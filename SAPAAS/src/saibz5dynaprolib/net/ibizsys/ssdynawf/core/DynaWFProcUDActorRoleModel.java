package net.ibizsys.ssdynawf.core;

import java.util.Iterator;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;
import net.ibizsys.pswf.core.WFProcUDActorRoleModel;
import net.ibizsys.pswf.core.WFRoleUser;

public class DynaWFProcUDActorRoleModel extends WFProcUDActorRoleModel {
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcRoleModel#getWFRoleUserModels(net.ibizsys.pswf.core.IWFActionContext)
	 */
	@Override
	public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext iWFActionContext) throws Exception
	{
		if(this.getUDFields()!=null)
		{
			WFUserService wfUserService = (WFUserService)ServiceGlobal.getService(WFUserService.class,((IDynaWFProcessModel) this.getWFInteractiveProcessModel()).getDynaWFVersionModel().getDynaWFModel().getDynaSysModel().getSessionFactory() );
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
