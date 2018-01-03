package ssm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.project.mapper.UserMapper;
import ssm.project.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		//根据名字查询数据库有没有相同的用户
		Boolean flag=false;
		List<User> byName = userMapper.getByName(u.getUsername());
		System.out.println("service层数据库查询的："+byName);
		if(byName!=null&&!byName.isEmpty()){
			System.out.println("数据库有相同名字，添加失败");
			flag=false;
		}else{
		int addUser = userMapper.addUser(u);
		if(addUser>0)
			flag=true;
		System.out.println("添加用户"+flag);
		}
	
		return flag;
	}
	@Override
	public boolean deleteByUid(Long uid) {
		// TODO Auto-generated method stub
		System.out.println("删除用户");
		int deleteByUid = userMapper.deleteByUid(uid);
		boolean flag=false;
		if(deleteByUid>0){
			flag=true;
		}
		
		return flag;
	}
	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		System.out.println("前台传的数据："+u);
		boolean flag=false;
		int update = userMapper.update(u);
		if(update>0){
		System.out.println("更新成功");
		flag=true;
		}
		else{
			flag=false;
			System.out.println("更新失败");
		}
		return flag;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return	userMapper.findAll();
	}
	@Override
	public List<User> search(String username) {
		// TODO Auto-generated method stub
		System.out.println("模糊查询结果："+userMapper.search(username));
		return userMapper.search(username);
	}
	@Override
	public User getByUid(Long uid) {
		// TODO Auto-generated method stub
		User user = userMapper.getByUid(uid);
		System.out.println("service层查询结果："+user);
		return user;
	}
	@Override
	public boolean deleteAll(Long[] uids) {
		// TODO Auto-generated method stub
		for(Long uid:uids){
			System.out.println("service层获得的id是："+uid);
		}
		int deleteAll = userMapper.deleteAll(uids);
		System.out.println("调用mapper的删除方法");
		boolean flag=false;
		if(deleteAll>0){
		flag=true;
		}else{
			flag=false;
		}
		return flag;
	}
}
