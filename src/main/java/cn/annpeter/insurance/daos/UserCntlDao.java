package cn.annpeter.insurance.daos;

import org.hibernate.Query;
import cn.annpeter.insurance.entities.User;
import org.springframework.stereotype.Repository;


/**
 * Created by annpeter on 3/10/16.
 */
@Repository
public class UserCntlDao extends BaseDao{

	
	public User getCheckUserVaild(User user){
		String sql = "FROM jt_user user WHERE user.name = ? AND user.password = ? ";
		Query query = getSession().createQuery(sql).setString(0, user.getName()).setString(1, user.getPassword());
		
		User retUser = (User) query.uniqueResult();
		
		return retUser;
	}

	/*
	 * 返回带有id的user
	 */
	public User addUser(User user) {
		return null;
	}
}
