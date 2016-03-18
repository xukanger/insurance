<%@page import="cn.annpeter.insurance.utils.WebUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<%
	String basePath = WebUtils.getBasePath();
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<title>
		<rapid:block name="title"></rapid:block>
	</title>
	<jsp:include page="base_head.jsp"></jsp:include>

	<link href="/static/admin/public/css/emoji.css" rel="stylesheet"	type="text/css">
	<!-- END GLOBAL MANDATORY STYLES -->
	
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link href="/static/admin/public/css/jquery.fancybox.css" rel="stylesheet"	type="text/css">
	<link rel="stylesheet" type="text/css"	href="/static/admin/public/css/colorpicker.css">
	<link rel="stylesheet" type="text/css"	href="/static/admin/public/css/datetimepicker.css">
	<link rel="stylesheet" type="text/css"	href="/static/admin/public/css/select2.css">
	<link rel="stylesheet" type="text/css"	href="/static/admin/public/css/select2-bootstrap.css">
	
	
	
	<!-- END PAGE LEVEL STYLES -->
	
	<!-- BEGIN THEME STYLES -->
	<link href="/static/admin/public/css/style-metronic.css" rel="stylesheet"	type="text/css">
	<link href="/static/admin/public/css/style.css" rel="stylesheet"	type="text/css">
	<link href="/static/admin/public/css/style-responsive.css" rel="stylesheet"	type="text/css">
	<link href="/static/admin/public/css/plugins.css" rel="stylesheet"	type="text/css">
	<link href="/static/admin/public/css/portfolio.css" rel="stylesheet"	type="text/css">
	
	<link href="/static/admin/public/css/default.css" rel="stylesheet"	type="text/css" id="style_color">
	<link href="/static/admin/public/css/custom.css" rel="stylesheet"	type="text/css">
	<link rel="stylesheet" type="text/css"	href="/static/admin/public/css/toastr.min.css">
	<script src="/static/admin/public/javascript/jquery-1.10.2.min.js"	type="text/javascript"></script>
	<script src="/static/admin/public/javascript/jquery-migrate-1.2.1.min.js"	type="text/javascript"></script>
	<script src="/static/admin/public/javascript/bootstrap.min.js"	type="text/javascript"></script>
	
	
	
	
	<!-- Add mousewheel plugin (this is optional) -->
	<script type="text/javascript"	src="/static/admin/public/javascript/jquery.mousewheel-3.0.6.pack.js"></script>
	
	<!-- Add fancyBox -->
	<link rel="stylesheet"	href="/static/admin/public/css/jquery.fancybox.css" type="text/css"
		media="screen">
	<script type="text/javascript"	src="/static/admin/public/javascript/jquery.fancybox.pack.js"></script>
	
	<!-- Optionally add helpers - button, thumbnail and/or media -->
	<link rel="stylesheet"	href="/static/admin/public/css/jquery.fancybox-buttons.css"	type="text/css" media="screen">
	<script type="text/javascript"	src="/static/admin/public/javascript/jquery.fancybox-buttons.js"></script>
	<script type="text/javascript"	src="/static/admin/public/javascript/jquery.fancybox-media.js"></script>
	
	<link rel="stylesheet"	href="/static/admin/public/css/jquery.fancybox-thumbs.css" type="text/css"	media="screen">
	<script type="text/javascript"	src="/static/admin/public/javascript/jquery.fancybox-thumbs.js"></script>
	
	
	<link rel="stylesheet"	href="/static/admin/public/css/bootstrap-multiselect.css" type="text/css">
	<script type="text/javascript"	src="/static/admin/public/javascript/bootstrap-multiselect.js"></script>
	
	<!-- END THEME STYLES -->
	<rapid:block name="head">
	
	</rapid:block>
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<rapid:block name="content">
<body class="page-header-fixed">
	<div class="header navbar navbar-fixed-top">
	<!-- BEGIN TOP NAVIGATION BAR -->
	<div class="header-inner">
		<!-- BEGIN LOGO -->

		<a class="navbar-brand" href="">
			&nbsp;&nbsp;&nbsp;
			<span style="color: #f00;">AnnPeter</span>
			<span style="color: #fff;">管理后台</span>
		</a>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse"> 
			<img src="/static/admin/public/images/menu-toggler.png" alt="">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<ul class="nav navbar-nav pull-right">
			<!-- BEGIN USER LOGIN DROPDOWN -->
			<li class="dropdown user">
				<a	href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					data-hover="dropdown" data-close-others="true">
					<span	class="username"> admin </span>
					<i class="fa fa-angle-down"></i>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a	href="#">
							<i	class="fa fa-user"></i> 
							我的信息
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="javascript:;" id="trigger_fullscreen">
							<i	class="fa fa-arrows"></i>
							全屏查看
						</a>
					</li>
					<li>
						<a	href="#">
							<i	class="fa fa-lock"></i>
							锁定屏幕
						</a>
					</li>
					<li class="divider"></li>
					<li>
						<a	href="#">
							<i	class="fa fa-key"></i>
							注销登陆
						</a>
					</li>
				</ul>
			</li>
			<!-- END USER LOGIN DROPDOWN -->
		</ul>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END TOP NAVIGATION BAR -->
