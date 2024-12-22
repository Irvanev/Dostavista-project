package com.delivery.mainservice.repositories;

import com.delivery.mainservice.models.entities.Feedbacks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedbacks, UUID> {

}
