package com.workers.ws_order.rest.Inbound.controller;

import com.workers.ws_order.bussines.photofiles.interfaces.OrderPhotoService;
import com.workers.ws_order.rest.Inbound.dto.common.model.FileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/photo")
public class OrderPhotoController {

    private final OrderPhotoService service;

    @PostMapping("/{orderId}/upload")
    public ResponseEntity<Void> uploadFiles (@PathVariable Long orderId,
                                             @RequestParam ("files") List<MultipartFile> files){
        service.uploadFiles(orderId,files);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{orderId}/update")
    public ResponseEntity<Void> updateOrderPhotos(@PathVariable Long orderId,
                                                  @RequestParam("files") List<MultipartFile> files) {
        service.updateOrderPhotos(orderId, files);
        return ResponseEntity.ok().build();// в этом случае возвращается только статус 200 без данных
    }

    @GetMapping("/{orderId}/load")
    public ResponseEntity<List<FileDto>> loadFiles(@PathVariable Long orderId) {
        return ResponseEntity.ok(service.loadFiles(orderId));//в этом случае возвращает статус 200 и список FileDto в теле ответа
    }
}
