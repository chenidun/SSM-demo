package ssm.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.project.pojo.Admin;
import ssm.project.service.AdminService;

@Controller
@RequestMapping("")
public class AdminController {
	
	@Autowired
	 AdminService adminService;
	
	@RequestMapping("admin_register")
	@ResponseBody
	public boolean register(Admin a){
		
		boolean data=adminService.register(a);
		
		System.out.println("ע��ɹ���"+data);
		return data;
	}
	
	@RequestMapping("adminlogin")
	@ResponseBody
	public boolean login(Admin admin,HttpSession session){
		String adminName=admin.getName();
		session.setAttribute("adminName", adminName);
		System.out.println("��¼���ǣ�"+admin.getName());
		System.out.println("��¼�����ǣ�"+admin.getPassword());
		 return adminService.login(admin.getName(),admin.getPassword());
	}
	@RequestMapping("toindex")
	public String toindex(HttpSession session,Model model){
		String name = (String) session.getAttribute("adminName");
		model.addAttribute("name", name);
		return "index.jsp";
	}
	@RequestMapping("loginout")
	public String loginout(HttpSession session){
		session.removeAttribute("adminName");
		return "login.jsp";
	}
	
}
