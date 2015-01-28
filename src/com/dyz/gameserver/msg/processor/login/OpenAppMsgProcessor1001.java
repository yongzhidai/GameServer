package com.dyz.gameserver.msg.processor.login;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.commons.session.GameSession;
import com.dyz.gameserver.msg.processor.common.INotAuthProcessor;
import com.dyz.gameserver.msg.processor.common.MsgProcessor;
import com.dyz.gameserver.msg.response.login.OpenAppResponse1002;

/**
 * 
 *
 * @author  daiyongzhi
 * @date 2015年1月28日 下午1:15:21
 * @version V1.0
 */
public class OpenAppMsgProcessor1001 extends MsgProcessor implements INotAuthProcessor{

	@Override
	public void process(GameSession gameSession, ClientRequest request)
			throws Exception {
		gameSession.sendMsg(new OpenAppResponse1002("welecome !"));
	}

}
