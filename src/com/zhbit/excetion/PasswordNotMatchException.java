package com.zhbit.excetion;


/**
 * 密码不匹配异常
 * @author chenyueling
 *
 */
@SuppressWarnings("serial")
public class PasswordNotMatchException extends Exception {
	public PasswordNotMatchException(){
		super("密码不匹配错误");
	}
}
