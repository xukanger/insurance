package cn.annpeter.insurance.services;

import cn.annpeter.insurance.daos.KaDanDao;
import cn.annpeter.insurance.entities.products.JsonKaDanShow;
import cn.annpeter.insurance.entities.products.Product;
import cn.annpeter.insurance.entities.products.ProductKaDan;
import cn.annpeter.insurance.utils.ExceptionUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by annpeter on 3/14/16.
 */
@Service
public class KaDanService  extends BaseService{

    @Resource
    private KaDanDao kaDanDao;

    public KaDanDao getKaDanDao() {
        return kaDanDao;
    }

    public void setKaDanDao(KaDanDao kaDanDao) {
        this.kaDanDao = kaDanDao;
    }

    public List<?> adminList() throws ExceptionUtils{
        return  kaDanDao.list();
    }


    /**
     * 根据JsonKaDanShow定义的字段,将整个卡单的信息进行删减,提供给Action显示给用户
     * id 名称 种类 价格 开始时间 失效时间 当前状态 操作(编辑,删除)
     * @return
     * @throws ExceptionUtils
     */
    public List<?> list() throws ExceptionUtils {

        List<ProductKaDan>  kaDanList = (List<ProductKaDan> )kaDanDao.list();

        List < Object> result = new ArrayList<>();

        result = getJsonList(kaDanList, JsonKaDanShow.class);

        return result;
    }

    /**
     * 获取整个卡单对象
     * @param kId
     * @return
     */
    public Object getById(int kId){
        return (ProductKaDan)kaDanDao.getById(kId);
    }

    /**
     * 保存新的卡单对象, 返回保存后的对象给Action
     * @param kaDan
     * @return
     */
    public Object save(ProductKaDan kaDan){
        kaDanDao.saveOrUpdate(kaDan);
        return kaDan;
    }


    public void delete(int id){
        kaDanDao.delete(id);
    }

    /**
     * 更新对象, 为了防止原来的对象中一些字段被篡改
     * 在这里根据要修改对象的id,到数据库中获取到原来的对象,
     * 然后根据该模块的需求,将新对象中的数据赋值给老的对象进行修改
     *
     * 在这里无须再次判定数据对象是否为空,
     * 因为在view中提供要修改的对象和这里的对象是一一对应的
     * 至于数据的检测,目前放在Action中和客户端完成
     *
     * @param newKaDan
     * @return
     */
    public Object update(ProductKaDan newKaDan){
        ProductKaDan oldKaDan = (ProductKaDan) getById(newKaDan.getId());

        /**
         * 不需要,或者不能够修改的字段在这里控制
         */

        //修改简介图
        oldKaDan.setCard_img_big(newKaDan.getCard_img_big());
        //修改产品名称
        oldKaDan.setCard_name(newKaDan.getCard_name());
        //修改产品描述
        oldKaDan.setCard_desc(newKaDan.getCard_desc());
        //修改价格
        oldKaDan.setCard_price(newKaDan.getCard_price());

        /**
         *修改产品相关的信息
         */
        //修改供应商
        oldKaDan.getProduct().setSupplier_id(newKaDan.getProduct().getSupplier_id());
        //修改开始时间
        oldKaDan.getProduct().setStart_date(newKaDan.getProduct().getStart_date());
        //修改结束时间
        oldKaDan.getProduct().setEnd_date(newKaDan.getProduct().getEnd_date());
        //修改是否开启
        oldKaDan.getProduct().setStatus(newKaDan.getProduct().getStatus());

        //修改保险分类
        oldKaDan.setCard_buy_type(newKaDan.getCard_buy_type());
        //修改投保要求
        oldKaDan.setConditions(newKaDan.getConditions());
        //修改产品详情
        oldKaDan.setCard_detail(newKaDan.getCard_detail());
        //修改投保范围
        oldKaDan.setCard_range(newKaDan.getCard_range());
        //修改投保须知
        oldKaDan.setCard_info(newKaDan.getCard_info());
        //修改售后服务
        oldKaDan.setAfter_sale_service(newKaDan.getAfter_sale_service());
        //修改保单形式
        oldKaDan.setCard_form_detail(newKaDan.getCard_form_detail());

        kaDanDao.saveOrUpdate(oldKaDan);
        return oldKaDan;
    }
}
