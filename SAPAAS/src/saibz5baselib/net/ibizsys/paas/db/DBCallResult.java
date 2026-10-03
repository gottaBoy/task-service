package net.ibizsys.paas.db;

import java.util.HashMap;

import net.ibizsys.paas.core.CallResult;

/**
 * 数据库调用结果
 * 
 * @author Administrator
 *
 */
public class DBCallResult extends CallResult {
	protected HashMap<String, Object> outputMap = null;
	protected IDataSet iDataSet = null;
	private int nUpdateCount = -1;

	/**
	 * 获取结果集合对象
	 * 
	 * @return
	 */
	public IDataSet getDataSet() {
		return iDataSet;
	}

	/**
	 * 设置结果集合对象
	 * 
	 * @param iDataSet
	 */
	public void setDataSet(IDataSet iDataSet) {
		this.iDataSet = iDataSet;
	}

	/**
	 * 获取返回值Map
	 * 
	 * @param bCreate 无值时是否建立
	 * @return
	 */
	public HashMap<String, Object> getOutputValues(boolean bCreate) {
		if (outputMap == null && bCreate) {
			outputMap = new HashMap<String, Object>();
		}
		return outputMap;
	}

	/**
	 * 从DB结果建立
	 * 
	 * @param result
	 */
	public void from(DBCallResult result) {
		HashMap<String, Object> paramMap = result.getOutputValues(false);
		if (paramMap != null) {
			HashMap<String, Object> curMap = getOutputValues(true);
			curMap.putAll(paramMap);
		}

		this.setDataSet(result.getDataSet());
		super.from(result);
	}
	
	
	/**
	 * 设置更新的数量
	 * @param nUpdateCount
	 */
	public void setUpdateCount(int nUpdateCount){
		this.nUpdateCount = nUpdateCount;
	}
	
	
	/**
	 * 获取更新的数量
	 * @return
	 */
	public int getUpdateCount(){
		return this.nUpdateCount;
	}

}
