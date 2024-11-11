package com.workers.ws_order.bussines.order.handyman.interfaces;

import com.workers.ws_order.rest.Inbound.dto.updateorder.OrderChangeStatusByHandyman;


public interface OrderHandymanService {

    //PageDomain<OrderSummaryProjection> getOrderByFilter(OrderSummaryRequestDto requestDto) throws ExecutionException, InterruptedException;

    void inProgress(OrderChangeStatusByHandyman request);

    void complete (OrderChangeStatusByHandyman request);
}
