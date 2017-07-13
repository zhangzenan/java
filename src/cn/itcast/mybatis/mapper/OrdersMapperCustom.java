package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

public interface OrdersMapperCustom {
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	//一对一映射
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	//一对多映射
	public List<Orders> findOrdersAndOrderdetailResultMap() throws Exception;
	
	//多对多映射
	public List<User> findUserAndItemsResultMap() throws Exception;

}
