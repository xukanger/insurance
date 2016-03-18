package cn.annpeter.insurance.utils;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Component;

@Component
public class WebUtils {
	

	public static String getBasePath() {
		ActionContext actionContext = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)actionContext.get(StrutsStatics.HTTP_REQUEST);
		String path = request.getContextPath();
		String basePath = request.getScheme() +"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

		return basePath;
	}




	public static void redrictToUrl(String uri) {
		ActionContext actionContext = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)actionContext.get(StrutsStatics.HTTP_RESPONSE);
		try {
			response.sendRedirect(getBasePath()+uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
