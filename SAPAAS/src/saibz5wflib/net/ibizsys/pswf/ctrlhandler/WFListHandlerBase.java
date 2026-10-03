package net.ibizsys.pswf.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.ctrlhandler.ListHandlerBase;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.controller.IWFViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFActionParam;

/**
 * 流程列表处理对象
 * 
 * @author lionlau
 *
 */
public abstract class WFListHandlerBase extends ListHandlerBase {
	/**
	 * 获取实体工作流模型
	 * 
	 * @return
	 */
	protected IDEWF getDEWF() {
		if (this.getViewController() instanceof IWFDEViewController) {
			return ((IWFDEViewController) this.getViewController()).getDEWF();
		}

		return null;
	}

	/**
	 * 是否为流程交互模式
	 * 
	 * @return
	 */
	protected boolean isWFIAMode() {
		if (this.getViewController() instanceof IWFViewController) {
			return ((IWFViewController) this.getViewController()).isWFIAMode();
		}

		return false;
	}

	/**
	 * 获取当前的流程步骤值
	 * 
	 * @return
	 */
	protected String getWFStepValue() {
		if (this.getViewController() instanceof IWFViewController) {
			return ((IWFViewController) this.getViewController()).getWFStepValue();
		}
		return "";
	}

	/**
	 * 获取流程模型
	 * 
	 * @return the iWFModel
	 */
	protected IWFModel getWFModel() {
		if (this.getViewController() instanceof IWFViewController) {
			return ((IWFViewController) this.getViewController()).getWFModel();
		}
		return null;
	}

	/**
	 * 获取流程版本模型对象
	 * 
	 * @return
	 */
	protected IWFVersionModel getWFVersionModel() {
		return this.getWFModel().getLastWFVersionModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#onFillDEDataSetFetchContext(net.ibizsys.paas.core.DEDataSetFetchContext)
	 */
	@Override
	protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		super.onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
		if (this.isWFIAMode()) {
			// //是否为流程交互模式
			// String strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId(getWebContext());
			// String strWFInstDEFId = "";
			// if(StringHelper.IsNullOrEmpty(strDESubWFId))
			// {
			// DEWF dewf = this.getPage().getDEHelper().GetDEWF();
			// strWFInstDEFId = dewf.getWFINSTDEFID();
			// }
			// else
			// {
			// DESubWF deSubWF = this.getPage().getDEHelper().GetDESubWF(strDESubWFId);
			// if(deSubWF == null)
			// {
			// this.getPage().PageLog(this,LogLevels.ERROR,StringHelper.Format("无法获取实体子流程[%1$s]",strDESubWFId));
			// return "";
			// }
			//
			// strWFInstDEFId = deSubWF.getWFINSTDEFID();
			// }
			//
			// //附加权限代码
			// IDEFHelper wfInstDEFHelper = this.getPage().getDEHelper().GetDEFHelper(strWFInstDEFId);
			// if(wfInstDEFHelper == null)
			// {
			// this.getPage().PageLog(this,LogLevels.ERROR, StringHelper.Format("获取实体属性[%1$s]失败",strWFInstDEFId));
			// return "";
			// }
			//
			// CallResult callResult = daQueryModelHelper.GetDEFieldExp(wfInstDEFHelper);
			// if(callResult.getRetCode()!=Errors.OK)
			// {
			// this.getPage().PageLog(this,LogLevels.ERROR, StringHelper.Format("获取实体属性[%1$s]查询表达式失败，%2$s",strWFInstDEFId,callResult.getErrorInfo()));
			// return "";
			// }
			// String strWFInstFieldExp = (String)callResult.getUserObject();
			//
			// StringBuilderEx script = new StringBuilderEx();
			// script.Append(strSql);
			//
			// if(StringHelper.IsNullOrEmpty(this.getDEHelper().GetDBStorage()))
			// {
			// script.Append(" INNER JOIN T_SRFWFINSTANCE wf1 ON %1$s = wf1.WFINSTANCEID ",strWFInstFieldExp);
			// script.Append(" INNER JOIN T_SRFWFSTEPACTOR wf2 ON wf1.ACTIVESTEPID = wf2.WFSTEPID ");
			// script.Append(" LEFT JOIN T_SRFWFSTEPDATA wf3 ON wf2.WFSTEPID = wf3.WFSTEPID AND wf2.ACTORID=wf3.ACTORID AND wf3.CONNECTIONNAME<>'SRFWFRESUBMIT' AND wf3.CONNECTIONNAME<>'SRFWFTIMEOUT'",strWFInstFieldExp);
			//
			// }
			// else
			// {
			// IDEHelper wfDEHelper = this.getPage().getDAModelStorage().FindDEHelper(SRFDAGlobal.DEID_WFINSTANCE);
			//
			// script.Append(" INNER JOIN %2$s.T_SRFWFINSTANCE wf1 ON %1$s = wf1.WFINSTANCEID ",strWFInstFieldExp,wfDEHelper.GetDBSchema());
			// script.Append(" INNER JOIN %1$s.T_SRFWFSTEPACTOR wf2 ON wf1.ACTIVESTEPID = wf2.WFSTEPID ",wfDEHelper.GetDBSchema());
			// script.Append(" LEFT JOIN %2$s.T_SRFWFSTEPDATA wf3 ON wf2.WFSTEPID = wf3.WFSTEPID AND wf2.ACTORID=wf3.ACTORID AND wf3.CONNECTIONNAME<>'SRFWFRESUBMIT' AND wf3.CONNECTIONNAME<>'SRFWFTIMEOUT'",strWFInstFieldExp,wfDEHelper.GetDBSchema());
			//
			// }
			//
			//
			// return script.toString();

			String strWFInstFieldExp = this.getDEWF().getWFInstField();
			if (!StringHelper.isNullOrEmpty(strWFInstFieldExp)) {
				StringBuilderEx script = new StringBuilderEx();
				script.append(" INNER JOIN T_SRFWFINSTANCE wf1 ON ${srfdefieldexp('%1$s')} = wf1.WFINSTANCEID ", strWFInstFieldExp);
				script.append(" INNER JOIN T_SRFWFSTEPACTOR wf2 ON wf1.ACTIVESTEPID = wf2.WFSTEPID ");
				script.append(" LEFT JOIN T_SRFWFSTEPDATA wf3 ON wf2.WFSTEPID = wf3.WFSTEPID AND wf2.ACTORID=wf3.ACTORID AND wf3.CONNECTIONNAME<>'SRFWFRESUBMIT' AND wf3.CONNECTIONNAME<>'SRFWFTIMEOUT'", strWFInstFieldExp);
				deDataSetFetchContextImpl.setJoinScript(script.toString());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#onFillFetchURLConditions(java.util.ArrayList)
	 */
	@Override
	protected void onFillFetchURLConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
		super.onFillFetchURLConditions(userConditions);
		onFillFetchWFConditions(userConditions);
	}

	/**
	 * 填充流程预置条件
	 * 
	 * @param userConditions
	 * @throws Exception
	 */
	protected void onFillFetchWFConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
		
		
		
		String strWFStepValue = WebContext.getWFStep(this.getWebContext());
		if (this.isWFIAMode() && !StringHelper.isNullOrEmpty(getWFStepValue())) {
			strWFStepValue = getWFStepValue();
		}
		
		if (!StringHelper.isNullOrEmpty(strWFStepValue) && !StringHelper.isNullOrEmpty(this.getDEWF().getWFStepField())) {
			IDEField iDEFieldModel = this.getDEModel().getDEField(this.getDEWF().getWFStepField(), false);

			DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
			deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
			deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
			deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
			deDataSetCondImpl.setCondValue(strWFStepValue);
			userConditions.add(deDataSetCondImpl);
		}

		String strWFStateValue = WebContext.getWFState(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strWFStateValue) && !StringHelper.isNullOrEmpty(this.getDEWF().getWFStateField())) {
			IDEField iDEFieldModel = this.getDEModel().getDEField(this.getDEWF().getWFStateField(), false);

			DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
			deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
			deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
			deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
			deDataSetCondImpl.setCondValue(strWFStateValue);
			userConditions.add(deDataSetCondImpl);
		}

		String strUDStateValue = WebContext.getWFUDState(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strUDStateValue) && !StringHelper.isNullOrEmpty(this.getDEWF().getUDStateField())) {
			IDEField iDEFieldModel = this.getDEModel().getDEField(this.getDEWF().getUDStateField(), false);
			DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
			deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
			deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
			deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
			deDataSetCondImpl.setCondValue(strUDStateValue);
			userConditions.add(deDataSetCondImpl);
		}

