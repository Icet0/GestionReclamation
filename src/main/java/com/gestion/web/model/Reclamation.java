package com.gestion.web.model;

import javax.persistence.*;
import java.util.Date;

@Entity //classe persistante liée à une table dans la base de données !
public class Reclamation {
    @Id
    @Column(length = 60)
    private String message;
    private String tire;
    private Date date;

    @ManyToOne
    private Compte compte;


    public Reclamation(){super();}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "message='" + message + '\'' +
                ", tire='" + tire + '\'' +
                ", date=" + date +
                ", compte=" + compte +
                '}';
    }
}
