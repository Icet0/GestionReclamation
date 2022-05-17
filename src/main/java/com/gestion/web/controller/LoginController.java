package com.gestion.web.controller;

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

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	
	//affichage de la page login.jsp
	//@RequestMapping(value = "/login",method = RequestMethod.GET)
	@GetMapping(value = "/login")
	public String showLogin() {
		return "login"; //il va appeler la page login.jsp !
	}
	/*@PostMapping(value="/login")
	public String verifierLogin(ModelMap model, @RequestParam String login,
			                        @RequestParam String mp ) {
		System.out.println("Login:"+login+"; mp : "+mp);
		if (login.equals(mp)) {
			//charger des variables dans le model pour utilisation 
			//par la jsp welcome
			model.put("identifiant", login);
			return "welcome";
		}else {
			model.put("erreur","Votre login ne correspond pas !!!");
			return "login";
		}
	}*/
	@PostMapping(value="/login")
	public ModelAndView verifierLogin(@RequestParam String login,
			                        @RequestParam String mp ) {
		ModelAndView model = new ModelAndView();
		if (loginService.verifierAuthentif(login, mp)) {
			//charger des variables dans le model pour utilisation 
			//par la jsp welcome
			model.addObject("identifiant",login);
			model.setViewName("welcome");
			return model;
		}else {
			model.addObject("erreur","Votre login ne correspond pas !!!");
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
		
		mv.setViewName("welcome");
		return mv;
	}
	@GetMapping(value="/addCompte")
	public String showInscriptionPage() {
		return "inscription";
	}
	@GetMapping(value="/listeComptes")
	public ModelAndView showComptes() {
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
