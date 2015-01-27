package com.dyz.gameserver.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyz.gameserver.commons.message.MsgDispatcher;
import com.dyz.gameserver.net.MinaMsgHandler;
import com.dyz.gameserver.net.NetManager;

public class GameServer {
	
	private static final Logger logger = LoggerFactory.getLogger(GameServer.class);

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
		logger.info("start game server ...");
		netManager.startListner(new MinaMsgHandler(), 1101);
		logger.info("game server started...");
		
	}
	
	public void stop(){
		netManager.stop();
		logger.info("stop game server ...");
	}
	
}
