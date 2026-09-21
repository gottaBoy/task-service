/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.client.ClientProtocolException
 *  org.apache.http.client.ResponseHandler
 *  org.apache.http.client.methods.HttpGet
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClients
 *  org.apache.http.util.EntityUtils
 */
package net.ibizsys.model;

import java.io.IOException;
import java.util.Vector;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.PSModelQueryHelperOAuthToken;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSAppFunc;
import net.ibizsys.model.entity.PSAppIndexView;
import net.ibizsys.model.entity.PSAppLan;
import net.ibizsys.model.entity.PSAppMenu;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.model.entity.PSAppMenuItemType;
import net.ibizsys.model.entity.PSAppModule;
import net.ibizsys.model.entity.PSAppPDTView;
import net.ibizsys.model.entity.PSAppPortalView;
import net.ibizsys.model.entity.PSAppPortalViewPart;
import net.ibizsys.model.entity.PSAppUIStyle;
import net.ibizsys.model.entity.PSAppUITheme;
import net.ibizsys.model.entity.PSAppUserMode;
import net.ibizsys.model.entity.PSAppUtilPage;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.entity.PSCodeItem;
import net.ibizsys.model.entity.PSCodeList;
import net.ibizsys.model.entity.PSControlType;
import net.ibizsys.model.entity.PSCounter;
import net.ibizsys.model.entity.PSCounterType;
import net.ibizsys.model.entity.PSDBType;
import net.ibizsys.model.entity.PSDBValueOP;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.model.entity.PSDEACModeItem;
import net.ibizsys.model.entity.PSDEAction;
import net.ibizsys.model.entity.PSDEActionLogic;
import net.ibizsys.model.entity.PSDEActionParam;
import net.ibizsys.model.entity.PSDEActionType;
import net.ibizsys.model.entity.PSDEChart;
import net.ibizsys.model.entity.PSDEChartAxes;
import net.ibizsys.model.entity.PSDEChartSeries;
import net.ibizsys.model.entity.PSDEDRDetail;
import net.ibizsys.model.entity.PSDEDRGroup;
import net.ibizsys.model.entity.PSDEDRItem;
import net.ibizsys.model.entity.PSDEDSDQ;
import net.ibizsys.model.entity.PSDEDSGroupParam;
import net.ibizsys.model.entity.PSDEDataQuery;
import net.ibizsys.model.entity.PSDEDataQueryCode;
import net.ibizsys.model.entity.PSDEDataQueryCodeCond;
import net.ibizsys.model.entity.PSDEDataQueryCodeExp;
import net.ibizsys.model.entity.PSDEDataRelation;
import net.ibizsys.model.entity.PSDEDataSet;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSDEFIUDetail;
import net.ibizsys.model.entity.PSDEFIUpdate;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleCond;
import net.ibizsys.model.entity.PSDEFValueRuleType;
import net.ibizsys.model.entity.PSDEFValueRuleTypeDetail;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDEFieldType;
import net.ibizsys.model.entity.PSDEForm;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.entity.PSDEFormItemVR;
import net.ibizsys.model.entity.PSDEGEIUDetail;
import net.ibizsys.model.entity.PSDEGEIUpdate;
import net.ibizsys.model.entity.PSDEGrid;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.entity.PSDEGridColumnType;
import net.ibizsys.model.entity.PSDEList;
import net.ibizsys.model.entity.PSDEListItem;
import net.ibizsys.model.entity.PSDELogic;
import net.ibizsys.model.entity.PSDELogicLink;
import net.ibizsys.model.entity.PSDELogicLinkCond;
import net.ibizsys.model.entity.PSDELogicLinkCondType;
import net.ibizsys.model.entity.PSDELogicLinkType;
import net.ibizsys.model.entity.PSDELogicNode;
import net.ibizsys.model.entity.PSDELogicNodeParam;
import net.ibizsys.model.entity.PSDELogicNodeType;
import net.ibizsys.model.entity.PSDELogicParam;
import net.ibizsys.model.entity.PSDEMainState;
import net.ibizsys.model.entity.PSDEMainStateAction;
import net.ibizsys.model.entity.PSDEMainStateOPPriv;
import net.ibizsys.model.entity.PSDEOPPriv;
import net.ibizsys.model.entity.PSDEPrint;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.model.entity.PSDERType;
import net.ibizsys.model.entity.PSDEToolbar;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.model.entity.PSDEUIActionGroupDetail;
import net.ibizsys.model.entity.PSDEUIActionType;
import net.ibizsys.model.entity.PSDEUtil;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.entity.PSDEViewCtrl;
import net.ibizsys.model.entity.PSDEViewView;
import net.ibizsys.model.entity.PSDRItemType;
import net.ibizsys.model.entity.PSDataEntity;
import net.ibizsys.model.entity.PSDepSlnSys;
import net.ibizsys.model.entity.PSDynaAppView;
import net.ibizsys.model.entity.PSDynaInst;
import net.ibizsys.model.entity.PSEditorType;
import net.ibizsys.model.entity.PSFDLogicType;
import net.ibizsys.model.entity.PSFormDetailType;
import net.ibizsys.model.entity.PSFormType;
import net.ibizsys.model.entity.PSLanguageItem;
import net.ibizsys.model.entity.PSLanguageRes;
import net.ibizsys.model.entity.PSPF;
import net.ibizsys.model.entity.PSPFCtrlTempl;
import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.entity.PSPFPluginTempl;
import net.ibizsys.model.entity.PSPFPubCode;
import net.ibizsys.model.entity.PSPFStyle;
import net.ibizsys.model.entity.PSPortletType;
import net.ibizsys.model.entity.PSSysCounter;
import net.ibizsys.model.entity.PSSysCss;
import net.ibizsys.model.entity.PSSysDBValueFunc;
import net.ibizsys.model.entity.PSSysDEFType;
import net.ibizsys.model.entity.PSSysDashboard;
import net.ibizsys.model.entity.PSSysDashboardPart;
import net.ibizsys.model.entity.PSSysEditorStyle;
import net.ibizsys.model.entity.PSSysImage;
import net.ibizsys.model.entity.PSSysModelInst;
import net.ibizsys.model.entity.PSSysPDTView;
import net.ibizsys.model.entity.PSSysPFPlugin;
import net.ibizsys.model.entity.PSSysPFPluginTempl;
import net.ibizsys.model.entity.PSSysPortlet;
import net.ibizsys.model.entity.PSSysUniRes;
import net.ibizsys.model.entity.PSSysValueRule;
import net.ibizsys.model.entity.PSSysWFSetting;
import net.ibizsys.model.entity.PSSystem;
import net.ibizsys.model.entity.PSSystemApplication;
import net.ibizsys.model.entity.PSToolbarItemType;
import net.ibizsys.model.entity.PSViewType;
import net.ibizsys.model.entity.PSWFDE;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFLinkCond;
import net.ibizsys.model.entity.PSWFLinkCondType;
import net.ibizsys.model.entity.PSWFLinkType;
import net.ibizsys.model.entity.PSWFProcParam;
import net.ibizsys.model.entity.PSWFProcRole;
import net.ibizsys.model.entity.PSWFProcSubWF;
import net.ibizsys.model.entity.PSWFProcess;
import net.ibizsys.model.entity.PSWFProcessType;
import net.ibizsys.model.entity.PSWFRole;
import net.ibizsys.model.entity.PSWFVersion;
import net.ibizsys.model.entity.PSWorkflow;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PSModelQueryHelperRestImpl
implements IPSModelQueryHelper {
    private static final Log log = LogFactory.getLog(PSModelQueryHelperRestImpl.class);
    private final String AUTHORIZATION = "Authorization";
    private final String BEARER = "Bearer ";
    private PSModelQueryHelperOAuthToken psModelQueryHelperOAuthToken = new PSModelQueryHelperOAuthToken();
    private String strPSSysModelInstId = null;
    private String strServiceUrl = null;
    PSResponseHandler responseHandler = new PSResponseHandler();
    CloseableHttpClient httpclient = HttpClients.createDefault();

    public void init(String strPSSysModelInstId, String strServiceUrl) throws Exception {
        this.strPSSysModelInstId = strPSSysModelInstId;
        this.strServiceUrl = strServiceUrl;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    @Override
    public void active() {
    }

    @Override
    public boolean isAlwaysActive() {
        return false;
    }

    @Override
    public void activeAlways() {
    }

    @Override
    public long getLastActiveTime() {
        return 0L;
    }

    @Override
    public void setModelInstVer(int nModelInstVer) {
    }

    @Override
    public void startLoadPSSysApp(String strPSSysAppId, int nLoadLevel) throws Exception {
    }

    @Override
    public void stopLoadPSSysApp() throws Exception {
    }

    @Override
    public void startLoadPSSystem(String strPSSystemId, int nLoadLevel) throws Exception {
    }

    @Override
    public void stopLoadPSSystem() throws Exception {
    }

    @Override
    public CallResult getPSDBType(String strPSDBTypeId, PSDBType psDBType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdbtype/%1$s"), (Object)strPSDBTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDBType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSystem(String strPSSystemId, PSSystem psSystem) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssystem/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSystem, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysModelInst(String strPSSysModelInstId, PSSysModelInst psSysModelInst) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysmodelinst/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysModelInstId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysModelInst, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppViewRefs(String strPSAppViewId, Vector<PSAppViewRef> psAppViewRefList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappviewrefs/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppViewRef psAppViewRef = new PSAppViewRef();
                    DataObject.fromJSONObject((IDataObject)psAppViewRef, (JSONObject)json);
                    psAppViewRefList.add(psAppViewRef);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViewBase(String strPSDEViewBaseId, PSDEViewBase psDEViewBase) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeviewbase/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEViewBaseId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEViewBase, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViewViews(String strPSDEViewId, Vector<PSDEViewView> psDEViewViewList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeviewviews/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEViewView item = new PSDEViewView();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEViewViewList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViewCtrls(String strPSDEViewId, Vector<PSDEViewCtrl> psDEViewCtrlList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeviewctrls/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEViewCtrl item = new PSDEViewCtrl();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEViewCtrlList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSApplicationView(String strPSApplicationViewId, PSAppView psApplicationView) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psapplicationview/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSApplicationViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psApplicationView, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppIndexView(String strPSAppIndexViewId, PSAppIndexView psAppIndexView) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappindexview/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppIndexViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppIndexView, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppPortalView(String strPSAppPortalViewId, PSAppPortalView psAppPortalView) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappportalview/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppPortalViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppPortalView, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppMenuItems(String strPSAppMenuId, Vector<PSAppMenuItem> psAppMenuItemList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappmenuitems/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppMenuId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppMenuItem psAppMenuItem = new PSAppMenuItem();
                    DataObject.fromJSONObject((IDataObject)psAppMenuItem, (JSONObject)json);
                    psAppMenuItemList.add(psAppMenuItem);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppMenu(String strPSAppMenuId, PSAppMenu psAppMenu) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappmenu/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppMenuId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppMenu, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGrid(String strPSDEGridId, PSDEGrid psDEGrid) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdegrid/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEGridId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEGrid, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEToolbar(String strPSDEToolbarId, PSDEToolbar psDEToolbar) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdetoolbar/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEToolbarId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEToolbar, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFormItemVRs(String strPSDEFormId, Vector<PSDEFormItemVR> psDEFormItemVRList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeformitemvrs/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFormId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFormItemVR item = new PSDEFormItemVR();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFormItemVRList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFIUDetails(String strPSDEFormId, Vector<PSDEFIUDetail> psDEFIUDetailList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefiudetails/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFormId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFIUDetail item = new PSDEFIUDetail();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFIUDetailList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFIUpdates(String strPSDEFormId, Vector<PSDEFIUpdate> psDEFIUpdateList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefiupdates/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFormId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFIUpdate item = new PSDEFIUpdate();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFIUpdateList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFormDetails(String strPSDEFormId, Vector<PSDEFormDetail> psDEFormDetailList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeformdetails/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFormId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFormDetail item = new PSDEFormDetail();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFormDetailList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEForm(String strPSDEFormId, PSDEForm psDEForm) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeform/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFormId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEForm, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFDLogics(String strPSDEFormId, Vector<PSDEFDLogic> psDEFDLogicList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefdlogics/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFormId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFDLogic item = new PSDEFDLogic();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFDLogicList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGridColumns(String strPSDEGridId, Vector<PSDEGridColumn> psDEGridColumnList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdegridcolumns/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEGridId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEGridColumn item = new PSDEGridColumn();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEGridColumnList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGEIUpdates(String strPSDEGridId, Vector<PSDEGEIUpdate> psDEGEIUpdateList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdegeiupdates/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEGridId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEGEIUpdate item = new PSDEGEIUpdate();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEGEIUpdateList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGEIUDetails(String strPSDEGridId, Vector<PSDEGEIUDetail> psDEGEIUDetailList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdegeiudetails/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEGridId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEGEIUDetail item = new PSDEGEIUDetail();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEGEIUDetailList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEToolbarItems(String strPSDEToolbarId, Vector<PSDEToolbarItem> psDEToolbarItemList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdetoolbaritems/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEToolbarId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEToolbarItem item = new PSDEToolbarItem();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEToolbarItemList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDashboard(String strPSSysDashboardId, PSSysDashboard psSysDashboard) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysdashboard/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysDashboardId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysDashboard, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDashboardParts(String strPSSysDashboardId, Vector<PSSysDashboardPart> psSysDashboardPartList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysdashboardparts/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysDashboardId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysDashboardPart item = new PSSysDashboardPart();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysDashboardPartList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEList(String strPSDEListId, PSDEList psDEList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelist/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEListId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEList, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEListItems(String strPSDEListId, Vector<PSDEListItem> psDEListItemList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelistitems/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEListId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEListItem item = new PSDEListItem();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEListItemList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEChart(String strPSDEChartId, PSDEChart psDEChart) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdechart/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEChartId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEChart, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEChartAxeses(String strPSDEChartId, Vector<PSDEChartAxes> psDEChartAxesList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdechartaxeses/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEChartId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEChartAxes item = new PSDEChartAxes();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEChartAxesList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEChartSerieses(String strPSDEChartId, Vector<PSDEChartSeries> psDEChartSeriesList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdechartserieses/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEChartId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEChartSeries item = new PSDEChartSeries();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEChartSeriesList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppPortalViewParts(String strPSAppPortalViewId, Vector<PSAppPortalViewPart> psAppPortalViewPartList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappportalviewparts/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppPortalViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppPortalViewPart item = new PSAppPortalViewPart();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppPortalViewPartList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDepSlnSys(String strPSDepSlnSysId, PSDepSlnSys psDepSlnSys) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdepslnsys/%1$s"), (Object)strPSDepSlnSysId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDepSlnSys, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSCodeItems(String strPSCodeListId, Vector<PSCodeItem> psCodeItemList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pscodeitems/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSCodeListId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSCodeItem item = new PSCodeItem();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psCodeItemList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSCodeList(String strPSCodeListId, PSCodeList psCodeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pscodelist/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSCodeListId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psCodeList, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSCodeLists(String strPSSystemId, Vector<PSCodeList> psCodeListList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpscodelists/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSCodeList item = new PSCodeList();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psCodeListList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysCsses(String strPSSystemId, Vector<PSSysCss> psSysCssList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssyscsses/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysCss item = new PSSysCss();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysCssList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysCss(String strPSSysCssId, PSSysCss psSysCss) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssyscss/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysCssId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysCss, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysImages(String strPSSystemId, Vector<PSSysImage> psSysImageList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssysimages/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysImage item = new PSSysImage();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysImageList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysImage(String strPSSysImageId, PSSysImage psSysImage) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysimage/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysImageId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysImage, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysWFSetting(String strPSSystemId, PSSysWFSetting psSysWFSetting) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssyswfsetting/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysWFSetting, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDataEntity(String strPSSystemId, String strPSDataEntityName, PSDataEntity psDataEntity) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdataentitybyname/%1$s/%2$s/%3$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId, (Object)strPSDataEntityName));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDataEntity, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDataEntity(String strPSDataEntityId, PSDataEntity psDataEntity) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdataentity/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDataEntity, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDER(String strPSDERId, PSDER psDER) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psder/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDERId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDER, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEField(String strPSDEFieldId, PSDEField psDEField) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefield/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFieldId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEField, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFieldsNoSort(String strPSDataEntityId, Vector<PSDEField> psDEFieldList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefieldsnosort/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEField item = new PSDEField();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFieldList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEAction(String strPSDEActionId, PSDEAction psDEAction) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeaction/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEActionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEAction, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEActions(String strPSDataEntityId, Vector<PSDEAction> psDEActionList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeactions/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEAction item = new PSDEAction();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEActionList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEActionParams(String strPSDEActionId, Vector<PSDEActionParam> psDEActionParamList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeactionparams/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEActionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEActionParam item = new PSDEActionParam();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEActionParamList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEActionLogics(String strPSDEActionId, Vector<PSDEActionLogic> psDEActionLogicList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeactionlogics/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEActionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEActionLogic item = new PSDEActionLogic();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEActionLogicList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogic(String strPSDELogicId, PSDELogic psDELogic) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogic/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDELogicId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDELogic, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActionGroup(String strPSDEUIActionGroupId, PSDEUIActionGroup psDEUIActionGroup) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeuiactiongroup/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEUIActionGroupId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEUIActionGroup, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIAction(String strPSDEUIActionId, PSDEUIAction psDEUIAction) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeuiaction/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEUIActionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEUIAction, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDEUIActions(String strPSSystemId, Vector<PSDEUIAction> psDEUIActionList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysdeuiactions/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEUIAction item = new PSDEUIAction();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEUIActionList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActions(String strPSDataEntityId, Vector<PSDEUIAction> psDEUIActionList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeuiactions/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEUIAction item = new PSDEUIAction();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEUIActionList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEACModes(String strPSDataEntityId, Vector<PSDEACMode> psDEACModeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeacmodes/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEACMode item = new PSDEACMode();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEACModeList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEACMode(String strPSDEACModeId, PSDEACMode psDEACMode) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeacmode/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEACModeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEACMode, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActionGroups(String strPSDataEntityId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeuiactiongroups/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEUIActionGroup item = new PSDEUIActionGroup();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEUIActionGroupList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActionGroupDetails(String strPSDEUIActionGroupId, Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeuiactiongroupdetails/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEUIActionGroupId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEUIActionGroupDetail item = new PSDEUIActionGroupDetail();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEUIActionGroupDetailList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUIActionType(String strPSDEUIActionTypeId, PSDEUIActionType psDEUIActionType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeuiactiontype/%1$s"), (Object)strPSDEUIActionTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEUIActionType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDEUIActionGroups(String strPSSystemId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysdeuiactiongroups/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEUIActionGroup item = new PSDEUIActionGroup();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEUIActionGroupList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeviews/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEViewBase item = new PSDEViewBase();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEViewBaseList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEPredefinedViews(String strPSDataEntityId, Vector<PSDEViewBase> psDEViewBaseList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdepredefinedviews/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEViewBase item = new PSDEViewBase();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEViewBaseList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEPrints(String strPSDEId, Vector<PSDEPrint> psDEPrintList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeprints/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEPrint item = new PSDEPrint();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEPrintList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDERs(String strPSDataEntityId, Vector<PSDER> psDERList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psders/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDER item = new PSDER();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDERList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFUIModesByDataEntity(String strPSDEId, Vector<PSDEFUIMode> psDEFUIModeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefuimodesbydataentity/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFUIMode item = new PSDEFUIMode();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFUIModeList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFSearchModesByDataEntity(String strPSDEId, Vector<PSDEFSearchMode> psDEFSearchModeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefsearchmodesbydataentity/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFSearchMode item = new PSDEFSearchMode();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFSearchModeList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFValueRulesByDataEntity(String strPSDEId, Vector<PSDEFValueRule> psDEFValueRuleList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefvaluerulesbydataentity/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFValueRule item = new PSDEFValueRule();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFValueRuleList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQuery(String strPSDEDataQueryId, PSDEDataQuery psDEDataQuery) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedataquery/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEDataQueryId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEDataQuery, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueries(String strPSDataEntityId, Vector<PSDEDataQuery> psDEDataQueryList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedataqueries/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDataQuery item = new PSDEDataQuery();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDataQueryList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueryCodes(String strPSDEDataQueryId, Vector<PSDEDataQueryCode> psDEDataQueryCodeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedataquerycodes/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEDataQueryId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDataQueryCode item = new PSDEDataQueryCode();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDataQueryCodeList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueryCode(String strPSDEDataQueryCodeId, PSDEDataQueryCode psDEDataQueryCode) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedataquerycode/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEDataQueryCodeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEDataQueryCode, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueryCodeExps(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedataquerycodeexps/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEDataQueryCodeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDataQueryCodeExp item = new PSDEDataQueryCodeExp();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDataQueryCodeExpList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataQueryCodeConds(String strPSDEDataQueryCodeId, Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedataquerycodeconds/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEDataQueryCodeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDataQueryCodeCond item = new PSDEDataQueryCodeCond();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDataQueryCodeCondList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataSet(String strPSDEDataSetId, PSDEDataSet psDEDataSet) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedataset/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEDataSetId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEDataSet, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataSets(String strPSDataEntityId, Vector<PSDEDataSet> psDEDataSetList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedatasets/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDataSet item = new PSDEDataSet();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDataSetList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDSDQs(String strPSDataSetId, Vector<PSDEDSDQ> psDEDSDQList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedsdqs/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataSetId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDSDQ item = new PSDEDSDQ();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDSDQList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDSGroupParams(String strPSDataSetId, Vector<PSDEDSGroupParam> psDEDSGroupParamList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedsgroupparams/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataSetId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDSGroupParam item = new PSDEDSGroupParam();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDSGroupParamList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAjaxControlHandlers(String strPSDataEntityId, Vector<PSACHandler> psAjaxControlHandlerList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psajaxcontrolhandlers/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSACHandler item = new PSACHandler();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAjaxControlHandlerList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEActionType(String strPSDEActionTypeId, PSDEActionType psDEActionType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeactiontype/%1$s"), (Object)strPSDEActionTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEActionType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogics(String strPSDataEntityId, Vector<PSDELogic> psDELogicList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogics/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDELogic item = new PSDELogic();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDELogicList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicParams(String strPSDELogicId, Vector<PSDELogicParam> psDELogicParamList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogicparams/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDELogicId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDELogicParam item = new PSDELogicParam();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDELogicParamList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicNodes(String strPSDELogicId, Vector<PSDELogicNode> psDELogicNodeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogicnodes/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDELogicId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDELogicNode item = new PSDELogicNode();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDELogicNodeList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicLinks(String strPSDELogicId, Vector<PSDELogicLink> psDELogicLinkList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogiclinks/%1$s/%2$s"), (Object)this.strPSSysModelInstId, psDELogicLinkList));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDELogicLink item = new PSDELogicLink();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDELogicLinkList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicNodeParams(String strPSDELogicId, Vector<PSDELogicNodeParam> psDELogicNodeParamList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogicnodeparams/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDELogicId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDELogicNodeParam item = new PSDELogicNodeParam();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDELogicNodeParamList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicLinkConds(String strPSDELogicId, Vector<PSDELogicLinkCond> psDELogicLinkCondList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogiclinkconds/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDELogicId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDELogicLinkCond item = new PSDELogicLinkCond();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDELogicLinkCondList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicLinkCondType(String strPSDELogicLinkCondTypeId, PSDELogicLinkCondType psDELogicLinkCondType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogiclinkcondtype/%1$s"), (Object)strPSDELogicLinkCondTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDELogicLinkCondType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicNodeType(String strPSDELogicNodeTypeId, PSDELogicNodeType psDELogicNodeType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogicnodetype/%1$s"), (Object)strPSDELogicNodeTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDELogicNodeType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDELogicLinkType(String strPSDELogicLinkTypeId, PSDELogicLinkType psDELogicLinkType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdelogiclinktype/%1$s"), (Object)strPSDELogicLinkTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDELogicLinkType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEACModeItems(String strPSDEACModeId, Vector<PSDEACModeItem> psDEACModeItemList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeacmodeitems/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEACModeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEACModeItem item = new PSDEACModeItem();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEACModeItemList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDRDetails(String strPSDEDRId, Vector<PSDEDRDetail> psDEDRDetailList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedrdetails/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEDRId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDRDetail item = new PSDEDRDetail();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDRDetailList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDataRelations(String strPSDEId, Vector<PSDEDataRelation> psDEDataRelationList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedatarelations/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDataRelation item = new PSDEDataRelation();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDataRelationList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDRGroups(String strPSDataEntityId, Vector<PSDEDRGroup> psDEDRGroupList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedrgroups/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDRGroup item = new PSDEDRGroup();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDRGroupList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEDRItems(String strPSDEId, Vector<PSDEDRItem> psDEDRItemList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdedritems/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEDRItem item = new PSDEDRItem();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEDRItemList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDRItemType(String strPSDRItemTypeId, PSDRItemType psDRItemType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdritemtype/%1$s"), (Object)strPSDRItemTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDRItemType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFDEs(String strPSDataEntityId, Vector<PSWFDE> psWFDEList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfdes/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFDE item = new PSWFDE();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFDEList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEMainStateOPPrivs(String strPSDEMainStateId, Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdemainstateopprivs/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEMainStateId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEMainStateOPPriv item = new PSDEMainStateOPPriv();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEMainStateOPPrivList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEMainStateActions(String strPSDEMainStateId, Vector<PSDEMainStateAction> psDEMainStateActionList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdemainstateactions/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEMainStateId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEMainStateAction item = new PSDEMainStateAction();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEMainStateActionList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEMainStates(String strPSDEId, Vector<PSDEMainState> psDEMainStateList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdemainstates/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEMainState item = new PSDEMainState();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEMainStateList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysDEFTypes(String strPSSystemId, Vector<PSSysDEFType> psSysDEFTypeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssysdeftypes/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysDEFType item = new PSSysDEFType();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysDEFTypeList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDEFType(String strPSSysDEFTypeId, PSSysDEFType psSysDEFType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysdeftype/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysDEFTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysDEFType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFValueRuleConds(String strPSDEFValueRuleId, Vector<PSDEFValueRuleCond> psDEFValueRuleCondList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefvalueruleconds/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFValueRuleId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFValueRuleCond item = new PSDEFValueRuleCond();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFValueRuleCondList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFValueRuleTypeDetail(String strPSDEFValueRuleTypeDetailId, PSDEFValueRuleTypeDetail psDEFValueRuleTypeDetail) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefvalueruletypedetail/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEFValueRuleTypeDetailId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEFValueRuleTypeDetail, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFValueRuleType(String strPSDEFValueRuleTypeId, PSDEFValueRuleType psDEFValueRuleType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdefvalueruletype/%1$s"), (Object)strPSDEFValueRuleTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEFValueRuleType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSDEFieldTypes(Vector<PSDEFieldType> psDEFieldTypes) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsdefieldtypes")));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEFieldType item = new PSDEFieldType();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEFieldTypes.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSDERs(String strPSSystemId, Vector<PSDER> psDataEntityList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsders/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDER item = new PSDER();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDataEntityList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDERType(String strPSDERTypeId, PSDERType psDERType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdertype/%1$s"), (Object)strPSDERTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDERType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDERsByMinorDEId(String strPSDataEntityId, Vector<PSDER> psDERList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdersbyminordeid/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDataEntityId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDER item = new PSDER();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDERList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEUtils(String strPSDEId, Vector<PSDEUtil> psDEUtilList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeutils/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEUtil item = new PSDEUtil();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEUtilList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysLans(String strPSSystemId, Vector<PSAppLan> psAppLans) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssyslans/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppLan item = new PSAppLan();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppLans.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSLanguageItems(String strPSSystemId, Vector<PSLanguageItem> psLanguageItemList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpslanguageitems/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSLanguageItem item = new PSLanguageItem();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psLanguageItemList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSLanguageReses(String strPSSystemId, Vector<PSLanguageRes> psLanguageResList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpslanguagereses/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSLanguageRes item = new PSLanguageRes();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psLanguageResList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysValueRule(String strPSSysValueRuleId, PSSysValueRule psSysValueRule) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysvaluerule/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysValueRuleId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysValueRule, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysValueRules(String strPSSystemId, Vector<PSSysValueRule> psSysValueRuleList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssysvaluerules/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysValueRule item = new PSSysValueRule();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysValueRuleList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysPortlet(String strPSSysPortletId, PSSysPortlet psSysPortlet) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysportlet/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysPortletId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysPortlet, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysPortlets(String strPSSystemId, Vector<PSSysPortlet> psSysPortletList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssysportlets/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysPortlet item = new PSSysPortlet();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysPortletList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysPDTViews(String strPSSystemId, Vector<PSSysPDTView> psSysPDTViewList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssyspdtviews/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysPDTView item = new PSSysPDTView();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysPDTViewList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysPDTView(String strPSSysPDTViewId, PSSysPDTView psSysPDTView) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssyspdtview/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysPDTViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysPDTView, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSystemApplication(String strPSSystemApplicationId, PSSystemApplication psSystemApplication) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssystemapplication/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemApplicationId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSystemApplication, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSystemApplications(String strPSSystemId, Vector<PSSystemApplication> psSystemApplicationList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssystemapplications/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSystemApplication item = new PSSystemApplication();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSystemApplicationList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSViewType(String strPSViewTypeId, PSViewType psViewType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psviewtype/%1$s"), (Object)strPSViewTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psViewType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSApplicationViews(String strPSApplicationId, Vector<PSAppView> psApplicationViews) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsapplicationviews/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSApplicationId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppView item = new PSAppView();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psApplicationViews.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppFunc(String strPSAppFuncId, PSAppFunc psAppFunc) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappfunc/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppFuncId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppFunc, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppUserMode(String strPSAppUserModeId, PSAppUserMode psAppUserMode) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappusermode/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppUserModeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppUserMode, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppUtilPage(String strPSAppUtilPageId, PSAppUtilPage psAppUtilPage) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psapputilpage/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppUtilPageId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppUtilPage, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppUIStyle(String strPSAppUIStyleId, PSAppUIStyle psAppUIStyle) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappuistyle/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppUIStyleId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppUIStyle, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppUITheme(String strPSAppUIThemeId, PSAppUITheme psAppUITheme) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappuitheme/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppUIThemeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppUITheme, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppMenus(String strPSApplicationId, Vector<PSAppMenu> psAppMenus) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsappmenus/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSApplicationId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppMenu item = new PSAppMenu();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppMenus.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppUtilPages(String strPSApplicationId, Vector<PSAppUtilPage> psAppUtilPages) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsapputilpages/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSApplicationId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppUtilPage item = new PSAppUtilPage();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppUtilPages.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppLans(String strPSApplicationId, Vector<PSAppLan> psAppLans) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsapplans/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSApplicationId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppLan item = new PSAppLan();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppLans.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppLan(String strPSAppLanId, PSAppLan psAppLan) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psapplan/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppLanId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppLan, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppFuncs(String strPSApplicationId, Vector<PSAppFunc> psAppFuncs) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsappfuncs/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSApplicationId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppFunc item = new PSAppFunc();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppFuncs.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysAjaxControlHandlers(String strPSSystemId, Vector<PSACHandler> psAjaxControlHandlerList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysajaxcontrolhandlers/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSACHandler item = new PSACHandler();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAjaxControlHandlerList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFDEsByWF(String strPSWFId, Vector<PSWFDE> psWFDEList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfdesbywf/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFDE item = new PSWFDE();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFDEList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFLinkCondType(String strPSWFLinkCondTypeId, PSWFLinkCondType psWFLinkCondType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswflinkcondtype/%1$s"), (Object)strPSWFLinkCondTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psWFLinkCondType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFLinkType(String strPSWFLinkTypeId, PSWFLinkType psWFLinkType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswflinktype/%1$s"), (Object)strPSWFLinkTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psWFLinkType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcessType(String strPSWFProcessTypeId, PSWFProcessType psWFProcessType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfprocesstype/%1$s"), (Object)strPSWFProcessTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psWFProcessType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSWFRoles(String strPSSystemId, Vector<PSWFRole> psWFRoleList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpswfroles/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFRole item = new PSWFRole();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFRoleList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFUIActions(String strPSWFVersionId, Vector<PSDEUIAction> psDEUIActionList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfuiactions/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFVersionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEUIAction item = new PSDEUIAction();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEUIActionList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFUIActionGroups(String strPSWFVersionId, Vector<PSDEUIActionGroup> psDEUIActionGroupList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfuiactiongroups/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFVersionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEUIActionGroup item = new PSDEUIActionGroup();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEUIActionGroupList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFVersions(String strPSWFId, Vector<PSWFVersion> psVersionList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfversions/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFVersion item = new PSWFVersion();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psVersionList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcesses(String strPSWFVersionId, Vector<PSWFProcess> psWFProcessList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfprocesses/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFVersionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFProcess item = new PSWFProcess();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFProcessList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFLinks(String strPSWFVersionId, Vector<PSWFLink> psWFLinkList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswflinks/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFVersionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFLink item = new PSWFLink();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFLinkList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcParams(String strPSWFVersionId, Vector<PSWFProcParam> psWFProcParamList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfprocparams/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFVersionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFProcParam item = new PSWFProcParam();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFProcParamList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcSubWFs(String strPSWFVersionId, Vector<PSWFProcSubWF> psWFProcSubWFList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfprocsubwfs/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFVersionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFProcSubWF item = new PSWFProcSubWF();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFProcSubWFList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFLinkConds(String strPSWFVersionId, Vector<PSWFLinkCond> psWFLinkCondList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswflinkconds/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFVersionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFLinkCond item = new PSWFLinkCond();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFLinkCondList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFProcRoles(String strPSWFVersionId, Vector<PSWFProcRole> psWFProcRoleList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfprocroles/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWFVersionId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFProcRole item = new PSWFProcRole();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFProcRoleList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSWorkflows(String strPSSystemId, Vector<PSWorkflow> psWorkflowList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsworkflows/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWorkflow item = new PSWorkflow();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWorkflowList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysCounter(String strPSSysCounterId, PSSysCounter psSysCounter) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssyscounter/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysCounterId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysCounter, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSCounterType(String strPSCounterTypeId, PSCounterType psCounterType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pscountertype/%1$s"), (Object)strPSCounterTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psCounterType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysCounters(String strPSSystemId, Vector<PSSysCounter> psSysCounterList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssyscounters/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysCounter item = new PSSysCounter();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysCounterList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysEditorStyles(String strPSSystemId, Vector<PSSysEditorStyle> psSysEditorStyleList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssyseditorstyles/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysEditorStyle item = new PSSysEditorStyle();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysEditorStyleList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysUniRes(String strPSSysUniResId, PSSysUniRes psSysUniRes) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysunires/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysUniResId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysUniRes, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysUniReses(String strPSSystemId, Vector<PSSysUniRes> psSysUniResList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssysunireses/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysUniRes item = new PSSysUniRes();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysUniResList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysDBValueFunc(String strPSSysDBValueFuncId, PSSysDBValueFunc psSysDBValueFunc) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssysdbvaluefunc/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysDBValueFuncId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysDBValueFunc, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEOPPriv(String strPSDEOPPrivId, PSDEOPPriv psDEOPPriv) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeoppriv/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDEOPPrivId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEOPPriv, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEOPPrivsBySystem(String strPSSystemId, Vector<PSDEOPPriv> psDEOPPrivList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeopprivsbysystem/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEOPPriv item = new PSDEOPPriv();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEOPPrivList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSEditorType(String strPSEditorTypeId, PSEditorType psEditorType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pseditortype/%1$s"), (Object)strPSEditorTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psEditorType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDBValueOP(String strPSDBValueOPId, PSDBValueOP psDBValueOP) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdbvalueop/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDBValueOPId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDBValueOP, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSCounter(String strPSCounterId, PSCounter psCounter) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pscounter/%1$s"), (Object)strPSCounterId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psCounter, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPortletType(String strPSPortletTypeId, PSPortletType psPortletType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psportlettype/%1$s"), (Object)strPSPortletTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psPortletType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSFormDetailType(String strPSFormDetailTypeId, PSFormDetailType psFormDetailType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psformdetailtype/%1$s"), (Object)strPSFormDetailTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psFormDetailType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSFormType(String strPSFormTypeId, PSFormType psFormType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psformtype/%1$s"), (Object)strPSFormTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psFormType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSFDLogicType(String strPSFDLogicTypeId, PSFDLogicType psFDLogicType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psfdlogictype/%1$s"), (Object)strPSFDLogicTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psFDLogicType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSControlType(String strPSControlTypeId, PSControlType psControlType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pscontroltype/%1$s"), (Object)strPSControlTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psControlType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSToolbarItemType(String strPSToolbarItemTypeId, PSToolbarItemType psToolbarItemType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pstoolbaritemtype/%1$s"), (Object)strPSToolbarItemTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psToolbarItemType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEGridColumnType(String strPSDEGridColumnTypeId, PSDEGridColumnType psDEGridColumnType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdegridcolumntype/%1$s"), (Object)strPSDEGridColumnTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDEGridColumnType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppMenuItemType(String strPSAppMenuItemTypeId, PSAppMenuItemType psAppMenuItemType) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappmenuitemtype/%1$s"), (Object)strPSAppMenuItemTypeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppMenuItemType, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDynaAppView(String strPSDynaAppViewId, PSDynaAppView psDynaAppView) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdynaappview/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDynaAppViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDynaAppView, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppViewLastModifyTimes(String strPSSysAppId, Vector<PSAppView> psAppViewList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsappviewlastmodifytimes/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysAppId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppView item = new PSAppView();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppViewList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppModules(String strPSApplicationId, Vector<PSAppModule> psAppModules) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsappmodules/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSApplicationId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppModule item = new PSAppModule();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppModules.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppModule(String strPSAppModuleId, PSAppModule psAppModule) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psappmodule/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppModuleId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppModule, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPF(String strPSPFId, PSPF psPF) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspf/%1$s"), (Object)strPSPFId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psPF, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFCtrlTemplDetails(String strPSPFCtrlTemplId, Vector<PSPFCtrlTemplDetail> psPFCtrlTemplDetailList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfctrltempldetails/%1$s"), (Object)strPSPFCtrlTemplId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSPFCtrlTemplDetail item = new PSPFCtrlTemplDetail();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psPFCtrlTemplDetailList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFStyle(String strPSPFStyleId, PSPFStyle psPFStyle) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfstyle/%1$s"), (Object)strPSPFStyleId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psPFStyle, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFCtrlTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFCtrlTempl> psPFViewTemplList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfctrltemplsbypfstyle/%1$s"), (Object)strPSPFStyleId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSPFCtrlTempl item = new PSPFCtrlTempl();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psPFViewTemplList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFEditorTemplsByPFStyle(String strPSPFStyleId, Vector<PSPFEditorTempl> psPFViewTemplList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfeditortemplsbypfstyle/%1$s"), (Object)strPSPFStyleId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSPFEditorTempl item = new PSPFEditorTempl();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psPFViewTemplList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFPubCodes(String strPSPFId, Vector<PSPFPubCode> psPFPubCodeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfpubcodes/%1$s"), (Object)strPSPFId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSPFPubCode item = new PSPFPubCode();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psPFPubCodeList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFPubCode(String strPSPFPubCodeId, PSPFPubCode psPFPubCode) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfpubcode/%1$s"), (Object)strPSPFPubCodeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psPFPubCode, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFEditorTemplsByPF(String strPSPFId, Vector<PSPFEditorTempl> psPFViewTemplList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfeditortemplsbypf/%1$s"), (Object)strPSPFId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSPFEditorTempl item = new PSPFEditorTempl();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psPFViewTemplList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFPubCodesByPPSPFPubCode(String strPSPFPubCodeId, Vector<PSPFPubCode> psPFPubCodeList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfpubcodesbyppspfpubcode/%1$s"), (Object)strPSPFPubCodeId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSPFPubCode item = new PSPFPubCode();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psPFPubCodeList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSPFPluginTempl(String strPSPFPluginTemplId, PSPFPluginTempl psPFPluginTempl) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pspfplugintempl/%1$s"), (Object)strPSPFPluginTemplId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psPFPluginTempl, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysPFPlugin(String strPSSysPFPluginId, PSSysPFPlugin psSysPFPlugin) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssyspfplugin/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysPFPluginId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysPFPlugin, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSSysPFPluginTempl(String strPSSysPFPluginTemplId, PSSysPFPluginTempl psSysPFPluginTempl) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pssyspfplugintempl/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSysPFPluginTemplId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psSysPFPluginTempl, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysPFPluginTempls(String strPSSystemId, Vector<PSSysPFPluginTempl> psSysPFPluginTemplList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssyspfplugintempls/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysPFPluginTempl item = new PSSysPFPluginTempl();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysPFPluginTemplList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSSysPFPlugins(String strPSSystemId, Vector<PSSysPFPlugin> psSysPFPluginList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpssyspfplugins/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSSystemId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSSysPFPlugin item = new PSSysPFPlugin();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psSysPFPluginList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWorkflow(String strPSWorkflowId, PSWorkflow psWorkflow) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psworkflow/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSWorkflowId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psWorkflow, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDynaInst(String strPSDynaInstId, PSDynaInst psDynaInst) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdynainst/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSDynaInstId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psDynaInst, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSAppPDTView(String strPSAppPDTViewId, PSAppPDTView psAppPDTView) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psapppdtview/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSAppPDTViewId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONObject jsonItem = retjson.getJSONObject("item");
                DataObject.fromJSONObject((IDataObject)psAppPDTView, (JSONObject)jsonItem);
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getAllPSAppPDTViews(String strPSApplicationId, Vector<PSAppPDTView> psAppPDTViewList) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/allpsapppdtviews/%1$s/%2$s"), (Object)this.strPSSysModelInstId, (Object)strPSApplicationId));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSAppPDTView item = new PSAppPDTView();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psAppPDTViewList.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDataEntityTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDataEntity> psDataEntities) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdataentitytagsbydynainst/%1$s/%2$s/%3$s/%4$s"), (Object)this.strPSSysModelInstId, (Object)strDynaInstId, (Object)nStart, (Object)nPageSize));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDataEntity item = new PSDataEntity();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDataEntities.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEFormTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDEForm> psDEForms) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeformtagsbydynainst/%1$s/%2$s/%3$s/%4$s"), (Object)this.strPSSysModelInstId, (Object)strDynaInstId, (Object)nStart, (Object)nPageSize));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEForm item = new PSDEForm();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEForms.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSDEViewBaseTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSDEViewBase> psDEViewBases) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/psdeviewbasetagsbydynainst/%1$s/%2$s/%3$s/%4$s"), (Object)this.strPSSysModelInstId, (Object)strDynaInstId, (Object)nStart, (Object)nPageSize));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSDEViewBase item = new PSDEViewBase();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psDEViewBases.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    @Override
    public CallResult getPSWFVersionTagsByDynaInst(String strDynaInstId, int nStart, int nPageSize, Vector<PSWFVersion> psWFVersions) {
        CallResult callResult = CallResult.create((int)0);
        HttpGet httpUriRequest = null;
        httpUriRequest = new HttpGet(StringHelper.format((String)(String.valueOf(this.strServiceUrl) + "/pswfversiontagsbydynainst/%1$s/%2$s/%3$s/%4$s"), (Object)this.strPSSysModelInstId, (Object)strDynaInstId, (Object)nStart, (Object)nPageSize));
        try {
            if (this.psModelQueryHelperOAuthToken.isOauth()) {
                httpUriRequest.addHeader("Authorization", "Bearer " + this.psModelQueryHelperOAuthToken.getToken().getValue());
            }
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]", (Object)httpUriRequest.getURI().toString()));
            String retStr = (String)this.httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)this.responseHandler);
            JSONObject retjson = JSONObject.fromString((String)retStr);
            if (retjson.has("ret") && StringHelper.compare((String)retjson.getString("ret"), (String)"0", (boolean)false) == 0) {
                JSONArray jsonArray = retjson.getJSONArray("items");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    PSWFVersion item = new PSWFVersion();
                    DataObject.fromJSONObject((IDataObject)item, (JSONObject)json);
                    psWFVersions.add(item);
                    ++i;
                }
            } else {
                callResult.setRetCode(retjson.has("ret") ? retjson.getInt("ret") : 1);
                callResult.setErrorInfo(retjson.has("retinfo") ? retjson.getString("retinfo") : retjson.toString());
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.format((String)"\u8bf7\u6c42\u670d\u52a1[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)httpUriRequest.getURI().toString(), (Object)e.getMessage()), (Throwable)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    class PSResponseHandler
    implements ResponseHandler<String> {
        PSResponseHandler() {
        }

        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (status != 200) {
                JSONObject json = new JSONObject();
                json.put("ret", status);
                json.put("retinfo", (Object)EntityUtils.toString((HttpEntity)entity, (String)"UTF-8"));
                return json.toString();
            }
            if (entity != null) {
                String result = EntityUtils.toString((HttpEntity)entity, (String)"UTF-8");
                return result;
            }
            return null;
        }
    }
}

