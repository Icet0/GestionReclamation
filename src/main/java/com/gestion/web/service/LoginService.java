package com.gestion.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.web.model.Compte;
import com.gestion.web.repository.CompteRepository;

@Service
public class LoginService {
	@Autowired
	CompteRepository compteRepository;
	
	//partie contenant le métiers de l'application/
	//Business Logic
	public boolean verifierAuthentif(String login, String motPasse) {
		List<Compte> comptes = getComptes(motPasse);
		for(Compte c :comptes){
			if(motPasse.equals(c.getMp())){
				return true;
			}
		}
		return false;
	}
	public void creerCompte(Compte c) {
		compteRepository.save(c);
	}
	//récuperr la liste des comptes
	public List<Compte> getComptes(){
		//return compteRepository.findAll();
		return compteRepository.getTousLesComptes();
	}
	public Compte getCompte(String login) {
		return compteRepository.getById(login);
	}
	public List<Compte> getComptes(String mp){
		return compteRepository.getByMp(mp);
	}

}
