package com.kidzoo.toydetails.service;


import com.kidzoo.toydetails.configuration.MessageStrings;
import com.kidzoo.toydetails.exception.AuthenticationFailException;
import com.kidzoo.toydetails.model.AuthenticationToken;
import com.kidzoo.toydetails.model.BasketId;
import com.kidzoo.toydetails.model.Cart;
import com.kidzoo.toydetails.model.User;
import com.kidzoo.toydetails.repository.BasketIdRepository;
import com.kidzoo.toydetails.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketIdService {

    @Autowired
    BasketIdRepository repository;


    public void saveBasketId(BasketId basketId) {
        repository.save(basketId);
    }

    public BasketId getBasketId(Cart cart) {
        return repository.findBasketIdByCart(cart);
    }


    public Cart getCart(String basketId) {
        BasketId basketId1 = repository.findBasketIdByBasketId(basketId);
        if (Helper.notNull(basketId1)) {
            if (Helper.notNull(basketId1.getCart())) {
                return basketId1.getCart();
            }
        }
        return null;
    }

    public void authenticate(String basketId) throws AuthenticationFailException {
        if (!Helper.notNull(basketId)) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_PRESENT);
        }
        if (!Helper.notNull(getCart(basketId))) {
            throw new AuthenticationFailException(MessageStrings.AUTH_TOEKN_NOT_VALID);
        }
    }

}
