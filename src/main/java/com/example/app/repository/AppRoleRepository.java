package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.app.entity.AppRole;

@RepositoryRestResource(path = "roles")
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

}
