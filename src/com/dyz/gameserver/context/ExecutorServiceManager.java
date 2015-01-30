package com.dyz.gameserver.context;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.dyz.gameserver.commons.tool.ServerThreadFactory;
/**
 * 整个服的线程池工具类
 *
 * @author  daiyongzhi
 * @date 2015年1月30日 下午5:37:16
 * @version V1.0
 */
public class ExecutorServiceManager {

	private static ExecutorServiceManager serviceManager = new ExecutorServiceManager();
	private ExecutorServiceManager(){}
	public static ExecutorServiceManager getInstance(){
		return serviceManager;
	}
	/**数据库操作使用的线程池*/
	private ScheduledThreadPoolExecutor executorServiceForDB;
	
	public void initExecutorService(){
		executorServiceForDB = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10,new ServerThreadFactory("ExecutorServiceForDB"));
	}
	
	public ScheduledThreadPoolExecutor ExecutorServiceForDB(){
		return executorServiceForDB;
	}
	
	public void stop() throws InterruptedException{
		executorServiceForDB.shutdown();
		executorServiceForDB.awaitTermination(1, TimeUnit.SECONDS);
	}
	
}
