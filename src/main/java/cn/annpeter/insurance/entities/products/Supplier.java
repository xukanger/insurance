package cn.annpeter.insurance.entities.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by annpeter on 3/18/16.
 */
@Entity(name = "jt_supplier")
public class Supplier {

    @Id
    Integer id;

    @Column(length = 45)
    String title;

    @Column(length = 45)
    String etitle;

    String logo;

    Short status;

    @Column(length = 128)
    String activeurl;

    @Column(length = 15)
    String tel;

    public Supplier() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEtitle() {
        return etitle;
    }

    public void setEtitle(String etitle) {
        this.etitle = etitle;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getActiveurl() {
        return activeurl;
    }

    public void setActiveurl(String activeurl) {
        this.activeurl = activeurl;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", etitle='" + etitle + '\'' +
                ", logo='" + logo + '\'' +
                ", status=" + status +
                ", activeurl='" + activeurl + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
