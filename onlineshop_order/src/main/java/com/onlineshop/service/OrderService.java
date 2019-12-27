package com.onlineshop.service;

import com.onlineshop.dao.OrderDao;
import com.onlineshop.dao.OrderInfoDao;
import com.onlineshop.domain.order.Order;
import com.onlineshop.domain.order.OrderProductsInfo;
import com.onlineshop.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 17:51
 * @Version 1.0
 * @Description
 **/

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderInfoDao orderInfoDao;
    @Autowired
    IdWorker idWorker;

    /**
     * 添加订单
     *
     * @return
     */
    public void save(Order order) {
        String orderId = idWorker.nextId() + "";
        // 设置订单id
        order.setOrderId(orderId);
        Set<OrderProductsInfo> productsInfos = order.getOrderProductsInfos();

        for (OrderProductsInfo info : productsInfos) {
            info.setId(idWorker.nextId() + "");
            info.setOrderId(orderId);
        }
        orderDao.save(order);
    }

    /**
     * 更新订单
     *
     * @return
     */
    public void update(Order order) {
        Order orderTarget = orderDao.findById(order.getOrderId()).get();
        BeanUtils.copyProperties(order, orderTarget);
        orderDao.save(orderTarget);
    }

    /**
     * 删除订单,将订单与用户取消关联
     *
     * @return
     */
    public void deleteByOrderId(String orderId) {
        Order order = orderDao.findByOrderId(orderId);
        order.setIsShow(0L);
        orderDao.save(order);
    }

    /**
     * 根据id查找订单
     *
     * @param orderId
     * @return
     */
    public Order findOneByOrderId(String orderId) {

        return orderDao.findByOrderId(orderId);
    }

    /**
     * 查找指定用户的所有订单
     *
     * @return
     */
    public Page findAllByUserId(final String userId, int page, int size) {
        Specification<Order> spec = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (!StringUtils.isEmpty(userId)) {
                    predicates.add(criteriaBuilder.equal(root.get(userId).as(String.class), userId));
                }
                // 查看可显示的订单
                predicates.add(criteriaBuilder.equal(root.get("isShow").as(Long.class), 1));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        Page<Order> pageUser = orderDao.findAll(spec, PageRequest.of(page - 1, size));
        return pageUser;

    }
}
