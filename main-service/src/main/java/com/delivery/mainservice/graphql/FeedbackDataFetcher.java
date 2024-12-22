package com.delivery.mainservice.graphql;

import com.delivery.mainservice.dtos.feedbackDtos.CreateFeedbackDto;
import com.delivery.mainservice.dtos.feedbackDtos.FeedbackDto;
import com.delivery.mainservice.models.entities.Feedbacks;
import com.delivery.mainservice.repositories.FeedbackRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@DgsComponent
public class FeedbackDataFetcher {

    private final FeedbackRepository feedbackRepository;
    private final ModelMapper modelMapper;

    public FeedbackDataFetcher(FeedbackRepository feedbackRepository, ModelMapper modelMapper) {
        this.feedbackRepository = feedbackRepository;
        this.modelMapper = modelMapper;
    }

    @DgsQuery
    public Optional<FeedbackDto> findFeedbackById(@InputArgument UUID id) {
        return feedbackRepository.findById(id).map(feedbacks -> modelMapper.map(feedbacks, FeedbackDto.class));
    }

    @DgsQuery
    public List<FeedbackDto> findAllFeedbacks() {
        return feedbackRepository.findAll().stream().map(feedbacks -> modelMapper.map(feedbacks, FeedbackDto.class))
                .collect(Collectors.toList());
    }

    @DgsMutation
    public FeedbackDto createFeedback(CreateFeedbackDto createFeedbackDto) {
        Feedbacks feedbacks = modelMapper.map(createFeedbackDto, Feedbacks.class);

        feedbacks.setCreatedAt(new Date());

        return modelMapper.map(feedbackRepository.saveAndFlush(feedbacks), FeedbackDto.class);
    }

    @DgsMutation
    public boolean deleteFeedback(UUID id) {
        feedbackRepository.deleteById(id);
        return true;
    }
}
