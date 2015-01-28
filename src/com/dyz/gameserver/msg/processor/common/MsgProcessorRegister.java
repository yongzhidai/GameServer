package com.dyz.gameserver.msg.processor.common;

import com.dyz.gameserver.msg.processor.login.LoginMsgProcessor1003;
import com.dyz.gameserver.msg.processor.login.OpenAppMsgProcessor1001;
import com.dyz.gameserver.msg.processor.login.SignUpMsgProcessor1005;


/**
 * 消息处理器注册类，所有的消息处理器，都在此注册实例化
 * @author dyz
 *
 */
public enum MsgProcessorRegister {
	/**用户打开app*/
	openApp(1001,new OpenAppMsgProcessor1001()),
	/**登陆处理器*/
	login(1003,new LoginMsgProcessor1003()),
	/**用户注册处理器*/
	signUp(1005,new SignUpMsgProcessor1005());
	
	
	private int msgCode;
	private MsgProcessor processor;
	private MsgProcessorRegister(int msgCode,MsgProcessor processor){
		this.msgCode = msgCode;
		this.processor = processor;
	}
	
	public int getMsgCode(){
		return this.msgCode;
	}
	
	public MsgProcessor getMsgProcessor(){
		return this.processor;
	}
}
