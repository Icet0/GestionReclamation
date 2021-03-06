package com.gestion.web.controller;

import com.gestion.web.model.Compte;
import com.gestion.web.model.Reclamation;
import com.gestion.web.service.LoginService;
import com.gestion.web.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
public class ReclamationController {

    @Autowired
    ReclamationService reclamationService;
    @Autowired
    LoginService loginService;

//    MAPPING + appel fonction de reclamationService


    @GetMapping(value = "/reclamationsAdmin")
    public ModelAndView showReclamationsAdmin(HttpServletRequest request) {
        System.out.println("In showReclamationsAdmin \n\n");
        Cookie name = WebUtils.getCookie(request, "login");
        ModelAndView mv = new ModelAndView();

        Compte u = this.loginService.getCompte(name.getValue());
        if(u.getRole().getId()!=1){
            mv.setViewName("login");
            return mv;
        }
        mv.addObject("Reclamations", reclamationService.getReclamations());
//        mv.("onClickFunc", reclamationService.onClick());
        mv.setViewName("reclamationsAffiche");
        return mv;
    }


    @PostMapping(value="/reclamationsAdmin")
    public ModelAndView updateValide(@RequestParam int id,@RequestParam String type) {
        if(type.equals("valider")){
            System.out.println("In UPTDATE VALIDE \n\n"+id);
            this.reclamationService.validerReclamation(id);
            ModelAndView mv = new ModelAndView();
            mv.addObject("Reclamations", reclamationService.getReclamations());
            mv.setViewName("reclamationsAffiche");
            return mv;
        } else {
            System.out.println("In UPTDATE VALIDE \n\n"+id);
            this.reclamationService.refuserReclamation(id);
            ModelAndView mv = new ModelAndView();
            mv.addObject("Reclamations", reclamationService.getReclamations());
            mv.setViewName("reclamationsAffiche");
            return mv;

        }
    }



    @GetMapping(value = "/reclamationsUser")
    public ModelAndView showReclamationsUser() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("reclamation");
        return mv;
    }

    @PostMapping(value="/reclamationsUser")
    public ModelAndView addCompte(@RequestParam String titre,
                                  @RequestParam String message,
                                  HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if(titre==""){
            mv.addObject("reclaPb","Veuillez saisir un titre");
            mv.setViewName("reclamation");
        }
        else if(message==""){
            mv.addObject("reclaPb","Veuillez renseigner un message");
            mv.setViewName("reclamation");
        }
        else {
            Reclamation r = new Reclamation();
            String login = "";
            Cookie name = WebUtils.getCookie(request, "login");
            if (name != null) {
                Compte c = loginService.getCompte(name.getValue());
                r.setCompte(c);
                r.setDate(Date.from(Instant.now()));
                r.setMessage(message);
                r.setTitre(titre);
                mv.addObject("identifiant", this.readLoginCookie(name.getValue()));
                reclamationService.creerReclamation(r);
                List<Reclamation> recla = reclamationService.getReclamationCompte(name.getValue());
                mv.addObject("reclamation", recla);
                mv.setViewName("welcomeUser");
            }
        }
            return mv;
    }
    public String readLoginCookie(@CookieValue(value = "login", defaultValue = "Atta") String login) {
        return  login;
    }

}
