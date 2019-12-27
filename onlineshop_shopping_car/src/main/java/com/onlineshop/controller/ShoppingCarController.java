package com.onlineshop.controller;

import com.onlineshop.domain.shoppingcar.ShoppingCar;
import com.onlineshop.entity.Result;
import com.onlineshop.entity.ResultCode;
import com.onlineshop.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 16:48
 * @Version 1.0
 * @Description
 **/
@CrossOrigin
@RestController
@RequestMapping("/shoppingCar")
public class ShoppingCarController extends BaseController {

    @Autowired
    ShoppingCarService shoppingCarService;

    /**
     * 更新购物车
     *
     * @return
     */
    @PutMapping(value = "/update/{userId}")
    public Result update(@RequestBody Map<Long, Long> productIds, @PathVariable String userId) {

        shoppingCarService.save(productIds, userId);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 删除购物车商品
     *
     * @param deletedProducted 要删除的商品
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/delete/{userId}")
    public Result delete(@RequestBody Set<Long> deletedProducted, @PathVariable String userId) {
        shoppingCarService.delete(deletedProducted, userId);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 根据用户id查找所有购物车
     *
     * @return
     */
    @GetMapping(value = "/find/{userId}")
    public Result findById(@PathVariable String userId) {
        ShoppingCar shoppingCar = shoppingCarService.find(userId);
        return new Result(ResultCode.SUCCESS, shoppingCar);
    }
}
