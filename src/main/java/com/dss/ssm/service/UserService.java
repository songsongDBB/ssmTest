package com.dss.ssm.service;

import java.util.Map;

import com.dss.ssm.entity.PageBean;
import com.dss.ssm.entity.User;

public interface UserService {

	User findUser(User user);

	PageBean listUser(Map<String, String> para);
}
