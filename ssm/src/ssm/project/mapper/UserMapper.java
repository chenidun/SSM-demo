package ssm.project.mapper;

import java.util.List;

import ssm.project.pojo.User;

public interface UserMapper {
	//添加会员
	public int addUser(User u);
	//查询所有会员信息
	public List<User> findAll();
	//删除会员
	public int deleteByUid(Long uid);
	//更新会员信息
	public int update(User u);
	//根据uid查询会员
	public User getByUid(Long uid);
	//根据名字模糊查询会员
	public List<User> search(String username );
	//根据名字查询会员用于验证添加时是否存在
	public List<User> getByName(String username);
	//批量删除
	public int deleteAll(Long[] uids);
}
