package com.kidzoo.toydetails.client;


import com.kidzoo.toydetails.client.entity.ToyDetailsCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface ToyDetailsCartClient extends JpaRepository<ToyDetailsCart, Integer> {

}
