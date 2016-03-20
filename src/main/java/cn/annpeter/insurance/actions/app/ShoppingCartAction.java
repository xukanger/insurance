package cn.annpeter.insurance.actions.app;

import cn.annpeter.insurance.actions.JsonBaseReqActionWithList;
import cn.annpeter.insurance.actions.JsonBaseResAction;
import cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart.JsonReqShoppingCartModify;
import cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart.JsonResShoppingCartList;
import cn.annpeter.insurance.services.ShoppingCartService;
import com.google.gson.Gson;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by annpeter on 3/19/16.
 */
@Namespace("/app/shoppingcart")
@ParentPackage("appDefault")
@Controller
public class ShoppingCartAction extends JsonBaseReqActionWithList {

    @Resource
    ShoppingCartService shoppingCartService;

    @Action(value = "list", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String list(){

        try{
            int memberId = Integer.valueOf(this.getUrlParameter("id"));
            List<JsonResShoppingCartList> result = new ArrayList<>();

            JsonResShoppingCartList jsonResponseShoppingCart = shoppingCartService.list(memberId);
            result.add(jsonResponseShoppingCart);

            sendSuccessMessage("获取购物车成功", result);

            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }



    @Action(value = "modify", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String modify(){


        try{

            Gson gson = new Gson();
            JsonReqShoppingCartModify jsonReqShoppingCartModify =  gson.fromJson(getReqJsonStr(), JsonReqShoppingCartModify.class);

            System.out.println(jsonReqShoppingCartModify.toString());

            sendSuccessMessage("成功修改成功", null);
        }catch (Exception e){

        }

        return SUCCESS;
    }

}
