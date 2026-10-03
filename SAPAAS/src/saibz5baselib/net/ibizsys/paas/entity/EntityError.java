package net.ibizsys.paas.entity;

import java.util.ArrayList;

import net.ibizsys.paas.util.StringBuilderEx;

/**
 * 数据对象错误对象
 * 
 * @author lionlau
 *
 */
public class EntityError {
	

	private ArrayList<EntityFieldError> fieldErrorList = new ArrayList<EntityFieldError>();
	
	private IEntity iEntity = null;
	
	private Object objUserData = null;
	

	/**
	 * 注册错误信息
	 * 
	 * @param entityFieldError
	 */
	public void register(EntityFieldError entityFieldError) {
		fieldErrorList.add(entityFieldError);
	}

	/**
	 * 注册错误信息
	 * 
	 * @param strFieldName 属性名称
	 * @param strCaption 逻辑名称
	 * @param strCapLanId 逻辑名称语言资源标识
	 * @param nErrorType 错误类型
	 * @param strErrorInfo 错误信息
	 */
	public void register(String strFieldName, String strCaption, String strCapLanId, int nErrorType, String strErrorInfo) {
		register(strFieldName, strCaption, strCapLanId, nErrorType, strErrorInfo, null);
	}

	/**
	 * 注册错误信息
	 * 
	 * @param strFieldName 属性名称
	 * @param strCaption 逻辑名称
	 * @param strCapLanId 逻辑名称语言资源标识
	 * @param nErrorType 错误类型
	 * @param strErrorInfo 错误信息
	 * @param objValue 错误值
	 */
	public void register(String strFieldName, String strCaption, String strCapLanId, int nErrorType, String strErrorInfo, Object objValue) {
		EntityFieldError fieldError = new EntityFieldError();
		fieldError.setFieldLogicName(strCaption);
		fieldError.setFieldName(strFieldName);
		fieldError.setErrorType(nErrorType);
		fieldError.setErrorInfo(strErrorInfo);
		fieldError.setFieldValue(objValue);
		fieldErrorList.add(fieldError);
	}

	/**
	 * 获取实体项错误清单
	 * 
	 * @return
	 */
	public ArrayList<EntityFieldError> getEntityFieldErrorList() {
		return this.fieldErrorList;
	}

	/**
	 * 实体是否有错误
	 * 
	 * @return
	 */
	public boolean hasError() {
		return this.fieldErrorList.size() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilderEx sb = new StringBuilderEx();
		boolean bFirst = true;
		for (EntityFieldError entityFieldError : fieldErrorList) {
			if (bFirst) {
				bFirst = false;
			} else {
				sb.append("\r\n");
			}
			sb.append(entityFieldError.toString());
		}
		return sb.toString();
	}

	

	/**
	 * 获取检查的数据对象
	 * @return
	 */
	public IEntity getEntity() {
		return iEntity;
	}

	/**
	 * 设置检查的数据对象
	 * @param iEntity
	 */
	public void setEntity(IEntity iEntity) {
		this.iEntity = iEntity;
	}

	/**
	 * 获取用户自定义数据
	 * @return
	 */
	public Object getUserData() {
		return objUserData;
	}

	/**
	 * 设置用户自定义数据
	 * @param objUserData
	 */
	public void setUserData(Object objUserData) {
		this.objUserData = objUserData;
	}

	
}
