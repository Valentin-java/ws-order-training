package com.workers.ws_order.rest.Inbound.controller;

import com.workers.ws_order.bussines.bid.interfaces.BidService;
import com.workers.ws_order.rest.Inbound.dto.bid.bidstatus.BidChangeStatusRequest;
import com.workers.ws_order.rest.Inbound.dto.bid.createbid.BidCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.bid.createbid.BidCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.bid.getbid.BidSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bid")
public class BidController {
    private final BidService service;

    @PostMapping("/create")
    public ResponseEntity<BidCreateResponseDto> createBid(@RequestBody BidCreateRequestDto requestDto) {
        return ResponseEntity.ok(service.createBid(requestDto));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<BidSummaryDto>> getBidsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(service.getBidsByOrderId(orderId));
    }

    @GetMapping("/specialist/{specialistId}")
    public ResponseEntity<List<BidSummaryDto>> getBidsBySpecialistId(@PathVariable Long specialistId) {
        return ResponseEntity.ok(service.getBidsBySpecialistId(specialistId));
    }

    @PostMapping("/accept")
    public ResponseEntity<Void> acceptBid(@RequestBody BidChangeStatusRequest request) {
        service.acceptBid(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject")
    public ResponseEntity<Void> rejectBid(@RequestBody BidChangeStatusRequest request) {
        service.rejectBid(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cancel")
    public ResponseEntity<Void> canselBid(@RequestBody BidChangeStatusRequest request) {
        service.canselBid(request);
        return ResponseEntity.ok().build();
    }

}
