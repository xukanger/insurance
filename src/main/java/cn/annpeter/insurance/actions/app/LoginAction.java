package cn.annpeter.insurance.actions.app;

import cn.annpeter.insurance.actions.JsonBaseResAction;
import cn.annpeter.insurance.entities.Member;
import cn.annpeter.insurance.services.MemberCntlService;
import cn.annpeter.insurance.services.MemberService;
import cn.annpeter.insurance.utils.Constant;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by yt on 2016/3/18.
 */
@Namespace("/app/Login")
@ParentPackage("appDefault")
@Controller
public class LoginAction extends JsonBaseResAction{

    private Member member;

    private String code;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Resource
    private MemberCntlService memberCntlService;

   @Resource
   private MemberService memberService;

    /*
     登陆用的action
     */
    @Action(value = "signIn", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String signIn() throws UnsupportedEncodingException {

        try {
            //检验参数
            String erroMsg="";
            if(member.getUserpwd()==null)erroMsg+="请求密码为空 ";
            if(member.getUsername()==null)erroMsg+="请求用户名为空 ";
            if(!erroMsg.equals("")){
                sendFailMessage(erroMsg.substring(0,erroMsg.length()-1),"");
                return SUCCESS;
            }
            //检验用户名和密码
           Member result=memberCntlService.signIn(member);
            if(result==null){
                sendFailMessage("未知的用户名或密码错误","0X0000");
            }
            else{

                Map<String,String> infoMap=new HashMap<>();
                infoMap.put("username",result.getUsername());
                infoMap.put("realname",result.getRealname());
                infoMap.put("mobile",result.getMobile());
                infoMap.put("city",result.getCity());
                infoMap.put("uid",result.getId().toString());

                sendSuccessMessage("登陆成功",infoMap);
            }

        }catch (Exception e){
            sendFailMessage("请求失败", "0X0000");
        }
        return SUCCESS;
    }


    /*
    发送验证码
     */
    @Action(value = "identify", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String identify() throws UnsupportedEncodingException {
        try{
            //检验参数
            if(member.getMobile()==null){
                sendFailMessage("请求手机号为空","");
                return SUCCESS;
            }

            //检验该手机号是否已经注册
            if(memberCntlService.checkMobileExists(member)){

                sendFailMessage("该号码已经注册","0x0000");
            }
            else{
                //TODO

                if (Constant.DEBUG) {
                    sendSuccessMessage("短信发送成功","");
                }
                else{
                    sendFailMessage("短信未发送成功","");
                }

            }

        }catch (Exception e){
            sendFailMessage("请求失败", "0X0000");
            e.printStackTrace();
        }
        return SUCCESS;
    }


    /*
    注册
     */
    @Action(value = "register", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String register()throws UnsupportedEncodingException {
        try
        {
            //检验参数
//            StringBuilder erroMsg=new StringBuilder();
//            if(member.getRealname()==null)
//                erroMsg.append("请求真名为空 ");
//            if(member.getMobile()==null)
//                erroMsg.append("请求手机号为空 ");
//            if(member.getCity()==null)
//                erroMsg.append("请求城市为空 ");
//
//            if(member.getUserpwd()==null)
//                erroMsg.append("请求密码为空 ");
            String erroString=getErroMsg(new String[]{"mobile","realname","city","userpwd"});
            if(code==null)
                erroString+=" 请求验证码为空";
            if(!erroString.equals("")){
                sendFailMessage(erroString.substring(0,erroString.length()),"");
            }

            //TODO
            //验证码
            if(!Constant.DEBUG){
                sendFailMessage("验证码错误","");
            }
            else{
                //发送用户信息
                Member result= memberService.add(member);

                Map<String,String> infoMap=new HashMap<>();
                infoMap.put("username",result.getUsername());
                infoMap.put("realname",result.getRealname());
                infoMap.put("mobile",result.getMobile());
                infoMap.put("city",result.getCity());
                infoMap.put("uid",result.getId().toString());

                sendSuccessMessage("注册成功",infoMap);
            }
        }
        catch (Exception e){
            sendFailMessage("请求失败", "0X0000");
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /*
    找回密码
     */
    @Action(value = "retrieve", results = {
            @Result(name = "success", type = "stream", params = {
                    "contentType","text/html",
                    "inputName","inputStream"
            })
    })
    public String retrieve() throws UnsupportedEncodingException {
        try
        {
//            StringBuilder erroMsg=new StringBuilder();
//            if(member.getMobile()==null)
//                erroMsg.append("请求手机号为空 ");
//            if(member.getUserpwd()==null)
//                erroMsg.append("请求密码为空 ")
//            String erroString=erroMsg.toString();
            String erroString=getErroMsg(new String[]{"mobile","userpwd"});
            if(code==null)
                erroString+=" 请求验证码缺失";

            if(!erroString.equals("")){
                sendFailMessage(erroString,"");
                return SUCCESS;
            }

            //TODO
            if(!code.equals("")){
                sendFailMessage("验证码错误","");
            }
            else{
                memberService.saveOrUpdate(member);
                sendSuccessMessage("重设密码成功",null);
            }

        }
        catch (Exception e){
            sendFailMessage("请求失败", "0X0000");
            e.printStackTrace();
        }
        return SUCCESS;
    }


    /*
    获取错误信息
     */
    private String getErroMsg(String[] properties) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        StringBuilder erroMsg=new StringBuilder();
        for(String property:properties){
            PropertyDescriptor propertyDescriptor=new PropertyDescriptor(property, Member.class);
            Method getMethod=propertyDescriptor.getReadMethod();
            if(member==null||getMethod.invoke(member)==null){
                erroMsg.append("请求");
                erroMsg.append(property);
                erroMsg.append("缺失 ");
            }
        }
        return erroMsg.substring(0,erroMsg.length()-1).toString();
    }

}
