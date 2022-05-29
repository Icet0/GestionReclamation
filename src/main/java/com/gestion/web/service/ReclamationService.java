package com.gestion.web.service;

import com.gestion.web.model.Reclamation;
import com.gestion.web.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service

public class ReclamationService {

    @Autowired
    ReclamationRepository reclamationRepository;

//    CREER RECLAMATION ETC ETC

    public void creerReclamation(Reclamation r){
        this.reclamationRepository.save(r);
    }

    public List<Reclamation> getReclamations(){
        return this.reclamationRepository.findAll();
    }

    public void validerReclamation(int id){

        Reclamation r = this.reclamationRepository.getById(id);
        r.setValide(true);
        r.setTraiter(true);
        this.reclamationRepository.save(r);
    }

    public void refuserReclamation(int id){

        Reclamation r = this.reclamationRepository.getById(id);
        r.setValide(false);
        r.setTraiter(true);
        this.reclamationRepository.save(r);
    }
    public List<Reclamation> getReclamationCompte(String login){
        return reclamationRepository.findByCompte_Login(login);
    }
//
}