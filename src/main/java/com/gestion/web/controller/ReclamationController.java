package com.gestion.web.controller;

import com.gestion.web.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReclamationController {

    @Autowired
    ReclamationService reclamationService;

//    MAPPING + appel fonction de reclamationService

    @GetMapping(value = "/reclamationsAdmin")
    public ModelAndView showReclamations() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("Reclamations", reclamationService.getReclamations());
//        mv.("onClickFunc", reclamationService.onClick());
        mv.setViewName("reclamationsAffiche");
        return mv;
    }

    public void onClick(String id){
        this.reclamationService.validerReclamation(id);
    }
}
