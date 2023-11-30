package com.kidzoo.toydetails.client.entity;

import com.kidzoo.toydetails.client.ToyDetailsCartClient;
import com.kidzoo.toydetails.client.ToyDetailsCheckoutClient;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="TOY_DETAILS_CHECKOUT")
@Entity
@Getter
@Setter
@ToString

public class ToyDetailsCheckout {
        @Id
        @Column(name = "ID")
        private int id;
        @Column(name = "B_ID")
        private int b_id;
        @Column(name = "PRICE")
        private BigDecimal price;
        @Column(name = "NAME")
        private String name;
        @Column(name = "QUANTITY")
        private BigDecimal quantity;
        @Column(name = "TOTAL")
        private  BigDecimal total;
}
