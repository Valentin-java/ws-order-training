package com.workers.ws_order.rest.Inbound.controller;

import com.workers.ws_order.bussines.order.service.BidService;
import com.workers.ws_order.rest.Inbound.dto.createbid.BidCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bid")
public class BidController {
    private final BidService bidService;

    public ResponseEntity<?> createBid (@RequestBody BidCreateRequestDto requestDto){
        return ResponseEntity.ok(bidService.createBid(requestDto));
    }
}
