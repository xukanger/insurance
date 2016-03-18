<%@page import="cn.annpeter.insurance.utils.WebUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  


<rapid:override name="head">
	<script type="text/javascript" src="/static/admin/public/javascript/plupload.full.min.js"></script>
</rapid:override>


<rapid:override name="page_header">
	
</rapid:override>

<rapid:override name="page_content">
	<!-- BEGIN PAGE CONTENT-->
	<div class="row">
		<div class="col-md-12">

			<form class="form-horizontal" method="post" action='/admin/user/profile' >
                <input type="hidden" name="user.id" value="<s:property value='#request.User.getId()'/>"/><!-- 隐藏域，用户id -->

			    <div class="form-group">
			        <label class="col-md-2 control-label">用户名</label>
			        <div class="col-sm-10">
			            <input type="text" name="user.name" class="form-control input-large input-inline"
			            		value="<s:property value='#request.User.getName()'/>" readonly="true"/>
			        </div>
			    </div>
			    <div class="form-group">
		            <label class="control-label col-md-2">头像</label>
		            <div class="col-md-5">
		
		                <!--single-->
		                <div class="plupload_container" style="position: relative;">
							<div id="ZEOA" class="btn btn-info" style="position: relative; z-index: 1;">  
								<i class="fa fa-plus"></i> 上传文件 <span class="info"></span>
							</div>
						</div>
		                <img src="<s:property value='#request.User.getHeadImgUrl()'/>" alt="" id="headImg" height="100" style="display:none;">
		                <input type="hidden" id="headImgUrl" name="user.headImgUrl" value="<s:property value='#request.User.getHeadImgUrl()'/>"/>
		                <script type="text/javascript">
		                    function uploadsingle(file, response) {
		                        var url = response.result.url;
		                        $('#headImgUrl').val(url);
		                        $('#headImg').attr('src', url).show();
		                    }
		                </script>
		            </div>
		            
					<script type="text/javascript">
						jQuery(function($) {
							
							var ZEOA = new plupload.Uploader({
							    runtimes: 'html5,flash,silverlight,html4',
							    browse_button: 'ZEOA',
							    url: '/static/admin/upload/index',
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
							if($('#headImg').attr('src')){
								$('#headImg').show();
							}
							});
					</script>
		            
		        </div>
        
			    <div class="form-group">
			        <label class="col-md-2 control-label">
			            性别
			        </label>
			        <div class="radio-list col-md-4">
                        <label class="radio-inline">
                            <input type="radio" id="extend1" name="open_image_verifycode" value="1" <s:if test='#request.User.getSex() == 1'>checked</s:if>/>
                            男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="extend2" name="open_image_verifycode" value="2" <s:if test='#request.User.getSex() == 2'>checked</s:if>/>
                            女
                        </label>
                        <label class="radio-inline">
                            <input type="radio" id="extend0" name="open_image_verifycode" value="0" <s:if test='#request.User.getSex() == 0'>checked</s:if>/>
                            其它
                        </label>
                    </div>
			    </div>

			    <div class="form-group">
			        <label class="col-md-2 control-label">生日</label>
			        <div class="col-sm-10">
			            <div class="input-group date form_datetime_ymd input-xlarge">
			                <input type="text" name="user.birth" readonly="" class="form-control"
                                value="<s:property value='#request.User.getBirthStr()'/>" placeholder="选择时间" />
			                	
			                <span class="input-group-btn">
			                    <button class="btn default date-set" type="button"><i class="fa fa-calendar"></i></button>
			                </span>
			            </div>
			        </div>
			    </div>

			    <div class="form-group">
			        <label class="col-md-2 control-label">注册日期</label>
			        <div class="col-sm-10">
			            <input type="text" class="form-control input-large input-inline"
			            		value="<s:property value='#request.User.getCreateTimeStr()'/>" readonly="true"/>
			        </div>
			    </div>
			    <div class="form-group">
			        <label class="col-md-2 control-label">手机号</label>
			        <div class="col-sm-10">
			            <input type='text' name='user.phone' class='form-control input-large input-inline'
			            	value="<s:property value='#request.User.getPhone()'/>"/>
			        </div>
			    </div>
			    <div class="form-group">
			        <label class="col-md-2 control-label">身份证号</label>
			        <div class="col-sm-10">
			            <input type="text" name="user.idNum" class="form-control input-large input-inline"
			            		value="<s:property value='#request.User.getIdNum()'/>"/>
			        </div>
			    </div>
			    <div class="form-group">
			        <label class="col-md-2 control-label">邮箱</label>
			        <div class="col-sm-10">
			            <input type="text" name="user.email" class="form-control input-large input-inline"
			            		value="<s:property value='#request.User.getEmail()'/>" readonly="true"/>
			        </div>
			    </div>
			    <div class="form-group">
			        <label class="col-md-2 control-label">QQ</label>
			        <div class="col-sm-10">
			            <input type="text" name="user.QQ" class="form-control input-large input-inline"
			            		value="<s:property value='#request.User.getQQ()'/>"/>
			        </div>
			    </div>
			    <div class="form-group">
			        <label class="col-md-2 control-label">微信</label>
			        <div class="col-sm-10">
			            <input type="text" name="user.weChat" class="form-control input-large input-inline"
			            		value="<s:property value='#request.User.getWeChat()'/>"/>
			        </div>
			    </div>
			    <div class="form-group">
			        <label class="col-md-2 control-label">地址</label>
			        <div class="col-sm-10">
			            <textarea class="form-control input-large input-inline" name="user.addr"><s:property value='#request.User.getAddr()'/></textarea>
			        </div>
			    </div>
			    
			    <input type="hidden" name="do" value="submit">
			    <div class="form-group">
			        <label class="col-md-2 control-label"></label>
			        <div class="col-sm-10">
                        <button type="submit" class="btn green">提交</button>
			        </div>
			    </div>
			</form>
			
		</div>
	</div>
	<!-- END PAGE CONTENT-->
</rapid:override>
<jsp:include page="../public/index_base_template.jsp"></jsp:include>