package com.workers.ws_order.persistance.enums;

public enum BidStatus {
    NEW,          // Новый отклик
    ACCEPTED,     // Отклик принят
    REJECTED,     // Отклик откланен
    CANCELLED,    // Отклик отменен
    COMPLETED,    // Отклик завершен
    PEDING
}
