package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IView;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService;

/**
 * 动态实体工作流模型基类
 * 
 * @author lionlau
 *
 */
public abstract class DynaDEWFModelBase extends DEWFModelBase {

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEWF#getWFEditViewPDTParam(net.ibizsys.paas.entity.IEntity, boolean, int)
	 */
	@Override
	public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode, int nAppType) throws Exception {
		// 判断数据是否在流程中
		boolean bWorkFlow = this.testDataInWF(iEntity);
		if (bWorkFlow) {
			boolean bMultiForm = getDEModel().isEnableMultiForm();
			Object multiFormValue = null;
			if (bMultiForm) {
				multiFormValue = iEntity.get(getDEModel().getMultiFormDEField().getName());
				if (multiFormValue == null) {
					throw new Exception(StringHelper.format("无法获取多表单识别数据"));
				}
			}
			Object wfStepValue = iEntity.get(this.getWFStepField());
			int nVer = 1;
			if (!StringHelper.isNullOrEmpty(this.getWFVerField())) {
				nVer = DataObject.getIntegerValue(iEntity, this.getWFVerField(), nVer);
			}
			
			String strPredefinedType = null;
			
			if(nAppType == IApplication.APPTYPE_MOBILE){
				if (multiFormValue == null) {
					if (bWorkMode) {
						strPredefinedType = IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW + ":" + StringHelper.format("%1$s:%3$sW:%2$s", this.getName(), wfStepValue, ((nVer == 1) ? "" : nVer));
					} else {
						strPredefinedType = IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW + ":" + StringHelper.format("%1$s:D", this.getName());
					}
				} else {
					if (bWorkMode) {
						strPredefinedType = IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW + ":" + StringHelper.format("%3$s:%1$s:%4$sW:%2$s", this.getName(), wfStepValue, multiFormValue, ((nVer == 1) ? "" : nVer));
					} else {
						strPredefinedType = IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW + ":" + StringHelper.format("%2$s:%1$s:D", this.getName(), multiFormValue);
					}
				}
			}
			else{
				if (multiFormValue == null) {
					if (bWorkMode) {
						strPredefinedType = IView.PREDEFINEDVIEWTYPE_WFEDITVIEW + ":" + StringHelper.format("%1$s:%3$sW:%2$s", this.getName(), wfStepValue, ((nVer == 1) ? "" : nVer));
					} else {
						strPredefinedType = IView.PREDEFINEDVIEWTYPE_WFEDITVIEW + ":" + StringHelper.format("%1$s:D", this.getName());
					}
				} else {
					if (bWorkMode) {
						strPredefinedType = IView.PREDEFINEDVIEWTYPE_WFEDITVIEW + ":" + StringHelper.format("%3$s:%1$s:%4$sW:%2$s", this.getName(), wfStepValue, multiFormValue, ((nVer == 1) ? "" : nVer));
					} else {
						strPredefinedType = IView.PREDEFINEDVIEWTYPE_WFEDITVIEW + ":" + StringHelper.format("%2$s:%1$s:D", this.getName(), multiFormValue);
					}
				}
			}
			if (bWorkMode){
				if(!StringHelper.isNullOrEmpty(strPredefinedType) && getDEModel()!=null && WebContext.getCurrent()!=null && !StringHelper.isNullOrEmpty(WebContext.getDynaSysInstId())){
					String strDEViewId = getDEModel().getDEViewIdByPDT(strPredefinedType, true);
					if(StringHelper.isNullOrEmpty(strDEViewId)){
						//没有找到对应的实体视图，判断是否为动态流程视图
						if(this.getDEModel().getSystemModel().getDynaSystemSetting()!=null){
							//获取对应的动态视图实例
							DSDynaViewInstService psDynaViewInstService = (DSDynaViewInstService)ServiceGlobal.getService(DSDynaViewInstService.class);
							DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
							dsDynaViewInst.setDynaSysInstId(WebContext.getDynaSysInstId());
							dsDynaViewInst.setDEWFId(this.getId());
							if(nVer == 1){
								dsDynaViewInst.setPDVTParam(StringHelper.format("%1$s", wfStepValue));
							}
							else{
								dsDynaViewInst.setPDVTParam(StringHelper.format("%1$s@%2$s", wfStepValue,nVer));
							}
							if(nAppType == IApplication.APPTYPE_MOBILE){
								dsDynaViewInst.setPredefinedViewType(IView.PREDEFINEDVIEWTYPE_MOBWFEDITVIEW);
							}
							else{
								dsDynaViewInst.setPredefinedViewType(IView.PREDEFINEDVIEWTYPE_WFEDITVIEW);
							}
							if(psDynaViewInstService.select(dsDynaViewInst,true)){
								if(dsDynaViewInst.getDSDynaView()!=null){
									if(!StringHelper.isNullOrEmpty(dsDynaViewInst.getDSDynaView().getPredefinedViewType())){
										if(!StringHelper.isNullOrEmpty(dsDynaViewInst.getDSDynaView().getPDVTParam())){
											return StringHelper.format("%1$s:%2$s",dsDynaViewInst.getDSDynaView().getPredefinedViewType(),
													dsDynaViewInst.getDSDynaView().getPDVTParam());
										}
										else{
											return dsDynaViewInst.getDSDynaView().getPredefinedViewType();
										}
									}
								}
							}
						}
					}
				}
			}
			
			
			return strPredefinedType;
		}

		return null;
	}
	
}
