package com.onlineshop.controller;

import com.onlineshop.domain.order.Order;
import com.onlineshop.entity.PageResult;
import com.onlineshop.entity.Result;
import com.onlineshop.entity.ResultCode;
import com.onlineshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 16:48
 * @Version 1.0
 * @Description
 **/
@CrossOrigin
@RestController
@RequestMapping("/shop/order")
public class OrderController extends BaseController {

    @Autowired
    OrderService orderService;

    /**
     * 添加订单
     *
     * @return
     */
    @PostMapping(value = "/save")
    public Result save(@RequestBody Order order) {
        // 设置提交订单用户id
        order.setUserId(this.getUserId());
        orderService.save(order);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 更新订单
     *
     * @return
     */
    @RequestMapping(value = "/update")
    public Result update(@RequestBody Order order) {
        orderService.update(order);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 删除订单
     *
     * @return
     */
    @DeleteMapping(value = "/delete/{orderId}")
    public Result deleteByOrderId(@PathVariable() String orderId) {
        orderService.deleteByOrderId(orderId);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据用户id查找所有订单
     *
     * @return
     */
    @GetMapping(value = "/findByUserId")
    public Result findOneUserById(String userId, @RequestParam(name = "page", required = true) int page, @RequestParam(name = "size", required = true) int size) {

        Page<Order> pageOrders = orderService.findAllByUserId(userId, page, size);
        // 返回结果
        PageResult pageResult = new PageResult(pageOrders.getTotalElements(), pageOrders.getContent());
        return new Result(ResultCode.SUCCESS, pageResult);

    }

    /**
     * 根据订单id查找订单
     *
     * @return
     */
    @GetMapping(value = "/findByOrderId/{orderId}")
    public Result findOneByOrderId(@PathVariable() String orderId) {

        Order order = orderService.findOneByOrderId(orderId);
        return new Result(ResultCode.SUCCESS, order);
    }

}
