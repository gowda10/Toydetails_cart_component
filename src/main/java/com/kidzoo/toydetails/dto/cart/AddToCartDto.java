package com.kidzoo.toydetails.dto.cart;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AddToCartDto {
    private int id;

    private @NotNull Integer productId;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
