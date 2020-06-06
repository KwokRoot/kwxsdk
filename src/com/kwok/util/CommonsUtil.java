package com.kwok.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用工具类
 * @author Kwok
 */
public class CommonsUtil {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static SimpleDateFormat getSimpleDateFormat(){
		
		if(simpleDateFormat==null){
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		
		return simpleDateFormat;
	}
	
	/**
	 * 日期转化为格式化日期字符串
	 * @author Kwok
	 */
	public static String formatDate(Date date){
		
		if(simpleDateFormat==null){
			getSimpleDateFormat();
		}
		
		return simpleDateFormat.format(date);
		
	}
	
}
