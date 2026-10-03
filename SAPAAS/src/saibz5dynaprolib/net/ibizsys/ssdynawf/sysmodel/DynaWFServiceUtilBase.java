package net.ibizsys.ssdynawf.sysmodel;

import java.util.ArrayList;

import net.ibizsys.paas.appmodel.AppViewModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.ssdyna.core.IDynaDEFormTemplModel;
import net.ibizsys.ssdyna.core.IDynaDETemplModel;
import net.ibizsys.ssdyna.core.IDynaDEViewTemplModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.sswf.entity.WFServiceEntity;
import net.ibizsys.sswf.entity.WFServiceEntityForm;
import net.ibizsys.sswf.entity.WFServiceEntityView;

/**
 * 动态系统工作流功能基类（对外）
 * @author Administrator
 *
 */
public abstract class DynaWFServiceUtilBase extends net.ibizsys.sswf.sysmodel.util.SaaSWFServiceUtilBase {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaWFServiceUtilBase.class);
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
				
				java.util.Iterator<IDynaDEFormTemplModel> dynaDEFormTemplModes = iDynaDETemplModel.getDynaDEFormTemplModels() ;
				if(dynaDEFormTemplModes!=null) {
					while(dynaDEFormTemplModes.hasNext()) {
						IDynaDEFormTemplModel iDynaDEFormTemplModel = dynaDEFormTemplModes.next();
						WFServiceEntityForm wfServiceEntityForm = new WFServiceEntityForm();
						wfServiceEntityForm.setWFServiceEntityFormId(iDynaDEFormTemplModel.getId());
						wfServiceEntityForm.setWFServiceEntityFormName(iDynaDEFormTemplModel.getName());
						wfServiceEntityForm.setFormId(iDynaDEFormTemplModel.getDEFormId());
						wfServiceEntity.getForms().add(wfServiceEntityForm);
					}
				}				
				
				list.add(wfServiceEntity);
			}
		}
		return list;
	}
	
	
}
