package net.ibizsys.paas.core;

/**
 * 模型对象基础接口2实现
 * @author Administrator
 *
 */
public abstract class ModelBase2Impl extends ModelBaseImpl implements IModelBase2 {

	private String strUserTag = null; 
	private String strUserTag2 = null; 
	
	/**
	 * 设置用户标记
	 * @param strUserTag
	 */
	public void setUserTag(String strUserTag){
		this.strUserTag = strUserTag;
	}
	
	
	/**
	 * 设置用户标记2
	 * @param strUserTag2
	 */
	public void setUserTag2(String strUserTag2){
		this.strUserTag2 = strUserTag2;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase2#getUserTag()
	 */
	@Override
	public String getUserTag() {
		return this.strUserTag;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase2#getUserTag2()
	 */
	@Override
	public String getUserTag2() {
		return this.strUserTag2;
	}

}
