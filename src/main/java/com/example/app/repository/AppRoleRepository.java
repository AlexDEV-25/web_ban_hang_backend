package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

}
