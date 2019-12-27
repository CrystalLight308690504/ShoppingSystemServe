import java.util.Objects;


public class Product implements Comparable{

  private int id;
  private String name;
  private String code ;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(int id, String name,String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        Product oj = (Product) o;
    System.out.println("运行equals方法=========》》》》》》" + this.name);
    if(oj.getName().equals(this.name)){
        return true;
    }else {
        return false;
    }

  }

  @Override
  public int hashCode() {
      System.out.println("运行hashCode()方法=========》》》》》》" + this.name+"  code :" +this.id);
      return this.id;

  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Product oj = (Product) o;
        if(oj.getName().equals(this.name)){
            return 0;
        }else {
            return 1;
        }
    }
}
