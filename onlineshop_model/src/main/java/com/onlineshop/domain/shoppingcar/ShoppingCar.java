package com.onlineshop.domain.shoppingcar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tb_shopping_car")
@Getter
@Setter
@DynamicInsert(true)
@DynamicUpdate(true)
@NoArgsConstructor
public class ShoppingCar implements Serializable {

    @Id
    private String carId;

    @OneToMany(mappedBy = "carId",cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
        private Set<ProductInfoInShoppingCar> productInfoInShoppingCarProducts;
    }
