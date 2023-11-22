package com.kidzoo.toydetails.client.entity;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "ID")
    private int id;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "AGE")
    private String age;
    @Column(name = "NAME")
    private String name;
    @Column(name = "IMAGEURL")
    private String imageURL;
    @Column(name = "Status")
    private String status;
}
