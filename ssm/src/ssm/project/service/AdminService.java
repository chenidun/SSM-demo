package ssm.project.service;

import ssm.project.pojo.Admin;

public interface AdminService {
	//ע��
	public boolean register(Admin a);
	//��¼
	public boolean login(String name,String password);
}
