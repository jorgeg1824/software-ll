package com.parking.features.vehicle.addvehicle.application.usecase.impl;

import com.parking.crosscuting.exception.BusinessException;
import com.parking.crosscuting.messagescatalog.MessagesEnum;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleResponseDTO;
import com.parking.features.vehicle.addvehicle.application.usecase.AddVehicleUseCase;
import com.parking.features.vehicle.addvehicle.application.usecase.domain.AddVehicleDomain;
import com.parking.features.vehicle.addvehicle.application.usecase.mapper.AddVehicleEntityMapper;
import com.parking.infrastructure.persistence.repository.CellRepository;
import com.parking.infrastructure.persistence.repository.CellVehicleRepository;
import com.parking.infrastructure.persistence.repository.TicketRepository;
import com.parking.infrastructure.persistence.repository.VehicleRepository;
import com.parking.infrastructure.persistence.repository.entity.CellEntity;
import com.parking.infrastructure.persistence.repository.entity.CellVehicleEntity;
import com.parking.infrastructure.persistence.repository.entity.TicketEntity;
import com.parking.infrastructure.persistence.repository.entity.VehicleEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddVehicleUseCaseImpl implements AddVehicleUseCase {

    private final TicketRepository ticketRepository;
    private final VehicleRepository vehicleRepository;
    private final CellRepository cellRepository;
    private final CellVehicleRepository cellVehicleRepository;
    private final AddVehicleEntityMapper mapper;

    public AddVehicleUseCaseImpl(
            final TicketRepository ticketRepository,
            final VehicleRepository vehicleRepository,
            final CellRepository cellRepository,
            final CellVehicleRepository cellVehicleRepository,
            final AddVehicleEntityMapper mapper) {

        if (ticketRepository == null)
            throw new BusinessException(MessagesEnum.VEHICLE_USECASE_REPOSITORY_NULL);
        if (mapper == null)
            throw new BusinessException(MessagesEnum.VEHICLE_USECASE_MAPPER_NULL);

        this.ticketRepository = ticketRepository;
        this.vehicleRepository = vehicleRepository;
        this.cellRepository = cellRepository;
        this.cellVehicleRepository = cellVehicleRepository;
        this.mapper = mapper;
    }

    @Override
    public AddVehicleResponseDTO execute(final AddVehicleDomain data) {

        validateDataNotNull(data);

        UUID vehicleId = findOrCreateVehicle(data);

        validateCellExists(data.getCellId());
        validateVehicleNotAlreadyInside(vehicleId);
        validateCellAvailable(data.getCellId());

        CellVehicleEntity cellVehicle = mapper.toCellVehicleEntity(data, vehicleId);
        CellVehicleEntity savedCellVehicle = cellVehicleRepository.save(cellVehicle);

        TicketEntity ticket = mapper.toTicketEntity(data, savedCellVehicle);
        ticketRepository.create(ticket);

        return buildResponse(ticket, savedCellVehicle);
    }

    private void validateDataNotNull(final AddVehicleDomain data) {
        if (data == null)
            throw new BusinessException(MessagesEnum.VEHICLE_USECASE_NULL_DATA);
    }

    private UUID findOrCreateVehicle(final AddVehicleDomain data) {
        return vehicleRepository
                .findByLicensePlate(data.getLicensePlate())
                .map(VehicleEntity::getId)
                .orElseGet(() -> {
                    VehicleEntity newVehicle = new VehicleEntity();
                    newVehicle.setLicensePlate(data.getLicensePlate());
                    newVehicle.setVehicleTypeId(data.getVehicleTypeId());
                    return vehicleRepository.save(newVehicle).getId();
                });
    }

    private void validateCellExists(final UUID cellId) {
        CellEntity cell = cellRepository.findById(cellId);
        if (cell == null)
            throw new BusinessException(MessagesEnum.VEHICLE_USECASE_CELL_NOT_FOUND);
    }

    private void validateCellAvailable(final UUID cellId) {
        if (ticketRepository.hasOpenTicketByCellId(cellId))
            throw new BusinessException(MessagesEnum.VEHICLE_USECASE_CELL_UNAVAILABLE);
    }

    private void validateVehicleNotAlreadyInside(final UUID vehicleId) {
        if (ticketRepository.hasOpenTicketByVehicleId(vehicleId))
            throw new BusinessException(MessagesEnum.VEHICLE_USECASE_ALREADY_INSIDE);
    }

    private AddVehicleResponseDTO buildResponse(final TicketEntity ticket,
                                                 final CellVehicleEntity cellVehicle) {
        return new AddVehicleResponseDTO(
                ticket.getId(),
                ticket.getTicketNumber(),
                ticket.getEntryDate(),
                cellVehicle.getId(),
                ticket.getTicketStatus().getId()
        );
    }
}