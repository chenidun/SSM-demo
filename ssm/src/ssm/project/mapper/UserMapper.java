package ssm.project.mapper;

import java.util.List;

import ssm.project.pojo.User;

public interface UserMapper {

	public int addUser(User u);
	
	public List<User> findAll();
	
	public int deleteByUid(Long uid);
	
	public int update(User u);
	
	public User getByUid(Long uid);
	
	public List<User> search(String username );
	
	public List<User> getByName(String username);
	
	public int deleteAll(Long[] uids);
}
