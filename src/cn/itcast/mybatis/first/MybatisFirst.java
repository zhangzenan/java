package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class MybatisFirst {

	// ����id��ѯ�û���Ϣ���õ�һ����¼���
	@Test
	public void findUserByIdTest() throws IOException {

		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		try {
			// �õ������ļ���
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// �����Ự����������mubatis��������Ϣ
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// ͨ�������õ�SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();

			// ͨ��SqlSession�������ݿ�
			// ��һ��������ӳ���ļ���statement��id,����=namespace+"."+statement��id
			// �ڶ���������ָ����ӳ���ļ�����ƥ���paremeterType���͵Ĳ���
			// sqlSession.selectOne�������ӳ���ļ�����ƥ���resultType���͵Ķ���

			User user = sqlSession.selectOne("test.findUserById", 1);

			System.out.println(user);

			sqlSession.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mubatis��������Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ͨ��SqlSession�������ݿ�
		// ��һ��������ӳ���ļ���statement��id,����=namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���paremeterType���͵Ĳ���
		// sqlSession.selectOne�������ӳ���ļ�����ƥ���resultType���͵Ķ���

		List<User> list = sqlSession.selectList("test.findUserByName","����");

		System.out.println(list);

		sqlSession.close();

	}

}
