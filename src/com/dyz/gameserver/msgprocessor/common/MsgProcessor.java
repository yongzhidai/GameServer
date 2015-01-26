package com.dyz.gameserver.msgprocessor.common;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;

public abstract class MsgProcessor {

	
	public void handle(GameSession gameSession,ClientRequest request){
		try {
			process(gameSession,request);
		} catch (Exception e) {
			System.out.println("消息处理出错，msg code:"+request.getMsgCode());
			e.printStackTrace();
		}
	}
	
	public abstract void process(GameSession gameSession,ClientRequest request)throws Exception;
}
