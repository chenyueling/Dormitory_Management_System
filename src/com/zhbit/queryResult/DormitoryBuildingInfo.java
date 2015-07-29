package com.zhbit.queryResult;

import java.util.Date;


/**
 * 宿舍楼信息查询结果类
 * @author chenyueling
 *
 */
public class DormitoryBuildingInfo {

	private String DormId;          //宿舍楼ID
	private String DMID;           //舍管ID
	private String StuSex;        //学生性别
	private String College;           //所住学生所属学院
	private String Etime;          //所住学生入学年份
	private String LiveNum;
	private String ConNum;
	
	
	public String getLiveNum() {
		return LiveNum;
	}
	public void setLiveNum(String liveNum) {
		LiveNum = liveNum;
	}
	public String getConNum() {
		return ConNum;
	}
	public void setConNum(String conNum) {
		ConNum = conNum;
	}
	public String getDormId() {
		return DormId;
	}
	public void setDormId(String dormId) {
		DormId = dormId;
	}
	public String getDMID() {
		return DMID;
	}
	public void setDMID(String dMID) {
		DMID = dMID;
	}
	public String getStuSex() {
		return StuSex;
	}
	public void setStuSex(String stuSex) {
		StuSex = stuSex;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public String getEtime() {
		return Etime;
	}
	public void setEtime(String string) {
		Etime = string;
		
	}
}
