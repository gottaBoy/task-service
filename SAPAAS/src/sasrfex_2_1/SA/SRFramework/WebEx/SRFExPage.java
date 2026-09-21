/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.INamingContainer
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.jsp.PageContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.INamingContainer;
import SA.SRFramework.WebEx.Button.SRFExButtonActionHelper;
import SA.SRFramework.WebEx.DGEx.SRFExDGExActionHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExFormActionHelper;
import SA.SRFramework.WebEx.ISRFExUserSessionMgr;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGridActionHelper;
import SA.SRFramework.WebEx.SRFExForms;
import SA.SRFramework.WebEx.SRFExTreeActionHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.ISRFExPOLogger;
import SA.SRFramework.WebEx.Utility.JSHelper;
import SA.SRFramework.WebEx.Utility.Jsp.SimplePageContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExPage
extends SRFExControl
implements INamingContainer {
    public static final int SCRIPTRUN_REALTIME = 0;
    public static final int SCRIPTRUN_BEFOREINITUI = 1;
    public static final int SCRIPTRUN_INITUI = 2;
    public static final int SCRIPTRUN_AFTERINITUI = 3;
    public static final int SCRIPTRUN_BEFORELOADDATA = 4;
    public static final int SCRIPTRUN_LOADDATA = 5;
    public static final int SCRIPTRUN_AFTERLOADDATA = 6;
    public static final String ACCESSDENY_MAJORURL = "ACCESSDENY_MAJORURL";
    public static final String ACCESSDENY_MINORURL = "ACCESSDENY_MINORURL";
    public static final String TAG_SENDREDIRECT = "SENDREDIRECT";
    protected boolean bBackEndMode = false;
    protected PageContext pageContext = null;
    protected SRFExWebContext webContext = null;
    protected SRFExForms forms = new SRFExForms(this);
    protected String strDefaultBackEndUrl = "";
    protected Map<Integer, String> scriptSet = null;
    protected Map<Integer, String> readyScriptSet = null;
    protected Map<Integer, String> scriptSetUncache = null;
    protected Map<Integer, String> readyScriptSetUncache = null;
    protected String strDefaultFormId = "";
    protected boolean bMainPage = false;
    protected boolean bDialogPage = false;
    private static final Log log = LogFactory.getLog(SRFExPage.class);
    protected Map<String, String> actionHelper = null;
    protected Integer nChildControlIndex = 0;
    protected String strResourceId = null;
    protected boolean bPrivilegeTestOk = false;
    protected boolean bUserInit = false;
    protected ArrayList<String> output = null;
    protected boolean bOutputDebug = true;
    protected boolean bOptimize = true;
    protected boolean bOptimizeEx = false;
    protected boolean bJSCache = false;
    protected boolean bIsStop = false;
    protected boolean bNoCache = true;
    protected boolean bControlValueFromUniqueId = true;
    protected int nFrontUIStyle = 1;
    private static String strMultiLanguageHeader = null;
    protected static Hashtable<String, String> appUIThemeMap = new Hashtable();
    protected static boolean bAlertOnReadyCatch = false;
    private long nPageStartProcessTime = 0L;
    private long nPageLastProcessTime = 0L;
    private static final String TAG_SM1 = "{A72E0CE7-3F75-4b84-BF06-7E91A0182C09}";
    private static final String TAG_SM2 = "{6D72D37E-29B4-42ad-A47F-697320B27611}";
    private static final String TAG_SM3 = "{CD9BA0FC-12CB-414b-8130-1285A2917050}";
    private static final String TAG_SM4 = "{C0E71D58-B43E-4553-AEA1-009A3BD75CC5}";
    private SRFExAjaxActionResult ajaxActionResult = null;
    private boolean bSimulateRequest = false;

    public SRFExPage() {
        this.setPage(this);
        this.nPageLastProcessTime = this.nPageStartProcessTime = new Date().getTime();
    }

    public final void Init(PageContext context) {
        this.pageContext = context;
        this.bBackEndMode = false;
        this.webContext = this.CreateWebContext();
        if (!this.sm1()) {
            return;
        }
        this.bOptimize = this.getWebContext().getWebConfig().GetExtValue("OPTIMIZE", this.bOptimize);
        this.bOptimizeEx = this.getWebContext().getWebConfig().GetExtValue("OPTIMIZEEX", this.bOptimizeEx);
        if (!this.webContext.getDialogMode()) {
            this.webContext.setDialogMode(this.bDialogPage);
        }
        if (this.bNoCache) {
            this.getResponse().addHeader("cache-control", "no-cache");
            this.getResponse().addHeader("expires", "thu, 01 jan 1970 00:00:01 gmt");
        }
        this.actionHelper = new TreeMap<String, String>();
        if (this.bUserInit) {
            this.OnUserInit();
            return;
        }
        if (!this.PreparePageEnv()) {
            return;
        }
        if (!this.AfterPreparePageEnv()) {
            return;
        }
        this.DebugProcessTime("AfterPreparePageEnv");
        this.bPrivilegeTestOk = this.TestPagePrivilege();
        if (!this.bPrivilegeTestOk) {
            this.OnTestPagePrivilegeFailed();
            return;
        }
        this.OnInitComponents();
        this.DebugProcessTime("OnInitComponents");
        this.OnInit();
        this.DebugProcessTime("OnInit");
    }

    public final void InitImitatedMode(SimplePageContext context) {
        this.bSimulateRequest = true;
        this.pageContext = context;
        this.bBackEndMode = false;
        this.webContext = this.CreateWebContext();
        this.bOptimize = this.getWebContext().getWebConfig().GetExtValue("OPTIMIZE", this.bOptimize);
        this.bOptimizeEx = this.getWebContext().getWebConfig().GetExtValue("OPTIMIZEEX", this.bOptimizeEx);
        if (!this.webContext.getDialogMode()) {
            this.webContext.setDialogMode(this.bDialogPage);
        }
        this.actionHelper = new TreeMap<String, String>();
        if (this.bUserInit) {
            this.OnUserInit();
            return;
        }
        if (!this.PreparePageEnv()) {
            return;
        }
        if (!this.AfterPreparePageEnv()) {
            return;
        }
        this.OnInitComponents();
        this.OnInit();
    }

    public final boolean isImitatedMode() {
        return this.bSimulateRequest;
    }

    @Override
    protected void OnInit() {
    }

    public final void InitBackEnd(PageContext context) {
        this.pageContext = context;
        this.bBackEndMode = true;
        this.webContext = this.CreateWebContext();
        if (!this.sm3()) {
            return;
        }
        this.bOptimize = this.getWebContext().getWebConfig().GetExtValue("OPTIMIZE", this.bOptimize);
        this.bOptimizeEx = this.getWebContext().getWebConfig().GetExtValue("OPTIMIZEEX", this.bOptimizeEx);
        if (this.bNoCache) {
            this.getResponse().addHeader("cache-control", "no-cache");
            this.getResponse().addHeader("expires", "thu, 01 jan 1970 00:00:01 gmt");
        }
        this.actionHelper = new TreeMap<String, String>();
        if (this.bUserInit) {
            this.OnUserInitBackEnd();
            return;
        }
        if (!this.PreparePageEnv()) {
            return;
        }
        if (!this.AfterPreparePageEnv()) {
            return;
        }
        this.DebugProcessTime("AfterPreparePageEnv");
        this.bPrivilegeTestOk = this.TestPagePrivilege();
        if (!this.bPrivilegeTestOk) {
            this.OnTestPagePrivilegeFailed();
            return;
        }
        this.OnInitComponents();
        this.DebugProcessTime("OnInitComponents");
        this.OnInitBackEnd();
        this.DebugProcessTime("OnInitBackEnd");
    }

    protected void OnTestPagePrivilegeFailed() {
        if (this.IsBackEndMode()) {
            SRFExAjaxActionResult actionResult = new SRFExAjaxActionResult();
            actionResult.setRetCode(2);
            try {
                this.getWriter().write(actionResult.ToJSONString());
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            boolean bSendRedirect = false;
            Object objSendRedirect = this.getRequest().getAttribute(TAG_SENDREDIRECT);
            if (objSendRedirect != null && objSendRedirect instanceof Boolean) {
                bSendRedirect = (Boolean)objSendRedirect;
            }
            if (!bSendRedirect) {
                String strAccessDenyURL = "";
                strAccessDenyURL = this.getMainPage() ? this.getWebContext().getWebConfig().GetExtValue(ACCESSDENY_MAJORURL, "../commonex/accessdeny_major.jsp") : this.getWebContext().getWebConfig().GetExtValue(ACCESSDENY_MINORURL, "../commonex/accessdeny_minor.jsp");
                try {
                    this.getResponse().sendRedirect(strAccessDenyURL);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    protected boolean PreparePageEnv() {
        this.getWebContext().setCurPageName(this.getCurPageName());
        this.getWebContext().setCurPagePath(this.getCurPagePath());
        return true;
    }

    protected boolean AfterPreparePageEnv() {
        return true;
    }

    protected void OnInitBackEnd() {
    }

    protected void OnUserInit() {
    }

    protected void OnUserInitBackEnd() {
    }

    protected String getCurPageName() {
        String strCurPath = this.getRequest().getRequestURL().toString();
        int nPos = strCurPath.lastIndexOf("/");
        if (nPos != -1 && strCurPath.length() - 1 > nPos) {
            return strCurPath.substring(nPos + 1);
        }
        return "";
    }

    protected String getCurPagePath() {
        String strContextPath;
        String strCurPath = this.getRequest().getRequestURL().toString();
        int nContextPathPos = strCurPath.indexOf(strContextPath = this.getRequest().getContextPath());
        if (nContextPathPos != -1) {
            strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
        }
        return strCurPath;
    }

    protected boolean TestPagePrivilege() {
        String strResourceId = this.getResourceId();
        if (StringHelper.Length((String)strResourceId) == 0) {
            return true;
        }
        IUserPrivilegeMgr iUserPrivilegeMgr = this.getWebContext().GetUserPrivilegeMgr();
        if (iUserPrivilegeMgr == null) {
            return false;
        }
        iUserPrivilegeMgr.LogTest(this.webContext, this, strResourceId);
        return iUserPrivilegeMgr.Test(this.getWebContext(), strResourceId);
    }

    protected boolean OnFormAction(String strFormId, String strAction) {
        SRFExAjaxActionResult result = new SRFExAjaxActionResult();
        result.setRetCode(1);
        result.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u8868\u5355[%1$s]\u64cd\u4f5c[%2$s]", (Object)strFormId, (Object)strAction));
        this.getPage().Output(result.ToJSONString());
        return false;
    }

    protected boolean OnDataGridAction(String strDataGridId, String strAction) {
        SRFExAjaxActionResult result = new SRFExAjaxActionResult();
        result.setRetCode(1);
        result.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u8868\u683c[%1$s]\u64cd\u4f5c[%2$s]", (Object)strDataGridId, (Object)strAction));
        this.getPage().Output(result.ToJSONString());
        return false;
    }

    protected boolean OnDGExAction(String strDGExId, String strAction) {
        SRFExAjaxActionResult result = new SRFExAjaxActionResult();
        result.setRetCode(1);
        result.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u6269\u5c55\u8868\u683c[%1$s]\u64cd\u4f5c[%2$s]", (Object)strDGExId, (Object)strAction));
        this.getPage().Output(result.ToJSONString());
        return false;
    }

    protected boolean OnTreeAction(String strTreeId, String strAction) {
        return false;
    }

    protected boolean OnButtonAction(String strButtonId, String strAction) {
        SRFExAjaxActionResult result = new SRFExAjaxActionResult();
        result.setRetCode(1);
        result.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u6309\u94ae[%1$s]\u64cd\u4f5c[%2$s]", (Object)strButtonId, (Object)strAction));
        this.getPage().Output(result.ToJSONString());
        return false;
    }

    protected boolean OnCustomAction(String strActionType, String strAction) {
        SRFExAjaxActionResult result = new SRFExAjaxActionResult();
        if (this.IsPrivilegeTestOK()) {
            result.setRetCode(1);
            result.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u81ea\u5b9a\u4e49\u64cd\u4f5c[%1$s]\u64cd\u4f5c[%2$s]", (Object)strActionType, (Object)strAction));
        } else {
            result.setRetCode(2);
            result.setErrorInfo(this.OnGetAccessDenyMsg());
        }
        this.getPage().Output(result.ToJSONString());
        return false;
    }

    protected String OnGetAccessDenyMsg() {
        return this.getWebContext().getWebExConfig().GetValue("SYSMSG", "ACCESSDENYBACKEND", "\u53ef\u80fd\u7531\u4e8e\u957f\u65f6\u95f4\u6ca1\u6709\u64cd\u4f5c\u7cfb\u7edf\uff0c\u7cfb\u7edf\u5df2\u5c06\u60a8\u7684\u8eab\u4efd\u81ea\u52a8\u6ce8\u9500\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u7cfb\u7edf\u518d\u8fdb\u884c\u64cd\u4f5c\uff01");
    }

    protected void OnInitComponents() {
    }

    public final void Load() {
        if (!this.bPrivilegeTestOk) {
            return;
        }
        this.OnLoad();
        this.DebugProcessTime("Load");
    }

    protected void OnLoad() {
    }

    public final void LoadBackEnd() {
        if (!this.bPrivilegeTestOk) {
            return;
        }
        this.OnLoadBackEnd();
        this.DebugProcessTime("LoadBackEnd");
        this.LogPagePerformance();
    }

    protected void OnLoadBackEnd() {
        String strTreeId;
        String strButtonId;
        String strDGExId;
        String strDataGridId;
        String strFormId;
        String strActionType = this.webContext.getActionType();
        String strAction = this.webContext.getAction();
        String strActionHelper = this.webContext.getActionHelper();
        if (StringHelper.Compare((String)"formaction", (String)strActionType, (boolean)true) == 0 && StringHelper.Length((String)(strFormId = this.webContext.getFormId())) > 0) {
            SRFExFormActionHelper formActionHelper = this.getFormActionHelper(strFormId);
            if (formActionHelper != null && formActionHelper.Process(this, strFormId, strAction)) {
                return;
            }
            if (!this.OnFormAction(strFormId, strAction)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u8868\u5355[%1$s]\u64cd\u4f5c[%2$s]", (Object)strFormId, (Object)strAction));
            }
            return;
        }
        if (StringHelper.Compare((String)"gridaction", (String)strActionType, (boolean)true) == 0 && StringHelper.Length((String)(strDataGridId = this.webContext.getGridId())) > 0) {
            SRFExDataGridActionHelper dataGridActionHelper = this.getDataGridActionHelper(strDataGridId);
            if (dataGridActionHelper != null && dataGridActionHelper.Process(this, strDataGridId, strAction)) {
                return;
            }
            if (!this.OnDataGridAction(strDataGridId, this.webContext.getAction())) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u8868\u683c[%1$s]\u64cd\u4f5c[%2$s]", (Object)strDataGridId, (Object)strAction));
            }
            return;
        }
        if (StringHelper.Compare((String)"gridexaction", (String)strActionType, (boolean)true) == 0 && StringHelper.Length((String)(strDGExId = this.webContext.getGridId())) > 0) {
            SRFExDGExActionHelper dgExActionHelper = this.getDGExActionHelper(strDGExId);
            if (dgExActionHelper != null && dgExActionHelper.Process(this, strDGExId, strAction)) {
                return;
            }
            if (!this.OnDGExAction(strDGExId, this.webContext.getAction())) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u6269\u5c55\u8868\u683c[%1$s]\u64cd\u4f5c[%2$s]", (Object)strDGExId, (Object)strAction));
            }
            return;
        }
        if (StringHelper.Compare((String)"buttonaction", (String)strActionType, (boolean)true) == 0 && StringHelper.Length((String)(strButtonId = this.webContext.getButtonId())) > 0) {
            SRFExButtonActionHelper buttonActionHelper;
            if (!StringHelper.IsNullOrEmpty((String)strActionHelper)) {
                this.RegisterButtonActionHelper(strButtonId, strActionHelper);
            }
            if ((buttonActionHelper = this.getButtonActionHelper(strButtonId)) != null && buttonActionHelper.Process(this, strButtonId, strAction)) {
                return;
            }
            if (!this.OnButtonAction(strButtonId, this.webContext.getAction())) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u6309\u94ae[%1$s]\u64cd\u4f5c[%2$s]", (Object)strButtonId, (Object)strAction));
            }
            return;
        }
        if (StringHelper.Compare((String)"treeaction", (String)strActionType, (boolean)true) == 0 && StringHelper.Length((String)(strTreeId = this.webContext.getTreeId())) > 0) {
            SRFExTreeActionHelper treeActionHelper = this.getTreeActionHelper(strTreeId);
            if (treeActionHelper != null && treeActionHelper.Process(this, strTreeId, this.getWebContext().getTreeNode(), strAction)) {
                return;
            }
            if (!this.OnTreeAction(strTreeId, this.webContext.getTreeNode())) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u6811[%1$s]\u64cd\u4f5c[%2$s]", (Object)strTreeId, (Object)this.webContext.getTreeNode()));
            }
            return;
        }
        if (!this.OnCustomAction(strActionType, strAction)) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u4e0d\u660e\u5904\u7406[%1$s]\u64cd\u4f5c[%2$s]", (Object)strActionType, (Object)strAction));
        }
    }

    public final boolean IsBackEndMode() {
        return this.bBackEndMode;
    }

    public final String Render(String strControlId) {
        if (!this.bPrivilegeTestOk) {
            return "";
        }
        StringWriter writer = new StringWriter();
        this.DebugProcessTime(StringHelper.Format((String)"Render [%1$s] Start", (Object)strControlId));
        this.RenderChild(writer, strControlId);
        this.DebugProcessTime(StringHelper.Format((String)"Render [%1$s] End", (Object)strControlId));
        return writer.toString();
    }

    public final String GetCtrlUniqueId(String strControlId) {
        SRFExControl childControl;
        block3: {
            try {
                childControl = this.FindControl(strControlId);
                if (childControl != null) break block3;
                return "";
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return "";
            }
        }
        return childControl.getUniqueID();
    }

    public final String Render() {
        if (!this.bPrivilegeTestOk) {
            return "";
        }
        if (!this.sm2()) {
            return "";
        }
        this.DebugProcessTime("Render Start");
        StringWriter writer = new StringWriter();
        try {
            if (this.bOutputDebug && this.getWebContext().getWebConfig().GetExtValue("DEBUG", false) && StringHelper.Length((String)this.getID()) == 0) {
                SRFExPage.RenderDebugWindow(this.getWebContext().getDialogMode(), writer);
            }
            this.Render(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.LogPagePerformance();
        this.DebugProcessTime("Render End");
        return writer.toString();
    }

    protected static void RenderDebugWindow(boolean bDialogMode, StringWriter writer) {
        if (bDialogMode) {
            writer.write("<table cellSpacing=\"0\" cellPadding=\"0\" width=\"600\" border=\"0\">");
            writer.write("<tr height='20'><td></td></tr>");
            writer.write("<tr><td align=\"center\">");
            writer.write("<table cellSpacing=\"0\" cellPadding=\"0\" width=\"600\" border=\"0\">");
            writer.write("<tr><td><SPAN class='sx-normaltext'>\u8c03\u8bd5\u4fe1\u606f</SPAN></td></tr>");
            writer.write("<TR><TD><textarea rows=\"5\" id=\"_DEBUG\" name=\"_DEBUG\" style=\"width:778px;height:300px\"></textarea>");
            writer.write("</TD></TR></table></td></tr></table>");
        } else {
            writer.write("<table cellSpacing=\"0\" cellPadding=\"0\" width=\"600\" border=\"0\">");
            writer.write("<tr height='20'><td></td></tr>");
            writer.write("<tr><td align=\"center\">");
            writer.write("<table cellSpacing=\"0\" cellPadding=\"0\" width=\"600\" border=\"0\">");
            writer.write("<tr><td><SPAN class='sx-normaltext'>\u8c03\u8bd5\u4fe1\u606f</SPAN></td></tr>");
            writer.write("<TR><TD><textarea rows=\"5\" id=\"_DEBUG\" name=\"_DEBUG\" style=\"width:600px;height:300px\"></textarea>");
            writer.write("</TD></TR></table></td></tr></table>");
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            String strJSConent;
            if (this.output != null) {
                int nCount = this.output.size();
                int i = 0;
                while (i < nCount) {
                    writer.write(this.output.get(i));
                    ++i;
                }
            }
            boolean bCacheEnable = false;
            boolean bCreateCacheFile = false;
            boolean bEmptyFile = false;
            String strJSCacheFile = "";
            String strJSCacheFileLocal = "";
            if (this.isJSCache() && !StringHelper.IsNullOrEmpty((String)(strJSCacheFile = this.getJSCahceFilePath()))) {
                strJSCacheFileLocal = String.valueOf(this.getWebContext().GetAppRootPath()) + "jscache" + File.separator + strJSCacheFile;
                File file = new File(strJSCacheFileLocal);
                if (file.exists()) {
                    bCacheEnable = true;
                    if (file.length() == 0L) {
                        bEmptyFile = true;
                    }
                } else {
                    bCacheEnable = true;
                    bCreateCacheFile = true;
                }
            }
            StringBuilderEx sb = new StringBuilderEx();
            if (!bCacheEnable || bCreateCacheFile) {
                if (this.scriptSet != null) {
                    int i = 0;
                    while (i <= 6) {
                        String strScript = this.scriptSet.get(i);
                        if (StringHelper.Length((String)strScript) != 0) {
                            sb.Append(strScript);
                        }
                        ++i;
                    }
                }
                StringWriter stringWriter = new StringWriter();
                this.forms.Render(stringWriter);
                if (this.isOptimize()) {
                    sb.Append(JSHelper.Optimize(stringWriter.toString()));
                } else {
                    sb.Append(stringWriter.toString());
                }
                sb.Append(" Ext.onReady(function(){try{");
                int i = 0;
                while (i <= 6) {
                    String strScript;
                    if (this.readyScriptSet != null && StringHelper.Length((String)(strScript = this.readyScriptSet.get(i))) != 0) {
                        sb.Append(strScript);
                    }
                    if (bCacheEnable) {
                        sb.Append("if(typeof(JRD_%1$s)=='function')JRD_%1$s(%2$s);", this.getID(), i);
                    }
                    ++i;
                }
                if (SRFExPage.isAlertOnReadyCatch()) {
                    sb.Append("}catch(e){alert(e.message);}});");
                } else {
                    sb.Append("}catch(e){/*alert(e.message);*/}});");
                }
                if (bCreateCacheFile) {
                    try {
                        String strJSConent2 = sb.toString();
                        if (strJSConent2.length() > 2000 && this.isOptimize() && this.isOptimizeEx()) {
                            strJSConent2 = JSHelper.OptimizeEx(strJSConent2);
                        }
                        OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strJSCacheFileLocal), "GBK");
                        if (StringHelper.Length((String)strJSConent2) > 0) {
                            out.write(StringHelper.Format((String)"/*created %1$s */\r\n", (Object)new Date().toString()));
                        } else {
                            bEmptyFile = true;
                        }
                        out.write(strJSConent2);
                        out.flush();
                        out.close();
                        sb.Reset();
                    }
                    catch (Exception ex) {
                        bCacheEnable = false;
                        ex.printStackTrace();
                    }
                }
            }
            if (this.isJSCache()) {
                if (this.scriptSetUncache != null) {
                    int i = 0;
                    while (i <= 6) {
                        String strScript = this.scriptSetUncache.get(i);
                        if (StringHelper.Length((String)strScript) != 0) {
                            sb.Append(strScript);
                        }
                        ++i;
                    }
                }
                if (this.readyScriptSetUncache != null) {
                    sb.Append(" function JRD_%1$s(_JRL){", this.getID());
                    int i = 0;
                    while (i <= 6) {
                        String strScript = this.readyScriptSetUncache.get(i);
                        if (StringHelper.Length((String)strScript) != 0) {
                            sb.Append(strScript);
                        }
                        ++i;
                    }
                    sb.Append("};");
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)(strJSConent = sb.toString()))) {
                if (strJSConent.length() > 2000 && this.isOptimize() && this.isOptimizeEx()) {
                    strJSConent = JSHelper.OptimizeEx(strJSConent);
                }
                writer.write("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
                writer.write(strJSConent);
                writer.write("</SCRIPT>");
            }
            if (bCacheEnable && !bEmptyFile) {
                writer.write(StringHelper.Format((String)"<script type=\"text/javascript\" src=\"../jscache/%1$s\"></script>", (Object)strJSCacheFile));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected String getJSCahceFilePath() {
        return String.valueOf(this.getWebContext().getCurPagePath().replace("/", ".")) + ".js";
    }

    protected SRFExWebContext CreateWebContext() {
        return null;
    }

    @Override
    public SRFExWebContext getWebContext() {
        return this.webContext;
    }

    public final PageContext getPageContext() {
        return this.pageContext;
    }

    public final SRFExForms getForms() {
        return this.forms;
    }

    public final String getDefaultBackEndUrl() {
        if (StringHelper.IsNullOrEmpty((String)this.strDefaultBackEndUrl)) {
            this.strDefaultBackEndUrl = SRFExPage.CalcDefaultBackendUrl(this);
        }
        return this.strDefaultBackEndUrl;
    }

    protected static String CalcDefaultBackendUrl(SRFExPage page) {
        String strServerName2;
        String strCurPath = page.getRequest().getRequestURL().toString();
        int nStartPos = strCurPath.indexOf(strServerName2 = page.getRequest().getServerName());
        nStartPos = nStartPos != -1 ? (nStartPos += strServerName2.length()) : 0;
        String strContextPath = page.getRequest().getContextPath();
        int nContextPathPos = strCurPath.indexOf(strContextPath, nStartPos);
        if (nContextPathPos != -1) {
            strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
        }
        String strDefaultBackEndUrl = strCurPath;
        strDefaultBackEndUrl = strDefaultBackEndUrl.substring(0, strDefaultBackEndUrl.length() - 4);
        strDefaultBackEndUrl = String.valueOf(strDefaultBackEndUrl) + "backend.jsp";
        strDefaultBackEndUrl = ".." + strDefaultBackEndUrl;
        if (StringHelper.StringLength((String)page.getWebContext().GetQueryString()) != 0) {
            strDefaultBackEndUrl = String.valueOf(strDefaultBackEndUrl) + "?";
            strDefaultBackEndUrl = String.valueOf(strDefaultBackEndUrl) + page.getWebContext().GetQueryString();
        }
        return strDefaultBackEndUrl;
    }

    public final void setDefaultBackEndUrl(String strDefaultBackEndUrl) {
        this.strDefaultBackEndUrl = strDefaultBackEndUrl;
    }

    public final Writer getWriter() {
        return this.pageContext.getOut();
    }

    public final HttpServletRequest getRequest() {
        return (HttpServletRequest)this.pageContext.getRequest();
    }

    public final HttpServletResponse getResponse() {
        return (HttpServletResponse)this.pageContext.getResponse();
    }

    public final void RegisterScript(int nLevel, String strScript) {
        if (this.isJSCache()) {
            this.RegisterUncacheScript(nLevel, strScript);
        } else {
            this.RegisterCacheScript(nLevel, strScript);
        }
    }

    public final void RegisterCacheScript(int nLevel, String strScript) {
        if (nLevel < 0 || nLevel > 6) {
            return;
        }
        if (this.scriptSet == null) {
            this.scriptSet = new TreeMap<Integer, String>();
        }
        if (this.bOptimize) {
            strScript = JSHelper.Optimize(strScript);
        }
        String strLastScript = "";
        if (this.scriptSet.containsKey(nLevel)) {
            strLastScript = this.scriptSet.get(nLevel);
        }
        if (!this.bOptimize && StringHelper.Length((String)strLastScript) > 0) {
            strLastScript = String.valueOf(strLastScript) + "\r\n";
        }
        strLastScript = String.valueOf(strLastScript) + strScript;
        this.scriptSet.put(nLevel, strLastScript);
    }

    public final void RegisterUncacheScript(int nLevel, String strScript) {
        if (!this.isJSCache()) {
            this.RegisterCacheScript(nLevel, strScript);
            return;
        }
        if (nLevel < 0 || nLevel > 6) {
            return;
        }
        if (this.scriptSetUncache == null) {
            this.scriptSetUncache = new TreeMap<Integer, String>();
        }
        if (this.bOptimize) {
            strScript = JSHelper.Optimize(strScript);
        }
        String strLastScript = "";
        if (this.scriptSetUncache.containsKey(nLevel)) {
            strLastScript = this.scriptSetUncache.get(nLevel);
        }
        if (!this.bOptimize && StringHelper.Length((String)strLastScript) > 0) {
            strLastScript = String.valueOf(strLastScript) + "\r\n";
        }
        strLastScript = String.valueOf(strLastScript) + strScript;
        this.scriptSetUncache.put(nLevel, strLastScript);
    }

    public final void RegisterOutput(String strOutput) {
        if (this.output == null) {
            this.output = new ArrayList();
        }
        this.output.add(strOutput);
    }

    public final void RegisterOnReadyScript(int nLevel, String strScript) {
        if (this.isJSCache()) {
            this.RegisterUncacheOnReadyScript(nLevel, strScript);
        } else {
            this.RegisterCacheOnReadyScript(nLevel, strScript);
        }
    }

    public final void RegisterCacheOnReadyScript(int nLevel, String strScript) {
        if (nLevel < 0 || nLevel > 6) {
            return;
        }
        if (this.readyScriptSet == null) {
            this.readyScriptSet = new TreeMap<Integer, String>();
        }
        if (this.bOptimize) {
            strScript = JSHelper.Optimize(strScript);
        }
        String strLastScript = "";
        if (this.readyScriptSet.containsKey(nLevel)) {
            strLastScript = this.readyScriptSet.get(nLevel);
        }
        if (!this.bOptimize && StringHelper.Length((String)strLastScript) > 0) {
            strLastScript = String.valueOf(strLastScript) + "\r\n";
        }
        strLastScript = String.valueOf(strLastScript) + StringHelper.Format((String)"if(1){%1$s}", (Object)strScript);
        this.readyScriptSet.put(nLevel, strLastScript);
    }

    public final void RegisterUncacheOnReadyScript(int nLevel, String strScript) {
        if (!this.isJSCache()) {
            this.RegisterCacheOnReadyScript(nLevel, strScript);
            return;
        }
        if (nLevel < 0 || nLevel > 6) {
            return;
        }
        if (this.readyScriptSetUncache == null) {
            this.readyScriptSetUncache = new TreeMap<Integer, String>();
        }
        if (this.bOptimize) {
            strScript = JSHelper.Optimize(strScript);
        }
        String strLastScript = "";
        if (this.readyScriptSetUncache.containsKey(nLevel)) {
            strLastScript = this.readyScriptSetUncache.get(nLevel);
        }
        if (!this.bOptimize && StringHelper.Length((String)strLastScript) > 0) {
            strLastScript = String.valueOf(strLastScript) + "\r\n";
        }
        strLastScript = String.valueOf(strLastScript) + StringHelper.Format((String)"if(_JRL==%2$s){%1$s}", (Object)strScript, (Object)nLevel);
        this.readyScriptSetUncache.put(nLevel, strLastScript);
    }

    public void setDefaultFormId(String strDefaultFormId) {
        this.strDefaultFormId = strDefaultFormId;
    }

    public String getDefaultFormId() {
        if (StringHelper.Length((String)this.strDefaultFormId) == 0) {
            this.strDefaultFormId = "frm" + this.getID();
        }
        return this.strDefaultFormId;
    }

    public SRFExBaseForm getDefaultForm() {
        String strFormId = this.getDefaultFormId();
        if (StringHelper.Length((String)strFormId) == 0) {
            return null;
        }
        return this.getForms().FindForm(strFormId);
    }

    public final void Output(String strOutput) {
        if (!this.bPrivilegeTestOk) {
            return;
        }
        try {
            this.getWriter().write(strOutput);
        }
        catch (Exception ex) {
            log.error((Object)"\u9875\u9762\u8f93\u51fa\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
        }
    }

    public final void OutputDirect(String strOutput) {
        try {
            this.getWriter().write(strOutput);
        }
        catch (Exception ex) {
            log.error((Object)"\u9875\u9762\u8f93\u51fa\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
        }
    }

    public final void OutputScript(String strOutput) {
        SRFExPage.OutputScript(this.getWriter(), strOutput);
    }

    protected static final void OutputScript(Writer writer, String strOutput) {
        try {
            writer.write("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
            writer.write(strOutput);
            writer.write("</SCRIPT>");
        }
        catch (Exception ex) {
            log.error((Object)"\u9875\u9762\u811a\u672c\u8f93\u51fa\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
        }
    }

    public void OutputAlertMsg(String strMessage, boolean bCloseWindow) {
        SRFExPage.OutputAlertMsg(this.getWriter(), strMessage, bCloseWindow);
    }

    protected static final void OutputAlertMsg(Writer writer, String strMessage, boolean bCloseWindow) {
        try {
            writer.write("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
            writer.write(BrowserJSHelper.getAlertMessageScript(strMessage));
            if (bCloseWindow) {
                writer.write(BrowserJSHelper.getCloseWindowScript());
            }
            writer.write("</SCRIPT>");
        }
        catch (Exception ex) {
            log.error((Object)"\u9875\u9762\u811a\u672c\u8f93\u51fa\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
        }
    }

    public final void RegisterFormActionHelper(String strFormId, String strHelperId) {
        if (this.actionHelper != null) {
            this.actionHelper.put("FORM_" + strFormId, strHelperId);
        }
    }

    protected SRFExFormActionHelper getFormActionHelper(String strFormId) {
        if (this.actionHelper == null) {
            return null;
        }
        String strFormActionHelperId = "FORM_" + strFormId;
        if (this.actionHelper.containsKey(strFormActionHelperId)) {
            String strHelperId = this.actionHelper.get(strFormActionHelperId);
            Object objHelper = ObjectHelper.Create(strHelperId);
            if (objHelper == null) {
                return null;
            }
            if (objHelper instanceof SRFExFormActionHelper) {
                return (SRFExFormActionHelper)objHelper;
            }
            log.error((Object)StringHelper.Format((String)"\u8868\u5355[%1$s]\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strFormId));
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u8868\u5355\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61[%1$s]\u4e0d\u5b58\u5728", (Object)strFormActionHelperId));
        return null;
    }

    public final void RegisterDataGridActionHelper(String strDataGridId, String strHelperId) {
        if (this.actionHelper != null) {
            this.actionHelper.put("DATAGRID_" + strDataGridId, strHelperId);
        }
    }

    protected SRFExDataGridActionHelper getDataGridActionHelper(String strDataGridId) {
        if (this.actionHelper == null) {
            return null;
        }
        String strDataGridActionHelperId = "DATAGRID_" + strDataGridId;
        if (this.actionHelper.containsKey(strDataGridActionHelperId)) {
            String strHelperId = this.actionHelper.get(strDataGridActionHelperId);
            Object objHelper = ObjectHelper.Create(strHelperId);
            if (objHelper == null) {
                return null;
            }
            if (objHelper instanceof SRFExDataGridActionHelper) {
                return (SRFExDataGridActionHelper)objHelper;
            }
            log.error((Object)StringHelper.Format((String)"\u6570\u636e\u8868\u683c[%1$s]\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strDataGridId));
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u6570\u636e\u8868\u683c\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61[%1$s]\u4e0d\u5b58\u5728", (Object)strDataGridActionHelperId));
        return null;
    }

    public final void RegisterDGExActionHelper(String strDGExId, String strHelperId) {
        if (this.actionHelper != null) {
            this.actionHelper.put("DGEX_" + strDGExId, strHelperId);
        }
    }

    protected SRFExDGExActionHelper getDGExActionHelper(String strDGExId) {
        if (this.actionHelper == null) {
            return null;
        }
        String strDGExActionHelperId = "DGEX_" + strDGExId;
        if (this.actionHelper.containsKey(strDGExActionHelperId)) {
            String strHelperId = this.actionHelper.get(strDGExActionHelperId);
            Object objHelper = ObjectHelper.Create(strHelperId);
            if (objHelper == null) {
                return null;
            }
            if (objHelper instanceof SRFExDGExActionHelper) {
                return (SRFExDGExActionHelper)objHelper;
            }
            log.error((Object)StringHelper.Format((String)"\u6570\u636e\u8868\u683c[%1$s]\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strDGExId));
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u6570\u636e\u8868\u683c\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61[%1$s]\u4e0d\u5b58\u5728", (Object)strDGExActionHelperId));
        return null;
    }

    public final void RegisterButtonActionHelper(String strButtonId, String strHelperId) {
        if (this.actionHelper != null) {
            this.actionHelper.put("BUTTON_" + strButtonId, strHelperId);
        }
    }

    protected SRFExButtonActionHelper getButtonActionHelper(String strButtonId) {
        if (this.actionHelper == null) {
            return null;
        }
        String strButtonActionHelperId = "BUTTON_" + strButtonId;
        if (this.actionHelper.containsKey(strButtonActionHelperId)) {
            String strHelperId = this.actionHelper.get(strButtonActionHelperId);
            Object objHelper = ObjectHelper.Create(strHelperId);
            if (objHelper == null) {
                return null;
            }
            if (objHelper instanceof SRFExButtonActionHelper) {
                return (SRFExButtonActionHelper)objHelper;
            }
            log.error((Object)StringHelper.Format((String)"\u6309\u94ae%1$s]\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strButtonId));
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u6309\u94ae\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61[%1$s]\u4e0d\u5b58\u5728", (Object)strButtonActionHelperId));
        return null;
    }

    public final void RegisterTreeActionHelper(String strTreeId, String strHelperId) {
        if (this.actionHelper != null) {
            this.actionHelper.put("TREE_" + strTreeId, strHelperId);
        }
    }

    protected SRFExTreeActionHelper getTreeActionHelper(String strTreeId) {
        return SRFExPage.getTreeActionHelper(this.actionHelper, strTreeId);
    }

    private static SRFExTreeActionHelper getTreeActionHelper(Map<String, String> actionHelper, String strTreeId) {
        if (actionHelper == null) {
            return null;
        }
        String strTreeActionHelperId = "TREE_" + strTreeId;
        if (actionHelper.containsKey(strTreeActionHelperId)) {
            String strHelperId = actionHelper.get(strTreeActionHelperId);
            Object objHelper = ObjectHelper.Create(strHelperId);
            if (objHelper == null) {
                return null;
            }
            if (objHelper instanceof SRFExTreeActionHelper) {
                return (SRFExTreeActionHelper)objHelper;
            }
            log.error((Object)StringHelper.Format((String)"\u6811%1$s]\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strTreeId));
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u6811\u64cd\u4f5c\u8f85\u52a9\u5bf9\u8c61[%1$s]\u4e0d\u5b58\u5728", (Object)strTreeActionHelperId));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final String GetControlUniId() {
        boolean bHex = true;
        String curId = this.getID();
        if (StringHelper.Length((String)curId) == 0) {
            curId = "M";
        } else {
            char ch = curId.charAt(curId.length() - 1);
            if (ch < 'g' || ch > 'z') {
                bHex = false;
            }
        }
        Integer n = this.nChildControlIndex;
        synchronized (n) {
            this.nChildControlIndex = this.nChildControlIndex + 1;
            return StringHelper.Format((String)"%1$s%2$s", (Object)curId, (Object)(bHex ? Integer.toHexString(this.nChildControlIndex) : SRFExPage.GetUniId(this.nChildControlIndex)));
        }
    }

    public static String GetControlUniId(String strParentId, int nIndex) {
        boolean bHex = true;
        if (StringHelper.Length((String)strParentId) == 0) {
            strParentId = "M";
        } else {
            char ch = strParentId.charAt(strParentId.length() - 1);
            if (ch < 'g' || ch > 'z') {
                bHex = false;
            }
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)strParentId, (Object)(bHex ? Integer.toHexString(nIndex) : SRFExPage.GetUniId(nIndex)));
    }

    private static String GetUniId(int nValue) {
        String strRet = "";
        do {
            int nTemp = nValue % 16;
            char nC = (char)(103 + nTemp);
            strRet = String.valueOf(nC) + strRet;
        } while ((nValue /= 16) != 0);
        return strRet;
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }

    public String getResourceId() {
        if (StringHelper.Length((String)this.strResourceId) == 0) {
            if (this.strResourceId != null) {
                return "";
            }
            return SRFExPage.CalcResourceId(this.getWebContext());
        }
        return this.strResourceId;
    }

    protected static String CalcResourceId(SRFExWebContext webContext) {
        String strCurPagePath = webContext.getCurPagePath();
        if (StringHelper.Length((String)strCurPagePath) == 0) {
            return "";
        }
        strCurPagePath = strCurPagePath.toUpperCase();
        strCurPagePath = webContext.IsBackEndMode() ? strCurPagePath.replace("BACKEND.JSP", "") : strCurPagePath.replace(".JSP", "");
        if (strCurPagePath.indexOf(47) == 0) {
            strCurPagePath = strCurPagePath.substring(1);
        }
        strCurPagePath = strCurPagePath.replace("/", ".");
        return "PAGE_" + strCurPagePath;
    }

    public void setMainPage(boolean bMainPage) {
        this.bMainPage = bMainPage;
    }

    public boolean getMainPage() {
        return this.bMainPage;
    }

    public void setDialogPage(boolean bDialogPage) {
        this.bDialogPage = bDialogPage;
    }

    public boolean getDialogPage() {
        return this.bDialogPage;
    }

    public boolean IsPrivilegeTestOK() {
        return this.bPrivilegeTestOk;
    }

    public boolean IsStop() {
        return this.bIsStop || !this.bPrivilegeTestOk || !this.sm4();
    }

    protected void SetStopPage(boolean bIsStop) {
        this.bIsStop = bIsStop;
    }

    public boolean isOutputDebug() {
        return this.bOutputDebug;
    }

    public void setOutputDebug(boolean outputDebug) {
        this.bOutputDebug = outputDebug;
    }

    public void PageLog(Object obj, int nLevel, String strInfo) {
        this.PageLog(obj, nLevel, strInfo, null);
    }

    public void PageLog(Object obj, String strInfo, CallResult result) {
        String strFormatInfo = "";
        if (result == null) {
            strFormatInfo = StringHelper.Format((String)"%1$s,\u4e0d\u660e\u8fd4\u56de\u7ed3\u679c", (Object)strInfo);
            this.PageLog(obj, 1, strFormatInfo, null);
        } else if (result.getRetCode() != 0) {
            strFormatInfo = StringHelper.Format((String)"%1$s,\u8fd4\u56de\u4ee3\u7801[%2$s],\u8fd4\u56de\u4fe1\u606f:%3$s", (Object)strInfo, (Object)result.getRetCode(), (Object)result.getErrorInfo());
            this.PageLog(obj, 1, strFormatInfo, null);
        } else {
            strFormatInfo = StringHelper.Format((String)"%1$s,\u8fd4\u56de\u7ed3\u679c\u6b63\u5e38", (Object)strInfo);
            this.PageLog(obj, 0, strFormatInfo, null);
        }
    }

    public void PageLog(Object obj, int nLevel, String strInfo, Throwable throwable) {
        SRFExPage.PageLog(this.getWebContext(), obj, nLevel, strInfo, throwable);
    }

    private static final void PageLog(SRFExWebContext webContext, Object obj, int nLevel, String strInfo, Throwable throwable) {
        try {
            String strFormatInfo = obj == null ? StringHelper.Format((String)"[%1$s] %2$s", (Object)webContext.getCurPagePath(), (Object)strInfo) : StringHelper.Format((String)"[%1$s] <%2$s> %3$s", (Object)webContext.getCurPagePath(), (Object)obj, (Object)strInfo);
            switch (nLevel) {
                case 0: {
                    if (throwable == null) {
                        log.info((Object)strFormatInfo);
                    } else {
                        log.info((Object)strFormatInfo, throwable);
                    }
                    return;
                }
                case 1: {
                    if (throwable == null) {
                        log.error((Object)strFormatInfo);
                    } else {
                        log.error((Object)strFormatInfo, throwable);
                    }
                    return;
                }
                case 5: {
                    if (throwable == null) {
                        log.debug((Object)strFormatInfo);
                    } else {
                        log.debug((Object)strFormatInfo, throwable);
                    }
                    return;
                }
                case 4: {
                    if (throwable == null) {
                        log.warn((Object)strFormatInfo);
                    } else {
                        log.warn((Object)strFormatInfo, throwable);
                    }
                }
                case 2: {
                    if (throwable == null) {
                        log.fatal((Object)strFormatInfo);
                    } else {
                        log.fatal((Object)strFormatInfo, throwable);
                    }
                    return;
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)"\u65e5\u5fd7\u8fc7\u7a0b\u4e2d\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
        }
    }

    public boolean isOptimize() {
        return this.bOptimize;
    }

    public void setOptimize(boolean optimize) {
        this.bOptimize = optimize;
    }

    public boolean isOptimizeEx() {
        return this.bOptimizeEx;
    }

    public void setOptimizeEx(boolean optimize) {
        this.bOptimizeEx = optimize;
    }

    public boolean isJSCache() {
        return this.bJSCache;
    }

    public void setJSCache(boolean bJSCache) {
        this.bJSCache = bJSCache;
    }

    public final Object getPageParam(String strParamName) {
        if (this.pageContext == null) {
            return null;
        }
        return this.pageContext.getAttribute(strParamName.toUpperCase());
    }

    public final boolean IsContainPageParam(String strParamName) {
        if (this.pageContext == null) {
            return false;
        }
        return this.pageContext.getAttribute(strParamName.toUpperCase()) != null;
    }

    public final String getPageParam(String strParamName, String strDefault) {
        Object objValue = this.getPageParam(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        return objValue.toString();
    }

    public final boolean getPageParam(String strParamName, boolean bDefault) {
        Object objValue = this.getPageParam(strParamName);
        if (objValue == null) {
            return bDefault;
        }
        return StringHelper.Compare((String)objValue.toString(), (String)"TRUE", (boolean)true) == 0;
    }

    public final int getPageParam(String strParamName, int nDefault) {
        Object objValue = this.getPageParam(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            return Integer.parseInt(objValue.toString());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    public final Enumeration getPageParamNames() {
        if (this.pageContext == null) {
            return null;
        }
        return this.pageContext.getAttributeNamesInScope(1);
    }

    public final void setPageParam(String strParamName, Object objValue) {
        if (this.pageContext == null) {
            return;
        }
        this.pageContext.setAttribute(strParamName.toUpperCase(), objValue);
    }

    public final void removePageParam(String strParamName) {
        if (this.pageContext == null) {
            return;
        }
        this.pageContext.removeAttribute(strParamName.toUpperCase());
    }

    public final Object getControlParam(SRFExControl control, String strParamName) {
        if (control == null) {
            return null;
        }
        String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)control.getUniqueID(), (Object)strParamName);
        return this.getPageParam(strKey);
    }

    public final String getControlParam(SRFExControl control, String strParamName, String strDefault) {
        Object objValue = this.getControlParam(control, strParamName);
        if (objValue == null) {
            return strDefault;
        }
        return objValue.toString();
    }

    public final void setControlParam(SRFExControl control, String strParamName, Object objValue) {
        if (control == null) {
            return;
        }
        String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)control.getUniqueID(), (Object)strParamName);
        this.setPageParam(strKey, objValue);
    }

    public final void setFormParam(SRFExBaseForm form, String strParamName, Object objValue) {
        if (form == null) {
            return;
        }
        String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)form.getFormId(), (Object)strParamName);
        this.setPageParam(strKey, objValue);
    }

    public final Object getFormParam(SRFExBaseForm form, String strParamName) {
        if (form == null) {
            return null;
        }
        String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)form.getFormId(), (Object)strParamName);
        return this.getPageParam(strKey);
    }

    public final String getFormParam(SRFExBaseForm form, String strParamName, String strDefault) {
        Object objValue = this.getFormParam(form, strParamName);
        if (objValue == null) {
            return strDefault;
        }
        return objValue.toString();
    }

    public final boolean getFormParam(SRFExBaseForm form, String strParamName, boolean bDefault) {
        Object objValue = this.getFormParam(form, strParamName);
        if (objValue == null) {
            return bDefault;
        }
        return StringHelper.Compare((String)objValue.toString(), (String)"TRUE", (boolean)true) == 0;
    }

    public final void setNoCache(boolean bNoCache) {
        this.bNoCache = bNoCache;
    }

    public String GetPageHeaderContent() {
        return this.OnGetPageHeaderContent();
    }

    protected String OnGetPageHeaderContent() {
        if (strMultiLanguageHeader != null && !StringHelper.IsNullOrEmpty((String)this.getLanguage())) {
            return StringHelper.Format((String)strMultiLanguageHeader, (Object)this.getLanguage().toLowerCase());
        }
        return "";
    }

    private boolean sm1() {
        return ((ISRFExUserSessionMgr)this.getWebContext().GetGlobalValue(TAG_SM1)).UpdateSession(this.getWebContext(), (ServletRequest)this.getRequest(), (ServletResponse)this.getResponse());
    }

    private boolean sm2() {
        return ((ISRFExUserSessionMgr)this.getWebContext().GetGlobalValue(TAG_SM2)).UpdateSession(this.getWebContext(), (ServletRequest)this.getRequest(), (ServletResponse)this.getResponse());
    }

    private boolean sm3() {
        return ((ISRFExUserSessionMgr)this.getWebContext().GetGlobalValue(TAG_SM2)).UpdateSession(this.getWebContext(), (ServletRequest)this.getRequest(), (ServletResponse)this.getResponse());
    }

    private boolean sm4() {
        return ((ISRFExUserSessionMgr)this.getWebContext().GetGlobalValue(TAG_SM2)).UpdateSession(this.getWebContext(), (ServletRequest)this.getRequest(), (ServletResponse)this.getResponse());
    }

    protected long CalcProcessTime() {
        this.nPageLastProcessTime = new Date().getTime();
        return this.nPageLastProcessTime - this.nPageStartProcessTime;
    }

    protected boolean isLogPagePerformance() {
        return true;
    }

    public void LogPagePerformance() {
        if (!this.isLogPagePerformance()) {
            return;
        }
        ISRFExPOLogger poLogger = this.getWebContext().getGlobalHelper().getPOLogger();
        if (poLogger == null) {
            return;
        }
        long nProcessTime = this.CalcProcessTime();
        poLogger.LogPageAction(this, (int)nProcessTime);
    }

    public void setControlValueFromUniqueId(boolean bValueFromUniqueId) {
        this.bControlValueFromUniqueId = bValueFromUniqueId;
    }

    public boolean isControlValueFromUniqueId() {
        return this.bControlValueFromUniqueId;
    }

    public int getFrontUIStyle() {
        return this.nFrontUIStyle;
    }

    public void setFrontUIStyle(int nFrontUIStyle) {
        this.nFrontUIStyle = nFrontUIStyle;
    }

    public String getLanguage() {
        if (this.getWebContext() != null) {
            return this.getWebContext().getLocalization();
        }
        return "";
    }

    public String GetLocalization(String strResId, String strResId2, String strDefault) {
        return this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getLanguage(), strResId, strResId2, strDefault);
    }

    public String GetLocalization(String strResId, String strDefault) {
        return this.getWebContext().getGlobalHelper().getLocalizationHelper().GetLocalization(this.getLanguage(), strResId, strDefault);
    }

    public static final void SetMultiLanguageHeader(String strValue) {
        strMultiLanguageHeader = strValue;
    }

    public static final String GetMultiLanguageHeader() {
        return strMultiLanguageHeader;
    }

    public static void RegisterAppUITheme(String strAppUIThemeId, String strStyle) {
        if (StringHelper.IsNullOrEmpty((String)strStyle)) {
            appUIThemeMap.remove(strAppUIThemeId);
        } else {
            appUIThemeMap.put(strAppUIThemeId, strStyle);
        }
    }

    public static void setAlertOnReadyCatch(boolean bValue) {
        bAlertOnReadyCatch = bValue;
    }

    public static boolean isAlertOnReadyCatch() {
        return bAlertOnReadyCatch;
    }

    public void DebugProcessTime(String strDebugInfo) {
        this.PageLog((Object)this, 5, StringHelper.Format((String)"\u65f6\u95f4[%1$s],%2$s", (Object)this.CalcProcessTime(), (Object)strDebugInfo));
    }
}

