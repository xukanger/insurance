package cn.annpeter.insurance.services;

import cn.annpeter.insurance.daos.ShoppingCartDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by annpeter on 3/19/16.
 */
@Service
public class ShoppingCartService {

    @Resource
    ShoppingCartDao shoppingCartDao;

    public List<?> list(){
        return null;
    }

}
