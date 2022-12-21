package com.shop2.myapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop2.myapp.dto.UserDTO;
import com.shop2.myapp.service.AjaxService;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private AjaxService ajaxService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("test1")
	public String testLoad(Model model) throws Exception {
		return "ajax/test1";
	}
	
	//아이디 중복 체크
	@GetMapping("idCheck.do")
	@ResponseBody
	public boolean idCheck(@RequestParam("id") String id) throws Exception {
		UserDTO user = ajaxService.getUser(id);
		if(user==null) {
			return true;
		} else {
			return false;	
		}
	}
	
	@GetMapping("test2")
	public String testLoad2(Model model) throws Exception {
		return "ajax/test2";
	}
	
	@GetMapping("userList.do")
	@ResponseBody
	public List<UserDTO> userList(Model model) throws Exception {
		List<UserDTO> userList = ajaxService.userList();
		return userList;
	}
	
	@GetMapping("test3")
	public String testLoad3(Model model) throws Exception {
		return "ajax/test3";
	}
	
	@GetMapping("getUser.do")
	@ResponseBody
	public UserDTO getUser(@RequestParam("id") String id, Model model) throws Exception {
		UserDTO user = ajaxService.getUser(id);
		return user;
	}
	
	@GetMapping("test4")
	public String testLoad4(Model model) throws Exception {
		return "ajax/test4";
	}
	
	//@PostMapping("getLogin.do")
	//@ResponseBody
	//public UserDTO getLogin(@ModelAttribute("user") UserDTO user, Model model) throws Exception {
	//	UserDTO usr = ajaxService.getLogin(user.getId(), user.getPw());
	
	@GetMapping("getLogin.do")
	@ResponseBody
	public UserDTO getLogin(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) throws Exception {
		UserDTO usr = ajaxService.getLogin(id, pw);
		if(usr==null) {
			session.invalidate();
		} else {
			session.setAttribute("sid", usr.getId());
			session.setAttribute("sname", usr.getName());
		}
		return usr;
	}
}