package com.gestion.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity //classe persistante liée à une table dans la base de données !
public class Compte {
	@Id //identifant de la classe lié à une clé primaire !!
	@Column(length = 30)
	private String login;
	private String mp;
	
	@ManyToOne
	Role role;
	
	public Compte() {
		super();
	}
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMp() {
		return mp;
	}
	public void setMp(String mp) {
		this.mp = mp;
	}


	@Override
	public String toString() {
		return "[login=" + login + ", mp=" + mp + "]" ;
	}
	
	
}
