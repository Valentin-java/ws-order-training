package com.workers.ws_order.bussines.bid.interfaces;

import com.workers.ws_order.rest.Inbound.dto.bidstatus.BidChangeStatusRequest;
import com.workers.ws_order.rest.Inbound.dto.createbid.BidCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createbid.BidCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.getbid.BidSummaryDto;

import java.util.List;

public interface BidService {

    BidCreateResponseDto createBid(BidCreateRequestDto requestDto);

    List<BidSummaryDto> getBidsByOrderId(Long orderId);

    List<BidSummaryDto> getBidsBySpecialistId(Long specialistId);

    void acceptBid(BidChangeStatusRequest request);

    void rejectBid(BidChangeStatusRequest request);

    void canselBid(BidChangeStatusRequest request);


}
