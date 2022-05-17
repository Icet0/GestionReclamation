package com.gestion.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.web.model.Compte;
import com.gestion.web.model.Role;
import com.gestion.web.repository.CompteRepository;
import com.gestion.web.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	public void addRole(Role role) {
		roleRepository.save(role);
	}
	public void affecteCompteARole(Compte compte, Role role) {
		//existance du role
		System.out.println(roleRepository.getByIntitule(role.getIntitule()));
		if (roleRepository.getByIntitule(role.getIntitule()) == null) {
			roleRepository.save(role);
		}
		//Certitude de son existance. Il est dans la base
		//On le recupere encore une fois est l'on associe au compte
		compte.setRole(roleRepository.getByIntitule(role.getIntitule()));
		compteRepository.save(compte);
	}
	public List<Compte> getComptesParRole(String intitule){
		return roleRepository.getCompteByRole(intitule);
	}
	public List<Object[]> getNombreComptesParRole(){
		return roleRepository.getNombreComptesParRole();
	}
}
