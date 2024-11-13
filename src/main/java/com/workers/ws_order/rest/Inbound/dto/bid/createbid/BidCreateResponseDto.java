package com.workers.ws_order.rest.Inbound.dto.bid.createbid;

import com.workers.ws_order.persistance.enums.BidStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BidCreateResponseDto(
        Long bidId,
        Long orderId,
        Long specialistId,
        BigDecimal price,
        BidStatus status,
        LocalDateTime createdAt

) {
}
