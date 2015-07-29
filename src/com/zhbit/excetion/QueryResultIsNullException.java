package com.zhbit.excetion;


/**
 * 查询不到结果跑出异常
 * @author chenyueling
 *
 */
@SuppressWarnings("serial")
public class QueryResultIsNullException extends Exception {
	public QueryResultIsNullException() {
		super("查询结果为空");
	}
}
