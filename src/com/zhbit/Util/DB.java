package com.zhbit.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zhbit.excetion.DataBaseException;

/**
 * 数据库连接工具
 * 
 * @author chenyueling
 * 
 */
public class DB {
	private static Properties props;
	private static Connection conn = null;
	private static String url;
	private static String user;
	private static String password;
	private static String driver;

	private DB() {
	};

	static {

		props = new Properties();
		try {
			props.load(DB.class.getClassLoader().getResourceAsStream(
					"jdbc.properties"));
			url = props.getProperty("jdbc.url");
			user = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");
			driver = props.getProperty("jdbc.driverClassName");
			Class.forName(driver);
		} catch (IOException e) {
			System.out.println("配置文件读取异常");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(" 连接驱动获取失败");
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws DataBaseException {
		

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("数据库连接异常");
			e.printStackTrace();
			throw new DataBaseException();
			
		}
		
		return conn;
	}

	/**
	 * 
	 * 创建一个会话
	 * 
	 * @return
	 * @throws DataBaseException
	 */
	public static Statement CreateStatement() throws DataBaseException {
        if(conn==null){
        	//System.out.println("111");
        	getConnection();
        } 
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("会话建立失败");
			throw new DataBaseException();
			// e.printStackTrace();
		}
		return stmt;
	}

	public static PreparedStatement CreatePrepare(String sql) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("PrepareStament 创建失败");
			e.printStackTrace();
		}
		return stmt;
	} 
	/**
	 * 关闭连接
	 */
	public static void Close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
