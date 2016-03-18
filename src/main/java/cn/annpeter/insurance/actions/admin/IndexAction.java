package cn.annpeter.insurance.actions.admin;


import java.io.UnsupportedEncodingException;
import java.util.Map;

import cn.annpeter.insurance.actions.BaseRequestAction;
import com.opensymphony.xwork2.ActionContext;
import cn.annpeter.insurance.entities.User;
import cn.annpeter.insurance.services.UserCntlService;
import cn.annpeter.insurance.utils.WebUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Namespace("/admin/index")
@ParentPackage("adminDefault")
@Controller
public class IndexAction extends BaseRequestAction {


    private static final long serialVersionUID = 1977013404500337855L;

    @Resource
    private UserCntlService userCntlService;
    private User user;


    @Action(value = "index", results = {
            @Result(name = "success", location = "/views/admin/index/index.jsp")
    })
    public String index() {

        return SUCCESS;
    }


    @Action(value = "login", results = {
            @Result(name = "success", location = "/views/admin/index/login.jsp"),
            @Result(name = "error", location = "/views/admin/index/login.jsp")
    })
    public String login() throws UnsupportedEncodingException {

        if(user != null){
            user = userCntlService.login(user);

            if(user != null){
                ActionContext actionContext = ActionContext.getContext();
                Map<String, Object> session = actionContext.getSession();
                session.put("User", user);

                //登陆成功，重定向至首页
                WebUtils.redrictToUrl("admin/index/index");
                return SUCCESS;
            }else{
                //用户不合法，登陆失败
                getRequest().put("userInvalid", 0);
                return ERROR;
            }
        }
        return SUCCESS;
    }



    public void setUserCntlService(UserCntlService userCntlService) {
        this.userCntlService = userCntlService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
