package com.coderhouse.models;



import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Practicas")


public class Practica {
    
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "Nombre", nullable = false) 

	    private String nombre;
	    
	    @Column(name = "Descripcion", nullable = false) 

	    private String descripcion;
	    
	    @Column(name = "Precio", nullable = false)
	    private Double precio;

	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	    		name = "paciente_practica",
	    	    joinColumns = @JoinColumn(name = "paciente_id"),
	    	    inverseJoinColumns = @JoinColumn(name = "practica_id")
	    )
	    
	    @JsonIgnore
	    private List<Paciente> pacientes = new ArrayList<>();

	    @ManyToOne(fetch = FetchType.EAGER)
	    private Categoria categoria;

	    public Practica(String nombre, String descripcion, Double precio, List<Paciente> pacientes, Categoria categoria) {
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	        this.precio = precio;
	        this.pacientes = pacientes;
	        this.categoria = categoria;
	    }

	    
	}
