package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;

public interface UserMapper {
	
	//����id��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;

}
