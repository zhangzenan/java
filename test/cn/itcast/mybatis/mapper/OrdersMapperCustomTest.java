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

	// �˷�������ִ��testFindUserById֮ǰִ��
	@Before
	public void setUp() throws Exception {
		// ����sqlSessionFactory

		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mubatis��������Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
		System.out.println(list);

		sqlSession.close();

	}

	@Test
	public void testfindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		System.out.println(list);

		sqlSession.close();

	}

	@Test
	public void testfindOrdersAndOrderdetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersAndOrderdetailResultMap();
		System.out.println(list);

		sqlSession.close();
	}

	@Test
	public void testfindUserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
		System.out.println(list);

		sqlSession.close();
	}

	@Test
	public void testfindOrderUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		// ��ѯ������Ϣ������
		List<Orders> list = ordersMapperCustom.findOrderUserLazyLoading();

		for (Orders orders : list) {
			//ִ��gteUser()ȥ��ѯ�û���Ϣ������ʵ�ְ������
			User user = orders.getUser();
			System.out.println(user);
		}
		System.out.println(list);

		sqlSession.close();
	}
	
	//����һ������
	@Test
	public void testCache1() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//��һ�η������󣬲�ѯidΪ1���û�
		User user1=userMapper.findUserById(1);
		System.out.println(user1);
		
		//���sqlSessionȥִ��commit������ִ�в��롢���¡�ɾ���������SqlSession�е�һ�����棬��������Ŀ��Ϊ���û����д洢����������Ϣ�����������
		
		//����user1����Ϣ
		user1.setUsername("��С��1");
		userMapper.updateUser(user1);
		sqlSession.commit();
		
		//�ڶ��η������󣬲�ѯidΪ1���û�
		User user2=userMapper.findUserById(1);
		System.out.println(user2);
		
		
		
		
	}

}
