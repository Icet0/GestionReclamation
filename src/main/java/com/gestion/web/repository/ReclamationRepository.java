package com.gestion.web.repository;

import com.gestion.web.model.Compte;
import com.gestion.web.model.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, String> {
    List<Reclamation> findByCompte_Login(String login);

    public Reclamation getReclamationByCompte(Compte compte);
    public Reclamation getReclamationByMessage(String message);
    public Reclamation getReclamationByTitre(String titre);
    public Reclamation getReclamationByDate(Date date);

    public Reclamation getReclamationByValide(boolean valide);

    public Reclamation getById(int id);

    @Override
    List<Reclamation> findAll();
}