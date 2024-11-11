package com.workers.ws_order.rest.Inbound.dto.updateorder;

public record OrderChangeStatusByHandyman(
        Long orderId,
        Long specialistId
) {
}
