package cn.annpeter.insurance.entities.products;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定义了在卡单list的时候需要用到的json对象
 * Created by annpeter on 3/15/16.
 */
@Component
public class JsonKaDanShow {
    Integer id;
    String card_name;
    Date card_desc;
    Integer card_price;
    String card_img_small;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public Date getCard_desc() {
        return card_desc;
    }

    public void setCard_desc(Date card_desc) {
        this.card_desc = card_desc;
    }

    public Integer getCard_price() {
        return card_price;
    }

    public void setCard_price(Integer card_price) {
        this.card_price = card_price;
    }

    public String getCard_img_small() {
        return card_img_small;
    }

    public void setCard_img_small(String card_img_small) {
        this.card_img_small = card_img_small;
    }



    public JsonKaDanShow(){}

    public JsonKaDanShow(Integer id, String card_name, Date card_desc, Integer card_price, String card_img_small) {
        this.id = id;
        this.card_name = card_name;
        this.card_desc = card_desc;
        this.card_price = card_price;
        this.card_img_small = card_img_small;
    }

    @Override
    public String toString() {
        return "JsonKaDanShow{" +
                "id=" + id +
                ", card_name='" + card_name + '\'' +
                ", card_desc='" + card_desc + '\'' +
                ", card_price=" + card_price +
                ", card_img_small='" + card_img_small + '\'' +
                '}';
    }
}
