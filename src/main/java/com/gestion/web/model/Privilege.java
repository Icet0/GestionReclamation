package com.gestion.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity //classe persistante
public class Privilege {
	@Id
	@Column(length = 30)
	private String intitule;
	
	@ManyToMany
	private List<Role> roles = new ArrayList<Role>();
	
	public Privilege() {
		super();
	}

	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Override
	public String toString() {
		return "Privilege [intitule=" + intitule + ", roles=" + roles + "]";
	}

}
