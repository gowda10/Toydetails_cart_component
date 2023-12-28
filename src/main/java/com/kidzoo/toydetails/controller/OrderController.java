package com.kidzoo.toydetails.controller;

import com.kidzoo.toydetails.common.ApiResponse;
import com.kidzoo.toydetails.dto.checkout.CheckoutItemDto;
import com.kidzoo.toydetails.dto.checkout.StripeResponse;
import com.kidzoo.toydetails.exception.*;
import com.kidzoo.toydetails.model.Order;
import com.kidzoo.toydetails.model.User;
import com.kidzoo.toydetails.model.UserDetails;
import com.kidzoo.toydetails.service.AuthenticationService;
import com.kidzoo.toydetails.service.OrderService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/toydetails/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;


    // place order after checkout
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder(@RequestHeader("token") String token, @RequestHeader("basketId") UUID basketId, @RequestBody UserDetails userDetails)
    throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        // retrieve user
        User user = authenticationService.getUser(token);
        // place the order
        orderService.placeOrder(user, basketId, userDetails);
        return new ResponseEntity<>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
    }

    // get all orders
    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(@RequestHeader("token") String token) throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        // retrieve user
        User user = authenticationService.getUser(token);
        // get orders
        List<Order> orderDtoList = orderService.listOrders(user);

        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }


    // get orderitems for an order
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Integer id, @RequestHeader("token") String token)
            throws AuthenticationFailException {
        // validate token
        authenticationService.authenticate(token);
        try {
            Order order = orderService.getOrder(id);
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        catch (OrderNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

}
