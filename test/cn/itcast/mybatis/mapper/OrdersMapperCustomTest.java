package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;

public class OrdersMapperCustomTest {
	
	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mubatis的配置信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	

	@Test
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> list= ordersMapperCustom.findOrdersUser();
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	@Test
	public void testfindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list= ordersMapperCustom.findOrdersUserResultMap();
		System.out.println(list);
		
		sqlSession.close();
		
	}

}
