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
		List<OrdersCustom> list= ordersMapperCustom.findOrdersUser();
		System.out.println(list);
		
		sqlSession.close();
		
	}
	
	@Test
	public void testfindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list= ordersMapperCustom.findOrdersUserResultMap();
		System.out.println(list);
		
		sqlSession.close();
		
	}

}
