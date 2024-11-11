package com.workers.ws_order.rest.Inbound.controller;

import com.workers.ws_order.bussines.order.handyman.interfaces.OrderHandymanService;
import com.workers.ws_order.rest.Inbound.dto.updateorder.OrderChangeStatusByHandyman;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order/handyman")
public class OrderHandymanController {

    public final OrderHandymanService service;

    //@PostMapping("/available")
    //    public ResponseEntity<PageDomain<OrderSummaryProjection>> getOrderListByFilter(@RequestBody OrderSummaryRequestDto requestDto) throws ExecutionException, InterruptedException {
    //        return ResponseEntity.ok(service.getOrderByFilter(requestDto));
    //    }

    @PostMapping("/inProgress")
    public ResponseEntity<Void> inProgress(@RequestBody OrderChangeStatusByHandyman request) {
        service.inProgress(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/complete")
    public ResponseEntity<Void>complete(@RequestBody OrderChangeStatusByHandyman request){
        service.complete(request);
        return ResponseEntity.ok().build();
    }

}
