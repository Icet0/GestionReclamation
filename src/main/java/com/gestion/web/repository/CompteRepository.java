package com.gestion.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion.web.model.Compte;


//Spring data Jpa
//Couche qui gère toutes les données de l'application !!

@Repository
public interface CompteRepository extends JpaRepository<Compte, String>{
//....
	public List<Compte> getByMp(String mp);
	//Requête SQL
	//select * from compte;
	//Réecriture en JPQL Java Persistence Query Language.
	@Query("select c from Compte c")
	public List<Compte> getTousLesComptes();

}
