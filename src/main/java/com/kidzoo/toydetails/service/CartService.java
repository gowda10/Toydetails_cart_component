package com.kidzoo.toydetails.service;

import com.kidzoo.toydetails.dto.cart.AddToCartDto;
import com.kidzoo.toydetails.dto.cart.CartDto;
import com.kidzoo.toydetails.dto.cart.CartItemDto;
import com.kidzoo.toydetails.exception.CartItemNotExistException;
import com.kidzoo.toydetails.model.*;
import com.kidzoo.toydetails.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CartService {


    @Autowired
    private  CartRepository cartRepository;


    public void addToCart(AddToCartDto addToCartDto, Product product, User user){
        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
        cartRepository.save(cart);
    }


    public void updateCartItem(CartItemDto cartDto, User user){
        UUID basketId = cartDto.getBasketId();
        Cart cart = cartRepository.findById(basketId).orElseThrow(() -> new CartItemNotExistException("BasketId is invalid" + basketId));
        cart.setQuantity(cartDto.getQuantity());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }

    public CartDto listCartItem(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart : cartList) {
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        return new CartDto(cartItems);
    }


    public CartDto listCartItems(User user, UUID basketId) {
        Cart carts = cartRepository.findById(basketId).orElseThrow(() -> new CartItemNotExistException("BasketId is invalid" + basketId));
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += (cartItemDto.getProduct().getPrice()* cartItemDto.getQuantity());
        }
        return new CartDto(cartItems,totalCost);
    }


    public static CartItemDto getDtoFromCart(Cart cart) {
        return new CartItemDto(cart);
    }



    public void deleteCartItem(UUID basketId, User user) throws CartItemNotExistException {
        if (!cartRepository.existsById(basketId))
            throw new CartItemNotExistException("Cart id is invalid:" + basketId);
        cartRepository.deleteByBasketIdAndUser(basketId, user);

    }



    public void deleteCartItems(int userId) {
        cartRepository.deleteAll();
    }


    public void deleteUserCartItems(User user, UUID basketId) {
        cartRepository.deleteByBasketIdAndUser(basketId, user);
    }
}


