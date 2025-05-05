package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity 
@Table(name = "Pacientes")
@EntityListeners(AuditingEntityListener.class)

public class Paciente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "Nombre", nullable = false)
		private String nombre;
		
		@Column(name = "Apellido", nullable = false)
		private String apellido;
		
		@Column(name = "DNI", nullable = false, unique = true)
		private int dni;
		
		@Column(name = "Edad")
		private int edad;
		
		@Column(name = "Sexo")
		private String sexo;
		
		@Column(name = "Telefono", nullable = false, unique = true)
		private int telefono;
		
		@Column(name = "Cobertura")
		private String cobertura;
		
		@ManyToMany(mappedBy = "pacientes", fetch = FetchType.EAGER)
		@JsonIgnore
		private List<Practica> practicas = new ArrayList<>();
		
		@CreatedDate
		@Column(updatable = false)
		private LocalDateTime createdAt; 
	
		
		public Paciente(String nombre, String apellido, int dni, int edad, String sexo, int telefono, String cobertura) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.edad = edad;
			this.sexo = sexo;
			this.telefono = telefono;
			this.cobertura = cobertura;
	}


}










