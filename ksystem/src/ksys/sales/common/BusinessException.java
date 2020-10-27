package ksys.sales.common;

public class BusinessException extends Exception {

	/**
	 * コンストラクタ
	 * @param message エラーメッセージ
	 */
	public BusinessException(String message){
		super(message);
	}
}
