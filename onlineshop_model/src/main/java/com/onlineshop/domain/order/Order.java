package com.onlineshop.domain.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "tb_order")
@Getter
@Setter
@DynamicInsert(true)
@DynamicUpdate(true)
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    private String orderId;

    private String userId;

    /**
     * 商品总价
     */
    private double totalPrice;

    /**
     * 创建日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.sql.Timestamp createdTime;

    /**
     * 订单状态
     */
    private String state;
    /**
     * 所属购物车
     */
    private String shoppingCarId;
    /**
     * 是否可见
     */
    private Long isShow;

    /**
     * 订单中所有商品信息
     */
    @OneToMany(mappedBy = "orderId")
    private Set<OrderProductsInfo> orderProductsInfos;
}
