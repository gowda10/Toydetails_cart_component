package com.kidzoo.toydetails.client;

import com.kidzoo.toydetails.client.entity.ToyDetailsCart;
import com.kidzoo.toydetails.client.entity.ToyDetailsCheckout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ToyDetailsCheckoutClient extends JpaRepository<ToyDetailsCheckout, String> {
    }
