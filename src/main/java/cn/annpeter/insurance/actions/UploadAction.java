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
			String staticPath = realPath.substring(realPath.lastIndexOf("/static"), realPath.length());//获得相对于static目录的路径

            //在strtus中使用URLEncode不能访问,后期加入Nginx,可以进行修改
			//String url = URLEncoder.encode(staticPath, "UTF-8");
			
			Map <String, Object> jsonMap = new HashMap<String, Object>();
			Map <String, Object> result = new HashMap<String, Object>();
			jsonMap.put("status", "success");
			
			result.put("url", staticPath);
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
