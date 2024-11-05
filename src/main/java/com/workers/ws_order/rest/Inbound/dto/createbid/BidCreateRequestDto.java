package com.workers.ws_order.rest.Inbound.dto.createbid;

import java.math.BigDecimal;

public record BidCreateRequestDto(
        Long orderId,
        Long specialistId,
        BigDecimal price,
        String message

) {
}
