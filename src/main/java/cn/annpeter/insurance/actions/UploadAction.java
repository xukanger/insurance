package cn.annpeter.insurance.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import cn.annpeter.insurance.utils.WebUtils;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.annpeter.insurance.utils.CommonUtils;
import net.sf.json.JSONObject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;


/**
 * Created by annpeter on 3/11/16.
 * 提供单个文件上传接口,上传的文件的文件名必须命名为fileData
 */
@Namespace("/admin/upload")
@ParentPackage("adminDefault")
@Controller
public class UploadAction extends BaseFileRequestAction{


	/**
	 * @return
	 * @throws UnsupportedEncodingException
	 */
    @Action(value = "index", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String index() throws UnsupportedEncodingException   {
		
    	File destFile = null;

		JSONObject jsonObject = new JSONObject();
		
		try {
			
			destFile = createDesDir();
			FileUtils.copyFile(getFileData(), destFile);
			
			String realPath = destFile.getPath();
			String staticPath = realPath.substring(realPath.lastIndexOf("static"), realPath.length());//获得相对于static目录的路径
            //String urlFullPath = WebUtils.getBasePath()+staticPath;

            //在strtus中使用URLEncode不能访问,后期加入Nginx,可以进行修改
			//String url = URLEncoder.encode(staticPath, "UTF-8");
			
			Map <String, Object> jsonMap = new HashMap<String, Object>();
			Map <String, Object> result = new HashMap<String, Object>();


            //组合json对象,返回请求端
			result.put("url", staticPath);

            jsonMap.put("status", "success");
			jsonMap.put("result", result);
			
			jsonObject.putAll(jsonMap);

			setInputStream(new ByteArrayInputStream(jsonObject.toString().getBytes("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
			
			HashMap<String, Object> error = new HashMap <String, Object>();
			error.put("code", "0x0000");
			error.put("message", "Upload fail!");
			
			Map <String, Object> jsonMap = new HashMap <String, Object>();
			jsonMap.put("error", error);
			
			jsonObject.putAll(jsonMap);

			setInputStream(new ByteArrayInputStream(jsonObject.toString().getBytes("UTF-8")));
		}
				
		return SUCCESS;
	}


    /**
     * 创建一个可用的文件路径,返回一个file对象
     * path=/static/admin/upload/年(四位数)/月(英文字母缩写大写)/日(两位数)
     *      /8位时间数(时间为当前时刻和今天早上凌晨的时间差,单位为毫秒)_5位由字母(大小写)和数字组成的随机数
     * @return
     */
    private File createDesDir(){
    	String path = ServletActionContext.getServletContext().getRealPath("/static/admin/upload");
		
    	String[] monthName = { "JAN", "FEB", "MAR", "APR", "MAY",
    			"JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
    			"DEC" };
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = monthName[calendar.get(Calendar.MONTH)];
		String day = CommonUtils.intToStr(String.valueOf(calendar.get(Calendar.DATE)), 2, '0');
		
		File file = new File(path);
		
		for(int i = 0; i < 3; i++){
			
			switch (i) {
			case 0: file = new File(file, year); break;
			case 1: file = new File(file, month); break;
			case 2: file = new File(file, day); break;
			default:
				break;
			}
			
			file.mkdir();
		}
		
		File retFile = null;
		long nowMillisecond = calendar.getTime().getTime() % 86400000;//获取今天过去的毫秒数作为开头
		String timeNow = CommonUtils.intToStr(String.valueOf(nowMillisecond), 8, '0');

        String fileName = getFileDataFileName();
		String prefix = fileName.substring(fileName.lastIndexOf(".")+1);
		retFile = new File(file, MessageFormat.format("{0}_{1}.{2}", timeNow, CommonUtils.getRandomCharAndNumr(5),  prefix));
		while(retFile.exists()){
			retFile = new File(file, MessageFormat.format("{0}_{1}.{2}", timeNow, CommonUtils.getRandomCharAndNumr(5),  prefix));
		}
		
		return retFile;
    }
	

}
