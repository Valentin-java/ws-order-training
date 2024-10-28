package com.workers.ws_order.rest.Inbound.dto.createorder;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public record OrderCreateResponseDto(
        Long orderId,
        Long customerId,
        String category,
        String shortDescription,
        String detailedDescription,
        String status,
        LocalDateTime createdAt,
        List<MultipartFile> photoData
) {
}
