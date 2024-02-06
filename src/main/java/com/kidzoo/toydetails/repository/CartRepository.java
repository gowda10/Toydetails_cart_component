package com.kidzoo.toydetails.repository;

import com.kidzoo.toydetails.model.Cart;
import com.kidzoo.toydetails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    List<Cart> deleteByUser(User user);

    void deleteByBasketIdAndUser(UUID basketId, User user);
}

