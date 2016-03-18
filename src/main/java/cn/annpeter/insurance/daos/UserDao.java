package cn.annpeter.insurance.daos;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import cn.org.rapid_framework.page.Page;
import oracle.net.aso.q;
import cn.annpeter.insurance.entities.User;
import cn.annpeter.insurance.utils.ExceptionUtils;
import org.hibernate.metamodel.relational.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao{


	public User getUserById(int id){
		Query query = getSession().createQuery("FROM jt_user WHERE id = ?").setParameter(0, id);
		User user = (User)query.uniqueResult();
		return user;
	}

	
	public List<User> list(){
		return getSession().createQuery("FROM jt_user").list();
	}
	
	public long getCount(String where){
		Query query = getSession().createQuery("SELECT COUNT(*) FROM jt_user");
		Long count = (Long) query.uniqueResult();
        return count;
	}
	
	public List<User> queryByPage(final String where, final Page<User> page) { 
		Query query = getSession().createQuery("FROM jt_user");
        //设置参数  
        //query.setParameter(0, xx);  
        //设置每页显示多少个，设置多大结果。  
        query.setMaxResults(page.getPageSize());  
        //设置起点  
        query.setFirstResult(page.getFirstResult());  
        return query.list();
	}

	public User add(User user) throws ExceptionUtils{
        Sequence sequence = (Sequence)getSession().save(user);

		return getUserById(sequence.getInitialValue());
	}
}