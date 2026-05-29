package com.parking.infrastructure.persistence.repository.sql.jpa;

import com.parking.infrastructure.persistence.repository.sql.jpa.entity.CellJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CellJPARepository extends JpaRepository<CellJPAEntity, UUID> {

	@Query("""
		    SELECT c FROM CellJPAEntity c
		    WHERE c.active = true
		    AND c.id NOT IN (
		        SELECT cv.cell.id
		        FROM CellVehicleJPAEntity cv
		        INNER JOIN TicketJPAEntity t ON t.cellVehicle.id = cv.id
		        WHERE TRIM(UPPER(t.ticketStatus.name)) = 'ABIERTO'
		    )
		    ORDER BY c.name
		    """)
		List<CellJPAEntity> findAvailableCells();
}