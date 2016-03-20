package cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by annpeter on 3/19/16.
 */
public class JsonResShoppingCartList {
    Integer memver_id;

    List<JsonShoppingCartList> jsonShoppingCarts;

    public JsonResShoppingCartList(){
        if(jsonShoppingCarts == null){
            jsonShoppingCarts = new ArrayList<>();
        }
    }

    public Integer getMemver_id() {
        return memver_id;
    }

    public void setMemver_id(Integer memver_id) {
        this.memver_id = memver_id;
    }

    public List<JsonShoppingCartList> getJsonShoppingCarts() {
        return jsonShoppingCarts;
    }

    public void setJsonShoppingCarts(List<JsonShoppingCartList> jsonShoppingCarts) {
        this.jsonShoppingCarts = jsonShoppingCarts;
    }
}
