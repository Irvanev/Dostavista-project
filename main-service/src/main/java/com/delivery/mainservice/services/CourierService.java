package com.delivery.mainservice.services;

import com.delivery.mainservice.dtos.courierDtos.CourierDto;
import com.delivery.mainservice.dtos.courierDtos.CreateCourierDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CourierService {
    CourierDto createCourier(CreateCourierDto createCourierDto);
    Page<CourierDto> getAllCouriers(Pageable pageable);
    Optional<CourierDto> getCourierById(UUID id);
    void deleteCourier(UUID id);
    CourierDto editCourier(UUID id, CreateCourierDto createCourierDto);
}
