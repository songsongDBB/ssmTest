package com.dss.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.ssm.dao.UserDao;
import com.dss.ssm.entity.PageBean;
import com.dss.ssm.entity.User;
import com.dss.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(User user) {
		return userDao.findUser(user);
	}

	@Override
	public PageBean listUser(Map<String, String> para) {

		PageBean userPage = new PageBean();

		// 分页从第几条数据开始
		int start = (Integer.parseInt(para.get("page").toString()) - 1)
				* Integer.parseInt(para.get("rows").toString());
		// 分页每页多少条数据
		int end = Integer.parseInt(para.get("rows").toString());

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);

		List<Map<String, Object>> userlist = userDao.listUser(map);
		userPage.setRows(userlist);

		int total = userDao.findUserCount();
		userPage.setTotal(total);

		return userPage;

	}

}
