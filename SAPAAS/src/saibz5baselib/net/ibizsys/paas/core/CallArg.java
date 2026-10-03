package net.ibizsys.paas.core;

import net.ibizsys.paas.data.DataObject;

/**
 * 调用参数对象
 * 
 * @author lionlau
 *
 */
public class CallArg {
	private String strActionMode;
	private DataObject dataObject;

	/**
	 * 获取操作模式
	 * 
	 * @return the strActionMode
	 */
	public String getActionMode() {
		return strActionMode;
	}

	/**
	 * 设置操作模式
	 * 
	 * @param strActionMode the strActionMode to set
	 */
	public void setActionMode(String strActionMode) {
		this.strActionMode = strActionMode;
	}

	/**
	 * 获取数据对象
	 * 
	 * @return the dataObject
	 */
	public DataObject getDataObject() {
		return dataObject;
	}

	/**
	 * 设置数据对象
	 * 
	 * @param dataObject the dataObject to set
	 */
	public void setDataObject(DataObject dataObject) {
		this.dataObject = dataObject;
	}
}
