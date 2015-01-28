package com.dyz.persist.roledata.user;

import com.dyz.persist.util.DBUtil;

public class UserService {

	private static final UserService userService = new UserService();
	
	public static UserService getInstance(){
		return userService;
	}
	
	private final UserMapper userMapper = DBUtil.roledata.getMapper(UserMapper.class);
	
	public int addUser(User record){
		return userMapper.insert(record);
	}
}
