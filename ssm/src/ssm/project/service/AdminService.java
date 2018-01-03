package ssm.project.service;

import ssm.project.pojo.Admin;

public interface AdminService {
	//注册
	public boolean register(Admin a);
	//登录
	public boolean login(String name,String password);
}
