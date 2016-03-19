package cn.annpeter.insurance.services;

import cn.annpeter.insurance.utils.Constant;
import cn.annpeter.insurance.utils.ExceptionUtils;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by annpeter on 3/15/16.
 */
@Service
public class BaseService {

    public Object getJsonObj(Object sourObj, Class clazz){
        try{
            Object destObj = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();

            for(int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++){

                Field field = fields[fieldIndex];

                //因为涉及到一个类的属性可能是一个类,在查这个表的附属信息的时候,我们只希望查询附属表的某一条或几条信息,
                //所以在这里,我规定,当需要查询附属信息的时候,我们JavaBean的命名方式为  字段__二级字段__三级字段
                //切记,所有表的字段中命名不能含有连续两个下划线
                String fieldNameStr = field.getName();   //filed

                String fieldNames[] = fieldNameStr.split("__");


                Object tempFieldValue = sourObj;   // 用于保存中间变量的值,因为可能有多个__,涉及到多级联的表
                for(int i =0; i < fieldNames.length; i++){
                    String fieldName = fieldNames[i];
                    //从原对象中获取值

                    //如果tempFileValue是一个集合怎么办???
                    tempFieldValue = getFieldValueByName(fieldName, tempFieldValue);
                }

                //这是最后的fieldValue的值
                Object fieldValue = tempFieldValue;

                //将获取到的值赋值给新的对象
                setFieldValueByName(field.getName(), destObj, fieldValue);
            }
            return destObj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从一个list中,将list的子元素转换为clazz类型的子元素,
     * 注意,clazz类型中的名称一定要与list子元素相匹配
     * @param sourList
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<?> getJsonList(List<?> sourList, Class clazz){

        try{
            Field[] fields = clazz.getDeclaredFields();
            List < Object> result  = new ArrayList<>();

            Iterator<?> iterator = sourList.iterator();

            while (iterator.hasNext()){
                Object sourObj = iterator.next();
                Object destObj = getJsonObj(sourObj, clazz);

                result.add(destObj);
            }

            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }


    private Object getFieldValueByName(String fieldName, Object obj) throws ExceptionUtils {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = obj.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(obj, new Object[] {});
            return value;
        }catch (Exception e){
            if(Constant.DEBUG){
                e.printStackTrace();
            }else{
                throw new ExceptionUtils("没有"+obj.getClass().toString()+"中找到属性"+fieldName);
            }
        }
        return  null;
    }


    private void setFieldValueByName(String fieldName, Object obj, Object value) throws ExceptionUtils {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String setter = "set" + firstLetter + fieldName.substring(1);
            Method method = obj.getClass().getMethod(setter, new Class[] {value.getClass()});

            method.invoke(obj, new Object[] {value});
        }catch (Exception e){
            if(Constant.DEBUG){
                e.printStackTrace();
            }else{
                throw new ExceptionUtils("不能将"+value.getClass().toString()+"类型的值赋值给"+obj.getClass().toString()+"的"+fieldName+"属性中");
            }
        }
    }


}
