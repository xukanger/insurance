package cn.annpeter.insurance.entities.jsonBeans.app.kadan;

import javax.persistence.CascadeType;
/**
 * Created by annpeter on 3/19/16.
 */
public class JsonResKaDanProfile {

    Integer id;

    String name;

    String description;

    Integer price;

    String summary;

    String img_big;

    String card_cate;

    String conditions;

    String detail;

    String card_range;

    String info;

    String after_sale_service;

    String form_detail;

    String product__supplier__title;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImg_big() {
        return img_big;
    }

    public void setImg_big(String img_big) {
        this.img_big = img_big;
    }

    public String getCard_cate() {
        return card_cate;
    }

    public void setCard_cate(String card_cate) {
        this.card_cate = card_cate;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCard_range() {
        return card_range;
    }

    public void setCard_range(String card_range) {
        this.card_range = card_range;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAfter_sale_service() {
        return after_sale_service;
    }

    public void setAfter_sale_service(String after_sale_service) {
        this.after_sale_service = after_sale_service;
    }

    public String getForm_detail() {
        return form_detail;
    }

    public void setForm_detail(String form_detail) {
        this.form_detail = form_detail;
    }

    public String getProduct__supplier__title() {
        return product__supplier__title;
    }

    public void setProduct__supplier__title(String product__supplier__title) {
        this.product__supplier__title = product__supplier__title;
    }
}
