package net.ibizsys.paas.api;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.exception.ErrorException;

/**
 * Rest 调用异常对象
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class RestCallException extends ErrorException {

	private int nStatusCode = 200;
	
	public RestCallException(int nStatusCode) {
		super(Errors.OK);
		this.nStatusCode = nStatusCode;
	}
	
	
	public RestCallException(int nErrorCode, String strMessage) {
		super(nErrorCode, strMessage);
	}
	
	
	/**
	 * 获取请求状态代码
	 * @return
	 */
	public int getStatusCode(){
		return this.nStatusCode;
	}
	
	
	/**
	 * 判断状态代码是否正常
	 * @return
	 */
	public boolean isStatusCodeOk(){
		return getStatusCode()==200 ;
	}
}
