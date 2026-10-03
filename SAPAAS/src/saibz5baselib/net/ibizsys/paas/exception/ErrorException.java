package net.ibizsys.paas.exception;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;

/**
 * 错误异常对象
 * 
 * @author lionlau
 *
 */
public class ErrorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nErrorCode = Errors.OK;
	private IDataEntity iDataEntity = null;

	public ErrorException(int nErrorCode) {
		super();
		this.nErrorCode = nErrorCode;
	}

	public ErrorException(int nErrorCode, String strMessage) {
		super(strMessage);
		this.nErrorCode = nErrorCode;
	}
	
	public ErrorException(int nErrorCode,IDataEntity iDataEntity) {
		super();
		this.nErrorCode = nErrorCode;
		this.iDataEntity = iDataEntity;
	}

	public ErrorException(int nErrorCode, String strMessage,IDataEntity iDataEntity) {
		super(strMessage);
		this.nErrorCode = nErrorCode;
		this.iDataEntity = iDataEntity;
	}

	/**
	 * 获取错误代码
	 * 
	 * @return the nErrorCode
	 */
	public int getErrorCode() {
		return nErrorCode;
	}
	
	
	
	@Override
	public String getMessage() {
		String strMessage =  super.getMessage();
		if(StringHelper.isNullOrEmpty(strMessage))
			return Errors.getErrorInfo(getErrorCode());
		return strMessage;
	}

	
	/**
	 * 获取实体对象
	 * @return
	 */
	public IDataEntity getDataEntity(){
		return this.iDataEntity;
	}
}
