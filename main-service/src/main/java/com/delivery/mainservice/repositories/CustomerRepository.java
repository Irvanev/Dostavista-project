package com.delivery.mainservice.repositories;

import com.delivery.mainservice.models.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, UUID> {

}
