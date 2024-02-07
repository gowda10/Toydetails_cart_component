package com.kidzoo.toydetails.repository;


import com.kidzoo.toydetails.model.BankDetails;
import com.kidzoo.toydetails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Integer> {

    BankDetails findByUser(User user);

}