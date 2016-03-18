package cn.annpeter.insurance.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

@Entity(name = "jt_user")
public class User {
    @Id
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String password;

    private String headImgUrl;
    //创建后不能被修改，从前端传入的是String类型，注意类型转换


    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    private String email;


    @Column(name = "BIRTH")
    @Temporal(TemporalType.DATE)
    private Date birth;

    //1->男，2-女，0->未知
    private Short sex;

    private String phone;

    private String idNum;

    private String addr;

    private String QQ;

    private String weChat;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getCreateTime() {return createTime;}

    public void setCreateTime(Date createTime) {this.createTime = createTime;}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date date) {
        this.birth = date;
    }


    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }


    public String getQQ() {
        return QQ;
    }

    public void setQQ(String qQ) {
        QQ = qQ;
    }


    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }



    @Override
    public String toString() {
        super.toString();
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", headImgUrl=" + headImgUrl
                + ", createTime=" + createTime + ", email=" + email + ", birth=" + birth + ", sex=" + sex + ", phone="
                + phone + ", idNum=" + idNum + ", addr=" + addr + ", QQ=" + QQ + ", weChat=" + weChat + "]";
    }


    @Transient
    public String getBirthStr(){
        String retStr = "";
        if (birth != null) {
            SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
            retStr = dataFormat.format(birth);
        }
        return retStr;
    }


    @Transient
    public String getCreateTimeStr() {
        String retStr = "";
        if (birth != null) {
            SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            retStr = dataFormat.format(createTime);
        }
        return retStr;
    }
}
