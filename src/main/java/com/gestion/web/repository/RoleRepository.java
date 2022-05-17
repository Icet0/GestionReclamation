package com.gestion.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestion.web.model.Compte;
import com.gestion.web.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	public Role getByIntitule(String intitule);
	
	//Requete JPQL personnalisée
	//Requete Sql correspondante
	//select c.* from compte as c,role as r where (c.role_id=r.id) 
	// and r.intitule='superadmin';
	@Query("select c from Compte c join c.role r where r.intitule=:intitule")
	public List<Compte> getCompteByRole(@Param("intitule") String intitule);
	
	//un autre exemple !!!!
	//@Query("select c from Compte c join c.role r where r.intitule=:abc and c.login=:lg")
	//public List<Compte> getCompteByRole(@Param("abc") String intitule, @Param("lg") String login);

	//select r.intitule, count(*) from compte as c, role as r where (c.role_id=r.id)
	//group by r.intitule
	@Query("select r.intitule, count(c) from Compte c join c.role r group by r.intitule")
	public List<Object[]> getNombreComptesParRole();
	
	
}
