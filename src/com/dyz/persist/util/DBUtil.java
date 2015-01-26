package com.dyz.persist.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 操作数据库工具类
 * @author dyz
 *
 */
public enum DBUtil {

	gamedata("mybaits-config-gamedata.xml"),
	roledata("mybaits-config-roledata.xml");
	
	private String configFile;
	
	private SqlSessionFactory sessionFactory;
	
	private DBUtil(String cfgName){
		this.configFile = cfgName;
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(this.configFile);
		} catch (IOException e) {
			System.out.println("read mybatis config file failed");
			e.printStackTrace();
		}
		sessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	public <T> T getMapper(Class<T> mapper){
	    SqlSession sqlSession = sessionFactory.openSession();
	    return sqlSession.getMapper(mapper);
	}
	
}
