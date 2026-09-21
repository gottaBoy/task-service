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
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.Page
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.psrt.srv.wf.service.WFInstanceService
 *  net.ibizsys.psrt.srv.wf.service.WFStepDataService
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswf.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.sf.json.JSONObject;

public class WFTraceChartPage
extends Page {
    private String strScript = "";

    protected void onInit() throws Exception {
        Iterator wfLinkModels;
        super.onInit();
        String strParentKey = WebContext.getParentKey((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strParentKey)) {
            return;
        }
        String strParentDEId = WebContext.getParentDEId((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strParentDEId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7236\u5b9e\u4f53\u6807\u793a");
        }
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)strParentDEId);
        IDEWF iDEWF = iDataEntityModel.getDefaultDEWF();
        if (iDEWF == null) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41", (Object)iDataEntityModel.getName()));
        }
        IEntity activeUserData = iDataEntityModel.createEntity();
        activeUserData.set(iDataEntityModel.getKeyDEField().getName(), (Object)strParentKey);
        iDataEntityModel.getService(this.getSessionFactory()).get(activeUserData);
        String strActiveWFInstId = DataObject.getStringValue((IDataObject)activeUserData, (String)iDEWF.getWFInstField(), null);
        if (StringHelper.isNullOrEmpty((String)strActiveWFInstId)) {
            return;
        }
        WFInstance wfInstance = new WFInstance();
        wfInstance.setWFInstanceId(strActiveWFInstId);
        WFInstanceService wfInstanceService = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class);
        wfInstanceService.get((IEntity)wfInstance);
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        StringBuilderEx sql = new StringBuilderEx();
        if (WebConfig.getCurrent().isLowCaseSql()) {
            sql.append("select t1.createdate,t1.createman,t1.deadline,t1.endtime,t1.fromwfstepid,t1.isfinish,t1.isinteractive,t1.lastactorid,t1.memo,t1.starttime,t1.tracestep,t1.updatedate,t1.updateman,t1.wfinstanceid,t1.wfplogicname,t1.wfpmodel,t1.wfpname,t1.wfstepid,t1.wfsteplanrestag,t1.wfstepname,t1.wfversion from t_srfwfstep t1  where t1.wfinstanceid =?   order by t1.tracestep ");
        } else {
            sql.append("select t1.* from t_srfwfstep t1  where t1.WFINSTANCEID =?   order by t1.tracestep ");
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(strActiveWFInstId);
        WFStepDataService wfStepDataService = (WFStepDataService)ServiceGlobal.getService(WFStepDataService.class);
        ArrayList list = wfStepDataService.selectRaw(sql.toString(), sqlParamList);
        HashMap<String, Integer> stepCountMap = new HashMap<String, Integer>();
        String strActiveStep = "";
        for (IEntity iEntity : list) {
            if (!DataObject.getBoolValue((IDataObject)iEntity, (String)"ISINTERACTIVE", (Boolean)false).booleanValue()) continue;
            String strWFStepValue = DataObject.getStringValue((IDataObject)iEntity, (String)"WFSTEPNAME", (String)"");
            Integer nLastCount = (Integer)stepCountMap.get(strWFStepValue);
            if (nLastCount == null) {
                nLastCount = 0;
            }
            nLastCount = nLastCount + 1;
            stepCountMap.put(strWFStepValue, nLastCount);
            if (DataObject.getBoolValue((IDataObject)iEntity, (String)"ISFINISH", (Boolean)false).booleanValue()) continue;
            strActiveStep = strWFStepValue;
        }
        IWFVersionModel iwfVersionModel = ((IDEWFModel)iDEWF).getWFModel().getWFVersionModelByWFVersion(wfInstance.getWFVersion().intValue());
        ArrayList<JSONObject> processObjectList = new ArrayList<JSONObject>();
        ArrayList<JSONObject> linkObjectList = new ArrayList<JSONObject>();
        Iterator wfProcessModels = iwfVersionModel.getWFProcessModels();
        IWFProcessModel activeWFProcessModel = null;
        if (wfProcessModels != null) {
            while (wfProcessModels.hasNext()) {
                IWFProcessModel iWFProcessModel = (IWFProcessModel)wfProcessModels.next();
                JSONObject item = new JSONObject();
                String strTips = "";
                item.put("wfprocesstype", JSONObjectHelper.stripQuotes((String)iWFProcessModel.getWFProcessType(), (boolean)true));
                String strPSWFProcessName = this.getLocalization(iWFProcessModel.getNameLanResTag(), iWFProcessModel.getName());
                item.put("pswfprocessname", JSONObjectHelper.stripQuotes((String)strPSWFProcessName, (boolean)true));
                item.put("pswfprocessid", JSONObjectHelper.stripQuotes((String)iWFProcessModel.getId(), (boolean)true));
                item.put("leftpos", iWFProcessModel.getLeftPos());
                item.put("toppos", iWFProcessModel.getTopPos());
                if (iWFProcessModel instanceof IWFInteractiveProcessModel) {
                    IWFInteractiveProcessModel iWFInteractiveProcessModel = (IWFInteractiveProcessModel)iWFProcessModel;
                    Integer nCount = (Integer)stepCountMap.get(iWFInteractiveProcessModel.getWFStepValue());
                    if (nCount == null) {
                        nCount = 0;
                    }
                    item.put("wfstepvalue", JSONObjectHelper.stripQuotes((String)iWFInteractiveProcessModel.getWFStepValue(), (boolean)true));
                    item.put("count", (Object)nCount);
                    boolean bActive = false;
                    if (StringHelper.compare((String)strActiveStep, (String)iWFInteractiveProcessModel.getWFStepValue(), (boolean)false) == 0) {
                        activeWFProcessModel = iWFProcessModel;
                        bActive = true;
                    }
                    item.put("active", bActive);
                    strTips = bActive ? (nCount == 1 ? "\u5f53\u524d\u73af\u8282" : StringHelper.format((String)"\u5f53\u524d\u73af\u8282\uff0c\u5df2\u6267\u884c[%1$s]\u6b21", (Object)nCount)) : (nCount >= 1 ? StringHelper.format((String)"\u5df2\u6267\u884c[%1$s]\u6b21", (Object)nCount) : "\u672a\u6267\u884c");
                }
                item.put("tips", JSONObjectHelper.stripQuotes((String)strTips, (boolean)true));
                processObjectList.add(item);
            }
        }
        if ((wfLinkModels = iwfVersionModel.getWFLinkModels()) != null) {
            while (wfLinkModels.hasNext()) {
                IWFLinkModel iWFLinkModel = (IWFLinkModel)wfLinkModels.next();
                JSONObject item = new JSONObject();
                item.put("frompswfprocid", JSONObjectHelper.stripQuotes((String)iWFLinkModel.getFrom(), (boolean)true));
                item.put("topswfprocid", JSONObjectHelper.stripQuotes((String)iWFLinkModel.getNext(), (boolean)true));
                item.put("srcendpoint", JSONObjectHelper.stripQuotes((String)iWFLinkModel.getSrcEndPoint(), (boolean)true));
                item.put("dstendpoint", JSONObjectHelper.stripQuotes((String)iWFLinkModel.getDstEndPoint(), (boolean)true));
                String strLinkName = iWFLinkModel.getLogicName();
                String strLNLanResTag = iWFLinkModel.getLNLanResTag();
                if (StringHelper.isNullOrEmpty((String)strLinkName)) {
                    strLinkName = iWFLinkModel.getName();
                }
                if (!StringHelper.isNullOrEmpty((String)strLNLanResTag)) {
                    strLinkName = this.getLocalization(strLNLanResTag, strLinkName);
                }
                item.put("label", JSONObjectHelper.stripQuotes((String)strLinkName, (boolean)true));
                linkObjectList.add(item);
            }
        }
        StringBuilderEx sbBuilderEx = new StringBuilderEx();
        for (JSONObject processObj : processObjectList) {
            sbBuilderEx.append("addProcess(%1$s);\r\n", (Object)processObj.toString());
        }
        for (JSONObject linkObj : linkObjectList) {
            sbBuilderEx.append("addConnection(%1$s);\r\n", (Object)linkObj.toString());
        }
        this.strScript = sbBuilderEx.toString();
    }

    protected String getLocalization(String strResId, String strDefault) {
        if (WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getLocalization(strResId, null, strDefault);
        }
        return strDefault;
    }

    public String outputScript() {
        return this.strScript;
    }
}

