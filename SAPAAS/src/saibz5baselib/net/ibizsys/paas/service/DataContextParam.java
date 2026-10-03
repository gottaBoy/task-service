package net.ibizsys.paas.service;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 数据上下文参数
 * 
 * @author Administrator
 *
 */
public class DataContextParam implements IDataContextParam {
	private String strDEName = "";
	private String strDEFName = "";
	// 引用项
	private String strReferItem = "";
	private boolean bIgnoreEmpty = false;

	/**
	 * 构造函数
	 * 
	 * @param strParam
	 * @throws Exception
	 */
	public DataContextParam(String strParam) throws Exception {
		if (strParam != null) {
			JSONObject json = JSONObjectHelper.fromString(strParam);
			strDEName = json.optString("dename", "");
			strDEFName = json.optString("defname", "");
			bIgnoreEmpty = json.optBoolean("ignoreempty", bIgnoreEmpty);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.IDataContextParam#getDEName()
	 */
	@Override
	public String getDEName() {
		return this.strDEName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.IDataContextParam#getDEFName()
	 */
	@Override
	public String getDEFName() {
		return this.strDEFName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.IDataContextParam#getReferItem()
	 */
	@Override
	public String getReferItem() {
		return strReferItem;
	}

	/**
	 * 设置引用项
	 * 
	 * @param strReferItem the strReferItem to set
	 */
	public void setReferItem(String strReferItem) {
		this.strReferItem = strReferItem;
	}

	/**
	 * 设置实体模型名称
	 * 
	 * @param strDEName the strDEName to set
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/**
	 * 设置实体属性名称
	 * 
	 * @param strDEFName the strDEFName to set
	 */
	public void setDEFName(String strDEFName) {
		this.strDEFName = strDEFName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.IDataContextParam#isIgnoreEmpty()
	 */
	@Override
	public boolean isIgnoreEmpty() {
		return this.bIgnoreEmpty;
	}

	/**
	 * 设置是否忽略空值条件
	 * 
	 * @param bIgnoreEmpty
	 */
	public void setIgnoreEmpty(boolean bIgnoreEmpty) {
		this.bIgnoreEmpty = bIgnoreEmpty;
	}
}
