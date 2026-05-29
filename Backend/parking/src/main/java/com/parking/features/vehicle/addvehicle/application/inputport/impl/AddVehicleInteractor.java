package com.parking.features.vehicle.addvehicle.application.inputport.impl;

import com.parking.features.vehicle.addvehicle.application.inputport.AddVehicleInputPort;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleResponseDTO;
import com.parking.features.vehicle.addvehicle.application.usecase.AddVehicleUseCase;
import com.parking.features.vehicle.addvehicle.application.usecase.domain.AddVehicleDomain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AddVehicleInteractor implements AddVehicleInputPort {

    private final AddVehicleUseCase useCase;

    public AddVehicleInteractor(final AddVehicleUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public AddVehicleResponseDTO execute(final AddVehicleDTO data) {
        AddVehicleDomain domain = new AddVehicleDomain(
                data.getId(),
                data.getTicketNumber(),
                data.getEntryDate(),
                data.getLicensePlate(),      
                data.getVehicleTypeId(),        
                data.getCellId(),
                data.getTicketStatus()
        );
        return useCase.execute(domain);
    }
}