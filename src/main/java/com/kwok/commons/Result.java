package com.kwok.commons;

import com.alibaba.fastjson.JSON;

/**
 * 自定义结果集类型
 * @author Kwok
 */
public class Result<T> {
	
	public enum Type{
		
		err(-1),yes(0);
		
		private int value;
		
		Type(int value){
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}
	
	
	public T data;
	public String message;
	public int code;
	
	public void setData(T data) {
		this.data = data;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	public static <T> Result<T> newInstance(){
		return new Result<T>();
	}
	
	
	public String toJson(){
		
		/*
		Gson gson = new Gson();
		return gson.toJson(this); //Gson 对泛型支持不是太好。
		*/
		
		return JSON.toJSONString(this); 
		
	}
	
}
