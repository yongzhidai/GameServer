package com.dyz.gameserver.bootstrap;

import com.dyz.gameserver.commons.message.MsgDispatcher;
import com.dyz.gameserver.net.MinaMsgHandler;
import com.dyz.gameserver.net.NetManager;

public class GameServer {

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
		System.out.println("start game server ...");
		netManager.startListner(new MinaMsgHandler(), 1101);
		System.out.println("game server started...");
		
	}
	
	public void stop(){
		netManager.stop();
		System.out.println("stop game server ...");
	}
	
}
