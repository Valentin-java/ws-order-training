package com.workers.ws_order.bussines.order.mapper;

import com.workers.ws_order.config.mapper.MapperConfiguration;
import com.workers.ws_order.persistance.entity.OrderEntity;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.getorder.OrderSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    OrderEntity toEntity(OrderCreateRequestDto requestDto);

    @Mapping(target = "orderId", source = "id")
    OrderCreateResponseDto toResponseDto(OrderEntity orderEntity);

    @Mapping(source = "id", target = "orderId")
    OrderSummaryDto toSummaryDto(OrderEntity orderEntity);




}
