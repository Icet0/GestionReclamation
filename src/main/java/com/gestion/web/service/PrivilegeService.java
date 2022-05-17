package com.gestion.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.web.model.Privilege;
import com.gestion.web.model.Role;
import com.gestion.web.repository.PrivilegeRepository;
import com.gestion.web.repository.RoleRepository;

@Service
public class PrivilegeService {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	public void affecterPriviegesRole(Privilege privilege, Role role) {
		if (roleRepository.getByIntitule(role.getIntitule()) == null) {
			roleRepository.save(role);
		}
		//Role exist
		privilege.getRoles().add(roleRepository.getByIntitule(role.getIntitule()));
		privilegeRepository.save(privilege);//save = create and update
	}
	public List<Privilege> getPrivileges(){
		return privilegeRepository.findAll();
	}
}
