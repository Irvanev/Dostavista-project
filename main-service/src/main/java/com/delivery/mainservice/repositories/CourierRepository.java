package com.delivery.mainservice.repositories;

import com.delivery.mainservice.models.entities.Couriers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourierRepository extends JpaRepository<Couriers, UUID> {

}
