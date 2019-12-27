package com.onlineshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 17:53
 * @Version 1.0
 * @Description
 **/
public interface ProductInfoInShoppingCarDao extends JpaRepository<com.onlineshop.domain.shoppingcar.ProductInfoInShoppingCar,String>, JpaSpecificationExecutor<com.onlineshop.domain.shoppingcar.ProductInfoInShoppingCar> {
    ProductInfoInShoppingCarDao findByCarIdAndProductId(String carId, Long productId);
}
