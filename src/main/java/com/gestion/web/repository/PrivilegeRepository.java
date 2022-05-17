package com.gestion.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.web.model.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, String>{
}
