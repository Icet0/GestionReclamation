package com.gestion.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.web.model.Compte;
import com.gestion.web.model.Role;
import com.gestion.web.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping(value="/addrole/{intitule}")
	public ModelAndView addRole(@PathVariable String intitule) {
		//Ajout de role
		Role r = new Role();
		r.setIntitule(intitule);
		roleService.addRole(r);
		ModelAndView mv  = new ModelAndView();
		mv.addObject("role", r);
		mv.setViewName("role");
		return mv;
	}
	@GetMapping(value="/addCompteRole")
	public String showCompteRole() {
		return "compterole";
	}
	@PostMapping(value="/addCompteRole")
	public ModelAndView affecterCompteRole(@RequestParam String login,
			@RequestParam String mp, @RequestParam String intitule) {
		ModelAndView mv = new ModelAndView();
		Compte c = new Compte();c.setLogin(login);c.setMp(mp);
		Role r = new Role();r.setIntitule(intitule);
		
		roleService.affecteCompteARole(c, r);
		
		mv.addObject("role1", roleService.getComptesParRole(intitule));
		mv.addObject("compte1",c);
		mv.addObject("listeNbreCompte", roleService.getNombreComptesParRole());
		//Recuperer le nombre de comptes par role
		for(Object[] o : roleService.getNombreComptesParRole()) {
			System.out.println("Intitule :"+o[0]);
			System.out.println("Nombre de comptes :"+o[1]);
		}
		mv.setViewName("lesComptes");
		return mv;
	}
	
	
	
	
}
