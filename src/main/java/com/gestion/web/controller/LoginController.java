package com.gestion.web.controller;

import com.gestion.web.model.Privilege;
import com.gestion.web.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.web.model.Compte;
import com.gestion.web.model.Role;
import com.gestion.web.service.LoginService;
import com.gestion.web.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@Autowired
	RoleService roleService;

	@Autowired
	ReclamationService reclamationService;

	
	//affichage de la page login.jsp
	@GetMapping(value = "/")
	public String home(){
		return "home";
	}




	@GetMapping(value = "/login")
	public String showLogin() {
		return "login"; //il va appeler la page login.jsp !
	}

	@PostMapping(value="/login")
	public ModelAndView verifierLogin(@RequestParam String login,
			                        @RequestParam String mp ) {
		ModelAndView model = new ModelAndView();
		if (loginService.verifierAuthentif(login, mp)) {
			model.addObject("identifiant",login);
			ArrayList<Privilege> lp = new ArrayList<>();
			boolean flag = false;
			for (Privilege p :this.loginService.getCompte(login).getRole().getPrivileges()){
				lp.add(p);
				if(p.getIntitule().equals("manager"))flag = true;
			}
			model.addObject("privileges",lp);
			if(flag){

				model.setViewName("welcomeAdmin");
			}else{
				model.setViewName("welcomeUser");
			}

			return model;
		}else {
			model.addObject("erreur","Mot de passse passe incorrect");
			model.setViewName("login");
			return model;
		}
	}
	@PostMapping(value="/addCompte")
	public ModelAndView addCompte(@RequestParam String login,
			                @RequestParam String mp) {
		ModelAndView mv = new ModelAndView();
		Compte c = new Compte();
		c.setLogin(login);
		c.setMp(mp);
		loginService.creerCompte(c);
		Role r = new Role();r.setIntitule("user");
		roleService.affecteCompteARole(c, r);
		mv.setViewName("welcomeUser");
		return mv;
	}
	@GetMapping(value="/addCompte")
	public String showInscriptionPage() {
		return "inscription";
	}
	@GetMapping(value="/listeComptes")
	public ModelAndView showCobmptes() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Comptes", loginService.getComptes());
		mv.setViewName("lesComptes");
		return mv;
	}
	@GetMapping(value="/compte/{xyz}/{mp}")
	public ModelAndView afficheCompte(@PathVariable String xyz,
			   @PathVariable String mp) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("abc", loginService.getCompte(xyz));
		mv.addObject("Comptes", loginService.getComptes());
		mv.addObject("lescomptes", loginService.getComptes(mp));
		mv.setViewName("lesComptes");
		return mv;
	}

	
	
	
}
