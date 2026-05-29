package com.parking.features.vehicle.addvehicle.application.inputport;

import com.parking.application.inputport.InputPort;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;
import com.parking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleResponseDTO;

public interface AddVehicleInputPort extends InputPort<AddVehicleDTO, AddVehicleResponseDTO> {
    AddVehicleResponseDTO execute(AddVehicleDTO data);
}