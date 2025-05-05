package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coderhouse.dto.AsignacionDeTurnoAPacienteDTO;
import com.coderhouse.models.Turno;
import com.coderhouse.service.TurnoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/a/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @Operation(summary = "Obtener la lista de los turnos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de Turnos obtenida correctamente"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping(path = {"/", ""})
    public ResponseEntity<List<Turno>> getAllTurnos() {
        try {
            List<Turno> turnos = turnoService.findAll();
            return ResponseEntity.ok(turnos); // 200
        } catch (Exception err) {
            return ResponseEntity.internalServerError().build(); // 500
        }
    }

    @Operation(summary = "Obtener un turno por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Turno obtenida correctamente"),
        @ApiResponse(responseCode = "404", description = "Turno no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{turnoId}")
    public ResponseEntity<?> getTurnoById(@PathVariable Long turnoId) {
        try {
            Turno turno = turnoService.findById(turnoId);
            return ResponseEntity.ok(turno); // 200
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turno no encontrado"); // 404
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor"); // 500
        }
    }

    @Operation(summary = "Registrar un nuevo turno a un paciente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Turno registrado correctamente"),
        @ApiResponse(responseCode = "400", description = "Error al registrar el turno"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/asignar-turno")
    public ResponseEntity<?> asignarTurnoAPaciente(@RequestBody AsignacionDeTurnoAPacienteDTO dto) {
        if (dto.getTurnoId() == null) {
            return ResponseEntity.badRequest().body("El ID del turno no puede ser null");
        }
        if (dto.getPacienteId() == null) {
            return ResponseEntity.badRequest().body("El ID del Paciente no puede ser null");
        }
        try {
            Turno turnoActualizado = turnoService.asignarTurnoAPacienteDTO(dto.getPacienteId(), dto.getTurnoId());
            return ResponseEntity.ok(turnoActualizado); // 201
        } catch (RuntimeException err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage()); // 400
        } catch (Exception err) {
            return ResponseEntity.internalServerError().build(); // 500
        }
    }

    @Operation(summary = "Editar un turno por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Turno editado correctamente"),
        @ApiResponse(responseCode = "404", description = "Turno no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{turnoId}")
    public ResponseEntity<?> updateTurnoById(@PathVariable Long turnoId, @RequestBody Turno turnoActualizado) {
        try {
            Turno turno = turnoService.update(turnoId, turnoActualizado);
            return ResponseEntity.ok(turno); // 200
        } catch (RuntimeException err) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turno no encontrado"); // 404
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @Operation(summary = "Eliminar un turno por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Turno eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Turno no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{turnoId}")
    public ResponseEntity<?> deleteTurnoById(@PathVariable Long turnoId) {
        try {
            turnoService.deleteById(turnoId);
            return ResponseEntity.noContent().build(); // 204
        } catch (RuntimeException err) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turno no encontrado"); // 404
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
}
