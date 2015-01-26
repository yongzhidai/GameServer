package com.dyz.test.msgprocessor;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msgprocessor.common.INotAuthProcessor;
import com.dyz.gameserver.msgprocessor.common.MsgProcessor;
import com.dyz.test.msg.response.TestResponse;

public class TestProcessor extends MsgProcessor implements INotAuthProcessor{

	@Override
	public void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		System.out.println("msg code:"+request.getMsgCode());
		System.out.println("int  "+request.getInt());
		
		byte[] body = new byte[5];
		body[0] = request.getByte();
		body[1] = request.getByte();
		body[2] = request.getByte();
		body[3] = request.getByte();
		body[4] = request.getByte();
		System.out.println("string---"+new String(body,"utf-8"));
		
		gameSession.sendMsg(new TestResponse(54, "how do you do"));
	}

}
