package net.ibizsys.pswf.core;

import java.util.Iterator;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFUserService;



/**
 * 工作流处理角色（当前数据上下文）
 * @author lionlau
 *
 */
public  class WFProcUDActorRoleModel extends WFProcRoleModelBase
{
	private String strUDField = "";
	private String[] udFields = null;
	
	/**
	 * 设置上下文属性
	 * @param strUDField
	 */
	public void setUDField(String strUDField)
	{
		this.strUDField = strUDField;
		if(!StringHelper.isNullOrEmpty(strUDField))
		{
			udFields = StringHelper.splitEx(this.strUDField);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getUDFields()
	 */
	@Override
	public String[] getUDFields()
	{
		return udFields;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFRoleUserModels(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception
	{
		if(this.getUDFields()!=null)
		{
			WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class);
			java.util.ArrayList<IWFRoleUser> wfRoleUserList = new java.util.ArrayList<IWFRoleUser>();
			for(String strUDField:this.getUDFields())
			{
				String strWFUserId = (String)iWFActionContext.getActiveEntity().get(strUDField);
				if(StringHelper.isNullOrEmpty(strWFUserId))
					continue;
				WFUser wfUser = new WFUser();
				wfUser.setWFUserId(strWFUserId);
				wfUserService.get(wfUser);
				wfRoleUserList.add(WFRoleUser.fromWFUser(wfUser, null));
			}
			return wfRoleUserList.iterator();
		}
		return null;
	}	

}
