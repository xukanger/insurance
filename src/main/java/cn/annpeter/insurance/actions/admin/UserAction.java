package cn.annpeter.insurance.actions.admin;

import cn.annpeter.insurance.actions.JsonBaseResAction;
import cn.annpeter.insurance.entities.User;
import cn.annpeter.insurance.services.UserService;
import cn.org.rapid_framework.page.Page;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;


/**
 * 用户管理,用于用户的增删改查
 * Created by annpeter on 3/11/16.
 */
@Namespace("/admin/user")
@ParentPackage("adminDefault")
@Controller
public class   UserAction extends JsonBaseResAction {

	private static final long serialVersionUID = 3097879606840479844L;

    @Resource
	private UserService userService;

	private Page page = null;
	private ArrayList<User> userArrayList;
    private User user; // 用于profile时提交用户信息


    /**
     * 分页显示用户信息,每页最多12条
     * @return
     */
    @Action( value = "list", results = {
            @Result(name = "success", location = "/views/admin/user/list.jsp")
    })
	public String list() {
		String objPage = ServletActionContext.getRequest().getParameter("page");

		if (objPage == null) {
			page = new Page<User>(0, 12, (int) userService.getCount(""));
			userArrayList = userService.queryByPage("", page);
			getRequest().put("UserArrayList", userArrayList);
			getRequest().put("UserPage", page);
		} else {
			page = new Page<User>(Integer.parseInt(objPage), 12, (int) userService.getCount(""));
			userArrayList = userService.queryByPage("", page);
            getRequest().put("UserArrayList", userArrayList);
            getRequest().put("UserPage", page);
		}

		return SUCCESS;
	}

    // 显示用户详细信息
    @Action(value = "profile", results = {
            @Result(name = "success", location = "/views/admin/user/profile.jsp")
    })
	public String profile() {

        try{
            //显示用户信息
            if(user == null){
                String uId = this.getUrlParameter("id");
                user = userService.getUserById(Integer.parseInt(uId));
            }else{//修改用户信息
                user = userService.saveOrUpdate(user);
            }

            getRequest().put("User", user);
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }

		return SUCCESS;
	}



    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
