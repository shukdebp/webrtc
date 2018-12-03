
package com.pwc.r2p2.common.exception;


import java.io.Serializable;
import java.security.SecureRandom;


public class R2P2RollException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1718120506142333218L;
	private String exceptionCode = null;
	private String exceptionMsgs = null;
	private String exceptionUniqueKey = null;

	public String getExceptionCode() {
		return exceptionCode;
	}

	public String getExceptionUniqueKey() {
		return exceptionUniqueKey;
	}

	public void setExceptionUniqueKey(String exceptionUniqueKey) {
		this.exceptionUniqueKey = exceptionUniqueKey;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMsgs() {
		return exceptionMsgs;
	}

	public void setExceptionMsgs(String exceptionMsgs) {
		this.exceptionMsgs = exceptionMsgs;
	}

	public R2P2RollException()	{
		this.exceptionUniqueKey = generateUniqueKey();
	}

	public R2P2RollException(String message) {
		super(message);
		this.exceptionUniqueKey = generateUniqueKey();
	}


	public R2P2RollException(Throwable cause) {
		super(cause);		
		this.exceptionUniqueKey = generateUniqueKey();

	}

	public R2P2RollException(String message, Throwable cause) {
		super(message, cause);
		this.exceptionUniqueKey = generateUniqueKey();
	}

	public R2P2RollException(String exceptionCode, String exceptionMsg,Throwable cause)
	{
		super(cause);
		this.exceptionCode = exceptionCode;
		this.exceptionMsgs = exceptionMsg;
		this.exceptionUniqueKey = generateUniqueKey();

	}

	protected String generateUniqueKey() {
		return generateRandomNo();
	}



	public static String generateRandomNo(int limit) {

		SecureRandom rand = null;
		int nextInt = 0;
		String randomNum = null;

		try {
			rand = SecureRandom.getInstance("SHA1PRNG");
			rand.setSeed(System.currentTimeMillis());
			if (limit == 0) {
				nextInt = rand.nextInt();
			} else {
				nextInt = rand.nextInt(limit);
			}
			randomNum = String.valueOf(nextInt);

		} catch (Exception e) {
		} finally {
			rand = null;
		}

		return randomNum;
	}

	public static String generateRandomNo() {

		return generateRandomNo(0);
	}

}



