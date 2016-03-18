package cn.annpeter.insurance.daos;

import cn.annpeter.insurance.daos.BaseDao;
import cn.annpeter.insurance.entities.products.ProductKaDan;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by annpeter on 3/14/16.
 */
@Repository
public class KaDanDao extends BaseDao {


    public List<?> list(){
        return  getList("FROM jt_p_kadan");
    }


    public Object getById(int kId){
        Object obj =  getOne(MessageFormat.format("FROM jt_p_kadan WHERE id = {0}", kId));
        if(obj == null) {
            throw new NullPointerException("在"+KaDanDao.class.toString()+"中,没有找到id为"+kId+"的对象");
        }
        return obj;
    }

    public void delete(int kId){
        delete(getById(kId));
    }
}
