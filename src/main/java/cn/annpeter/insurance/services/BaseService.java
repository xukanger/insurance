package cn.annpeter.insurance.services;

import cn.annpeter.insurance.entities.products.JsonKaDanShow;
import cn.annpeter.insurance.entities.products.ProductKaDan;
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


    /**
     * 从一个list中,将list的子元素转换为clazz类型的子元素,
     * 注意,clazz类型中的名称一定要与list子元素相匹配
     * @param sorList
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<Object> getJsonList(List<?> sorList, Class clazz) throws ExceptionUtils {

        try{
            Field[] fields = clazz.getDeclaredFields();
            List < Object> result  = new ArrayList<>();

            Iterator<?> iterator = sorList.iterator();

            while (iterator.hasNext()){
                Object sourObj = iterator.next();

                Object destObj = clazz.newInstance();

                for(int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++){
                    Field field = fields[fieldIndex];

                    //从原对象中获取值
                    Object fieldValue = getFieldValueByName(field.getName(), sourObj);

                    //将获取到的值赋值给新的对象
                    setFieldValueByName(field.getName(), destObj, fieldValue);
                }

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
