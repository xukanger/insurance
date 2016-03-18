package cn.annpeter.insurance.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * Created by annpeter on 3/12/16.
 */
@Component
public class CommonUtils {
	/**
	 * 用数字和字符生成随机字符串
	 * @param length
	 * @return
	 */
	public static String getRandomCharAndNumr(int length) {
        StringBuffer val = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
        	
            // 输出字母还是数字, num=1  char=0
            int isNum = random.nextInt(2) % 2; 
            
            if (isNum == 1) { // 数字
            	val.append(random.nextInt(10));
            } else {//字母
            	// 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; 
                val.append((char)(choice + random.nextInt(26)));
            }
        }
        return val.toString();
    }
	
	
	/**
	 * 将字符串value，使用c， 扩充称为长度为len的字符串
	 * @param value
	 * @param len
	 * @param c
	 * @return
	 */
	public static String intToStr(String value, int len, char c){
		
		if (value.length() < len) {
			StringBuffer sBuffer = new StringBuffer();
			for (int i = 0; i < len - value.length(); i++) {
				sBuffer.append(c);
			}
			value = sBuffer.append(value).toString();
		}
		return value;
	}


    /**
     * 根据日期格式, 获取日期字符串
     * @param date
     * @param format
     * @return
     */
    public static String getDateStr(Date date, String format){
        String retStr = "";
        if (date != null) {
            SimpleDateFormat dataFormat = new SimpleDateFormat(format);
            retStr = dataFormat.format(date);
        }
        return retStr;
    }

}
