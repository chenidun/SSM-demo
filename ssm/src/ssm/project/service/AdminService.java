package ssm.project.service;

import ssm.project.pojo.Admin;

public interface AdminService {
	//×¢²á
	public boolean register(Admin a);
	//µÇÂ¼
	public boolean login(String name,String password);
}
