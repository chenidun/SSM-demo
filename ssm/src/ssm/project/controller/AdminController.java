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
		//注册
		boolean data=adminService.register(a);
		System.out.println("注册成功："+data);
		return data;
	}
	@RequestMapping("adminlogin")
	@ResponseBody
	public boolean login(Admin admin,HttpSession session){
		//登录，成功后把登录名保存到session
		String adminName=admin.getName();
		session.setAttribute("adminName", adminName);
		System.out.println("登录名是："+admin.getName());
		System.out.println("登录密码是："+admin.getPassword());
		return adminService.login(admin.getName(),admin.getPassword());
	}
	@RequestMapping("toindex")
	public String toindex(HttpSession session,Model model){
		//把session保存的登录名取出来显示在首页
		String name = (String) session.getAttribute("adminName");
		model.addAttribute("name", name);
		return "index.jsp";
	}
	@RequestMapping("loginout")
	public String loginout(HttpSession session){
		//退出登录，删除session中保存的登录名
		session.removeAttribute("adminName");
		return "login.jsp";
	}
	
}
