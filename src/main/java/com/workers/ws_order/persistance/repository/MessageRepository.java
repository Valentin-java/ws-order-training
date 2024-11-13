package com.workers.ws_order.persistance.repository;

import com.workers.ws_order.persistance.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity>findByBidId(Long bidId);
}
