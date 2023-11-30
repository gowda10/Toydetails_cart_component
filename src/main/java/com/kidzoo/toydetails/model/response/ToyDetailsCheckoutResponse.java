package com.kidzoo.toydetails.model.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.kidzoo.toydetails.client.entity.ToyDetailsCart;
import com.kidzoo.toydetails.client.entity.ToyDetailsCheckout;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data

public class ToyDetailsCheckoutResponse {
    @ApiModelProperty("List of Toys For Checkout")
    private List<ToyDetailsCheckout> toyDetailsCheckoutList;
}
