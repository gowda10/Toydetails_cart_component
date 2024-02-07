package com.kidzoo.toydetails.controller;

import com.kidzoo.toydetails.common.ApiResponse;
import com.kidzoo.toydetails.dto.cart.AddToCartDto;
import com.kidzoo.toydetails.dto.cart.CartDto;
import com.kidzoo.toydetails.dto.cart.CartItemDto;
import com.kidzoo.toydetails.exception.AuthenticationFailException;
import com.kidzoo.toydetails.exception.CartItemNotExistException;
import com.kidzoo.toydetails.exception.ProductNotExistException;
import com.kidzoo.toydetails.model.Cart;
import com.kidzoo.toydetails.model.Product;
import com.kidzoo.toydetails.model.User;
import com.kidzoo.toydetails.service.AuthenticationService;
import com.kidzoo.toydetails.service.CartService;
import com.kidzoo.toydetails.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/toydetails/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<CartDto> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                 @RequestHeader("token") String token) throws AuthenticationFailException, ProductNotExistException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        Product product = productService.getProductById(addToCartDto.getProductId());
        System.out.println("product to add"+  product.getName());
        cartService.addToCart(addToCartDto, product, user);
        CartDto cartDto = cartService.listCartItem(user);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);

    }
    @GetMapping("/get-cartItems")
    public ResponseEntity<CartDto> getCartItems(@RequestHeader(value = "token") String token, @RequestHeader(value = "basketId") UUID basketId) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        CartDto cartDto = cartService.listCartItems(user, basketId);
        return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody @Valid CartItemDto cartDto,
                                                      @RequestHeader(value = "token") String token, @RequestHeader(value = "basketId") UUID basketId ) throws AuthenticationFailException,ProductNotExistException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.updateCartItem(cartDto, user);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteCartItem(@RequestHeader(value = "basketId") UUID basketId, @RequestHeader(value = "token") String token) throws AuthenticationFailException, CartItemNotExistException {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.deleteCartItemsByUser(user);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }

}
