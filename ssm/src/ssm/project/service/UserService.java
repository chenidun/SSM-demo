package ssm.project.service;

import java.util.List;

import ssm.project.pojo.User;


public interface UserService {
//	添加会员
	public boolean addUser(User u);
//	删除会员
	public boolean deleteByUid(Long uid);
//	更新会员信息
	public boolean update(User u);
//	通过uid查询会员
	public User getByUid(Long uid);

//	查询所有会员
	public List<User> findAll();
//	根据会员名查询，模糊查询
	public List<User> search(String username);
//	批量删除
	public boolean deleteAll(Long[] uids);
}
