package com.dss.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.dss.ssm.entity.Menu;
import com.dss.ssm.entity.User;
import com.dss.ssm.service.MenuService;

@Controller
@RequestMapping(value="/index")
public class IndexController extends BaseController {

	@Autowired
	private MenuService munuService;
	
	/**
	 * 查询该用户可以看到的所有父菜单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/listParentMent")
	public void getParentMentList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		
		User user = (User) this.getRequest().getSession().getAttribute("user");
		
		int rid = munuService.getRoleByUser(user);
		
		List<Menu> parnetMenu = munuService.listAllParentMenuBuUser(rid);
		
		JSONArray jsonArray = (JSONArray) JSONArray.toJSON(parnetMenu);
		
		out.print(jsonArray);
	}
	
	/**
	 * 查询该用户可以看到某个父菜单下面的子菜单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/listSonMent")
	public void getSonMentList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		
		String mname = request.getParameter("mname");
		User user = (User) this.getRequest().getSession().getAttribute("user");
		
		int rid = munuService.getRoleByUser(user);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mname", mname);
		map.put("rid", rid);
		
		List<HashMap<String, Object>> sonMenu = munuService.listAllSonMenuBuParent(map);
		
		JSONArray jsonArray = (JSONArray) JSONArray.toJSON(sonMenu);
		
		out.print(jsonArray);
	}
	
	@RequestMapping(value="/goTest")
	public ModelAndView goTest(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("back/userManage");
		return mv;
	}
}
