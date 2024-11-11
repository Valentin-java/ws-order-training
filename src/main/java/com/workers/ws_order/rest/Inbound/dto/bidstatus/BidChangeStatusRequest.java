package com.workers.ws_order.rest.Inbound.dto.bidstatus;

public record BidChangeStatusRequest(
        Long orderId,
        Long bidId
) {

}
