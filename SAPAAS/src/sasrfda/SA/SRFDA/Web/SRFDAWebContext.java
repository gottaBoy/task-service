/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.Data.MainMenu;
import SA.SRFDA.Security.IUserRoleHelper;
import SA.SRFDA.Security.UserQueryModelStorage;
import SA.SRFDA.Security.UserRoleHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAConfigCache;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDAWebContext
extends SRFExWebContext
implements ISRFDAWebContext {
    public static final String TAG_SRFGRIDVIEW = "SRFGRIDVIEW";
    public static final String TAG_SRFTREEVIEW = "SRFTREEVIEW";
    public static final String TAG_SRFGRIDVIEWEX = "SRFGRIDVIEWEX";
    public static final String TAG_SRFSUMMARYKEY = "SRFSUMMARYKEY";
    public static final String TAG_SRFGVSMODE = "SRFGVSMODE";
    public static final String TAG_SRFDGAL = "SRFDGAL";
    public static final String TAG_SRFGVSMODE_RIGHT = "RIGHT";
    public static final String TAG_SRFGVSMODE_BOTTOM = "BOTTOM";
    public static final String TAG_SRFFORMVIEW = "SRFFORMVIEW";
    public static final String TAG_SRFDEID = "SRFDEID";
    public static final String TAG_SRFPDEID = "SRFPDEID";
    public static final String TAG_SRFDERID = "SRFDERID";
    public static final String TAG_SRFDSTDERID = "SRFDSTDERID";
    public static final String TAG_SRFDERINDEXID = "SRFDERINDEXID";
    public static final String TAG_SRFPDEKEY = "SRFPDEKEY";
    public static final String TAG_SRFPDEKEY2 = "SRFPDEKEY2";
    public static final String TAG_SRFPDEKEY3 = "SRFPDEKEY3";
    public static final String TAG_SRFMAINFORM = "SRFMAINFORM";
    public static final String TAG_SRFVDEF = "SRFVDEF";
    public static final String TAG_SRFTDEF = "SRFTDEF";
    public static final String TAG_SRFDEFID = "SRFDEFID";
    public static final String TAG_SRFIFVIEW = "SRFIFVIEW";
    public static final String TAG_SRFGVTHEME = "SRFGVTHEME";
    public static final String TAG_SRFWFSTATE = "SRFWFSTATE";
    public static final String TAG_SRFWFSTEP = "SRFWFSTEP";
    public static final String TAG_SRFDEMAINACTION = "SRFDEMAINACTION";
    public static final String TAG_SRFFORMDIGEST = "SRFFORMDIGEST";
    public static final String TAG_SRFDEMAINSTATE = "SRFDEMAINSTATE";
    public static final String TAG_SRFPDEMAINSTATE = "SRFPDEMAINSTATE";
    public static final String TAG_SRFWFSUBSTEP = "SRFWFSUBSTEP";
    public static final String TAG_SRFDESUBWFID = "SRFDESUBWFID";
    public static final String TAG_SRFPDESUBWFID = "SRFPDESUBWFID";
    public static final String TAG_SRFWFACTION = "SRFWFACTION";
    public static final String TAG_SRFWFACTION_STARTNEW = "STARTNEW";
    public static final String TAG_SRFCAPTION = "SRFCAPTION";
    public static final String TAG_SRFSHOWCAP = "SRFSHOWCAP";
    public static final String TAG_SRFCHARTID = "SRFCHARTID";
    public static final String TAG_SRFCHARTTYPE = "SRFCHARTTYPE";
    public static final String TAG_SRFPAGEID = "SRFPAGEID";
    public static final String TAG_SRFLISTID = "SRFLISTID";
    public static final String TAG_SRFACTIVEFOLDER = "SRFAF";
    public static final String TAG_SRFCOPYID = "SRFCOPYID";
    public static final String TAG_SRFMASKINFO = "SRFMASKINFO";
    public static final String TAG_SRFSAVETAG = "SRFSAVETAG";
    public static final String TAG_SRFPVEQ = "SRFPVEQ";
    public static final String TAG_SRFFILTER = "SRFFILTER";
    public static final String TAG_SRFUSERROLEHELPER = "SRFUSERROLEHELPER";
    public static final String TAG_SRFUSERQUERYMODELSTORAGE = "SRFUSERQUERYMODELSTORAGE";
    public static final String TAG_SRFCONFIGCACHE = "SRFCONFIGCACHE";
    public static final String TAG_SRFQUICKSEARCH = "SRFQUICKSEARCH";
    public static final String TAG_SRFAPPUITHEME = "SRFAPPUITHEME";
    public static final String TAG_SRFWFSTATEVALUE = "SRFWFSTATEVALUE";
    public static final String TAG_SRFWFDATAGROUP = "SRFWFDATAGROUP";
    public static final String TAG_SRFWFDATAGROUP_MY = "MY";
    public static final String TAG_SRFWFDATAGROUP_ALL = "ALL";
    public static final String TAG_SRFWFDATAGROUP_MYWFWORK = "MYWFWORK";
    public static final String TAG_SRFWFDATAGROUP_PROCESSING = "PROCESSING";
    public static final String TAG_SRFPPNAME = "SRFPPNAME";
    public static final String TAG_PPMODELID = "PPMODELID";
    public static final String TAG_PPMODEL = "PPMODEL";
    public static final String TAG_REALURL = "REALURL";
    public static final String TAG_CALENDARID = "CALENDARID";
    public static final String TAG_SRFMSGFOLDER = "SRFMSGFOLDER";
    public static final String TAG_SRFINFOMODE = "SRFINFOMODE";
    public static final String TAG_SRFFEWDATAMODE = "SRFFEWDATAMODE";
    public static final String TAG_SRFWFMODE = "SRFWFMODE";
    public static final String TAG_SRFFORMSTATE = "SRFFORMSTATE";
    public static final String TAG_SRFTEMPDATA = "SRFTEMPDATA";
    public static final String TAG_SRFEMBEDMODE = "SRFEMBEDMODE";
    public static final String TAG_SRFDATEMPKEYID = "SRFDATEMPKEYID";
    public static final String TAG_SRFACCSEQ = "SRFACCSEQ";
    public static final String TAG_SRFPAGEMODEL = "SRFPAGEMODEL";
    public static final String TAG_SRFNEWDATA = "SRFNEWDATA";
    public static final String TAG_SRFDEDATAIMPORT = "SRFDEDATAIMPORT";
    public static final String TAG_SRFERRORCODEID = "SRFERRORCODEID";
    public static final String TAG_SRFERRORINFO = "SRFERRORINFO";
    public static final String TAG_SRFDEWIZARDID = "SRFDEWIZARDID";
    public static final String TAG_SRFDEWZPAGEID = "SRFDEWZPAGEID";
    public static final String TAG_SRFWZSESSIONID = "SRFWZSESSIONID";
    public static final String TAG_SRFWZSTEPID = "SRFWZSTEPID";
    public static final String TAG_SRFLASTWZSTEPID = "SRFLASTWZSTEPID";
    public static final String TAG_SRFHISDEWZPAGEID = "SRFHISDEWZPAGEID";
    public static final String TAG_SRFMBPANELID = "SRFMBPANELID";
    public static final String TAG_SRFMBLISTID = "SRFMBLISTID";
    public static final String TAG_SRFMBCTRLID = "SRFMBCTRLID";
    public static final String TAG_SRFDAKEYS = "SRFDAKEYS";
    public static final String TAG_SRFDER1NID = "SRFDER1NID";
    public static final String TAG_SRFCOPYMODE = "SRFCOPYMODE";
    public static final String TAG_SRFPARENTDATATAG = "SRFPARENTDATATAG";
    public static final String TAG_SRFPARENTDATA = "SRFPARENTDATA";
    public static final String TAG_SRFDERINDEXFILTER = "SRFDERINDEXFILTER";
    public static final String TAG_SRFMULTIFORMFILTER = "SRFMULTIFORMFILTER";
    protected static Vector<String> daParams = new Vector();
    protected static Hashtable<String, String> daParamMap = new Hashtable();
    protected static String strDAParams = "";
    private static final Log log = LogFactory.getLog(SRFDAWebContext.class);
    protected TreeMap<String, String> pveqMap;

    static {
        daParams.add(TAG_SRFGRIDVIEW);
        daParams.add(TAG_SRFGRIDVIEWEX);
        daParams.add(TAG_SRFFORMVIEW);
        daParams.add(TAG_SRFDEID);
        daParams.add(TAG_SRFPDEID);
        daParams.add(TAG_SRFMAINFORM);
        daParams.add(TAG_SRFDERID);
        daParams.add(TAG_SRFDERINDEXID);
        daParams.add(TAG_SRFVDEF);
        daParams.add(TAG_SRFTDEF);
        daParams.add(TAG_SRFDEFID);
        daParams.add("TABVIEWID");
        daParams.add("TABVIEWPAGEID");
        daParams.add(TAG_SRFGVSMODE);
        daParams.add(TAG_SRFPAGEID);
        daParams.add(TAG_SRFCAPTION);
        daParams.add(TAG_SRFMSGFOLDER);
        daParams.add(TAG_SRFINFOMODE);
        daParams.add(TAG_SRFFEWDATAMODE);
        daParams.add(TAG_SRFPVEQ);
        daParams.add(TAG_REALURL);
        daParams.add(TAG_SRFIFVIEW);
        daParams.add(TAG_SRFFORMSTATE);
        daParams.add(TAG_SRFDGAL);
        daParams.add(TAG_SRFACTIVEFOLDER);
        daParams.add(TAG_SRFMASKINFO);
        daParams.add(TAG_SRFFILTER);
        daParams.add(TAG_SRFEMBEDMODE);
        daParams.add(TAG_SRFACCSEQ);
        daParams.add(TAG_SRFDEMAINSTATE);
        daParams.add(TAG_SRFDEMAINACTION);
        daParams.add(TAG_SRFFORMDIGEST);
        daParams.add(TAG_SRFCOPYMODE);
        daParams.add(TAG_SRFPDEMAINSTATE);
        daParams.add(TAG_SRFWFDATAGROUP);
        daParams.add(TAG_SRFWFSTATE);
        daParams.add(TAG_SRFWFSTEP);
        daParams.add(TAG_SRFWFSUBSTEP);
        daParams.add(TAG_SRFWFSTATEVALUE);
        for (String strDAParam : daParams) {
            if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
                strDAParams = String.valueOf(strDAParams) + "|";
            }
            strDAParams = String.valueOf(strDAParams) + strDAParam;
            daParamMap.put(strDAParam, "");
        }
    }

    public static Hashtable<String, String> getDAParamMap() {
        return daParamMap;
    }

    public static String getDAParams() {
        return strDAParams;
    }

    public SRFDAWebContext(SRFExPage page) {
        super(page);
    }

    public static SRFDAWebContext Current(SRFExPage page) {
        return SRFDAWebContext.Current(page, true);
    }

    public static SRFDAWebContext Current(SRFExPage page, boolean bNew) {
        if (page == null) {
            return null;
        }
        Object curContext = page.getPageContext().getAttribute("SASRFEXWEBCONTEXT");
        if (curContext == null) {
            if (bNew) {
                SRFDAWebContext curTemp = new SRFDAWebContext(page);
                return curTemp;
            }
            return null;
        }
        return (SRFDAWebContext)curContext;
    }

    protected void ParseRequest(String strQueryString) {
        super.ParseRequest(strQueryString);
    }

    public String getSRFGridView() {
        return this.GetParamValue(TAG_SRFGRIDVIEW);
    }

    public String getSRFGVSMode() {
        return this.GetParamValue(TAG_SRFGVSMODE);
    }

    public String getSRFFormView() {
        return this.GetParamValue(TAG_SRFFORMVIEW);
    }

    public String getSRFDEID() {
        String strDEId = this.GetParamValue(TAG_SRFDEID);
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            return this.GetPostValue(TAG_SRFDEID);
        }
        return strDEId;
    }

    public String getSRFDEFID() {
        return this.GetParamValue(TAG_SRFDEFID);
    }

    public String getSRFPDEID() {
        return this.GetParamValue(TAG_SRFPDEID);
    }

    public String getSRFVDEF() {
        return this.GetParamValue(TAG_SRFVDEF);
    }

    public String getSRFTDEF() {
        return this.GetParamValue(TAG_SRFTDEF);
    }

    public String getSRFDERID() {
        return this.GetParamValue(TAG_SRFDERID);
    }

    public String getSRFDERINDEXID() {
        return this.GetParamValue(TAG_SRFDERINDEXID);
    }

    public String getSRFWFSTATE() {
        return this.GetParamValue(TAG_SRFWFSTATE);
    }

    public String getSRFWFSTEP() {
        return this.GetParamValue(TAG_SRFWFSTEP);
    }

    public String getSRFWFSTATEVALUE() {
        return this.GetParamValue(TAG_SRFWFSTATEVALUE);
    }

    public String getSRFWFDATAGROUP() {
        return this.GetParamValue(TAG_SRFWFDATAGROUP);
    }

    public String getSRFWFACTION() {
        String strWFAction = this.GetPostValue(TAG_SRFWFACTION);
        if (!StringHelper.IsNullOrEmpty((String)strWFAction)) {
            return strWFAction;
        }
        return this.GetParamValue(TAG_SRFWFACTION);
    }

    public boolean getSRFMainForm() {
        return this.GetParamBoolValue(TAG_SRFMAINFORM, false);
    }

    public void ResetDAParams() {
        for (String strDAParam : daParams) {
            this.RemoveParam(strDAParam);
        }
    }

    @Override
    public GlobalHelperEx getGlobalHelper() {
        return (GlobalHelperEx)this.GetGlobalValue("SRFDACONTEXTHELPER");
    }

    public String GetQueryStringWithoutDAParam() {
        return this.GetQueryStringWithoutDAParam(null);
    }

    @Override
    public String GetQueryStringWithoutDAParam(Map<String, String> daParams) {
        String strTemp = strDAParams;
        if (daParams != null) {
            for (String strKey : daParams.keySet()) {
                strTemp = String.valueOf(strTemp) + "|";
                strTemp = String.valueOf(strTemp) + strKey;
            }
        }
        return this.GetQueryStringWithout(strTemp);
    }

    protected String GetCurMenuExId() {
        MainMenu mainMenu = new MainMenu();
        CallResult callResult = this.getGlobalHelper().getDAModelHelper().GetMainMenu(this.getCurUserMode(), mainMenu);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237[%1$s]\u4e3b\u83dc\u5355\u5931\u8d25\uff0c%2$s", (Object)this.getCurUserMode(), (Object)callResult.getErrorInfo()));
            return "";
        }
        String strMainMenuConfigId = StringHelper.Format((String)"MENUEX_%1$s_%2$s", (Object)this.getCurUserMode(), (Object)mainMenu.getMMVERSION());
        strMainMenuConfigId = strMainMenuConfigId.toUpperCase();
        return strMainMenuConfigId;
    }

    public String getSRFPPNAME() {
        return this.GetParamValue(TAG_SRFPPNAME);
    }

    public String getSRFChartId() {
        return this.GetParamValue(TAG_SRFCHARTID);
    }

    public String getSRFListId() {
        return this.GetParamValue(TAG_SRFLISTID);
    }

    public String getSRFPageId() {
        return this.GetParamValue(TAG_SRFPAGEID);
    }

    public boolean getSRFInfoMode() {
        return this.GetParamBoolValue(TAG_SRFINFOMODE, false);
    }

    @Override
    public IUserRoleHelper GetUserRoleHelper() {
        Object objUserRoleHelper = this.GetSessionValue(TAG_SRFUSERROLEHELPER);
        if (objUserRoleHelper == null || !(objUserRoleHelper instanceof UserRoleHelper)) {
            UserRoleHelper userRoleHelper = new UserRoleHelper(this.getGlobalHelper(), this.getCurUserId());
            this.SetSessionValue(TAG_SRFUSERROLEHELPER, userRoleHelper);
            return userRoleHelper;
        }
        return (IUserRoleHelper)objUserRoleHelper;
    }

    @Override
    public UserQueryModelStorage GetUserQueryModelStorage() {
        Object objUserQueryModelStorage = this.GetSessionValue(TAG_SRFUSERQUERYMODELSTORAGE);
        if (objUserQueryModelStorage == null || !(objUserQueryModelStorage instanceof UserQueryModelStorage)) {
            UserQueryModelStorage userQueryModelStorage = new UserQueryModelStorage(this.GetUserRoleHelper(), this.getGlobalHelper(), this.getCurUserId());
            this.SetSessionValue(TAG_SRFUSERQUERYMODELSTORAGE, userQueryModelStorage);
            return userQueryModelStorage;
        }
        return (UserQueryModelStorage)objUserQueryModelStorage;
    }

    public void ReloadUserPrivilege() {
        super.ReloadUserPrivilege();
        this.SetSessionValue(TAG_SRFUSERQUERYMODELSTORAGE, null);
        this.SetSessionValue(TAG_SRFUSERROLEHELPER, null);
        this.SetSessionValue(TAG_SRFUSERQUERYMODELSTORAGE, null);
    }

    public String getCurAppUITheme() {
        Object appUITheme = this.page.getPageContext().getSession().getAttribute(TAG_SRFAPPUITHEME);
        if (appUITheme == null) {
            return "";
        }
        return appUITheme.toString();
    }

    public void setCurAppUITheme(String strAppUITheme) {
        this.page.getPageContext().getSession().setAttribute(TAG_SRFAPPUITHEME, (Object)strAppUITheme);
    }

    protected void OnLogout() {
        super.OnLogout();
        this.SetSessionValue(TAG_SRFUSERQUERYMODELSTORAGE, null);
        this.SetSessionValue(TAG_SRFUSERROLEHELPER, null);
        this.SetSessionValue(TAG_SRFCONFIGCACHE, null);
        this.SetSessionValue(TAG_SRFAPPUITHEME, null);
    }

    @Override
    public String getSRFWFMode() {
        if (this.page.getPageContext().getSession().getAttribute(TAG_SRFWFMODE) == null) {
            return "";
        }
        return this.page.getPageContext().getSession().getAttribute(TAG_SRFWFMODE).toString();
    }

    public void setSRFWFMode(String strWFMode) {
        this.SetSessionValue(TAG_SRFWFMODE, strWFMode);
    }

    public String GetParamValue(String strParamName) {
        String strParamValue = this.InternalGetParamValue(strParamName);
        if (!StringHelper.IsNullOrEmpty((String)strParamValue) || this.pveqMap == null) {
            return strParamValue;
        }
        if (this.pveqMap != null && this.pveqMap.containsKey(strParamName.toUpperCase())) {
            strParamName = this.pveqMap.get(strParamName.toUpperCase());
        }
        return this.InternalGetParamValue(strParamName);
    }

    public void SetParamValue(String strParamName, String strParamValue) {
        if (StringHelper.Compare((String)strParamName, (String)TAG_SRFPVEQ, (boolean)true) == 0) {
            String strPVEQ = strParamValue;
            if (!StringHelper.IsNullOrEmpty((String)strPVEQ)) {
                if (this.pveqMap == null) {
                    this.pveqMap = new TreeMap();
                } else {
                    this.pveqMap.clear();
                }
                strPVEQ = strPVEQ.replace(",", ";");
                String[] parts = strPVEQ.split("[;]");
                int i = 0;
                while (i < parts.length) {
                    String[] eq;
                    String strEQ = parts[i];
                    if (!StringHelper.IsNullOrEmpty((String)(strEQ = strEQ.trim())) && (eq = strEQ.split("[|]")).length == 2) {
                        this.pveqMap.put(eq[0].trim().toUpperCase(), eq[1].trim().toUpperCase());
                    }
                    ++i;
                }
            } else {
                this.pveqMap = null;
            }
        }
        super.SetParamValue(strParamName, strParamValue);
    }

    private String InternalGetParamValue(String strParamName) {
        return super.GetParamValue(strParamName);
    }

    public String GetSRFFormState() {
        return this.InternalGetParamValue(TAG_SRFFORMSTATE);
    }

    public boolean GetSRFDGAutoLoad() {
        return StringHelper.Compare((String)this.InternalGetParamValue(TAG_SRFDGAL), (String)"FALSE", (boolean)true) != 0;
    }

    public String getSRFFILTER() {
        return this.GetParamValue(TAG_SRFFILTER);
    }

    public String getSRFPageModel() {
        return this.GetParamValue(TAG_SRFPAGEMODEL);
    }

    @Override
    public SRFDAConfigCache GetConfigCache() {
        Object objConfigCache = this.GetSessionValue(TAG_SRFCONFIGCACHE);
        if (objConfigCache == null || !(objConfigCache instanceof SRFDAConfigCache)) {
            SRFDAConfigCache ConfigCache = new SRFDAConfigCache(this.getGlobalHelper());
            this.SetSessionValue(TAG_SRFCONFIGCACHE, ConfigCache);
            return ConfigCache;
        }
        return (SRFDAConfigCache)objConfigCache;
    }

    public void OnLogon() {
        super.OnLogon();
        this.GetConfigCache();
    }

    @Override
    public Object getAttribute(String strName) {
        if (this.page == null || this.page.getRequest() == null) {
            return null;
        }
        return this.page.getRequest().getAttribute(strName.toUpperCase());
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
        if (this.page == null || this.page.getRequest() == null) {
            return;
        }
        if (objValue == null) {
            this.page.getRequest().removeAttribute(strName.toUpperCase());
        } else {
            this.page.getRequest().setAttribute(strName.toUpperCase(), objValue);
        }
    }
}

