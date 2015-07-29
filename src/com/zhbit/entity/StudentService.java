package com.zhbit.entity;

import java.util.Vector;

import com.zhbit.excetion.DataBaseException;
import com.zhbit.excetion.PasswordNotMatchException;
import com.zhbit.excetion.QueryResultIsNullException;
import com.zhbit.excetion.UpdateDataException;
import com.zhbit.excetion.UpdateSuccessException;
import com.zhbit.form.UpdatePassWordForm;
import com.zhbit.form.UpdatePersonalInfoForm;

/**
 * 
 * @author chenyueling
 *
 */
public interface StudentService {
	//********************查询快递信息******************//
	
	
	
	//*******************查询保修信息********************//
	
	
	//********************查询阿姨信息*********************//
	
	
	//**********************查询宿舍信息*******************//
	
	//*********************个人信息***********************//
	public void initPersonalInfo(Student student) throws DataBaseException,
	QueryResultIsNullException;
	
	/**
	 * 个人密码修改
	 * @param updatepassWordForm
	 * @throws PasswordNotMatchException
	 * @throws DataBaseException 
	 * @throws UpdateSuccessException 
	 */
	public void PasswordUpdate(UpdatePassWordForm updatepassWordForm) throws PasswordNotMatchException, DataBaseException, UpdateSuccessException;

	
	public void UpdatePersonalInfo(UpdatePersonalInfoForm updatePersonalInfoForm) throws UpdateDataException, DataBaseException;

	/**
	 * 查询学生个人详细的快递信息
	 * @return
	 * @throws DataBaseException
	 * @throws QueryResultIsNullException
	 */
	public Vector<Object> getPersonalExpressInfo(String StuId) throws DataBaseException,QueryResultIsNullException;
	
	
	
	/**
	 *快递信息消息弹出宽显示的快递信息 
	 * @return
	 * @throws DataBaseException
	 * @throws QueryResultIsNullException
	 */
	public Vector<Object> showPersonalExpressInfo(String StuId) throws DataBaseException,QueryResultIsNullException;

	/**
	 * 查询学生个人夜归记录
	 * @param StuId
	 * @return
	 * @throws DataBaseException
	 * @throws QueryResultIsNullException
	 */
	public Vector<Object> getPersonalCurfewInfo(String StuId)throws DataBaseException,QueryResultIsNullException;

	/**
	 * 查询自己所在宿舍报修信息
	 * @return
	 * @throws DataBaseException
	 * @throws QueryResultIsNullException
	 */
	public Vector<Object> getMaintainceRecord(String RoomId)throws DataBaseException,QueryResultIsNullException;

	public Vector<Object> getItem() throws DataBaseException;

	public boolean insertItemMa(String id,  String dormId2,	String roomId2, String bedNum2, String itemId, String rmark) throws DataBaseException;

	public boolean updateExpressTransceiver(int record, String data) throws DataBaseException;

}


