package com.dyz.gameserver.net;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.executor.OrderedThreadPoolExecutor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyz.gameserver.net.codec.GameProtocolcodecFactory;

public class NetManager {

	private static final Logger logger = LoggerFactory.getLogger(NetManager.class);
	
	private NioSocketAcceptor acceptor;
	private OrderedThreadPoolExecutor threadpool;
	
	public  void startListner(IoHandler iohandler,int listenPort) throws Exception{
		acceptor = new NioSocketAcceptor();
		acceptor.setBacklog(100);
		acceptor.setReuseAddress(true);
		acceptor.setHandler(iohandler);
		
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        IoFilter protocol = new ProtocolCodecFilter(new GameProtocolcodecFactory());
        chain.addLast("codec", protocol);
		threadpool = new OrderedThreadPoolExecutor(500);
		chain.addLast("threadPool", new ExecutorFilter(threadpool));
		
		int recsize = 5120;
		int sendsize = 40480;
		int timeout = 10;
		SocketSessionConfig sc = acceptor.getSessionConfig();
		sc.setReuseAddress(true);// 设置每一个非主监听连接的端口可以重用
		sc.setReceiveBufferSize(recsize);// 设置输入缓冲区的大小
		sc.setSendBufferSize(sendsize);// 设置输出缓冲区的大小
		sc.setTcpNoDelay(true);// flush函数的调用 设置为非延迟发送，为true则不组装成大包发送，收到东西马上发出   
		sc.setSoLinger(0);
		sc.setIdleTime(IdleStatus.READER_IDLE, timeout);
		acceptor.bind(new InetSocketAddress(listenPort));
	}
	
	public void stop(){
		acceptor.unbind();
		threadpool.shutdown();
		acceptor.dispose(true);
	}
}
