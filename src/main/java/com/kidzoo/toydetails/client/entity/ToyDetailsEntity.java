package com.kidzoo.toydetails.client.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class ToyDetailsEntity {
    @Id
    private int id;
    private String name;
    private BigDecimal price;
    private String quantity;
}
