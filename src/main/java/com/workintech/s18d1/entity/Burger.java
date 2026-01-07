package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="burger",schema = "fsweb")
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "burger_name")
    private String name;

    @Column(name = "burger_price")
    private double price;

    @Column(name = "burger_isvegan" )
    private boolean isVegan;

    @Column(name = "burger_breadType")
    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column(name = "burger_contents")
    private String contents;

}
