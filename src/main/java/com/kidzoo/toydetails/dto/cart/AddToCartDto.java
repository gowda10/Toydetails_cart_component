package com.kidzoo.toydetails.dto.cart;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AddToCartDto {
    private UUID basketId;

    private @NotNull Integer productId;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    }

    public UUID getBasketId() {
        return basketId;
    }

    public void setBasketId(UUID basketId) {this.basketId = basketId;}

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
