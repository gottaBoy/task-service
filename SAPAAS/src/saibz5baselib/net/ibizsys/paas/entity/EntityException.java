package net.ibizsys.paas.entity;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;

/**
 * 数据对象值异常对象
 * 
 * @author lionlau
 *
 */
public class EntityException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntityError entityError = null;
	private IDataEntity iDataEntity = null;
	private int nErrorCode = Errors.OK;
	
	public EntityException(EntityError entityError) {
		super();
		this.entityError = entityError;

	}
	
	public EntityException(EntityError entityError,String strMessage) {
		super(strMessage);
		this.entityError = entityError;

	}
	
	public EntityException(EntityError entityError,IDataEntity iDataEntity) {
		super();
		this.entityError = entityError;
		this.iDataEntity = iDataEntity;

	}
	
	public EntityException(EntityError entityError,String strMessage,IDataEntity iDataEntity) {
		super(strMessage);
		this.entityError = entityError;
		this.iDataEntity = iDataEntity;
	}
	
	
	public EntityException(EntityError entityError,int nErrorCode) {
		super();
		this.entityError = entityError;
		this.nErrorCode = nErrorCode;

	}
	
	public EntityException(EntityError entityError,int nErrorCode,String strMessage) {
		super(strMessage);
		this.entityError = entityError;
		this.nErrorCode = nErrorCode;

	}
	
	public EntityException(EntityError entityError,int nErrorCode,IDataEntity iDataEntity) {
		super();
		this.entityError = entityError;
		this.iDataEntity = iDataEntity;
		this.nErrorCode = nErrorCode;
	}
	
	public EntityException(EntityError entityError,int nErrorCode,String strMessage,IDataEntity iDataEntity) {
		super(strMessage);
		this.entityError = entityError;
		this.iDataEntity = iDataEntity;
		this.nErrorCode = nErrorCode;
	}

	/**
	 * 获取数据对象错误对象
	 * 
	 * @return
	 */
	public EntityError getEntityError() {
		return this.entityError;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		if (entityError != null) return entityError.toString();
		return super.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		if(StringHelper.isNullOrEmpty(super.getMessage())){
			if (entityError != null){
				return entityError.toString();
			}
			if(this.getErrorCode()!=Errors.OK)
				return Errors.getErrorInfo(getErrorCode());
		}
		return super.getMessage();
	}
	
	
	/**
	 * 获取实体对象
	 * @return
	 */
	public IDataEntity getDataEntity(){
		return this.iDataEntity;
	}
	
	
	/**
	 * 获取错误代码
	 * 
	 * @return the nErrorCode
	 */
	public int getErrorCode() {
		return nErrorCode;
	}
	
}
