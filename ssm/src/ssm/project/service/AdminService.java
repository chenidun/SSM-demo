package ssm.project.service;

import ssm.project.pojo.Admin;

public interface AdminService {
	
	public boolean register(Admin a);

	public boolean login(String name,String password);
}
