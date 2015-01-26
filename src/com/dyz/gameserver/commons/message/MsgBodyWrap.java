package com.dyz.gameserver.commons.message;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 封装了消息体(内容,不包括消息号),用于封装从客户端读取到的数据，或者发送到客户端的数据
 * 
 * @author dyz
 * 
 */
public class MsgBodyWrap {
	//	private boolean read = true;
	private ByteArrayInputStream in;
	private ByteArrayOutputStream out;

	private DataInputStream dataIn;
	private DataOutputStream dataOut;

	public static MsgBodyWrap newInstance4In(byte[] buffer) {
		return new MsgBodyWrap(buffer);

	}

	
	public static MsgBodyWrap newInstance4Out() {
		return new MsgBodyWrap();
	}

	private MsgBodyWrap(byte[] buffer) {
		in = new ByteArrayInputStream(buffer);
		dataIn = new DataInputStream(in);
	}

	private MsgBodyWrap() {
		out = new ByteArrayOutputStream();
		dataOut = new DataOutputStream(out);
	}

	public byte readByte() throws IOException {
		return dataIn.readByte();
	}

	public int read() throws IOException {
		return dataIn.read();
	}

	public short readShort() throws IOException {
		return dataIn.readShort();
	}

	public int readInt() throws IOException {
		return dataIn.readInt();
	}

	public long readLong() throws IOException {
		return dataIn.readLong();
	}

	public float readFloat() throws IOException {
		return dataIn.readFloat();
	}

	public double readDouble() throws IOException {
		return dataIn.readDouble();
	}

	public String readUTF() throws IOException {
		return dataIn.readUTF();
	}

	public void writeByte(int value) throws IOException {
		dataOut.writeByte(value);
	}

	public void writeBoolean(boolean value) throws IOException {
		dataOut.writeBoolean(value);
	}

	public void writeBytes(byte[] value) throws IOException {
		dataOut.write(value);
	}

	public void writeShort(int value) throws IOException {
		dataOut.writeShort(value);
	}

	public void writeInt(int value) throws IOException {
		dataOut.writeInt(value);
	}

	public void writeLong(long value) throws IOException {
		dataOut.writeLong(value);
	}

	public void writeFloat(float value) throws IOException {
		dataOut.writeFloat(value);
	}

	public void writeDouble(double value) throws IOException {
		dataOut.writeDouble(value);
	}

	public void writeUTF(String value) throws IOException {
		dataOut.writeUTF(value);
	}

	public byte[] toByteArray() {
		return this.out.toByteArray();
	}
	
	/**
	 * 关闭缓冲读写数据流
	 */
	public void close() {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (out != null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (dataIn != null) {
			try {
				dataIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (dataOut != null) {
			try {
				dataOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
