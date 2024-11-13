package com.workers.ws_order.rest.Inbound.dto.bid.createbid;

import java.math.BigDecimal;

/**
 * запрос для создания заказа.
 */
public record BidCreateRequestDto(
        Long orderId,
        Long specialistId,
        BigDecimal price,
        String message

) {
}
