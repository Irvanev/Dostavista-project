package com.delivery.contractfirst.dtos;

import java.util.Date;

public record CourierResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        String requisite,
        UserStatusEnum status,
        Date createdAt
) {
}
