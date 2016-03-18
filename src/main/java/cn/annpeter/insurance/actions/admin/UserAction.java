package cn.annpeter.insurance.actions.admin;

import cn.annpeter.insurance.actions.BaseRequestAction;
import cn.annpeter.insurance.actions.app.JsonBaseReqestAction;
import org.apache.struts2.ServletActionContext;
import cn.annpeter.insurance.entities.User;
import cn.annpeter.insurance.services.UserService;
import cn.org.rapid_framework.page.Page;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.util.ArrayList;

@Namespace("/admin/user")
@ParentPackage("adminDefault")
@Controller
public class UserAction extends JsonBaseReqestAction {

	private static final long serialVersionUID = 3097879606840479844L;

    @Resource
	private UserService userService;

	private Page page = null;
	private ArrayList<User> userArrayList;
    private User user; // 用于profile时提交用户信息


	// 分页显示用户信息
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

        getRequest().put("ActionDesc", "用户信息管理");
        getRequest().put("MethodDesc", "编辑用户信息");

        String uId = this.getUrlParameter("id");

		try {
			User user = userService.getUserById(Integer.parseInt(uId));
            getRequest().put("User", user);
			user.getBirthStr();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "editProfile", results = {
            @Result(name = "success", location = "/views/admin/user/profile.jsp")
    })
	public String editProfile() {

        getRequest().put("ActionDesc", "用户信息管理");
        getRequest().put("MethodDesc", "编辑用户信息");
		
		try {
			user = userService.saveOrUpdate(user);

            getRequest().put("User", user);
		} catch (Exception e) {
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
