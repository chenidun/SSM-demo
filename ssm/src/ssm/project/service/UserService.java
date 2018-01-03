package ssm.project.service;

import java.util.List;

import ssm.project.pojo.User;


public interface UserService {
//	��ӻ�Ա
	public boolean addUser(User u);
//	ɾ����Ա
	public boolean deleteByUid(Long uid);
//	���»�Ա��Ϣ
	public boolean update(User u);
//	ͨ��uid��ѯ��Ա
	public User getByUid(Long uid);

//	��ѯ���л�Ա
	public List<User> findAll();
//	���ݻ�Ա����ѯ��ģ����ѯ
	public List<User> search(String username);
//	����ɾ��
	public boolean deleteAll(Long[] uids);
}
