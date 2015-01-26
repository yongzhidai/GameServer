package com.dyz.test.msg.response;

import java.io.IOException;

import com.dyz.gameserver.commons.message.ServerResponse;

public class TestResponse extends ServerResponse{

	public TestResponse(int b,String str){
		setMsgCode(1002);
		try {
			output.writeInt(b);
			output.writeUTF(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
