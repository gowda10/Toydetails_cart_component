package com.kidzoo.toydetails.dto;

import com.kidzoo.toydetails.client.entity.ToyDetailsCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

    private ToyDetailsCart cart;
}
