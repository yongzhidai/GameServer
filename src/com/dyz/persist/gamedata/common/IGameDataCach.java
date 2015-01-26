package com.dyz.persist.gamedata.common;
/**
 * 所有的对gamedata数据操作的管理器实现此接口，用于统一加载gamedata
 * 继承此类的 gamedata管理器要为单例模式
 * 
 * @author dyz
 *
 */
public interface IGameDataCach {

	/**
	 * 重记载数据，也可以用于初始化记载，
	 * 
	 */
	public void reload();
}
