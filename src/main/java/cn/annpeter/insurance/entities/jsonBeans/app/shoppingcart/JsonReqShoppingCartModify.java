package cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by annpeter on 3/20/16.
 */
public class JsonReqShoppingCartModify {
    Integer memver_id;

    List<JsonShoppingCartModify> jsonShoppingCartModifies;

    JsonReqShoppingCartModify(){
        if(jsonShoppingCartModifies == null){
            jsonShoppingCartModifies = new ArrayList<>();
        }
    }


    public Integer getMemver_id() {
        return memver_id;
    }

    public void setMemver_id(Integer memver_id) {
        this.memver_id = memver_id;
    }

    public List<JsonShoppingCartModify> getJsonShoppingCartModifies() {
        return jsonShoppingCartModifies;
    }

    public void setJsonShoppingCartModifies(List<JsonShoppingCartModify> jsonShoppingCartModifies) {
        this.jsonShoppingCartModifies = jsonShoppingCartModifies;
    }

    @Override
    public String toString() {
        return "JsonReqShoppingCartModify{" +
                "memver_id=" + memver_id +
                ", jsonShoppingCartModifies=" + jsonShoppingCartModifies +
                '}';
    }
}
