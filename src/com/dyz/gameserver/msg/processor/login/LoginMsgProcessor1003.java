package com.dyz.gameserver.msg.processor.login;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.login.LoginResponse1004;

public class LoginMsgProcessor1003 extends MsgProcessor implements INotAuthProcessor{

	@Override
	public void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		String phone = request.getString();
		String passwd = request.getString();
		
		gameSession.sendMsg(new LoginResponse1004(true));
	}

}
