package cn.annpeter.insurance.services;

import cn.annpeter.insurance.daos.MemberCntlDao;
import cn.annpeter.insurance.entities.Member;
import cn.annpeter.insurance.utils.ExceptionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yt on 2016/3/20.
 */
@Service
public class MemberCntlService {
    @Resource
    private MemberCntlDao memberCntlDao;

    public void setMemberCntlDao(MemberCntlDao memberCntlDao) {
        this.memberCntlDao = memberCntlDao;
    }

    public Member signIn(Member member) throws ExceptionUtils {
        if(member==null)throw new ExceptionUtils("登录出错 member不能为空");
        return memberCntlDao.getCheckMemberVaild(member);
    }
    public boolean checkMobileExists(Member member) throws ExceptionUtils {
        if(member==null)throw new ExceptionUtils("检查号码是否存在出错 不能为空");
        Member result=memberCntlDao.getcheckMobileExists(member);
        return result!=null?true:false;
    }


}
