package com.gestion.web.model;

import javax.persistence.*;
import java.util.Date;

@Entity //classe persistante liée à une table dans la base de données !
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 360)
    private String message;
    private String titre;
    private Date date;

    @ManyToOne
    private Compte compte;

    private boolean valide;


    public Reclamation(){super();}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String tire) {
        this.titre = tire;
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

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }



    @Override
    public String toString() {
        return "Reclamation{" +
                "message='" + message + '\'' +
                ", titre='" + titre + '\'' +
                ", date=" + date +
                ", compte=" + compte +
                ", valide=" + valide +
                '}';
    }
}
