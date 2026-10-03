package net.ibizsys.pswf.web.util;

import java.util.ArrayList;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginLog;
import net.ibizsys.psrt.srv.wf.service.WFIAActionService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFActionResult;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 远程服务 核心 API Servlet
 * 
 * @author Administrator
 * 
 */
public class WFAPIServlet extends HttpServletBase {
	/**
	 * 获取我的工作
	 */
	private static String ACTION_GETWORKLIST = "GETWORKLIST";

	/**
	 * 获取数据流程记录
	 */
	private static String ACTION_GETSTEPDATALIST = "GETSTEPDATALIST";

	/**
	 * 获取当前的操作者
	 */
	private static String ACTION_GETSTEPACTORLIST = "GETSTEPACTORLIST";

	/**
	 * 获取当前的流程处理
	 */
	private static String ACTION_GETSTEPACTIONLIST = "GETSTEPACTIONLIST";

	/**
	 * 提交流程操作
	 */
	private static String ACTION_SUBMITACTION = "SUBMITACTION";

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(WFAPIServlet.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.HttpServletBase#onProcessAction()
	 */
	@Override
	protected AjaxActionResult onProcessAction() throws Exception {
		try {
			String strLoginKey = WebContext.getLoginKey(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strLoginKey)) {
				AjaxActionResult ajaxActionResult = new AjaxActionResult();
				ajaxActionResult.setRetCode(Errors.ACCESSDENY);
				ajaxActionResult.setErrorInfo("没有指定登录标示，请先进行登录");
				return ajaxActionResult;
			}

			LoginLog loginLog = RemoteLoginGlobal.getLoginLog(strLoginKey);
			if (loginLog == null) {
				AjaxActionResult ajaxActionResult = new AjaxActionResult();
				ajaxActionResult.setRetCode(Errors.ACCESSDENY);
				ajaxActionResult.setErrorInfo("无效登录标示，请重新登录");
				return ajaxActionResult;
			}

			String strWFId = WebContext.getWFId(this.getWebContext());
			String strDEId = WebContext.getDEId(this.getWebContext());
			String strKey = WebContext.getKey(this.getWebContext());
			String strCall = WebContext.getRemoteCall(this.getWebContext());
			String strRemoteAddr = this.getWebContext().getRemoteAddr();
			String strUserId = DataObject.getStringValue(loginLog, "userid", "");
			String strUserName = DataObject.getStringValue(loginLog, "username", "");
			String strCallRetIncEmpty = WebContext.getRemoteCallRetIncEmpty(this.getWebContext());
			boolean bCallRetIncEmpty = (StringHelper.compare(strCallRetIncEmpty, "true", true) == 0);
			String strCallRetTimeFmt = WebContext.getRemoteCallRetTimeFmt(this.getWebContext());
			if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
				strCallRetTimeFmt = DateHelper.getTimeJavaFormat(strCallRetTimeFmt);
			}

			this.getWebContext().setSessionValue(IWebContext.PERSONID, strUserId);
			this.getWebContext().setSessionValue(IWebContext.USERID, strUserId);
			this.getWebContext().setSessionValue(IWebContext.USERNAME, strUserName);

			if (StringHelper.compare(strCall, ACTION_GETWORKLIST, true) == 0) {
				MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
				// 获取我的工作
				StringBuilderEx sql = new StringBuilderEx();
				sql.append("select t3.WFWORKFLOWID,t3.WFWORKFLOWNAME,t1.WFPLOGICNAME,t4.ACTORID,t1.WFSTEPNAME,t2.USERDATA4,t2.USERDATA ,t1.createdate,t2.wfinstanceid,t2.wfinstancename from T_SRFWFSTEP t1 " + " INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0) " + "INNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  " + "INNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  " + "LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND  t5.CONNECTIONNAME<>'SRFWFRESUBMIT' AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT') " + "where t5.WFSTEPDATAID IS NULL AND t4.ACTORID=? order by t1.createdate ");

				SqlParamList sqlParamList = new SqlParamList();
				sqlParamList.addString(this.getWebContext().getCurUserId());

				// 进行数据查询
				WFStepService wfStepService = (WFStepService) ServiceGlobal.getService(WFStepService.class);
				ArrayList<IEntity> list = wfStepService.selectRaw(sql.toString(), sqlParamList);

				for (IEntity iEntity : list) {
					JSONObject itemJsonObject = DataObject.toJSONObject(iEntity, bCallRetIncEmpty);
					String objUserData4 = itemJsonObject.getString("userdata4");
					itemJsonObject.remove("userdata4");
					IDataEntityModel iDEModel = DEModelGlobal.getDEModel(objUserData4);
					itemJsonObject.put("srfdeid", JSONObjectHelper.stripQuotes(iDEModel.getName(),true));
					// itemJsonObject.put("srfwfid", ((IDEWFModel) iDEModel.getDEWF(itemJsonObject.optString("wfworkflowid"))).getWFModel().getName());

					String objUserData = itemJsonObject.getString("userdata");
					itemJsonObject.remove("userdata");
					itemJsonObject.put("srfkey",JSONObjectHelper.stripQuotes( objUserData,true));

					if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
						itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
					}

					ajaxActionResult.getRows().add(itemJsonObject);

				}

				ajaxActionResult.setTotalRow(list.size());
				return ajaxActionResult;
			}

