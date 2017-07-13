package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

public interface OrdersMapperCustom {
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	//һ��һӳ��
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	//һ�Զ�ӳ��
	public List<Orders> findOrdersAndOrderdetailResultMap() throws Exception;
	
	//��Զ�ӳ��
	public List<User> findUserAndItemsResultMap() throws Exception;

}
