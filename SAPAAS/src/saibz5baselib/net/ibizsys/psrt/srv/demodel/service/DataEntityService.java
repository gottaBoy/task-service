package net.ibizsys.psrt.srv.demodel.service;


import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.common.entity.UserRoleDataAction;
import net.ibizsys.psrt.srv.common.service.UserRoleDataActionService;
import net.ibizsys.psrt.srv.common.service.UserRoleDataService;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


//@Service
//@Transactional
@Component

/**
 * 实体 服务操作对象
 * 
 */
public  class DataEntityService extends DataEntityServiceBase{

	protected static String[] readOnlyActions = new String[]{DataAccessActions.READ};
	protected static String[] readWriteActions = new String[]{DataAccessActions.READ,DataAccessActions.CREATE,DataAccessActions.UPDATE,DataAccessActions.DELETE,DataAccessActions.WFSTART};
	
	protected static int URD_ALL=0;
	protected static int URD_ORG=1;
	protected static int URD_SECTOR=2;
	protected static int URD_USER=3;
	
	protected static int UDR_DR_CUR=1;
	protected static int UDR_DR_SUP=2;
	protected static int UDR_DR_SUB=4;
	
	protected static int UDR_ACTION_READONLY=1;
	protected static int UDR_ACTION_READWRITE=2;
	
  private static final Log log = LogFactory.getLog(DataEntityService.class);
   public DataEntityService (){
        super();
        
   }
   
   @Override
	protected void onInitAll(DataEntity dataEntity) throws Exception
	{
		this.initUserRoleData(dataEntity);
	}
   
   
   @Override
	protected void onInitUserRoleData(DataEntity dataEntity) throws Exception
	{
	   if(!dataEntity.isFullEntity())
	   {
		   this.get(dataEntity);
	   }
	   //全部数据只读
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "ALL_R", "[%1$s]全部数据[只读]", URD_ALL, 0, UDR_ACTION_READONLY);
	   }
	   //全部数据读写
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "ALL_RW", "[%1$s]全部数据[读写]", URD_ALL, 0, UDR_ACTION_READWRITE);
	   }
	   //当前机构只读
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "CURORG_R", "[%1$s]当前机构[只读]", URD_ORG, UDR_DR_CUR, UDR_ACTION_READONLY);
	   }
	   //当前机构读写
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "CURORG_RW", "[%1$s]当前机构[读写]", URD_ORG, UDR_DR_CUR, UDR_ACTION_READWRITE);
	   }
	   //下级机构只读
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "SUBORG_R", "[%1$s]下级机构[只读]", URD_ORG, UDR_DR_SUB, UDR_ACTION_READONLY);
	   }
	   //下级机构读写
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "SUBORG_RW", "[%1$s]下级机构[读写]", URD_ORG, UDR_DR_SUB, UDR_ACTION_READWRITE);
	   }

	   //当前部门只读
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "CURSEC_R", "[%1$s]当前部门[只读]", URD_SECTOR, UDR_DR_CUR, UDR_ACTION_READONLY);
	   }
	   //当前部门读写
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "CURSEC_RW", "[%1$s]当前部门[读写]", URD_SECTOR, UDR_DR_CUR, UDR_ACTION_READWRITE);
	   }
	   //下级部门只读
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "SUBSEC_R", "[%1$s]下级部门[只读]", URD_SECTOR, UDR_DR_SUB, UDR_ACTION_READONLY);
	   }
	   //下级部门读写
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "SUBSEC_RW", "[%1$s]下级部门[读写]", URD_SECTOR, UDR_DR_SUB, UDR_ACTION_READWRITE);
	   }
	   
	   //当前用户读写
	   if(true)
	   {
		   this.addUserRoleData(dataEntity, "CURUSER_RW", "[%1$s]当前用户[读写]", URD_USER, UDR_DR_CUR, UDR_ACTION_READWRITE);
	   }
	}
   
    protected void addUserRoleData(DataEntity dataEntity,String strURDId,String strURDName,int nURD,int nURDDR,int nURDAction) throws Exception{
		// 初始化用户角色数据
		UserRoleDataService userRoleDataService = (UserRoleDataService) ServiceGlobal
				.getService(UserRoleDataService.class);
		UserRoleDataActionService userRoleDataActionService = (UserRoleDataActionService) ServiceGlobal
				.getService(UserRoleDataActionService.class);

		UserRoleData userRoleData = new UserRoleData();
		userRoleData.setDEId(dataEntity.getDEId());
		userRoleData.setUserRoleDataId(KeyValueHelper.genUniqueId(dataEntity.getDEId(), strURDId));
		if (userRoleDataService.checkKey(userRoleData) == IService.CHECKKEYSTATE_OK) {
			userRoleData.setUserRoleDataName(StringHelper.format(strURDName, dataEntity.getDELogicName()));
			if(nURD==URD_ALL){
				userRoleData.setIsAllData(1);
			}else if(nURD==URD_ORG){
				userRoleData.setOrgDR(nURDDR);
				userRoleData.setIsAllData(0);
			}else if(nURD==URD_SECTOR){
				userRoleData.setSecDR(nURDDR);
				userRoleData.setIsAllData(0);
			}else if(nURD==URD_USER){
				userRoleData.setUserDR(nURDDR);
				userRoleData.setIsAllData(0);
			}else{
				return;
			}
			
			userRoleData.setUDVersion(1);
			userRoleData.setDEName(dataEntity.getDEName());
			userRoleDataService.create(userRoleData, false);

			String[] actions=null;
			if(nURDAction==UDR_ACTION_READONLY){
				actions=readOnlyActions;
			}else if(nURDAction==UDR_ACTION_READWRITE){
				actions=readWriteActions;
			}else{
				return;
			}
			for (String strAction : actions) {
				UserRoleDataAction userRoleDataAction = new UserRoleDataAction();
				userRoleDataAction.setIsAllow(1);
				userRoleDataAction.setUserRoleDataId(userRoleData.getUserRoleDataId());
				userRoleDataAction.setUserRoleDataName(userRoleData.getUserRoleDataName());
				userRoleDataAction.setUserRoleDataActionName(strAction);
				userRoleDataActionService.create(userRoleDataAction, false);
			}
		}
    }

}