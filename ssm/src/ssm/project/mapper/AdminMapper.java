package ssm.project.mapper;

import ssm.project.pojo.Admin;

public interface AdminMapper {
	//ע��
	public int register(Admin a);
	//��¼�����ݹ���Ա�˻�����ѯ
	public Admin login(String name);
	
	

}
