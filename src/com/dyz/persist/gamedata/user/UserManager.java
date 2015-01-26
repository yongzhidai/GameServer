package com.dyz.persist.gamedata.user;

import java.util.List;

import com.dyz.persist.gamedata.common.IGameDataCach;
import com.dyz.persist.util.DBUtil;

public class UserManager implements IGameDataCach{
	private UserMapper userMapper = DBUtil.gamedata.getMapper(UserMapper.class);
	
	private UserManager(){}
	private static UserManager userManager = new UserManager();
	
	public static UserManager getInstance(){
		return userManager;
	}

	@Override
	public void reload() {
		List<User> users = userMapper.selectByExample(null);
	}
	
	
	
}
