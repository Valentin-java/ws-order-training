package com.workers.ws_order.rest.Inbound.dto.messege.createmsg;

public record MessageCreateRequestDto(
        Long senderId,
        String content
) {
}
