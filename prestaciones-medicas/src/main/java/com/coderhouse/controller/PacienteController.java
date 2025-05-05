package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.coderhouse.dto.RegistroDePacienteDTO;
import com.coderhouse.models.Paciente;

import com.coderhouse.service.PacienteService;

@RestController
@RequestMapping("/api/pacientes")

public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping(path = {"/", ""})
	public ResponseEntity<List<Paciente>> getAllPacientes() {
		try {
			  List<Paciente> pacientes = pacienteService.findAll(); 
				  return ResponseEntity.ok(pacientes); // 200
			  } catch (Exception err) {
				  return ResponseEntity.internalServerError().build(); //500
			  }
				  
		
	}
	
	@GetMapping("/{pacienteId}")
	public ResponseEntity<?> getPacienteById(@PathVariable Long pacienteId){
		
		try {
			  
			Paciente paciente = pacienteService.findById(pacienteId);
			return ResponseEntity.ok(paciente); // 200
		} catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); //404
		}catch(Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarPaciente(@RequestBody RegistroDePacienteDTO dto) {
		try {
			Paciente pacienteCreado = pacienteService.registrarPacienteAPracticas(dto);
			return ResponseEntity.ok(pacienteCreado); //201
			
		}catch (IllegalStateException err) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(err.getMessage()); //409
			
		}catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); //404
		}catch (Exception err) {
			return ResponseEntity.internalServerError().build(); //500
		}
	}
	
	@PutMapping("/{pacienteId}")
	public ResponseEntity<?> updatePacienteById(@PathVariable Long pacienteId,@RequestBody Paciente pacienteActualizado){
		
		if(pacienteId == null) {
			return ResponseEntity.badRequest().body("El ID del paciente no puiede ser null");
		}
		try {
			Paciente paciente = pacienteService.update(pacienteId, pacienteActualizado);
			return ResponseEntity.ok(paciente); // 200
			
		}catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); //404
	
	
		}catch (Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
		
		}
	

	}
	@DeleteMapping("/{pacienteId}")
	public ResponseEntity<Void> deletePacienteById(@PathVariable Long pacienteId) {
		
		try {
			pacienteService.deleteById(pacienteId); 
			return ResponseEntity.noContent().build(); // 204
		
		}catch (IllegalArgumentException err) {
			return ResponseEntity.notFound().build(); //404


		}catch (Exception err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
	
		}
	}


}

















