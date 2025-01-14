package edu.badpals;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumno")
@PrimaryKeyJoinColumn(name="id")
@DiscriminatorValue(value="1")
public class Alumno extends Persona {

    @Column(name = "asignaturaPreferida")
    private String asignaturaPreferida;

    @ManyToOne
    @JoinColumn(name="tutor", referencedColumnName = "id")
    private Profesor profesor;

    @ManyToMany
   @JoinTable(name = "profesores_alumnos",joinColumns =   @JoinColumn(name="id_al"),
   inverseJoinColumns = @JoinColumn(name="id_prof"))
   private List<Profesor> profesores = new ArrayList<>();;


    public Alumno(int idAl, Calle calle, List<String> telefonos, List<Email> emails, String asignaturaPreferida) {
        super(idAl, calle, telefonos, emails);
        this.asignaturaPreferida = asignaturaPreferida;
    }

    public Alumno() {

    }

    public Alumno(String asignaturaPreferida) {
        this.asignaturaPreferida = asignaturaPreferida;
    }

    public String getAsignaturaPreferida() {
        return asignaturaPreferida;
    }

    public void setAsignaturaPreferida(String asignaturaPreferida) {
        this.asignaturaPreferida = asignaturaPreferida;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}