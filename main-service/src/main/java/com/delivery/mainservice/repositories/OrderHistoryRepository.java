package com.delivery.mainservice.repositories;

import com.delivery.mainservice.models.entities.OrdersHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrdersHistory, UUID> {

}
