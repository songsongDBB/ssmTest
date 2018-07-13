package com.dss.ssm.dao;

import java.util.List;
import java.util.Map;

import com.dss.ssm.entity.User;

public interface UserDao {

	User findUser(User user);

	List<Map<String, Object>> listUser(Map<String, Integer> map);

	int findUserCount();
}
