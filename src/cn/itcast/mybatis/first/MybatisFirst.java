package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class MybatisFirst {

	// 根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws IOException {

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		try {
			// 得到配置文件流
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// 创建会话工厂，传入mubatis的配置信息
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// 通过工厂得到SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();

			// 通过SqlSession操作数据库
			// 第一个参数：映射文件中statement的id,等于=namespace+"."+statement的id
			// 第二个参数：指定和映射文件中所匹配的paremeterType类型的参数
			// sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象

			User user = sqlSession.selectOne("test.findUserById", 1);

			System.out.println(user);

			sqlSession.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mubatis的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过SqlSession操作数据库
		// 第一个参数：映射文件中statement的id,等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的paremeterType类型的参数
		// sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象

		List<User> list = sqlSession.selectList("test.findUserByName", "王五");

		System.out.println(list);

		sqlSession.close();

	}

	//添加用户信息
	@Test
	public void insertUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mubatis的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过SqlSession操作数据库
		// 第一个参数：映射文件中statement的id,等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的paremeterType类型的参数
		// sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象

		User user = new User();
		user.setUsername("王五");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setAddress("河南郑州");

		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		
		System.out.println(user.getId());
		sqlSession.close();

	}
	
	//删除用户
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mubatis的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过SqlSession操作数据库
		// 第一个参数：映射文件中statement的id,等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的paremeterType类型的参数	

		sqlSession.delete("test.deleteUser", 5);
		sqlSession.commit();	
		
		sqlSession.close();

	}
	
	@Test
	public void updateUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mubatis的配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过SqlSession操作数据库
		// 第一个参数：映射文件中statement的id,等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的paremeterType类型的参数
		// sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象

		User user = new User();
		user.setId(4);
		user.setUsername("王五");
		user.setBirthday(new Date());
		user.setSex("0");
		user.setAddress("河南郑州二七区");

		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		
		System.out.println(user.getId());
		sqlSession.close();

	}

}
