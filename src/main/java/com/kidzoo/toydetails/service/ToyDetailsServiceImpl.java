package com.kidzoo.toydetails.service;

import com.kidzoo.toydetails.client.InventoryClient;
import com.kidzoo.toydetails.client.ToyDetailsCartClient;
import com.kidzoo.toydetails.client.entity.ToyDetailsCart;
import com.kidzoo.toydetails.client.ToyDetailsClient;

import com.kidzoo.toydetails.client.entity.ToyDetailsEntity;
import com.kidzoo.toydetails.exception.ToyDetailsCustomException;
import com.kidzoo.toydetails.model.response.ToyDetailsBasketResponse;
import com.kidzoo.toydetails.model.response.ToyDetailsResponse;
import com.kidzoo.toydetails.model.response.ToyStatusById;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ToyDetailsServiceImpl {
    @Autowired
    private ToyDetailsClient toyDetailsClient;
    @Autowired
    private InventoryClient inventoryClient;
    @Autowired
    private ToyDetailsCartClient toyDetailsCartClient;
    String referenceId = UUID.randomUUID().toString();

    public ToyDetailsResponse getToyDetails() {
        ToyDetailsResponse toyDetailsResponse = new ToyDetailsResponse();
        try {
            toyDetailsResponse.setToyDetailsList(toyDetailsClient.findAll());
        } catch (Exception exception) {
            throw new ToyDetailsCustomException(referenceId, exception.getMessage(), "400");
        }
        return toyDetailsResponse;
    }

    public ToyDetailsResponse getToyDetailsBasedOnPriceRange(String priceRange_1, String priceRange_2) {
        ToyDetailsResponse toyDetailsResponse = new ToyDetailsResponse();
        try {
            List<ToyDetailsEntity> getToyDetails = toyDetailsClient.findAll();
            toyDetailsResponse.setToyDetailsList(getToyDetails
                    .stream().filter(s -> s.getPrice().compareTo(new BigDecimal(priceRange_1)) >= 0
                            && s.getPrice().compareTo(new BigDecimal(priceRange_2)) <= 0)
                    .collect(Collectors.toList()));
        } catch (Exception exception) {
            throw new ToyDetailsCustomException(referenceId, exception.getMessage(), "400");
        }
        return toyDetailsResponse;
    }

    public ToyStatusById getToyStatusById(int toyId) {
        ToyStatusById toyStatusById ;
        try {
            toyStatusById = inventoryClient.findToyFromInventoryById(toyId);
        } catch (Exception exception) {
            throw new ToyDetailsCustomException(referenceId, exception.getMessage(), "400");
        }
        return toyStatusById;
    }

    public List<ToyStatusById> getListOfToysByStatus(String status) {
        try{
            return inventoryClient.getToyListFromInventoryByStatus(status);
        }catch (Exception exception) {
            throw new ToyDetailsCustomException(referenceId, exception.getMessage(), "400");
        }
    }
    public ToyDetailsBasketResponse getListOfToysInBasket() {
        ToyDetailsBasketResponse toyDetailsBasketResponse = new ToyDetailsBasketResponse();
        try {
            toyDetailsBasketResponse.setToyDetailsCartList(toyDetailsCartClient.findAll());
        } catch (Exception exception) {
            throw new ToyDetailsCustomException(referenceId, exception.getMessage(), "400");
        }
        return toyDetailsBasketResponse;
    }
}
