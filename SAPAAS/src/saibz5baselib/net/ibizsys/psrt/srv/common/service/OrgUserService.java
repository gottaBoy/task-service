package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.OrgSecUser;
import net.ibizsys.psrt.srv.common.entity.OrgUser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

//@Service
//@Transactional
@Component
/**
 * 组织人员 服务操作对象
 * 
 */
public class OrgUserService extends OrgUserServiceBase
{

	private static final Log log = LogFactory.getLog(OrgUserService.class);

	public OrgUserService()
	{
		super();

	}


	@Override
	protected void onAfterCreate(OrgUser et) throws Exception
	{
		createDefaultOrgSecUser(et);
		super.onAfterCreate(et);
	}
	
	
	@Override
	protected void onAfterUpdate(OrgUser et) throws Exception
	{
		createDefaultOrgSecUser(et);
		super.onAfterUpdate(et);
	}

	protected void createDefaultOrgSecUser(OrgUser et)throws Exception
	{
		OrgSecUser orgSecUser = new OrgSecUser();
		OrgSecUserService orgSecUserService = (OrgSecUserService)ServiceGlobal.getService(OrgSecUserService.class,this.getSessionFactory());
		OrgUser lastEt = getLast(et);
		if(lastEt!=null)
		{
			//判断是否一致
			if(StringHelper.compare(lastEt.getOrgSectorId(), et.getOrgSectorId(), true)!=0)
			{
				//移除历史
				String strKey = KeyValueHelper.genUniqueId(lastEt.getOrgSectorId(),et.getOrgUserId());
				orgSecUser.setOrgSecUserId(strKey);
				orgSecUser.setDefaultFlag(0);
				orgSecUserService.remove(orgSecUser);
			}
		}
		
		et.copyTo(orgSecUser, true);
		if(orgSecUserService.checkKey(orgSecUser) == IService.CHECKKEYSTATE_EXIST)
		{
			orgSecUser.setOrgSecUserName(et.getOrgUserName());
			orgSecUser.setDefaultFlag(1);
			orgSecUserService.update(orgSecUser);
		}
		else
		{
			orgSecUser.setOrgSecUserName(et.getOrgUserName());
			orgSecUser.setDefaultFlag(1);
			orgSecUserService.create(orgSecUser);
		}
	
	}
	
	
	protected void removeDefaultOrgSecUser(OrgUser et)throws Exception
	{
		OrgUser lastEt = getLast(et);
		
		OrgSecUser orgSecUser = new OrgSecUser();
		OrgSecUserService orgSecUserService = (OrgSecUserService)ServiceGlobal.getService(OrgSecUserService.class,this.getSessionFactory());
		String strKey = KeyValueHelper.genUniqueId(lastEt.getOrgSectorId(),et.getOrgUserId());
		orgSecUser.setOrgSecUserId(strKey);
		orgSecUser.setDefaultFlag(0);
		orgSecUserService.remove(orgSecUser);
	}
	
	
	@Override
	protected boolean isPrepareLastForUpdate()
	{
		return true;
	}
	
	@Override
	protected void onBeforeRemove(OrgUser et) throws Exception
	{
		removeDefaultOrgSecUser(et);
		super.onBeforeRemove(et);
	}
}