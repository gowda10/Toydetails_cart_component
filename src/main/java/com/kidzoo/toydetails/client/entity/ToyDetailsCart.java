package com.kidzoo.toydetails.client.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="TOY_DETAILS_BASKET")
@Entity
@Getter
@Setter
@ToString
public class ToyDetailsCart {

    @Id
    @GeneratedValue()
    private int b_id;
    private String name;
    private BigDecimal price;
    private BigDecimal quantity;

    }