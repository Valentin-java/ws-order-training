package com.workers.ws_order.bussines.order.customer.mapper;

import com.workers.ws_order.config.mapper.MapperConfiguration;
import com.workers.ws_order.persistance.entity.OrderEntity;
import com.workers.ws_order.persistance.enums.OrderCategoryEnum;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createorder.OrderCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.getorder.OrderSummaryDto;
import com.workers.ws_order.rest.Inbound.dto.updateorder.OrderUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfiguration.class)
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    OrderEntity toEntity(OrderCreateRequestDto requestDto);

    @Mapping(target = "orderId", source = "id")
    @Mapping(source = "category", target = "category", qualifiedByName = "mapCategoryToDescription")
    OrderCreateResponseDto toResponseDto(OrderEntity orderEntity);

    @Mapping(source = "id", target = "orderId")
    @Mapping(source = "category", target = "category", qualifiedByName = "mapCategoryToDescription")
    OrderSummaryDto toSummaryDto(OrderEntity orderEntity);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    void updateOrderFromDto(OrderUpdateRequestDto source, @MappingTarget OrderEntity target);

    @Named("mapCategoryToDescription")
    default String mapCategoryToDescription(Integer categoryCode) {
        return OrderCategoryEnum.getDescriptionByCode(categoryCode);
    }




}
