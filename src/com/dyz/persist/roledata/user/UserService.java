package com.dyz.persist.roledata.user;

import java.sql.SQLException;

import com.dyz.persist.util.DBUtil;

public class UserService {

	private final UserDAO userDao = new UserDAOImpl(DBUtil.getRoledataSqlMapClient());
	
	private static UserService userService = new UserService();
	
	private UserService(){}
	
	public static UserService getInstance(){
		return userService;
	}
	
	public void insertUser(User user){
		 try {
			userDao.insert(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
