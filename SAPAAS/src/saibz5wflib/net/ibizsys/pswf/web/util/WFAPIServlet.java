/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEWF
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDEWFModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.security.RemoteLoginGlobal
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.HttpServletBase
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.SDAjaxActionResult
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.common.entity.LoginLog
 *  net.ibizsys.psrt.srv.wf.service.WFIAActionService
 *  net.ibizsys.psrt.srv.wf.service.WFStepActorService
 *  net.ibizsys.psrt.srv.wf.service.WFStepDataService
 *  net.ibizsys.psrt.srv.wf.service.WFStepService
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.WFActionParam
 *  net.ibizsys.pswf.core.WFActionResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pswf.web.util;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
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

public class WFAPIServlet
extends HttpServletBase {
    private static String ACTION_GETWORKLIST = "GETWORKLIST";
    private static String ACTION_GETSTEPDATALIST = "GETSTEPDATALIST";
    private static String ACTION_GETSTEPACTORLIST = "GETSTEPACTORLIST";
    private static String ACTION_GETSTEPACTIONLIST = "GETSTEPACTIONLIST";
    private static String ACTION_SUBMITACTION = "SUBMITACTION";
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(WFAPIServlet.class);

    protected AjaxActionResult onProcessAction() throws Exception {
        try {
            String strLoginKey = WebContext.getLoginKey((IWebContext)this.getWebContext());
            if (StringHelper.isNullOrEmpty((String)strLoginKey)) {
                AjaxActionResult ajaxActionResult = new AjaxActionResult();
                ajaxActionResult.setRetCode(2);
                ajaxActionResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u767b\u5f55\u6807\u793a\uff0c\u8bf7\u5148\u8fdb\u884c\u767b\u5f55");
                return ajaxActionResult;
            }
            LoginLog loginLog = RemoteLoginGlobal.getLoginLog((String)strLoginKey);
            if (loginLog == null) {
                AjaxActionResult ajaxActionResult = new AjaxActionResult();
                ajaxActionResult.setRetCode(2);
                ajaxActionResult.setErrorInfo("\u65e0\u6548\u767b\u5f55\u6807\u793a\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55");
                return ajaxActionResult;
            }
            String strWFId = WebContext.getWFId((IWebContext)this.getWebContext());
            String strDEId = WebContext.getDEId((IWebContext)this.getWebContext());
            String strKey = WebContext.getKey((IWebContext)this.getWebContext());
            String strCall = WebContext.getRemoteCall((IWebContext)this.getWebContext());
            String strRemoteAddr = this.getWebContext().getRemoteAddr();
            String strUserId = DataObject.getStringValue((IDataObject)loginLog, (String)"userid", (String)"");
            String strUserName = DataObject.getStringValue((IDataObject)loginLog, (String)"username", (String)"");
            String strCallRetIncEmpty = WebContext.getRemoteCallRetIncEmpty((IWebContext)this.getWebContext());
            boolean bCallRetIncEmpty = StringHelper.compare((String)strCallRetIncEmpty, (String)"true", (boolean)true) == 0;
            String strCallRetTimeFmt = WebContext.getRemoteCallRetTimeFmt((IWebContext)this.getWebContext());
            if (!StringHelper.isNullOrEmpty((String)strCallRetTimeFmt)) {
                strCallRetTimeFmt = DateHelper.getTimeJavaFormat((String)strCallRetTimeFmt);
            }
            this.getWebContext().setSessionValue("SRFPERSONID", (Object)strUserId);
            this.getWebContext().setSessionValue("SRFUSERID", (Object)strUserId);
            this.getWebContext().setSessionValue("SRFUSERNAME", (Object)strUserName);
            if (StringHelper.compare((String)strCall, (String)ACTION_GETWORKLIST, (boolean)true) == 0) {
                MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
                StringBuilderEx sql = new StringBuilderEx();
                sql.append("select t3.WFWORKFLOWID,t3.WFWORKFLOWNAME,t1.WFPLOGICNAME,t4.ACTORID,t1.WFSTEPNAME,t2.USERDATA4,t2.USERDATA ,t1.createdate,t2.wfinstanceid,t2.wfinstancename from T_SRFWFSTEP t1  INNER JOIN t_SRFWFINSTANCE t2 on  t2.ACTIVESTEPID = t1.WFSTEPID AND ( t2.ISCLOSE IS NULL OR t2.ISCLOSE=0) INNER JOIN T_SRFWFWORKFLOW t3 on t2.WFWORKFLOWID = t3.WFWORKFLOWID  INNER JOIN T_SRFWFSTEPACTOR t4 on  t4.WFSTEPID = t1.WFSTEPID  LEFT JOIN T_SRFWFSTEPDATA t5 ON (t5.ACTORID=T4.ACTORID and  t5.WFSTEPID = t2.ACTIVESTEPID AND  t5.CONNECTIONNAME<>'SRFWFRESUBMIT' AND t5.CONNECTIONNAME <> 'SRFWFTIMEOUT') where t5.WFSTEPDATAID IS NULL AND t4.ACTORID=? order by t1.createdate ");
                SqlParamList sqlParamList = new SqlParamList();
                sqlParamList.addString(this.getWebContext().getCurUserId());
                WFStepService wfStepService = (WFStepService)ServiceGlobal.getService(WFStepService.class);
                ArrayList list = wfStepService.selectRaw(sql.toString(), sqlParamList);
                for (IEntity iEntity : list) {
                    JSONObject itemJsonObject = DataObject.toJSONObject((IDataObject)iEntity, (boolean)bCallRetIncEmpty);
                    String objUserData4 = itemJsonObject.getString("userdata4");
                    itemJsonObject.remove("userdata4");
                    IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)objUserData4);
                    itemJsonObject.put("srfdeid", JSONObjectHelper.stripQuotes((String)iDEModel.getName(), (boolean)true));
                    String objUserData = itemJsonObject.getString("userdata");
                    itemJsonObject.remove("userdata");
                    itemJsonObject.put("srfkey", JSONObjectHelper.stripQuotes((String)objUserData, (boolean)true));
                    if (!StringHelper.isNullOrEmpty((String)strCallRetTimeFmt)) {
                        itemJsonObject = DataObject.convertJSONValueTimeFmt((JSONObject)itemJsonObject, (String)strCallRetTimeFmt);
                    }
                    ajaxActionResult.getRows().add(itemJsonObject);
                }
                ajaxActionResult.setTotalRow(list.size());
                return ajaxActionResult;
            }
            IDataEntityModel iDataEntityModel = null;
            IDEWF iDEWF = null;
            if (!StringHelper.isNullOrEmpty((String)strDEId)) {
                iDataEntityModel = DEModelGlobal.getDEModel((String)strDEId);
            }
            if ((iDEWF = !StringHelper.isNullOrEmpty((String)strWFId) ? iDataEntityModel.getDEWF(strWFId) : iDataEntityModel.getDefaultDEWF()) == null) {
                AjaxActionResult ajaxActionResult = new AjaxActionResult();
                ajaxActionResult.setRetCode(5);
                ajaxActionResult.setErrorInfo("\u5f53\u524d\u4e1a\u52a1\u5bf9\u8c61\u4e0d\u652f\u6301\u6d41\u7a0b");
                return ajaxActionResult;
            }
            if (StringHelper.isNullOrEmpty((String)strKey)) {
                AjaxActionResult ajaxActionResult = new AjaxActionResult();
                ajaxActionResult.setRetCode(5);
                ajaxActionResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u4e1a\u52a1\u6570\u636e");
                return ajaxActionResult;
            }
            IDEWFModel iDEWFModel = (IDEWFModel)iDEWF;
            if (StringHelper.compare((String)strCall, (String)ACTION_GETSTEPDATALIST, (boolean)true) == 0) {
                IEntity activeUserData = iDataEntityModel.createEntity();
                activeUserData.set(iDataEntityModel.getKeyDEField().getName(), (Object)strKey);
                iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
                String strActiveWFInstId = DataObject.getStringValue((IDataObject)activeUserData, (String)iDEWF.getWFInstField(), null);
                MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
                StringBuilderEx sql = new StringBuilderEx();
                if (WebConfig.getCurrent().isLowCaseSql()) {
                    sql.append("select t1.actorid,t1.actorname,t1.actorname2,t1.connectionname,t1.createdate,t1.createman,t1.memo,t1.nextto,t1.originalwfuserid,t1.originalwfusername,t1.sdparam,t1.sdparam2,t1.updatedate,t1.updateman,t1.userdata,t1.userdatadesc,t1.wfactionlanrestag,t1.wfinstanceid,t1.wfinstancename,t1.wfplogicname,t1.wfstepdataid,t1.wfstepdataname,t1.wfstepid,t1.wfsteplanrestag,t1.wfstepname,wf1.wfworkflowid from t_srfwfstepdata t1  inner join t_srfwfinstance wf1 on t1.wfinstanceid = wf1.wfinstanceid  where wf1.userdata=? and wf1.userdata4=? and (wf1.wfinstanceid =?  or wf1.pwfinstanceid =?) order by t1.createdate ");
                } else {
                    sql.append("select t1.*,wf1.WFWORKFLOWID from t_srfwfstepdata t1  INNER JOIN T_SRFWFINSTANCE wf1 ON t1.WFINSTANCEID = wf1.WFINSTANCEID  where wf1.USERDATA=? and wf1.USERDATA4=? and (wf1.WFINSTANCEID =?  OR wf1.PWFINSTANCEID =?) order by t1.createdate ");
                }
                SqlParamList sqlParamList = new SqlParamList();
                sqlParamList.addString(strKey);
                sqlParamList.addString(iDataEntityModel.getId());
                sqlParamList.addString(strActiveWFInstId);
                sqlParamList.addString(strActiveWFInstId);
                WFStepDataService wfStepDataService = (WFStepDataService)ServiceGlobal.getService(WFStepDataService.class);
                ArrayList list = wfStepDataService.selectRaw(sql.toString(), sqlParamList);
                for (IEntity iEntity : list) {
                    JSONObject itemJsonObject = DataObject.toJSONObject((IDataObject)iEntity, (boolean)bCallRetIncEmpty);
                    itemJsonObject.put("srfdeid", JSONObjectHelper.stripQuotes((String)iDataEntityModel.getName(), (boolean)true));
                    if (!StringHelper.isNullOrEmpty((String)strCallRetTimeFmt)) {
                        itemJsonObject = DataObject.convertJSONValueTimeFmt((JSONObject)itemJsonObject, (String)strCallRetTimeFmt);
                    }
                    ajaxActionResult.getRows().add(itemJsonObject);
                }
                ajaxActionResult.setTotalRow(list.size());
                return ajaxActionResult;
            }
            if (StringHelper.compare((String)strCall, (String)ACTION_GETSTEPACTORLIST, (boolean)true) == 0) {
                IEntity activeUserData = iDataEntityModel.createEntity();
                activeUserData.set(iDataEntityModel.getKeyDEField().getName(), (Object)strKey);
                iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
                String strActiveWFInstId = DataObject.getStringValue((IDataObject)activeUserData, (String)iDEWF.getWFInstField(), null);
                MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
                StringBuilderEx sql = new StringBuilderEx();
                if (WebConfig.getCurrent().isLowCaseSql()) {
                    sql.append("select t1.actorid,t1.actortype,t1.createdate,t1.createman,t1.finishdate,t1.firstreadtime,t1.iaactions,t1.isfinish,t1.isreadonly,t1.memo,t1.originalwfuserid,t1.originalwfusername,t1.readflag,t1.remindercount,t1.roleid,t1.updatedate,t1.updateman,t1.wfinstanceid,t1.wfstepactorid,t1.wfstepactorname,t1.wfstepid,t1.wfstepname ,wf1.wfworkflowid from t_srfwfstepactor t1  inner join t_srfwfinstance wf1 on t1.wfinstanceid = wf1.wfinstanceid and wf1.activestepid = t1.wfstepid  where wf1.userdata=? and wf1.userdata4=? and (wf1.wfinstanceid =?  or wf1.pwfinstanceid =?) order by t1.createdate ");
                } else {
                    sql.append("select t1.* ,wf1.WFWORKFLOWID from t_srfwfstepactor t1  INNER JOIN T_SRFWFINSTANCE wf1 ON t1.WFINSTANCEID = wf1.WFINSTANCEID and wf1.ACTIVESTEPID = t1.WFSTEPID  where wf1.USERDATA=? and wf1.USERDATA4=? and (wf1.WFINSTANCEID =?  OR wf1.PWFINSTANCEID =?) order by t1.createdate ");
                }
                SqlParamList sqlParamList = new SqlParamList();
                sqlParamList.addString(strKey);
                sqlParamList.addString(iDataEntityModel.getId());
                sqlParamList.addString(strActiveWFInstId);
                sqlParamList.addString(strActiveWFInstId);
                WFStepActorService wfStepActorService = (WFStepActorService)ServiceGlobal.getService(WFStepActorService.class);
                ArrayList list = wfStepActorService.selectRaw(sql.toString(), sqlParamList);
                for (IEntity iEntity : list) {
                    JSONObject itemJsonObject = DataObject.toJSONObject((IDataObject)iEntity, (boolean)bCallRetIncEmpty);
                    itemJsonObject.put("srfdeid", JSONObjectHelper.stripQuotes((String)iDataEntityModel.getName(), (boolean)true));
                    if (!StringHelper.isNullOrEmpty((String)strCallRetTimeFmt)) {
                        itemJsonObject = DataObject.convertJSONValueTimeFmt((JSONObject)itemJsonObject, (String)strCallRetTimeFmt);
                    }
                    ajaxActionResult.getRows().add(itemJsonObject);
                }
                ajaxActionResult.setTotalRow(list.size());
                return ajaxActionResult;
            }
            if (StringHelper.compare((String)strCall, (String)ACTION_GETSTEPACTIONLIST, (boolean)true) == 0) {
                IEntity activeUserData = iDataEntityModel.createEntity();
                activeUserData.set(iDataEntityModel.getKeyDEField().getName(), (Object)strKey);
                iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
                String strActiveWFInstId = DataObject.getStringValue((IDataObject)activeUserData, (String)iDEWF.getWFInstField(), null);
                MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
                StringBuilderEx sql = new StringBuilderEx();
                if (WebConfig.getCurrent().isLowCaseSql()) {
                    sql.append("select t1.actioncount,t1.actionlogicname,t1.actionname,t1.createdate,t1.createman,t1.fahelper,t1.memo,t1.nextcondition,t1.nextto,t1.orderflag,t1.pagepath,t1.panelid,t1.updatedate,t1.updateman,t1.wfiaactionid,t1.wfiaactionname,t1.wfstepid,t1.wfstepname  from t_srfwfiaaction t1   inner join t_srfwfinstance wf1 on t1.wfstepid = wf1.activestepid   where wf1.wfinstanceid =? order by t1.orderflag ");
                } else {
                    sql.append("select t1.*  from t_srfwfiaaction t1   INNER JOIN T_SRFWFINSTANCE wf1 ON t1.WFSTEPID = wf1.ACTIVESTEPID   where wf1.WFINSTANCEID =? order by t1.orderflag ");
                }
                SqlParamList sqlParamList = new SqlParamList();
                sqlParamList.addString(strActiveWFInstId);
                WFIAActionService wfIAActionService = (WFIAActionService)ServiceGlobal.getService(WFIAActionService.class);
                ArrayList list = wfIAActionService.selectRaw(sql.toString(), sqlParamList);
                for (IEntity iEntity : list) {
                    JSONObject itemJsonObject = DataObject.toJSONObject((IDataObject)iEntity, (boolean)bCallRetIncEmpty);
                    itemJsonObject.put("srfdeid", JSONObjectHelper.stripQuotes((String)iDataEntityModel.getName(), (boolean)true));
                    itemJsonObject.put("srfwfiatag", itemJsonObject.get("actionname"));
                    itemJsonObject.remove("actionname");
                    if (!StringHelper.isNullOrEmpty((String)strCallRetTimeFmt)) {
                        itemJsonObject = DataObject.convertJSONValueTimeFmt((JSONObject)itemJsonObject, (String)strCallRetTimeFmt);
                    }
                    ajaxActionResult.getRows().add(itemJsonObject);
                }
                ajaxActionResult.setTotalRow(list.size());
                return ajaxActionResult;
            }
            if (StringHelper.compare((String)strCall, (String)ACTION_SUBMITACTION, (boolean)true) == 0) {
                String strIATag = WebContext.getWFIATag((IWebContext)this.getWebContext());
                String strSubmitMemo = WebContext.getWFMemo((IWebContext)this.getWebContext());
                IEntity activeUserData = iDataEntityModel.createEntity();
                String strArg = WebContext.getRemoteCallArg((IWebContext)this.getWebContext());
                if (!StringHelper.isNullOrEmpty((String)strArg)) {
                    JSONObject joArg = JSONObject.fromString((String)strArg);
                    DataObject.fromJSONObject((IDataObject)activeUserData, (JSONObject)joArg);
                    iDataEntityModel.getService(this.getSessionFactory()).save(activeUserData);
                } else {
                    activeUserData.set(iDataEntityModel.getKeyDEField().getName(), (Object)strKey);
                    iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
                }
                String strActiveWFStepId = DataObject.getStringValue((IDataObject)activeUserData, (String)iDEWF.getWFStepField(), null);
                String strMemoField = "";
                IWFService iWFService = iDEWFModel.getWFModel().getWFService();
                IWFProcessModel iWFProcessModel = iDEWFModel.getWFModel().getLastWFVersionModel().getWFProcessModelByWFStepValue(strActiveWFStepId, false);
                if (iWFProcessModel instanceof IWFInteractiveProcessModel) {
                    IWFInteractiveProcessModel iWFInteractiveProcessModel = (IWFInteractiveProcessModel)iWFProcessModel;
                    IWFInteractiveLinkModel iWFInteractiveLinkModel = iWFInteractiveProcessModel.getWFInteractiveLinkModel(strIATag, true);
                    if (iWFInteractiveLinkModel != null) {
                        strMemoField = iWFInteractiveLinkModel.getMemoField();
                    }
                    if (StringHelper.isNullOrEmpty((String)strMemoField)) {
                        strMemoField = iWFInteractiveProcessModel.getMemoField();
                    }
                }
                String strLastSubmitMemo = "";
                if (!StringHelper.isNullOrEmpty((String)strMemoField)) {
                    IEntity iEntity2 = iDataEntityModel.createEntity();
                    strLastSubmitMemo = DataObject.getStringValue((IDataObject)activeUserData, (String)strMemoField, (String)"");
                    if (!StringHelper.isNullOrEmpty((String)strLastSubmitMemo)) {
                        strLastSubmitMemo = String.valueOf(strLastSubmitMemo) + "\r\n\r\n";
                    }
                    strLastSubmitMemo = String.valueOf(strLastSubmitMemo) + StringHelper.format((String)"%1$s %2$s \u5904\u7406:\r\n%3$s", (Object)this.getWebContext().getCurUserName(), (Object)DateHelper.getCurTimeString(), (Object)strSubmitMemo);
                    iEntity2.set(strMemoField, (Object)strLastSubmitMemo);
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
                ajaxActionResult.setRetCode(0);
                ajaxActionResult.setErrorInfo(wfActionResult.getReturnInfo());
                ajaxActionResult.getData(true).put("wfinstanceid", JSONObjectHelper.stripQuotes((String)wfActionResult.getInstanceId(), (boolean)true));
                return ajaxActionResult;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528[%1$s]", (Object)strCall));
        }
        catch (Exception ex) {
            AjaxActionResult ajaxActionResult = new AjaxActionResult();
            log.error((Object)StringHelper.format((String)"\u8fdc\u7a0b\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
    }
}

