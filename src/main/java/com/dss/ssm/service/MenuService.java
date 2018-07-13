package com.dss.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dss.ssm.entity.Menu;
import com.dss.ssm.entity.User;

public interface MenuService {

	List<Menu> listAllParentMenuBuUser(int rid);

	int getRoleByUser(User user);

	List<HashMap<String, Object>> listAllSonMenuBuParent(Map<String, Object> map);
}
