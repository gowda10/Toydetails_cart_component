package com.kidzoo.toydetails.service;

import com.kidzoo.toydetails.exception.CustomException;
import com.kidzoo.toydetails.model.*;
import com.stripe.param.checkout.SessionCreateParams;
import com.kidzoo.toydetails.dto.cart.CartDto;
import com.kidzoo.toydetails.dto.cart.CartItemDto;
import com.kidzoo.toydetails.dto.checkout.CheckoutItemDto;
import com.kidzoo.toydetails.exception.OrderNotFoundException;
import com.kidzoo.toydetails.repository.OrderItemsRepository;
import com.kidzoo.toydetails.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class OrderService {

    @Autowired
    private CartService cartService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    PersonalDetailsService personalDetailsService;

    @Autowired
    BankDetailsService bankDetailsService;

    // create total price
    SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto) {
        return SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("inr")
                .setUnitAmount((long)(checkoutItemDto.getPrice()*100))
                .setProductData(
                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                .setName(checkoutItemDto.getProductName())
                                .build())
                .build();
    }

    public void placeOrder(User user, UUID basketId) {
        PersonalDetails personalDetails = personalDetailsService.getPersonalDetailsByUser(user);
        if (personalDetails == null) {
            throw new CustomException("User has not provided personal details.");
        }
        BankDetails bankDetails = bankDetailsService.getBankDetailsByUser(user);
        if (bankDetails == null) {
            throw new CustomException("User has not provided Bank details.");
        }
//         first let get cart items for the user
        CartDto cartDto = cartService.listCartItems(user, basketId);

        List<CartItemDto> cartItemDtoList = cartDto.getCartItems();

        // create the order and save it
        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
        newOrder.setUser(user);
        newOrder.setTotalPrice(cartDto.getTotalCost());
        orderRepository.save(newOrder);

        for (CartItemDto cartItemDto : cartItemDtoList) {
            // create orderItem and save each one
            OrderItem orderItem = new OrderItem();
            orderItem.setCreatedDate(new Date());
            orderItem.setPrice(cartItemDto.getProduct().getPrice());
            orderItem.setProduct(cartItemDto.getProduct());
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setOrder(newOrder);
            // add to order item list
            orderItemsRepository.save(orderItem);
        }
        cartService.deleteCartItemsByUser(user);
    }

    public List<Order> listOrders(User user) {
        return orderRepository.findAllByUserOrderByCreatedDateDesc(user);
    }

    public Order getOrder(Integer orderId) throws OrderNotFoundException {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            return order.get();
        }
        throw new OrderNotFoundException("Order not found");
    }
}