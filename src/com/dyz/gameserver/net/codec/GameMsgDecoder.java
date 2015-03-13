package com.dyz.gameserver.net.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyz.gameserver.commons.message.ClientRequest;
import com.dyz.gameserver.net.MinaMsgHandler;

/**
 * 消息解码器。将连续的字节按照协议规范分割成完整的消息包，并包装成ClientRequest。
 * @author dyz
 */
public class GameMsgDecoder extends CumulativeProtocolDecoder {

	private static final Logger logger = LoggerFactory.getLogger(MinaMsgHandler.class);
	
	public GameMsgDecoder() {
		
	}
	
	/**
	 * flag(1 byte)+length(4 byte,后边内容的长度)+protocol code(4 byte)+content
	 * length的长度包括  ：消息号+ 内容
	 */
	@Override
	protected boolean doDecode(IoSession session, IoBuffer iobuffer,
			ProtocolDecoderOutput protocolDecoderOutput) throws Exception {
		
		if(iobuffer.remaining()<(MsgProtocol.flagSize+MsgProtocol.lengthSize+MsgProtocol.msgCodeSize)){//数据不完整
			logger.info("数据包长度不足");
			return false;
		}
		iobuffer.mark();
		byte flag = iobuffer.get();//flag，备用
		if (flag == 1) {
			int length = iobuffer.getInt();//读取长度字段
			if(length<=0 || length>MsgProtocol.maxPackLength){//长度字段异常
				logger.info("数据包长度异常");
				return false;
			}
			if(iobuffer.remaining()>=length){//
				int preLimit = iobuffer.limit();//记录下当前的limit值
				
				/**
				 * 这行代码有一个bug，
				 * 读取协议内容时，如果第一个字节不是1，则越过此字节继续往后的读，直到读到1，
				 * 然而在设置limit时没有考虑到越过去的flag之前的字节，从而导致设置的limit比本应设置的位置小。
				 * 所以导致，iobuffer中当前position到设置的limit的长度小于我们要读取的length。
				 * 结果导致抛出BufferUnderflowException
				 */
				//iobuffer.limit(MsgProtocol.flagSize+MsgProtocol.lengthSize+length);
				iobuffer.limit(iobuffer.position()+length);
				byte[] body = new byte[length];
				iobuffer.get(body);
				iobuffer.limit(preLimit);
				ClientRequest message = new ClientRequest(body);
				protocolDecoderOutput.write(message);
				return true;
			}else{
				logger.info("数据包尚不完整");
				iobuffer.reset();
				return false;
			}
		}else{
			logger.info("flag 错误");
			return false;
		}
	}
	
	public void finishDecode(IoSession session, ProtocolDecoderOutput out)
			throws Exception {
	}

	public void dispose(IoSession session) throws Exception {
	}
}