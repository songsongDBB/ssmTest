package com.dss.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dss.ssm.entity.PageBean;
import com.dss.ssm.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	/**
	 * 查询所有的用户信息
	 * @return
	 */
	@RequestMapping(value="/listUserInfo")
	@ResponseBody
	public PageBean listUser(){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("page", this.getRequest().getParameter("page"));
		map.put("rows", this.getRequest().getParameter("rows"));
		
		PageBean userPage = userService.listUser(map);
		
		return userPage;
		
	}
}
