/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  javax.servlet.jsp.PageContext
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Data.DBCallConfigMgr;
import SA.SRFramework.Report.Web.Storage.BaseChartConfigMgr;
import SA.SRFramework.Report.Web.Storage.UserSessionChartConfigMgr;
import SA.SRFramework.Security.PrivilegesMgr;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFPage;
import SA.SRFramework.Web.UI.DynamicFormMgr;
import SA.SRFramework.Web.UI.IconViewMgr;
import SA.SRFramework.Web.UI.MainListMgr;
import SA.SRFramework.Web.UI.MenuConfig;
import SA.SRFramework.Web.UI.MenuConfigMgr;
import SA.SRFramework.Web.UI.PageConfigMgr;
import SA.SRFramework.Web.UI.SearchFormMgr;
import SA.SRFramework.Web.UI.SubListMgr;
import SA.SRFramework.Web.UI.SubViewMgr;
import SA.SRFramework.Web.UI.TipsMgr;
import SA.SRFramework.Web.UI.WebThemeConfig;
import SA.SRFramework.Web.UI.WebThemeMgr;
import SA.SRFramework.Web.WebConfig;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

public class WebContext {
    protected Hashtable paramList = new Hashtable();
    protected PageContext context = null;
    protected SRFPage curPage = null;
    protected String strCurPageName = "";
    protected String strPagePath = "";
    protected String strUITheme = "THEME_DEFAULT";
    protected int pageStyle = 0;
    protected String strCurPageId = "";
    protected static String SASRFWEBCONTEXT = "SASRFWEBCONTEXT";
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    public WebContext(PageContext pageContext) {
        this.context = pageContext;
        this.context.setAttribute(SASRFWEBCONTEXT, (Object)this);
        this.request = (HttpServletRequest)this.context.getRequest();
        this.response = (HttpServletResponse)this.context.getResponse();
        this.ParserRequest(this.request.getQueryString());
    }

    public static WebContext Current(PageContext pageContext) {
        return WebContext.Current(pageContext, true);
    }

    public static WebContext Current(PageContext pageContext, boolean bNew) {
        if (pageContext == null) {
            return null;
        }
        Object curContext = pageContext.getAttribute(SASRFWEBCONTEXT);
        if (curContext == null) {
            if (bNew) {
                WebContext curTemp = new WebContext(pageContext);
                return curTemp;
            }
            return null;
        }
        return (WebContext)curContext;
    }

    public PageContext getPageContext() {
        return this.context;
    }

    public void setPage(SRFPage page) {
        this.curPage = page;
    }

    public SRFPage getPage() {
        return this.curPage;
    }

