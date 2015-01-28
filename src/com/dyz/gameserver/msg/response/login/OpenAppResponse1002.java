package com.dyz.gameserver.msg.response.login;

import java.io.IOException;

import com.dyz.gameserver.commons.message.ServerResponse;

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
