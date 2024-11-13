package com.workers.ws_order.rest.Inbound.dto.messege.createmsg;

import java.time.LocalDateTime;

public record MessageCreateResponseDto(
        Long messageId,
        Long bidId,
        Long senderId,
        String content,
        LocalDateTime timestamp
) {
}
