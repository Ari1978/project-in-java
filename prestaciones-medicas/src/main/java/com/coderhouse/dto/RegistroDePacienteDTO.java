package com.coderhouse.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroDePacienteDTO {
	
	private Long pacienteId;
	
	private List<Long> practicaIds;

}
