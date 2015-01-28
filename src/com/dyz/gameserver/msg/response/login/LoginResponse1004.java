package com.dyz.gameserver.msg.response.login;

import java.io.IOException;

import com.dyz.gameserver.commons.message.ServerResponse;

public class LoginResponse1004 extends ServerResponse{

	public LoginResponse1004(boolean isSuccess) {
		super(1004);
		try {
			output.writeBoolean(isSuccess);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
