/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.springframework.web.servlet.i18n.SessionLocaleResolver
 */
package net.ibizsys.paas.web;

import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.security.IUserRoleMgr2;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public abstract class WebContextBase {
    private static ThreadLocal<IWebContext> webContext = new ThreadLocal();
    private static ThreadLocal<JSONObject> activeData = new ThreadLocal();
    private static ThreadLocal<JSONObject> referData = new ThreadLocal();
    private static ThreadLocal<JSONObject> parentData = new ThreadLocal();
    private static ThreadLocal<JSONObject> appData = new ThreadLocal();
    private static ThreadLocal<JSONObject> viewParam = new ThreadLocal();
    public static final String PARAM_PARENTTYPE = "SRFPARENTTYPE";
    public static final String PARAM_PARENTKEY = "SRFPARENTKEY";
    public static final String PARAM_PARENTKEY2 = "SRFPARENTKEY2";
    public static final String PARAM_SOURCEKEY = "SRFSOURCEKEY";
    public static final String PARAM_KEYS = "SRFKEYS";
    public static final String PARAM_KEY = "SRFKEY";
    public static final String PARAM_TEMPKEY = "SRFTEMPKEY";
    public static final String PARAM_DER1NID = "SRFDER1NID";
    public static final String PARAM_DERINDEXID = "SRFDERINDEXID";
    public static final String PARAM_DER11ID = "SRFDER11ID";
    public static final String PARAM_FILTER = "SRFFILTER";
    public static final String PARAM_QUICKSEARCH = "SRFQUICKSEARCH";
    public static final String PARAM_APPID = "SRFAPPID";
    public static final String PARAM_VIEWID = "SRFVIEWID";
    public static final String PARAM_VIEWMODE = "SRFVIEWMODE";
    public static final String PARAM_VIEWDEID = "SRFVIEWDEID";
    public static final String PARAM_VIEWWFID = "SRFVIEWWFID";
    public static final String PARAM_CODELISTID = "SRFCODELISTID";
    public static final String PARAM_FORMITEMID = "SRFFORMITEMID";
    public static final String PARAM_CTRLID = "SRFCTRLID";
    public static final String PARAM_COUNTERID = "SRFCOUNTERID";
    public static final String PARAM_COUNTERPARAM = "SRFCOUNTERPARAM";
    public static final String PARAM_ACTION = "SRFACTION";
    public static final String PARAM_CONTAINERID = "SRFCID";
    public static final String PARAM_CONTAINERLEVEL = "SRFCLEVEL";
    public static final String PARAM_RENDER = "SRFRENDER";
    public static final String PARAM_DEID = "srfdeid";
    public static final String PARAM_PARENTDEID = "srfparentdeid";
    public static final String PARAM_WFSTEP = "srfwfstep";
    public static final String PARAM_WFUDSTATE = "srfwfudstate";
    public static final String PARAM_WFSTATE = "srfwfstate";
    public static final String PARAM_WFIATAG = "srfwfiatag";
    public static final String PARAM_WFMEMO = "srfwfmemo";
    public static final String PARAM_UIACTIONID = "SRFUIACTIONID";
    public static final String PARAM_FETCHCOND = "SRFFETCHCOND";
    public static final String PARAM_ACTIVEDATA = "SRFACTIVEDATA";
    public static final String PARAM_REFERDATA = "SRFREFERDATA";
    public static final String PARAM_REFERITEM = "SRFREFERITEM";
    public static final String PARAM_PARENTDATA = "SRFPARENTDATA";
    public static final String PARAM_PARENTMODE = "SRFPARENTMODE";
    public static final String PARAM_APPDATA = "SRFAPPDATA";
    public static final String PARAM_IFCHILD = "SRFIFCHILD";
    public static final String PARAM_PARENTTYPE_DER1N = "DER1N";
    public static final String PARAM_PARENTTYPE_SYSDER1N = "SYSDER1N";
    public static final String PARAM_PARENTTYPE_DER11 = "DER11";
    public static final String PARAM_PARENTTYPE_SYSDER11 = "SYSDER11";
    public static final String PARAM_TEMPMODE = "SRFTEMPMODE";
    public static final String PARAM_UFIMODE = "SRFUFIMODE";
    public static final String PARAM_NODESELECT = "SRFNODESELECT";
    public static final String PARAM_NODEID = "SRFNODEID";
    public static final String PARAM_NODETYPE = "SRFNODETYPE";
    public static final String PARAM_ITEMID = "SRFITEMID";
    public static final String PARAM_ITEMTYPE = "SRFITEMTYPE";
    public static final String PARAM_CALL = "SRFCALL";
    public static final String PARAM_CALLARG = "SRFCALLARG";
    public static final String PARAM_CALLRETINCEMPTY = "SRFCALLRETINCEMPTY";
    public static final String PARAM_CALLRETTIMEFMT = "SRFCALLRETTIMEFMT";
    public static final String PARAM_LOGINKEY = "SRFLOGINKEY";
    public static final String PARAM_WFID = "SRFWFID";
    public static final String PARAM_DEDATAIMPORT = "SRFDEDATAIMPORT";
    public static final String PARAM_VIEWPARAM = "SRFVIEWPARAM";
    public static final String PARAM_PRINTID = "SRFPRINTID";
    public static final String PARAM_REPORTID = "SRFREPORTID";
    public static final String PARAM_LOCALE = "SRFLOCALE";
    public static final String PARAM_RELOAD = "SRFRELOAD";
    public static final String PARAM_ORIKEY = "srforikey";
    public static final String PARAM_ACTIONDATA = "SRFACTIONDATA";
    public static final String PARAM_APPMODE = "SRFAPPMODE";
    public static final String HEADER_REALIP = "X-Real-IP";
    public static final String PARAM_CONTAINERID_REGEX = "^\\w+$";

    public static String encodeURLParamValue(String strValue) {
        try {
            return URLEncoder.encode(strValue, "UTF-8");
        }
        catch (Exception ex) {
            return strValue;
        }
    }

    public static IWebContext getCurrent(boolean bMust) throws Exception {
        IWebContext iWebContext = webContext.get();
        if (iWebContext == null && bMust) {
            throw new Exception("\u7528\u6237\u8bf7\u6c42\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548");
        }
        return iWebContext;
    }

    public static IWebContext getCurrent() {
        return webContext.get();
    }

    public static void setCurrent(IWebContext value) {
        webContext.set(value);
        activeData.set(null);
        appData.set(null);
        referData.set(null);
        parentData.set(null);
        viewParam.set(null);
    }

    public static String getParentType(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_PARENTTYPE);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_PARENTTYPE);
    }

    public static String getParentKey(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_PARENTKEY);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_PARENTKEY);
    }

    public static String getParentKey() {
        return WebContextBase.getParentKey(WebContext.getCurrent());
    }

    public static String getParentKey2(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_PARENTKEY2);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_PARENTKEY2);
    }

    public static String getParentKey2() {
        return WebContextBase.getParentKey2(WebContext.getCurrent());
    }

    public static String getSourceKey(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_SOURCEKEY);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_SOURCEKEY);
    }

    public static String getKeys(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_KEYS);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_KEYS);
    }

    public static String getKey(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_KEY);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_KEY);
    }

    public static String getDER1NId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_DER1NID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_DER1NID);
    }

    public static String getCtrlId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_CTRLID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_CTRLID);
    }

    public static String getCtrlId(IWebContext iWebContext, boolean bPostOnly) {
        String strValue = iWebContext.getPostValue(PARAM_CTRLID);
        if (strValue != null) {
            return strValue;
        }
        if (bPostOnly) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_CTRLID);
    }

    public static String getCounterId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_COUNTERID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_COUNTERID);
    }

    public static String getCounterParam(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_COUNTERPARAM);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_COUNTERPARAM);
    }

    public static String getAction(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_ACTION);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_ACTION);
    }

    public static String getAction(IWebContext iWebContext, boolean bPostOnly) {
        String strValue = iWebContext.getPostValue(PARAM_ACTION);
        if (strValue != null) {
            return strValue;
        }
        if (bPostOnly) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_ACTION);
    }

    public static String getDERIndexId(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_DERINDEXID);
    }

    public static String getFilter(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_FILTER);
    }

    public static String getAppId(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_APPID);
    }

    public static String getAppViewId(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_VIEWID);
    }

    public static String getAppViewMode(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_VIEWMODE);
    }

    public static String getAppViewDEId(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_VIEWDEID);
    }

    public static String getAppViewWFId(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_VIEWWFID);
    }

    public static String getCodeListId(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_CODELISTID);
    }

    public static String getFormItemId(IWebContext iWebContext) {
        return iWebContext.getParamValue(PARAM_FORMITEMID);
    }

    public static String getUIActionId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_UIACTIONID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_UIACTIONID);
    }

    public static String getFetchCond(IWebContext iWebContext) {
        return iWebContext.getPostValue(PARAM_FETCHCOND);
    }

    public static JSONObject getActiveData() throws Exception {
        return WebContextBase.getActiveData(WebContextBase.getCurrent());
    }

    public static JSONObject getActiveData(IWebContext iWebContext) throws Exception {
        String strActiveData;
        JSONObject dataObject = activeData.get();
        if (dataObject == null && !StringHelper.isNullOrEmpty(strActiveData = iWebContext.getPostValue(PARAM_ACTIVEDATA))) {
            dataObject = JSONObjectHelper.fromString(strActiveData);
            activeData.set(dataObject);
        }
        return dataObject;
    }

    public static void setActiveData(JSONObject dataObject) {
        activeData.set(dataObject);
    }

    public static JSONObject getAppData() {
        return WebContextBase.getAppData(WebContextBase.getCurrent());
    }

    public static JSONObject getAppData(IWebContext iWebContext) {
        String strAppData;
        JSONObject dataObject = appData.get();
        if (dataObject == null && iWebContext != null && !StringHelper.isNullOrEmpty(strAppData = iWebContext.getPostValue(PARAM_APPDATA))) {
            strAppData = new String(Base64Helper.decode(strAppData));
            dataObject = JSONObjectHelper.fromString(strAppData);
            appData.set(dataObject);
        }
        return dataObject;
    }

    public static void setAppData(JSONObject dataObject) {
        appData.set(dataObject);
    }

    public static JSONObject getReferData() {
        return WebContextBase.getReferData(WebContextBase.getCurrent());
    }

    public static JSONObject getReferData(IWebContext iWebContext) {
        String strReferData;
        JSONObject dataObject = referData.get();
        if (dataObject == null && !StringHelper.isNullOrEmpty(strReferData = iWebContext.getPostValue(PARAM_REFERDATA))) {
            dataObject = JSONObjectHelper.fromString(strReferData);
            referData.set(dataObject);
        }
        return dataObject;
    }

    public static void setReferData(JSONObject dataObject) {
        referData.set(dataObject);
    }

    public static JSONObject getParentData() throws Exception {
        return WebContextBase.getParentData(WebContextBase.getCurrent());
    }

    public static JSONObject getParentData(IWebContext iWebContext) throws Exception {
        JSONObject dataObject = parentData.get();
        if (dataObject == null) {
            String strParentData = iWebContext.getPostValue(PARAM_PARENTDATA);
            if (!StringHelper.isNullOrEmpty(strParentData)) {
                dataObject = JSONObjectHelper.fromString(strParentData);
                parentData.set(dataObject);
            } else {
                String strParentType = WebContext.getParentType(iWebContext);
                String strParentKey = WebContext.getParentKey(iWebContext);
                String strParentDEId = WebContext.getParentDEId(iWebContext);
                if (!(StringHelper.isNullOrEmpty(strParentType) || StringHelper.isNullOrEmpty(strParentKey) || StringHelper.isNullOrEmpty(strParentDEId))) {
                    dataObject = new JSONObject();
                    dataObject.put("srfparentkey", JSONObjectHelper.stripQuotes(strParentKey, true));
                    dataObject.put(PARAM_PARENTDEID, JSONObjectHelper.stripQuotes(strParentDEId, true));
                    dataObject.put("srfparenttype", JSONObjectHelper.stripQuotes(strParentType, true));
                    parentData.set(dataObject);
                }
            }
        }
        return dataObject;
    }

    public static int getFetchStart(IWebContext iWebContext, int nDefault) {
        String strStart = iWebContext.getPostValue("start");
        if (StringHelper.isNullOrEmpty(strStart)) {
            return nDefault;
        }
        return Integer.parseInt(strStart);
    }

    public static int getFetchSize(IWebContext iWebContext, int nDefault) {
        String strSize = iWebContext.getPostValue("limit");
        if (StringHelper.isNullOrEmpty(strSize)) {
            return nDefault;
        }
        return Integer.parseInt(strSize);
    }

    public static String getFetchQuickSearch(IWebContext iWebContext) {
        String strQuery = iWebContext.getPostValue("query");
        return strQuery;
    }

    public static String getSortParam(IWebContext iWebContext) {
        String strSortField = iWebContext.getPostValue("sort");
        return strSortField;
    }

    public static String getSortDir(IWebContext iWebContext) {
        String strSortDir = iWebContext.getPostValue("sortdir");
        return strSortDir;
    }

    public static boolean isTempMode(IWebContext iWebContext) {
        String strTempMode = iWebContext.getPostValue(PARAM_TEMPMODE);
        if (StringHelper.isNullOrEmpty(strTempMode)) {
            strTempMode = iWebContext.getParamValue(PARAM_TEMPMODE);
        }
        if (StringHelper.isNullOrEmpty(strTempMode)) {
            return false;
        }
        return StringHelper.compare(strTempMode, "true", true) == 0;
    }

    public static String getUFIMode(IWebContext iWebContext) {
        String strUFIMode = iWebContext.getPostValue(PARAM_UFIMODE);
        if (StringHelper.isNullOrEmpty(strUFIMode)) {
            strUFIMode = iWebContext.getParamValue(PARAM_UFIMODE);
        }
        return strUFIMode;
    }

    public static String getWFStep(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_WFSTEP);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_WFSTEP);
    }

    public static String getWFState(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_WFSTATE);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_WFSTATE);
    }

    public static String getWFUDState(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_WFUDSTATE);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_WFUDSTATE);
    }

    public static String getWFIATag(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_WFIATAG);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_WFIATAG);
    }

    public static String getWFMemo(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_WFMEMO);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_WFMEMO);
    }

    public static String getDEId() {
        return WebContext.getDEId(WebContext.getCurrent());
    }

    public static String getDEId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_DEID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_DEID);
    }

    public static String getParentDEId() {
        return WebContextBase.getParentDEId(WebContext.getCurrent());
    }

    public static String getParentDEId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_PARENTDEID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_PARENTDEID);
    }

    public static String getContainerId() {
        return WebContextBase.getContainerId(WebContext.getCurrent());
    }

    public static String getContainerId(IWebContext iWebContext) {
        Pattern pattern;
        Matcher m;
        String strValue = iWebContext.getPostValue(PARAM_CONTAINERID);
        if (strValue == null) {
            strValue = iWebContext.getParamValue(PARAM_CONTAINERID);
        }
        if (!StringHelper.isNullOrEmpty(strValue) && !(m = (pattern = Pattern.compile(PARAM_CONTAINERID_REGEX)).matcher(strValue)).matches()) {
            strValue = null;
        }
        return strValue;
    }

    public static String getContainerLevel() {
        return WebContextBase.getContainerLevel(WebContext.getCurrent());
    }

    public static String getContainerLevel(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_CONTAINERLEVEL);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_CONTAINERLEVEL);
    }

    public static String getRender() {
        return WebContextBase.getRender(WebContext.getCurrent());
    }

    public static String getRender(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_RENDER);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_RENDER);
    }

    public static String getNodeId() {
        return WebContextBase.getNodeId(WebContext.getCurrent());
    }

    public static String getNodeId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_NODEID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_NODEID);
    }

    public static String getNodeType() {
        return WebContextBase.getNodeType(WebContext.getCurrent());
    }

    public static String getNodeType(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_NODETYPE);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_NODETYPE);
    }

    public static String getItemId() {
        return WebContextBase.getItemId(WebContext.getCurrent());
    }

    public static String getItemId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_ITEMID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_ITEMID);
    }

    public static String getItemType() {
        return WebContextBase.getItemType(WebContext.getCurrent());
    }

    public static String getItemType(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_ITEMTYPE);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_ITEMTYPE);
    }

    public static String getRemoteCall() {
        return WebContextBase.getRemoteCall(WebContext.getCurrent());
    }

    public static String getRemoteCall(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_CALL);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_CALL);
    }

    public static String getRemoteCallArg() {
        return WebContextBase.getRemoteCallArg(WebContext.getCurrent());
    }

    public static String getRemoteCallArg(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_CALLARG);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_CALLARG);
    }

    public static String getRemoteCallRetIncEmpty() {
        return WebContextBase.getRemoteCallRetIncEmpty(WebContext.getCurrent());
    }

    public static String getRemoteCallRetIncEmpty(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_CALLRETINCEMPTY);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_CALLRETINCEMPTY);
    }

    public static String getRemoteCallRetTimeFmt() {
        return WebContextBase.getRemoteCallRetTimeFmt(WebContext.getCurrent());
    }

    public static String getRemoteCallRetTimeFmt(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_CALLRETTIMEFMT);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_CALLRETTIMEFMT);
    }

    public static String getLoginKey() {
        return WebContextBase.getLoginKey(WebContext.getCurrent());
    }

    public static String getLoginKey(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_LOGINKEY);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_LOGINKEY);
    }

    public static String getWFId() {
        return WebContext.getWFId(WebContext.getCurrent());
    }

    public static String getWFId(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_WFID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_WFID);
    }

    public static String getReferItem() {
        return WebContext.getReferItem(WebContext.getCurrent());
    }

    public static String getReferItem(IWebContext iWebContext) {
        if (iWebContext == null) {
            return null;
        }
        String strValue = iWebContext.getPostValue(PARAM_REFERITEM);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_REFERITEM);
    }

    public static void fillByLoginAccount(IWebContext iWebContext, LoginAccount loginAccount) {
        iWebContext.setSessionValue("SRFPERSONID", loginAccount.getUserId());
        iWebContext.setSessionValue("SRFUSERID", loginAccount.getUserId());
        iWebContext.setSessionValue("SRFUSERNAME", loginAccount.getUserName());
        iWebContext.setSessionValue("SRFUESRNAME", loginAccount.getUserName());
        iWebContext.setSessionValue("SRFLOGINNAME", loginAccount.getLoginAccountName());
        WebContext.setLocalization(iWebContext, loginAccount.getLanguage());
        if (DataObject.getBoolValue(loginAccount.getSuperUser(), false)) {
            iWebContext.setSessionValue("SRFSUPERUSER", "1");
        } else {
            iWebContext.setSessionValue("SRFSUPERUSER", "0");
        }
        if (DataObject.getBoolValue(loginAccount.getOrgAdmin(), false)) {
            iWebContext.setSessionValue("SRFORGADMIN", "1");
        } else {
            iWebContext.setSessionValue("SRFORGADMIN", "0");
        }
    }

    public static void fillByOrgUser(IWebContext iWebContext, OrgUser orgUser) {
        iWebContext.setSessionValue("SRFORGID", orgUser.getOrgId());
        iWebContext.setSessionValue("SRFORGNAME", orgUser.getOrgName());
        iWebContext.setSessionValue("SRFORGSECTORID", orgUser.getOrgSectorId());
        iWebContext.setSessionValue("SRFORGSECTORNAME", orgUser.getOrgSectorName());
        iWebContext.setSessionValue("SRFORGSECTORBC", orgUser.getBizCode());
    }

    public static String getDEDataImport() {
        return WebContext.getDEDataImport(WebContext.getCurrent());
    }

    public static String getDEDataImport(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_DEDATAIMPORT);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_DEDATAIMPORT);
    }

    public static JSONObject getViewParam() {
        return WebContextBase.getViewParam(WebContextBase.getCurrent());
    }

    public static JSONObject getViewParam(IWebContext iWebContext) {
        String strViewParam;
        JSONObject dataObject = viewParam.get();
        if (dataObject == null && !StringHelper.isNullOrEmpty(strViewParam = iWebContext.getPostValue(PARAM_VIEWPARAM))) {
            dataObject = JSONObjectHelper.fromString(strViewParam);
            viewParam.set(dataObject);
        }
        return dataObject;
    }

    public static String getReportId(IWebContext iWebContext) {
        if (iWebContext == null) {
            return null;
        }
        String strValue = iWebContext.getPostValue(PARAM_REPORTID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_REPORTID);
    }

    public static String getPrintId(IWebContext iWebContext) {
        if (iWebContext == null) {
            return null;
        }
        String strValue = iWebContext.getPostValue(PARAM_PRINTID);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_PRINTID);
    }

    public static String getOriginKey(IWebContext iWebContext) {
        if (iWebContext == null) {
            return null;
        }
        String strValue = iWebContext.getPostValue(PARAM_ORIKEY);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_ORIKEY);
    }

    public static String getRealKey(IWebContext iWebContext) {
        String strKey = WebContext.getKey(iWebContext);
        if (StringHelper.isNullOrEmpty(strKey)) {
            return strKey;
        }
        if (KeyValueHelper.isTempKey(strKey)) {
            return WebContextBase.getOriginKey(iWebContext);
        }
        return strKey;
    }

    public static void setLocalization(IWebContext iWebContext, String strLocalization) {
        if (StringHelper.isNullOrEmpty(strLocalization)) {
            iWebContext.setSessionValue("SRFLOCALIZATION", null);
            iWebContext.setSessionValue(PARAM_LOCALE, null);
            iWebContext.setSessionValue(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, null);
        } else {
            iWebContext.setSessionValue(PARAM_LOCALE, null);
            iWebContext.setSessionValue("SRFLOCALIZATION", strLocalization);
            Locale locale = iWebContext.getLocale();
            iWebContext.setSessionValue(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        }
    }

    public static IUserRoleMgr2 getUserRoleMgr2() throws Exception {
        return WebContextBase.getUserRoleMgr2(WebContext.getCurrent());
    }

    public static IUserRoleMgr2 getUserRoleMgr2(IWebContext iWebContext) throws Exception {
        IUserRoleMgr iUserRoleMgr = iWebContext.getUserRoleMgr();
        if (!(iUserRoleMgr instanceof IUserRoleMgr2)) {
            throw new Exception(StringHelper.format("\u7528\u6237\u89d2\u8272\u7ba1\u7406\u5668\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[net.ibizsys.paas.security.IUserRoleMgr2]", iUserRoleMgr));
        }
        return (IUserRoleMgr2)((Object)iUserRoleMgr);
    }

    public static String getActionData() {
        return WebContextBase.getActionData(WebContext.getCurrent());
    }

    public static String getActionData(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_ACTIONDATA);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_ACTIONDATA);
    }

    public static String getDynaSysInstId() {
        return WebContextBase.getDynaSysInstId(WebContext.getCurrent());
    }

    public static String getDynaSysInstId(IWebContext iWebContext) {
        Object objDynaInstId = iWebContext.getSessionValue("SRFDYNASYSINSTID");
        if (StringHelper.isNullOrEmpty(objDynaInstId)) {
            return WebConfig.getCurrent().getDynaSysInstId();
        }
        return (String)objDynaInstId;
    }

    public static String getAppMode() {
        return WebContextBase.getAppMode(WebContext.getCurrent());
    }

    public static String getAppMode(IWebContext iWebContext) {
        String strValue = iWebContext.getPostValue(PARAM_APPMODE);
        if (strValue != null) {
            return strValue;
        }
        return iWebContext.getParamValue(PARAM_APPMODE);
    }
}

