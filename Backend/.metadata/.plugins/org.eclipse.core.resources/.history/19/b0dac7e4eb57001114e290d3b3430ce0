package com.parking.infrastructure.persistence.repository.adapter.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.VehicleJPARepository;
import com.parking.infrastructure.persistence.repository.sql.jpa.VehicleTypeJPARepository;
import com.parking.infrastructure.rest.dto.VehicleInfoResponse;
import com.parking.infrastructure.rest.dto.VehicleTypeInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VehicleQueryService {

    private final VehicleJPARepository vehicleRepository;
    private final VehicleTypeJPARepository vehicleTypeRepository;

    public VehicleQueryService(final VehicleJPARepository vehicleRepository,
                                final VehicleTypeJPARepository vehicleTypeRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public Optional<VehicleInfoResponse> findByLicensePlate(final String plate) {
        return vehicleRepository.findByLicensePlate(plate.toUpperCase().trim())
                .map(v -> new VehicleInfoResponse(
                        v.getId(),
                        v.getLicensePlate(),
                        v.getVehicleType() != null ? v.getVehicleType().getId()   : null,
                        v.getVehicleType() != null ? v.getVehicleType().getName() : "N/A"
                ));
    }

    public List<VehicleTypeInfoResponse> findAllVehicleTypes() {
        return vehicleTypeRepository.findAll()
                .stream()
                .filter(vt -> Boolean.TRUE.equals(vt.isActive()))
                .map(vt -> new VehicleTypeInfoResponse(vt.getId(), vt.getName()))
                .toList();
    }
}