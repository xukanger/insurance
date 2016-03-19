package cn.annpeter.insurance.daos;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by annpeter on 3/19/16.
 */
@Repository
public class ShoppingCartDao extends BaseDao{
    @Resource
    SessionFactory sessionFactory;

    /**
     * 获取当前保险员所有的购物单
     * @param memberId
     * @return
     */
    public List<?> list(int memberId){
        return getList(MessageFormat.format("FROM jt_shoppingcart WHERE member_id = {0} ", memberId));
    }


}
