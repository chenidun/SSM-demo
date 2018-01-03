package ssm.project.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.project.pojo.User;
import ssm.project.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("usertoadd")
	public String toadd(){
		return "member-add.jsp";
	}
	
	@RequestMapping("useradd")
	@ResponseBody
	public boolean addUser(User u){
		System.out.println("ǰ̨���ݵ����ݣ�"+u);
		//���ݵ�ǰʱ��
		u.setJointime(new Date());
		boolean user = userService.addUser(u);
		
			System.out.println("���Ʋ���ӳɹ�"+user);
			return user;
	}
	@RequestMapping("usertoList")
	public String list(Model model){
		List<User> uList = userService.findAll();
		int sum = uList.size();
		System.out.println("���ݿ��ѯ�����ݹ�"+sum+"��");
		model.addAttribute("list",uList);
		model.addAttribute("sum", sum);
		return "member-list.jsp";
	}
	@RequestMapping("userdelete")
	@ResponseBody
	public boolean deleteByUid(Long uid){
		return userService.deleteByUid(uid);
		
	}
	@RequestMapping("userupdate")
	@ResponseBody
	public boolean update(User u,HttpSession session){
		Long uid = (Long) session.getAttribute("uid");
		u.setUId(uid);
		System.out.println("��session��ȡ����uid ��;"+uid);
		return userService.update(u);
	}
	@RequestMapping("usersearch")
	public String search(String username,Model model){
		System.out.println("ģ����ѯ");
		List<User> searchResult = userService.search(username);
		int search_sum=searchResult.size();
		System.out.println("��ѯ�ɹ���"+searchResult);
		model.addAttribute("SR", searchResult);
		model.addAttribute("name", username);
		model.addAttribute("search_sum", search_sum);
		return "search-result.jsp";
	}
	@RequestMapping("memberedit")
	public String edit(Long uid,Model model,HttpSession session){
		System.out.println("��Ҫ�༭��Ϣ��ID"+uid);
		User byUid = userService.getByUid(uid);
		session.setAttribute("uid", uid);
		System.out.println("session�б����uid�ǣ�"+uid);
		System.out.println("����uid��ѯ���û�����"+byUid);
		model.addAttribute("user", byUid);
		return "member-update.jsp";
	}
	@RequestMapping("userdeleteall")
	@ResponseBody
	public boolean deleteAll(Long[] uids){
		for(Long uid:uids){
			System.out.println("controller��ǰ̨����ѡ�е�id��"+uid);
		}
		boolean flag = userService.deleteAll(uids);
		System.out.println("ɾ���ɹ�"+flag);
		return true;
	}
	@RequestMapping("userdetail")
	
	public String userdetail(Long uid,Model model){
		System.out.println("ǰ̨�鿴��id��"+uid);
		User byUid = userService.getByUid(uid);
		model.addAttribute("user", byUid);
		return "member-show.jsp";
	}
}
