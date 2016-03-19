package cn.annpeter.insurance.actions.app;

import cn.annpeter.insurance.entities.DemoBean;
import cn.annpeter.insurance.entities.products.JsonKaDanProfile;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import java.io.UnsupportedEncodingException;

/**
 * Created by annpeter on 3/19/16.
 */
@Namespace("/app/demo")
@ParentPackage("appDefault")
@Controller
public class DemoAction extends JsonBaseReqestAction{

    DemoBean demoBean;

    @Action(value = "index", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String index() throws UnsupportedEncodingException {


        String str = demoBean.toString();
        System.out.println(str);

        return SUCCESS;
    }


    @Action(value = "req", results = {
            @Result(name = "success", location = "/views/test/test.jsp")
    })
    public String req(){

        return SUCCESS;
    }

    public DemoBean getDemoBean() {
        return demoBean;
    }

    public void setDemoBean(DemoBean demoBean) {
        this.demoBean = demoBean;
    }
}
