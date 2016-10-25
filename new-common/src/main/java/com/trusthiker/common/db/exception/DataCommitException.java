package com.trusthiker.common.db.exception;

/**
 * 表示数据提交失败。
 *
 * @author com.trusthiker.common
 */
public class DataCommitException extends RuntimeException {

	private static final long serialVersionUID = 1669843560642800254L;

	public DataCommitException() {
		super("Data commit failed!");
	}

}
