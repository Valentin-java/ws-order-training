package com.workers.ws_order.rest.Inbound.dto.createorder;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record OrderCreateRequestDto(
        Long customerId,
        String category,
        String shortDescription,
        String detailedDescription,
        List<MultipartFile> photoData

) {
}
