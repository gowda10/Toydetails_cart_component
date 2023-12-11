package com.kidzoo.toydetails.dto.cart;

import com.kidzoo.toydetails.model.Cart;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AddToCartDto {
    private @NotNull UUID basketId;

    private @NotNull Integer productId;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    }

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
