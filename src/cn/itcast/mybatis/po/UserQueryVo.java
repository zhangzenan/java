package cn.itcast.mybatis.po;

import java.util.List;

/**
 * ��װ����*/
public class UserQueryVo {
	
	//������id
	private List<Integer> ids;
	//�������װ����Ҫ�Ĳ�ѯ����
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	//�û���ѯ����
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	//���԰�װ�����Ĳ�ѯ��������������Ʒ

}
