package com.dyz.persist.util;

import java.io.IOException;
import java.io.InputStream;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapConfigParser;
/**
 * 操作数据库工具类,负责初始化ibatis的SqlMapClient，
 * 注意，如果ibatis的config文件中没有配置sqlMap元素，不要初始化，否则会报错
 * @author dyz
 *
 */
public class DBUtil {

	private static SqlMapClient roledataSqlMapClient;
	
	private static SqlMapClient gamedataSqlMapClient;
	
	public static void initAllSqlMapClient()throws Exception{
		//gamedataSqlMapClient=initSqlMapClient("ibatis-gamedata-config.xml");
		roledataSqlMapClient=initSqlMapClient("ibatis-roledata-config.xml");
	}
	
	private static SqlMapClient initSqlMapClient(String cfgName) throws Exception{
		InputStream in = null;
		SqlMapClient sqlMapClient = null;
		try{
			in = Resources.getResourceAsStream(cfgName);
			sqlMapClient = new SqlMapConfigParser().parse(in);
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlMapClient;
	}

	public static SqlMapClient getRoledataSqlMapClient() {
		return roledataSqlMapClient;
	}

	public static SqlMapClient getGamedataSqlMapClient() {
		return gamedataSqlMapClient;
	}
	
	
	
}
