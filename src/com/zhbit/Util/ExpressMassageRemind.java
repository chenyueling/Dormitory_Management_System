package com.zhbit.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhbit.entity.Student;
import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.QueryResultIsNullException;

public class ExpressMassageRemind implements Runnable {

	private String userId=null;
	private Statement stmt=null;
	private ExpressMassage expressMassage=null;
	private Student student;
	public ExpressMassageRemind(Student stu){
		this.student = stu;
		expressMassage = new ExpressMassage(stu);
	
	}
	
	
	
	@SuppressWarnings("unused")
	@Override
	public void run() {
		while (true) {
			
			
			try {
				Thread.sleep(expressMassage.getRemindTime()-100000);
				//Statement stmt = DB.CreateStatement();
			//	String sql = "select RecordNum,CName,ComeDate,Remark from ExpressTransceiver where StuId='"+userId+"'";
				
				
				//ResultSet rs = null;
				//System.out.println(sql);
				//rs = stmt.executeQuery(sql);
			//	System.out.println("快递~~~~~~~");
				
				/*JOptionPane.showMessageDialog(null, "您有快递", "系统信息",
						JOptionPane.WARNING_MESSAGE);*/
			/*	if(expressMassage!=null){
					remindTime=expressMassage.getRemindTime();
				}
				expressMassage.showInfo();
				if (rs != null && rs.next()) {
					if(expressMassage==null){
						expressMassage = new ExpressMassage(student);
			
						expressMassage.setVisible(true);
						}else{
							expressMassage.setVisible(true);
						}
					
				}*/
				if(expressMassage!=null){
					expressMassage.showInfo();
					expressMassage.setVisible(true);
					Thread.sleep(100000);
				}

			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (DataBaseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();

			} catch (QueryResultIsNullException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}

