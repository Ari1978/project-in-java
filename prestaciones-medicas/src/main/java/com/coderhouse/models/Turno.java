package com.coderhouse.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private LocalTime hora;

    @ManyToOne
    private Paciente paciente; // El paciente es asignado en el turno

    @ManyToOne
    private Practica practica; // La práctica se asocia al turno

    private String estado;

    @Column(length = 500)
    private String observaciones;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // Constructor sin parámetros
    public Turno() {}

    // Constructor con parámetros
    
        
    

    // Setters personalizados si se necesita lógica adicional para la fecha
    public void setFecha(String fecha) {
        try {
            this.fecha = LocalDate.parse(fecha); // Convertir de String a LocalDate
        } catch (Exception e) {
            throw new IllegalArgumentException("Fecha no válida: " + fecha);
        }
    }

    public void setHora(String hora) {
        try {
            this.hora = LocalTime.parse(hora); // Convertir de String a LocalTime
        } catch (Exception e) {
            throw new IllegalArgumentException("Hora no válida: " + hora);
        }
    }

	public Turno(Long id, LocalDate fecha, LocalTime hora, Paciente paciente, Practica practica, String estado,
			String observaciones, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.paciente = paciente;
		this.practica = practica;
		this.estado = estado;
		this.observaciones = observaciones;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
