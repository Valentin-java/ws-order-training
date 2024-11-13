package com.workers.ws_order.rest.Inbound.dto.bid.bidstatus;

public record BidChangeStatusRequest(
        Long orderId,
        Long bidId
) {

}
