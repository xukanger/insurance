package cn.annpeter.insurance.actions;

import cn.annpeter.insurance.entities.products.ProductKaDan;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.stereotype.Controller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by annpeter on 3/15/16.
 *
 * 所有的非文件上传下载请求都继承自该类
 */
@Controller
public class BaseRequestAction extends ActionSupport implements RequestAware {

    private Map<String, Object> request;

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public Map<String, Object> getRequest(){
        return this.request;
    }


    /**
     * 获取url问号后面的参数
     * @param key
     * @return
     */
    public String getUrlParameter(String key){
        return ServletActionContext.getRequest().getParameter(key);
    }
}
