package net.ibizsys.pswf.core;

import java.util.Iterator;


/**
 * 工作流处理角色基类
 * @author lionlau
 *
 */
public  class WFProcRoleModel extends WFProcRoleModelBase
{

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFRoleUserModels(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception
	{
		if(this.getWFRoleModel()!=null)
			return this.getWFRoleModel().getWFRoleUserModels(iWFActionContext);
		return null;		
	}	
	

}
