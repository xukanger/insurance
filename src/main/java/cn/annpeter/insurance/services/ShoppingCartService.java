package cn.annpeter.insurance.services;

import cn.annpeter.insurance.daos.KaDanDao;
import cn.annpeter.insurance.daos.ProductDao;
import cn.annpeter.insurance.daos.ShoppingCartDao;
import cn.annpeter.insurance.entities.ShoppingCart;
import cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart.JsonResShoppingCartList;
import cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart.JsonShoppingCartList;
import cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart.JsonShoppingCartModify;
import cn.annpeter.insurance.entities.products.ProductKaDan;
import cn.annpeter.insurance.entities.products.Supplier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by annpeter on 3/19/16.
 */
@Service
public class ShoppingCartService {

    @Resource
    ShoppingCartDao shoppingCartDao;
    @Resource
    KaDanDao kaDanDao;

    public JsonResShoppingCartList list(int member_id){

        JsonResShoppingCartList jsonResponseShoppingCart = new JsonResShoppingCartList();

        jsonResponseShoppingCart.setMemver_id(member_id);

        List<ShoppingCart> shoppingCartList = (List<ShoppingCart>)shoppingCartDao.list(member_id);

        Iterator<ShoppingCart> it = shoppingCartList.iterator();

        while (it.hasNext()){
            ShoppingCart shoppingCart = it.next();

            int productId = shoppingCart.getProduct_id();
            //卡单里面有product的信息,所以这里直接获取卡单的信息就够了
            ProductKaDan productKaDan = kaDanDao.getByProductId(productId);
            Supplier supplier = productKaDan.getProduct().getSupplier();

           JsonShoppingCartList jsonShoppingCart =  new JsonShoppingCartList(productId, supplier.getId(), supplier.getTitle(),
                   supplier.getLogo(), productKaDan.getName(), productKaDan.getPrice(), shoppingCart.getNum());

            jsonResponseShoppingCart.getJsonShoppingCarts().add(jsonShoppingCart);
        }

        return  jsonResponseShoppingCart;
    }


    public Object modify(JsonShoppingCartModify jsonShoppingCartModify){



        return null;
    }
}
