package cn.annpeter.insurance.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by annpeter on 3/15/16.
 */
@Repository
public class BaseDao {

    @Resource
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 使用hql,获取一个对象集
     * @param hql
     * @return
     */
    public List<?> getList(String hql){
        Query query = getSession().createQuery(hql);
        List<?> list = query.list();
        return list;
    }

    /**
     * 使用hql语句获取一个对象
     * @param hql
     * @return
     */
    public Object getOne(String hql){
        Object obj = getSession().createQuery(hql).uniqueResult();
        return obj;
    }

    public void saveOrUpdate(Object obj){
        getSession().saveOrUpdate(obj);
    }

    public void delete(Object obj){
        getSession().delete(obj);
    }
}
