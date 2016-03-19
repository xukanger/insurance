package cn.annpeter.insurance.actions.app;

import cn.annpeter.insurance.services.ShoppingCartService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by annpeter on 3/19/16.
 */
@Controller
public class ShoppingCartAction extends JsonBaseReqestAction{

    @Resource
    ShoppingCartService shoppingCartService;

    @Action(value = "list", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String list(){
        return SUCCESS;
    }

    @Action(value = "modify", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String modify(){


        return SUCCESS;
    }

}
