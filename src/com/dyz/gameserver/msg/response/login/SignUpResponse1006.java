package com.dyz.gameserver.msg.response.login;

import java.io.IOException;

import com.dyz.gameserver.commons.message.ServerResponse;

public class SignUpResponse1006 extends ServerResponse{

	public SignUpResponse1006(boolean isSuccess) {
		super(1006);
		try {
			output.writeBoolean(isSuccess);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
