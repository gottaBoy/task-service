package net.ibizsys.pswf.core;

import java.util.Iterator;

/**
 * 流程自定义角色模型
 * @author lionlau
 *
 */
public abstract class WFCustomRoleModelBase extends WFRoleModelBase
{
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRoleModel#getWFRoleType()
	 */
	@Override
	public String getWFRoleType()
	{
		return IWFRoleModel.WFROLETYPE_CUSTOM;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRoleModel#getWFRoleUserModels(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception
	{
		throw new Exception("没有实现自定义获取流程用户");
	}
}
