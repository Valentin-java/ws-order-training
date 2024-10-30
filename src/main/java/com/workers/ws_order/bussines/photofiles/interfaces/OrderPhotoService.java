package com.workers.ws_order.bussines.photofiles.interfaces;

import com.workers.ws_order.rest.Inbound.dto.common.model.FileDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OrderPhotoService {

    //Сохранение фотографий заказа
    void uploadFiles(Long orderId, List<MultipartFile> files);

    //Загрузка фотографий заказа
    List<FileDto> loadFiles(Long orderId);

    //Замена списка фотографий на те, что пришли из update
    void updateOrderPhotos(Long orderId, List<MultipartFile> photoData);

}
