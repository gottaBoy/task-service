package net.ibizsys.pswf.core;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroup;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroupDetail;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService;

/**
 * 流程用户组角色模型对象
 * @author lionlau
 *
 */
public abstract class WFUserGroupRoleModelBase extends WFRoleModelBase
{
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRoleModel#getWFRoleType()
	 */
	@Override
	public String getWFRoleType()
	{
		return IWFRoleModel.WFROLETYPE_USERGROUP;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFRoleModel#getWFRoleUserModels(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception
	{
		WFUserGroup wfUserGroup = new WFUserGroup();
		wfUserGroup.setWFUserGroupId(this.getId());
		
		WFUserGroupDetailService wfUserGroupDetailService = (WFUserGroupDetailService)ServiceGlobal.getService(WFUserGroupDetailService.class);
		ArrayList<WFUserGroupDetail> wfUserGroupDetailList = wfUserGroupDetailService.selectByWFUserGroup(wfUserGroup);
		
		java.util.ArrayList<IWFRoleUser> wfRoleUserList = new java.util.ArrayList<IWFRoleUser>();
		for(WFUserGroupDetail wfUserGroupDetail:wfUserGroupDetailList)
		{
			wfRoleUserList.add(WFRoleUser.fromWFUserGroupDetail(wfUserGroupDetail, this));
		}
		return wfRoleUserList.iterator();
	}
}
