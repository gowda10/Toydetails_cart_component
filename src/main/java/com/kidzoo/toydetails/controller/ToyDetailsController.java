package com.kidzoo.toydetails.controller;

import com.kidzoo.toydetails.client.ToyDetailsCartClient;
import com.kidzoo.toydetails.client.ToyDetailsClient;
import com.kidzoo.toydetails.client.entity.ToyDetailsCart;
import com.kidzoo.toydetails.client.entity.ToyDetailsCheckout;
import com.kidzoo.toydetails.client.entity.ToyDetailsEntity;
import com.kidzoo.toydetails.dto.OrderRequest;
import com.kidzoo.toydetails.model.response.ToyDetailsBasketResponse;
import com.kidzoo.toydetails.model.response.ToyDetailsCheckoutResponse;
import com.kidzoo.toydetails.model.response.ToyDetailsResponse;
import com.kidzoo.toydetails.service.ToyDetailsServiceImpl;
import com.kidzoo.toydetails.exception.Error;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Api(tags = "ToyDetails")
@RestController
@RequestMapping(value = "/v1")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RequiredArgsConstructor
public class ToyDetailsController {
    @Autowired
    ToyDetailsServiceImpl toyDetailsService;

    @Autowired
    ToyDetailsCartClient toyDetailsCartClient;

    @Autowired
    ToyDetailsClient toyDetailsClient;


    @ApiOperation(value = "This API will add toys to database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsBasketResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @PostMapping(value = "/add-toy", produces = "application/hal+json")
    public ToyDetailsEntity addToy(@RequestBody ToyDetailsEntity toyDetailsEntity){return toyDetailsService.saveToy(toyDetailsEntity);}


    @ApiOperation(value = "This API will retrieve list of all toys from database")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ToyDetailsResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @GetMapping(value = "/get-list-of-toys", produces = "application/hal+json")
    public List<ToyDetailsEntity> getToys(){
        return toyDetailsService.getToys();
    }


    @ApiOperation(value = "This API will retrieve list of all toys with their price range from database")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ToyDetailsResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @GetMapping(value = "/get-list-of-toys/byPrice", produces = "application/hal+json")
    public ToyDetailsResponse getToyDetailsBasedOnPriceRange(
            @NotNull @NotEmpty @ApiParam(value = "This is value of price range 1", required = true) @RequestParam(value = "price_range1") String price_range1,
            @NotNull @NotEmpty @ApiParam(value = "This is value of price range 2", required = true) @RequestParam(value = "price_range2") String price_range2){
        return toyDetailsService.getToyDetailsBasedOnPriceRange(price_range1,price_range2);
    }

    @ApiOperation(value = "This API will update the toys in Database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsBasketResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @PutMapping(value = "/update-toy", produces = "application/hal+json")
    public ToyDetailsEntity updateToy(@RequestBody ToyDetailsEntity toyDetailsEntity){return toyDetailsService.updateToy(toyDetailsEntity);}

    @ApiOperation(value = "This API will delete the toy in the Database by Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsBasketResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @DeleteMapping(value = "/delete-toy/{id}", produces = "application/hal+json")
    public String deleteToy(@PathVariable int id){return toyDetailsService.deleteToy(id);}




    @ApiOperation(value = "This API will add toys to the Basket")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsBasketResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @PostMapping(value = "/add-toys-to-basket", produces = "application/hal+json")
    public ToyDetailsCart addToCart(@RequestBody OrderRequest request){return toyDetailsCartClient.save(request.getCart());}


    @ApiOperation(value = "This API will get the list of toys in the Basket by Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsBasketResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @GetMapping(value = "/view-basket", produces = "application/hal+json")
    public List<ToyDetailsCart> getToysByIdInCart(){return toyDetailsService.getToysInCart();}

    @ApiOperation(value = "This API will update the list of toys in the Basket")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsBasketResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @PutMapping(value = "/update-from-basket", produces = "application/hal+json")
    public ToyDetailsEntity updateCart(@RequestBody ToyDetailsEntity toyDetailsEntity){return toyDetailsService.updateCart(new ToyDetailsEntity());}

    @ApiOperation(value = "This API will delete the Basket by Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsBasketResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @DeleteMapping(value = "/delete-basket/{id}", produces = "application/hal+json")
    public String deleteToyFromCart(@PathVariable UUID id){return toyDetailsService.deleteToyFromCart(id);}

    @ApiOperation(value = "This API will get the list of toys for checkout")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsCheckoutResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @GetMapping(value = "/checkout-details", produces = "application/hal+json")
    public List<ToyDetailsCheckout> getToyDetailsCheckout(){return toyDetailsService.getToyDetailsCheckout();}

    @ApiOperation(value = "This API will add list of toys to Checkout")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsCheckoutResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @PostMapping(value = "/add-list-of-toys-to-checkout", produces = "application/hal+json")
    public List<ToyDetailsCheckout> saveCheckoutList(@RequestBody List<ToyDetailsCheckout> toyDetailsCheckoutList){return toyDetailsService.saveCheckoutList(toyDetailsCheckoutList);}

}
