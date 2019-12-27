package com.onlineshop.service;

import com.onlineshop.dao.ProductInfoInShoppingCarDao;
import com.onlineshop.dao.ShoppingCarDao;
import com.onlineshop.domain.shoppingcar.ProductInfoInShoppingCar;
import com.onlineshop.domain.shoppingcar.ShoppingCar;
import com.onlineshop.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @Author CrystalLight
 * @Date 2019/12/24 17:51
 * @Version 1.0
 * @Description
 **/

@Service
public class ShoppingCarService {

    @Autowired
    ShoppingCarDao shoppingDao;
    @Autowired
    ProductInfoInShoppingCarDao productInfoInShoppingCarDao;
    @Autowired
    IdWorker idWorker;

    /**
     * 更新购物车
     *
     * @param data   key 为要添加的商品的id value 为要添加的商品的个数
     * @param userId 用户购物车的id和用户的id相同
     * @return
     */
    public void save(Map<Long, Long> data, String userId) {

        // 根据用户id获取购物车
        ShoppingCar car = shoppingDao.findByCarId(userId);
        if (car == null) { // 没有购物车,添加
            car = new ShoppingCar();
            car.setCarId(userId);
            shoppingDao.save(car);
        }

        // 获得已在购车存在的商品
        Set<com.onlineshop.domain.shoppingcar.ProductInfoInShoppingCar> addedCarInfoExisteds = car.getProductInfoInShoppingCarProducts();
        if (addedCarInfoExisteds == null) {
            addedCarInfoExisteds = new HashSet<>();
        }

        // 浏览已在购车存在的商品
        for (com.onlineshop.domain.shoppingcar.ProductInfoInShoppingCar productInfoInShoppingCar : addedCarInfoExisteds) {

            Long productId = productInfoInShoppingCar.getProductId();
            boolean isExited = data.containsKey(productId); // 是否已经有该商品
            if (isExited) {// 如果存在 只增加数量
                productInfoInShoppingCar.setAccount(productInfoInShoppingCar.getAccount() + data.get(productId));
                data.remove(productId); // 删除添加的商品
                System.out.println("dada数据的个数：=====>>>>> " + data.size() + " <<<<============");
            }
        }

        // 添加没有的商品
        Set<Long> productIds = data.keySet();
        for (Long productId: productIds) {
            ProductInfoInShoppingCar shoppingCarInfoaAdd = new ProductInfoInShoppingCar();
            shoppingCarInfoaAdd.setId(idWorker.nextId() + "");
            shoppingCarInfoaAdd.setCarId(userId);
            shoppingCarInfoaAdd.setProductId(productId);
            shoppingCarInfoaAdd.setAccount(data.get(productId));
            // 添加到购物车
            addedCarInfoExisteds.add(shoppingCarInfoaAdd);
        }

        // 保存更新数据库
        shoppingDao.save(car);
    }


    /**
     * 购物车中的商品
     *
     * @return
     */
    public void delete(Set<Long> deletedProducted, String userId) {
        List<ProductInfoInShoppingCar> carProducts = productInfoInShoppingCarDao.findAll(getSpecification(userId, deletedProducted));

        // 浏览购物车中的所有商品
        for (ProductInfoInShoppingCar piisc : carProducts) {
            productInfoInShoppingCarDao.delete(piisc);
        }

        // 更新数据
    }

    /**
     * 查找指定用户的所有购物车
     *
     * @return
     */
    public ShoppingCar find(String userId) {

        // 根据用户id获取购物车
        ShoppingCar car = shoppingDao.findByCarId(userId);
        if (car == null) { // 没有购物车,添加
            car = new ShoppingCar();
            car.setCarId(userId);
            shoppingDao.save(car);
        }
        return car;
    }

    public List<com.onlineshop.domain.shoppingcar.ProductInfoInShoppingCar> text(Set<Long> deletedProducted, String userId){
        return productInfoInShoppingCarDao.findAll(getSpecification(userId, deletedProducted));

    }


    /**
     * 根据 用户id(购物车id) 和 产品id 查询购物车信息
     *
     * @param userId     用户id(购物车id)
     * @param productIds 所有要查询的产品id
     * @return
     */
    private Specification getSpecification(String userId, Set<Long> productIds) {
        return new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<>();

                // 连接根据查询购物车id
                Predicate equalCarId = cb.equal(root.get("carId").as(String.class), userId);
                list.add(equalCarId);

                // 连接根据产品Id条件
                CriteriaBuilder.In<Object> inCardId = cb.in(root.get("productId"));
                // 要添加的商品id

                for (Long productId : productIds) {
                    inCardId.value(productId);
                }
                list.add(inCardId);

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        };
    }

}
