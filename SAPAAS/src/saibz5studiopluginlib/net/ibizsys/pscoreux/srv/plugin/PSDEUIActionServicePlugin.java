package net.ibizsys.pscoreux.srv.plugin;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;

public class PSDEUIActionServicePlugin extends ServicePluginBase {

	@Override
	public PluginActionResult doCustomAction(IService iService, String strActionName, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
		if(nActionPos == IPlugin.ACTIONPOS_ENTER) {
			if(StringHelper.compare(strActionName, PSDEUIActionService.ACTION_CREATEDEUAGROUP, true) == 0){
				//界面行为的Service
				PSDEUIActionService psDEUIActionService = (PSDEUIActionService) ServiceGlobal.getService(PSDEUIActionService.class, iService.getSessionFactory());
				//界面行为的实体
				PSDEUIAction psDEUIAction = new PSDEUIAction();
				iEntity.copyTo(psDEUIAction, true);
				
				if(psDEUIActionService.get(psDEUIAction, true)){
					//界面行为的ID
					String strPSDEUIActionId = psDEUIAction.getPSDEUIActionId();
					//实体的ID
					String strPSDEId = psDEUIAction.getPSDEId();
					//实体的名称
					String strPSDEName = psDEUIAction.getPSDEName();
					//界面行为的名称
					String strPSDEUIActionName = psDEUIAction.getPSDEUIActionName();
					//系统的ID
					String strPSSystemId = psDEUIAction.getPSSystemId();
					
					//界面行为组的实体
					PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
					//界面行为组的Service
					PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService) ServiceGlobal.getService(PSDEUAGroupService.class,  iService.getSessionFactory());
					//设置界面行为组所在实体的ID
					psDEUAGroup.setPSDEId(strPSDEId);
					//设置界面行为组所在实体的名称
					psDEUAGroup.setPSDEName(strPSDEName);
					//设置界面行为组的名称
					psDEUAGroup.setPSDEUAGroupName(strPSDEUIActionName);
					//设置系统的ID
					psDEUAGroup.setPSSystemId(strPSSystemId);
					//新建界面行为组
					psDEUAGroupService.create(psDEUAGroup);
					
					//界面行为组成员的实体
					PSDEUAGroupDetail psDEUAGroupDetail = new PSDEUAGroupDetail();
					//界面行为组的Service
					PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService) ServiceGlobal.getService(PSDEUAGroupDetailService.class, iService.getSessionFactory());
					//判断界面行为组是否保存成功
					boolean bPSDEUAGrop = psDEUAGroupService.get(psDEUAGroup, true);
					//界面行为组的ID
					String strPSDEUAGropId = psDEUAGroup.getPSDEUAGroupId();
					//设置界面行为组的ID
					psDEUAGroupDetail.setPSDEUAGroupId(strPSDEUAGropId);
					//设置界面行为的ID
					psDEUAGroupDetail.setPSDEUIActionId(strPSDEUIActionId);
					//新建界面行为组成员
					psDEUAGroupDetailService.create(psDEUAGroupDetail);
				}else {
					throw new Exception(StringHelper.format("界面行为[%1$s]未找到，无法创建默认行为组！", psDEUIAction.getPSDEUIActionId()));
				}
				
				return PluginActionResult.Replace;				
			}
		}
		return super.doCustomAction(iService, strActionName, nActionPos, iEntity, objParam);
	}
	
}
