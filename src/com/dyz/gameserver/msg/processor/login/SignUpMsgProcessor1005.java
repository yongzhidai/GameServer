package com.dyz.gameserver.msg.processor.login;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.login.SignUpResponse1006;
import com.dyz.persist.roledata.user.User;
import com.dyz.persist.roledata.user.UserService;

public class SignUpMsgProcessor1005 extends MsgProcessor implements INotAuthProcessor{

	@Override
	public void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		String name = request.getString();
		String phone = request.getString();
		String email = request.getString();
		String passwd = request.getString();
		User user = new User();
		user.setName(name);
		user.setPhonenumber(phone);
		user.setEmail(email);
		user.setPasswd(passwd);
		user.setRegdate(System.currentTimeMillis());
		
		int id = UserService.getInstance().addUser(user);
		if(id>=0){
			user.setId(id);
			gameSession.setLogin(true);
			gameSession.setRole(user);
			gameSession.sendMsg(new SignUpResponse1006(true));
		}else{
			gameSession.sendMsg(new SignUpResponse1006(false));
		}
	}

}
