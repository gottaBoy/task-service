package net.ibizsys.paas.core;

import net.ibizsys.paas.data.DataObject;

/**
 * 模型对象基础接口3实现
 * @author Administrator
 *
 */
public abstract class ModelBase3Impl extends ModelBase2Impl implements IModelBase3 {

	private DataObject dataObject = null;
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase3#getAttribute(java.lang.String)
	 */
	@Override
	public Object getAttribute(String strKey) throws Exception {
		if(dataObject == null)
			return null;
		return dataObject.get(strKey);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase3#getAttribute(java.lang.String, boolean)
	 */
	@Override
	public boolean getAttribute(String strKey, boolean bDefault) throws Exception {
		if(dataObject == null)
			return bDefault;
		return DataObject.getBoolValue(dataObject,strKey,bDefault);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase3#getAttribute(java.lang.String, java.lang.String)
	 */
	@Override
	public String getAttribute(String strKey, String strDefault) throws Exception {
		if(dataObject == null)
			return strDefault;
		return DataObject.getStringValue(dataObject,strKey,strDefault);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase3#getAttribute(java.lang.String, int)
	 */
	@Override
	public int getAttribute(String strKey, int nDefault) throws Exception {
		if(dataObject == null)
			return nDefault;
		return DataObject.getIntegerValue(dataObject,strKey,nDefault);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase3#getAttribute(java.lang.String, double)
	 */
	@Override
	public double getAttribute(String strKey, double fDefault) throws Exception {
		if(dataObject == null)
			return fDefault;
		return DataObject.getDoubleValue(dataObject,strKey,fDefault);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IModelBase3#setAttribute(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setAttribute(String strKey, Object objValue) throws Exception {
		if(dataObject==null){
			dataObject = new DataObject();
		}
		dataObject.set(strKey, objValue);
	}

	

}
