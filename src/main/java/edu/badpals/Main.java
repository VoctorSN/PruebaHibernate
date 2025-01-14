package edu.badpals;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Crear objetos de las clases utilizando los constructores
        PersonaId personaId = new PersonaId(1, 2);
        Calle calle = new Calle("Calle Falsa 123", "12345");
        Email email1 = new Email("juan.perez@example.com");
        Email email2 = new Email("jperez@work.com");
        Persona persona = new Persona();
        persona.setId(1);
        persona.setCalle(calle);
        persona.setTelefonos(Arrays.asList("123456789", "987654321"));
        persona.setEmails(Arrays.asList(email1, email2));

        Alumno alumno = new Alumno("Jane Doe");

        Profesor profesor = new Profesor("Dr. Smith");
        profesor.setId(2);
        profesor.setCalle(calle);
        profesor.setTelefonos(Arrays.asList("123456789", "987654321"));
        profesor.setEmails(Arrays.asList(email1, email2));
        profesor.setTutorizados(List.of(alumno));
        profesor.setAlumnos(List.of(alumno));

        alumno.setId(3);
        alumno.setCalle(calle);
        alumno.setTelefonos(Arrays.asList("123456789", "987654321"));
        alumno.setEmails(Arrays.asList(email1, email2));
        alumno.setProfesor(profesor);
        alumno.setProfesores(List.of(profesor));

        // Persistir los objetos en la base de datos
        em.persist(persona);
        em.persist(profesor);
        em.persist(alumno);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}