			IDataEntityModel iDataEntityModel = null;
			IDEWF iDEWF = null;
			if (!StringHelper.isNullOrEmpty(strDEId)) {
				iDataEntityModel = DEModelGlobal.getDEModel(strDEId);
			}
			if (!StringHelper.isNullOrEmpty(strWFId)) {
				iDEWF = iDataEntityModel.getDEWF(strWFId);
			} else
				iDEWF = iDataEntityModel.getDefaultDEWF();

			if (iDEWF == null) {
				AjaxActionResult ajaxActionResult = new AjaxActionResult();
				ajaxActionResult.setRetCode(Errors.INPUTERROR);
				ajaxActionResult.setErrorInfo("当前业务对象不支持流程");
				return ajaxActionResult;
			}

			if (StringHelper.isNullOrEmpty(strKey)) {
				AjaxActionResult ajaxActionResult = new AjaxActionResult();
				ajaxActionResult.setRetCode(Errors.INPUTERROR);
				ajaxActionResult.setErrorInfo("没有指定业务数据");
				return ajaxActionResult;
			}

			IDEWFModel iDEWFModel = (IDEWFModel) iDEWF;

			if (StringHelper.compare(strCall, ACTION_GETSTEPDATALIST, true) == 0) {
				IEntity activeUserData = iDataEntityModel.createEntity();
				activeUserData.set(iDataEntityModel.getKeyDEField().getName(), strKey);
				iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
				String strActiveWFInstId = DataObject.getStringValue(activeUserData, iDEWF.getWFInstField(), null);

				MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
				// 获取我的工作
				StringBuilderEx sql = new StringBuilderEx();
				if(WebConfig.getCurrent().isLowCaseSql()) {
					sql.append("select t1.actorid,t1.actorname,t1.actorname2,t1.connectionname,t1.createdate,t1.createman,t1.memo,t1.nextto,t1.originalwfuserid,t1.originalwfusername,t1.sdparam,t1.sdparam2,t1.updatedate,t1.updateman,t1.userdata,t1.userdatadesc,t1.wfactionlanrestag,t1.wfinstanceid,t1.wfinstancename,t1.wfplogicname,t1.wfstepdataid,t1.wfstepdataname,t1.wfstepid,t1.wfsteplanrestag,t1.wfstepname,wf1.wfworkflowid from t_srfwfstepdata t1 " + " inner join t_srfwfinstance wf1 on t1.wfinstanceid = wf1.wfinstanceid " + " where wf1.userdata=? and wf1.userdata4=? and (wf1.wfinstanceid =?  or wf1.pwfinstanceid =?) order by t1.createdate ");
				}else {
					sql.append("select t1.*,wf1.WFWORKFLOWID from t_srfwfstepdata t1 " + " INNER JOIN T_SRFWFINSTANCE wf1 ON t1.WFINSTANCEID = wf1.WFINSTANCEID " + " where wf1.USERDATA=? and wf1.USERDATA4=? and (wf1.WFINSTANCEID =?  OR wf1.PWFINSTANCEID =?) order by t1.createdate ");
				}
				SqlParamList sqlParamList = new SqlParamList();
				sqlParamList.addString(strKey);
				sqlParamList.addString(iDataEntityModel.getId());
				sqlParamList.addString(strActiveWFInstId);
				sqlParamList.addString(strActiveWFInstId);

				// 进行数据查询
				WFStepDataService wfStepDataService = (WFStepDataService) ServiceGlobal.getService(WFStepDataService.class);
				ArrayList<IEntity> list = wfStepDataService.selectRaw(sql.toString(), sqlParamList);

				for (IEntity iEntity : list) {
					JSONObject itemJsonObject = DataObject.toJSONObject(iEntity, bCallRetIncEmpty);
					itemJsonObject.put("srfdeid",  JSONObjectHelper.stripQuotes(iDataEntityModel.getName(),true));
					if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
						itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
					}

					// itemJsonObject.put("srfwfid", ((IDEWFModel) iDataEntityModel.getDEWF(itemJsonObject.optString("wfworkflowid"))).getWFModel().getName());

					ajaxActionResult.getRows().add(itemJsonObject);
				}
				ajaxActionResult.setTotalRow(list.size());
				return ajaxActionResult;
			}

			if (StringHelper.compare(strCall, ACTION_GETSTEPACTORLIST, true) == 0) {
				IEntity activeUserData = iDataEntityModel.createEntity();
				activeUserData.set(iDataEntityModel.getKeyDEField().getName(), strKey);
				iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
				String strActiveWFInstId = DataObject.getStringValue(activeUserData, iDEWF.getWFInstField(), null);

				MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
				// 获取我的工作
				StringBuilderEx sql = new StringBuilderEx();
				if(WebConfig.getCurrent().isLowCaseSql()) {
					sql.append("select t1.actorid,t1.actortype,t1.createdate,t1.createman,t1.finishdate,t1.firstreadtime,t1.iaactions,t1.isfinish,t1.isreadonly,t1.memo,t1.originalwfuserid,t1.originalwfusername,t1.readflag,t1.remindercount,t1.roleid,t1.updatedate,t1.updateman,t1.wfinstanceid,t1.wfstepactorid,t1.wfstepactorname,t1.wfstepid,t1.wfstepname ,wf1.wfworkflowid from t_srfwfstepactor t1 " + " inner join t_srfwfinstance wf1 on t1.wfinstanceid = wf1.wfinstanceid and wf1.activestepid = t1.wfstepid " + " where wf1.userdata=? and wf1.userdata4=? and (wf1.wfinstanceid =?  or wf1.pwfinstanceid =?) order by t1.createdate ");
				}else {
					sql.append("select t1.* ,wf1.WFWORKFLOWID from t_srfwfstepactor t1 " + " INNER JOIN T_SRFWFINSTANCE wf1 ON t1.WFINSTANCEID = wf1.WFINSTANCEID and wf1.ACTIVESTEPID = t1.WFSTEPID " + " where wf1.USERDATA=? and wf1.USERDATA4=? and (wf1.WFINSTANCEID =?  OR wf1.PWFINSTANCEID =?) order by t1.createdate ");
				}

				SqlParamList sqlParamList = new SqlParamList();
				sqlParamList.addString(strKey);
				sqlParamList.addString(iDataEntityModel.getId());
				sqlParamList.addString(strActiveWFInstId);
				sqlParamList.addString(strActiveWFInstId);

				// 进行数据查询
				WFStepActorService wfStepActorService = (WFStepActorService) ServiceGlobal.getService(WFStepActorService.class);
				ArrayList<IEntity> list = wfStepActorService.selectRaw(sql.toString(), sqlParamList);

				for (IEntity iEntity : list) {
					JSONObject itemJsonObject = DataObject.toJSONObject(iEntity, bCallRetIncEmpty);
					itemJsonObject.put("srfdeid",JSONObjectHelper.stripQuotes( iDataEntityModel.getName(),true));
					if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
						itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
					}
					// itemJsonObject.put("srfwfid", ((IDEWFModel) iDataEntityModel.getDEWF(itemJsonObject.optString("wfworkflowid"))).getWFModel().getName());

					ajaxActionResult.getRows().add(itemJsonObject);
				}
				ajaxActionResult.setTotalRow(list.size());
				return ajaxActionResult;
			}

			if (StringHelper.compare(strCall, ACTION_GETSTEPACTIONLIST, true) == 0) {
				IEntity activeUserData = iDataEntityModel.createEntity();
				activeUserData.set(iDataEntityModel.getKeyDEField().getName(), strKey);
				iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
				String strActiveWFInstId = DataObject.getStringValue(activeUserData, iDEWF.getWFInstField(), null);

				MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
				// 获取我的工作
				StringBuilderEx sql = new StringBuilderEx();
				if(WebConfig.getCurrent().isLowCaseSql()) {
					sql.append("select t1.actioncount,t1.actionlogicname,t1.actionname,t1.createdate,t1.createman,t1.fahelper,t1.memo,t1.nextcondition,t1.nextto,t1.orderflag,t1.pagepath,t1.panelid,t1.updatedate,t1.updateman,t1.wfiaactionid,t1.wfiaactionname,t1.wfstepid,t1.wfstepname  from t_srfwfiaaction t1  " + " inner join t_srfwfinstance wf1 on t1.wfstepid = wf1.activestepid  " + " where wf1.wfinstanceid =? order by t1.orderflag ");
				}else {
					sql.append("select t1.*  from t_srfwfiaaction t1  " + " INNER JOIN T_SRFWFINSTANCE wf1 ON t1.WFSTEPID = wf1.ACTIVESTEPID  " + " where wf1.WFINSTANCEID =? order by t1.orderflag ");
				}

				SqlParamList sqlParamList = new SqlParamList();
				sqlParamList.addString(strActiveWFInstId);

				// 进行数据查询
				WFIAActionService wfIAActionService = (WFIAActionService) ServiceGlobal.getService(WFIAActionService.class);
				ArrayList<IEntity> list = wfIAActionService.selectRaw(sql.toString(), sqlParamList);

				for (IEntity iEntity : list) {
					JSONObject itemJsonObject = DataObject.toJSONObject(iEntity, bCallRetIncEmpty);
					itemJsonObject.put("srfdeid", JSONObjectHelper.stripQuotes(iDataEntityModel.getName(),true));
					// itemJsonObject.put("srfwfid", iDEWFModel.getWFModel().getName());
					itemJsonObject.put("srfwfiatag", itemJsonObject.get("actionname"));
					itemJsonObject.remove("actionname");
					if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
						itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
					}

					ajaxActionResult.getRows().add(itemJsonObject);
				}
				ajaxActionResult.setTotalRow(list.size());
				return ajaxActionResult;
			}

			if (StringHelper.compare(strCall, ACTION_SUBMITACTION, true) == 0) {
				String strIATag = WebContext.getWFIATag(this.getWebContext());
				String strSubmitMemo = WebContext.getWFMemo(this.getWebContext());

				IEntity activeUserData = iDataEntityModel.createEntity();

				String strArg = WebContext.getRemoteCallArg(this.getWebContext());
				if (!StringHelper.isNullOrEmpty(strArg)) {
					JSONObject joArg = JSONObject.fromString(strArg);
					DataObject.fromJSONObject(activeUserData, joArg);
					iDataEntityModel.getService(this.getSessionFactory()).save(activeUserData);
				} else {
					activeUserData.set(iDataEntityModel.getKeyDEField().getName(), strKey);
					iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
				}

				String strActiveWFStepId = DataObject.getStringValue(activeUserData, iDEWF.getWFStepField(), null);

				String strMemoField = "";

				IWFService iWFService = iDEWFModel.getWFModel().getWFService();
				IWFProcessModel iWFProcessModel = iDEWFModel.getWFModel().getLastWFVersionModel().getWFProcessModelByWFStepValue(strActiveWFStepId, false);
				if (iWFProcessModel instanceof IWFInteractiveProcessModel) {
					IWFInteractiveProcessModel iWFInteractiveProcessModel = (IWFInteractiveProcessModel) iWFProcessModel;
					IWFInteractiveLinkModel iWFInteractiveLinkModel = iWFInteractiveProcessModel.getWFInteractiveLinkModel(strIATag, true);
					if (iWFInteractiveLinkModel != null) {
						strMemoField = iWFInteractiveLinkModel.getMemoField();
					}
					if (StringHelper.isNullOrEmpty(strMemoField)) {
						strMemoField = iWFInteractiveProcessModel.getMemoField();
					}
				}

				String strLastSubmitMemo = "";
				if (!StringHelper.isNullOrEmpty(strMemoField)) {
					// 有处理意见属性
					IEntity iEntity2 = iDataEntityModel.createEntity();
					strLastSubmitMemo = DataObject.getStringValue(activeUserData, strMemoField, "");
					if (!StringHelper.isNullOrEmpty(strLastSubmitMemo)) {
						strLastSubmitMemo += "\r\n\r\n";
					}
					strLastSubmitMemo += StringHelper.format("%1$s %2$s 处理:\r\n%3$s", this.getWebContext().getCurUserName(), DateHelper.getCurTimeString(), strSubmitMemo);
					iEntity2.set(strMemoField, strLastSubmitMemo);
					iEntity2.set(iDataEntityModel.getKeyDEField().getName(), activeUserData.get(iDataEntityModel.getKeyDEField().getName()));
					iDataEntityModel.getService(this.getSessionFactory()).update(iEntity2);
				}

				WFActionParam wfActionParam = new WFActionParam();
				wfActionParam.setUserData(strKey);
				wfActionParam.setUserData4(iDataEntityModel.getId());
				wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
				wfActionParam.setStepId(iWFProcessModel.getId());
				wfActionParam.setConnection(strIATag);
				wfActionParam.setDescription(strSubmitMemo);
				wfActionParam.setWFMode(this.getWebContext().getWFMode());
				WFActionResult wfActionResult = iWFService.submit(wfActionParam);

				SDAjaxActionResult ajaxActionResult = new SDAjaxActionResult();
				ajaxActionResult.setRetCode(Errors.OK);
				ajaxActionResult.setErrorInfo(wfActionResult.getReturnInfo());
				ajaxActionResult.getData(true).put("wfinstanceid", JSONObjectHelper.stripQuotes( wfActionResult.getInstanceId(),true));
				return ajaxActionResult;
			}

			throw new Exception(StringHelper.format("无法识别的远程调用[%1$s]", strCall));
		} catch (Exception ex) {
			AjaxActionResult ajaxActionResult = new AjaxActionResult();
			log.error(StringHelper.format("远程请求发生异常，%1$s", ex.getMessage()), ex);
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		}
	}
}
