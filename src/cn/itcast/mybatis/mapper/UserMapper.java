package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public interface UserMapper {
	
	//�û���Ϣ�ۺϲ�ѯ
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//�û���Ϣ�ۺϲ�ѯ����
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//����id��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;
	
	//����id��ѯ�û���Ϣ��ʹ��resultMap���
	public User findUserByIdResultMap(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;

}
