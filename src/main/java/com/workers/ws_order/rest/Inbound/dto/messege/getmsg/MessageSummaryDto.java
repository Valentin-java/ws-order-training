package com.workers.ws_order.rest.Inbound.dto.messege.getmsg;

import java.time.LocalDateTime;

public record MessageSummaryDto(
        Long messageId,
        Long senderId,
        String content,
        LocalDateTime timestamp
) {
}
