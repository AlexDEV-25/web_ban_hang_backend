package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.app.entity.BillDetail;

@RepositoryRestResource(path = "bill-details")
public interface BillDetailRepository extends JpaRepository<BillDetail, Long> {

}
