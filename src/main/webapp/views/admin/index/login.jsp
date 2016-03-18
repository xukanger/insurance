<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  

<rapid:override name="title">
	后台管理系统
</rapid:override>

<rapid:override name="head">
	<!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="/static/admin/public/css/select2.css" />
    <link rel="stylesheet" type="text/css" href="/static/admin/public/css/select2-metronic.css" />
    <!-- END PAGE LEVEL SCRIPTS -->
    <!-- BEGIN THEME STYLES -->
    <link href="/static/admin/public/css/style-metronic.css" rel="stylesheet" type="text/css"/>
    <link href="/static/admin/public/css/style.css"  rel="stylesheet" type="text/css"/>
    <link href="/static/admin/public/css/style-responsive.css"  rel="stylesheet" type="text/css"/>
    <link href="/static/admin/public/css/plugins.css"   rel="stylesheet" type="text/css"/>
    <link href="/static/admin/public/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/static/admin/login/css/login-soft.css"  rel="stylesheet" type="text/css"/>
    <link href="/static/admin/public/css/custom.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME STYLES -->
</rapid:override>

<rapid:override name="content">
	<!-- BEGIN LOGO -->
	<div class="logo">
	    <a href="#">
	        <img src="/static/admin/login/images/logo-big.png" alt=""/>
	    </a>
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
	<!-- BEGIN LOGIN FORM -->


    <form class="login-form" action="/admin/index/login" method="post" novalidate="novalidate">
        <h3 class="form-title">镇江圈管理后台</h3>
        <div class="alert alert-danger display-hide">
            <button class="close" data-close="alert"></button>
    <span>
     输入
    </span>
        </div>
        <div class="form-group">
            <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
            <label class="control-label visible-ie8 visible-ie9">用户名</label>
            <div class="input-icon">
                <i class="fa fa-user"></i>
                <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Username" name="user.name" value="">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">密码</label>
            <div class="input-icon">
                <i class="fa fa-lock"></i>
                <input class="form-control placeholder-no-fix valid" type="password" autocomplete="off" placeholder="Password" name="user.password">
            </div>
        </div>
        <div class="form-actions">
            <label class="checkbox">
                <div class="checker"><span><input type="checkbox" name="remember" value="1"></span></div> 记住密码 </label>
            <button type="submit" class="btn blue pull-right">
                登录 <i class="m-icon-swapright m-icon-white"></i>
            </button>
        </div>

    </form>

	<!-- END LOGIN FORM -->
	
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">
	    2016 &copy; AnnPeter
	</div>
	<!-- END COPYRIGHT -->
</rapid:override>

<rapid:override name="page_script">
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
	<script src="/static/admin/public/javascript/respond.min.js" ></script>
	<script src="/static/admin/public/javascript/excanvas.min.js" ></script>
	<![endif]-->
	<script src="/static/admin/public/javascript/jquery-1.10.2.min.js"  type="text/javascript"></script>
	<script src="/static/admin/public/javascript/jquery-migrate-1.2.1.min.js"  type="text/javascript"></script>
	<script src="/static/admin/public/javascript/bootstrap.min.js" type="text/javascript"></script>
	<script src="/static/admin/public/javascript/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
	<script src="/static/admin/public/javascript/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="/static/admin/public/javascript/jquery.blockui.min.js"  type="text/javascript"></script>
	<script src="/static/admin/public/javascript/jquery.cokie.min.js"  type="text/javascript"></script>
	<script src="/static/admin/public/javascript/jquery.uniform.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="/static/admin/public/javascript/jquery.validate.min.js"  type="text/javascript"></script>
	<script src="/static/admin/public/javascript/jquery.backstretch.min.js"  type="text/javascript"></script>
	<script type="text/javascript" src="/static/admin/public/javascript/select2.min.js" ></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="/static/admin/public/javascript/app.js" type="text/javascript"></script>
	<script src="/static/admin/login/javascript/login-soft.js"  type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
	    jQuery(document).ready(function() {
	        App.init();
	        Login.init();
	    });
	</script>
	<!-- END JAVASCRIPTS -->
</rapid:override>

<rapid:override name="footer">
</rapid:override>

<jsp:include page="../public/login_base_template.jsp"></jsp:include>