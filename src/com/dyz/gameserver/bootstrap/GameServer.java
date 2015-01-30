package com.dyz.gameserver.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyz.gameserver.commons.message.MsgDispatcher;
import com.dyz.gameserver.net.MinaMsgHandler;
import com.dyz.gameserver.net.NetManager;
import com.dyz.persist.util.DBUtil;

public class GameServer {
	
	private static final Logger logger = LoggerFactory.getLogger(GameServer.class);

	private int port = 1101;
	
	private static GameServer instance=new GameServer();
	
	public static MsgDispatcher msgDispatcher = new MsgDispatcher();;
	
	private NetManager netManager;
	
	private GameServer(){
		netManager = new NetManager();
	}
	
	public static GameServer getInstance(){
		return instance;
	}
	
	public void startUp(){
		try {
			logger.info("开始启动服务器 ...");
			DBUtil.initAllSqlMapClient();
			logger.info("数据库连接初始化完成");
			netManager.startListner(new MinaMsgHandler(), port);
			logger.info("服务器监听端口:{}完成",port);
			logger.info("game server started...");
		} catch (Exception e) {
			logger.error("服务器启动失败");
			e.printStackTrace();
		}
		
	}
	
	public void stop(){
		netManager.stop();
		logger.info("stop game server ...");
	}
	
}
