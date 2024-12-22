package com.delivery.contractfirst.dtos;

import java.util.Date;

public record CustomerResponse(
       Long id,
       String firstName,
       String lastName,
       String email,
       String phone,
       Date birthDate
)
{}
