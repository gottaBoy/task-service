package net.ibizsys.pswf.web.util;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.sf.json.JSONObject;

/**
 * 流程跟踪视图
 * 
 * @author Administrator
 *
 */
public class WFTraceChartPage extends Page {
	private String strScript = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.Page#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		String strParentKey = WebContext.getParentKey(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strParentKey)) {
			return;
		}

		String strParentDEId = WebContext.getParentDEId(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strParentDEId)) {
			throw new Exception("没有指定父实体标示");
		}

		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strParentDEId);
		IDEWF iDEWF = iDataEntityModel.getDefaultDEWF();
		if (iDEWF == null) {
			throw new Exception(StringHelper.format("实体[%1$s]不支持工作流", iDataEntityModel.getName()));
		}

		IEntity activeUserData = iDataEntityModel.createEntity();
		activeUserData.set(iDataEntityModel.getKeyDEField().getName(), strParentKey);
		iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);

		String strActiveWFInstId = DataObject.getStringValue(activeUserData, iDEWF.getWFInstField(), null);
		if (StringHelper.isNullOrEmpty(strActiveWFInstId)) return;

		WFInstance wfInstance = new WFInstance();
		wfInstance.setWFInstanceId(strActiveWFInstId);

		WFInstanceService wfInstanceService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class);
		wfInstanceService.get(wfInstance);

		MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
		// 获取我的工作
		StringBuilderEx sql = new StringBuilderEx();
		if(WebConfig.getCurrent().isLowCaseSql()) {
			sql.append("select t1.createdate,t1.createman,t1.deadline,t1.endtime,t1.fromwfstepid,t1.isfinish,t1.isinteractive,t1.lastactorid,t1.memo,t1.starttime,t1.tracestep,t1.updatedate,t1.updateman,t1.wfinstanceid,t1.wfplogicname,t1.wfpmodel,t1.wfpname,t1.wfstepid,t1.wfsteplanrestag,t1.wfstepname,t1.wfversion from t_srfwfstep t1 " + " where t1.wfinstanceid =?   order by t1.tracestep ");
		}else {
			sql.append("select t1.* from t_srfwfstep t1 " + " where t1.WFINSTANCEID =?   order by t1.tracestep ");
		}

		SqlParamList sqlParamList = new SqlParamList();
		sqlParamList.addString(strActiveWFInstId);

		// 进行数据查询
		WFStepDataService wfStepDataService = (WFStepDataService) ServiceGlobal.getService(WFStepDataService.class);
		ArrayList<IEntity> list = wfStepDataService.selectRaw(sql.toString(), sqlParamList);

		HashMap<String, Integer> stepCountMap = new HashMap<String, Integer>();
		String strActiveStep = "";
		for (IEntity iEntity : list) {
			if (!DataObject.getBoolValue(iEntity, WFStep.FIELD_ISINTERACTIVE, false)) continue;
			String strWFStepValue = DataObject.getStringValue(iEntity, WFStep.FIELD_WFSTEPNAME, "");
			Integer nLastCount = stepCountMap.get(strWFStepValue);
			if (nLastCount == null) nLastCount = 0;
			nLastCount++;
			stepCountMap.put(strWFStepValue, nLastCount);
			if (!DataObject.getBoolValue(iEntity, WFStep.FIELD_ISFINISH, false)) {
				strActiveStep = strWFStepValue;
				continue;
			}
		}

		IWFVersionModel iwfVersionModel = ((IDEWFModel) iDEWF).getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion());

		ArrayList<JSONObject> processObjectList = new ArrayList<JSONObject>();
		ArrayList<JSONObject> linkObjectList = new ArrayList<JSONObject>();
		java.util.Iterator<IWFProcessModel> wfProcessModels = iwfVersionModel.getWFProcessModels();
		IWFProcessModel activeWFProcessModel = null;
		if (wfProcessModels != null) {
			while (wfProcessModels.hasNext()) {
				IWFProcessModel iWFProcessModel = wfProcessModels.next();
				JSONObject item = new JSONObject();
				String strTips = "";
				item.put("wfprocesstype", JSONObjectHelper.stripQuotes(iWFProcessModel.getWFProcessType(),true));
				String strPSWFProcessName = getLocalization(iWFProcessModel.getNameLanResTag(),iWFProcessModel.getName());
				item.put("pswfprocessname", JSONObjectHelper.stripQuotes(strPSWFProcessName,true));
				item.put("pswfprocessid", JSONObjectHelper.stripQuotes(iWFProcessModel.getId(),true));
				item.put("leftpos", iWFProcessModel.getLeftPos());
				item.put("toppos", iWFProcessModel.getTopPos());
				if (iWFProcessModel instanceof IWFInteractiveProcessModel) {
					IWFInteractiveProcessModel iWFInteractiveProcessModel = (IWFInteractiveProcessModel) iWFProcessModel;
					Integer nCount = stepCountMap.get(iWFInteractiveProcessModel.getWFStepValue());
					if (nCount == null) {
						nCount = 0;
					}
					item.put("wfstepvalue", JSONObjectHelper.stripQuotes(iWFInteractiveProcessModel.getWFStepValue(),true));
					item.put("count", nCount);
					boolean bActive = false;
					if (StringHelper.compare(strActiveStep, iWFInteractiveProcessModel.getWFStepValue(), false) == 0) {
						activeWFProcessModel = iWFProcessModel;
						bActive = true;
					}
					item.put("active", bActive);
					if (bActive) {
						if (nCount == 1) {
							strTips = "当前环节";
						} else {
							strTips = StringHelper.format("当前环节，已执行[%1$s]次", nCount);
						}
					} else {
						if (nCount >= 1) {
							strTips = StringHelper.format("已执行[%1$s]次", nCount);
						} else {
							strTips = "未执行";
						}
					}
				}
				item.put("tips",JSONObjectHelper.stripQuotes(strTips,true));
				processObjectList.add(item);
			}
		}

		java.util.Iterator<IWFLinkModel> wfLinkModels = iwfVersionModel.getWFLinkModels();
		if (wfLinkModels != null) {
			while (wfLinkModels.hasNext()) {
				IWFLinkModel iWFLinkModel = wfLinkModels.next();
				JSONObject item = new JSONObject();
				item.put("frompswfprocid", JSONObjectHelper.stripQuotes(iWFLinkModel.getFrom(),true));
				item.put("topswfprocid", JSONObjectHelper.stripQuotes(iWFLinkModel.getNext(),true));
				item.put("srcendpoint", JSONObjectHelper.stripQuotes(iWFLinkModel.getSrcEndPoint(),true));
				item.put("dstendpoint", JSONObjectHelper.stripQuotes(iWFLinkModel.getDstEndPoint(),true));
				String strLinkName = iWFLinkModel.getLogicName();
				String strLNLanResTag = iWFLinkModel.getLNLanResTag();
				if (StringHelper.isNullOrEmpty(strLinkName)) {
					strLinkName = iWFLinkModel.getName();
				}
				if(!StringHelper.isNullOrEmpty(strLNLanResTag)){
					strLinkName = getLocalization(strLNLanResTag,strLinkName);
				}
				item.put("label", JSONObjectHelper.stripQuotes(strLinkName,true));
				linkObjectList.add(item);
			}
		}

		StringBuilderEx sbBuilderEx = new StringBuilderEx();
		for (JSONObject processObj : processObjectList) {
			sbBuilderEx.append("addProcess(%1$s);\r\n", processObj.toString());
		}
		for (JSONObject linkObj : linkObjectList) {
			sbBuilderEx.append("addConnection(%1$s);\r\n", linkObj.toString());
		}

		this.strScript = sbBuilderEx.toString();

	}
	
	/**
	 * 获取本地化内容
	 * @param strResId
	 * @param strDefault
	 * @return
	 */
	protected String getLocalization(String strResId, String strDefault) {
		if (WebContext.getCurrent() != null) {
			return WebContext.getCurrent().getLocalization(strResId, null, strDefault);
		}
		return strDefault;
	}

	/**
	 * 输出脚本
	 * 
	 * @return
	 */
	public String outputScript() {
		return this.strScript;
	}
}
