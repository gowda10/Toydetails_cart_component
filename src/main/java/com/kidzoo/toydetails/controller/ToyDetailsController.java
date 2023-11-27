package com.kidzoo.toydetails.controller;

import com.kidzoo.toydetails.client.entity.ToyDetailsCart;
import com.kidzoo.toydetails.model.response.ToyDetailsBasketResponse;
import com.kidzoo.toydetails.model.response.ToyDetailsResponse;
import com.kidzoo.toydetails.model.response.ToyStatusById;
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

@Api(tags = "ToyDetails")
@RestController
@RequestMapping(value = "/v1")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RequiredArgsConstructor
public class ToyDetailsController {
    @Autowired
    ToyDetailsServiceImpl toyDetailsService;

    @ApiOperation(value = "This API will retrieve list of all toys from database")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ToyDetailsResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @GetMapping(value = "/get-list-of-toys", produces = "application/hal+json")
    public ToyDetailsResponse getToyDetails(){
        return toyDetailsService.getToyDetails();
    }


    @ApiOperation(value = "This API will retrieve list of all toys with thr price range from database")
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

    @ApiOperation(value = "This API will retrieve status of toy")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ToyStatusById.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @GetMapping(value = "/get-status-by-toyId/{toyId}", produces = "application/hal+json")
    public ToyStatusById getToyStatusById(
            @NotNull @NotEmpty @ApiParam(value = "This is value of toy id", required = true) @PathVariable(value = "toyId") int toyId){
        return toyDetailsService.getToyStatusById(toyId);
    }

   @ApiOperation(value = "This API will retrieve list of toy when queried with status")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ToyStatusById.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @GetMapping(value = "/find-toys-by-status", produces = "application/hal+json")
    public List<ToyStatusById> getToyListByStatus(
            @NotNull @NotEmpty @ApiParam(value = "This is status of toy", required = true
                    , allowableValues =  "available,backorder,outofstock") @RequestParam(value = "status") String status){
        return toyDetailsService.getListOfToysByStatus(status);
    }

    @ApiOperation(value = "This API will retrieve list of toys in the Basket")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ToyDetailsBasketResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method not allowed", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @GetMapping(value = "/find-toys-in-basket", produces = "application/hal+json")
    public ToyDetailsBasketResponse getListOfToysInBasket(){return toyDetailsService.getListOfToysInBasket();}
}
