package com.kidzoo.toydetails.dto.order;

import com.kidzoo.toydetails.model.Order;

import javax.validation.constraints.NotNull;

public class OrderDto {
    private Integer orderId;
    private @NotNull Integer userId;

    private @NotNull Integer guestId;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setOrderId(order.getOrderId());
        //this.setUserId(order.getUserId());
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

}
