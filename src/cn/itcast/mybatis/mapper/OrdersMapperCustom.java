package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;

public interface OrdersMapperCustom {
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	public List<Orders> findOrdersUserResultMap() throws Exception;

}
