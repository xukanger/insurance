package cn.annpeter.insurance.entities.products;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by annpeter on 3/14/16.
 */
@Entity(name = "jt_p_kadan")
public class ProductKaDan{
    @Id
    @GeneratedValue
    Integer id;

    @OneToOne(cascade= CascadeType.ALL)
    Product product;

    @Column(length = 45)
    String name;

    @Column(length = 45)
    String description;

    Integer price;

    String summary;

    String img_small;

    String img_big;

    @Column(length = 45)
    String card_cate;

    @Column(length = 45)
    String conditions;

    @Column(length = 45)
    String detail;

    @Column(length = 45)
    String card_range;

    @Column(length = 45)
    String info;

    @Column(length = 45)
    String after_sale_service;

    @Column(length = 45)
    String form_detail;

//    @OneToMany( targetEntity = ProductKaDanType.class,
//                mappedBy = "productKaDan",
//                cascade=CascadeType.ALL,
//                fetch = FetchType.EAGER)
//    private Set<ProductKaDanType> productKaDanTypes;


    public ProductKaDan() {
        //如果这里不初始化,当使用strtus提交表单对ProductKaDan进行初始化时,这里会为空.
        if(product == null){
            product = new Product();
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public String getImg_small() {
        return img_small;
    }

    public void setImg_small(String img_small) {
        this.img_small = img_small;
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

    @Override
    public String toString() {
        return "ProductKaDan{" +
                "id=" + id +
                ", product=" + product +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", summary='" + summary + '\'' +
                ", img_small='" + img_small + '\'' +
                ", img_big='" + img_big + '\'' +
                ", card_cate='" + card_cate + '\'' +
                ", conditions='" + conditions + '\'' +
                ", detail='" + detail + '\'' +
                ", card_range='" + card_range + '\'' +
                ", info='" + info + '\'' +
                ", after_sale_service='" + after_sale_service + '\'' +
                ", form_detail='" + form_detail + '\'' +
                '}';
    }
}
