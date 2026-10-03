/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFUIWizard;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;


//@Component
/**
 * 工作流界面向导跳转步骤操作用户代码表模型
 */
public class WFGotoStepActorCodeListModel extends WFGotoStepActorCodeListModelBase {


   public WFGotoStepActorCodeListModel(){
        super();
   }
 
  
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#queryCodeItems(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.data.IDataObject)
	 */
	@Override
	public Iterator<ICodeItem> queryCodeItems(IWebContext iWebContext, IDataObject iDataObject) throws Exception
	{
		String strActionParam = DataObject.getStringValue(iDataObject, WFUIWizard.FIELD_ACTIONPARAM, "");
		if (StringHelper.isNullOrEmpty(strActionParam))
		{
			return this.getCodeItems();
		}

		String[] keys = strActionParam.split("[;]");
		

		WFInstanceService wfInstanceService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
		WFStepActorService wfStepActorService = (WFStepActorService) ServiceGlobal.getService(WFStepActorService.class, this.getSessionFactory());
		
		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(keys[0]);
		wfInstanceService.get(wfInstance);
		
		SelectCond selectCond = new SelectCond();
		selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
		ArrayList<WFStepActor> wfStepActorList = wfStepActorService.select(selectCond);
		
//		selectCond.reset();
//		selectCond.set("WFSTEPID", wfInstance.getActiveStepId());
//		selectCond.set("ACTORID", stepData.getActorId());
//		ArrayList<WFStepData> wfStepDataList = wfStepDataService.select(selectCond);
//		for (WFStepData wfStepData : wfStepDataList)
//		{
//			if (StringHelper.compare(wfStepData.getConnectionName(), "SRFWFRESUBMIT", true) != 0)
//			{
//				throw new Exception("用户已经完成了当前步骤的操作，无法再次完成");
//			}
//		}
		
		ArrayList<ICodeItem> codeItemList = new ArrayList<ICodeItem>();
		for(WFStepActor wfStepActor :wfStepActorList){
			CodeItemModel iCodeItemModel = new CodeItemModel();
			iCodeItemModel.setValue(wfStepActor.getActorId());
			iCodeItemModel.setText(wfStepActor.getWFStepActorName());
			codeItemList.add(iCodeItemModel);
		}
		
		return codeItemList.iterator();
	}
}