package net.ibizsys.psrt.srv.common.service;


import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.OrgSecUser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


//@Service
//@Transactional
@Component

/**
 * 组织部门人员 服务操作对象
 * 
 */
public  class OrgSecUserService extends OrgSecUserServiceBase{

  private static final Log log = LogFactory.getLog(OrgSecUserService.class);
   public OrgSecUserService (){
        super();
        
   }

   @Override
	protected void onBeforeRemove(OrgSecUser et) throws Exception
	{
	   if(!et.isDefaultFlagDirty())
	   {
			OrgSecUser orgSecUser = getLast(et);
			if(DataObject.getBoolValue( orgSecUser.getDefaultFlag(),false))
			{
				throw new Exception(StringHelper.format("无法删除默认部门人员关系"));
			}
	   }
	   
	   if(DataObject.getBoolValue( et.getDefaultFlag(),false))
		{
			throw new Exception(StringHelper.format("无法删除默认部门人员关系"));
		}
	   	
		super.onBeforeRemove(et);
	}
   
   
   @Override
	protected void onRemoveDefault(OrgSecUser orgSecUser) throws Exception
	{
		super.onRemoveDefault(orgSecUser);
	}
}