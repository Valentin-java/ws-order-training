package com.workers.ws_order.rest.Inbound.controller;

import com.workers.ws_order.bussines.message.Interfaces.MessageService;
import com.workers.ws_order.rest.Inbound.dto.messege.createmsg.MessageCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.messege.createmsg.MessageCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.messege.getmsg.MessageSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/message")
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/bid/{bidId}")
    public ResponseEntity<MessageCreateResponseDto> sendMessage(@PathVariable Long bidId, @RequestBody MessageCreateRequestDto requestDto){
        return ResponseEntity.ok(messageService.sendMessage(bidId,requestDto));
    }

    @GetMapping("/bid/{bidId}")
    public ResponseEntity<List<MessageSummaryDto>> getMessageByBidId(@PathVariable Long bidId){
        return ResponseEntity.ok(messageService.getMessageByBidId(bidId));
    }
}
