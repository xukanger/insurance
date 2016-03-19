package cn.annpeter.insurance.entities.jsonBeans.app.kadan;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定义了在卡单list的时候需要用到的json对象
 * Created by annpeter on 3/15/16.
 */
@Component
public class JsonResKaDanList {
    Integer id;
    String name;
    String description;
    Integer price;
    String img_small;
    public JsonResKaDanList(){}

    public JsonResKaDanList(Integer id, String name, String description, Integer price, String img_small) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img_small = img_small;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg_small() {
        return img_small;
    }

    public void setImg_small(String img_small) {
        this.img_small = img_small;
    }


    @Override
    public String toString() {
        return "JsonKaDanShow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", img_small='" + img_small + '\'' +
                '}';
    }
}
