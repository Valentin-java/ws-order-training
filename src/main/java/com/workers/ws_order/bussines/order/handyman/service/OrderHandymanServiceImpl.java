package com.workers.ws_order.bussines.order.handyman.service;

import com.workers.ws_order.bussines.order.handyman.interfaces.OrderHandymanService;
import com.workers.ws_order.persistance.entity.BidEntity;
import com.workers.ws_order.persistance.entity.OrderEntity;
import com.workers.ws_order.persistance.enums.BidStatus;
import com.workers.ws_order.persistance.enums.OrderStatus;
import com.workers.ws_order.persistance.repository.BidRepository;
import com.workers.ws_order.persistance.repository.OrderRepository;
import com.workers.ws_order.persistance.repository.custom.OrderPageableCustomRepository;
import com.workers.ws_order.rest.Inbound.dto.order.updateorder.OrderChangeStatusByHandyman;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.workers.ws_order.persistance.enums.OrderStatus.CANCELLED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderHandymanServiceImpl implements OrderHandymanService {

    private final BidRepository bidRepository;
    private final OrderRepository orderRepository;
    private final OrderPageableCustomRepository orderPageableCustomRepository;

    //@Override
    //    public PageDomain<OrderSummaryProjection> getOrderByFilter(OrderSummaryRequestDto requestDto)
    //            throws ExecutionException, InterruptedException {
    //        log.info("Fetching available orders for specialist ID: {}", requestDto);
    //
    //
    //        var futureRecordCount = CompletableFuture.supplyAsync(
    //                () -> orderPageableCustomRepository.getRecordsCount(requestDto.filter()));
    //
    //        var orderList = orderPageableCustomRepository.getOrderListByFilter(requestDto);
    //
    //        return new PageDomain<>(
    //                requestDto.pageable().getOffset(),
    //                requestDto.pageable().getItemsLimit(),
    //                futureRecordCount.get(),
    //                orderList);
    //    }


    @Override
    public void inProgress(OrderChangeStatusByHandyman request) {
        OrderEntity order = orderRepository.findById(request.orderId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Order not found with ID: " + request.orderId()));

        BidEntity acceptedBid = bidRepository.findFirstByOrderIdAndStatus(request.orderId(), BidStatus.ACCEPTED);
        if (acceptedBid != null || !acceptedBid.getSpecialistId().equals(request.specialistId())) {
            throw new ResponseStatusException(BAD_REQUEST, "Only the specialist with the accepted bid can take in progress the order");
        }
        order.setStatus(OrderStatus.IN_PROGRESS);
        orderRepository.save(order);
        log.info("Order with ID: {} has been marked as in progress by specialist ID: {}", request.orderId(), request.specialistId());

    }

    @Override
    public void complete(OrderChangeStatusByHandyman request) {
        OrderEntity order = orderRepository.findById(request.orderId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Order not found with ID: " + request.orderId()));

        BidEntity acceptedBid = bidRepository.findFirstByOrderIdAndStatus(request.orderId(), BidStatus.ACCEPTED);
        if (acceptedBid != null || !acceptedBid.getSpecialistId().equals(request.specialistId())) {
            throw new ResponseStatusException(BAD_REQUEST, "Only the specialist with the accepted bid can take in progress the order");
        }

        order.setStatus(CANCELLED);
        orderRepository.save(order);
        log.info("Order with ID: {} has been marked as completed by specialist ID: {}", request.orderId(), request.specialistId());

    }

}























