package net.ibizsys.pswf.core;

/**
 * 流程实体操作处理参数模型对象
 * @author lionlau
 *
 */
public class WFDEActionProcessParamModel implements IWFDEActionProcessParamModel
{
	private String strDstField = "";
	private String strSrcValue = "";
	private String strSrcValueType = "";

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEActionProcessParamModel#getDstField()
	 */
	@Override
	public String getDstField() throws Exception
	{
		return this.strDstField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEActionProcessParamModel#getSrcValue()
	 */
	@Override
	public String getSrcValue()
	{
		return this.strSrcValue;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEActionProcessParamModel#getDirectCode()
	 */
	@Override
	public String getDirectCode()
	{
		return null;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFDEActionProcessParamModel#getSrcValueType()
	 */
	@Override
	public String getSrcValueType()
	{
		return this.strSrcValueType;
	}

	/**
	 * 设置目标属性
	 * @param strDstField the strDstField to set
	 */
	public void setDstField(String strDstField)
	{
		this.strDstField = strDstField;
	}

	/**
	 * 设置源值
	 * @param strSrcValue the strSrcValue to set
	 */
	public void setSrcValue(String strSrcValue)
	{
		this.strSrcValue = strSrcValue;
	}

	/**
	 * 设置源值类型
	 * @param strSrcValueType the strSrcValueType to set
	 */
	public void setSrcValueType(String strSrcValueType)
	{
		this.strSrcValueType = strSrcValueType;
	}
}
