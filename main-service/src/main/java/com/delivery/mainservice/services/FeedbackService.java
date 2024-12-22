package com.delivery.mainservice.services;

import com.delivery.mainservice.dtos.feedbackDtos.CreateFeedbackDto;
import com.delivery.mainservice.dtos.feedbackDtos.FeedbackDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface FeedbackService {
    FeedbackDto createFeedback(CreateFeedbackDto createFeedbackDto);
    void deleteFeedback(UUID id);
    FeedbackDto editFeedback(UUID id, CreateFeedbackDto createFeedbackDto);
    Page<FeedbackDto> getAllFeedbacks(Pageable pageable);
    Optional<FeedbackDto> getFeedback(UUID id);
}
