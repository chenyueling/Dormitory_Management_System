package com.zhbit.entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.zhbit.Util.AESUtil;
import com.zhbit.Util.DB;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.PasswordNotMatchException;
import com.zhbit.excetion.QueryResultIsNullException;
import com.zhbit.excetion.UpdateDataException;
import com.zhbit.excetion.UpdateSuccessException;
import com.zhbit.form.UpdatePassWordForm;
import com.zhbit.form.UpdatePersonalInfoForm;

/**
 * 
 * @author lenovo
 * 
 */
public class StudentServiceImpl implements StudentService {

	@Override
	public void initPersonalInfo(Student student) throws DataBaseException,
			QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql = "select * from View_Student_College_StuDormRoom where stuid = '"
				+ student.getId() + "'";

		//System.out.println(sql);
		try {
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				throw new QueryResultIsNullException();
			}
			// rs.next();
			student.setName(rs.getString("StuName"));
	//System.out.println(rs.getString("Stuname"));
			student.setSex(rs.getString("Stusex"));
			student.setHome(rs.getString("StuHome"));
			student.setPhone(rs.getString("StuPhone"));
			student.setCollege(rs.getString("College"));
			student.setMajor(rs.getString("Major"));
			student.setClassNumber(rs.getString("StuClass"));
			student.setStuETime(rs.getString("StuETime"));
			student.setDormID(rs.getString("DormId"));
			student.setRoomID(rs.getString("RoomId"));

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块

