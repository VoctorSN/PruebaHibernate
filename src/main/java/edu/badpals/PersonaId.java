package edu.badpals;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonaId implements Serializable {

    @Column(nullable = false)
    private int primeraParteId;
    @Column(nullable = false)
    private int segundaParteId;

    public int getPrimeraParteId() {
        return primeraParteId;
    }

    public int getSegundaParteId() {
        return segundaParteId;
    }

    public PersonaId(int primeraParteId, int segundaParteId){
        this.primeraParteId = primeraParteId;
        this.segundaParteId = segundaParteId;
    }

    public PersonaId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonaId entity = (PersonaId) o;
        return Objects.equals(this.segundaParteId, entity.segundaParteId) &&
                Objects.equals(this.primeraParteId, entity.primeraParteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segundaParteId, primeraParteId);
    }
}