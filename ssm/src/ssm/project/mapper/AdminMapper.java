package ssm.project.mapper;

import ssm.project.pojo.Admin;

public interface AdminMapper {
	 
	public int register(Admin a);
	//ע��������������Զ���װ��map���ϣ������ڼ�Ϊ�� 
	public Admin login(String name);
	
	

}
