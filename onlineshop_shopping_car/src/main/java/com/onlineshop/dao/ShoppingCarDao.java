package com.onlineshop.dao;

import com.onlineshop.domain.shoppingcar.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 17:53
 * @Version 1.0
 * @Description
 **/
public interface ShoppingCarDao extends JpaRepository<ShoppingCar,String>, JpaSpecificationExecutor<ShoppingCar> {

    ShoppingCar findByCarId(String carId);

}
