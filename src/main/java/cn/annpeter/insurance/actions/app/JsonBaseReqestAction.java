package cn.annpeter.insurance.actions.app;

/**
 * Created by annpeter on 3/17/16.
 */

import cn.annpeter.insurance.actions.BaseRequestAction;
import cn.annpeter.insurance.entities.products.ProductKaDan;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by annpeter on 3/15/16.
 */
@Controller
public class JsonBaseReqestAction extends BaseRequestAction {

    private InputStream inputStream;
    private JSONObject jsonObject;
    private Map<String, Object> jsonMap;

    public JsonBaseReqestAction(){
        jsonObject = new JSONObject();
        jsonMap = new HashMap<String, Object>();
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    /**
     * 组装并发送要传送的内容
     * @param message
     * @param result
     * @throws UnsupportedEncodingException
     */
    public void sendSuccessMessage(String message, Object result) throws UnsupportedEncodingException {

        jsonMap.put("status", 1);
        jsonMap.put("message", message);
        jsonMap.put("result", result);
        jsonObject.putAll(jsonMap);

        inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("UTF-8"));
    }

    public void sendSuccessMessageCycleDetection(String message, Object result) throws UnsupportedEncodingException {

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

        JSONObject resultJson = JSONObject.fromObject(result, jsonConfig);

        ProductKaDan obj = (ProductKaDan) JSONObject.toBean(resultJson, ProductKaDan.class);

        jsonMap.put("status", 1);
        jsonMap.put("message", message);
        jsonMap.put("result", obj);
        jsonObject.putAll(jsonMap);

        inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("UTF-8"));
    }



    public void sendFailMessage(String message, String code) throws UnsupportedEncodingException {
        jsonMap.put("status", 0);
        jsonMap.put("message", message);
        jsonMap.put("code", code);
        jsonObject.putAll(jsonMap);
        inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("UTF-8"));
    }
}