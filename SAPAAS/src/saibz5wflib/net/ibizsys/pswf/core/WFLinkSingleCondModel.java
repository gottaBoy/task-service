package net.ibizsys.pswf.core;

/**
 * 流程连接单项条件模型对象
 * @author Administrator
 *
 */
public class WFLinkSingleCondModel extends WFLinkCondModelBase implements IWFLinkSingleCondModel
{
	private String strFieldName = "";
	private String strCondOP = "";
	private String strParamType = null;
	private String strParamValue = null;
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkCondModel#getCondType()
	 */
	@Override
	public String getCondType()
	{
		return CONDTYPE_SINGLE;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkSingleCondModel#getFieldName()
	 */
	@Override
	public String getFieldName() throws Exception
	{
		return strFieldName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkSingleCondModel#getCondOP()
	 */
	@Override
	public String getCondOP()
	{
		return this.strCondOP;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkSingleCondModel#getParamType()
	 */
	@Override
	public String getParamType()
	{
		return this.strParamType;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkSingleCondModel#getParamValue()
	 */
	@Override
	public String getParamValue()
	{
		return this.strParamValue;
	}

	/**
	 * 设置判断属性名称
	 * @param strFieldName the strFieldName to set
	 */
	public void setFieldName(String strFieldName)
	{
		this.strFieldName = strFieldName;
	}

	/**
	 * 设置判断操作
	 * @param strCondOP the strCondOP to set
	 */
	public void setCondOP(String strCondOP)
	{
		this.strCondOP = strCondOP;
	}

	/**
	 * 设置参数类型
	 * @param strParamType the strParamType to set
	 */
	public void setParamType(String strParamType)
	{
		this.strParamType = strParamType;
	}

	/**
	 * 设置参数值
	 * @param strParamValue the strParamValue to set
	 */
	public void setParamValue(String strParamValue)
	{
		this.strParamValue = strParamValue;
	}
	

}
