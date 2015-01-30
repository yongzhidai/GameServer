package com.dyz.gameserver.msg.processor.login;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.context.GameServerContext;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.login.LoginResponse1004;
import com.dyz.persist.roledata.user.User;
import com.dyz.persist.roledata.user.UserService;
import com.dyz.gameserver.sprite.Character;

public class LoginMsgProcessor1003 extends MsgProcessor implements INotAuthProcessor{

	@Override
	public void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		String phone = request.getString();
		String passwd = request.getString();
		
		User user = UserService.getInstance().selectUser(phone, passwd);
		if(user==null){
			gameSession.sendMsg(new LoginResponse1004(false));
		}else{
			gameSession.setLogin(true);
			Character character = new Character(user);
			gameSession.setRole(character);
			GameServerContext.addCharacter(character);
			gameSession.sendMsg(new LoginResponse1004(true));
		}
		
		
	}

}
