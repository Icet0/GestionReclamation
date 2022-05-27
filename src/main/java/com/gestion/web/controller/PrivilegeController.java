package com.gestion.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.web.model.Privilege;
import com.gestion.web.model.Role;
import com.gestion.web.service.PrivilegeService;

@Controller
public class PrivilegeController {
	@Autowired
	PrivilegeService privilegeService;
	
	@GetMapping(value="/privilegerole")
	public String showPrivilegeRole() {
		return "privilegerole";
	}
	@PostMapping(value="/privilegerole")
	public ModelAndView affecterPrivilegeRole
	          (@RequestParam String intitPrivilege,
	        		  @RequestParam String intitRole) {
		ModelAndView mv = new ModelAndView();
		Privilege p = new Privilege();p.setIntitule(intitPrivilege);
		Role r = new Role();r.setIntitule(intitRole);
		privilegeService.affecterPriviegesRole(p, r);
		System.out.println(privilegeService.getPrivileges());
		mv.addObject("privileges", privilegeService.getPrivileges());
		mv.setViewName("home");
		return mv;
	}

}
