学习笔记

1.表之间的关联关系见图片；
2.部分数据如下;

user 用户表
id uuid email password nickname mobile sex  create_time update_time               

shop_cart  购物车表
id user_uuid  sku_id  sku_name current_price  quantity total_price  create_time update_time             

t_trade  订单表
id trade_no user_uuid  payment payment_type status  payment_time close_time  creat_time  update_time  

trade_order_item  订单明细表
id user_uuid trade_no sku_id  sku_name current_price  quantity  total_price  create_time update_time     


t_category  产品分类表
id	parent  		name	 status         sort_order   create_time   update_time
1    	0          手机	        1          	   1
2   	0          笔记本	    1			   2
3   	0          平板    		1			   3
4   	1          荣耀系列  	1		       1
5       1          P系列      	1	           2
6       2          Book系列  	1 		       1
7   	2          猎人游戏本    1	           2


t_product  产品表
id category_id      spu_name 		price    img_url     attribute  status  create_time  update_time
1       4	        荣耀V30 PRO  	2000     url://leo     [1,2,3]	1
2       4	        荣耀V30  		2000     url://leo     [1,2,3]	1


t_property  产品属性表
id  category_id 	property_name  	create_time  update_time
1        4			颜色   		
2        4			版本   	
3        4			套餐   	
	

t_property_option   属性值选项
id  property_id 	option_name  	creat_time   update_time
1        1			冰岛幻境
2        1			幻夜星河   	
3        1			魅海星蓝		
4        2			5G全网通 8GB+128GB
5        2			5G全网通 8GB+256GB   		
6        3			官方标配	



t_sku   最小库存单位
id        spu_id	 sku_name								sku_price   img_url 	enable_flag  create_time      
1   		1		荣耀V30 PRO 双模5G 麒麟990...           	2000  	 				1


t_sku_property_option    sku属性
id 		sku_id  property_id    property_option        enable_flag      creat_time  update_time
1       1	       1                    2				1
2       1	       2                    4				1
3       1	       3                    6				1

t_store 库存表
id  	sku_id   quantity	status    create_time    update_time  version
1        1        100		1	












