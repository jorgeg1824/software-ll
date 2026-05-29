package com.parking.infrastructure.rest.mapper;

import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleResponseDTO;
import com.parking.infrastructure.rest.dto.AddVehicleRequest;
import com.parking.infrastructure.rest.dto.AddVehicleResponse;
import org.springframework.stereotype.Component;

@Component
public class AddVehicleRestMapper {

    public AddVehicleDTO toDTO(final AddVehicleRequest request) {
        return new AddVehicleDTO(
            null,
            request.getTicketNumber(),
            request.getEntryDate(),
            request.getLicensePlate(),    
            request.getVehicleTypeId(),    
            request.getCellId(),
            request.getTicketStatus()
        );
    }

    public AddVehicleResponse toResponse(final AddVehicleResponseDTO result) {
        return new AddVehicleResponse(
            result.getId(),
            result.getTicketNumber(),
            result.getEntryDate(),
            result.getCellVehicle()
        );
    }
}