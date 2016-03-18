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
    String card_name;

    @Column(length = 45)
    String card_desc;

    Integer card_price;

    String card_img_small;

    String card_img_big;

    @Column(length = 45)
    String card_buy_type;

    @Column(length = 45)
    String card_cate;

    @Column(length = 45)
    String conditions;

    @Column(length = 45)
    String card_detail;

    @Column(length = 45)
    String card_range;

    @Column(length = 45)
    String card_info;

    @Column(length = 45)
    String after_sale_service;

    @Column(length = 45)
    String card_form_detail;

    @OneToMany( targetEntity = ProductKaDanType.class,
                mappedBy = "productKaDan",
                cascade=CascadeType.ALL,
                fetch = FetchType.EAGER)
    private Set<ProductKaDanType> productKaDanTypes;

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

    public void setProduct(Product product_id) {
        this.product = product;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getCard_desc() {
        return card_desc;
    }

    public void setCard_desc(String card_desc) {
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

    public String getCard_img_big() {
        return card_img_big;
    }

    public void setCard_img_big(String card_img_big) {
        this.card_img_big = card_img_big;
    }

    public String getCard_buy_type() {
        return card_buy_type;
    }

    public void setCard_buy_type(String card_buy_type) {
        this.card_buy_type = card_buy_type;
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

    public String getCard_detail() {
        return card_detail;
    }

    public void setCard_detail(String card_detail) {
        this.card_detail = card_detail;
    }

    public String getCard_range() {
        return card_range;
    }

    public void setCard_range(String card_range) {
        this.card_range = card_range;
    }

    public String getCard_info() {
        return card_info;
    }

    public void setCard_info(String card_info) {
        this.card_info = card_info;
    }

    public String getAfter_sale_service() {
        return after_sale_service;
    }

    public void setAfter_sale_service(String after_sale_service) {
        this.after_sale_service = after_sale_service;
    }

    public String getCard_form_detail() {
        return card_form_detail;
    }

    public void setCard_form_detail(String card_form_detail) {
        this.card_form_detail = card_form_detail;
    }

    public Set<ProductKaDanType> getProductKaDanTypes() {
        return productKaDanTypes;
    }

    public void setProductKaDanTypes(Set<ProductKaDanType> productKaDanTypes) {
        this.productKaDanTypes = productKaDanTypes;
    }



    @Override
    public String toString() {
        return "ProductKaDan{" +
                "id=" + id +
                ", product=" + product +
                ", card_name='" + card_name + '\'' +
                ", card_desc='" + card_desc + '\'' +
                ", card_price=" + card_price +
                ", card_img_small='" + card_img_small + '\'' +
                ", card_img_big='" + card_img_big + '\'' +
                ", card_buy_type='" + card_buy_type + '\'' +
                ", card_cate='" + card_cate + '\'' +
                ", conditions='" + conditions + '\'' +
                ", card_detail='" + card_detail + '\'' +
                ", card_range='" + card_range + '\'' +
                ", card_info='" + card_info + '\'' +
                ", after_sale_service='" + after_sale_service + '\'' +
                ", card_form_detail='" + card_form_detail + '\'' +
                ", productKaDanTypes=" + productKaDanTypes +
                '}';
    }
}
