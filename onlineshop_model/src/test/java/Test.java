import java.util.*;

/**
 * @Author CrystalLight
 * @Date 2019/12/25 15:40
 * @Version 1.0
 * @Description
 **/

public class Test {


    @org.junit.Test
    public void ff(){
        ShoppingCarInfo product0 = new ShoppingCarInfo("1", "啊啊");
        ShoppingCarInfo product1 = new ShoppingCarInfo("1", "啊啊");
        ShoppingCarInfo product2 = new ShoppingCarInfo("3", "啊啊啊");
        ShoppingCarInfo product3 = new ShoppingCarInfo("4", "啊啊啊啊");
        ShoppingCarInfo product4 = new ShoppingCarInfo("5", "啊啊啊啊啊");
        ShoppingCarInfo product5 = new ShoppingCarInfo("6", "啊啊啊啊啊啊");
// Product product0 = new Product(1,"张三","1");
//        Product product1 = new Product(1,"张三","2");
//        Product product2 = new Product(1,"张三","3");
//        Product product3 = new Product(1,"订单三");
//        Product product4 = new Product(2,"订单三");
//        Product product5 = new Product(2,"张三");

//        Map<Product,Integer> map = new HashMap<>();
//        map.put(product0,0);
//        map.put(product1,1);
//
//        System.out.println("=======================");
//        System.out.println(map.get(product0));
//        System.out.println(map.get(product1));

//        Map<String,Integer> s = new HashMap<>();
//
//        String y = "wo";
//        String y1 = new String("wo");
//        System.out.println(y == y1);
//        s.put("wo",10);
//        s.put("wo",15);
//
//        System.out.println("sss"+s.get("wo"));
//
////        map.get(product2);

//
//        Set<Product> set = new HashSet<>();
//        set.add(product0);
//        set.add(product1);
//        set.add(product2);
//        set.add(product2);
//        set.add(product2);
//        set.add(product2);
//        set.add(product3);
        Set<ShoppingCarInfo> set = new HashSet<>();
        set.add(product0);
        set.add(product1);
        set.add(product2);
        set.add(product2);
        set.add(product2);
        set.add(product2);
        set.add(product3);

        for (ShoppingCarInfo p:set
             ) {
            System.out.println(p);
        }

    }
}
