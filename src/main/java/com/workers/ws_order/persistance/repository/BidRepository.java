package com.workers.ws_order.persistance.repository;

import com.workers.ws_order.persistance.entity.BidEntity;
import com.workers.ws_order.persistance.enums.BidStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<BidEntity, Long> {

    List<BidEntity> findByOrderId(Long orderId);

    BidEntity findFirstByOrderIdAndStatus(Long orderId, BidStatus status);

    List<BidEntity> findBySpecialistId(Long specialistId);

    Optional<BidEntity> findBidEntityByOrderIdAndId(Long orderId, Long bidId);

    Boolean existsBidEntityBySpecialistIdAndOrderId(Long specialistId, Long orderId);
}

