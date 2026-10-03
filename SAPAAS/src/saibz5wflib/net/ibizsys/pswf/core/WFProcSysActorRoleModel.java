package net.ibizsys.pswf.core;

import java.util.Iterator;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFUserService;



/**
 * 工作流处理角色（系统）
 * @author lionlau
 *
 */
public  class WFProcSysActorRoleModel extends WFProcRoleModelBase
{
	/**
	*上两个步骤操作者
	*/
	public final static String ROLETYPE_LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR" ;
	
	/**
	*上三个步骤操作者
	*/
	public final static String ROLETYPE_LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR" ;
	
	/**
	*上一步骤操作者
	*/
	public final static String ROLETYPE_LASTSTEPACTOR = "LASTSTEPACTOR" ;

	
	/**
	*当前操作者
	*/
	public final static String ROLETYPE_CURACTOR = "CURACTOR" ;
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFRoleUserModels(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception
	{
		if(StringHelper.compare(this.getWFProcRoleType(), ROLETYPE_CURACTOR, true)==0)
		{
			java.util.ArrayList<IWFRoleUser> wfRoleUserList = new java.util.ArrayList<IWFRoleUser>();
			String strWFUserId = iWFActionContext.getOpPersonId();
			if(StringHelper.isNullOrEmpty(strWFUserId))
				return null;
			
			WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class);
			WFUser wfUser = new WFUser();
			wfUser.setWFUserId(strWFUserId);
			wfUserService.get(wfUser);
			wfRoleUserList.add(WFRoleUser.fromWFUser(wfUser, null));
			return wfRoleUserList.iterator();
		}
		return null;
	}


}
