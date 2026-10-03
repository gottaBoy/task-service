package net.ibizsys.ssdynawf.core;

import java.util.Iterator;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.WFProcSysActorRoleModel;
import net.ibizsys.pswf.core.WFRoleUser;

public class DynaWFProcSysActorRoleModel extends WFProcSysActorRoleModel {

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
			
			WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class, ((IDynaWFProcessModel) this.getWFInteractiveProcessModel()).getDynaWFVersionModel().getDynaWFModel().getDynaSysModel().getSessionFactory() );
			WFUser wfUser = new WFUser();
			wfUser.setWFUserId(strWFUserId);
			wfUserService.get(wfUser);
			wfRoleUserList.add(WFRoleUser.fromWFUser(wfUser, null));
			return wfRoleUserList.iterator();
		}
		return null;
	}
	
}
