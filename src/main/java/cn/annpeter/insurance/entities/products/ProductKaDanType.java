package cn.annpeter.insurance.entities.products;

import javax.persistence.*;

/**
 * Created by annpeter on 3/16/16.
 */
@Entity(name = "jt_p_kadan_type")
public class ProductKaDanType {
    @Id
    Integer id;

    @ManyToOne( cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    ProductKaDan productKaDan;

    Integer price;

    @Column(length = 45)
    String type_detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductKaDan getProductKaDan() {
        return productKaDan;
    }

    public void setProductKaDan(ProductKaDan productKaDan) {
        this.productKaDan = productKaDan;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType_detail() {
        return type_detail;
    }

    public void setType_detail(String type_detail) {
        this.type_detail = type_detail;
    }


}
