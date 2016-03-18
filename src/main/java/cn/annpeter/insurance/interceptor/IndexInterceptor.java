package cn.annpeter.insurance.interceptor;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import cn.annpeter.insurance.entities.configs.Navigater;
import cn.annpeter.insurance.entities.configs.Navigaters;


/**
 * 用于找出当前的导航高亮栏目
 *
 * Created by annpeter on 3/11/16.
 */
public class IndexInterceptor extends AbstractInterceptor{

	
	private static final long serialVersionUID = -4891488603257484302L;
	private Navigaters root = null;
	ActionProxy actionProxy = null;
	
	private String actionDesc = "ERROR";
	private String methodDesc = "ERROR";
	HttpServletRequest request;
	
	String formatNoSub;
	String formatHaveSub;
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		IndexInterceptor_init();
		
		actionProxy = actionInvocation.getProxy();

		Navigaters root = getNavigaters();
		String leftNavHtml = getNavigaterString(root);
		request.setAttribute("LeftNavHtml", leftNavHtml);
		request.setAttribute("ActionDesc", actionDesc);
		request.setAttribute("MethodDesc", methodDesc);
		return actionInvocation.invoke();
	}
	
	private void IndexInterceptor_init(){
		ActionContext actionContext = ActionContext.getContext();
		request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);


        //无子节点的html模板
		formatNoSub = "<li class='%s'>"+
								"<a	href='"+request.getContextPath()+"%s'>"+
									"<i class='%s'></i>"+
									"<span class='title'>%s</span>"+
								"</a>"+
							"</li>";
        //有子节点的html模板
		formatHaveSub = 	"<li class='%s'>"+
									"<a	href='"+request.getContextPath()+"%s'>"+
										"<i class='%s'></i>"+
										"<span class='title'>%s</span>"+
										"<span class='arrow'></span>"+
									"</a>"+
									"<ul class='sub-menu'>"+
									"%s"+
									"</ul>"+
								"</li>";
	}
	


	//根据配置文件navigater.xml获取到导航栏的目录树
	private String getNavigaterString(Navigaters navigaters) {
		String retString = null;
		
		Iterator<Navigater> niIterator = navigaters.getNavigater().iterator();
		
		String pageMethod= actionProxy.getActionName();
		String nameSpace = actionProxy.getNamespace();
		String pageAction = nameSpace.substring(nameSpace.lastIndexOf("/")+1, nameSpace.length());
		
		String thisTime = "";
		String currentModel = "";
		int degree = 0;
		while (niIterator.hasNext()) {
			degree++;
			Navigater navigater = (Navigater) niIterator.next();

			//这里以后可能会有错，请注意navigater.xml文件中url的配置
            //匹配设置当前的Action和Method,使当前模块展开并高亮
			if(pageAction.equals(navigater.getAction()) && pageMethod.equals((navigater.getMethod()))){
				currentModel = "current";
				methodDesc = navigater.getDesc();
				Navigater parent = getRoot(navigater);
				actionDesc = parent.getDesc();
			}else{
				//清除上次的tag值
				currentModel = "";
			}


            //形成路径,当有子模块时,高级模块后面没有/
            String actionStr = navigater.getAction().length()==0?"":"/"+navigater.getAction();
            String methodStr = navigater.getAction().length()==0?"":"/"+navigater.getMethod();
			String url = String.format("/admin%s%s", actionStr, methodStr);


			if(navigater.getNavigaters() != null){
				retString = getNavigaterString(navigater.getNavigaters());
				thisTime += String.format(formatHaveSub, currentModel, url, navigater.getImg(), navigater.getTitle(), retString);
			}else{
				thisTime += String.format(formatNoSub, currentModel, url, navigater.getImg(), navigater.getTitle());
			}
		}
		
		return thisTime;
	}
	
	private Navigater getRoot(Navigater navigater){
		Navigater root = navigater;
		while(navigater.getNavigaters()!= null && navigater.getNavigaters().getParent() != navigater){
			root = getRoot(navigater.getNavigaters().getParent());
		}
		return root;
	}

	private Navigaters getNavigaters(){
		try {

            String classPath = this.getClass().getResource("/").getPath();

            java.io.File file = new java.io.File(classPath+ "navigater.xml");
	        JAXBContext jaxbContext = JAXBContext.newInstance(Navigaters.class);

	        Unmarshaller um = jaxbContext.createUnmarshaller();  
	        StreamSource streamSource = new StreamSource(file);  
	        
			root = (Navigaters) um.unmarshal(streamSource);
	        
	        return root;
		} catch (JAXBException e) {
			e.printStackTrace();
		} 
		
		return root;
	}
}