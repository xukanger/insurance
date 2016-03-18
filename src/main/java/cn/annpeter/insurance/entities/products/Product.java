package cn.annpeter.insurance.entities.products;

import cn.annpeter.insurance.utils.CommonUtils;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 产品类, 所有产品继承自该类
 *
 * Created by annpeter on 3/14/16.
 */
@Entity(name = "jt_product")
public class Product{
    @Id
    @GeneratedValue
    Integer id;

    Integer cate_id;


    //@ManyToOne(optional = false)
    Integer supplier_id;

    @Column(length = 45)
    String title;

    @Temporal(TemporalType.DATE)
    Date start_date;

    @Temporal(TemporalType.DATE)
    Date end_date;

    @Column(length = 20)
    String model;

    Short status;

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }

    public String getStartDateStr(){
        return CommonUtils.getDateStr(start_date, "yyyy-MM-dd HH:mm:ss");
    }

    public String getEndDateStr(){
        return CommonUtils.getDateStr(end_date, "yyyy-MM-dd HH:mm:ss");
    }



    public Product() {
    }
}
