package com.kidzoo.toydetails.repository;


import com.kidzoo.toydetails.model.AuthenticationToken;
import com.kidzoo.toydetails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findTokenByUser(User user);
    AuthenticationToken findTokenByToken(String token);
}
