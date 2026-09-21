/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpServletRequest
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.DBCallConfigMgr;
import SA.SRFramework.Report.Web.Storage.BaseChartConfigMgr;
import SA.SRFramework.Report.Web.Storage.UserSessionChartConfigMgr;
import SA.SRFramework.Security.PrivilegesMgr;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Data.WebDBCallerHelper;
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
import SA.SRFramework.Web.WebConfig;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class WebServletContext {
    protected Hashtable paramList = new Hashtable();
    protected HttpServletRequest request = null;
    protected ServletContext servletContext = null;

    public WebServletContext(ServletContext servletContext, HttpServletRequest request) {
        this.servletContext = servletContext;
        this.request = request;
        this.ParserRequest(request.getQueryString());
    }

    public void ParserCondition(String strCondition) {
        try {
            String strQueryString = new String(Base64.decode(strCondition));
            this.ParserRequest(strQueryString);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
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
                catch (Exception exception) {
                    // empty catch block
                }
            }
            ++i;
        }
    }

    public String getCurLanguage() {
        return "CN";
    }

    public String getCurUserId() {
        if (this.request.getSession().getAttribute("PERSONID") == null) {
            return "";
        }
        return this.request.getSession().getAttribute("PERSONID").toString();
    }

    public void setCurUserId(String strValue) {
        this.request.getSession().setAttribute("PERSONID", (Object)strValue);
    }

    public String getCurUserName() {
        if (this.request.getSession().getAttribute("UESRNAME") == null) {
            return "";
        }
        return this.request.getSession().getAttribute("UESRNAME").toString();
    }

    public void setCurUserName(String strValue) {
        this.request.getSession().setAttribute("UESRNAME", (Object)strValue);
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

    public String getCurUserMode() {
        if (this.request.getSession().getAttribute("UESRMODE") == null) {
            return "DEFAULT";
        }
        return this.request.getSession().getAttribute("UESRMODE").toString();
    }

    public void setCurUserMode(String value) {
        this.request.getSession().setAttribute("UESRMODE", (Object)value);
    }

    public PrivilegesMgr getCurUserPrivs() {
        if (this.request.getSession().getAttribute("USERPRIVILEGESMGR") == null) {
            PrivilegesMgr privilegesMgr = this.CreatePrivilegesMgr();
            privilegesMgr.setFullPrivMode(true);
            this.request.getSession().setAttribute("USERPRIVILEGESMGR", (Object)privilegesMgr);
        }
        return (PrivilegesMgr)this.request.getSession().getAttribute("USERPRIVILEGESMGR");
    }

    protected PrivilegesMgr CreatePrivilegesMgr() {
        return new PrivilegesMgr();
    }

    public BaseChartConfigMgr getUserCharts() {
        if (this.request.getSession().getAttribute("SASRFUSERCHARTS") == null) {
            UserSessionChartConfigMgr userSessionChartConfigMgr = new UserSessionChartConfigMgr();
            this.request.getSession().setAttribute("SASRFUSERCHARTS", (Object)userSessionChartConfigMgr);
        }
        return (BaseChartConfigMgr)this.request.getSession().getAttribute("SASRFUSERCHARTS");
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
        return (WebConfig)this.servletContext.getAttribute("SRFWEBCONFIG");
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
        return (SearchFormMgr)this.servletContext.getAttribute("SRFSEARCHFORMMGR");
    }

    public IconViewMgr getIconViews() {
        return (IconViewMgr)this.servletContext.getAttribute("SRFICONVIEWMGR");
    }

    public DynamicFormMgr getDynamicForms() {
        return (DynamicFormMgr)this.servletContext.getAttribute("SRFDYNAMICFORMMGR");
    }

    public MenuConfig getUserMenu() {
        MenuConfigMgr menuConfigMgr = this.getMenus();
        if (menuConfigMgr != null) {
            return menuConfigMgr.Get(this.getCurUserMode());
        }
        return null;
    }

    public MenuConfigMgr getMenus() {
        return (MenuConfigMgr)this.servletContext.getAttribute("SRFMENUMGR");
    }

    public PageConfigMgr getPages() {
        return (PageConfigMgr)this.servletContext.getAttribute("SRFPAGEMGR");
    }

    public SubViewMgr getSubViews() {
        return (SubViewMgr)this.servletContext.getAttribute("SRFSUBVIEWMGR");
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

    public DBCallConfigMgr getDBCallConfigs() {
        DBCallConfigMgr dbCaller = (DBCallConfigMgr)this.servletContext.getAttribute("SRFDBCALLERMGR");
        return dbCaller;
    }

    public WebDBCallerHelper getDBCaller() {
        WebDBCallerHelper dbCaller = (WebDBCallerHelper)this.servletContext.getAttribute("SRFDBCALLERHELPER");
        return dbCaller;
    }

    public MainListMgr getMainLists() {
        MainListMgr mainListMgr = (MainListMgr)this.servletContext.getAttribute("SRFMAINLISTMGR");
        return mainListMgr;
    }

    public SubListMgr getSubLists() {
        SubListMgr subListMgr = (SubListMgr)this.servletContext.getAttribute("SRFSUBLISTMGR");
        return subListMgr;
    }

    public TipsMgr getTips() {
        TipsMgr tipsMgr = (TipsMgr)this.servletContext.getAttribute("SRFTIPSMGR");
        return tipsMgr;
    }

    public void RemoveKey(String strKey) {
        if (this.paramList.containsKey(strKey)) {
            this.paramList.remove(strKey);
        }
    }

    public String GetParamValue(String strParamName) {
        if (this.paramList.containsKey(strParamName)) {
            return this.paramList.get(strParamName).toString();
        }
        return "";
    }

    public void SetParamValue(String strParamName, String strParamValue) {
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
        Hashtable systemCallList = (Hashtable)this.servletContext.getAttribute("SRFSYSTEMCALLLIST");
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
        this.request.getSession().removeAttribute("PERSONID");
        this.request.getSession().removeAttribute("UESRNAME");
        this.request.getSession().removeAttribute("UESRMODE");
    }
}

