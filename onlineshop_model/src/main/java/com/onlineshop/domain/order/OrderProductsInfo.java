package com.onlineshop.domain.order;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author CrystalLight
 * @Date 2019/12/26 15:56
 * @Version 1.0
 * @Description
 **/

@Entity
@Table(name = "tb_product_info_in_order")
@Getter
@Setter
@DynamicInsert(true)
@DynamicUpdate(true)
public class OrderProductsInfo {

    @Id
    private String id;
    private String orderId;
    private long productId;
    private long total;

}
