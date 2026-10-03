package net.ibizsys.paas.sysmodel;

import java.util.HashMap;

import net.ibizsys.paas.core.ModelBase2Impl;
import net.ibizsys.paas.data.DataObject;

/**
 * 系统辅助功能组件基类
 * @author Administrator
 *
 */
public abstract class SystemUtilBase extends ModelBase2Impl implements ISystemUtil {

	private ISystemModel iSystemModel = null;
	private String strUtilType = null;
	private HashMap<String, Object> utilParamMap = new HashMap<String, Object>();
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.iSystemModel = iSystemModel;
		onInit();
	}
	
	protected void onInit()throws Exception{
		
	}

	protected void setId(String strId) {
		this.strId = strId;
	}
	
	
	protected void setName(String strName) {
		this.strName = strName;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemUtil#getUtilType()
	 */
	@Override
	public String getUtilType() {
		return this.strUtilType;
	}
	
	/**
	 * 设置辅助功能类型
	 * @param strUtilType
	 */
	public void setUtilType(String strUtilType){
		this.strUtilType = strUtilType;
	}
	
	@Override
	public ISystemModel getSystemModel() {
		return this.iSystemModel;
	}

	@Override
	public void setUtilParam(String strParamKey, Object objValue) {
		this.utilParamMap.put(strParamKey, objValue);
	}

	
	
	/**
	 * 获取功能参数（整数）
	 * @param strParam
	 * @param nDefault
	 * @return
	 */
	public int getUtilParam(String strParam, int nDefault)
	{
		try{
			return DataObject.getIntegerValue(this.utilParamMap.get(strParam), nDefault);
		}
		catch(Exception ex){
			return nDefault;
		}
	}

	/**
	 * 获取功能参数（字符串）
	 * @param strParam
	 * @param strDefault
	 * @return
	 */
	public String getUtilParam(String strParam, String strDefault)
	{
		try{
			return DataObject.getStringValue(this.utilParamMap.get(strParam), strDefault);
		}
		catch(Exception ex){
			return strDefault;
		}
	}

	/**
	 * 获取功能参数（浮点）
	 * @param strParam
	 * @param fDefault
	 * @return
	 */
	public double getUtilParam(String strParam, double fDefault)
	{
		try{
			return DataObject.getDoubleValue(this.utilParamMap.get(strParam));
		}
		catch(Exception ex){
			return fDefault;
		}
	}

	/**
	 * 获取功能参数（布尔值）
	 * @param strParam
	 * @param bDefault
	 * @return
	 */
	public boolean getUtilParam(String strParam, boolean bDefault)
	{
		try{
			return DataObject.getBoolValue(this.utilParamMap.get(strParam),bDefault);
		}
		catch(Exception ex){
			return bDefault;
		}
	}
	
	
	
}
