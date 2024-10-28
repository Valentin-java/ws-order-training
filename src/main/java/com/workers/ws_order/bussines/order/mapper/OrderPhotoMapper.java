package com.workers.ws_order.bussines.order.mapper;

import com.workers.ws_order.config.mapper.MapperConfiguration;
import com.workers.ws_order.persistance.entity.OrderPhotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

@Mapper(config = MapperConfiguration.class)
public interface OrderPhotoMapper {


    @Mapping(target = "orderId", source = "orderId")
    @Mapping(target = "", source = "source.name")
    @Mapping(target = "", source = "source.")
    @Mapping(target = "", source = "source.")
    @Mapping(target = "", source = "source.")
    OrderPhotoEntity toEntity(MultipartFile source, Long orderId);
}
