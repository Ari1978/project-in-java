package com.coderhouse.dao;

import java.util.List;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

import com.coderhouse.models.Paciente;
import com.coderhouse.models.Practica;
import com.coderhouse.models.Categoria;

=======
import org.springframework.stereotype.Repository;
>>>>>>> cbe5526 ("Commit inicial")
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

<<<<<<< HEAD
@Service
=======
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Paciente;
import com.coderhouse.models.Practica;
import com.coderhouse.models.Turno;

@Repository
>>>>>>> cbe5526 ("Commit inicial")
public class DaoFactory {

    @PersistenceContext
    private EntityManager em;

<<<<<<< HEAD
    // Persistir un Paciente
=======
>>>>>>> cbe5526 ("Commit inicial")
    @Transactional
    public void persistirPaciente(Paciente paciente) {
        em.persist(paciente);
    }

<<<<<<< HEAD
    // Persistir una Práctica
=======
>>>>>>> cbe5526 ("Commit inicial")
    @Transactional
    public void persistirPractica(Practica practica) {
        em.persist(practica);
    }

<<<<<<< HEAD
    // Persistir una Categoría
=======
>>>>>>> cbe5526 ("Commit inicial")
    @Transactional
    public void persistirCategoria(Categoria categoria) {
        em.persist(categoria);
    }

<<<<<<< HEAD
    // Obtener una Práctica por ID
    @Transactional
=======
    @Transactional
    public void persistirTurno(Turno turno) {
        // Verificar si el paciente existe
        Paciente paciente = em.find(Paciente.class, turno.getPaciente().getId());
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente con ID " + turno.getPaciente().getId() + " no existe.");
        }

        // Verificar si la práctica existe
        Practica practica = em.find(Practica.class, turno.getPractica().getId());
        if (practica == null) {
            throw new IllegalArgumentException("La práctica con ID " + turno.getPractica().getId() + " no existe.");
        }

        // Asignar paciente y practica al turno, ya que ambos existen
        turno.setPaciente(paciente);
        turno.setPractica(practica);

        // Persistir el turno
        em.persist(turno);
    

        // Asignar los objetos a turno
        turno.setPaciente(paciente);
        turno.setPractica(practica);

        // Persistir el turno
        em.persist(turno);
    }

    // -------------------- Getters por ID --------------------
>>>>>>> cbe5526 ("Commit inicial")
    public Practica getPracticaById(Long practicaId) throws Exception {
        try {
            TypedQuery<Practica> query = em.createQuery("SELECT p FROM Practica p WHERE p.id = :id", Practica.class);
            return query.setParameter("id", practicaId).getSingleResult();
        } catch (Exception e) {
<<<<<<< HEAD
            throw new Exception("La práctica con ID: " + practicaId + " no existe.");
        }
    }

    // Obtener una Categoría por ID
    @Transactional
=======
            throw new Exception("No se encontró la práctica con ID: " + practicaId);
        }
    }

>>>>>>> cbe5526 ("Commit inicial")
    public Categoria getCategoriaById(Long categoriaId) throws Exception {
        try {
            TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c WHERE c.id = :id", Categoria.class);
            return query.setParameter("id", categoriaId).getSingleResult();
        } catch (Exception e) {
<<<<<<< HEAD
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
=======
            throw new Exception("No se encontró la categoría con ID: " + categoriaId);
        }
    }

    public Paciente getPacienteById(Long pacienteId) throws Exception {
        try {
            TypedQuery<Paciente> query = em.createQuery("SELECT p FROM Paciente p WHERE p.id = :id", Paciente.class);
            return query.setParameter("id", pacienteId).getSingleResult();
        } catch (Exception e) {
            throw new Exception("No se encontró el paciente con ID: " + pacienteId);
        }
    }

	public void asignarPacienteAPractica(Long id, List<Long> practicasParaPaciente2) {
		// TODO Auto-generated method stub
		
	}
}
>>>>>>> cbe5526 ("Commit inicial")
