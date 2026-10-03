package net.ibizsys.pswf.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.ctrlhandler.ListHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;

/**
 * 流程操作者列表后台处理对象
 * 
 * @author Administrator
 *
 */
public abstract class WFStepActorListHandlerBase extends ListHandlerBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#onFillDEDataSetFetchContext(net.ibizsys.paas.core.DEDataSetFetchContext)
	 */
	@Override
	protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		super.onFillDEDataSetFetchContext(deDataSetFetchContextImpl);

		String strParentDEId = WebContext.getParentDEId(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strParentDEId)) {
			throw new Exception("没有指定父实体标识");
		}

		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strParentDEId);
		IDEWF iDEWF = iDataEntityModel.getDefaultDEWF();
		if (iDEWF == null) {
			throw new Exception(StringHelper.format("实体[%1$s]不支持工作流", iDataEntityModel.getName()));
		}

		String strParentKey = WebContext.getParentKey(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strParentKey)) {
			deDataSetFetchContextImpl.setCancel(true);
			return;
		}

		deDataSetFetchContextImpl.setPageSize(9999);
		deDataSetFetchContextImpl.setSort("createdate");
		deDataSetFetchContextImpl.setSortDir("asc");

		IEntity activeUserData = iDataEntityModel.createEntity();
		activeUserData.set(iDataEntityModel.getKeyDEField().getName(), strParentKey);
		iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);

		StringBuilderEx script = new StringBuilderEx();

		String strWFInstFieldExp = iDEWF.getWFInstField();
		if (!StringHelper.isNullOrEmpty(strWFInstFieldExp)) {
			script.append(" INNER JOIN T_SRFWFINSTANCE wf1 ON ${srfdefieldexp('%1$s')} = wf1.WFINSTANCEID and wf1.ACTIVESTEPID = t1.WFSTEPID", strWFInstFieldExp);
			deDataSetFetchContextImpl.setJoinScript(script.toString());

			String strActiveWFInstId = DataObject.getStringValue(activeUserData, iDEWF.getWFInstField(), null);
			String strCondition = "";
			if (!StringHelper.isNullOrEmpty(strActiveWFInstId)) {
				WFInstanceService wfInstanceService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
				WFInstance wfInstance = new WFInstance();
				wfInstance.setWFInstanceId(strActiveWFInstId);
				wfInstanceService.get(wfInstance);

				strCondition = StringHelper.format("(wf1.USERDATA='%1$s' AND wf1.USERDATA4='%2$s' AND wf1.WFINSTANCEID= '%3$s') OR (wf1.USERDATA2='%1$s' AND wf1.PWFINSTANCEID= '%3$s') ", strParentKey, strParentDEId, strActiveWFInstId);

				// 获取实例当前步骤
				WFStepService wfStepService = (WFStepService) ServiceGlobal.getService(WFStepService.class, this.getSessionFactory());
				WFStep wfStep = new WFStep();
				wfStep.setWFStepId(wfInstance.getActiveStepId());
				wfStepService.get(wfStep);

				this.getWebContext().getCurAjaxActionResult().setExtAttr("activestep", DataObject.toJSONObject(wfStep, false));

			} else {
				strCondition = StringHelper.format("wf1.USERDATA='%1$s' AND wf1.USERDATA4='%2$s'", strParentKey, strParentDEId);
			}

			ArrayList<IDEDataSetCond> userConditionList = deDataSetFetchContextImpl.getConditionList();
			DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
			deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
			deDataSetCondImpl.setCustomCond(strCondition);
			userConditionList.add(deDataSetCondImpl);
		} else {

		}

	}
}
