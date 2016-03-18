package cn.annpeter.insurance.actions.app;

import cn.annpeter.insurance.entities.products.JsonKaDanList;
import cn.annpeter.insurance.entities.products.JsonKaDanProfile;
import cn.annpeter.insurance.entities.products.ProductKaDan;
import cn.annpeter.insurance.services.KaDanService;
import cn.annpeter.insurance.utils.ExceptionUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by annpeter on 3/14/16.
 *
 * 对于产品卡单的请求管理
 */
@Namespace("/app/kadan")
@ParentPackage("appDefault")
@Controller
public class KaDanAction extends JsonBaseReqestAction {

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
            String kId = this.getUrlParameter("id");

            JsonKaDanProfile productKaDan = (JsonKaDanProfile)kaDanService.getJsonKaDanProfile(Integer.valueOf(kId));

            sendSuccessMessageCycleDetection("请求卡单成功", productKaDan);
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

            List <JsonKaDanList> result = kaDanService.getJsonKaDanList();

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
