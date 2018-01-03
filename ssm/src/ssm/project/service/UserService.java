package ssm.project.service;

import java.util.List;

import ssm.project.pojo.User;


public interface UserService {
//	添加用户
	public boolean addUser(User u);
//	删除用户
	public boolean deleteByUid(Long uid);
//	修改
	public boolean update(User u);
	
	public User getByUid(Long uid);

//	查询所有
	public List<User> findAll();
	
	public List<User> search(String username);
	
	public boolean deleteAll(Long[] uids);
}
