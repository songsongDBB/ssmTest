package com.dss.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dss.ssm.entity.User;
import com.dss.ssm.service.UserService;
import com.dss.ssm.utils.CodeUtil;

@Controller
@RequestMapping(value="/login")
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin(){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value="/toIndex")
	public ModelAndView toIndex(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("back/index");
		return mv;
	}
	
	@RequestMapping(value="/goLogin")
	@ResponseBody
	public String goLogin(User model){
		
		boolean result = CodeUtil.checkVerifyCode(this.getRequest());
		if(!result){				//ÑéÖ¤Âë´íÎó
			return "2";
		}
		
		User user = userService.findUser(model);
		
		if(user != null){
			this.getRequest().getSession().setAttribute("user", user);
			return "0";
		}else{
			return "1";
		}
	}
}
