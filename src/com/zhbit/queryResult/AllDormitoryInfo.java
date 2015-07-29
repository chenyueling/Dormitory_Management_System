package com.zhbit.queryResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.zhbit.Util.DB;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

/**
 * 查询本栋楼所有宿舍信息
 * 
 * @author chenyueling
 * 
 */
public class AllDormitoryInfo {
	//private List<DormitoryInfo> dormitoryInfos = new ArrayList<DormitoryInfo>();
	
	private Vector<Object> dormitoryInfos = new Vector<Object>();
	
	public Vector<Object> getdormitoryInfos(){
		return dormitoryInfos;
	}
	


	public Vector<Object> getDormitoryInfos() {
		return dormitoryInfos;
	}



	public void setDormitoryInfos(Vector<Object> dormitoryInfos) {
		this.dormitoryInfos = dormitoryInfos;
	}



	public void getAllDormitoryInfo(String DormId) throws DataBaseException,
			QueryResultIsNullException {
		
		Statement stmt = DB.CreateStatement();
		Statement stmt2 = DB.CreateStatement();
		
		String sql = "select * from DormitoryInfo where DormId="+DormId;
//System.out.println(sql);
		//DormitoryInfo dormitoryInfo = new DormitoryInfo();
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			
			if (rs != null && !rs.next()) {
				throw new QueryResultIsNullException();
			}

			
			ResultSet rs2 = null;
			
			String s, s1, sql2;
			
			s = rs.getString(1);
			s1 = rs.getString(2);		
	        sql2 = "select * from Stu_DormInfo('" + s + "','" + s1 + "')";
			
//System.out.println(sql2);	

			rs2 = stmt2.executeQuery(sql2);
			
			if (rs2 != null && !rs2.next()) {
				throw new QueryResultIsNullException();
			}
		
			Vector<Object> line = new Vector<Object>();
			for(int i=1; i<=8; i++){
				String string = rs2.getString(i);
				if(string==null){
					line.add("空");
				}else{
					line.add(string);
				}
			}
			dormitoryInfos.add(line);
			
//System.out.println(line);
			
			while(rs.next()){
				
	//System.out.println(line);

	
				s = rs.getString(1);
//System.out.println(s);
				s1 = rs.getString(2);		
		        sql2 = "select * from Stu_DormInfo('" + s + "','" + s1 + "')";	
 //System.out.println(line);
				rs2 = stmt2.executeQuery(sql2);

				if (rs2 != null && !rs2.next()) {
					throw new QueryResultIsNullException();
				}

				line = new Vector<Object>();
				for(int i=1; i<=8; i++){
					String string = rs2.getString(i);
					if(string==null){
						line.add("空");
					}else{
						line.add(string);
					}
				}
				dormitoryInfos.add(line);
				
//System.out.println(line);

			}
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataBaseException();
		}
	}
	
	
}
