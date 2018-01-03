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
		System.out.println("前台传递的数据："+u);
		//传递当前时间
		u.setJointime(new Date());
		boolean user = userService.addUser(u);
		return user;
	}
	@RequestMapping("usertoList")
	public String list(Model model){
		List<User> uList = userService.findAll();
		//获取查询总数
		int sum = uList.size();
		System.out.println("数据库查询的数据共"+sum+"条");
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
		//取出session保存的uid
		Long uid = (Long) session.getAttribute("uid");
		u.setUId(uid);
		System.out.println("从session中取出的uid 是;"+uid);
		return userService.update(u);
	}
	@RequestMapping("usersearch")
	public String search(String username,Model model){
		//模糊查询
		List<User> searchResult = userService.search(username);
		//获取查询到的总数
		int search_sum=searchResult.size();
		System.out.println("查询成功："+searchResult);
		model.addAttribute("SR", searchResult);
		model.addAttribute("name", username);
		model.addAttribute("search_sum", search_sum);
		return "search-result.jsp";
	}
	@RequestMapping("memberedit")
	public String edit(Long uid,Model model,HttpSession session){
		User byUid = userService.getByUid(uid);
		//将前台传来的uid保存到session
		session.setAttribute("uid", uid);
		System.out.println("session中保存的uid是："+uid);
		System.out.println("根据uid查询的用户对象："+byUid);
		model.addAttribute("user", byUid);
		return "member-update.jsp";
	}
	@RequestMapping("userdeleteall")
	@ResponseBody
	public boolean deleteAll(Long[] uids){
		//批量删除
		boolean flag = userService.deleteAll(uids);
		System.out.println("删除成功"+flag);
		return true;
	}
	@RequestMapping("userdetail")
	public String userdetail(Long uid,Model model){
		User byUid = userService.getByUid(uid);
		model.addAttribute("user", byUid);
		return "member-show.jsp";
	}
}
