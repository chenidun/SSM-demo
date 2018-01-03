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
		//根据前台要注册的名字进行查询
		Admin login = adminMapper.login(a.getName());
		boolean flag=false;
		//如果注册名字不存在，就执行注册
		if(login==null){
		int register = adminMapper.register(a);
		//注册成功
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
//		登陆验证
		if(admin!=null && admin.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
