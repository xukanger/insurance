package cn.annpeter.insurance.entities.jsonBeans.app.shoppingcart;

/**
 * Created by annpeter on 3/19/16.
 */
public class JsonShoppingCartList {
    Integer id;   //产品id

    Integer supplier_id;

    String supplier_title;

    String supplier_logo;

    String kadan_name;

    Integer kadan_price;

    Integer card_num;

    public JsonShoppingCartList(Integer id, Integer supplier_id, String supplier_title, String supplier_logo, String kadan_name, Integer kadan_price, Integer card_num) {
        this.id = id;
        this.supplier_id = supplier_id;
        this.supplier_title = supplier_title;
        this.supplier_logo = supplier_logo;
        this.kadan_name = kadan_name;
        this.kadan_price = kadan_price;
        this.card_num = card_num;
    }
}
