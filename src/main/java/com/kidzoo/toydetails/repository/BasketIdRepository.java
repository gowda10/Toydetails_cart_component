package com.kidzoo.toydetails.repository;


import com.kidzoo.toydetails.model.BasketId;
import com.kidzoo.toydetails.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketIdRepository extends JpaRepository<BasketId, Integer> {

    BasketId findBasketIdByCart(Cart cart);

    BasketId findBasketIdByBasketId(String basketId);
}
