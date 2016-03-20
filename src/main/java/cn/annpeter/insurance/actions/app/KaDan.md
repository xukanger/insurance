##卡单模块接口交流

###请求查看所有卡单(/app/kadan/list)
* 返回json样例
	```vim
	{
	  "result": [
		{
		  "id": 1,	<!--这里的id是产品的id-->
		  "name": "产品名称1",
		  "description": "描述1",
		  "price": 1,
		  "img_small": "/static/admin/upload/2016/MAR/20/19127032_K4r19.png"
		},
		{
		  "id": 2,
		  "name": "产品名称2",
		  "description": "产品描述2",
		  "price": 2,
		  "img_small": "/static/admin/upload/2016/MAR/20/19260648_lm0q6.png"
		}
	  ],
	  "message": "请求卡单列表成功",
	  "status": 1
	}
	```

###请求查看某条卡单具体信息(/app/kadan/index?id=productID)
* 请求携带productID(产品id，所有产品共享的id字段)
* 返回json样例
	```json
	{
	  "result": {
		"id": 1,	<!--这里的id是产品的id-->
		"name": "产品名称1",
		"description": "描述1",
		"price": 1,
		"summary": "1",
		"img_big": "/static/admin/upload/2016/MAR/20/19131787_UY3nu.jpeg",
		"card_cate": "保险分类1",
		"conditions": "投保要求1",
		"detail": "产品详情1",
		"card_range": "投保范围1",
		"info": "投保须知1",
		"after_sale_service": "售后服务1",
		"form_detail": "保单形式1",
		"product__supplier__title": "1"
	  },
	  "message": "请求卡单成功",
	  "status": 1
	}
	```
