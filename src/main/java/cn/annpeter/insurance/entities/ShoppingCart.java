package cn.annpeter.insurance.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by annpeter on 3/19/16.
 */
@Entity(name = "jt_shoppingcart")
public class ShoppingCart {
    @Id
    Integer id;

    Integer member_id;

    Integer product_id;

    Integer num;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
