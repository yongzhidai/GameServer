package com.dyz.gameserver.bootstrap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GamserServerStartupAndStop implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		GameServer gameServer = (GameServer) arg0.getServletContext().getAttribute("gameserver");
		gameServer.stop();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		GameServer gameServer = GameServer.getInstance();
		arg0.getServletContext().setAttribute("gameserver", gameServer);
		gameServer.startUp();
	}

}
