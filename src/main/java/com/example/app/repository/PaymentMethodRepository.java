package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.app.entity.PaymentMethod;

@RepositoryRestResource(path = "payment-methods")
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

}
