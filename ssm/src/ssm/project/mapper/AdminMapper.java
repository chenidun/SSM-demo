package ssm.project.mapper;

import ssm.project.pojo.Admin;

public interface AdminMapper {
	//注册
	public int register(Admin a);
	//登录，根据管理员账户名查询
	public Admin login(String name);
	
	

}
