package com.zhbit.queryResult;
/**
 * 维修记录
 * @author chenyueling
 *
 */
public class MaintanceRecord {
	private String recordNum;       //维修号
	private String stuId;    	//报修学生id
	private String stuName;  	 //报修学生信息
	private String dormId;  	//宿舍楼栋
	private String RoomId;			//报修房间号
	//private String bedId;
	private String itId;			//报修物品id
	private String itName;		//报修物品名称
	private String repaireDate;    //报修时间
	private String serviceDate;			//维修时间
	private String isReplace;			//是否维修	
	private String maId;				//维修员号码
	private String remark;				//备注
	
	public String getRecordNum() {
		return recordNum;
	}
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getDormId() {
		return dormId;
	}
	public void setDormId(String dormId) {
		this.dormId = dormId;
	}
	public String getRoomId() {
		return RoomId;
	}
	public void setRoomId(String roomId) {
		RoomId = roomId;
	}
	public String getItId() {
		return itId;
	}
	public void setItId(String itId) {
		this.itId = itId;
	}
	public String getItName() {
		return itName;
	}
	public void setItName(String itName) {
		this.itName = itName;
	}
	public String getRepaireDate() {
		return repaireDate;
	}
	public void setRepaireDate(String repaireDate) {
		this.repaireDate = repaireDate;
	}
	public String getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getIsReplace() {
		return isReplace;
	}
	public void setIsReplace(String isReplace) {
		this.isReplace = isReplace;
	}
	public String getMaId() {
		return maId;
	}
	public void setMaId(String maId) {
		this.maId = maId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
