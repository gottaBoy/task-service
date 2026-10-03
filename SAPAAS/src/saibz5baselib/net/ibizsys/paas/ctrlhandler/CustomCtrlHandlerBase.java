package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;

/**
 * 自定义部件处理对象
 * 
 * @author Administrator
 *
 */
public abstract class CustomCtrlHandlerBase extends CtrlHandlerBase implements ICustomCtrlHandler {

	private String strCustomTag = null;
	private String strCustomTag2 = null;
	private String strDEActionName = null;
	private String strDEDataSetName = null;
	private String strDEName = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICustomCtrlHandler#getCustomTag()
	 */
	@Override
	public String getCustomTag() {
		return this.strCustomTag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICustomCtrlHandler#getCustomTag2()
	 */
	@Override
	public String getCustomTag2() {
		return this.strCustomTag2;
	}

	/**
	 * 设置自定义标记
	 * 
	 * @param strCustomTag
	 */
	protected void setCustomTag(String strCustomTag) {
		this.strCustomTag = strCustomTag;
	}

	/**
	 * 设置自定义标记2
	 * 
	 * @param strCustomTag2
	 */
	protected void setCustomTag2(String strCustomTag2) {
		this.strCustomTag2 = strCustomTag2;
	}

	@Override
	public ICtrlModel getCtrlModel() {
		return null;
	}

	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	public String getDEName() {
		return strDEName;
	}

	/**
	 * 设置实体名称
	 * 
	 * @param strDEName
	 */
	protected void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/**
	 * 获取实体行为名称
	 * 
	 * @return
	 */
	public String getDEActionName() {
		return strDEActionName;
	}

	/**
	 * 设置实体行为名称
	 * 
	 * @param strDEActionName
	 */
	protected void setDEActionName(String strDEActionName) {
		this.strDEActionName = strDEActionName;
	}

	/**
	 * 获取实体数据集合名称
	 * 
	 * @return
	 */
	public String getDEDataSetName() {
		return strDEDataSetName;
	}

	/**
	 * 设置实体体数据集合名称
	 * 
	 * @param strDEDataSetName
	 */
	protected void setDEDataSetName(String strDEDataSetName) {
		this.strDEDataSetName = strDEDataSetName;
	}

}
