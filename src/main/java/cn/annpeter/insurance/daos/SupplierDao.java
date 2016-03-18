package cn.annpeter.insurance.daos;

import java.util.List;

/**
 * Created by annpeter on 3/18/16.
 */
public class SupplierDao extends BaseDao {


    public List<?> list(){
        return getList("FROM jt_supplier");
    }
}
