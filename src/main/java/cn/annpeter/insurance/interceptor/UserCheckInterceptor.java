package cn.annpeter.insurance.interceptor;

import cn.annpeter.insurance.utils.Constant;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.annpeter.insurance.entities.User;
import cn.annpeter.insurance.utils.WebUtils;
import org.springframework.stereotype.Controller;


/**
 * 用于检测用户授权
 *
 * Created by annpeter on 3/11/16.
 */
public class UserCheckInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = -8209905321100447926L;

	@Override
	public String intercept(ActionInvocation actionInvocation) {

		try {

            if(Constant.DEBUG){
                actionInvocation.invoke();
                return "success";
            }


			ActionProxy actionProxy = actionInvocation.getProxy();
			String method = actionProxy.getMethod();

			//检测本次行为是否为登陆，如果不是登陆，检测用户权限
			if(!method.equals("login")){
				ActionContext actionContext = actionInvocation.getInvocationContext();
				
				User userLogined = (User) actionContext.getSession().get("User");
				
				if(userLogined != null){
					
					actionInvocation.invoke();
				}else{
//					if(!actionProxy.getActionName().equals("index")){
//						//本次登陆Action不在index，所以重定向至index然后到登陆
//						WebUtils.redrictToUrl("admin/index/login");
//					}
					//本package中的Action,应该可以直接跳转,无需重定向,耗费资源
                    WebUtils.redrictToUrl("admin/index/login");
				}
			}else{
				//本次行为即为登陆，无需检测授权
				actionInvocation.invoke();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
