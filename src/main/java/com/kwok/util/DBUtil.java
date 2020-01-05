package com.kwok.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.util.DaoUp;

import com.alibaba.druid.pool.DruidDataSource;
import com.kwok.config.AppConfig;
import com.kwok.model.entity.UserA;
import com.kwok.model.entity.UserB;

public class DBUtil {
	
	private static DruidDataSource druidDataSource;
	private static Connection connection;
	private static Dao dao;
	
	public static DruidDataSource getDataSource() {
		if (druidDataSource == null) {
			druidDataSource = new DruidDataSource();
			druidDataSource.setDriverClassName(AppConfig.dbDriver);
			druidDataSource.setUrl(AppConfig.dbUrl);
			druidDataSource.setUsername(AppConfig.dbUserName);
			druidDataSource.setPassword(AppConfig.dbPassword);
		}
		return druidDataSource;
	}

	public static Connection getConnection() {
		if (druidDataSource == null) {
			druidDataSource = getDataSource();
		}
		if (connection == null) {
			try {
				connection = druidDataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static Dao getNutDao() {
		if (dao == null) {
			DaoUp daoUp = DaoUp.me();
			daoUp.setDataSource(getDataSource());
			dao = daoUp.dao();
		}
		return dao;
	}
	
	/*
	 * 保存用户信息，如果用户已经存在，更新用户信息。
	 * @author Kwok
	 */
	public static Integer saveUserA(UserA userA) {

		Boolean isExistUser = false;
		UserA tempUserA = getNutDao().fetch(userA);

		if (tempUserA != null) {
			isExistUser = true;
		}

		try {
			if (!isExistUser) {
				getNutDao().insert(userA);
			} else {
				getNutDao().update(userA);
			}
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}
	
	
	/*
	 * 保存用户信息，如果用户已经存在，更新用户信息。
	 * @author Kwok
	 */
	public static Integer saveUserB(UserB userB) {
		
		Boolean isExistUser = false;

		UserB tempUserB = getNutDao().fetch(userB);

		if (tempUserB != null) {
			isExistUser = true;
		}

		try {
			if (!isExistUser) {
				getNutDao().insert(userB);
			} else {
				getNutDao().update(userB);
			}
		} catch (Exception e) {
			return -1;
		}
		return 1;
		
	}
	
	
	 /*
	  * 假删除用户信息，当用户取消关注时，更新用户的订阅状态。
	  * @author Kwok
	  */
	public static Integer deleteUserB(String openid){
		
		UserB userB = new UserB();
		userB.setOpenid(openid);
		userB = getNutDao().fetch(userB);
		if (userB != null) {
			userB.setSubscribe(0);
			saveUserB(userB);
		}
		return -1;
		
	}
	
	
	 /*
	  * 验证用户是否关注微信公众号-B
	  * @author Kwok
	  */
	public static boolean checkSubscribe(String unionid){
			
		UserB userB = getNutDao().fetch(UserB.class, Cnd.where("unionid", "=", unionid));

		if (userB != null && userB.getSubscribe() == 1) {
			return true;
		} else {
			return false;
		}
			
	}
	
	
	 /*
	  * 保存用户的投票记录(同一关注用户只能给投票活动下的同一栏目投一票。)
	  * @author Kwok
	  */
	public static Integer saveRecoed(String unionid, String itemid){
		
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM `record_1` WHERE `unionid` = ? AND `itemid` = ? ");
			preparedStatement.setString(1, unionid);
			preparedStatement.setString(2, itemid);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			String insertSqlStr = "INSERT INTO `record_1` (`unionid`, `itemid`, `time`) VALUES (?, ?, ?)";
			
			if(resultSet.next()){
				return 0;
			}else{
				PreparedStatement insertpreparedStatement = getConnection().prepareStatement(insertSqlStr);
				insertpreparedStatement.setString(1, unionid);
				insertpreparedStatement.setString(2, itemid);
				insertpreparedStatement.setTimestamp(3, new Timestamp(new Date().getTime()));
				return insertpreparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		
	}
	
}