</div>	
	
	<div class="clearfix"></div>
	
	<rapid:block name="content_page">
		<div class="page-container">
			<!-- BEGIN SIDEBAR -->
			<div class="page-sidebar-wrapper">
				<div class="page-sidebar navbar-collapse collapse">
	
					<!-- BEGIN SIDEBAR MENU -->
					<ul class="page-sidebar-menu" data-auto-scroll="true"	data-slide-speed="200">
						<s:property value="#request.LeftNavHtml" escape="false"></s:property>	
					</ul>
					<!-- END SIDEBAR MENU -->
				</div>
			</div>
			<!-- END SIDEBAR -->
			<!-- BEGIN CONTENT -->
			<div class="page-content-wrapper">
				<div class="page-content" style="min-height: 740px !important">

					<!-- BEGIN PAGE HEADER-->
					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN PAGE TITLE & BREADCRUMB-->
							<h3 class="page-title">
								<span style=""><s:property value="#request.ActionDesc" escape="false"></s:property></span>
							</h3>
							<span style="color: #999; font-size: 14px;"></span>
							<ul class="page-breadcrumb breadcrumb">
								<li>
									<i class="fa fa-home"></i>
									<a href="<%=basePath%>admin/index/index">首页</a>
									<i class="fa fa-angle-right"></i>
								</li>
								<li><s:property value="#request.MethodDesc" escape="false"></s:property></li>
							</ul>
							<!-- END PAGE TITLE & BREADCRUMB-->
						</div>
					</div>
					<!-- END PAGE HEADER-->

					<!-- BEGIN PAGE CONTENT-->
					<rapid:block name="page_content"></rapid:block>
					<!-- END PAGE CONTENT-->
                    <s:debug></s:debug>
				</div>
			</div>
			<!-- END CONTENT -->
		</div>
	</rapid:block>
	
	<rapid:block name="content_footer">
		<!-- BEGIN FOOTER -->
		<div class="footer">
			<div class="footer-inner">2016 © AnnPeter.</div>
			<div class="footer-tools">
				<span class="go-top"> <i class="fa fa-angle-up"></i>
				</span>
			</div>
		</div>
		<!-- END FOOTER -->
	</rapid:block>
	

<rapid:block name="page_script">

</rapid:block>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->

<!--[if lt IE 9]>
	<script src="/static/admin/public/javascript/respond.min.js"></script>
	<script src="/static/admin/public/javascript/excanvas.min.js"></script>
<![endif]-->

<script src="/static/admin/public/javascript/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="/static/admin/public/javascript/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/static/admin/public/javascript/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/static/admin/public/javascript/jquery.cokie.min.js" type="text/javascript"></script>
<script src="/static/admin/public/javascript/jquery.uniform.min.js" type="text/javascript"></script>

<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->

<script src="/static/admin/public/javascript/jquery.mixitup.min.js" type="text/javascript"></script>
<script src="/static/admin/public/javascript/jquery.fancybox.js" type="text/javascript"></script>
<script type="text/javascript" src="/static/admin/public/javascript/bootstrap-colorpicker.js"></script>
<script type="text/javascript" src="/static/admin/public/javascript/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="/static/admin/public/javascript/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript" src="/static/admin/public/javascript/select2.min.js"></script>

<!-- END PAGE LEVEL PLUGINS -->

<script src="/static/admin/public/javascript/app.js"></script>
<script src="/static/admin/public/javascript/components-pickers.js"></script>
<script src="/static/admin/public/javascript/bootbox.min.js" type="text/javascript"></script>
<script src="/static/admin/public/javascript/toastr.min.js"></script>
<script src="/static/admin/public/javascript/portfolio.js"></script>

