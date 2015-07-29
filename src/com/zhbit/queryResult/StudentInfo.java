package com.zhbit.queryResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhbit.Util.DB;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

/**
 * 学生信息类
 * @author chenyueling
 *
 */
public class StudentInfo {
	
	
	private String bedNum;
	private String college;
	private String dormId;
	private String Home;
	private String id;
	private String inOutDate;
	private String major;
	private String name;
	private String phone;
	private String roomId;
	private String sex;
	private String stuClass;
	private String StuEtime;
	
	
	public String getBedNum() {
		return bedNum;
	}
	public String getCollege() {
		return college;
	}
	public String getDormId() {
		return dormId;
	}
	public String getHome() {
		return Home;
	}
	public String getId() {
		return id;
	}
	public String getInOutDate() {
		return inOutDate;
	}
	public String getMajor() {
		return major;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getRoomId() {
		return roomId;
	}
	public String getSex() {
		return sex;
	}
	public String getStuClass() {
		return stuClass;
	}
	public String getStuEtime() {
		return StuEtime;
	}
	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void setDormId(String dormId) {
		this.dormId = dormId;
	}
	public void setHome(String home) {
		Home = home;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setInOutDate(String inOutDate) {
		this.inOutDate = inOutDate;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public void setStuEtime(String stuEtime) {
		StuEtime = stuEtime;
	}
	
	public void getStudentInfo() throws QueryResultIsNullException, DataBaseException{
		
		String sql = null;
		try {
			Statement stmt = DB.CreateStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs==null){
			throw new QueryResultIsNullException();
		}
		rs.next();
		//studentInfo.setrs.getString()
		//TODO ..............
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	
}
