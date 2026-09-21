/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.jsp.JspWriter
 *  javax.servlet.jsp.PageContext
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.INamingContainer;
import SA.SRFramework.Web.SRFCommonEventImpl;
import SA.SRFramework.Web.ViewStates;
import SA.SRFramework.Web.WebContext;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

public class SRFPage
extends SRFCommonEventImpl
implements INamingContainer {
    private String strFormId = "Form1";
    protected static String __VIEWSTATE = "__VIEWSTATE";
    protected static String __EVENTTARGET = "__EVENTTARGET";
    protected static String __EVENTARGUMENT = "__EVENTARGUMENT";
    protected Hashtable pageParams = null;
    protected PageContext pageContext = null;
    protected ViewStates viewStates = new ViewStates();
    protected boolean bIsPostBack = true;
    protected boolean bIsFinishLoad = false;
    protected String strEventTarget = "";
    protected String strEventArgument = "";
    protected Hashtable startupScripts = null;
    protected Hashtable startupScripts2 = null;
    protected String strActionPath = "";

    public SRFPage() {
        this.setPage(this);
    }

    public void Init(PageContext context) {
        String strViewState;
        String strContextPath;
        int nContextPathPos;
        this.pageContext = context;
        this.getResponse().addHeader("cache-control", "no-cache");
        this.getResponse().addHeader("expires", "thu, 01 jan 1970 00:00:01 gmt");
        this.setWebContext(this.CreateWebContext(context));
        this.getWebContext().setPage(this);
        String strCurPath = this.getRequest().getRequestURL().toString();
        int nPos = strCurPath.lastIndexOf("/");
        if (nPos != -1 && strCurPath.length() - 1 > nPos) {
            this.getWebContext().setCurPageName(strCurPath.substring(nPos + 1));
        }
        if ((nContextPathPos = strCurPath.indexOf(strContextPath = this.getRequest().getContextPath())) != -1) {
            strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
        }
        this.getWebContext().setCurPagePath(strCurPath);
        this.strActionPath = this.getWebContext().getCurPageName();
        if (StringHelper.StringLength(this.getRequest().getQueryString()) != 0) {
            this.strActionPath = String.valueOf(this.strActionPath) + "?";
            this.strActionPath = String.valueOf(this.strActionPath) + this.getRequest().getQueryString();
        }
        if ((strViewState = context.getRequest().getParameter(String.valueOf(this.getID()) + __VIEWSTATE)) == null) {
            this.bIsPostBack = false;
        } else {
            this.viewStates.fromString(strViewState);
            this.strEventTarget = context.getRequest().getParameter(__EVENTTARGET);
            this.strEventArgument = context.getRequest().getParameter(__EVENTARGUMENT);
        }
        this.OnInit(context);
    }

    protected void OnInit(PageContext context) {
    }

    protected WebContext CreateWebContext(PageContext context) {
        return WebContext.Current(this.pageContext);
    }

    public void setFormId(String strValue) {
        this.strFormId = strValue;
    }

    public String getFormId() {
        return this.strFormId;
    }

    public String getEventTarget() {
        return this.strEventTarget;
    }

    public String getEventArgument() {
        return this.strEventArgument;
    }

    public void Load() {
        this.OnInitComponents();
        if (this.bIsPostBack) {
            this.ReadFromViewStates();
            this.InitFromRequest();
        }
        this.OnLoad();
        if (this.bIsPostBack) {
            this.RaiseControlEvents();
        }
        this.bIsFinishLoad = true;
    }

    protected void OnInitComponents() {
    }

    protected void OnLoad() {
    }

    public String getAction() {
        return this.strActionPath;
    }

    public boolean getIsPostBack() {
        return this.bIsPostBack;
    }

    public boolean getIsFinishLoad() {
        return this.bIsFinishLoad;
    }

    public String getDefaultPageCode() {
        String strOutput = "";
        if (StringHelper.StringLength(this.getID()) == 0) {
            strOutput = String.valueOf(strOutput) + " <input type=\"hidden\" name=\"__EVENTTARGET\" value=\"\" />\n";
            strOutput = String.valueOf(strOutput) + " <input type=\"hidden\" name=\"__EVENTARGUMENT\" value=\"\" />\n";
        }
        if (StringHelper.StringLength(this.getID()) == 0) {
            strOutput = String.valueOf(strOutput) + " <script language=\"javascript\" type=\"text/javascript\">\n";
            strOutput = String.valueOf(strOutput) + "<!--\n";
            strOutput = String.valueOf(strOutput) + "  function __doPostBack(eventTarget, eventArgument) {\n";
            strOutput = String.valueOf(strOutput) + "          var theform;\n";
            strOutput = String.valueOf(strOutput) + "         if (window.navigator.appName.toLowerCase().indexOf(\"microsoft\") > -1) {\n";
            strOutput = String.valueOf(strOutput) + "                 theform = document." + this.getFormId() + ";\n";
            strOutput = String.valueOf(strOutput) + "         }\n";
            strOutput = String.valueOf(strOutput) + "         else {\n";
            strOutput = String.valueOf(strOutput) + "                 theform = document.forms[\"" + this.getFormId() + "\"];\n";
            strOutput = String.valueOf(strOutput) + "         }\n";
            strOutput = String.valueOf(strOutput) + "         theform.__EVENTTARGET.value = eventTarget.split(\"$\").join(\":\");\n";
            strOutput = String.valueOf(strOutput) + "         theform.__EVENTARGUMENT.value = eventArgument;\n";
            strOutput = String.valueOf(strOutput) + "         theform.submit();\n";
            strOutput = String.valueOf(strOutput) + "  }\n";
            strOutput = String.valueOf(strOutput) + "// -->\n";
            strOutput = String.valueOf(strOutput) + "</script>\n\n";
        }
        return strOutput;
    }

    public JspWriter getOUTPUT() {
        return this.pageContext.getOut();
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest)this.pageContext.getRequest();
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse)this.pageContext.getResponse();
    }

    public ViewStates getViewStates() {
        return this.viewStates;
    }

    public void setApplication(String strKey, Object objValue) {
        this.pageContext.getServletContext().setAttribute(strKey, objValue);
    }

    public Object getApplication(String strKey) {
        return this.pageContext.getServletContext().getAttribute(strKey);
    }

    public synchronized void RegisterStartupScript(String strName, String strJscript) {
        if (this.startupScripts == null) {
            this.startupScripts = new Hashtable();
        }
        this.startupScripts.put(strName, strJscript);
    }

    public synchronized void RegisterStartupScript2(String strName, String strJscript) {
        if (this.startupScripts2 == null) {
            this.startupScripts2 = new Hashtable();
        }
        this.startupScripts2.put(strName, strJscript);
    }

    public synchronized String getStartupScript() {
        String strValue;
        String strName;
        Enumeration enumeration;
        String strOutput = "";
        strOutput = this.getPageViewState();
        if (this.startupScripts != null) {
            enumeration = this.startupScripts.keys();
            while (enumeration.hasMoreElements()) {
                strName = (String)enumeration.nextElement();
                strValue = (String)this.startupScripts.get(strName);
                if (StringHelper.StringLength(strValue) == 0) continue;
                strOutput = String.valueOf(strOutput) + "\n";
                strOutput = String.valueOf(strOutput) + strValue;
            }
        }
        if (this.startupScripts2 != null) {
            strOutput = String.valueOf(strOutput) + "<SCRIPT language=\"javascript\" type=\"text/javascript\">\n";
            enumeration = this.startupScripts2.keys();
            while (enumeration.hasMoreElements()) {
                strName = (String)enumeration.nextElement();
                strValue = (String)this.startupScripts2.get(strName);
                if (StringHelper.StringLength(strValue) == 0) continue;
                strOutput = String.valueOf(strOutput) + "\n";
                strOutput = String.valueOf(strOutput) + strValue;
            }
            strOutput = String.valueOf(strOutput) + "\n</SCRIPT>";
        }
        return strOutput;
    }

    public String getEndPageCode() {
        return this.getStartupScript();
    }

    protected String getPageViewState() {
        this.WriteToViewStates();
        String strOutput = "";
        strOutput = String.valueOf(strOutput) + String.format("<input type=\"hidden\" name=\"%1$s\" value=\"%2$s\" />", String.valueOf(this.getID()) + __VIEWSTATE, this.viewStates.toString());
        return strOutput;
    }

    public void setPageParam(String strName, Object strValue) {
        if (this.pageParams == null) {
            this.pageParams = new Hashtable();
        }
        this.pageParams.put(strName, strValue);
    }

    public Object getPageParam(String strName) {
        if (this.pageParams == null) {
            return null;
        }
        if (this.pageParams.containsKey(strName)) {
            return this.pageParams.get(strName);
        }
        return null;
    }
}

