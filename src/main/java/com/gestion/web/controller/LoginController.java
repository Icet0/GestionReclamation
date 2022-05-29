package com.gestion.web.controller;

import com.gestion.web.model.Privilege;
import com.gestion.web.model.Reclamation;
import com.gestion.web.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.web.model.Compte;
import com.gestion.web.model.Role;
import com.gestion.web.service.LoginService;
import com.gestion.web.service.RoleService;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
	@Autowired
	HttpServletResponse response;
	@Autowired
	LoginService loginService;

	@Autowired
	RoleService roleService ;
	Role role;

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
	public void setLoginCookie(HttpServletResponse response,String login) {
		// create a cookie
		Cookie cookie = new Cookie("login", login);

		//add cookie to response
		response.addCookie(cookie);

	}
	@PostMapping(value="/login")
	public ModelAndView verifierLogin(@RequestParam String login,
									  @RequestParam String mp,
									  HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if (loginService.verifierAuthentif(login, mp)) {
			model.addObject("identifiant",login);
			role = loginService.getCompte(login).getRole() ;
			model.addObject("role", this.role.getIntitule());
			ArrayList<Privilege> lp = new ArrayList<>();
			boolean flag = false;
			for (Privilege p :this.loginService.getCompte(login).getRole().getPrivileges()){
				lp.add(p);

			}
			if(this.loginService.getCompte(login).getRole().getId()==1)flag = true;
			model.addObject("privileges",lp);
			if(flag){
				model.setViewName("welcomeAdmin");
				setLoginCookie(response,login);
				Cookie name = WebUtils.getCookie(request, "login");
				if (name != null) {
					model.addObject("identifiant",this.readLoginCookie(name.getValue()));
				}
			}else{
				List<Reclamation> recla = reclamationService.getReclamationCompte(login);
				model.addObject("reclamation", recla);
				setLoginCookie(response,login);
				Cookie name = WebUtils.getCookie(request, "login");
				if (name != null) {
					model.addObject("identifiant",this.readLoginCookie(name.getValue()));
				}
				model.setViewName("welcomeUser");
			}

			return model;
		}else {
			model.addObject("errorMessage","Mot de passse passe incorrect");
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


	@GetMapping(value = "/roleattrib")
	public String showRole() {
		return "roleattrib"; //il va appeler la page login.jsp !
	}
	@PostMapping(value="/roleattrib")
	public ModelAndView attribRole(Role r, String login, String mp){
		ModelAndView m = new ModelAndView() ;
		if (loginService.verifierAuthentif(login, mp)) {
			m.addObject("log", login);

			roleService.affecteCompteARole(loginService.getCompte(login), r) ;
			m.addObject("Role", loginService.getCompte(login).getRole().getIntitule()) ;
			System.out.println(loginService.getCompte(login).getRole());
			m.setViewName("compterole2");
			return m;
		}
		else{
			m.addObject("erreur","Le compte que vous cherchez n'existe pas");
			m.setViewName("compterole2");
			return m;
		}
	}


	public void setRoleCookie(HttpServletResponse response,String role) {
		// create a cookie
		Cookie cookie = new Cookie("role", role);

		//add cookie to response
		response.addCookie(cookie);

	}

	public String readLoginCookie(@CookieValue(value = "login", defaultValue = "Atta") String login) {
		return  login;
	}

	public String readRoleCookie(@CookieValue(value = "role") String role) {
		return  role;
	}
}