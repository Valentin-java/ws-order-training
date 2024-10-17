package com.workers.ws_order.rest.Inbound.dto.createorder;

public record OrderCreateRequestDto(
        Long customerId,
        String category,
        String shortDescription,
        String detailedDescription

) {
}
