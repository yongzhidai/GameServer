package com.dyz.gameserver.commons.session;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IoSession;

import com.dyz.gameserver.commons.message.ResponseMsg;
/**
 * 游戏中的session回话，封装了mina的session
 * @author dyz
 *
 */
public class GameSession {

	private IoSession session;
	private String address;
	
	private Object role;
	
	private boolean isLogin=false;
	
	private static final AttributeKey KEY_PLAYER_SESSION = new AttributeKey(GameSession.class, "player.session");
	
	public GameSession(IoSession session){
		this.session = session;
		this.session.setAttribute(KEY_PLAYER_SESSION, this);
		SocketAddress socketaddress = session.getRemoteAddress();
		InetSocketAddress s = (InetSocketAddress) socketaddress;
		address = s.getAddress().getHostAddress();
	}
	
	public static GameSession getInstance(IoSession session) {
		Object playerObj = session.getAttribute(KEY_PLAYER_SESSION);
		return (GameSession) playerObj;
	}
	
	/**
	 * 发送消息给客户端
	 * @param msg
	 * @return
	 */
	public WriteFuture sendMsg(ResponseMsg msg) {
		if (session == null || !session.isConnected() || session.isClosing()) {
			return null;
		}
		return session.write(msg);
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public  void setLogin(){
		this.isLogin=true;
	}
	public boolean isLogin(){
		return this.isLogin;
	}
	
	
}
