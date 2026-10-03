package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.ModelBaseImpl;

/**
 * 流程连接条件模型对象基类
 * @author Administrator
 *
 */
public abstract class WFLinkCondModelBase extends ModelBaseImpl  implements IWFLinkCondModel
{
	private String strPId = "";

	/**
	 * 获取父条件标识
	 * @return the strPId
	 */
	@Override
	public String getPId()
	{
		return strPId;
	}

	/**
	 * 设置父条件标识
	 * @param strPId the strPId to set
	 */
	public void setPId(String strPId)
	{
		this.strPId = strPId;
	}
	

	/**
	 * 设置当前条件标识
	 * @param strId
	 */
	public void setId(String strId)
	{
		this.strId = strId;
	}
	
}
