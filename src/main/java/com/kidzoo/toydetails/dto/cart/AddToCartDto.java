package com.kidzoo.toydetails.dto.cart;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AddToCartDto {
    private Integer basketId;

    private @NotNull Integer productId;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    }

    public Integer getBasketId() {
        return basketId;
    }

    public void setBasketId(Integer basketId) {this.basketId = basketId;}

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
