package com.onlineshop.domain.shoppingcar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "tb_product_in_shopping_car")
@Getter
@Setter
@DynamicInsert(true)
@DynamicUpdate(true)
@NoArgsConstructor
public class ProductInfoInShoppingCar implements Serializable {

    @Id
    private String id;
    private Long productId;
    private String carId;
    private Long account;

    @Override
    public boolean equals(Object o) {
        ProductInfoInShoppingCar p = (ProductInfoInShoppingCar) o;
        System.out.println("运行equals(Object o)========"+this.account +"=============");
        return p.getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        System.out.println("运行hashCode()========"+this.id +"=============");
        System.out.println(this);
        return 10;
    }

    @Override
    public String toString() {
        return "ProductInfoInShoppingCar{" +
                "id='" + id + '\'' +
                ", name='" + account + '\'' +
                '}';
    }

}
