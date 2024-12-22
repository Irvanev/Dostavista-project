package com.delivery.mainservice.services.impl;

import com.delivery.mainservice.dtos.courierDtos.CourierDto;
import com.delivery.mainservice.dtos.courierDtos.CreateCourierDto;
import com.delivery.mainservice.models.entities.Couriers;
import com.delivery.mainservice.models.enums.UserStatusEnum;
import com.delivery.mainservice.repositories.CourierRepository;
import com.delivery.mainservice.services.CourierService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;
    private final ModelMapper modelMapper;

    public CourierServiceImpl(
            CourierRepository courierRepository,
            ModelMapper modelMapper
    ) {
        this.courierRepository = courierRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CourierDto createCourier(CreateCourierDto createCourierDto) {
        Couriers couriers = modelMapper.map(createCourierDto, Couriers.class);
        couriers.setCreatedAt(new Date());
        couriers.setStatus(UserStatusEnum.FREE);

        couriers = courierRepository.saveAndFlush(couriers);

        return modelMapper.map(couriers, CourierDto.class);
    }

    @Override
    public Page<CourierDto> getAllCouriers(Pageable pageable) {
        Page<Couriers> couriersPage = courierRepository.findAll(pageable);
        return couriersPage.map(courier -> modelMapper.map(courier, CourierDto.class));
    }

    @Override
    public Optional<CourierDto> getCourierById(UUID id) {
        return courierRepository.findById(id).map(courier -> modelMapper.map(courier, CourierDto.class));
    }

    @Override
    public void deleteCourier(UUID id) {
        courierRepository.deleteById(id);
    }

    @Override
    public CourierDto editCourier(UUID id, CreateCourierDto createCourierDto) {
        Couriers couriers = courierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Courier not found"));

        modelMapper.map(createCourierDto, couriers);

        return modelMapper.map(courierRepository.saveAndFlush(couriers), CourierDto.class);
    }
}
