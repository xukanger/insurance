package cn.annpeter.insurance.services;

import cn.annpeter.insurance.daos.KaDanDao;
import cn.annpeter.insurance.daos.ProductDao;
import cn.annpeter.insurance.daos.ShoppingCartDao;
import cn.annpeter.insurance.entities.ShoppingCart;
import cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart.JsonResShoppingCart;
import cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart.JsonShoppingCart;
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
    ProductDao productDao;
    @Resource
    KaDanDao kaDanDao;

    public JsonResShoppingCart list(int member_id){

        JsonResShoppingCart jsonResponseShoppingCart = new JsonResShoppingCart();

        jsonResponseShoppingCart.setMemver_id(member_id);

        List<ShoppingCart> shoppingCartList = (List<ShoppingCart>)shoppingCartDao.list(member_id);

        Iterator<ShoppingCart> it = shoppingCartList.iterator();

        while (it.hasNext()){
            ShoppingCart shoppingCart = it.next();

            int productId = shoppingCart.getProduct_id();
            ProductKaDan productKaDan = kaDanDao.getByProductId(productId);
            Supplier supplier = productKaDan.getProduct().getSupplier();

           JsonShoppingCart jsonShoppingCart =  new JsonShoppingCart(productId, supplier.getId(), supplier.getTitle(),
                   supplier.getLogo(), productKaDan.getName(), productKaDan.getPrice(), shoppingCart.getNum());

            jsonResponseShoppingCart.getJsonShoppingCarts().add(jsonShoppingCart);
        }

        return  jsonResponseShoppingCart;
    }

}
