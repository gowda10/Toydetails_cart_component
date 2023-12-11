package com.kidzoo.toydetails.dto.checkout;

import com.kidzoo.toydetails.dto.cart.CartItemDto;
import com.kidzoo.toydetails.model.Product;

public class CheckoutItemDto {

    private String productName;
    private int  quantity;
    private double price;

    Product product;
    CartItemDto cart;

    public CheckoutItemDto() {}

    public CheckoutItemDto(String productName, int quantity, double price) {
        this.productName = product.getName();
        this.quantity = cart.getQuantity();
        this.price = product.getPrice();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){return price;}



}
