<%--
  Created by IntelliJ IDEA.
  User: annpeter
  Date: 3/17/16
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<rapid:override name="head">
    <script type="text/javascript" src="/static/admin/public/javascript/plupload.full.min.js"></script>
</rapid:override>

<rapid:override name="page_content">

    <div class="portlet box purple">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa fa-reorder"></i>添加卡单
            </div>

        </div>
        <div class="portlet-body form">

            <form action="/admin/kadan/add" method="post" class="form-horizontal">
                <input type="hidden" name="productKaDan.id" value="<s:property value='#request.ProductKaDan.id'/>"/><!-- 隐藏域，用户id -->
                <div class="row">
                    <div class="col-md-8">
                        <!-- BEGIN FORM-->

                            <div class="form-body">

                                <div class="form-group">
                                    <label class="control-label col-md-2">简介图(640*200)</label>
                                    <div class="col-md-6">

                                        <!--single-->
                                        <div class="plupload_container" style="position: relative;">
                                            <div id="ZEOA" class="btn btn-info" style="position: relative; z-index: 1;">  <i class="fa fa-plus"></i> 上传文件 <span class="info"></span></div>
                                        </div>
                                        <img src="<s:property value='#request.ProductKaDan.card_img_big'/>" style="display:none;"  alt="" id="cardImgBig" height="100">
                                        <input type="hidden" id="cardImgBigUrl" name="productKaDan.card_img_big" value="<s:property value='#request.ProductKaDan.card_img_big'/>">
                                        <script type="text/javascript">
                                            function uploadsingle(file, response) {
                                                var url = response.result.url;
                                                $('#cardImgBigUrl').val(url);
                                                $('#cardImgBig').attr('src', url).show();
                                            }
                                        </script>
                                    </div>
                                    <script type="text/javascript">
                                        jQuery(function($) {

                                            var ZEOA = new plupload.Uploader({
                                                runtimes: 'html5,flash,silverlight,html4',
                                                browse_button: 'ZEOA',
                                                url: '/admin/upload/index',
                                                flash_swf_url: '/static/admin/public/swf/Moxie.swf',
                                                silverlight_xap_url: '/static/admin/public/swf/Moxie.swf',
                                                multipart:true,
                                                filters: {
                                                    max_file_size: '512000',
                                                    mime_types: [
                                                        {title: "Files", extensions: "jpg,jpeg,png,bmp,gif"}
                                                    ],
                                                    prevent_duplicates:false
                                                },
                                                file_data_name:'fileData',
                                                multi_selection: false,

                                                init: {
                                                    FilesAdded: function (up, files) {
                                                        up.start();
                                                    },

                                                    FileUploaded: function(up, file, info) {
                                                        info = $.parseJSON(info.response);
                                                        if(info!=undefined){
                                                            if(info.error!=undefined){
                                                                alert("["+info.error.code+"]"+info.error.message)
                                                            }else{
                                                                var status = info.status;
                                                                if (status != undefined && status =='success') {
                                                                    uploadsingle(file, info);
                                                                }
                                                            }
                                                        }
                                                    },

                                                    UploadProgress: function (up, file) {
                                                        var $percent = $("#ZEOA span.info");
                                                        if(file.percent==100){
                                                            $percent.text("");
                                                        }else{
                                                            $percent.text(file.percent + '%');
                                                        }
                                                    },

                                                    Error: function (up, err) {
                                                        alert("[" + err.code + "]" + err.message)
                                                    }
                                                }
                                            });

                                            ZEOA.init();
                                            if($('#cardImgBig').attr('src')){
                                                $('#cardImgBig').show();
                                            }
                                        });
                                    </script>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-md-2">产品名称</label>
                                    <div class="col-md-6">
                                        <input name="productKaDan.card_name" value="<s:property value='#request.ProductKaDan.card_name'/>" type="text" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-2">产品描述</label>
                                    <div class="col-md-6">
                                        <input name="productKaDan.card_desc" value="<s:property value='#request.ProductKaDan.card_desc'/>" type="text" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-2">价格</label>
                                    <div class="col-md-6">
                                        <input name="productKaDan.card_price" value="<s:property value='#request.ProductKaDan.card_price'/>" type="text" class="form-control">
                                    </div>
                                </div>

                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-2">数量</label>--%>
                                    <%--<div class="col-md-6">--%>
                                        <%--<input name="description" value="1213" type="text" class="form-control">--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-2">产品概要</label>--%>
                                    <%--<div class="col-md-6">--%>
                                        <%--<input name="productKaDan.card_price" value="10万意外伤害+5万医疗" type="text" class="form-control">--%>
                                    <%--</div>--%>
                                <%--</div>--%>


                                <div class="form-group">
                                    <label class="control-label col-md-2">提供商</label>
                                    <div class="col-md-6">
                                        <input name="productKaDan.product.supplier_id" value="<s:property value='#request.ProductKaDan.product.supplier_id'/>" type="text" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-2">保险分类</label>
                                    <div class="col-md-6">
                                        <input name="productKaDan.card_cate" value="<s:property value='#request.ProductKaDan.card_cate'/>" type="text" class="form-control">
                                    </div>
                                </div>



                                <div class="form-group">
                                    <label class="control-label col-md-2">投保要求</label>
                                    <div class="col-md-6">
                                        <input name="productKaDan.conditions" value="<s:property value='#request.ProductKaDan.conditions'/>" type="text" class="form-control">
                                    </div>
                                </div>

                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-2">尺寸</label>--%>
                                    <%--<div class="col-md-6">--%>
                                        <%--<input name="description" value="其它" type="text" class="form-control">--%>
                                    <%--</div>--%>
                                <%--</div>--%>


                                <div class="form-group">
                                    <label class="col-md-2 control-label">产品详情</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" name="productKaDan.card_detail"><s:property value='#request.ProductKaDan.card_detail'/></textarea>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保范围</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" name="productKaDan.card_range"><s:property value='#request.ProductKaDan.card_range'/></textarea>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-2 control-label">投保须知</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" name="productKaDan.card_info"><s:property value='#request.ProductKaDan.card_info'/></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">售后服务</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" name="productKaDan.after_sale_service"><s:property value='#request.ProductKaDan.after_sale_service'/></textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2 control-label">保单形式</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" name="productKaDan.card_form_detail"><s:property value='#request.ProductKaDan.card_form_detail'/></textarea>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-md-2">开始时间</label>
                                    <div class="col-md-6">
                                        <div class="input-group date form_datetime">
                                            <input type="text" size="16" name="productKaDan.product.start_date" readonly="" class="form-control" value="<s:property value='#request.ProductKaDan.product.getStartDateStr()'/>" placeholder="开始时间">
                                <span class="input-group-btn">
                                    <button class="btn default date-set" type="button"><i class="fa fa-calendar"></i></button>
                                </span>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-2">结束时间</label>
                                    <div class="col-md-6">
                                        <div class="input-group date form_datetime">
                                            <input type="text" size="16" name="productKaDan.product.end_date" readonly="" class="form-control" value="<s:property value='#request.ProductKaDan.product.getEndDateStr()'/>" placeholder="结束时间">
                                            <span class="input-group-btn">
                                                <button class="btn default date-set" type="button"><i class="fa fa-calendar"></i></button>
                                            </span>
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-md-2">是否开启</label>
                                    <div class="radio-list col-md-6">
                                        <label class="radio-inline"><input type="radio" name="productKaDan.product.status" value="1" >是</label>
                                        <label class="radio-inline"><input type="radio" name="productKaDan.product.status" value="0" checked>否</label>
                                    </div>
                                </div>

                            </div>


                        <!-- END FORM-->
                    </div>
                    <div class="col-md-4" style="height: auto;">

                            <%--Phone Begin--%>
                        <div id="phone" style="width: 350px;height: 706px;scroll:no;overflow-x:hidden;
                            background: url(/static/phone/public/images/iphone_6.png);margin-left: auto;margin-right: auto; position: relative;">
                            <div style="left: 30px;top: 96px;height: 517px;width: 289px; overflow:scroll;overflow-x:hidden;position: absolute">

                                <div id="phone" style="width: 289px;height: 568px;overflow-y:scroll;  overflow-x:hidden;background-color: #6e1881;margin-left: auto;margin-right: auto">


                                    <style>
                                        #phone ::-webkit-scrollbar{width:0px;}
                                    </style>

                                    <link rel="stylesheet" href="/static/phone/public/css/mui.css" />
                                    <link rel="stylesheet" type="text/css" href="/static/phone/public/css/common.css" />
                                    <link rel="stylesheet" type="text/css" href="/static/phone/kadan/css/insur_card_info.css" />

                                    <div style="background:#f4f4f4;">
                                        <div class="mui-content">
                                            <img src="/static/phone/kadan/images/homePage/slider4.jpg" width="100%" />
                                            <div class="xmain">
                                                <h2>如E少儿意外保险计划</h2>
                                                <h3>平安鸿运随行系列</h3>
                                                <div class="bt">
                                                    <div class="bt-left">参考价：<strong>￥128.00</strong></div>
                                                    <div style="clear:both;"></div>
                                                </div>
                                                <div class="yf">
                                                    <div class="yf-left">送至：江苏省 &nbsp;&nbsp;免运费</div>
                                                    <div class="yf-right"><img src="/static/phone/kadan/images/goods/insur_card/jj.png" width="25" /></div>
                                                    <div style="clear:both;"></div>
                                                </div>
                                            </div>
                                            <div class="xmain">
                                                <div class="baoz"><strong>售后保障</strong>
                                                    <p>卖家承诺以下服务</p>
                                                </div>
                                                <div class="pic1"><img src="/static/phone/kadan/images/goods/insur_card/u1.jpg" width="20" />
                                                    <br/>消费者保障服务</div>
                                                <div class="pic1"><img src="/static/phone/kadan/images/goods/insur_card/u1.jpg" width="20" />
                                                    <br/>消费者保障服务</div>
                                                <div class="pic2"><img src="/static/phone/kadan/images/goods/insur_card/jj.png" width="25" /></div>
                                                <div style="clear:both;"></div>
                                            </div>
                                            <div class="xmain">
                                                <div class="xuanz-fl">
                                                    <strong>卡单保障</strong>
                                                    <p>10万意外伤害+5万医疗</p>
                                                </div>
                                                <div class="xuanz-sl">
                                                    <strong>数量:</strong>
                                                    <h3><input type="button" value="-" class="slsl"><input value="1" class="slsloo"><input type="button" value="+" class="slsl"></h3>
                                                    <div style="clear:both;"></div>
                                                </div>
                                            </div>
                                            <div class="xmain">
                                                <div class="xuanz-cp">
                                                    <strong>卡单简介</strong>
                                                    <p><strong>提供商</strong>中国人寿保险股份有限公司</p>
                                                    <p><strong>保险分类</strong>少儿意外险</p>
                                                    <p><strong>种类</strong>保险卡单</p>
                                                    <p><strong>激活</strong>自主激活，线上激活</p>
                                                    <p><strong>投保要求</strong>出生28日以上、6周岁（不含）以下、身体健康的儿童</p>
                                                    <p><strong>尺寸</strong>其他</p>
                                                    <div style="clear:both;"></div>
                                                </div>
                                            </div>
                                            <div class="xmain">
                                                <div class="xuanz-xq">
                                                    <ul class="" id="mui-table-content">
                                                        <li class="">
                                                            <a class="" >产品详情</a>
                                                            <div class="">
                                                                <p> 如E少儿意外保险计划提供意外伤害伤残、意外骨折，以及意外伤害医疗保障，为您的宝贝提供全方位的呵护。</p>
                                                            </div>
                                                        </li>
                                                        <li class="">
                                                            <a >投保范围</a>
                                                            <div class="">
                                                                <p>凡出生28日以上、6周岁（不含）以下、身体健康的儿童，均可作为被保险人参加如E少儿意外保险计划。投保人须为被保险人的父母。</p>
                                                            </div>
                                                        </li>
                                                        <li class="">
                                                            <a >投保须知</a>
                                                            <div class="">
                                                                <p>1、每一被保险人限通过如E少儿意外保险计划投保一次。保险合同生效日由投保人在投保时指定，但不能早于投保当日的次日，且不能晚于投保当日之后15日。保险合同生效后方能享受保险保障。 </p>
                                                                <p>2、若被保险人已参加学生儿童基本医疗保险，意外伤害门诊费用补偿保险金的免赔额为100元，给付比例为80％，意外伤害住院费用补偿医疗保险金的免赔额为0元，给付比例为90％。若被保险人未参加学生儿童基本医疗保险，意外伤害门诊费用补偿医疗保险金的免赔额为200元，给付比例为70%，意外伤害住院费用补偿医疗保险儿童基本医疗保险金的免赔额100元，给付比例为80%。</p>
                                                                <p>3、投保成功后，投保人将收到如E少儿意外保险计划的电子保险单。投保人在投保成功后可登录www.chinalife.com.cn或致电中国人寿客户服务电话95519，查询保单信息。</p>
                                                                <p>4、若发生保险事故，需打印如E少儿意外伤害保险计划的电子保险单，并凭身份证明、电子保险单、相关出险证明和本公司要求提供的其他资料办理理赔手续。报案电话：95519</p>
                                                            </div>
                                                        </li>
                                                        <li class="">
                                                            <a class="">售后服务</a>
                                                            <div class="">
                                                                <p>投保人在投保成功后可登录www.chinalife.com.cn或致电中国人寿客户服务电话95519，查询保单信息。</p>
                                                            </div>
                                                        </li>
                                                        <li class="">
                                                            <a class="" >保单形式</a>
                                                            <div class="">
                                                                <p>本合同采用电子保险单的形式承保，您可以通过95519查询保单。如您需要发票，请拨打客服热线：95519。</p>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                    <div style="clear:both;"></div>
                                                </div>
                                            </div>


                                            <div style="width:100%; height:60px;"></div>
                                            <div class="doot">
                                                <div class="doot-left">
                                                    <button class="huang">加入购物车</button>
                                                </div>
                                                <div class="doot-right">
                                                    <button class="hong" id="buying">立即购买</button>
                                                </div>
                                            </div>
                                            <div style="clear:both;"></div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                            <%--Phone End--%>

                    </div>
                </div>

                    <div class="form-actions fluid">
                        <div class="col-md-offset-2 col-md-10">
                            <button type="submit" class="btn green">提交</button>
                            <a href="/admin/activity/list/" type="button" class="btn default">取消</a>
                        </div>
                    </div>
                </form>
            </div>
    </div>



</rapid:override>

<jsp:include page="../public/index_base_template.jsp"></jsp:include>