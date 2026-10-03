package net.ibizsys.pswf.core;


/**
 * 流程异常
 * @author Administrator
 *
 */
public class WFException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int nErrorCode = 0;
	
	public WFException(int nErrorCode,String strMessage){
		super(strMessage);
		this.nErrorCode = nErrorCode;
	}
	
	public WFException(String strMessage){
		super(strMessage);
		this.nErrorCode = WFErrors.E_999999;   
	}
	
	
	/**
	 * 获取错误代码
	 * @return
	 */
	public int getErrorCode(){
		return this.nErrorCode;
	}
	
}
