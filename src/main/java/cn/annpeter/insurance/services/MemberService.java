package cn.annpeter.insurance.services;

import cn.annpeter.insurance.daos.MemberDao;
import cn.annpeter.insurance.entities.Member;
import cn.annpeter.insurance.utils.ExceptionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yt on 2016/3/20.
 */
@Service
public class MemberService extends BaseService{
    @Resource
    MemberDao memberDao;

    public Member saveOrUpdate(Member newMember) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        //使用新的member查找老的member，避免不可改变的区域被新的用户修改

        //在这里，用户的用户名，注册ip，注册还有注册日期不能被修改
        //暂时 手机号不能改变

        Member oldMember=memberDao.getMemberById(newMember.getId());
//        //Email
//        if(newMember.getEmail()!=null)
//            oldMember.setEmail(newMember.getEmail());
//        //Fax
//        if(newMember.getFax()!=null)
//            oldMember.setFax(newMember.getFax());
//        //City
//        if(newMember.getCity_id()!=null)
//            oldMember.setCity_id(newMember.getCity_id());
//        //Last_login_ip
//        if(newMember.getLast_login_ip()!=null)
//            oldMember.setLast_login_ip(newMember.getLast_login_ip());
//        //Last_login_time
//        if(newMember.getLast_login_time()!=null)
//            oldMember.setLast_login_time(newMember.getLast_login_time());
//        //This_login_ip
//        if(newMember.getThis_login_ip()!=null)
//            oldMember.setThis_login_ip(newMember.getThis_login_ip());
//        //This_login_time
//        if(newMember.getThis_login_time()!=null)
//            oldMember.setThis_login_time(newMember.getThis_login_time());
//        //QQ
//        if(newMember.getQq()!=null)
//            oldMember.setQq(newMember.getQq());
//        //Status
//        if(newMember.getStatus()!=null)
//            oldMember.setStatus(newMember.getStatus());
//        //Star
//        if(newMember.getStar()!=null)
//            oldMember.setStar(newMember.getStar());
//        //sn
//        if(newMember.getSn()!=null)
//            oldMember.setSn(newMember.getSn());
//
//        if(newMember.getUserpwd()!=null)
//            oldMember.setUserpwd(newMember.getUserpwd());
        String[]modifyProperties=new String[]{"email","fax","city","city_id","last_login_ip","last_login_time",
                "this_login_ip","this_login_time","status","qq","tel_num","sn","star"};
        modifyMember(oldMember,newMember,modifyProperties);
        memberDao.saveOrUpdate(newMember);
        return oldMember;
    }

    private void modifyMember(Member oldMember,Member newMember,String[]properties) throws InvocationTargetException, IllegalAccessException, IntrospectionException {
        for(String property:properties){
            PropertyDescriptor propertyDescriptor=new PropertyDescriptor(property, Member.class);
            Method readMethod=propertyDescriptor.getReadMethod();
            Object param=readMethod.invoke(newMember);
            if(param!=null){
                Method writeMethod=propertyDescriptor.getWriteMethod();
                writeMethod.invoke(oldMember,param);
            }
        }
    }

    public Member add(Member member) throws ExceptionUtils {
        if(member==null)throw new ExceptionUtils("添加member出错 member不能为空");
        return memberDao.add(member);
    }

    public Member getMemberById(int id) throws ExceptionUtils{
        Member member = memberDao.getMemberById(id);
        if(member == null){
            throw new ExceptionUtils("没有找到id = " + id +"的用户。" );
        }
        return member;
    }
}
