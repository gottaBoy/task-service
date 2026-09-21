/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAConfigPublishContext
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.DAConfigPublishContext;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Properties;
import net.sf.json.JSONObject;

public abstract class SRFDAPageEx
extends SRFDAPage {
    protected Page page = null;
    protected IPageHelper iPageHelper = null;
    protected static boolean bPageJSFunc = false;

    public static void setEnablePageJSFunc(boolean bValue) {
        bPageJSFunc = bValue;
    }

    public static boolean isEnablePageJSFunc() {
        return bPageJSFunc;
    }

    public void setPageData(IPageHelper iPageHelper) {
        this.iPageHelper = iPageHelper;
        if (this.iPageHelper != null) {
            this.setPage(this.iPageHelper.getData());
        } else {
            this.page = null;
        }
    }

    @Override
    public IPageHelper getPageData() {
        return this.iPageHelper;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strPageId = this.getWebContext().getSRFPageId();
        if (!StringHelper.IsNullOrEmpty((String)strPageId) && this.page == null) {
            try {
                IPageHelper iPageHelper = this.getDAModelStorage().FindPage2(strPageId);
                this.setPageData(iPageHelper);
            }
            catch (Exception ex) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                return false;
            }
        }
        if (this.page != null) {
            if (!this.OnCheckPageUserMode()) {
                this.OutputScript("alert('\u60a8\u5f53\u524d\u7684\u7528\u6237\u8eab\u4efd\u65e0\u6cd5\u8bbf\u95ee\u6b64\u9875\u9762')");
                return false;
            }
            SRFDAPageEx.InitPageParam(this, this.page);
            if (!StringHelper.IsNullOrEmpty((String)this.page.getDEID())) {
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFDEID()) && StringHelper.Compare((String)this.page.getDEID(), (String)this.getWebContext().getSRFDEID(), (boolean)true) != 0) {
                    this.PageLog((Object)this, 4, StringHelper.Format((String)"\u9875\u9762[%1$s]\u7ea6\u5b9a\u6570\u636e\u5b9e\u4f53[%2$s]\u4e0e\u5f53\u7136\u4f20\u5165\u5b9e\u4f53[%3$s]\u4e0d\u4e00\u81f4", (Object)this.page.getPAGEID(), (Object)this.page.getDEID(), (Object)this.getWebContext().getSRFDEID()));
                }
                this.getWebContext().SetParamValue("SRFDEID", this.page.getDEID());
                this.setPageDataEntityId(this.page.getDEID());
                if (!SRFDAPageEx.ExecPageLogic(this, this.page.GetPageLogicAction("AFTERINITPAGEPARAM"))) {
                    return false;
                }
            }
        }
        return this.CheckPageCallParam();
    }

    @Override
    protected void PreparePageParam() {
        super.PreparePageParam();
        String strPageId = this.getWebContext().getSRFPageId();
        if (!StringHelper.IsNullOrEmpty((String)strPageId) && this.page == null) {
            this.page = this.getWebContext().GetConfigCache().FindPage(this.getWebContext(), strPageId);
        }
    }

    private static boolean InitPageParam(SRFDAPageEx pageObject, Page page) {
        String strValue;
        String strKey;
        Enumeration<Object> en;
        Properties properties;
        SRFDAWebContext webContext = pageObject.getWebContext();
        if (!pageObject.IsBackEndMode()) {
            try {
                properties = page.getWTProperties();
                if (properties != null) {
                    en = properties.keys();
                    while (en.hasMoreElements()) {
                        strKey = (String)en.nextElement();
                        strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                        CallResult callResult = MacroHelper.GetValue((String)strValue, (ISRFDAWebContext)pageObject.getWebContext(), (ISRFDAGlobalHelper)pageObject.getDAGlobalHelper(), (String)pageObject.getWebContext().getCurUserId(), null);
                        if (callResult.IsOk()) {
                            if (callResult.getUserObject() != null) {
                                Object obj = callResult.getUserObject();
                                if (obj instanceof String) {
                                    webContext.SetParamValue(strKey, (String)obj);
                                    continue;
                                }
                                webContext.SetParamValue(strKey, obj.toString());
                                continue;
                            }
                            webContext.SetParamValue(strKey, "");
                            continue;
                        }
                        throw new Exception(StringHelper.Format((String)"\u8ba1\u7b97\u4e0a\u4e0b\u6587\u53c2\u6570[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                    }
                }
            }
            catch (Exception ex) {
                pageObject.PageLog((Object)pageObject, 1, "\u52a0\u8f7d\u4e0a\u4e0b\u6587\u914d\u7f6e\u5931\u8d25", ex);
                return false;
            }
        }
        if (!page.isTREEVIEWIDNull()) {
            pageObject.setPageParam("PAGE.TREEVIEW", page.getTREEVIEWID());
        }
        if (StringHelper.IsNullOrEmpty((String)webContext.GetParamValue("SRFFORMVIEW")) && !page.isFORMIDNull()) {
            webContext.SetParamValue("SRFFORMVIEW", page.getFORMID());
        }
        if (!page.isSEARCHFORMIDNull()) {
            pageObject.setPageParam("PAGE.SEARCHFORM", page.getSEARCHFORMID());
        }
        if (StringHelper.IsNullOrEmpty((String)webContext.GetParamValue("SRFGRIDVIEW")) && !page.isDATAGRIDIDNull()) {
            webContext.SetParamValue("SRFGRIDVIEW", page.getDATAGRIDID());
        }
        if (!page.isQUERYMODELIDNull()) {
            String strQueryModelId = page.getQUERYMODELID();
            pageObject.setPageParam("PAGE.DATAGRID.QUERYMODEL", strQueryModelId);
            pageObject.setPageParam("PAGE.DATAGRIDEX.QUERYMODEL", strQueryModelId);
        }
        try {
            properties = page.getPAGEProperties();
            if (properties != null) {
                en = properties.keys();
                while (en.hasMoreElements()) {
                    strKey = (String)en.nextElement();
                    strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    pageObject.setPageParam(strKey, strValue);
                }
            }
        }
        catch (Exception ex) {
            pageObject.PageLog((Object)pageObject, 1, "\u52a0\u8f7d\u7f51\u9875\u53c2\u6570\u5931\u8d25", ex);
            return false;
        }
        return true;
    }

    protected boolean CheckPageCallParam() {
        return true;
    }

    protected boolean OnCheckPageUserMode() {
        if (this.page == null || this.isImitatedMode()) {
            return true;
        }
        return this.page.CheckUserMode(this.getWebContext().getCurUserMode());
    }

    protected void InitCtrlConfigFromPageParam(String strParamRoot, XMLConfig config) {
        SRFDAPageEx.InitCtrlConfigFromPageParam(this, strParamRoot, config);
    }

    protected static void InitCtrlConfigFromPageParam(SRFDAPageEx page, String strParamRoot, XMLConfig config) {
        Enumeration en = page.getPageParamNames();
        if (en == null || config == null) {
            return;
        }
        strParamRoot = strParamRoot.toUpperCase();
        while (en.hasMoreElements()) {
            String strKey = en.nextElement().toString();
            if (strParamRoot.indexOf(strKey) != 0) continue;
            String strValue = page.getPageParam(strKey).toString();
            if (strKey.length() < strParamRoot.length() + 1) continue;
            String strPropertyName = strKey.substring(strParamRoot.length() + 1);
            config.SetProperty(strPropertyName, strValue);
        }
    }

    public String GetPageHeader() {
        return this.OnGetPageHeader();
    }

    protected String OnGetPageHeader() {
        Object objParam = this.getPageParam("PAGE.HEADER");
        if (objParam == null) {
            return "";
        }
        return objParam.toString();
    }

    public String GetPageHeaderCSSAndJS() {
        String strContent = this.OnGetPageHeaderCSS();
        strContent = String.valueOf(strContent) + "\r\n";
        strContent = String.valueOf(strContent) + this.OnGetPageHeaderJS();
        return strContent;
    }

    protected String OnGetPageHeaderContent() {
        String strOutput = super.OnGetPageHeaderContent();
        String strAppUITheme = this.getWebContext().getCurAppUITheme();
        if (!StringHelper.IsNullOrEmpty((String)strAppUITheme) && appUIThemeMap.containsKey(strAppUITheme)) {
            if (!StringHelper.IsNullOrEmpty((String)strOutput)) {
                strOutput = String.valueOf(strOutput) + "\r\n";
            }
            strOutput = String.valueOf(strOutput) + (String)appUIThemeMap.get(strAppUITheme);
        }
        if (this.page != null) {
            if (!StringHelper.IsNullOrEmpty((String)strOutput)) {
                strOutput = String.valueOf(strOutput) + "\r\n";
            }
            strOutput = String.valueOf(strOutput) + this.page.getPAGEHEADER();
        }
        return strOutput;
    }

    protected String OnGetPageHeaderCSS() {
        return "<LINK href=\"../resources/css/ext-all.css\" type=\"text/css\"\trel=\"stylesheet\">\r\n<LINK href=\"../sasrfex/css/default/common.css\" type=\"text/css\" rel=\"stylesheet\">";
    }

    protected String OnGetPageHeaderJS() {
        if (this.page != null) {
            return StringHelper.Format((String)"<script type=\"text/javascript\" src=\"../jscript/rt/%1$s.js\" charset=\"UTF-8\"></script>", (Object)this.page.getRealPageFunc());
        }
        return StringHelper.Format((String)"<script type=\"text/javascript\" src=\"../jscript/rt/%1$s.js\" charset=\"UTF-8\"></script>", (Object)this.OnGetDefaultPageFunc());
    }

    protected int OnGetDefaultPageFunc() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getResourceId() {
        if (this.page == null) {
            return "";
        }
        return this.page.getRESOURCEID(this.getPageDataEntityId());
    }

    protected void OnRender(Writer writer) {
        super.OnRender(writer);
        if (this.page == null) {
            return;
        }
        String strPageScript = this.page.getPAGESCRIPT();
        if (!StringHelper.IsNullOrEmpty((String)strPageScript)) {
            try {
                writer.write("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
                writer.write(strPageScript);
                writer.write("</SCRIPT>");
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void OnInit() {
        super.OnInit();
        String strMaskInfo = this.getWebContext().GetParamValue("SRFMASKINFO");
        if (!StringHelper.IsNullOrEmpty((String)strMaskInfo)) {
            this.RegisterOnReadyScript(3, StringHelper.Format((String)"$P.maskhelper.maskinfo('%1$s');", (Object)strMaskInfo));
        }
    }

    @Override
    public BaseDataEntity getAdvPageParam(String strCtrlId, String strParamType) {
        if (this.page != null) {
            return this.page.getAdvPageParam(strCtrlId, strParamType);
        }
        return super.getAdvPageParam(strCtrlId, strParamType);
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        String[] itemIds;
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        if (this.page != null && !StringHelper.IsNullOrEmpty((String)this.page.getSLUIPART()) && this.pageModel != null) {
            this.pageModel.setSLUIPart(this.page.getSLUIPART());
        }
        if (this.pageModel != null && (itemIds = this.OnGetCalcPrivileges()) != null) {
            String[] stringArray = itemIds;
            int n = itemIds.length;
            int n2 = 0;
            while (n2 < n) {
                String strItemId = stringArray[n2];
                boolean bRet = this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), strItemId);
                this.pageModel.RegisterPrivilege(strItemId, bRet);
                ++n2;
            }
        }
        return true;
    }

    protected String[] OnGetCalcPrivileges() {
        String strCalcPrivileges = this.getPageParam("PAGE.CALCPRIVILEGES", "");
        if (StringHelper.IsNullOrEmpty((String)strCalcPrivileges)) {
            return null;
        }
        String[] itemIds = strCalcPrivileges.split("[;]");
        return itemIds;
    }

    protected void FillDAConfigPublishContext(DAConfigPublishContext daConfigPublishContext) {
        daConfigPublishContext.setPage((ISRFDAPage)this);
    }

    @Override
    protected IPageHelper OnGetPageData() {
        return this.iPageHelper;
    }

    public static CallResult TestWFAction(ISRFDAPage page, String strKeyValue, String strStepName) {
        String strWFId = page.getDEHelper().GetDEWFId(page.getWebContext().getSRFWFMode());
        return SRFDAPageEx.TestWFAction(page, page.getDEHelper(), strWFId, strKeyValue, strStepName);
    }

    public static CallResult TestWFAction(ISRFDAPage page, IDEHelper iDEHelper, String strWFId, String strKeyValue, String strStepName) {
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = page.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        WFGetIAActionsResult wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, page.getWebContext().getCurUserId(), "", strStepName, "", "", "", "");
        if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo())));
            page.PageLog((Object)page, 1, callResult.getErrorInfo());
            return callResult;
        }
        String strProcessName = wfGetIAActionsResult.getProcessName();
        WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(strWFId, page.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), strProcessName, "", "", "", "");
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            return callResult;
        }
        return wfCallResult;
    }

    protected boolean RedirectCurrentPath() throws Exception {
        return SRFDAPageEx.RedirectCurrentPath(this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected static boolean RedirectCurrentPath(SRFDAPageEx page) throws Exception {
        String strPagePath = page.getWebContext().getCurPagePath();
        if (!StringHelper.IsNullOrEmpty((String)page.getPageModel())) {
            strPagePath = page.IsBackEndMode() ? strPagePath.replace("modelbackend.jsp", ".jsp") : strPagePath.replace("model.jsp", ".jsp");
        }
        strPagePath = ".." + URLHelper.AppendURLSeperator((String)strPagePath) + page.getWebContext().GetQueryString();
        if (page.IsBackEndMode()) {
            if (StringHelper.IsNullOrEmpty((String)page.getPageModel())) return true;
            SRFExAjaxActionResult ajaxActionResult = new SRFExAjaxActionResult();
            ajaxActionResult.setRetCode(0);
            ajaxActionResult.setGotoPath(strPagePath);
            page.getResponse().getWriter().write(ajaxActionResult.ToJSONString());
            return false;
        } else if (StringHelper.IsNullOrEmpty((String)page.getPageModel())) {
            page.getResponse().sendRedirect(strPagePath);
            return false;
        } else {
            page.getResponse().getWriter().write(SRFDAPageEx.OutputRedirectModel(strPagePath));
        }
        return false;
    }

    protected void OnTestPagePrivilegeFailed() {
        if (!this.IsBackEndMode() && !StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            this.OutputPreparePageEnvError(Errors.GetErrorInfo((int)2));
            return;
        }
        super.OnTestPagePrivilegeFailed();
    }
}

