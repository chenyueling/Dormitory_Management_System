package com.zhbit.queryResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zhbit.Util.DB;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

/**
 * 所有学生的结果集
 * @author chenyueling
 *
 */
public class AllStudentInfo {
	
	private ArrayList<StudentInfo> allStudentInfo = new ArrayList<StudentInfo>();

	public ArrayList<StudentInfo> getAllStudentList() {
		return allStudentInfo;
	}

	public void setAllStudentList(ArrayList<StudentInfo> allStudentInfo) {
		this.allStudentInfo = allStudentInfo;
	}
	
	@SuppressWarnings("unused")
	public void getAllStudentInfo() throws QueryResultIsNullException, DataBaseException{
		StudentInfo  studentInfo = new StudentInfo();
		ArrayList<StudentInfo> list = getAllStudentList();
		Statement stmt = DB.CreateStatement();
		String sql = null;
		try {
			ResultSet rs = null;
					//stmt.executeQuery(sql);
			if (rs==null  && !rs.next()) {
				throw new QueryResultIsNullException();
			}
			while(rs.next()){
			studentInfo.setName(rs.getString("name"));
			studentInfo.setId(rs.getString("id"));
			studentInfo.setRoomId(rs.getString("roomId"));
			studentInfo.setDormId(rs.getString("dormId"));
			studentInfo.setBedNum(rs.getString("bedNum"));
			studentInfo.setInOutDate(rs.getString("inOutDate"));
				//TODO 还有方法没写完.等视图出来再写
			list.add(studentInfo);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new DataBaseException();
			
		}
	}
	
	
	
}
