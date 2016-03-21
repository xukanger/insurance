package cn.annpeter.insurance.daos;

import cn.annpeter.insurance.entities.Member;
import cn.annpeter.insurance.utils.ExceptionUtils;
import cn.org.rapid_framework.page.Page;
import org.hibernate.Query;
import org.hibernate.metamodel.relational.Sequence;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yt on 2016/3/20.
 */
@Repository
public class MemberDao extends BaseDao{
    public Member getMemberById(int id){
        Query query = getSession().createQuery("FROM jt_member WHERE id = ?").setParameter(0, id);
        Member member = (Member)query.uniqueResult();
        return member;
    }
    public List<Member> list(){
        return getSession().createQuery("FROM jt_member").list();
    }

    public long getCount(String where){
        Query query = getSession().createQuery("SELECT COUNT(*) FROM jt_member");
        Long count = (Long) query.uniqueResult();
        return count;
    }

    public List<Member> queryByPage(final String where, final Page<Member> page) {
        Query query = getSession().createQuery("FROM jt_member");
        //设置参数  
        //query.setParameter(0, xx);  
        //设置每页显示多少个，设置多大结果。  
        query.setMaxResults(page.getPageSize());
        //设置起点  
        query.setFirstResult(page.getFirstResult());
        return query.list();
    }
    public Member add(Member member) throws ExceptionUtils {
        Sequence sequence = (Sequence)getSession().save(member);

        return getMemberById(sequence.getInitialValue());
    }
}
