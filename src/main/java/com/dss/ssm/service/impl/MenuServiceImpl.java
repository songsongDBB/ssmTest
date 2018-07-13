package com.dss.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.ssm.dao.MenuDao;
import com.dss.ssm.entity.Menu;
import com.dss.ssm.entity.User;
import com.dss.ssm.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	/**
	 * 查询该用户所分配的所有的父菜单
	 */
	public List<Menu> listAllParentMenuBuUser(int rid) {
		return menuDao.listAllParentMenuBuUser(rid);
	}

	public int getRoleByUser(User user) {
		return menuDao.getRoleByUser(user);
	}

	public List<HashMap<String, Object>> listAllSonMenuBuParent(Map<String, Object> map) {
		return menuDao.listAllSonMenuBuParent(map);
	}

}
