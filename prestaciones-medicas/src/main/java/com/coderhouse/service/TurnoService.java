package com.coderhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.TurnoServiceInterface;
import com.coderhouse.models.Paciente;
import com.coderhouse.models.Turno;
import com.coderhouse.repositories.PacienteRepository;
import com.coderhouse.repositories.TurnoRepository;

import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@Service
public class TurnoService implements TurnoServiceInterface<Turno, Long> {

    private static final int topeDeTurnosPorDia = 10;
    
    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno findById(Long id) {
        return turnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
    }

    @Override
    public Turno save(Turno turno) {
        // Verificar si se ha alcanzado el tope de turnos para el día
        int cantidadDeTurnosHoy = turnoRepository.countByFecha(turno.getFecha());

        if (cantidadDeTurnosHoy >= topeDeTurnosPorDia) {
            throw new RuntimeException("Se alcanzó el tope de turnos para el día: " + turno.getFecha());
        }

        return turnoRepository.save(turno);
    }

    @Override
    public Turno update(Long id, Turno turno) {
        // Validar existencia
        if (!turnoRepository.existsById(id)) {
            throw new RuntimeException("Turno no encontrado");
        }
        turno.setId(id); // asegurar que use el ID correcto
        return turnoRepository.save(turno);
    }

    @Override
    public void deleteById(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return turnoRepository.existsById(id);
    }

    // Asignar turno a un paciente
    @Transactional
    public Turno asignarTurnoAPacienteDTO(Long pacienteId, Long turnoId) {
        // Obtener el paciente
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // Obtener el turno
        Turno turno = turnoRepository.findById(turnoId)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));

        // Asignar el paciente al turno
        turno.setPaciente(paciente);

        return turnoRepository.save(turno);
    }
}