			e.printStackTrace();
			throw new DataBaseException();
		}

	}


	
	
	@Override
	public void PasswordUpdate(UpdatePassWordForm updatePassWordForm)
			throws PasswordNotMatchException, DataBaseException,
			UpdateSuccessException {
		String oldPassword = updatePassWordForm.getOldPassword();
		oldPassword = AESUtil.getInstance().encrypt(oldPassword);
		Statement stmt = DB.CreateStatement();
		String sql = "select  *from StuAccountPassword where StuId='"
				+ updatePassWordForm.getOwnerId() + "' and Password ='"
				+ oldPassword + "'";
		//System.out.println(sql);
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				throw new PasswordNotMatchException();
			} else {
				String newPassword = updatePassWordForm.getNewassword();
				newPassword = AESUtil.getInstance().encrypt(newPassword);
				String ownerId = updatePassWordForm.getOwnerId();
				String upsql = "update StuAccountPassword set Password='"
						+ newPassword + "' where StuId='" + ownerId + "'";
				System.out.println(upsql);
				stmt.executeUpdate(upsql);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		throw new UpdateSuccessException();

	}
	
	

	@Override
	public void UpdatePersonalInfo(UpdatePersonalInfoForm updatePersonalInfoForm)
			throws UpdateDataException, DataBaseException {
		Connection connection = DB.getConnection();
		String sql = "update Student set Stuphone=?,StuHome=? where StuId="
				+ updatePersonalInfoForm.getOwnerId();
		//System.out.println(sql);
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, updatePersonalInfoForm.getPhone());
			pstmt.setString(2, updatePersonalInfoForm.getHome());
			pstmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UpdateDataException();

		}
	}

	@Override
	public Vector<Object> getPersonalExpressInfo(String StuId) throws DataBaseException,
			QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql = "select *from ExpressTransceiver where StuId='"+StuId+"'";
		ResultSet rs = null;
		Vector<Object> vector = null;
		Vector<Object> vectors = new Vector<Object>();
		try {
			rs = stmt.executeQuery(sql);
			if (rs != null && !rs.next()) {
				throw new QueryResultIsNullException();
			}
			vector = new Vector<Object>();
			for (int i = 1; i <= 11; i++) {

				vector.add(rs.getString(i));

			}
			vectors.add(vector);
			while (rs.next()) {
				vector = new Vector<Object>();
				for (int i = 1; i <= 11; i++) {

					vector.add(rs.getString(i));

				}
				vectors.add(vector);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}

		return vectors;

	}

	@Override
	public Vector<Object> showPersonalExpressInfo(String StuId) throws DataBaseException,
			QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql = "select StuName,ComeDate,CName,Remark from ExpressTransceiver where StuId='"+StuId+"'";
		ResultSet rs = null;
		Vector<Object> vector = null;
		Vector<Object> vectors = new Vector<Object>();
		try {
			//System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if (rs != null && !rs.next()) {
				throw new QueryResultIsNullException();
			}
			vector = new Vector<Object>();
			vector.add(rs.getString("StuName"));
			vector.add(rs.getString("ComeDate"));
			vector.add(rs.getString("CName"));
			vector.add(rs.getString("Remark"));

			vectors.add(vector);
			while (rs.next()) {
				vector = new Vector<Object>();
				vector.add(rs.getString("StuName"));
				vector.add(rs.getString("ComeDate"));
				vector.add(rs.getString("CName"));
				vector.add(rs.getString("Remark"));
				
				vectors.add(vector);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}

		return vectors;

	}

	@Override
	public Vector<Object> getPersonalCurfewInfo(String StuId)
			throws DataBaseException, QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql = "select RecordNum,Curfew,CurfewNum,Remark,DMId from Curfew where StuId='"+StuId+"'";
		ResultSet rs = null;
		Vector<Object> vector = null;
		Vector<Object> vectors = new Vector<Object>();
		try {
			//System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if (rs != null && !rs.next()) {
				throw new QueryResultIsNullException();
			}
			vector = new Vector<Object>();
			for(int i=1;i<=5;i++){
				vector.add(rs.getString(i));
			}

			vectors.add(vector);
			while (rs.next()) {
				vector = new Vector<Object>();
				for(int i=1;i<=5;i++){
					vector.add(rs.getString(i));
				}
				
				vectors.add(vector);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}

		return vectors;

		
	}

	@Override
	public Vector<Object> getMaintainceRecord(String RoomId) throws DataBaseException,
			QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql = "select *from View_MR_Stu_It where RoomId='"+RoomId+"'";
		ResultSet rs = null;
		Vector<Object> vector = null;
		Vector<Object> vectors = new Vector<Object>();
		try {
			//System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if (rs != null && !rs.next()) {
				throw new QueryResultIsNullException();
			}
			vector = new Vector<Object>();
			for(int i=1;i<=13;i++){
				vector.add(rs.getString(i));
			}

			vectors.add(vector);
			while (rs.next()) {
				vector = new Vector<Object>();
				for(int i=1;i<=13;i++){
					vector.add(rs.getString(i));
				}
				
				vectors.add(vector);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}

		return vectors;
	}

	
	public boolean insertItemMa(String id, String dormId2,String roomId2, String bedNum2, String itemId, String rmark) throws DataBaseException {

	
		
		try {
			
			Connection connection = DB.getConnection();
			CallableStatement cst = connection.prepareCall("{call proc_MaintenanceRecord_Repaire(?,?,?,?,?,?)}");
			cst.setString(1, id);
//cst.setString(2, name);
			cst.setString(2, dormId2);
			cst.setString(3, roomId2);
			cst.setString(4, bedNum2);
			cst.setString(5, itemId);
			cst.setString(6, rmark);
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


	@Override
	public Vector<Object> getItem() throws DataBaseException {
		// TODO Auto-generated method stub
		
		Statement stmt = DB.CreateStatement();
		String sql = "select ItName from ItemInfo";
		ResultSet rs = null;
		
		Vector<Object> vector = null;
		
		Vector<Object> vectors = new Vector<Object>();
		
		try {
		//System.out.println(sql);
		
			rs = stmt.executeQuery(sql);
			if (rs != null && !rs.next()) {
				throw new QueryResultIsNullException();
			}
			
			vector = new Vector<Object>();
			
			vector.add(rs.getString(1));
			
			vectors.add(vector);
			while (rs.next()) {
				vector = new Vector<Object>();
				
				vector.add(rs.getString(1));
				
				vectors.add(vector);
			}
			

		} catch (SQLException | QueryResultIsNullException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}

		return vectors;
		
	}



	@Override
	public boolean updateExpressTransceiver(int record, String data) throws DataBaseException {

		try {
			Connection connection = DB.getConnection();
			CallableStatement cst = connection.prepareCall("{call proc_ExpressTransceiver_Get(?,?)}");
			cst.setInt(1, record);
			cst.setString(2, data);
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

}
