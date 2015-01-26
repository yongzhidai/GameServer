package com.dyz.gameserver.net.codec;

/**
 * 消息协议相关常量
 * @author Administrator
 *
 */
public interface MsgProtocol {

	/**默认flag值*/
	public byte defaultFlag = 1;
	/**最大长度*/
	public int maxPackLength = 1024 * 5;
	/**标识数占得 byte数*/
	public int flagSize = 1;//
	/**协议中 长度部分  占用的byte数,其值表示( 协议号+内容) 的长度*/
	public int lengthSize = 4;//
	/**消息号占用的byte数*/
	public int msgCodeSize = 4;
}
