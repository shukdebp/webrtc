package com.pwc.r2p2.common.exception;

/**
 * This is class will be used to prepare the exception message for any user defined exception
 * @author shovanroy261
 *
 */
public class ExceptionMessageUtil {

	/**
	 * 
	 */
	public ExceptionMessageUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method return the exception message with doing some additional formatting.
	 * @param message
	 * @param code
	 * @param type
	 * @return
	 */
	public static String getExceptionMessage(String message,String code, String type){
		StringBuffer buffer = new StringBuffer();
		buffer.append(code);
		buffer.append(" : ");
		buffer.append(type);
		buffer.append("\n");
		buffer.append("Exception Message: ");
		buffer.append(message);
		return buffer.toString();

	}
	
	public static String getExceptionMessage(String message,String code){
		StringBuffer buffer = new StringBuffer();
		buffer.append(code);
		buffer.append(" : ");
		buffer.append(message);
		return buffer.toString();

	}

}

