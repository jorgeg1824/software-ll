package com.parking.infrastructure.persistence.repository.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.TicketJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketJPARepository extends JpaRepository<TicketJPAEntity, UUID> {

	@Query("""
		    SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END
		    FROM TicketJPAEntity t
		    WHERE t.cellVehicle.cell.id = :cellId
		    AND TRIM(UPPER(t.ticketStatus.name)) = 'ABIERTO'
		    """)
		boolean hasOpenTicketByCellId(@Param("cellId") UUID cellId);

		@Query("""
		    SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END
		    FROM TicketJPAEntity t
		    WHERE t.cellVehicle.vehicle.id = :vehicleId
		    AND TRIM(UPPER(t.ticketStatus.name)) = 'ABIERTO'
		    """)
		boolean hasOpenTicketByVehicleId(@Param("vehicleId") UUID vehicleId);
}