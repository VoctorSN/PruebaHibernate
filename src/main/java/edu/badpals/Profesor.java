package edu.badpals;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesor")
@PrimaryKeyJoinColumn(name="id")
@DiscriminatorValue(value="2")
public class Profesor extends Persona {


    @Column(name = "alumnaPreferida")
    private String alumnaPreferida;

   @OneToMany(mappedBy = "profesor")
   private List<Alumno> tutorizados = new ArrayList<>();;

   @ManyToMany(mappedBy = "profesores")
   private List<Alumno> alumnos = new ArrayList<>();;

    public Profesor(int idPr, Calle calle, List<String> telefonos, List<Email> emails) {
        super(idPr, calle, telefonos, emails);
    }

    public Profesor(int idPr, Calle calle, List<String> telefonos, List<Email> emails, String alumnaPreferida) {
        super(idPr, calle, telefonos, emails);
        this.alumnaPreferida = alumnaPreferida;
    }

    public Profesor() {
    }

    public Profesor(String alumnaPreferida) {
        this.alumnaPreferida = alumnaPreferida;
    }

    public List<Alumno> getTutorizados() {
        return tutorizados;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void setTutorizados(List<Alumno> tutorizados) {
        this.tutorizados = tutorizados;
    }

    public String getAlumnaPreferida() {
        return alumnaPreferida;
    }

    public void setAlumnaPreferida(String alumnaPreferida) {
        this.alumnaPreferida = alumnaPreferida;
    }
}