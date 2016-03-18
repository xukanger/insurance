<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:override name="head">

</rapid:override>

<rapid:override name="page_content">
<div class="row">
	<div class="col-md-12">

		<div class="note note-success">
			快捷操作: 
			<a href="#" class="btn btn-primary "><b>本地圈信息管理</b></a>
			<a href="#" class="btn btn-primary "><b>广告活动管理</b></a>
			<a href="#" class="btn btn-primary "><b>今日热点推送</b></a>
			<a href="#" class="btn btn-primary "><b>首页推送</b></a>
		</div>

		<form class="form-inline" method="get">
			选择时间
			<input class="form-control input-small hasDatepicker"
				maxlength="4" placeholder="开始日期" id="start_time" type="text"
				value="2016-02-21" name="start_time">
				 - 
			<input
				class="form-control input-small hasDatepicker" maxlength="4"
				placeholder="结束日期" id="end_time" type="text" value="2016-02-27"
				name="end_time">

			<button type="submit" class="btn btn-primary">筛选</button>
		</form>

		<div class="portlet box">
			<div id="main" style="height: 400px; width: 100%; -webkit-tap-highlight-color: transparent;
				 -webkit-user-select: none; cursor: default; background-color: rgba(0, 0, 0, 0);"
				_echarts_instance_="1456554270938">
				<div style="position: relative; overflow: hidden; width: 1270px; height: 400px;">
					<div data-zr-dom-id="bg" class="zr-element" style="position: absolute; left: 0px; top: 0px; 
						width: 1270px; height: 400px; -webkit-user-select: none;">
					</div>
					<canvas width="1270" height="400" data-zr-dom-id="0" class="zr-element" style="position: absolute;
						 left: 0px; top: 0px; width: 1270px; height: 400px; -webkit-user-select: none;
						  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
					</canvas>
					<canvas width="1270" height="400" data-zr-dom-id="1" class="zr-element" style="position: absolute;
						 left: 0px; top: 0px; width: 1270px; height: 400px; -webkit-user-select: none;
						  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
					</canvas>
					<canvas width="1270" height="400" data-zr-dom-id="_zrender_hover_" class="zr-element" style="position: absolute;
						 left: 0px; top: 0px; width: 1270px; height: 400px; -webkit-user-select: none;
						  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
					</canvas>
					<div class="echarts-dataview" style="position: absolute; display: block; overflow: hidden; 
						transition: height 0.8s, background-color 1s; z-index: 1; left: 0px; top: 0px; width: 1270px; height: 0px;
						 background-color: rgb(240, 255, 255);">
					</div>
				</div>
			</div>

		</div>

	</div>
</div>
</rapid:override>

<rapid:override name="page_script">
<script src="/static/admin/public/javascript/echarts-all.js"></script>

<script type="text/javascript">
	// 基于准备好的dom，初始化echarts图表
	var myChart = echarts.init(document.getElementById('main'));

	option = {
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '主题数', '回复数', '点赞数' ]
		},
		toolbox : {
			show : true,
			feature : {
				//mark : {show: true},
				dataZoom : {
					show : true
				},
				dataView : {
					show : true
				},
				//magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		dataZoom : {
			show : true,
			realtime : true,
			start : 0,
			end : 100
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : function() {
				return [ '2016-02-21',
						'2016-02-22', '2016-02-23',
						'2016-02-24', '2016-02-25',
						'2016-02-26' ];
			}()
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [
				{
					name : '主题数',
					type : 'line',
					data : function() {
						return [ 115, 142, 123,
								115, 112, 112 ];
					}(),
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				},
				{
					name : '回复数',
					type : 'line',
					data : function() {
						return [ 217, 230, 143,
								166, 127, 255 ];
					}(),
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				},
				{
					name : '点赞数',
					type : 'line',
					data : function() {
						return [ 838, 1006, 827,
								719, 960, 953 ];
					}(),
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				} ]
	};

	// 为echarts对象加载数据
	myChart.setOption(option);
</script>
</rapid:override>

<jsp:include page="../public/index_base_template.jsp"></jsp:include>