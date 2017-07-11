package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public class UserMapperTest {

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
	public void testfindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ����userMapper�ķ���
		User user = userMapper.findUserById(1);
		sqlSession.close();
		System.out.println(user);
	}
	


	@Test
	public void testfindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ����userMapper�ķ���
		List<User> list = userMapper.findUserByName("����");

		sqlSession.close();

		System.out.println(list);
	}
	
	@Test
	public void testfindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//������װ�������ò�ѯ����
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("��С��");
		userCustom.setAddress("����֣��");
		userQueryVo.setUserCustom(userCustom);
		
		// ����userMapper�ķ���
		List<UserCustom> list = userMapper.findUserList(userQueryVo);

		sqlSession.close();

		System.out.println(list);
	}
	
	@Test
	public void testfindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//������װ�������ò�ѯ����
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("��С��");
		userCustom.setAddress("����֣��");
		userQueryVo.setUserCustom(userCustom);
		
		// ����userMapper�ķ���
		int count = userMapper.findUserCount(userQueryVo);

		sqlSession.close();

		System.out.println(count);
	}
	
	@Test
	public void testfindUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ����userMapper�ķ���
		User user = userMapper.findUserByIdResultMap(1);
		sqlSession.close();
		System.out.println(user);
	}
	

}
