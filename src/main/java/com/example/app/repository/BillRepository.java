package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.app.entity.Bill;

@RepositoryRestResource(path = "bills")
public interface BillRepository extends JpaRepository<Bill, Long> {

}
