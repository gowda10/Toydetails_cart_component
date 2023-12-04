package com.kidzoo.toydetails.client.entity;

import lombok.*;
import java.util.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class ToyDetailsCart {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(targetEntity = ToyDetailsEntity.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "b_id", referencedColumnName = "id")
    private List<ToyDetailsEntity> toyDetailsEntities;
}