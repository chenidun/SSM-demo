package ssm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.project.mapper.AdminMapper;
import ssm.project.pojo.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public boolean register(Admin a) {
		// TODO Auto-generated method stub
		//����ǰ̨Ҫע������ֽ��в�ѯ
		Admin login = adminMapper.login(a.getName());
		boolean flag=false;
		//���ע�����ֲ����ڣ���ִ��ע��
		if(login==null){
		int register = adminMapper.register(a);
		//ע��ɹ�
		if(register==1){
		flag=true;
		}else{
			flag=false;
		}
		}else{
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean login(String name,String password) {
		// TODO Auto-generated method stub
		Admin admin = adminMapper.login(name);
//		��½��֤
		if(admin!=null && admin.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
