import javax.persistence.Id;
import java.io.Serializable;



public class ShoppingCarInfo implements Serializable {

    private String id;
    private String productId;
    private String name;
    private String carId;
    private long account;

    public ShoppingCarInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("运行equals(Object o)========"+this.name +"=============");
        return true;
    }

    @Override
    public int hashCode() {
        System.out.println("运行hashCode()========"+this.id +"=============");
        return Integer.valueOf(this.id);
    }

    @Override
    public String toString() {
        return "ProductInfoInShoppingCar{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