    public void ParserCondition(String strCondition) {
        try {
            String strQueryString = new String(Base64.decode(strCondition));
            System.out.print(StringHelper.Format("ParseCondition [%1$s]\n", strQueryString));
            this.ParserRequest(strQueryString);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void ParserRequest(String strQueryString) {
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
                    if (StringHelper.Length(strValue) != 0) {
                        this.paramList.put(set[0].toUpperCase(), strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
    }

    public void setCurPageStyle(int nValue) {
        this.pageStyle = nValue;
    }

    public int getCurPageStyle() {
        return this.pageStyle;
    }

    public String getCurLanguage() {
        return "CN";
    }

    public String getCurUserId() {
        if (this.context.getSession().getAttribute("PERSONID") == null) {
            return "";
        }
        return this.context.getSession().getAttribute("PERSONID").toString();
    }

    public void setCurUserId(String strValue) {
        this.context.getSession().setAttribute("PERSONID", (Object)strValue);
    }

    public String getCurUserName() {
        if (this.context.getSession().getAttribute("UESRNAME") == null) {
            return "";
        }
        return this.context.getSession().getAttribute("UESRNAME").toString();
    }

    public void setCurUserName(String strValue) {
        this.context.getSession().setAttribute("UESRNAME", (Object)strValue);
    }

    public boolean getReload() {
        return this.GetBool(this.GetParamValue("RELOAD"), false);
    }

    public void setReload(boolean bValue) {
        this.SetParamValue("RELOAD", bValue ? "True" : "False");
    }

    public String getRU() {
        return this.GetParamValue("RU");
    }

    public void setRU(String value) {
        this.SetParamValue("RU", value);
    }

    public String getCurPageId() {
        return this.strCurPageId;
    }

    public void setCurPageId(String value) {
        this.strCurPageId = value;
    }

    public String getCurUserMode() {
        if (this.context.getSession().getAttribute("UESRMODE") == null) {
            return "DEFAULT";
        }
        return this.context.getSession().getAttribute("UESRMODE").toString();
    }

    public void setCurUserMode(String value) {
        this.context.getSession().setAttribute("UESRMODE", (Object)value);
    }

    public PrivilegesMgr getCurUserPrivs() {
        if (this.context.getSession().getAttribute("USERPRIVILEGESMGR") == null) {
            PrivilegesMgr privilegesMgr = this.CreatePrivilegesMgr();
            privilegesMgr.setFullPrivMode(true);
            this.context.getSession().setAttribute("USERPRIVILEGESMGR", (Object)privilegesMgr);
        }
        return (PrivilegesMgr)this.context.getSession().getAttribute("USERPRIVILEGESMGR");
    }

    protected PrivilegesMgr CreatePrivilegesMgr() {
        return new PrivilegesMgr();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BaseChartConfigMgr getUserCharts() {
        HttpSession httpSession = this.context.getSession();
        synchronized (httpSession) {
            if (this.context.getSession().getAttribute("SASRFUSERCHARTS") == null) {
                UserSessionChartConfigMgr userSessionChartConfigMgr = new UserSessionChartConfigMgr();
                this.context.getSession().setAttribute("SASRFUSERCHARTS", (Object)userSessionChartConfigMgr);
            }
        }
        return (BaseChartConfigMgr)this.context.getSession().getAttribute("SASRFUSERCHARTS");
    }

    public String getCurPageName() {
        return this.strCurPageName;
    }

    public void setCurPageName(String value) {
        this.strCurPageName = value;
    }

    public String getCurPagePath() {
        return this.strPagePath;
    }

    public void setCurPagePath(String value) {
        this.strPagePath = value;
    }

    public boolean getShowCondition() {
        return this.GetBool(this.GetParamValue("SHOWCONDITION"), true);
    }

    public void setShowCondition(boolean value) {
        if (value) {
            this.RemoveKey("SHOWCONDITION");
        } else {
            this.SetParamValue("SHOWCONDITION", value ? "True" : "False");
        }
    }

    public boolean getCopyMode() {
        return this.GetBool(this.GetParamValue("COPYMODE"), false);
    }

    public void setCopyMode(boolean value) {
        if (!value) {
            this.RemoveKey("COPYMODE");
        } else {
            this.SetParamValue("COPYMODE", value ? "True" : "False");
        }
    }

    public WebConfig getWebConfig() {
        return (WebConfig)this.context.getServletContext().getAttribute("SRFWEBCONFIG");
    }

    public String getUITheme() {
        return this.strUITheme;
    }

    public void setUITheme(String value) {
        this.strUITheme = value;
    }

    public String getIFrameName() {
        return this.GetParamValue("IF_NAME");
    }

    public int getPageNO() {
        return this.GetInt(this.GetParamValue("PAGENO"), 1);
    }

    public void setPageNO(int value) {
        this.paramList.put("PAGENO", Integer.valueOf(value).toString());
    }

    public int getOrderFieldId() {
        return this.GetInt(this.GetParamValue("ORDERFIELDID"), -1);
    }

    public void setOrderFieldId(int value) {
        this.paramList.put("ORDERFIELDID", Integer.valueOf(value).toString());
    }

    public int getOrderDirect() {
        return this.GetInt(this.GetParamValue("ORDERDIRECT"), -1);
    }

    public void setOrderDirect(int value) {
        this.paramList.put("ORDERDIRECT", Integer.valueOf(value).toString());
    }

    public String getExcelExportId() {
        return this.GetParamValue("EXCELEXPORTID");
    }

    public String getMenuMode() {
        return this.GetParamValue("MENUMODE");
    }

    public void setMenuMode(String value) {
        this.SetParamValue("MENUMODE", value);
    }

    public int getShowTabView() {
        return this.GetInt(this.GetParamValue("SHOWTABVIEW"), -1);
    }

    public void setShowTabView(int value) {
        this.SetParamValue("SHOWTABVIEW", Integer.valueOf(value).toString());
    }

    public SearchFormMgr getSearchForms() {
        return (SearchFormMgr)this.context.getServletContext().getAttribute("SRFSEARCHFORMMGR");
    }

    public IconViewMgr getIconViews() {
        return (IconViewMgr)this.context.getServletContext().getAttribute("SRFICONVIEWMGR");
    }

    public DynamicFormMgr getDynamicForms() {
        return (DynamicFormMgr)this.context.getServletContext().getAttribute("SRFDYNAMICFORMMGR");
    }

    public MenuConfig getUserMenu() {
        MenuConfigMgr menuConfigMgr = this.getMenus();
        if (menuConfigMgr != null) {
            return menuConfigMgr.Get(this.getCurUserMode());
        }
        return null;
    }

    public MenuConfigMgr getMenus() {
        return (MenuConfigMgr)this.context.getServletContext().getAttribute("SRFMENUMGR");
    }

    public PageConfigMgr getPages() {
        return (PageConfigMgr)this.context.getServletContext().getAttribute("SRFPAGEMGR");
    }

    public SubViewMgr getSubViews() {
        return (SubViewMgr)this.context.getServletContext().getAttribute("SRFSUBVIEWMGR");
    }

    public int getSearch() {
        String strValue = this.GetParamValue("SEARCHMODE");
        if (strValue.compareToIgnoreCase("ADVANCE") == 0) {
            return 2;
        }
        return 1;
    }

    public void setSearch(int value) {
        if (2 == value) {
            this.paramList.put("SEARCHMODE", "ADVANCE");
        } else {
            this.paramList.put("SEARCHMODE", "NORMAL");
        }
    }

    public void setSearchCond(String value) {
        this.SetParamValue("SEARCHCOND", value);
    }

    public String getSearchCond() {
        return this.GetParamValue("SEARCHCOND");
    }

    public boolean getLoadSC() {
        return this.GetBool(this.GetParamValue("LOADSC"), true);
    }

    public void setLoadSC(boolean value) {
        if (value) {
            this.RemoveKey("LOADSC");
        } else {
            this.SetParamValue("LOADSC", value ? "True" : "False");
        }
    }

    public boolean getPickMode() {
        return this.GetBool(this.GetParamValue("PICKMODE"), true);
    }

    public void setPickMode(boolean value) {
        if (value) {
            this.RemoveKey("PICKMODE");
        } else {
            this.SetParamValue("PICKMODE", value ? "True" : "False");
        }
    }

    public WebThemeConfig getCurThemeConfig() {
        WebThemeMgr webThemeMgr = (WebThemeMgr)this.context.getServletContext().getAttribute("SRFTHEMEMGR");
        return webThemeMgr.Get(this.strUITheme);
    }

    public DBCallConfigMgr getDBCallConfigs() {
        DBCallConfigMgr dbCaller = (DBCallConfigMgr)this.context.getServletContext().getAttribute("SRFDBCALLERMGR");
        return dbCaller;
    }

    public BaseDBCallerHelper getDBCaller() {
        BaseDBCallerHelper dbCaller = (BaseDBCallerHelper)this.context.getServletContext().getAttribute("SRFDBCALLERHELPER");
        return dbCaller;
    }

    public MainListMgr getMainLists() {
        MainListMgr mainListMgr = (MainListMgr)this.context.getServletContext().getAttribute("SRFMAINLISTMGR");
        return mainListMgr;
    }

    public SubListMgr getSubLists() {
        SubListMgr subListMgr = (SubListMgr)this.context.getServletContext().getAttribute("SRFSUBLISTMGR");
        return subListMgr;
    }

    public TipsMgr getTips() {
        TipsMgr tipsMgr = (TipsMgr)this.context.getServletContext().getAttribute("SRFTIPSMGR");
        return tipsMgr;
    }

    public void RemoveKey(String strKey) {
        if (this.paramList.containsKey(strKey)) {
            this.paramList.remove(strKey);
        }
    }

    public String GetParamValue(String strParamName) {
        if (this.paramList.containsKey(strParamName = strParamName.toUpperCase())) {
            return this.paramList.get(strParamName).toString();
        }
        return "";
    }

    public void SetParamValue(String strParamName, String strParamValue) {
        strParamName = strParamName.toUpperCase();
        this.paramList.put(strParamName, strParamValue);
    }

    protected int GetInt(String strValue, int nDefault) {
        if (strValue.length() == 0) {
            return nDefault;
        }
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    protected boolean GetBool(String strValue, boolean bDefault) {
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

    public String GetQueryString() {
        String strURLCall = "";
        Enumeration enumeration = this.paramList.keys();
        while (enumeration.hasMoreElements()) {
            String strName = (String)enumeration.nextElement();
            String strValue = (String)this.paramList.get(strName);
            if (strValue.length() == 0) continue;
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

    public String GetSystemCall() {
        String strQueryString = "";
        Hashtable systemCallList = (Hashtable)this.context.getServletContext().getAttribute("SRFSYSTEMCALLLIST");
        Enumeration enumeration = this.paramList.keys();
        while (enumeration.hasMoreElements()) {
            String strValue;
            String strKey = (String)enumeration.nextElement();
            if (!systemCallList.containsKey(strKey) || StringHelper.StringLength(strValue = this.paramList.get(strKey).toString()) == 0) continue;
            if (strQueryString.length() > 0) {
                strQueryString = String.valueOf(strQueryString) + "&";
            }
            strQueryString = String.valueOf(strQueryString) + strKey;
            strQueryString = String.valueOf(strQueryString) + "=";
            try {
                strQueryString = String.valueOf(strQueryString) + URLEncoder.encode(strValue, "UTF-8");
            }
            catch (Exception ex) {
                strQueryString = String.valueOf(strQueryString) + strValue;
            }
        }
        return strQueryString;
    }

    public void Logout() {
        this.context.getSession().removeAttribute("PERSONID");
        this.context.getSession().removeAttribute("UESRNAME");
        this.context.getSession().removeAttribute("UESRMODE");
    }
}

