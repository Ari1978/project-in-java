package com.coderhouse.models;

import java.time.LocalDateTime;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
=======
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
>>>>>>> cbe5526 ("Commit inicial")
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
<<<<<<< HEAD
=======
import jakarta.persistence.OneToMany;
>>>>>>> cbe5526 ("Commit inicial")
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

<<<<<<< HEAD

=======
>>>>>>> cbe5526 ("Commit inicial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
<<<<<<< HEAD
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










=======
@Entity
@Schema(description = "Modelo de paciente")
@Table(name = "pacientes")  // Convención de nombres en minúsculas
public class Paciente {

    @Schema(description = "ID del paciente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @Schema(description = "Nombre del paciente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Matias")
    @Column(name = "nombre", nullable = false)  // Convención de nombres en minúsculas
    private String nombre;

    @Schema(description = "Apellido del paciente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Martinez")
    @Column(name = "apellido", nullable = false)  // Convención de nombres en minúsculas
    private String apellido;

    @Schema(description = "Número de documento del paciente", example = "33444555")
    @Column(name = "dni", nullable = false, unique = true)  // Convención de nombres en minúsculas
    private int dni;

    @Schema(description = "Edad del paciente", example = "28")
    @Column(name = "edad")
    private int edad;

    @Schema(description = "Sexo del paciente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Femenino o Masculino")
    @Column(name = "sexo")
    private String sexo;

    @Schema(description = "Número de teléfono del paciente", example = "8887485")
    @Column(name = "telefono", nullable = false, unique = true)  // Convención de nombres en minúsculas
    private int telefono;  // Cambio a String para permitir números largos o con ceros a la izquierda

    @Schema(description = "Cobertura médica del paciente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Osde")
    @Column(name = "cobertura")
    private String cobertura;

    @Schema(description = "Lista de turnos asignados al paciente")
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Turno> turnos;

    @Schema(description = "Lista de prácticas asignadas al paciente")
    @ManyToMany(mappedBy = "pacientes")
    @JsonIgnore
    private List<Practica> practicas;

    @Schema(description = "Muestra la hora y fecha del registro del paciente")
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // Constructor con parámetros
    public Paciente(String nombre, String apellido, int dni, int edad, String sexo, int i, String cobertura) {
       
    	this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.telefono = i;
        this.cobertura = cobertura;
    }
}
>>>>>>> cbe5526 ("Commit inicial")
