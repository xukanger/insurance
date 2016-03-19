package cn.annpeter.insurance.actions.admin;

import cn.annpeter.insurance.actions.BaseRequestAction;
import cn.annpeter.insurance.entities.products.Product;
import cn.annpeter.insurance.entities.products.ProductKaDan;
import cn.annpeter.insurance.services.KaDanService;
import cn.annpeter.insurance.utils.ExceptionUtils;
import cn.annpeter.insurance.utils.WebUtils;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by annpeter on 3/17/16.
 * 后台对卡单的增删改查操作
 */
@Namespace("/admin/kadan")
@ParentPackage("adminDefault")
@Controller
public class AdminKaDanAction extends BaseRequestAction {

    @Resource
    KaDanService kaDanService;

    List<ProductKaDan> kaDanArrayList = null;
    ProductKaDan productKaDan = null;


    /**
     * 显示所有卡单
     * @return
     */
    @Action(value = "list", results = {
            @Result(name = "success", location = "/views/admin/kadan/list.jsp")
    })
    public String list(){
        try {
            kaDanArrayList = (List<ProductKaDan>)kaDanService.adminList();
            getRequest().put("KaDanArrayList", kaDanArrayList);
        } catch (ExceptionUtils exceptionUtils) {
            exceptionUtils.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * @return
     */
    @Action(value = "add", results = {
            @Result(name = "success", location = "/views/admin/kadan/add.jsp")
    })
    public String add(){
        try{

            if(productKaDan != null){
                if(productKaDan.getProduct() == null){
                    productKaDan.setProduct(new Product());
                }

                productKaDan = (ProductKaDan) kaDanService.save(productKaDan);

                //重定向至编辑页面
                WebUtils.redrictToUrl("/admin/kadan/profile?id="+productKaDan.getId());
            }
            return SUCCESS;
        }catch (Exception e){
            return ERROR;
        }
    }


    @Action(value = "delete", results = {

    })
    public String delete(){
        try{
            String id = getUrlParameter("id");

            kaDanService.delete(Integer.valueOf(id));

            //重定向至list页面
            WebUtils.redrictToUrl("/admin/kadan/list");
            return SUCCESS;
        }catch (Exception e){
            return ERROR;
        }
    }


    /**
     * profile用于显示某条卡单的详细信息,并提供修改的接口
     * 当用户第一次访问时,profile中productKaDan为空,执行显示详情操作
     * 当用户进行二次操作时,productKaDan被初始化,执行updata
     * @return
     */
    @Action(value = "profile", results = {
            @Result(name = "success", location = "/views/admin/kadan/profile.jsp")
    })
    public String profile(){
        try{
            String id = getUrlParameter("id");
            if(productKaDan == null){
                //从数据库获取
                productKaDan = kaDanService.getById(Integer.valueOf(id));
            }else{
                //修改到数据库
                productKaDan = kaDanService.update(productKaDan);
            }
            //回显至页面
            getRequest().put("ProductKaDan", productKaDan);
        }catch (Exception e){
            e.printStackTrace();
            return  ERROR;
        }
        return SUCCESS;
    }


    /**
     * set和get主要是提供给strtus提交表单时初始化productKaDan使用
     * get方法可有可无,但一定要有set方法
     * @return
     */
    public ProductKaDan getProductKaDan() {
        return productKaDan;
    }
    public void setProductKaDan(ProductKaDan productKaDan) {
        this.productKaDan = productKaDan;
    }

}
