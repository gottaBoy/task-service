/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Data.DBCallConfigMgr
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebConfig
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.CodeList.UserCodeListMgr;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Data.DBCallConfigMgr;
import SA.SRFramework.DataEx.DataEntityMgr;
import SA.SRFramework.Localization.LocalizationConfig;
import SA.SRFramework.ReportEx.Model.ExcelTemplMgr;
import SA.SRFramework.SecurityEx.Web.DefaultUserPrivilegeMgr;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.StringLengthMgr;
import SA.SRFramework.ValueRule.ValueRuleMgr;
import SA.SRFramework.Web.WebConfig;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;
import SA.SRFramework.WebEx.ISRFExUserMenuCaptionMgr;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarMgr;
import SA.SRFramework.WebEx.UI.AutoCompleteMgr;
import SA.SRFramework.WebEx.UI.AutoFillMgr;
import SA.SRFramework.WebEx.UI.BuilderConfig;
import SA.SRFramework.WebEx.UI.BuilderMgr;
import SA.SRFramework.WebEx.UI.DataGridMgr;
import SA.SRFramework.WebEx.UI.DynamicPanelMgr;
import SA.SRFramework.WebEx.UI.ExcelReportMgr;
import SA.SRFramework.WebEx.UI.FormImageLinkMgr;
import SA.SRFramework.WebEx.UI.GlobalConfigMgr;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import SA.SRFramework.WebEx.UI.MenuExMgr;
import SA.SRFramework.WebEx.UI.PickerDialogMgr;
import SA.SRFramework.WebEx.UI.SearchPanelMgr;
import SA.SRFramework.WebEx.UI.ShortcutBarMgr;
import SA.SRFramework.WebEx.UI.TabViewMgr;
import SA.SRFramework.WebEx.UI.TreeViewMgr;
import SA.SRFramework.WebEx.UI.ValueTransformMgr;
import SA.SRFramework.WebEx.UI.WebExConfig;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.Workflow.WFConfigMgr;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExWebContext
implements ISRFExWebContext {
    private static final Log log = LogFactory.getLog(SRFExWebContext.class);
    protected SRFExPage page = null;
    protected Hashtable<String, String> paramList = new Hashtable();
    protected String strUITheme = "THEME_DEFAULT";
    protected String strCurPageName = "";
    protected String strCurPagePath = "";
    protected String strDBCallerMode = "";
    public static final String SASRFEXWEBCONTEXT = "SASRFEXWEBCONTEXT";
    public static final String SRFDBCALLERHELPER = "SRFDBCALLERHELPER";
    public static final String SASRFEXGRIDID = "GRIDID";
    public static final String SASRFEXPGRIDID = "PGRIDID";
    public static final String SASRFEXFORMID = "SRFFORMID";
    public static final String SASRFEXCONTAINERID = "CONTAINERID";
    public static final String SASRFEXFORMITEMID = "FORMITEMID";
    public static final String SASRFEXACTIONTYPE = "ACTIONTYPE";
    public static final String SASRFEXACTIONTYPEEX = "SRFACTIONTYPE";
    public static final String SASRFACTIONHELPER = "SRFACTIONHELPER";
    public static final String SASRFEXACTION = "ACTION";
    public static final String SASRFEXACTIONEX = "SRFACTION";
    public static final String SASRFEXSAVEANDNEW = "SAVEANDNEW";
    public static final String SASRFEXCOPYMODE = "COPYMODE";
    public static final String SASRFEXTREEID = "TREEID";
    public static final String SASRFEXTREENODE = "NODE";
    public static final String SASRFEXTABVIEWID = "TABVIEWID";
    public static final String SASRFEXTABVIEWPAGEID = "TABVIEWPAGEID";
    public static final String SASRFEXSEARCHTHEMEID = "SEARCHTHEMEID";
    public static final String SASRFEXSEARCHTHEMENAME = "SEARCHTHEMENAME";
    public static final String SASRFEXSEARCHPANELID = "SEARCHPANELID";
    public static final String SASRFEXSYSTEMID = "SYSTEMID";
    public static final String SASRFEXBUTTONID = "BUTTONID";
    public static final String SASRFEXAJAXPARAM = "SRFAJAXPARAM";
    public static final String SASRFEXAJAXID = "SRFAJAXID";
    public static final String SASRFEXDIALOGMODE = "DIALOGMODE";
    public static final String SASRFEXMENUEX = "MENUEX";
    public static final String SASRFEXACQUERY = "ACQUERY";
    public static final String SASRFEXACMODE = "ACMODE";
    public static final String SASRFEXPICKUPTEXT = "PICKUPTEXT";
    public static final String SASRFEXPICKUPVALUE = "PICKUPVALUE";
    public static final String SASRFEXEXCELREPORT = "EXCELREPORT";
    public static final String SASRFEXDGTHEMEID = "DGTHEMEID";
    public static final String SASRFEXDGTHEME = "DGTHEME";
    public static final String SASRFEXUSERPRIVILEGEMGR = "USERPRIVILEGEMGR";
    public static final String SASRFEXUSERMENUCAPTIONID = "USERMENUCAPTIONID";
    public static final String SASRFEXRU = "RU";
    public static final String SASRFEXPERSONNAME = "PERSONNAME";
    public static final String SASRFEXDEPTID = "DEPTID";
    public static final String SASRFEXDEPTNAME = "DEPTNAME";
    public static final String SASRFEXLOGINNAME = "LOGINNAME";
    public static final String SASRFEXMAINMENUID = "MAINMENUID";
    public static final String SASRFEXSHORTCUTBARID = "SHORTCUTBARID";
    public static final String SASRFEXROWINDEX = "ROWINDEX";
    public static final String SASRFEXPAGEID = "SRFPAGEID";
    public static final String SASRFEXLOCALIZATION = "LOCALIZATION";
    public static final String SASRFEXTIMEZONE = "SRFTIMEZONE";
    public static final String SASRFEXORGID = "SRFORGID";
    public static final String SASRFEXORGNAME = "SRFORGNAME";
    private SRFExAjaxActionResult ajaxActionResult = null;
    protected Hashtable<String, String> cacheLocalizationMap = null;
    private static String[] filterkeywords = new String[]{"CREATE ", "UPDATE ", "DELETE ", "INSERT ", "DROP ", "SELECT ", "GRANT ", "OPEN ", "AND ", "OR ", "<IFRAME", "<FRAME", "<SCRIPT>", "<SCRIPT ", "</SCRIPT>", "<IMG "};
    private static String[] filterkeywords3 = new String[]{"CREATE ", "UPDATE ", "DELETE ", "INSERT ", "DROP ", "SELECT ", "GRANT ", "OPEN ", "AND ", "OR "};
    private static String[] filterkeywords2 = new String[]{"EVAL(", "ALERT(", "+'", "+\"", "'+", "\"+", "JAVASCRIPT:"};

    public SRFExWebContext(SRFExPage page) {
        this.page = page;
        page.getPageContext().setAttribute(SASRFEXWEBCONTEXT, (Object)this);
        HttpServletRequest request = (HttpServletRequest)page.getPageContext().getRequest();
        this.ParseRequest(request.getQueryString());
    }

    public static SRFExWebContext Current(SRFExPage page) {
        return SRFExWebContext.Current(page, true);
    }

    public static SRFExWebContext Current(SRFExPage page, boolean bNew) {
        if (page == null) {
            return null;
        }
        Object curContext = page.getPageContext().getAttribute(SASRFEXWEBCONTEXT);
        if (curContext == null) {
            if (bNew) {
                SRFExWebContext curTemp = new SRFExWebContext(page);
                return curTemp;
            }
            return null;
        }
        return (SRFExWebContext)curContext;
    }

    protected void ParseRequest(String strQueryString) {
        if (strQueryString == null) {
            return;
        }
        String[] strLists = strQueryString.split("&");
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strValue = URLDecoder.decode(set[1], "UTF-8");
                    strValue = this.FilterRequestValue(set[0], strValue);
                    if (StringHelper.Length((String)strValue) != 0) {
                        this.SetParamValue(set[0], strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
    }

    protected String FilterRequestValue(String strParamName, String strValue) {
        return SRFExWebContext.FilterRequestValue(strValue);
    }

    public static String FilterRequestValue(String strValue) {
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        String strProcessValue = strValue.toUpperCase();
        strProcessValue = strProcessValue.replace("\r", " ");
        strProcessValue = strProcessValue.replace("\n", " ");
        strProcessValue = strProcessValue.replace("\t", " ");
        int i = 0;
        while (i < filterkeywords.length) {
            if (strProcessValue.indexOf(filterkeywords[i]) != -1) {
                return "";
            }
            ++i;
        }
        strProcessValue = strProcessValue.replace(" ", "");
        i = 0;
        while (i < filterkeywords2.length) {
            if (strProcessValue.indexOf(filterkeywords2[i]) != -1) {
                return "";
            }
            ++i;
        }
        strValue = strValue.replace("'", "");
        strValue = strValue.replace("\"", "");
        return strValue;
    }

    public boolean FilterSQLKeywords(String strValue) {
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return true;
        }
        String strProcessValue = strValue.toUpperCase();
        strProcessValue = strProcessValue.replace("\r", " ");
        strProcessValue = strProcessValue.replace("\n", " ");
        strProcessValue = strProcessValue.replace("\t", " ");
        int i = 0;
        while (i < filterkeywords3.length) {
            if (strProcessValue.indexOf(filterkeywords3[i]) != -1) {
                return false;
            }
            ++i;
        }
        return true;
    }

    public static String FilterQueryString(String strQueryString) {
        if (StringHelper.IsNullOrEmpty((String)strQueryString)) {
            return strQueryString;
        }
        String[] strLists = strQueryString.split("&");
        Hashtable<String, String> paramList = new Hashtable<String, String>();
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strValue = URLDecoder.decode(set[1], "UTF-8");
                    strValue = SRFExWebContext.FilterRequestValue(strValue);
                    if (StringHelper.Length((String)strValue) != 0) {
                        paramList.put(set[0], strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
        return URLHelper.GetQueryString(paramList);
    }

    public SRFExPage getPage() {
        return this.page;
    }

    @Override
    public String GetQueryString() {
        return URLHelper.GetQueryString(this.paramList);
    }

    public String GetParamsString(String strParams) {
        return SRFExWebContext.GetParamsString(this, strParams);
    }

    private static String GetParamsString(SRFExWebContext webContext, String strParams) {
        if (StringHelper.Length((String)strParams) == 0) {
            return "";
        }
        String strURLCall = "";
        String[] list = strParams.split("[|]");
        int i = 0;
        while (i < list.length) {
            String strValue;
            String strName = list[i];
            if (StringHelper.Length((String)strName) != 0 && StringHelper.Length((String)(strValue = webContext.GetParamValue(strName))) != 0) {
                if (strURLCall.length() > 0) {
                    strURLCall = String.valueOf(strURLCall) + "&";
                }
                strURLCall = String.valueOf(strURLCall) + strName;
                strURLCall = String.valueOf(strURLCall) + "=";
                try {
                    strURLCall = String.valueOf(strURLCall) + URLEncoder.encode(strValue, "UTF-8");
                }
                catch (Exception ex) {
                    strURLCall = String.valueOf(strURLCall) + strValue;
                }
            }
            ++i;
        }
        return strURLCall;
    }

    @Override
    public String GetQueryStringWithout(String strParams) {
        if (StringHelper.Length((String)strParams) == 0) {
            return this.GetQueryString();
        }
        return SRFExWebContext.GetQueryStringWithout(this.paramList, strParams);
    }

    private static String GetQueryStringWithout(Hashtable<String, String> paramList, String strParams) {
        String strURLCall = "";
        String[] list = strParams.toUpperCase().split("[|]");
        Hashtable<String, String> notKeys = new Hashtable<String, String>();
        int i = 0;
        while (i < list.length) {
            notKeys.put(list[i], "");
            ++i;
        }
        Enumeration<String> enumeration = paramList.keys();
        while (enumeration.hasMoreElements()) {
            String strValue;
            String strName = enumeration.nextElement();
            if (StringHelper.Length((String)strName) == 0 || notKeys.containsKey(strName.toUpperCase()) || StringHelper.Length((String)(strValue = paramList.get(strName))) == 0) continue;
            if (strURLCall.length() > 0) {
                strURLCall = String.valueOf(strURLCall) + "&";
            }
            strURLCall = String.valueOf(strURLCall) + strName;
            strURLCall = String.valueOf(strURLCall) + "=";
            try {
                strURLCall = String.valueOf(strURLCall) + URLEncoder.encode(strValue, "UTF-8");
            }
            catch (Exception ex) {
                strURLCall = String.valueOf(strURLCall) + strValue;
            }
        }
        return strURLCall;
    }

    public static String EncodeURLParamValue(String strValue) {
        try {
            return URLEncoder.encode(strValue, "UTF-8");
        }
        catch (Exception ex) {
            return strValue;
        }
    }

    @Override
    public void RemoveParam(String strParamName) {
        if (this.paramList.containsKey(strParamName.toUpperCase())) {
            this.paramList.remove(strParamName.toUpperCase());
        }
    }

    @Override
    public String GetParamValue(String strParamName) {
        if (this.paramList.containsKey(strParamName.toUpperCase())) {
            return this.paramList.get(strParamName.toUpperCase()).toString();
        }
        return "";
    }

    @Override
    public void SetParamValue(String strParamName, String strParamValue) {
        if (!StringHelper.IsNullOrEmpty((String)(strParamValue = strParamValue.trim()))) {
            this.paramList.put(strParamName.toUpperCase(), strParamValue);
        } else {
            this.RemoveParam(strParamName);
        }
    }

    protected int GetParamIntValue(String strParamName, int nDefault) {
        String strValue = this.GetParamValue(strParamName);
        if (StringHelper.Length((String)strValue) == 0) {
            return nDefault;
        }
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    protected static int GetExtValue(String strValue, int nDefault) {
        if (StringHelper.Length((String)strValue) == 0) {
            return nDefault;
        }
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    protected boolean GetParamBoolValue(String strParamName, boolean bDefault) {
        String strValue = this.GetParamValue(strParamName);
        if (strValue.length() == 0) {
            return bDefault;
        }
        try {
            return Boolean.parseBoolean(strValue);
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public String getFormId() {
        String strFormId = this.GetParamValue(SASRFEXFORMID);
        if (StringHelper.Length((String)strFormId) == 0) {
            strFormId = this.page.getRequest().getParameter("srfformid");
        }
        if (StringHelper.Length((String)strFormId) == 0) {
            strFormId = this.page.getRequest().getParameter("formid");
        }
        return strFormId;
    }

    public boolean getCopyMode() {
        String strCopyMode = this.GetParamValue(SASRFEXCOPYMODE);
        if (StringHelper.Length((String)strCopyMode) == 0) {
            strCopyMode = this.page.getRequest().getParameter("copymode");
        }
        return StringHelper.Compare((String)strCopyMode, (String)"TRUE", (boolean)true) == 0;
    }

    public boolean getSaveAndNewMode() {
        String strSaveAndNewMode = this.GetParamValue(SASRFEXSAVEANDNEW);
        if (StringHelper.Length((String)strSaveAndNewMode) == 0) {
            strSaveAndNewMode = this.page.getRequest().getParameter(SASRFEXSAVEANDNEW.toLowerCase());
        }
        return StringHelper.Compare((String)strSaveAndNewMode, (String)"TRUE", (boolean)true) == 0;
    }

    public String getFormItemId() {
        return this.GetParamValue(SASRFEXFORMITEMID);
    }

    public int getRowIndex() {
        String strRowIndex = this.GetParamValue(SASRFEXROWINDEX);
        if (StringHelper.Length((String)strRowIndex) == 0) {
            strRowIndex = this.page.getRequest().getParameter("rowindex");
        }
        return SRFExWebContext.GetExtValue(strRowIndex, -1);
    }

    public String getGridId() {
        String strGridId = this.GetParamValue("srfgridid");
        if (!StringHelper.IsNullOrEmpty((String)strGridId)) {
            return strGridId;
        }
        strGridId = this.page.getRequest().getParameter("srfgridid");
        if (!StringHelper.IsNullOrEmpty((String)strGridId)) {
            return strGridId;
        }
        strGridId = this.GetParamValue(SASRFEXGRIDID);
        if (StringHelper.Length((String)strGridId) == 0) {
            strGridId = this.page.getRequest().getParameter("gridid");
        }
        return strGridId;
    }

    public String getButtonId() {
        String strButtonId = this.GetParamValue(SASRFEXBUTTONID);
        if (StringHelper.Length((String)strButtonId) == 0) {
            strButtonId = this.page.getRequest().getParameter(SASRFEXBUTTONID.toLowerCase());
        }
        return strButtonId;
    }

    public String getTreeId() {
        String strTreeId = this.GetParamValue("srftreeid");
        if (!StringHelper.IsNullOrEmpty((String)strTreeId)) {
            return strTreeId;
        }
        strTreeId = this.page.getRequest().getParameter("srftreeid");
        if (!StringHelper.IsNullOrEmpty((String)strTreeId)) {
            return strTreeId;
        }
        strTreeId = this.GetParamValue(SASRFEXTREEID);
        if (StringHelper.Length((String)strTreeId) == 0) {
            strTreeId = this.page.getRequest().getParameter(SASRFEXTREEID.toLowerCase());
        }
        return strTreeId;
    }

    public String getTreeNode() {
        String strTreeNodeId = this.GetParamValue(SASRFEXTREENODE);
        if (StringHelper.Length((String)strTreeNodeId) == 0) {
            strTreeNodeId = this.page.getRequest().getParameter(SASRFEXTREENODE.toLowerCase());
        }
        return strTreeNodeId;
    }

    public int getSearchThemeId() {
        String strSearchThemeId = this.GetParamValue(SASRFEXSEARCHTHEMEID);
        if (StringHelper.Length((String)strSearchThemeId) == 0) {
            strSearchThemeId = this.page.getRequest().getParameter(SASRFEXSEARCHTHEMEID.toLowerCase());
        }
        if (StringHelper.Length((String)strSearchThemeId) > 0) {
            return SRFExWebContext.GetExtValue(strSearchThemeId, -1);
        }
        return -1;
    }

    public String getSearchThemeName() {
        String strSearchThemeName = this.GetParamValue(SASRFEXSEARCHTHEMENAME);
        if (StringHelper.Length((String)strSearchThemeName) == 0) {
            strSearchThemeName = this.page.getRequest().getParameter(SASRFEXSEARCHTHEMENAME.toLowerCase());
        }
        return strSearchThemeName;
    }

    public String getSearchPanelId() {
        String strSearchPanelId = this.GetParamValue(SASRFEXSEARCHPANELID);
        if (StringHelper.Length((String)strSearchPanelId) == 0) {
            strSearchPanelId = this.page.getRequest().getParameter(SASRFEXSEARCHPANELID.toLowerCase());
        }
        return strSearchPanelId;
    }

    public String getTabViewId() {
        return this.GetParamValue(SASRFEXTABVIEWID);
    }

    public String getTabViewPageId() {
        return this.GetParamValue(SASRFEXTABVIEWPAGEID);
    }

    public String getContainerId() {
        return this.GetParamValue(SASRFEXCONTAINERID);
    }

    public boolean getDialogMode() {
        return this.GetParamBoolValue(SASRFEXDIALOGMODE, false);
    }

    public String getPageId() {
        String strPageId = this.GetParamValue(SASRFEXPAGEID);
        if (StringHelper.IsNullOrEmpty((String)strPageId)) {
            return this.GetParamValue("PAGEID");
        }
        return strPageId;
    }

    public void setDialogMode(boolean bDialogMode) {
        if (this.getDialogMode() != bDialogMode) {
            this.SetParamValue(SASRFEXDIALOGMODE, Boolean.toString(bDialogMode));
        }
    }

    public String getPGridId() {
        return this.GetParamValue(SASRFEXPGRIDID);
    }

    public String getActionType() {
        String strActionType = this.page.getRequest().getParameter(SASRFEXACTIONTYPEEX.toLowerCase());
        if (StringHelper.Length((String)strActionType) != 0) {
            return strActionType;
        }
        strActionType = this.GetParamValue(SASRFEXACTIONTYPEEX);
        if (StringHelper.Length((String)strActionType) != 0) {
            return strActionType;
        }
        strActionType = this.page.getRequest().getParameter(SASRFEXACTIONTYPE.toLowerCase());
        if (StringHelper.Length((String)strActionType) == 0) {
            strActionType = this.GetParamValue(SASRFEXACTIONTYPE);
        }
        return strActionType;
    }

    public String getActionHelper() {
        String strActionHelper = this.GetParamValue(SASRFACTIONHELPER);
        if (StringHelper.Length((String)strActionHelper) == 0) {
            strActionHelper = this.page.getRequest().getParameter(SASRFACTIONHELPER.toLowerCase());
        }
        return strActionHelper;
    }

    public String getAction() {
        String strAction = this.page.getRequest().getParameter(SASRFEXACTIONEX.toLowerCase());
        if (StringHelper.Length((String)strAction) != 0) {
            return strAction;
        }
        strAction = this.GetParamValue(SASRFEXACTIONEX);
        if (StringHelper.Length((String)strAction) != 0) {
            return strAction;
        }
        strAction = this.page.getRequest().getParameter(SASRFEXACTION.toLowerCase());
        if (StringHelper.Length((String)strAction) == 0) {
            strAction = this.GetParamValue(SASRFEXACTION);
        }
        return strAction;
    }

    public String getACQuery() {
        String strACQuery = this.GetParamValue(SASRFEXACQUERY);
        if (StringHelper.Length((String)strACQuery) == 0) {
            strACQuery = this.page.getRequest().getParameter(SASRFEXACQUERY.toLowerCase());
            strACQuery = SRFExWebContext.FilterRequestValue(strACQuery);
        }
        return strACQuery;
    }

    public String getACMode() {
        String strACMode = this.GetParamValue(SASRFEXACMODE);
        if (StringHelper.Length((String)strACMode) == 0) {
            strACMode = this.page.getRequest().getParameter(SASRFEXACMODE.toLowerCase());
        }
        return strACMode;
    }

    public String getDataGridThemeId() {
        String strDataGridThemeId = this.GetParamValue(SASRFEXDGTHEMEID);
        if (StringHelper.Length((String)strDataGridThemeId) == 0) {
            strDataGridThemeId = this.page.getRequest().getParameter(SASRFEXDGTHEMEID.toLowerCase());
        }
        return strDataGridThemeId;
    }

    public String getDataGridTheme() {
        String strDataGridTheme = this.GetParamValue(SASRFEXDGTHEME);
        if (StringHelper.Length((String)strDataGridTheme) == 0) {
            strDataGridTheme = this.page.getRequest().getParameter(SASRFEXDGTHEME.toLowerCase());
        }
        return strDataGridTheme;
    }

    public String getAjaxParam(int nIndex) {
        String strParamName = StringHelper.Format((String)"%1$s%2$s", (Object)SASRFEXAJAXPARAM, (Object)nIndex);
        String strValue = this.page.getRequest().getParameter(strParamName.toLowerCase());
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        strValue = this.GetParamValue(strParamName);
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        strParamName = StringHelper.Format((String)"%1$s%2$s", (Object)"AJAXPARAM", (Object)nIndex);
        strValue = this.page.getRequest().getParameter(strParamName.toLowerCase());
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        strValue = this.GetParamValue(strParamName);
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        return strValue;
    }

    @Override
    public String GetPostValue(String strParamName) {
        String strValue = this.page.getRequest().getParameter(strParamName.toLowerCase());
        if (strValue == null) {
            strValue = "";
        }
        return strValue;
    }

    public String GetPostValue(String strParamName, String strDefault) {
        String strValue = this.page.getRequest().getParameter(strParamName.toLowerCase());
        if (strValue == null) {
            strValue = strDefault;
        }
        return strValue;
    }

    public BuilderMgr getBuilderMgr() {
        return (BuilderMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("SRFEXTHEME"));
    }

    public BuilderConfig getCurBuilderConfig() {
        BuilderMgr builderMgr = this.getBuilderMgr();
        if (builderMgr == null) {
            log.error((Object)StringHelper.Format((String)"\u6784\u5efa\u5668\u7ba1\u7406\u5bf9\u8c61\u65e0\u6548"));
            return null;
        }
        return builderMgr.Get(this.strUITheme);
    }

    public BaseBuilder FindBuilder(String strBuilderName, String strBuilderMode) {
        BuilderConfig builderConfig = this.getCurBuilderConfig();
        if (builderConfig == null) {
            return null;
        }
        return builderConfig.GetBuilder(strBuilderName, strBuilderMode);
    }

    public DynamicPanelMgr getDynamicPanelMgr() {
        return (DynamicPanelMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("DYNAMICPANEL"));
    }

    public DataGridMgr getDataGridMgr() {
        return (DataGridMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("DATAGRID"));
    }

    public ShortcutBarMgr getShortcutBarMgr() {
        return (ShortcutBarMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("SHORTCUTBAR"));
    }

    public ValueRuleMgr getValueRuleMgr() {
        return (ValueRuleMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("VALUERULE"));
    }

    public SearchPanelMgr getSearchPanelMgr() {
        return (SearchPanelMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("SEARCHPANEL"));
    }

    public TreeViewMgr getTreeViewMgr() {
        return (TreeViewMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("TREEVIEW"));
    }

    public TabViewMgr getTabViewMgr() {
        return (TabViewMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("TABVIEW"));
    }

    public ValueTransformMgr getValueTransformMgr() {
        return (ValueTransformMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("VALUETRANSFORM"));
    }

    public ExcelReportMgr getExcelReportMgr() {
        return (ExcelReportMgr)((Object)this.page.getPageContext().getServletContext().getAttribute(SASRFEXEXCELREPORT));
    }

    public DataEntityMgr getDataEntityMgr() {
        return (DataEntityMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("DATAENTITY"));
    }

    public ToolbarMgr getToolbarMgr() {
        return (ToolbarMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("TOOLBAR"));
    }

    public String getUITheme() {
        return this.strUITheme;
    }

    public void setUITheme(String value) {
        this.strUITheme = value;
    }

    public BaseDBCallerHelper getDBCaller() {
        return this.OnGetDBCaller(this.getDBCallerMode());
    }

    public BaseDBCallerHelper getDBCaller(String strMode) {
        return this.OnGetDBCaller(strMode);
    }

    protected BaseDBCallerHelper OnGetDBCaller(String strMode) {
        BaseDBCallerHelper dbCaller = (BaseDBCallerHelper)this.page.getPageContext().getServletContext().getAttribute(SRFDBCALLERHELPER + strMode);
        if (dbCaller instanceof WebDBCallerHelperEx) {
            WebDBCallerHelperEx webDBCallerHelperEx = (WebDBCallerHelperEx)dbCaller;
            webDBCallerHelperEx.setWebContext(this);
        }
        return dbCaller;
    }

    public DBCallConfigMgr getDBCallConfigs() {
        DBCallConfigMgr dbCaller = (DBCallConfigMgr)this.page.getPageContext().getServletContext().getAttribute("SRFDBCALLERMGR");
        return dbCaller;
    }

    public WebConfig getWebConfig() {
        return (WebConfig)this.page.getPageContext().getServletContext().getAttribute("SRFWEBCONFIG");
    }

    public WebExConfig getWebExConfig() {
        return this.getGlobalConfigMgr().GetWebExConfig();
    }

    public String getCurSystemId() {
        WebConfig webConfig = this.getWebConfig();
        return webConfig.GetExtValue(SASRFEXSYSTEMID, "");
    }

    public String getCurPageName() {
        return this.strCurPageName;
    }

    public void setCurPageName(String value) {
        this.strCurPageName = value;
    }

    @Override
    public String getCurUserId() {
        if (this.page.getPageContext().getSession().getAttribute("PERSONID") == null) {
            return "";
        }
        return this.page.getPageContext().getSession().getAttribute("PERSONID").toString();
    }

    public void setCurUserId(String strValue) {
        this.page.getPageContext().getSession().setAttribute("PERSONID", (Object)strValue);
    }

    @Override
    public String getCurOrgUnitId() {
        Object objCurOrgId = this.GetSessionValue(SASRFEXORGID);
        if (objCurOrgId == null) {
            return "";
        }
        return objCurOrgId.toString();
    }

    public void setCurOrgUnitId(String strValue) {
        this.SetSessionValue(SASRFEXORGID, strValue);
    }

    @Override
    public String getCurOrgUnitName() {
        Object objCurOrgName = this.GetSessionValue(SASRFEXORGNAME);
        if (objCurOrgName == null) {
            return "";
        }
        return objCurOrgName.toString();
    }

    public void setCurOrgUnitName(String strValue) {
        this.SetSessionValue(SASRFEXORGNAME, strValue);
    }

    @Override
    public String getCurUserMode() {
        if (this.page.getPageContext().getSession().getAttribute("UESRMODE") == null) {
            return "DEFAULT";
        }
        return this.page.getPageContext().getSession().getAttribute("UESRMODE").toString();
    }

    public void setCurUserMode(String value) {
        this.page.getPageContext().getSession().setAttribute("UESRMODE", (Object)value);
    }

    public MenuExMgr getMenuExMgr() {
        return (MenuExMgr)((Object)this.page.getPageContext().getServletContext().getAttribute(SASRFEXMENUEX));
    }

    @Override
    public CodeListMgr getCodeListMgr() {
        if (!this.isEnableUserCodeList()) {
            return this.getGlobalHelper().getCodeListMgr();
        }
        Object obj = this.GetSessionValue("CODELIST");
        if (obj == null) {
            obj = this.CreateUserCodeListMgr();
            if (obj == null) {
                return null;
            }
            this.SetSessionValue("CODELIST", obj);
        }
        return (CodeListMgr)((Object)obj);
    }

    protected UserCodeListMgr CreateUserCodeListMgr() {
        UserCodeListMgr userCodeListMgr = new UserCodeListMgr();
        userCodeListMgr.setDBCallerHelper(this.getDBCaller(""));
        userCodeListMgr.setGlobalHelper(this.getGlobalHelper());
        userCodeListMgr.setGlobalCodeListMgr(this.getGlobalHelper().getCodeListMgr());
        return userCodeListMgr;
    }

    protected boolean isEnableUserCodeList() {
        return this.getWebConfig().GetExtValue("USERCODELIST", false);
    }

    public AutoCompleteMgr getAutoCompleteMgr() {
        return (AutoCompleteMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("AUTOCOMLETE"));
    }

    public AutoFillMgr getAutoFillMgr() {
        return (AutoFillMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("AUTOFILL"));
    }

    public PickerDialogMgr getPickerDialogMgr() {
        return (PickerDialogMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("PICKERDIALOG"));
    }

    public StringLengthMgr getStringLengthMgr() {
        return (StringLengthMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("STRINGLENGTH"));
    }

    public MenuExConfig getCurMenuExConfig() {
        return this.getMenuExConfig(this.GetCurMenuExId());
    }

    public MenuExConfig getMenuExConfig(String strMenuId) {
        MenuExConfig curMenuExConfig = null;
        if (this.page.getPageContext().getSession().getAttribute(SASRFEXMENUEX) != null) {
            curMenuExConfig = (MenuExConfig)((Object)this.page.getPageContext().getSession().getAttribute(SASRFEXMENUEX));
            if (StringHelper.Compare((String)curMenuExConfig.getConfigId(), (String)strMenuId, (boolean)true) == 0) {
                return curMenuExConfig;
            }
            this.ResetCurMenuExConfig();
        }
        if ((curMenuExConfig = this.getMenuExMgr().GetMenuExConfig(strMenuId)) != null) {
            curMenuExConfig.setConfigId(strMenuId);
            curMenuExConfig.PrepareMenuExConfig(this);
            this.page.getPageContext().getSession().setAttribute(SASRFEXMENUEX, (Object)curMenuExConfig);
        }
        return curMenuExConfig;
    }

    protected String GetCurMenuExId() {
        return "MENUEX_" + this.getCurUserMode();
    }

    public void ResetCurMenuExConfig() {
        this.page.getPageContext().getSession().removeAttribute(SASRFEXMENUEX);
    }

    public String getMenuMode() {
        return this.GetParamValue("MENUMODE");
    }

    public void setMenuMode(String value) {
        this.SetParamValue("MENUMODE", value);
    }

    public HttpSession getSession() {
        return this.page.getPageContext().getSession();
    }

    public String getSessionId() {
        return this.getSession().getId();
    }

    public boolean TestIncludeParams(String strParams) {
        if (StringHelper.Length((String)strParams) == 0) {
            return true;
        }
        String[] list = strParams.split("[|]");
        int i = 0;
        while (i < list.length) {
            String strValue;
            String strName = list[i];
            if (StringHelper.Length((String)strName) != 0 && StringHelper.Length((String)(strValue = this.GetParamValue(strName))) == 0) {
                return false;
            }
            ++i;
        }
        return true;
    }

    public boolean TestExcludeParams(String strParams) {
        if (StringHelper.Length((String)strParams) == 0) {
            return true;
        }
        String[] list = strParams.split("[|]");
        int i = 0;
        while (i < list.length) {
            String strValue;
            String strName = list[i];
            if (StringHelper.Length((String)strName) != 0 && StringHelper.Length((String)(strValue = this.GetParamValue(strName))) != 0) {
                return false;
            }
            ++i;
        }
        return true;
    }

    @Override
    public String getCurPagePath() {
        return this.strCurPagePath;
    }

    public void setCurPagePath(String value) {
        this.strCurPagePath = value;
    }

    public String getPickupText() {
        return this.GetParamValue(SASRFEXPICKUPTEXT);
    }

    public String getPickupValue() {
        return this.GetParamValue(SASRFEXPICKUPVALUE);
    }

    public String getExcelReport() {
        return this.GetParamValue(SASRFEXEXCELREPORT);
    }

    public String getRU() {
        return this.GetParamValue(SASRFEXRU);
    }

    public String getMainMenuId() {
        return this.GetParamValue(SASRFEXMAINMENUID);
    }

    public String getShortcutBarId() {
        return this.GetParamValue(SASRFEXSHORTCUTBARID);
    }

    public void setRU(String value) {
        this.SetParamValue(SASRFEXRU, value);
    }

    protected IUserPrivilegeMgr CreateUserPrivilegeMgr() {
        return new DefaultUserPrivilegeMgr();
    }

    @Override
    public IUserPrivilegeMgr GetUserPrivilegeMgr() {
        Object objUserPrivilegeMgr = this.page.getPageContext().getSession().getAttribute(SASRFEXUSERPRIVILEGEMGR);
        if (objUserPrivilegeMgr != null && objUserPrivilegeMgr instanceof IUserPrivilegeMgr) {
            return (IUserPrivilegeMgr)objUserPrivilegeMgr;
        }
        IUserPrivilegeMgr iUserPrivilegeMgr = this.CreateUserPrivilegeMgr();
        if (iUserPrivilegeMgr != null) {
            this.page.getPageContext().getSession().setAttribute(SASRFEXUSERPRIVILEGEMGR, (Object)iUserPrivilegeMgr);
        }
        return iUserPrivilegeMgr;
    }

    public ISRFExUserMenuCaptionMgr GetUserMenuCaptionMgr() {
        Object objUserMenuCaptionMgr = this.page.getPageContext().getServletContext().getAttribute("USERMENUCAPTIONMGR");
        if (objUserMenuCaptionMgr == null) {
            return null;
        }
        return (ISRFExUserMenuCaptionMgr)objUserMenuCaptionMgr;
    }

    public String getUserMenuCaptionId() {
        return this.GetParamValue(SASRFEXUSERMENUCAPTIONID);
    }

    public FormImageLinkMgr getFormImageLinkMgr() {
        return (FormImageLinkMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("FORMIMAGELINK"));
    }

    public GlobalConfigMgr getGlobalConfigMgr() {
        return (GlobalConfigMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("GLOBALCONFIG"));
    }

    public WFConfigMgr getWorkflowMgr() {
        return (WFConfigMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("WORKFLOW"));
    }

    public ExcelTemplMgr getExcelTemplMgr() {
        return (ExcelTemplMgr)((Object)this.page.getPageContext().getServletContext().getAttribute("EXCELTEMPLATE"));
    }

    @Override
    public final void Logout() {
        this.Logout(false);
    }

    public final void Logout(boolean bReleaseSession) {
        this.page.getPageContext().getSession().removeAttribute(SASRFEXUSERPRIVILEGEMGR);
        this.page.getPageContext().getSession().removeAttribute("PERSONID");
        this.page.getPageContext().getSession().removeAttribute("UESRMODE");
        this.page.getPageContext().getSession().removeAttribute(SASRFEXMENUEX);
        this.page.getPageContext().getSession().removeAttribute(SASRFEXPERSONNAME);
        this.page.getPageContext().getSession().removeAttribute(SASRFEXDEPTID);
        this.page.getPageContext().getSession().removeAttribute(SASRFEXDEPTNAME);
        this.page.getPageContext().getSession().removeAttribute(SASRFEXLOGINNAME);
        this.page.getPageContext().getSession().removeAttribute("USERPRIVILEGESMGR");
        this.page.getPageContext().getSession().removeAttribute("SASRFUSERCHARTS");
        this.page.getPageContext().getSession().removeAttribute("CODELIST");
        this.OnLogout();
        Vector<String> sessionKeys = new Vector<String>();
        Enumeration en = this.page.getPageContext().getSession().getAttributeNames();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            sessionKeys.add(strKey);
        }
        for (String strKey : sessionKeys) {
            this.page.getPageContext().getSession().removeAttribute(strKey);
        }
        if (bReleaseSession) {
            this.page.getPageContext().getSession().invalidate();
        }
    }

    protected void OnLogout() {
    }

    @Override
    public final void Logon() {
        this.OnLogon();
    }

    public void OnLogon() {
    }

    public String getCurLoginName() {
        if (this.page.getPageContext().getSession().getAttribute(SASRFEXLOGINNAME) == null) {
            return "";
        }
        return this.page.getPageContext().getSession().getAttribute(SASRFEXLOGINNAME).toString();
    }

    public void setCurLoginName(String strValue) {
        this.page.getPageContext().getSession().setAttribute(SASRFEXLOGINNAME, (Object)strValue);
    }

    @Override
    public String getCurDeptId() {
        if (this.page.getPageContext().getSession().getAttribute(SASRFEXDEPTID) == null) {
            return "";
        }
        return this.page.getPageContext().getSession().getAttribute(SASRFEXDEPTID).toString();
    }

    public void setCurDeptId(String strValue) {
        this.page.getPageContext().getSession().setAttribute(SASRFEXDEPTID, (Object)strValue);
    }

    @Override
    public String getCurDeptName() {
        if (this.page.getPageContext().getSession().getAttribute(SASRFEXDEPTNAME) == null) {
            return "";
        }
        return this.page.getPageContext().getSession().getAttribute(SASRFEXDEPTNAME).toString();
    }

    public void setCurDeptName(String strValue) {
        this.page.getPageContext().getSession().setAttribute(SASRFEXDEPTNAME, (Object)strValue);
    }

    public String getCurPersonName() {
        if (this.page.getPageContext().getSession().getAttribute(SASRFEXPERSONNAME) == null) {
            return "";
        }
        return this.page.getPageContext().getSession().getAttribute(SASRFEXPERSONNAME).toString();
    }

    public void setCurPersonName(String strValue) {
        this.page.getPageContext().getSession().setAttribute(SASRFEXPERSONNAME, (Object)strValue);
    }

    @Override
    public String getCurUserName() {
        if (this.page.getPageContext().getSession().getAttribute(SASRFEXPERSONNAME) == null) {
            return "";
        }
        return this.page.getPageContext().getSession().getAttribute(SASRFEXPERSONNAME).toString();
    }

    public void setCurUserName(String strValue) {
        this.page.getPageContext().getSession().setAttribute(SASRFEXPERSONNAME, (Object)strValue);
    }

    @Override
    public final Object GetSessionValue(String strKey) {
        return this.page.getPageContext().getSession().getAttribute(strKey);
    }

    @Override
    public final void SetSessionValue(String strKey, Object objValue) {
        if (objValue == null) {
            this.page.getPageContext().getSession().removeAttribute(strKey);
        } else {
            this.page.getPageContext().getSession().setAttribute(strKey, objValue);
        }
    }

    @Override
    public final Object GetGlobalValue(String strKey) {
        return this.page.getPageContext().getServletContext().getAttribute(strKey);
    }

    @Override
    public final void SetGlobalValue(String strKey, Object objValue) {
        if (objValue == null) {
            this.page.getPageContext().getServletContext().removeAttribute(strKey);
        } else {
            this.page.getPageContext().getServletContext().setAttribute(strKey, objValue);
        }
    }

    public String getDBCallerMode() {
        return this.strDBCallerMode;
    }

    public void setDBCallerMode(String strDBCallerMode) {
        this.strDBCallerMode = strDBCallerMode.toUpperCase();
    }

    public String GetAppRootPath() {
        return (String)this.page.getPageContext().getServletContext().getAttribute("APPROOTPATH");
    }

    @Override
    public String getLocalization() {
        Object objValue = this.GetSessionValue(SASRFEXLOCALIZATION);
        if (objValue == null) {
            return "";
        }
        return (String)objValue;
    }

    public void setLocalization(String strLocalization) {
        this.SetSessionValue(SASRFEXLOCALIZATION, strLocalization);
    }

    public LocalizationConfig getLocalConfig() {
        return this.getGlobalConfigMgr().GetLocalizationConfig(this.getLocalization());
    }

    public String getLocalText(String strGroup, String strField, String strDefault) {
        LocalizationConfig localizationConfig = this.getLocalConfig();
        return localizationConfig.GetValue(strGroup, strField, strDefault);
    }

    @Override
    public ContextHelper getGlobalHelper() {
        return (ContextHelper)this.GetGlobalValue("CONTEXTHELPER");
    }

    @Override
    public String getRemoteAddr() {
        return this.page.getRequest().getRemoteAddr();
    }

    @Override
    public TimeZone getCurTimeZone() {
        Object objTimeZone = this.GetSessionValue(SASRFEXTIMEZONE);
        if (objTimeZone != null) {
            return (TimeZone)objTimeZone;
        }
        return null;
    }

    public void setCurTimeZone(TimeZone timeZone) {
        this.SetSessionValue(SASRFEXTIMEZONE, timeZone);
    }

    public boolean isContainsParam(String strParamName) {
        strParamName = strParamName.toUpperCase();
        return this.paramList.containsKey(strParamName);
    }

    @Override
    public Hashtable<String, String> GetParams() {
        return this.paramList;
    }

    @Override
    public boolean IsBackEndMode() {
        return this.page.IsBackEndMode();
    }

    @Override
    public String GetLocalization(String strResId, String strResId2, String strDefault) {
        String strText;
        String strKey = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)this.getLocalization(), (Object)strResId, (Object)strResId2);
        if (this.cacheLocalizationMap == null) {
            this.cacheLocalizationMap = new Hashtable();
        }
        if ((strText = this.cacheLocalizationMap.get(strKey)) == null) {
            strText = this.getGlobalHelper().getLocalizationHelper().GetLocalization(this.getLocalization(), strResId, strResId2, strDefault);
            this.cacheLocalizationMap.put(strKey, strText);
        }
        return strText;
    }

    @Override
    public void ReloadUserPrivilege() {
        this.page.getPageContext().getSession().removeAttribute(SASRFEXUSERPRIVILEGEMGR);
    }

    @Override
    public SRFExAjaxActionResult getActiveAjaxActionResult() {
        return this.ajaxActionResult;
    }

    @Override
    public void setActiveAjaxActionResult(SRFExAjaxActionResult ajaxActionResult) {
        this.ajaxActionResult = ajaxActionResult;
    }
}

