package ssm.project.mapper;

import java.util.List;

import ssm.project.pojo.User;

public interface UserMapper {
	//��ӻ�Ա
	public int addUser(User u);
	//��ѯ���л�Ա��Ϣ
	public List<User> findAll();
	//ɾ����Ա
	public int deleteByUid(Long uid);
	//���»�Ա��Ϣ
	public int update(User u);
	//����uid��ѯ��Ա
	public User getByUid(Long uid);
	//��������ģ����ѯ��Ա
	public List<User> search(String username );
	//�������ֲ�ѯ��Ա������֤���ʱ�Ƿ����
	public List<User> getByName(String username);
	//����ɾ��
	public int deleteAll(Long[] uids);
}
