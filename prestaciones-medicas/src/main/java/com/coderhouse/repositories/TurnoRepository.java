package com.coderhouse.repositories;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coderhouse.models.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    int countByFecha(LocalDate fecha);
}
