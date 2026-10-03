package net.ibizsys.paas.exception;

import net.ibizsys.paas.core.IDataEntity;

/**
 * 值错误异常
 * 
 * @author Administrator
 *
 */
public class ValueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDataEntity iDataEntity = null;
	
	public ValueException(String strError) {
		super(strError);
	}

	public ValueException(String strError,IDataEntity iDataEntity) {
		super(strError);
		this.iDataEntity = iDataEntity;
	}
	
	/**
	 * 获取实体对象
	 * @return
	 */
	public IDataEntity getDataEntity(){
		return this.iDataEntity;
	}
}
