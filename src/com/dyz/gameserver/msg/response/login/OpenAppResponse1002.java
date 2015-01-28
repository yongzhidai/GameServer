package com.dyz.gameserver.msg.response.login;

import java.io.IOException;

import com.dyz.gameserver.commons.message.ServerResponse;
/**
 * 
 *
 * @author  daiyongzhi
 * @date 2015年1月28日 下午2:12:34
 * @version V1.0
 */
public class OpenAppResponse1002 extends ServerResponse{

	public OpenAppResponse1002(String initWord){
		super(1002);
		try {
			output.writeUTF(initWord);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
