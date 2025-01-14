package edu.badpals;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Calle {
    @Column(name = "via")
    private String via;
    @Column(name = "cp")
    private String cp;

    public Calle(String via, String cp) {
        this.via = via;
        this.cp = cp;
    }

    public Calle() {

    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
}