package ksys.sales.common;

public class SystemException extends Exception {

	/**
	 * コンストラクタ
	 * @param message エラーメッセージ
	 */
	public SystemException(String message){
		super(message);
	}
}
