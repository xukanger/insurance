##卡单模块接口交流

###请求查看当前用户的购物车(/app/shoppingcart/list?id=memberID)
* 请求携带信息memberID(用户id，用户即保险员)
* 返回json样例

	```
	{
	  "result": [
		{
		  "memver_id": 1,
		  "jsonShoppingCarts": [
			{
			  "id": 1,	<!--这里的id是产品的id-->
			  "supplier_id": 1,
			  "supplier_title": "中国人寿",
			  "supplier_logo": "标识",
			  "kadan_name": "产品名称1",
			  "kadan_price": 1,
			  "card_num": 3
			},
			{
			  "id": 2,
			  "supplier_id": 1,
			  "supplier_title": "中国人寿",
			  "supplier_logo": "标识",
			  "kadan_name": "产品名称2",
			  "kadan_price": 2,
			  "card_num": 5
			}
		  ]
		}
	  ],
	  "message": "获取购物车成功",
	  "status": 1
	}
	```