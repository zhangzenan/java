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
	public void testfindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 调用userMapper的方法
		User user = userMapper.findUserById(1);
		sqlSession.close();
		System.out.println(user);
	}
	


	@Test
	public void testfindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 调用userMapper的方法
		List<User> list = userMapper.findUserByName("王五");

		sqlSession.close();

		System.out.println(list);
	}
	
	@Test
	public void testfindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("王小军");
		userCustom.setAddress("河南郑州");
		userQueryVo.setUserCustom(userCustom);
		
		// 调用userMapper的方法
		List<UserCustom> list = userMapper.findUserList(userQueryVo);

		sqlSession.close();

		System.out.println(list);
	}
	
	@Test
	public void testfindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("王小军");
		userCustom.setAddress("河南郑州");
		userQueryVo.setUserCustom(userCustom);
		
		// 调用userMapper的方法
		int count = userMapper.findUserCount(userQueryVo);

		sqlSession.close();

		System.out.println(count);
	}
	
	@Test
	public void testfindUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 调用userMapper的方法
		User user = userMapper.findUserByIdResultMap(1);
		sqlSession.close();
		System.out.println(user);
	}
	

}
