package com.delivery.mainservice.services.impl;

import com.delivery.mainservice.dtos.feedbackDtos.CreateFeedbackDto;
import com.delivery.mainservice.dtos.feedbackDtos.FeedbackDto;
import com.delivery.mainservice.models.entities.Feedbacks;
import com.delivery.mainservice.repositories.FeedbackRepository;
import com.delivery.mainservice.services.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final ModelMapper modelMapper;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, ModelMapper modelMapper) {
        this.feedbackRepository = feedbackRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public FeedbackDto createFeedback(CreateFeedbackDto createFeedbackDto) {
        Feedbacks feedback = modelMapper.map(createFeedbackDto, Feedbacks.class);
        feedback.setCreatedAt(new Date());

        return modelMapper.map(feedbackRepository.save(feedback), FeedbackDto.class);
    }

    @Override
    public void deleteFeedback(UUID id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public FeedbackDto editFeedback(UUID id, CreateFeedbackDto createFeedbackDto) {
        Feedbacks feedbacks = feedbackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feedback not found"));

        modelMapper.map(createFeedbackDto, feedbacks);

        return modelMapper.map(feedbackRepository.saveAndFlush(feedbacks), FeedbackDto.class);
    }

    @Override
    public Page<FeedbackDto> getAllFeedbacks(Pageable pageable) {
        Page<Feedbacks> feedbacksPage = feedbackRepository.findAll(pageable);
        return feedbacksPage.map(feedbacks -> modelMapper.map(feedbacks, FeedbackDto.class));
    }

    @Override
    public Optional<FeedbackDto> getFeedback(UUID id) {
        return feedbackRepository.findById(id).map(feedback -> modelMapper.map(feedback, FeedbackDto.class));
    }
}
