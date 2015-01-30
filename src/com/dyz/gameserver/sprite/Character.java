package com.dyz.gameserver.sprite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyz.gameserver.sprite.base.GameObj;
import com.dyz.gameserver.sprite.tool.AsyncTaskQueue;
import com.dyz.persist.roledata.user.User;

public class Character implements GameObj{

	private static final Logger logger = LoggerFactory.getLogger(Character.class);
	
	private AsyncTaskQueue asyncTaskQueue = new AsyncTaskQueue();
	
	private User user;
	public Character(User user){
		this.user=user;
	} 
	
	public Integer getUserId(){
		return this.user.getId();
	}
	
	/**
	 * 添加异步任务，针对异步操作数据库
	 * @param tasks
	 */
	public void addAsyncTask(Runnable... tasks){
		asyncTaskQueue.addTask(tasks);
	}

	@Override
	public void destroy() {
		logger.info("用户{}断开服务器链接",user.getName());
	}
}
