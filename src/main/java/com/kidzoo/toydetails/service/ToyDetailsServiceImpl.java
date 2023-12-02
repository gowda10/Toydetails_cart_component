package com.kidzoo.toydetails.service;

import com.kidzoo.toydetails.client.ToyDetailsCartClient;
import com.kidzoo.toydetails.client.ToyDetailsCheckoutClient;
import com.kidzoo.toydetails.client.entity.ToyDetailsCart;
import com.kidzoo.toydetails.client.ToyDetailsClient;

import com.kidzoo.toydetails.client.entity.ToyDetailsCheckout;
import com.kidzoo.toydetails.client.entity.ToyDetailsEntity;
import com.kidzoo.toydetails.exception.ToyDetailsCustomException;
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
    private ToyDetailsCartClient toyDetailsCartClient;

    @Autowired
    private ToyDetailsCheckoutClient toyDetailsCheckoutClient;
    String referenceId = UUID.randomUUID().toString();





    public ToyDetailsEntity saveToy(ToyDetailsEntity toyDetailsEntity){
        return toyDetailsClient.save(toyDetailsEntity);
    }

    public List<ToyDetailsEntity> getToys(){
        return toyDetailsClient.findAll();
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

    public String deleteToy(int id){
        toyDetailsClient.deleteById(id);
        return id +" Has been removed";
    }

    public ToyDetailsEntity updateToy(ToyDetailsEntity toyDetailsEntity){
        ToyDetailsEntity existingToy=toyDetailsClient.findById(toyDetailsEntity.getId()).orElse(null);
        existingToy.setName(toyDetailsEntity.getName());
        existingToy.setPrice(toyDetailsEntity.getPrice());
        existingToy.setAge(toyDetailsEntity.getAge());
        existingToy.setImageURL(toyDetailsEntity.getImageURL());
        existingToy.setStatus(toyDetailsEntity.getStatus());
        return toyDetailsClient.save(existingToy);
    }
    public ToyDetailsCart saveCart(ToyDetailsCart toyDetailsCart){
       return toyDetailsCartClient.save(toyDetailsCart);
    }

    public ToyDetailsCart getToysInCart(int B_id){
        return toyDetailsCartClient.findById(B_id).orElse(null);
    }

    public String deleteToyFromCart(int B_id){
        toyDetailsCartClient.deleteById(B_id);
        return B_id +" Has been removed";
    }

    public ToyDetailsCart updateCart(ToyDetailsCart toyDetailsCart){
        ToyDetailsCart existingToy=toyDetailsCartClient.findById(toyDetailsCart.getB_id()).orElse(null);
        existingToy.setName(toyDetailsCart.getName());
        existingToy.setPrice(toyDetailsCart.getPrice());
        existingToy.setQuantity(toyDetailsCart.getQuantity());
        return toyDetailsCartClient.save(existingToy);
    }

    public List<ToyDetailsCheckout> getToyDetailsCheckout(){
        return toyDetailsCheckoutClient.findAll();
    }

    public List<ToyDetailsCheckout> saveCheckoutList(List<ToyDetailsCheckout> toyDetailsCheckoutList){
        return toyDetailsCheckoutClient.saveAll(toyDetailsCheckoutList);
    }

}
