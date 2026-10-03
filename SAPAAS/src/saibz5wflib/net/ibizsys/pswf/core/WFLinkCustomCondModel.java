package net.ibizsys.pswf.core;

/**
 * 流程连接自定义条件模型对象
 * @author Administrator
 *
 */
public class WFLinkCustomCondModel extends WFLinkCondModelBase implements IWFLinkCustomCondModel
{
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFLinkCondModel#getCondType()
	 */
	@Override
	public String getCondType()
	{
		return CONDTYPE_CUSTOM;
	}

}
