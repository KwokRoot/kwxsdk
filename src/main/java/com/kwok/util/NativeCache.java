package com.kwok.util;

import java.util.HashMap;
import java.util.Map;

public class NativeCache {
	
	/*
	 * 标识 Redis 请求正常
	 */
	public static boolean isOk_Redis = true;
	
	public static Map<Integer, String> specialUserMap = new HashMap<Integer, String>();
	
	static{
		specialUserMap.put(2, "oYHXlwJTFGxD8hUyAZTNCGfu5l6M");
		specialUserMap.put(3, "xyz");
	}
	
}
