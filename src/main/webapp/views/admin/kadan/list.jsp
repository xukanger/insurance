<%--
  Created by IntelliJ IDEA.
  User: annpeter
  Date: 3/17/16
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<rapid:override name="head">

</rapid:override>

<rapid:override name="page_content">
    <div class="row">
        <div class="col-md-12">

            <!-- page message -->
            <!-- page message -->



            <div class="row">
                <div class="col-md-12">
                    <table
                            class="table table-striped table-condensed flip-content table-hover">
                        <thead class="flip-content">
                        <tr>
                            <th width="5%">ID</th>
                            <th>名称</th>
                            <th>种类</th>
                            <th>价格</th>
                            <th>开始时间</th>
                            <th>失效时间</th>
                            <th>当前状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value='#request.KaDanArrayList' var="v">
                            <tr>
                                <td><span style="line-height: 35px;text-align: center;"><s:property value='#v.id'/></span></td>
                                <td><span style="line-height: 35px;text-align: center;"><s:property value='#v.name'/></span></td><!--显示的是卡单的名称,而不是产品名称-->
                                <td><span style="line-height: 35px;text-align: center;"><s:property value='#v.card_cate'/></span></td>
                                <td><span style="line-height: 35px;text-align: center;"><s:property value='#v.price'/></span></td>
                                <td><span style="line-height: 35px;text-align: center;"><s:property value='#v.product.getStartDateStr()'/></span></td>
                                <td><span style="line-height: 35px;text-align: center;"><s:property value='#v.product.getEndDateStr()'/></span></td>
                                <td>
                                    <span style="line-height: 35px;text-align: center;">
                                        <s:if test='#v.product.status == 1'>
                                            <span class="label label-success label-sm">开启</span>
                                        </s:if>
                                        <s:elseif test='#v.product.status == 0'>
                                            <span class="label label-warning label-sm">关闭</span>
                                        </s:elseif>

                                    </span>
                                </td>
                                <td><span style="line-height: 35px;text-align: center;">
                                        <a class="btn btn-info btn-sm" href="/admin/kadan/profile?id=<s:property value='#v.id'/>">编辑</a>
                                        <a class="btn btn-danger btn-sm" onclick="return confirm('确定要删除该卡单吗？')" href="/admin/kadan/delete?id=<s:property value='#v.id'/>">删除</a>
                                    </span>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</rapid:override>

<jsp:include page="../public/index_base_template.jsp"></jsp:include>