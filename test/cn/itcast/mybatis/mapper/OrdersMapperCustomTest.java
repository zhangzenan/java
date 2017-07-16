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
import cn.itcast.mybatis.po.User;

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
		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
		System.out.println(list);

		sqlSession.close();

	}

	@Test
	public void testfindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		System.out.println(list);

		sqlSession.close();

	}

	@Test
	public void testfindOrdersAndOrderdetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersAndOrderdetailResultMap();
		System.out.println(list);

		sqlSession.close();
	}

	@Test
	public void testfindUserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
		System.out.println(list);

		sqlSession.close();
	}

	@Test
	public void testfindOrderUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		// 查询订单信息（单表）
		List<Orders> list = ordersMapperCustom.findOrderUserLazyLoading();

		for (Orders orders : list) {
			//执行gteUser()去查询用户信息，这里实现按需加载
			User user = orders.getUser();
			System.out.println(user);
		}
		System.out.println(list);

		sqlSession.close();
	}
	
	//测试一级缓存
	@Test
	public void testCache1() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//第一次发起请求，查询id为1的用户
		User user1=userMapper.findUserById(1);
		System.out.println(user1);
		
		//如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新消息，避免脏读。
		
		//更新user1的信息
		user1.setUsername("王小军1");
		userMapper.updateUser(user1);
		sqlSession.commit();
		
		//第二次发起请求，查询id为1的用户
		User user2=userMapper.findUserById(1);
		System.out.println(user2);		
	}
	
	@Test
	public void testCache2() throws Exception{
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);		
		//第一次发起请求，查询id为1的用户
		User user1=userMapper1.findUserById(1);
		System.out.println(user1);
		//这里执行关闭操作，将sqlSession中的数据写到二级缓存中
		sqlSession1.close();	
		
		//使用sqlSession3执行commit()操作
	/*	UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user=userMapper3.findUserById(1);
		user.setUsername("张明明");
		userMapper3.updateUser(user);
		//执行提交，清空UserMapper下面的二级缓存
		sqlSession3.commit();
		sqlSession3.close();*/		 	 	
		
		//第二次发起请求，查询id为1的用户
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2=userMapper2.findUserById(1);
		System.out.println(user2);	
		sqlSession2.close();
		
	}

}
