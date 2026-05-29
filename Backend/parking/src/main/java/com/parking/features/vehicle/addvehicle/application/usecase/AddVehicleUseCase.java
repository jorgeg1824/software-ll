package com.parking.features.vehicle.addvehicle.application.usecase;

import com.parking.application.usecase.UseCase;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleResponseDTO;
import com.parking.features.vehicle.addvehicle.application.usecase.domain.AddVehicleDomain;

public interface AddVehicleUseCase
        extends UseCase<AddVehicleDomain, AddVehicleResponseDTO> {

}