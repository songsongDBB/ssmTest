package com.dss.ssm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dss.ssm.entity.Menu;
import com.dss.ssm.entity.User;

public interface MenuDao {

	List<Menu> listAllParentMenuBuUser(int rid);

	int getRoleByUser(User user);

	List<HashMap<String, Object>> listAllSonMenuBuParent(Map<String, Object> map);
}
