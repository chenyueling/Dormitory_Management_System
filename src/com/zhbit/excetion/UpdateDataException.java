package com.zhbit.excetion;
/**
 * 数据更新失败
 * @author chenyueling
 *
 */
@SuppressWarnings("serial")
public class UpdateDataException extends Exception {
	public UpdateDataException(){
		super("数据更新失败!!!");
	}
}
