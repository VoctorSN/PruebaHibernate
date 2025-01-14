package edu.badpals;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_persona", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "via", column = @Column(name = "calle")),
            @AttributeOverride(name = "cp", column = @Column(name = "codigo_postal"))
    })
    private Calle calle;

    @ElementCollection
    @CollectionTable(name = "telefonos",
            joinColumns = @JoinColumn(name = "id",
                    foreignKey = @ForeignKey(name = "fk_telefono_persona")),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id", "telefono"},
                    name = "id_telefonos_uniq"))
    @Column(name = "telefono", length = 15, nullable = false)
    @OrderColumn(name = "telefonos", nullable = false, columnDefinition = "NUMERIC(2)")
    List<String> telefonos = new ArrayList<>();
    ;

    @ElementCollection
    @AttributeOverrides({
            @AttributeOverride(name = "email", column = @Column(name = "email", length = 320))
    })
    @CollectionTable(name = "persona_emails",
            joinColumns = @JoinColumn(name = "id",
                    foreignKey = @ForeignKey(name = "fk_id_email")),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id", "email"},
                    name = "fk_id_email"))
    @OrderColumn(name = "emails", nullable = false, columnDefinition = "numeric(2)")
    private List<Email> emails = new ArrayList<>();
    ;

    public Persona(int id, Calle calle, List<String> telefonos, List<Email> emails) {
        this.id = id;
        this.calle = calle;
        this.telefonos = telefonos;
        this.emails = emails;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calle getCalle() {
        return calle;
    }

    public void setCalle(Calle calle) {
        this.calle = calle;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}