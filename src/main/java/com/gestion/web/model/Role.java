package com.gestion.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Role{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String intitule;
	
	//Association BIDIRECTIONNELLE vers compte ! 
	@OneToMany(mappedBy = "role")
	private List<Compte> comptes;
	
	@ManyToMany(mappedBy = "roles")
	private List<Privilege> privileges = new ArrayList<Privilege>();;
	
	public Role() {
		super();
	}
		


	public List<Privilege> getPrivileges() {
		return privileges;
	}



	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}



	public List<Compte> getComptes() {
		return comptes;
	}


	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", intitule=" + intitule + ", comptes=" + comptes;
	}
	
}
