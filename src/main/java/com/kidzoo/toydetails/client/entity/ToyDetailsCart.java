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
public class ToyDetailsCart {
    @Id
    /*@Column(name = "B_ID")
    private int b_id;*/
    @Column(name = "ID")
    private int id;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "NAME")
    private String name;
    }