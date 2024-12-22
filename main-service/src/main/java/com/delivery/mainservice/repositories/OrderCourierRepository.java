package com.delivery.mainservice.repositories;

import com.delivery.mainservice.models.entities.OrdersCourier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderCourierRepository extends JpaRepository<OrdersCourier, UUID> {
    Optional<OrdersCourier> findByCourierIdAndOrderId(UUID courierId, UUID orderId);
}
