package com.gestion.web.service;

import com.gestion.web.model.Reclamation;
import com.gestion.web.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

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

    public void validerReclamation(String id){
        Reclamation r = this.reclamationRepository.getById(id);
        r.setValide(!r.isValide());
        this.reclamationRepository.save(r);
    }
    public List<Reclamation> getReclamationCompte(String login){
        return reclamationRepository.findByCompte_Login(login);
    }
}