package ssm.project.service;

import java.util.List;

import ssm.project.pojo.User;


public interface UserService {
//	����û�
	public boolean addUser(User u);
//	ɾ���û�
	public boolean deleteByUid(Long uid);
//	�޸�
	public boolean update(User u);
	
	public User getByUid(Long uid);

//	��ѯ����
	public List<User> findAll();
	
	public List<User> search(String username);
	
	public boolean deleteAll(Long[] uids);
}
