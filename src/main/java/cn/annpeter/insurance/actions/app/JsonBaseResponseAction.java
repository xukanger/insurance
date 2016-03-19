package cn.annpeter.insurance.actions.app;

/**
 * Created by annpeter on 3/17/16.
 */

import cn.annpeter.insurance.actions.BaseRequestAction;
import cn.annpeter.insurance.utils.Constant;
import com.google.gson.Gson;
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
public class JsonBaseResponseAction extends BaseRequestAction {

    private InputStream inputStream;
    private Gson gson;
    private Map<String, Object> jsonMap;

    public JsonBaseResponseAction(){
        gson = new Gson();
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

        if(Constant.DEBUG){
            System.out.println(gson.toJson(jsonMap));
        }

        inputStream = new ByteArrayInputStream(gson.toJson(jsonMap).getBytes("UTF-8"));
    }

//    /**
//     * 避免在result中的属性不是基本对象时,发生无限迭代
//     * @param message
//     * @param result
//     * @param clazz
//     * @throws UnsupportedEncodingException
//     */
//    public void sendSuccessMessageCycleDetection(String message, Object result, Class clazz) throws UnsupportedEncodingException {
//
//        JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//
//        JSONObject resultJson = JSONObject.fromObject(result, jsonConfig);
//
//        //Object obj = result
//        //需要将这里的ProductKaDan换为clazz,因为现在尚未用到,暂不实现
//        ProductKaDan obj = (ProductKaDan) JSONObject.toBean(resultJson, ProductKaDan.class);
//
//        jsonMap.put("status", 1);
//        jsonMap.put("message", message);
//        jsonMap.put("result", obj);
//        jsonObject.putAll(jsonMap);
//
//        inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("UTF-8"));
//    }



    public void sendFailMessage(String message, String code) throws UnsupportedEncodingException {
        jsonMap.put("status", 0);
        jsonMap.put("message", message);
        jsonMap.put("code", code);
        inputStream = new ByteArrayInputStream(gson.toJson(jsonMap).getBytes("UTF-8"));
    }
}