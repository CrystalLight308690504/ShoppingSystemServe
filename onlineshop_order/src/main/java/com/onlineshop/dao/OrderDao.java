package com.onlineshop.dao;

import com.onlineshop.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 17:53
 * @Version 1.0
 * @Description
 **/
public interface OrderDao extends JpaRepository<Order,String>, JpaSpecificationExecutor<Order> {
    Order findByOrderId(String orderId);
    Order findByOrderIdAndIsShow(String orderId,Long isShow);
}
