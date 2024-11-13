package com.workers.ws_order.rest.Inbound.dto.order.updateorder;

public record OrderChangeStatusByHandyman(
        Long orderId,
        Long specialistId
) {
}
