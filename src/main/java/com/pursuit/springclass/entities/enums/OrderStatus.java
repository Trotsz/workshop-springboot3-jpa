package com.pursuit.springclass.entities.enums;

import com.pursuit.springclass.entities.Order;

public enum OrderStatus {
    WAITING_PAYMENT(0),
    PAID(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static OrderStatus intToEnum(int num) {
        for(int i = 0; i < OrderStatus.values().length; i++) {
            if(OrderStatus.values()[i].getCode() == num) {
                return OrderStatus.values()[i];
            }
        }
        throw new IllegalArgumentException("The enum OrderStatus does not have an element with the code " + num);
    }
}
