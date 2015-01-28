package com.dyz.gameserver.msg.processor.common;

import com.dyz.gameserver.msg.processor.login.OpenAppMsgProcessor1001;


/**
 * 消息处理器注册类，所有的消息处理器，都在此注册实例化
 * @author Administrator
 *
 */
public enum MsgProcessorRegister {

	openApp(1001,new OpenAppMsgProcessor1001());
	
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
