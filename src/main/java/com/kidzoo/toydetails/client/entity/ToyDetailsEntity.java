package com.kidzoo.toydetails.client.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="TOY_DETAILS")
@Entity
@Getter
@Setter
@ToString
public class ToyDetailsEntity {
    @Id
    @GeneratedValue()
    private int id;
    private String name;
    private BigDecimal price;
    private String age;
    private String imageURL;
    private String status;
}