<script>
jQuery(document)
		.ready(
				function() {
					// initiate layout and plugins
					App.init();
					Portfolio.init();
					var handleColorPicker = function() {
						if (!jQuery().colorpicker) {
							return;
						}
						$('.colorpicker-default').colorpicker({
							format : 'hex'
						});
						$('.colorpicker-rgba').colorpicker();
					}
					handleColorPicker();
					// 初始化菜单
					$('li.current').addClass('active').parents('li').addClass('active').find('span.arrow').addClass('open');

					//批量操作
					$('.chk_all').on('click',
									function() {
										$('.data-id').attr('checked', true).parent('span').addClass('checked');
									});
					$('.chk_rev') .on('click',
									function() {
										$('.data-id').each( 
											function() {
												if ($(this).is(':checked')) 
													$(this).attr('checked', false).parent('span').removeClass('checked');
												else
													$(this).attr('checked',true).parent('span').addClass('checked');
												});
									});
					$('.chk_none').on('click',
									function() {
										$('.data-id').attr('checked', false).parent('span').removeClass('checked');
									});
					$('.batch_submit').on( 'click',
									function() {
										$action = $(this).attr('rel');
										$(this).parents('form').attr('action',$action).submit();
									});

					$(".form_datetime").datetimepicker({
						language : 'zh-CN',
						autoclose : true,
						format : "yyyy-mm-dd hh:ii",
						pickerPosition : "bottom-left",
						todayBtn : 1,
						todayHighlight : true,
						minuteStep : 1
					});
					
					$(".form_datetime_ymd").datetimepicker({
						language : 'zh-CN',
						autoclose : true,
						format : "yyyy-mm-dd",
						pickerPosition : "bottom-left",
						todayBtn : 1,
						todayHighlight : true,
						minuteStep : 1,
						startView: 4,
						maxView: 4,
						minView: 2,
					});

					//设置禁言 
					;
					(function() {
						var uid;
						$('.setting-forbid').on('click',
											function() {
												$('#forbidForm').find(".modal-title").html("为"+ $(this).attr("data-name")+ "设置禁言");
												uid = $(this).attr("data-id");
											});
						$("#forbidForm .btn-ok").on('click',
											function() {
												$("#forbidForm").modal('hide');
												var days = parseInt($("#forbidForm").find("select[name='days']").val());
												var reason = $("#forbidForm").find("select[name='reason']").val();
												var send = $("#forbidForm").find("input[name='send']").val();
												var message = $("#forbidForm").find("textarea[name='message']").val();
												toastr.options = {
													"closeButton" : true,
													"debug" : false,
													"positionClass" : "toast-top-center",
													"onclick" : null,
													"showDuration" : "1000",
													"hideDuration" : "1000",
													"timeOut" : "2000",
													"extendedTimeOut" : "1000",
													"showEasing" : "swing",
													"hideEasing" : "linear",
													"showMethod" : "fadeIn",
													"hideMethod" : "fadeOut"
												};
												if (days >= 0) {
													$.ajax({url : "/admin/forbid/setting",
															type : 'POST',
															data : {
																uid : uid,
																days : days,
																reason : reason,
																send : send,
																message : message
															},
															dataType : 'text',
															success : function(res) {
																	if (res == "success") {
																		toastr.success('','设置禁言成功');
																	} else {toastr.error('','设置禁言失败');
																	}
																},
															error : function() {
																	toastr.error('','设置禁言失败');
																}
													});
												} else {
													toastr.warning('', '请设置正确的天数');
												}
									});
					})();

					// IE8 placeholder 不兼容的问题
					jQuery('[placeholder]') .focus( function() {
													var input = jQuery(this);
													if (input.val() == input.attr('placeholder')) {
														input.val('');
														input.removeClass('placeholder');
													}
												}).blur( function() {
													var input = jQuery(this);
													if (input.val() == '' || input.val() == input.attr('placeholder')) {
														input.addClass('placeholder');
														input.val(input.attr('placeholder'));
													}
												}).blur().parents('form').submit(
												function() {
													jQuery(this).find('[placeholder]').each(
															function() {
																var input = jQuery(this);
																if (input.val() == input.attr('placeholder')) {
																	input.val('');
																}
															})
												});
				});
</script>
<script type="text/javascript" src="/static/admin/public/javascript/jquery-ui.min.js"></script>
<script type="text/javascript" src="/static/admin/public/javascript/jquery-ui-i18n.min.js"></script>
<script type="text/javascript">
	/*<![CDATA[*/
	jQuery(function($) {
		jQuery('#start_time').datepicker(jQuery.extend({
			showMonthAfterYear : false
		}, jQuery.datepicker.regional['zh_cn'], {
			'maxDate' : 'new Date()',
			'dateFormat' : 'yy-mm-dd'
		}));
		jQuery('#end_time').datepicker(jQuery.extend({
			showMonthAfterYear : false
		}, jQuery.datepicker.regional['zh_cn'], {
			'maxDate' : 'new Date()',
			'dateFormat' : 'yy-mm-dd'
		}));
	});
	/*]]>*/
</script>

<rapid:block name="footer">
<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
</rapid:block>

</rapid:block>
</body>
<!-- END BODY -->
</html>
