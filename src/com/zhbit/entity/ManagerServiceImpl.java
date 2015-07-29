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
import com.zhbit.queryResult.AllDormitoryInfo;
import com.zhbit.queryResult.AllMaintanceRecord;
import com.zhbit.queryResult.AllStudentInfo;
import com.zhbit.queryResult.DormitoryBuildingInfo;
import com.zhbit.queryResult.StudentInfo;

public class ManagerServiceImpl implements ManagerService {

	private Connection connection ;
	
	public ManagerServiceImpl(){
		 try {
			connection = DB.getConnection();
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Vector<Object> getAllStudentInfo(String dmid)
			throws QueryResultIsNullException, DataBaseException {
		Statement stmt = DB.CreateStatement();
		String sql = "select * from View_Student_College_StuDormRoom where DormId = '" + dmid + "'";
		//String sql = "select * from View_Student_College " ;
	//System.out.println(sql);
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(rs!=null&&!rs.next()){
				throw new QueryResultIsNullException();
			}
			Vector<Object> vectors = new Vector<Object>();
			Vector<Object> vector = new Vector<Object>();
			for(int i=1;i<=9;i++){
				vector.add(rs.getObject(i));
			}
			vectors.add(vector);
			while(rs.next()){
				vector = new Vector<Object>();
				for(int i=1;i<=9;i++){
					vector.add(rs.getObject(i));
				}
				vectors.add(vector);
			}
			return vectors;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}
		
	}
/*
	
	@Override
	public AllStudentInfo getAllStudentInfo()
			throws QueryResultIsNullException, DataBaseException {
		AllStudentInfo allStudentInfo = null;
		allStudentInfo = new AllStudentInfo();
		allStudentInfo.getAllStudentInfo();

		return allStudentInfo;
	}*/

	@Override
	public StudentInfo queryStudentInfoById(String studentId)
			throws QueryResultIsNullException, DataBaseException {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.getStudentInfo();
		return studentInfo;

	}

	@Override
	public void queryStudentInfoByName(String studentName) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void queryStudentInfoByDormitoryId(String dormitoryId) {
		// TODO 自动生成的方法存根

	}

	@Override
	public Vector<Object> getAllExpressInfo(String dmid) throws DataBaseException, QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql ="select *from ExpressTransceiver where DormId = '" + dmid + "'";
		ResultSet rs = null;
		Vector<Object> vector = null;
		Vector<Object> vectors = new Vector<Object>();
		try {
			rs = stmt.executeQuery(sql);
			if(rs!=null&&!rs.next()){
				throw new QueryResultIsNullException();
			}
			vector = new Vector<Object>();
			for(int i = 1 ;i<=11;i++){
					 
				vector.add(rs.getString(i));
				
			}
			vectors.add(vector);
			while(rs.next()){
				vector = new Vector<Object>();
				for(int i = 1 ;i<=11;i++){
					 
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
	
	public boolean updateExpressTransceiver(int Record, String Data){

		try {
			CallableStatement cst = connection.prepareCall("{call proc_ExpressTransceiver_Get(?,?)}");
			cst.setInt(1, Record);
			cst.setString(2, Data);
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
	

	public boolean insetRecord(String cmid, String stuId, String data, String mark){

		try {
			CallableStatement cst = connection.prepareCall("{call proc_ExpressTransceiver_Come(?,?,?,?)}");
			cst.setString(1, cmid);
			cst.setString(2, stuId);
			cst.setString(3, data);
			cst.setString(4, mark);
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
	public void getAllExpressUnSignIn() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void getAllExpressSignIn() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void queryExpressById(String ExpressId) {
		// TODO 自动生成的方法存根

	}

	@Override
	public AllMaintanceRecord getAllMaintenanceRecord(String dormId) throws DataBaseException, QueryResultIsNullException {
		AllMaintanceRecord allMaintanceRecord = new AllMaintanceRecord();
		allMaintanceRecord.getAllMaintanceRecord(dormId);
		return allMaintanceRecord;
	}

	@Override
	public void getFixedInfo() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void queryMaintenanceInfoByDormitoryId(String DormitoryId) {
		// TODO 自动生成的方法存根

	}

	@Override
	public AllDormitoryInfo getAllDormitoryInfo(String DormId)
			throws DataBaseException, QueryResultIsNullException {
		AllDormitoryInfo allDormitoryInfo = new AllDormitoryInfo();
		allDormitoryInfo.getAllDormitoryInfo(DormId);
		return allDormitoryInfo;

	}

	@Override
	public void queryDormitoryInfoById(String dormitoryId) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void PasswordUpdate(UpdatePassWordForm updatePassWordForm)
			throws PasswordNotMatchException, DataBaseException,
			UpdateSuccessException {
		String oldPassword = updatePassWordForm.getOldPassword();
		oldPassword = AESUtil.getInstance().encrypt(oldPassword);
		Statement stmt = DB.CreateStatement();
		String sql = "select  *from DMAccountPassword where DMId='"
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
				String upsql = "update DMAccountPassword set Password='"
						+ newPassword + "' where DMId='" + ownerId + "'";
				System.out.println(upsql);
				stmt.executeUpdate(upsql);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		throw new UpdateSuccessException();

	}
	/*
	@Override
	public void PasswordUpdate(UpdatePassWordForm updatePassWordForm)
			throws PasswordNotMatchException, DataBaseException,
			UpdateSuccessException {
		String oldPassword = updatePassWordForm.getOldPassword();
		oldPassword = AESUtil.getInstance().encrypt(oldPassword);
		Statement stmt = DB.CreateStatement();
		String sql = "select  *from DMAccountPassword where DMId = '"
				+ updatePassWordForm.getOwnerId() + "' and Password ='"
				+ oldPassword + "'";
		System.out.println(sql);
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				throw new PasswordNotMatchException();
			} else {
				String newPassword = updatePassWordForm.getNewassword();
				newPassword = AESUtil.getInstance().encrypt(newPassword);
				String ownerId = updatePassWordForm.getOwnerId();
				String upsql = "update DMAccountPassword set Password='"
						+ newPassword + "' where DMId '" + ownerId + "'";
				System.out.println(upsql);
				stmt.executeUpdate(upsql);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		throw new UpdateSuccessException();

	}
*/
	@Override
	public void getAllDormitoryPropertyInfo() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void queryDormitoryPropertyInfoById(String dormitoryId) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void initPersonalInfo(Manager manager) throws DataBaseException,
			QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql = "select *from DormManage where DMId=" + manager.getId();
		//System.out.println(sql);
		try {
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				throw new QueryResultIsNullException();
			}
			// rs.next();
			manager.setName(rs.getString("DMName"));
			manager.setSex(rs.getString("DMsex"));
			manager.setDormId(rs.getString("DormId"));
			manager.setPhone(rs.getString("DMPhone"));

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块

			e.printStackTrace();
			throw new DataBaseException();
		}

	}

	@Override
	public void UpdatePersonalInfo(UpdatePersonalInfoForm updatePersonalInfoForm)
			throws UpdateDataException, DataBaseException {
Connection connection = DB.getConnection();
		String sql = "update DormManage set DMPhone=? where DMid="
				+ updatePersonalInfoForm.getOwnerId();
	//	System.out.println(sql);
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, updatePersonalInfoForm.getPhone());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateDataException();

		}
	}

	@Override
	public DormitoryBuildingInfo getDormitory(String DMID)
			throws DataBaseException, QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql = "select *from View_Dormitory_College where Dormid=(select DormId from DormManage where DMId='"
				+ DMID + "')";
		//System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			if (rs != null && !rs.next()) {
				throw new QueryResultIsNullException();
			}
			DormitoryBuildingInfo dormitoryBuildingInfo = new DormitoryBuildingInfo();
			dormitoryBuildingInfo.setDormId(rs.getString("DormID"));
			dormitoryBuildingInfo.setStuSex(rs.getString("StuSex"));
			dormitoryBuildingInfo.setCollege(rs.getString("College"));
			dormitoryBuildingInfo.setEtime(rs.getString("Etime"));
			dormitoryBuildingInfo.setLiveNum(rs.getString("LiveNum"));
			dormitoryBuildingInfo.setConNum(rs.getString("ConNum"));
			return dormitoryBuildingInfo;

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public Vector<Object> getAllCurfewRecord(String DMID) throws DataBaseException, QueryResultIsNullException {
		Statement stmt = DB.CreateStatement();
		String sql = "select *from Curfew where Dormid="+DMID +"order by StuId asc";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(rs!=null&&!rs.next()){
				throw new QueryResultIsNullException();
			}
			Vector<Object> vectors = new Vector<Object>();
			Vector<Object> vector = new Vector<Object>();
			for(int i=1;i<=10;i++){
				vector.add(rs.getString(i));
			}
			vectors.add(vector);
			while(rs.next()){
				vector = new Vector<Object>();
				for(int i=1;i<=10;i++){
					vector.add(rs.getString(i));
				}
				vectors.add(vector);
				
			}
			return vectors;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}
		
	}
	

	public boolean insertLCRecord(String stuId, String stuName, String data,String lC, String mark)throws DataBaseException, QueryResultIsNullException{
		
	//	System.out.println("***********---");
		
		try {
			CallableStatement cst = connection.prepareCall("{call proc_LeaveComeStu(?,?,?,?,?)}");
			cst.setString(1, stuId);
			cst.setString(2, stuName);
			cst.setString(3, data);
			cst.setString(4, lC);
			cst.setString(5, mark);
			
			//System.out.println("***********---");
			
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

	
	public boolean insertCurfew(String stuId, String stuName, String curfew, String rmark, String dMid)throws DataBaseException, QueryResultIsNullException {

		try {
			CallableStatement cst = connection.prepareCall("{call proc_Curfew(?,?,?,?,?)}");
			cst.setString(1, stuId);
			cst.setString(2, stuName);
			cst.setString(3, curfew);
			cst.setString(4, rmark);
			cst.setString(5, dMid);
			
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
	public Vector<Object> getAllLeaveComeStu(String DormId) throws DataBaseException, QueryResultIsNullException{
		Statement stmt = DB.CreateStatement();
		String sql = "select *from LeaveComeStu where DormId='"+DormId+"'";
	//	System.err.println(sql);
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(rs!=null&&!rs.next()){
				throw new QueryResultIsNullException();
			}
			Vector<Object> vectors = new Vector<Object>();
			Vector<Object> vector = new Vector<Object>();
			for(int i=1;i<=9;i++){
				vector.add(rs.getString(i));
			}
			vectors.add(vector);
			while(rs.next()){
				vector = new Vector<Object>();
				for(int i=1;i<=9;i++){
					vector.add(rs.getString(i));
				}
				vectors.add(vector);
			}
			return vectors;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataBaseException();
		}
	}
	
	
	public boolean outStu(String stuId, String rmark) throws DataBaseException{
		
		Statement stmt;
		stmt = DB.CreateStatement();
		String sql = "select StuId from StuDormRoom where StuId='" +stuId + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs!=null && !rs.next()){
				return false;
			}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			CallableStatement cst = connection.prepareCall("{call proc_StuInOut_SDM_out(?,?)}");
			cst.setString(1, stuId);
			cst.setString(2, rmark);
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
	
	public String getStuName(String stuId) throws DataBaseException{

		String Name = null;
		
		
		Statement stmt;
		stmt = DB.CreateStatement();
		String sql = "select StuName from Student where StuId='" +stuId + "'";
		try {
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs!=null && !rs.next()){
			//System.out.print("学生姓名查询失败");
				
				return null;
			}
			
			Name = rs.getString(1);
				
		//	System.out.print("学生姓名查询成功");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return Name;
		
	}
	
	
	public boolean insertStu(String dormId2, String roomId, String bedId, String stuId, String data, String rmark) throws DataBaseException, QueryResultIsNullException{
		
		Statement stmt;
		stmt = DB.CreateStatement();
		String sql = "select StuId from StuDormRoom where StuId='" +stuId + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs!=null && rs.next()){
				return false;
			}
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
			CallableStatement cst = connection.prepareCall("{call proc_StuInOut_SDM_in(?,?,?,?,?,?)}");
			cst.setString(1, stuId);
			cst.setString(2, dormId2);
			cst.setString(3, roomId);
			cst.setString(4, bedId);
			cst.setString(5, data);
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

}
