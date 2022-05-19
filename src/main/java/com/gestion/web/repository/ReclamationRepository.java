package com.gestion.web.repository;

import com.gestion.web.model.Compte;
import com.gestion.web.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation, String> {

    public Reclamation getReclamationByCompte();
    public Reclamation getReclamationByMessage();
    public Reclamation getReclamationByTire();
    public Reclamation getReclamationByDate();
}
