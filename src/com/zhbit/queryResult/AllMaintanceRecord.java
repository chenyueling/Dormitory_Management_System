package com.zhbit.queryResult;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.zhbit.Util.DB;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

/**
 * 本栋楼所有维修记录信息
 * @author chenyueling
 *
 */
public class AllMaintanceRecord {
	
	private Connection connection;
	private Vector<Object> allMaintanceRecord =  new  Vector<Object>();
	
	public AllMaintanceRecord() throws DataBaseException{
		connection = DB.getConnection();
	}
	
	public Vector<Object> getAllMaintanceRecord() {
		return allMaintanceRecord;
	}


	public void setAllMaintanceRecord(Vector<Object> allMaintanceRecord) {
		this.allMaintanceRecord = allMaintanceRecord;
	}

	public boolean updateMaintanceRecord(int Record,String MainId,String Data){
		
		try {
			CallableStatement cst = connection.prepareCall("{call proc_MaintenanceRecord_Service(?,?,?)}");
			cst.setInt(1, Record);
			cst.setString(2, Data);
			cst.setString(3, MainId);
			int r = cst.executeUpdate();
			cst.close();
			if(r >0 ){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public void getAllMaintanceRecord(String dormId) throws DataBaseException, QueryResultIsNullException{
		//Connection connection = DB.getConnection();
		String sql ="select * from View_MR_Stu_It where DormId="+dormId;
		Statement stmt = DB.CreateStatement();
		ResultSet rs = null; 
		try {
			rs = stmt.executeQuery(sql);
			if(rs!=null&&!rs.next()){
				throw new QueryResultIsNullException();
			}
			
			Vector<Object> line = new Vector<Object>();
		 
			/*line.add(rs.getString("RecordNum"));
			line.add(rs.getString("StuId"));
			line.add(rs.getString("StuName"));
			line.add(rs.getString("DormId"));
			line.add(rs.getString("roomId"));
			line.add(rs.getString("ItName"));
			line.add(rs.getString("RepaireDate"));
			line.add(rs.getString("ServiceDate"));
			line.add(rs.getString("isReplace"));
			line.add(rs.getString("MaId"));
			line.add(rs.getString("Remark"));
			*/
			
			for(int i=1; i<=13; i++){
				String string = rs.getString(i);
				if(string==null){
					line.add("空");
				}else{
					line.add(string);
				}
			}
			
			allMaintanceRecord.add(line);
			while(rs.next()){
				line = new Vector<Object>();
				
			  /*line.add(rs.getString("RecordNum"));
				line.add(rs.getString("StuId"));
				line.add(rs.getString("StuName"));
				line.add(rs.getString("DormId"));
				line.add(rs.getString("roomId"));
				line.add(rs.getString("ItName"));
				line.add(rs.getString("RepaireDate"));
				line.add(rs.getString("ServiceDate"));
				line.add(rs.getString("isReplace"));
				line.add(rs.getString("MaId"));
				line.add(rs.getString("Remark"));
				
			*/
				for(int i=1; i<=13; i++){
					String string = rs.getString(i);
					if(string==null){
						line.add("空");
					}else{
						line.add(string);
					}
				}
				allMaintanceRecord.add(line);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}
	}
}
