package net.ibizsys.psrt.srv.codelist;

import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFUIWizard;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;

//@Component
/**
 * 工作流界面向导跳转步骤代码表模型
 */
public class WFGotoStepCodeListModel extends WFGotoStepCodeListModelBase
{

	public WFGotoStepCodeListModel()
	{
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.codelist.IDynamicCodeList#realTimeQueryCodeItems(net
	 * .ibizsys.paas.web.IWebContext, net.ibizsys.paas.entity.IEntity)
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
		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(keys[0]);
		wfInstanceService.get(wfInstance);

		// 找到对应的实体
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(wfInstance.getUserData4());
		IDEWFModel iDEWFModel = (IDEWFModel) iDataEntityModel.getDEWF(wfInstance.getWFWorkflowId());
		
		ICodeListModel iCodeListModel = (ICodeListModel)iDEWFModel.getWFModel().getWFStepCodeList();
		return iCodeListModel.getCodeItems();
	}

}