package com.workers.ws_order.bussines.message.Interfaces;

import com.workers.ws_order.rest.Inbound.dto.messege.createmsg.MessageCreateRequestDto;
import com.workers.ws_order.rest.Inbound.dto.messege.createmsg.MessageCreateResponseDto;
import com.workers.ws_order.rest.Inbound.dto.messege.getmsg.MessageSummaryDto;

import java.util.List;

public interface MessageService {

    MessageCreateResponseDto sendMessage(Long bidId, MessageCreateRequestDto requestDto);

    List<MessageSummaryDto> getMessageByBidId(Long bidId);
}
