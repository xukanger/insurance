<%@page import="cn.annpeter.insurance.utils.WebUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<%
	String basePath = WebUtils.getBasePath();
%>

<rapid:override name="head">

</rapid:override>


<rapid:override name="page_content">
	<!-- BEGIN PAGE CONTENT-->
	<div class="row">
		<div class="col-md-12">

			<!-- page message -->
			<!-- page message -->

			<div class="row">
				<div class="col-md-6">
					<form class="form-inline" method="get">
						<a href="#">
							<b>全部账号</b>
						</a>
						<a href="#">
							<b>马甲账号</b>
						</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-success" target="_blank" href="http://7xou6n.media1.z0.glb.clouddn.com/%E7%94%A8%E6%88%B7%E5%88%97%E8%A1%A8_0.mp4">
							<i class="fa fa-video-camera"></i>
							视频教程
						</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" name="keyword" value="" class="form-control placeholder"
							placeholder="用户id/用户名/手机号">

						<button type="submit" class="btn green">搜索</button>
					</form>
				</div>
				<div class="col-md-6">
					<form class="form-inline" action="#"
						method="get">
						<input type="text" name="uids" value="" class="form-control placeholder" placeholder="UID用,隔开">
						<div class="checker" id="uniform-is_vest">
							<span>
								<input type="checkbox" id="is_vest" value="1" name="is_vest">
							</span>
						</div>
						<label for="is_vest">设置为马甲</label>
						<button type="submit" class="btn green">导入用户</button>
					</form>
				</div>
			</div>

			<div class="blank"></div>

			<div class="row">
				<div class="col-md-12">
					<table
						class="table table-striped table-condensed flip-content table-hover">
						<thead class="flip-content">
							<tr>
								<th width="5%">ID</th>
								<th>姓名</th>
								<th>手机</th>
								<th>操作</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value='#request.UserArrayList' var="v">
							   <tr style="height: 45px;">
								<td><s:property value='id'/><s:property value="#v.id"/></td>
								<td><s:property value='name'/>
									<s:if test='#v.sex == 1'>
										<i class="fa fa-male critical"></i>
									</s:if>
									<s:elseif test='#v.sex == 2'>
										<i class="fa fa-female warning"></i>
									</s:elseif>
								</td>
								<td><s:property value='#v.phone'/></td>
								<td>
									<a href="#"
										data-toggle="modal" class="btn btn-xs setting-forbid"
										data-name="wanjinxing102" data-id="4866">禁言</a>|
									<a href="<%=basePath%>admin/user/profile?id=<s:property value="id"/>"> 查看信息 </a> |
									<a href="#">查看评论 </a> |
									<a href="#">设为马甲</a>
								</td>
								<td>	</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>

			<script type="text/javascript">
				$(document).ready(function() {
					isallchecked();
				});

				//点击单个
				function toggleVest(user_id) {
					isallchecked();
					window.location.href = '/admin/user/toggleVest?uid='
							+ user_id;
				}

				//点赞全选是否被选中
				function isallchecked() {
					if ($('input[name=vestshow]:checked').length == $('input[name=vestshow]').length) {
						$('#allchecked').attr('checked', true);
					} else {
						$('#allchecked').attr('checked', false);
					}
				}
				//

				//点击全选操作
				$('#allchecked').click(function() {
					toggleCheck($(this).attr('checked'));
				});

				//全选和反选
				function toggleCheck(type) {
					if (type) {
						$('input[name=vestshow]').each(
								function() {
									if (!$(this).attr('checked')) {
										var th = $(this);
										var user_id = th.attr('data-vest');
										$.get('/admin/user/toggleVest?uid='
												+ user_id, function(data) {
										});
										th.attr('checked', true);
										th.parents('span').addClass('checked');
									}

								});
					} else {
						$('input[name=vestshow]').each(
								function() {
									if ($(this).attr('checked')) {
										var th = $(this);
										var user_id = th.attr('data-vest');
										$.get('/admin/user/toggleVest?uid='
												+ user_id, function(data) {
										});
										th.attr('checked', false);
										th.parents('span').removeClass(
												'checked');
									}
								});
					}
				}
			</script>

			<div class="row">
				<div class="col-md-12 pagination" style="margin: 0;">
					<div>
						<ul class=" pagination pull-right" id="yw0">
							<li class="previous <s:if test='#request.UserPage.isHasPreviousPage() == false'>disabled</s:if>">
								<a href="<%=basePath%>admin/user/list?page=<s:property value='#request.UserPage.getPreviousPageNumber()'/>">上一页</a>
							</li>
							<s:iterator value='#request.UserPage.getLinkPageNumbers()' var='v'>
								<li class="<s:if test='#request.UserPage.getThisPageNumber() == #v'>active</s:if>">
									<a href="<%=basePath%>admin/user/list?page=<s:property value="#v"/>"><td><s:property value='#v'/></td></a>
								</li>
							</s:iterator>
							<li class="next <s:if test='#request.UserPage.isHasNextPage() == false'>disabled</s:if>">
								<a href="<%=basePath%>admin/user/list?page=<s:property value='#request.UserPage.getNextPageNumber()'/>">下一页</a>
							</li>
						</ul>
						<div style="clear: both;"></div>
					</div>

				</div>
			</div>

			<div id="forbidForm" class="modal fade" tabindex="-1"
				data-width="400" aria-hidden="true" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">为wanjinxing102设置禁言</h4>
						</div>
						<div class="modal-body">
							<div class="row form-horizontal">
								<div class="col-md-12">
									<div class="form-group">
										<label class="col-md-3 control-label">输入禁言天数</label>
										<div class="col-sm-7">
											<select name="days" class="form-control">
												<option>请选择</option>
												<option value="1">禁言1天</option>
												<option value="3">禁言3天</option>
												<option value="7">禁言7天</option>
												<option value="10000">永久禁言</option>
												<option value="0">解除禁言</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">禁言理由</label>
										<div class="col-sm-7">
											<select name="reason" class="form-control">
												<option>请选择</option>
												<option value="不当发言">不当发言</option>
												<option value="刷广告">刷广告</option>
												<option value="主题涉及违规信息">主题涉及违规信息</option>
												<option value="解除禁言">解除禁言</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">消息通知</label>
										<div class="col-sm-7">
											<label><input name="send" type="radio" value="1">
												开启</label> <label><input name="send" type="radio" value="0"
												checked=""> 关闭</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">消息通知</label>
										<div class="col-sm-7">
											<textarea class="form-control" name="message" id="" cols="30"
												rows="10"></textarea>
											<span style="color: red;">禁言之后无法发表和回复本地圈/无法使用聊天系统</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn">关闭</button>
							<button type="button" class="btn red btn-ok">确定</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END PAGE CONTENT-->
</rapid:override>
<jsp:include page="../public/index_base_template.jsp"></jsp:include>