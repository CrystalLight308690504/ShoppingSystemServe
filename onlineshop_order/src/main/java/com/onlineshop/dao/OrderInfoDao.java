package com.onlineshop.dao;

import com.onlineshop.domain.order.OrderProductsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 17:53
 * @Version 1.0
 * @Description
 **/
public interface OrderInfoDao extends JpaRepository<OrderProductsInfo,String>, JpaSpecificationExecutor<OrderProductsInfo> {

    OrderProductsInfo findByOrderId(String orderId);
}
