package net.ibizsys.ssdynawf.sysmodel;

import java.util.ArrayList;

import net.ibizsys.paas.appmodel.AppViewModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.ssdyna.core.IDynaDETemplModel;
import net.ibizsys.ssdyna.core.IDynaDEViewTemplModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.sswf.api.SaaSWFActionParam;
import net.ibizsys.sswf.entity.WFServiceEntity;
import net.ibizsys.sswf.entity.WFServiceEntityView;

/**
 * 动态系统工作流功能基类
 * @author Administrator
 *
 */
public abstract class DynaWFUtilBase extends net.ibizsys.sswf.sysmodel.util.SaaSWFUtilBase {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaWFUtilBase.class);
	public IDynaSysModel getDynaSysModel() {
		return (IDynaSysModel)getSystemModel();
	}
	
	
	@Override
	public ArrayList<WFServiceEntity> getWFServiceEntities() throws Exception {
		//查出动态系统全部动态实体模板
		ArrayList<WFServiceEntity> list = new ArrayList<WFServiceEntity>();
		java.util.Iterator<IDynaDETemplModel> dynaDETempls = this.getDynaSysModel().getDynaDETemplModels();
		if(dynaDETempls!=null) {
			while(dynaDETempls.hasNext()) {
				IDynaDETemplModel iDynaDETemplModel = dynaDETempls.next();
				
				IDataEntityModel tempDEModel = this.getDynaSysModel().getDataEntityModel(iDynaDETemplModel.getTemplDEId());
				if(!tempDEModel.hasDEWF()) {
					continue;
				}
				
				WFServiceEntity wfServiceEntity = new WFServiceEntity();
				wfServiceEntity.setWFServiceEntityId(iDynaDETemplModel.getId());
				wfServiceEntity.setWFServiceEntityName(iDynaDETemplModel.getName());
				
				java.util.Iterator<IDynaDEViewTemplModel> dynaDEViewTemplModes = iDynaDETemplModel.getDynaDEViewTemplModels();
				if(dynaDEViewTemplModes!=null) {
					while(dynaDEViewTemplModes.hasNext()) {
						IDynaDEViewTemplModel iDynaDEViewTemplModel = dynaDEViewTemplModes.next();
						WFServiceEntityView wfServiceEntityView = new WFServiceEntityView();
						wfServiceEntityView.setWFServiceEntityViewId(iDynaDEViewTemplModel.getId());
						wfServiceEntityView.setWFServiceEntityViewName(iDynaDEViewTemplModel.getName());
						java.util.Iterator<AppViewModel>  appViewModels = iDynaDEViewTemplModel.getAppDynaDEViews();
						if(appViewModels!=null) {
							while(appViewModels.hasNext()) {
								AppViewModel appViewModel = appViewModels.next();
								wfServiceEntityView.setAppId(appViewModel.getAppId());
								wfServiceEntityView.setAppViewId(appViewModel.getId());
								wfServiceEntityView.setAppViewUrl(appViewModel.getViewUrl());
								
								break;
							}
						}
						wfServiceEntity.getViews().add(wfServiceEntityView);
					}
				}
				
				list.add(wfServiceEntity);
			}
		}
		return list;
	}
	
	@Override
	protected IWFModel getWFModel(SaaSWFActionParam wfParam) throws Exception {
		
		return this.getDynaSysModel().getWFModel(wfParam.getWorkflowId());
	}
}
