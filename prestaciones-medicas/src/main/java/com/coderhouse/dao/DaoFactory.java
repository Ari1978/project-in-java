package com.coderhouse.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coderhouse.models.Paciente;
import com.coderhouse.models.Practica;
import com.coderhouse.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {

    @PersistenceContext
    private EntityManager em;

    // Persistir un Paciente
    @Transactional
    public void persistirPaciente(Paciente paciente) {
        em.persist(paciente);
    }

    // Persistir una Práctica
    @Transactional
    public void persistirPractica(Practica practica) {
        em.persist(practica);
    }

    // Persistir una Categoría
    @Transactional
    public void persistirCategoria(Categoria categoria) {
        em.persist(categoria);
    }

    // Obtener una Práctica por ID
    @Transactional
    public Practica getPracticaById(Long practicaId) throws Exception {
        try {
            TypedQuery<Practica> query = em.createQuery("SELECT p FROM Practica p WHERE p.id = :id", Practica.class);
            return query.setParameter("id", practicaId).getSingleResult();
        } catch (Exception e) {
            throw new Exception("La práctica con ID: " + practicaId + " no existe.");
        }
    }

    // Obtener una Categoría por ID
    @Transactional
    public Categoria getCategoriaById(Long categoriaId) throws Exception {
        try {
            TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c WHERE c.id = :id", Categoria.class);
            return query.setParameter("id", categoriaId).getSingleResult();
        } catch (Exception e) {
            throw new Exception("La categoría con ID: " + categoriaId + " no existe.");
        }
    }

    // Obtener un Paciente por ID
    @Transactional
    public Paciente getPacienteById(Long pacienteId) throws Exception {
        try {
            TypedQuery<Paciente> query = em.createQuery("SELECT pa FROM Paciente pa WHERE pa.id = :id", Paciente.class);
            return query.setParameter("id", pacienteId).getSingleResult();
        } catch (Exception e) {
            throw new Exception("El paciente con ID: " + pacienteId + " no existe.");
        }
    }

    // Asignar Categoría a una Práctica
    @Transactional
    public void asignarCategoriaAPractica(Long practicaId, Long categoriaId) throws Exception {
        Practica practica = getPracticaById(practicaId);
        Categoria categoria = getCategoriaById(categoriaId);

        if (practica == null) {
            throw new Exception("La práctica con ID: " + practicaId + " no existe.");
        }
        if (categoria == null) {
            throw new Exception("La categoría con ID: " + categoriaId + " no existe.");
        }

        // Asignamos la categoría a la práctica
        practica.setCategoria(categoria);

        
    }

    // Asignar Paciente a una Práctica
   
    @Transactional
    public void asignarPacienteAPractica(Long pacienteId, List<Long> practicaIds) throws Exception {
        
    	Paciente paciente = getPacienteById(pacienteId);
        if (paciente == null) {
            throw new Exception("El paciente con ID: " + pacienteId + " no existe.");
        }
        for (Long practicaId : practicaIds) {
        	Practica practica = getPracticaById(practicaId);
        	if (practica == null) {
        	throw new Exception("La práctica con ID: " + practicaId + " no existe.");
        }

        // Evitar duplicados, si la práctica ya está asignada al paciente
        
        if (!paciente.getPracticas().contains(practica)) {
            paciente.getPracticas().add(practica);
        }

        // Evitar duplicados, si el paciente ya está asignado a la práctica
        if (!practica.getPacientes().contains(paciente)) {
            practica.getPacientes().add(paciente);
        }

        // Persistir los cambios
        em.merge(paciente);
        em.merge(practica);
    }

	 
		
	}
}