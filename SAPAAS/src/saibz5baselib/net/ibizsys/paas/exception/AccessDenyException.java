package net.ibizsys.paas.exception;

import net.ibizsys.paas.core.Errors;

/**
 * 访问被拒绝异常
 * @author Administrator
 *
 */
public class AccessDenyException extends ErrorException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean bNotLogin = true;
	
	public AccessDenyException(String strMessage,boolean bNotLogin) {
		super(Errors.ACCESSDENY,strMessage);
		this.bNotLogin = bNotLogin;
	}

	/**
	 * 获取是否已经登录
	 * @return
	 */
	public boolean isNotLogin() {
		return bNotLogin;
	}

	/**
	 * 设置是否已经登录
	 * @param bNotLogin
	 */
	public void setNotLogin(boolean bNotLogin) {
		this.bNotLogin = bNotLogin;
	}

	
	

}