		if (this.isWFIAMode()) {
			
			/**
			 * 20171221修改，附加工作流标识
			 */
			if(true){
				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
				deDataSetCondImpl.setCustomCond(StringHelper.format("wf1.WFWORKFLOWID='%1$s'",getDEWF().getWorkflowId()));
				userConditions.add(deDataSetCondImpl);
			}
			
			
			if (true) {
				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
				deDataSetCondImpl.setCustomCond(StringHelper.format("wf2.ACTORID='%1$s'", this.getWebContext().getCurUserId()));
				userConditions.add(deDataSetCondImpl);
			}

			if (true) {
				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
				deDataSetCondImpl.setCustomCond(StringHelper.format("wf3.ACTORID IS NULL"));
				userConditions.add(deDataSetCondImpl);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#onProcessAction(java.lang.String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, IWFCtrlHandler.ACTION_WFSUBMIT, true) == 0) {
			return onWFSubmit();
		}
		return super.onProcessAction(strAction);
	}

	/**
	 * 流程交互
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onWFSubmit() throws Exception {
		AjaxActionResult ajaxActionResult = new AjaxActionResult();
		String strKeys = WebContext.getKeys(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKeys)) {
			strKeys = WebContext.getKey(this.getWebContext());
		}

		if (StringHelper.isNullOrEmpty(strKeys)) {
			ajaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return ajaxActionResult;
		}

		String strIATag = WebContext.getWFIATag(this.getWebContext());
		String[] keys = strKeys.split("[;]");
		IWFService iWFService = getWFModel().getWFService();

		IWFProcessModel iWFProcessModel = this.getWFModel().getLastWFVersionModel().getWFProcessModelByWFStepValue(this.getWFStepValue(), false);

		for (String strKey : keys) {
			WFActionParam wfActionParam = new WFActionParam();
			wfActionParam.setUserData(strKey);
			wfActionParam.setUserData4(this.getDEModel().getId());
			wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
			wfActionParam.setStepId(iWFProcessModel.getId());
			wfActionParam.setConnection(strIATag);
			wfActionParam.setWFMode(this.getWebContext().getWFMode());
			iWFService.submit(wfActionParam);
		}
		return ajaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#fillDEDataSetFetchDataRange(net.ibizsys.paas.core.DEDataSetFetchContext)
	 */
	@Override
	protected void fillDEDataSetFetchDataRange(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		if (this.isWFIAMode()) return;
		super.fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);
	}

}
