package com.kidzoo.toydetails.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "basketId")

public class BasketId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String basketId;

    @OneToOne(targetEntity = Cart.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private Cart cart;
    public BasketId(Cart cart) {
        this.id = id;
        this.basketId = UUID.randomUUID().toString();
    }

    public BasketId(Integer id, String basketId, Cart cart) {
        this.id = id;
        this.basketId = UUID.randomUUID().toString();
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public BasketId setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getBasketId() {
        return basketId;
    }

    public BasketId setBasketId(String basketId) {
        this.basketId = basketId;
        return this;
    }

    public Cart getCart() {
        return cart;
    }

    public BasketId setCart(Cart cart) {
        this.cart = cart;
        return this;
    }
}
