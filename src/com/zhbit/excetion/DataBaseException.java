package com.zhbit.excetion;
/**
 * 发生SQL异常错误
 * @author chenyueling
 *
 */
@SuppressWarnings("serial")
public class DataBaseException extends Exception {
	public DataBaseException(){
		super("数据库错误");
	}
}
