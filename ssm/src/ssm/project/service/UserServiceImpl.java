package ssm.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.project.mapper.UserMapper;
import ssm.project.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		//����ǰ̨Ҫ��ӵ����ֲ�ѯ�Ƿ��Ѿ�����
		List<User> byName = userMapper.getByName(u.getUsername());
		if(byName!=null&&!byName.isEmpty()){
			System.out.println("���ݿ�����ͬ���֣����ʧ��");
			flag=false;
		}else{
		//������ӣ�������ӽ����Ӱ��ļ�¼
		int addUser = userMapper.addUser(u);
		if(addUser>0)
			flag=true;
		System.out.println("����û�"+flag);
		}
	
		return flag;
	}
	@Override
	public boolean deleteByUid(Long uid) {
		// TODO Auto-generated method stub
		//ɾ�����������ݿ�Ӱ������
		int deleteByUid = userMapper.deleteByUid(uid);
		boolean flag=false;
		if(deleteByUid>0){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		boolean flag=false;
		//���£�����Ӱ������
		int update = userMapper.update(u);
		if(update>0){
		System.out.println("���³ɹ�");
		flag=true;
		}
		else{
			flag=false;
			System.out.println("����ʧ��");
		}
		return flag;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return	userMapper.findAll();
	}
	@Override
	public List<User> search(String username) {
		// TODO Auto-generated method stub
		System.out.println("ģ����ѯ�����"+userMapper.search(username));
		return userMapper.search(username);
	}
	@Override
	public User getByUid(Long uid) {
		// TODO Auto-generated method stub
		User user = userMapper.getByUid(uid);
		System.out.println("service���ѯ�����"+user);
		return user;
	}
	@Override
	public boolean deleteAll(Long[] uids) {
		// TODO Auto-generated method stub
		//����ɾ�������ؽ��
		int deleteAll = userMapper.deleteAll(uids);
		boolean flag=false;
		if(deleteAll>0){
		flag=true;
		}else{
			flag=false;
		}
		return flag;
	}
}
