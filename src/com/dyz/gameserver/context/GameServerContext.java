package com.dyz.gameserver.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.dyz.gameserver.sprite.Character;

public class GameServerContext {

	private static Map<Integer,Character> ALL_ONLINE_PLAYER = new ConcurrentHashMap<Integer, Character>();
	
	public static void addCharacter(Character character){
		ALL_ONLINE_PLAYER.put(character.getUserId(), character);
	}
	
	public static void removeCharacter(Character character){
		ALL_ONLINE_PLAYER.remove(character.getUserId());
	}
}
