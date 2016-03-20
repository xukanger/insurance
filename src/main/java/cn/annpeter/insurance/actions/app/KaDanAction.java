package cn.annpeter.insurance.actions.app;

import cn.annpeter.insurance.actions.JsonBaseResAction;
import cn.annpeter.insurance.entities.jsonBeans.app.kadan.JsonResKaDanList;
import cn.annpeter.insurance.entities.jsonBeans.app.kadan.JsonResKaDanProfile;
import cn.annpeter.insurance.services.KaDanService;
import cn.annpeter.insurance.utils.ExceptionUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by annpeter on 3/14/16.
 *
 * 对于产品卡单的请求管理
 */
@Namespace("/app/kadan")
@ParentPackage("appDefault")
@Controller
public class KaDanAction extends JsonBaseResAction {

    @Resource
    private KaDanService kaDanService;


    @Action(value = "index", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String index() throws UnsupportedEncodingException {

        try {
            //当id有误时,返回错误信息
            int product_Id = Integer.valueOf(this.getUrlParameter("id"));

            //因为客户端要求result必须为一个数组, 但有时我们取出来的本来就是一个list
            //因此,在这里虽然只有一个对象,还是需要把它装载在list中,保持格式一致
            List <JsonResKaDanProfile> result = new ArrayList<>();

            JsonResKaDanProfile productKaDan = kaDanService.getJsonKaDanProfile(product_Id);

            result.add(productKaDan);

            sendSuccessMessage("请求卡单成功", productKaDan);
        }catch (Exception e){
            sendFailMessage("请求卡单失败", "0X0000");
        }
        return SUCCESS;
    }



    @Action(value = "list", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String list() throws UnsupportedEncodingException {
        try {

            List <JsonResKaDanList> result = kaDanService.getJsonKaDanList();

            sendSuccessMessage("请求卡单列表成功", result);
        } catch (ExceptionUtils exceptionUtils) {
            sendFailMessage("获取卡单列表失败", "0x0000");
            exceptionUtils.printStackTrace();
        }
        return SUCCESS;
    }



    public void setKaDanService(KaDanService kaDanService) {
        this.kaDanService = kaDanService;
    }

}
