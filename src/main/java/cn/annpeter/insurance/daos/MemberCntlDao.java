package cn.annpeter.insurance.daos;

import cn.annpeter.insurance.entities.Member;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by yt on 2016/3/20.
 */
@Repository
public class MemberCntlDao extends BaseDao{


    public Member getCheckMemberVaild(Member member){
        String sql = "FROM jt_member  WHERE mobile = ? AND userpwd = ? ";
        Query query = getSession().createQuery(sql).setString(0, member.getMobile()).setString(1, member.getUserpwd());
        Member result=(Member)query.uniqueResult();
        return result;
    }

    public Member getcheckMobileExists(Member member){
        String sql="FROM jt_member  WHERE mobile= ?";
        Query query=getSession().createQuery(sql).setString(0,member.getMobile());
        Member result=(Member)query.uniqueResult();
        return result;
    }

}
