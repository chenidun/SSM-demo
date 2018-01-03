package ssm.project.mapper;

import ssm.project.pojo.Admin;

public interface AdminMapper {
	 
	public int register(Admin a);
	//注解的两个参数会自动封装成map集合，括号内即为键 
	public Admin login(String name);
	
	

}
