package com.workers.ws_order.bussines.bid.mapper;

import com.workers.ws_order.config.mapper.MapperConfiguration;
import com.workers.ws_order.persistance.entity.BidEntity;
import com.workers.ws_order.rest.Inbound.dto.createbid.BidCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.createbid.BidCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.getbid.BidSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface BidMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BidEntity toEntity(BidCreateRequestDto requestDto);//приобразование в сущность для сохранения

    @Mapping(target = "bidId",source = "id")
    BidCreateResponseDto toResponseDto(BidEntity bidEntity);//Преобразование сущности в ответный DTO

    @Mapping(target = "bidId", source = "id")
    BidSummaryDto toSummeryDto (BidEntity bidEntity);
}
