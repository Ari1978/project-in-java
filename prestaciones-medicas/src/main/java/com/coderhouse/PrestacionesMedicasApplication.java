package com.coderhouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
=======
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;
>>>>>>> cbe5526 ("Commit inicial")

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Paciente;
import com.coderhouse.models.Practica;
<<<<<<< HEAD

@EnableJpaAuditing
@SpringBootApplication
public class PrestacionesMedicasApplication implements CommandLineRunner {

    @Autowired
    private DaoFactory dao;
=======
import com.coderhouse.models.Turno;

@EnableJpaAuditing
@SpringBootApplication


public class PrestacionesMedicasApplication implements CommandLineRunner {

    @Autowired
    private DaoFactory dao; // Asegúrate de que DaoFactory esté inyectado correctamente
>>>>>>> cbe5526 ("Commit inicial")

    public static void main(String[] args) {
        SpringApplication.run(PrestacionesMedicasApplication.class, args);
    }

<<<<<<< HEAD
    @Override
    public void run(String... args) throws Exception {

        try {
=======
    @Bean 
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            // Inicialización de las categorías
>>>>>>> cbe5526 ("Commit inicial")
            Categoria categoria1 = new Categoria("Laboratorio");
            Categoria categoria2 = new Categoria("Estudios por imagenes");
            Categoria categoria3 = new Categoria("Estudios complementarios");

<<<<<<< HEAD
=======
            // Inicialización de las prácticas
>>>>>>> cbe5526 ("Commit inicial")
            Practica practica1 = new Practica("Electrocardiograma", "Registro eléctrico del corazón", 3500.0, new ArrayList<>(), categoria2);
            Practica practica2 = new Practica("Análisis de orina", "Análisis clínico de orina", 1800.0, new ArrayList<>(), categoria1);
            Practica practica3 = new Practica("Análisis de sangre", "Estudio de sangre completo", 2500.0, new ArrayList<>(), categoria1);
            Practica practica4 = new Practica("Radiografías", "Imágenes por rayos X", 4000.0, new ArrayList<>(), categoria2);
            Practica practica5 = new Practica("Audiometría", "Medición de la audición", 2000.0, new ArrayList<>(), categoria3);
            Practica practica6 = new Practica("Tomografía", "Imagen médica por secciones", 8000.0, new ArrayList<>(), categoria2);
            Practica practica7 = new Practica("Electroencefalograma", "Actividad cerebral", 4500.0, new ArrayList<>(), categoria3);
            Practica practica8 = new Practica("Ecografía", "Imagen con ultrasonido", 3200.0, new ArrayList<>(), categoria2);
            Practica practica9 = new Practica("Resonancia magnética", "Imágenes por campos magnéticos", 9000.0, new ArrayList<>(), categoria2);
            Practica practica10 = new Practica("Endoscopia", "Visualización del interior del cuerpo", 5000.0, new ArrayList<>(), categoria2);

<<<<<<< HEAD
=======
            // Inicialización de los pacientes
>>>>>>> cbe5526 ("Commit inicial")
            Paciente paciente1 = new Paciente("Carlos", "Lopez", 34550623, 35, "Masculino", 1156989325, "Swiss Medical");
            Paciente paciente2 = new Paciente("Pedro", "Juarez", 32557628, 33, "Masculino", 1133989329, "Medife");
            Paciente paciente3 = new Paciente("Gabriela", "Mangioni", 30444623, 29, "Femenino", 1144882233, "Galeno");
            Paciente paciente4 = new Paciente("Carla", "Gomez", 26555623, 46, "Femenino", 1169993332, "Osde");
            Paciente paciente5 = new Paciente("Federico", "Mazur", 44555623, 22, "Masculino", 1168775523, "Sancor Salud");
            Paciente paciente6 = new Paciente("Lorena", "Ferreyra", 24555623, 48, "Femenino", 1133311125, "Premedic");
            Paciente paciente7 = new Paciente("Mariano", "Arguello", 34111212, 35, "Masculino", 1198522559, "Medical");
            Paciente paciente8 = new Paciente("Marcelo", "Rodriguez", 29595999, 41, "Masculino", 1121218932, "Medife");
            Paciente paciente9 = new Paciente("Abigail", "Gutierrez", 383333623, 30, "Femenino", 1148852361, "Galeno");
            Paciente paciente10 = new Paciente("Facundo", "Soto", 34666878, 35, "Masculino", 1152643289, "Swiss Medical");
            Paciente paciente11 = new Paciente("Juan", "Lopez", 31222653, 32, "Masculino", 1166332458, "Premedic");

<<<<<<< HEAD
=======
            // Inicialización de los turnos
            Turno turno1 = new Turno();
            turno1.setPaciente(paciente1);
            turno1.setPractica(practica5);
            //turno1.setFecha("2025-04-25 17:01:25");
            
            Turno turno2 = new Turno();
            turno2.setPaciente(paciente2);
            turno2.setPractica(practica4);
            //turno2.setFecha("2025-03-18 11:10:25");
            
            Turno turno3 = new Turno();
            turno3.setPaciente(paciente3);
            turno3.setPractica(practica2);
            //turno3.setFecha("2025-01-11 10:22:18");
            
            Turno turno4 = new Turno();
            turno4.setPaciente(paciente4);
            turno4.setPractica(practica8);
            //turno4.setFecha("2025-02-02 14:18:25");
            
            Turno turno5 = new Turno();
            turno5.setPaciente(paciente5);
            turno5.setPractica(practica5);
            //turno5.setFecha("2025-03-16 09:30:00");

            // Persistir datos en la base de datos
            dao.persistirTurno(turno1);
            dao.persistirTurno(turno2);
            dao.persistirTurno(turno3);
            dao.persistirTurno(turno4);
            dao.persistirTurno(turno5);

            // Persistir categorías
>>>>>>> cbe5526 ("Commit inicial")
            dao.persistirCategoria(categoria1);
            dao.persistirCategoria(categoria2);
            dao.persistirCategoria(categoria3);

<<<<<<< HEAD
=======
            // Persistir prácticas
>>>>>>> cbe5526 ("Commit inicial")
            dao.persistirPractica(practica1);
            dao.persistirPractica(practica2);
            dao.persistirPractica(practica3);
            dao.persistirPractica(practica4);
            dao.persistirPractica(practica5);
            dao.persistirPractica(practica6);
            dao.persistirPractica(practica7);
            dao.persistirPractica(practica8);
            dao.persistirPractica(practica9);
            dao.persistirPractica(practica10);

<<<<<<< HEAD
=======
            // Persistir pacientes
>>>>>>> cbe5526 ("Commit inicial")
            dao.persistirPaciente(paciente1);
            dao.persistirPaciente(paciente2);
            dao.persistirPaciente(paciente3);
            dao.persistirPaciente(paciente4);
            dao.persistirPaciente(paciente5);
            dao.persistirPaciente(paciente6);
            dao.persistirPaciente(paciente7);
            dao.persistirPaciente(paciente8);
            dao.persistirPaciente(paciente9);
            dao.persistirPaciente(paciente10);
            dao.persistirPaciente(paciente11);

            // Asignar múltiples prácticas a un paciente
            List<Long> practicasParaPaciente2 = new ArrayList<>();
            if (practica1 != null) practicasParaPaciente2.add(practica1.getId());
            if (practica2 != null) practicasParaPaciente2.add(practica2.getId());
            if (practica3 != null) practicasParaPaciente2.add(practica3.getId());

            dao.asignarPacienteAPractica(paciente2.getId(), practicasParaPaciente2);

        } catch (Exception err) {
            System.out.println("Error al iniciar datos: " + err.getMessage());
        }
    }
}
