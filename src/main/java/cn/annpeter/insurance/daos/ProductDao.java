package cn.annpeter.insurance.daos;

import cn.annpeter.insurance.entities.products.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.MessageFormat;

/**
 * Created by annpeter on 3/19/16.
 */
@Repository
public class ProductDao extends BaseDao{
    @Resource
    SessionFactory sessionFactory;

    public Product getById(int id){
        String hql = MessageFormat.format("FROM jt_product WHERE id = {0}", id);

        return  (Product) getOne(hql);
    }
}
