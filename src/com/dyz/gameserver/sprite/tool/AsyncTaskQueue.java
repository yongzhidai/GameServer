package com.dyz.gameserver.sprite.tool;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.dyz.gameserver.context.ExecutorServiceManager;
/**
 * 异步操作类，用于异步执行数据库操作
 *
 * @author  daiyongzhi
 * @date 2015年1月30日 下午6:23:47
 * @version V1.0
 */
public class AsyncTaskQueue {

	private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<Runnable>();
	private volatile boolean processingCompleted = true;
	
	public void addTask(Runnable... tasks){
		for(Runnable task:tasks){
			queue.offer(task);
		}
		if(processingCompleted){
			processingCompleted = false;
			ExecutorServiceManager.getInstance().getExecutorServiceForDB().execute(new Runnable() {
				
				@Override
				public void run() {
					executeQueueTask();
				}
			});
		}
	}
	
	private void executeQueueTask(){
		while(true){
			Runnable task = queue.poll();
			if(task == null){
				processingCompleted = true;
				break;
			}else{
				task.run();
			}
		}
	}
}
