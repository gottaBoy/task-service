/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebHttpModule
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.CommonEx.Version;
import SA.SRFramework.DataEx.DataEntityMgr;
import SA.SRFramework.Localization.ISRFExLocalizationHelper;
import SA.SRFramework.Localization.SRFExLocalizationHelper;
import SA.SRFramework.ReportEx.Model.ExcelTemplMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.ValueRule.StringLengthMgr;
import SA.SRFramework.ValueRule.ValueRuleMgr;
import SA.SRFramework.Web.WebHttpModule;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;
import SA.SRFramework.WebEx.ISRFExUserMenuCaptionMgr;
import SA.SRFramework.WebEx.ISRFExUserSessionMgr;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarMgr;
import SA.SRFramework.WebEx.UI.AutoCompleteMgr;
import SA.SRFramework.WebEx.UI.AutoFillMgr;
import SA.SRFramework.WebEx.UI.BuilderMgr;
import SA.SRFramework.WebEx.UI.DataGridMgr;
import SA.SRFramework.WebEx.UI.DynamicPanelMgr;
import SA.SRFramework.WebEx.UI.ExcelReportMgr;
import SA.SRFramework.WebEx.UI.FormImageLinkMgr;
import SA.SRFramework.WebEx.UI.GlobalConfigMgr;
import SA.SRFramework.WebEx.UI.MenuExMgr;
import SA.SRFramework.WebEx.UI.PickerDialogMgr;
import SA.SRFramework.WebEx.UI.SearchPanelMgr;
import SA.SRFramework.WebEx.UI.ShortcutBarMgr;
import SA.SRFramework.WebEx.UI.TabViewMgr;
import SA.SRFramework.WebEx.UI.TreeViewMgr;
import SA.SRFramework.WebEx.UI.UIStyleMgr;
import SA.SRFramework.WebEx.UI.UserConfigMgr;
import SA.SRFramework.WebEx.UI.UserConfigMgrItemConfig;
import SA.SRFramework.WebEx.UI.ValueTransformMgr;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.ISRFExPOLogger;
import SA.SRFramework.WebEx.Utility.SRFExPOLogger;
import SA.SRFramework.Workflow.WFConfigMgr;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExWebHttpModule
extends WebHttpModule
implements ISRFExUserSessionMgr {
    public static final String TAG_THEMEEX = "SRFEXTHEME";
    public static final String TAG_DYNAMICPANEL = "DYNAMICPANEL";
    public static final String TAG_DATAGRID = "DATAGRID";
    public static final String TAG_SEARCHPANEL = "SEARCHPANEL";
    public static final String TAG_TREEVIEW = "TREEVIEW";
    public static final String TAG_TABVIEW = "TABVIEW";
    public static final String TAG_MENUEX = "MENUEX";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_VALUERULE = "VALUERULE";
    public static final String TAG_AUTOCOMPLETE = "AUTOCOMLETE";
    public static final String TAG_AUTOFILL = "AUTOFILL";
    public static final String TAG_VALUETRANSFORM = "VALUETRANSFORM";
    public static final String TAG_EXCELREPORT = "EXCELREPORT";
    public static final String TAG_STRINGLENGTH = "STRINGLENGTH";
    public static final String TAG_PICKERDIALOG = "PICKERDIALOG";
    public static final String TAG_SHORTCUTBAR = "SHORTCUTBAR";
    public static final String TAG_USERMENUCAPTIONMGR = "USERMENUCAPTIONMGR";
    public static final String TAG_FORMIMAGELINK = "FORMIMAGELINK";
    public static final String TAG_WORKFLOW = "WORKFLOW";
    public static final String TAG_EXCELTEMPLATE = "EXCELTEMPLATE";
    public static final String TAG_DATAENTITY = "DATAENTITY";
    public static final String TAG_GLOBALCONFIG = "GLOBALCONFIG";
    public static final String TAG_TOOLBAR = "TOOLBAR";
    public static final String TAG_CONTEXTHELPER = "CONTEXTHELPER";
    public static final String TAG_POLOGGER = "POLOGGER";
    public static final String TAG_LOCALIZATIONHELPER = "LOCALIZATIONHELPER";
    protected BuilderMgr builderMgr = new BuilderMgr();
    protected DynamicPanelMgr dynamicPanelMgr = new DynamicPanelMgr();
    protected DataGridMgr dataGridMgr = new DataGridMgr();
    protected SearchPanelMgr searchPanelMgr = new SearchPanelMgr();
    protected TreeViewMgr treeViewMgr = new TreeViewMgr();
    protected TabViewMgr tabViewMgr = new TabViewMgr();
    protected MenuExMgr menuExMgr = new MenuExMgr();
    protected CodeListMgr codeListMgr = null;
    protected ValueRuleMgr valueRuleMgr = new ValueRuleMgr();
    protected AutoCompleteMgr autoCompleteMgr = new AutoCompleteMgr();
    protected AutoFillMgr autoFillMgr = new AutoFillMgr();
    protected ValueTransformMgr valueTransformMgr = new ValueTransformMgr();
    protected ExcelReportMgr excelReportMgr = new ExcelReportMgr();
    protected StringLengthMgr stringLengthMgr = new StringLengthMgr();
    protected PickerDialogMgr pickerDialogMgr = new PickerDialogMgr();
    protected ShortcutBarMgr shortcutBarMgr = new ShortcutBarMgr();
    protected ISRFExUserMenuCaptionMgr iUserMenuCaption = null;
    protected FormImageLinkMgr formImageLinkMgr = new FormImageLinkMgr();
    protected WFConfigMgr workflowMgr = new WFConfigMgr();
    protected UIStyleMgr uiStyleMgr = new UIStyleMgr();
    protected ExcelTemplMgr excelTemplMgr = new ExcelTemplMgr();
    protected DataEntityMgr dataEntityMgr = new DataEntityMgr();
    protected GlobalConfigMgr globalConfigMgr = new GlobalConfigMgr();
    protected ToolbarMgr toolbarMgr = new ToolbarMgr();
    protected ISRFExLocalizationHelper localizationHelper = null;
    protected ArrayList arrConfigPaths = new ArrayList();
    private static String TAG_SM1 = "{A72E0CE7-3F75-4b84-BF06-7E91A0182C09}";
    private static String TAG_SM2 = "{6D72D37E-29B4-42ad-A47F-697320B27611}";
    private static String TAG_SM3 = "{CD9BA0FC-12CB-414b-8130-1285A2917050}";
    private static String TAG_SM4 = "{C0E71D58-B43E-4553-AEA1-009A3BD75CC5}";
    private static Log log = LogFactory.getLog(SRFExWebHttpModule.class);
    protected ISRFExPOLogger poLogger = null;
    protected ContextHelper contextHelper = null;

    protected void OnInit() {
        Object obj;
        super.OnInit();
        this.RegistSM();
        this.codeListMgr = this.CreateCodeListMgr();
        WebDBCallerHelperEx dbCallerHelperEx = this.CreateBCallerHelperEx();
        if (dbCallerHelperEx != null) {
            this.SetDBCallerHelperEx("", dbCallerHelperEx);
        }
        String strConfigFolderPaths = this.webConfig.GetExtValue("CONFIGEXPATH", "configex");
        String[] strConfigFolder = strConfigFolderPaths.split("[|]");
        int i = 0;
        while (i < strConfigFolder.length) {
            String strFolder = strConfigFolder[i];
            if (StringHelper.Length((String)strFolder) != 0) {
                String strConfigPath = String.valueOf(this.strRootPath) + strFolder + this.strFolderSeperator;
                this.arrConfigPaths.add(strConfigPath);
            }
            ++i;
        }
        this.dbCallConfigMgr.setConfigPaths(this.arrConfigPaths);
        this.builderMgr.setFolderSeperator(this.strFolderSeperator);
        this.dynamicPanelMgr.setFolderSeperator(this.strFolderSeperator);
        this.dataGridMgr.setFolderSeperator(this.strFolderSeperator);
        this.searchPanelMgr.setFolderSeperator(this.strFolderSeperator);
        this.treeViewMgr.setFolderSeperator(this.strFolderSeperator);
        this.tabViewMgr.setFolderSeperator(this.strFolderSeperator);
        this.menuExMgr.setFolderSeperator(this.strFolderSeperator);
        this.codeListMgr.setFolderSeperator(this.strFolderSeperator);
        this.valueRuleMgr.setFolderSeperator(this.strFolderSeperator);
        this.autoCompleteMgr.setFolderSeperator(this.strFolderSeperator);
        this.autoFillMgr.setFolderSeperator(this.strFolderSeperator);
        this.valueTransformMgr.setFolderSeperator(this.strFolderSeperator);
        this.excelReportMgr.setFolderSeperator(this.strFolderSeperator);
        this.stringLengthMgr.setFolderSeperator(this.strFolderSeperator);
        this.pickerDialogMgr.setFolderSeperator(this.strFolderSeperator);
        this.shortcutBarMgr.setFolderSeperator(this.strFolderSeperator);
        this.formImageLinkMgr.setFolderSeperator(this.strFolderSeperator);
        this.workflowMgr.setFolderSeperator(this.strFolderSeperator);
        this.uiStyleMgr.setFolderSeperator(this.strFolderSeperator);
        this.excelTemplMgr.setFolderSeperator(this.strFolderSeperator);
        this.dataEntityMgr.setFolderSeperator(this.strFolderSeperator);
        this.globalConfigMgr.setFolderSeperator(this.strFolderSeperator);
        this.toolbarMgr.setFolderSeperator(this.strFolderSeperator);
        this.builderMgr.setConfigPaths(this.arrConfigPaths);
        this.dynamicPanelMgr.setConfigPaths(this.arrConfigPaths);
        this.dataGridMgr.setConfigPaths(this.arrConfigPaths);
        this.searchPanelMgr.setConfigPaths(this.arrConfigPaths);
        this.treeViewMgr.setConfigPaths(this.arrConfigPaths);
        this.tabViewMgr.setConfigPaths(this.arrConfigPaths);
        this.menuExMgr.setConfigPaths(this.arrConfigPaths);
        this.codeListMgr.setConfigPaths(this.arrConfigPaths);
        this.valueRuleMgr.setConfigPaths(this.arrConfigPaths);
        this.autoCompleteMgr.setConfigPaths(this.arrConfigPaths);
        this.autoFillMgr.setConfigPaths(this.arrConfigPaths);
        this.valueTransformMgr.setConfigPaths(this.arrConfigPaths);
        this.excelReportMgr.setConfigPaths(this.arrConfigPaths);
        this.stringLengthMgr.setConfigPaths(this.arrConfigPaths);
        this.pickerDialogMgr.setConfigPaths(this.arrConfigPaths);
        this.shortcutBarMgr.setConfigPaths(this.arrConfigPaths);
        this.formImageLinkMgr.setConfigPaths(this.arrConfigPaths);
        this.workflowMgr.setConfigPaths(this.arrConfigPaths);
        this.uiStyleMgr.setConfigPaths(this.arrConfigPaths);
        this.excelTemplMgr.setConfigPaths(this.arrConfigPaths);
        this.dataEntityMgr.setConfigPaths(this.arrConfigPaths);
        this.globalConfigMgr.setConfigPaths(this.arrConfigPaths);
        this.toolbarMgr.setConfigPaths(this.arrConfigPaths);
        this.builderMgr.setEncrypt(this.bEncrypt);
        this.dynamicPanelMgr.setEncrypt(this.bEncrypt);
        this.dataGridMgr.setEncrypt(this.bEncrypt);
        this.searchPanelMgr.setEncrypt(this.bEncrypt);
        this.treeViewMgr.setEncrypt(this.bEncrypt);
        this.tabViewMgr.setEncrypt(this.bEncrypt);
        this.menuExMgr.setEncrypt(this.bEncrypt);
        this.codeListMgr.setEncrypt(this.bEncrypt);
        this.valueRuleMgr.setEncrypt(this.bEncrypt);
        this.autoCompleteMgr.setEncrypt(this.bEncrypt);
        this.autoFillMgr.setEncrypt(this.bEncrypt);
        this.valueTransformMgr.setEncrypt(this.bEncrypt);
        this.excelReportMgr.setEncrypt(this.bEncrypt);
        this.stringLengthMgr.setEncrypt(this.bEncrypt);
        this.pickerDialogMgr.setEncrypt(this.bEncrypt);
        this.shortcutBarMgr.setEncrypt(this.bEncrypt);
        this.formImageLinkMgr.setEncrypt(this.bEncrypt);
        this.workflowMgr.setEncrypt(this.bEncrypt);
        this.uiStyleMgr.setEncrypt(this.bEncrypt);
        this.excelTemplMgr.setEncrypt(this.bEncrypt);
        this.dataEntityMgr.setEncrypt(this.bEncrypt);
        this.globalConfigMgr.setEncrypt(this.bEncrypt);
        this.toolbarMgr.setEncrypt(this.bEncrypt);
        this.dynamicPanelMgr.setUIStyleMgr(this.uiStyleMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_THEMEEX, (Object)this.builderMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_DYNAMICPANEL, (Object)this.dynamicPanelMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_DATAGRID, (Object)this.dataGridMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_SEARCHPANEL, (Object)this.searchPanelMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_TREEVIEW, (Object)this.treeViewMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_TABVIEW, (Object)this.tabViewMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_MENUEX, (Object)this.menuExMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_CODELIST, (Object)this.codeListMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_VALUERULE, (Object)this.valueRuleMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_AUTOFILL, (Object)this.autoFillMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_AUTOCOMPLETE, (Object)this.autoCompleteMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_VALUETRANSFORM, (Object)this.valueTransformMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_EXCELREPORT, (Object)this.excelReportMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_STRINGLENGTH, (Object)this.stringLengthMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_PICKERDIALOG, (Object)this.pickerDialogMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_SHORTCUTBAR, (Object)this.shortcutBarMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_FORMIMAGELINK, (Object)this.formImageLinkMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_WORKFLOW, (Object)this.workflowMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_EXCELTEMPLATE, (Object)this.excelTemplMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_DATAENTITY, (Object)this.dataEntityMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_GLOBALCONFIG, (Object)this.globalConfigMgr);
        this.filterConfig.getServletContext().setAttribute(TAG_TOOLBAR, (Object)this.toolbarMgr);
        this.contextHelper = new ContextHelper(this.filterConfig.getServletContext());
        this.filterConfig.getServletContext().setAttribute(TAG_CONTEXTHELPER, (Object)this.contextHelper);
        try {
            ArrayList list;
            UserConfigMgr userConfigMgr = this.globalConfigMgr.GetUserConfigMgr();
            if (userConfigMgr != null && (list = userConfigMgr.getList()) != null) {
                int nCount = list.size();
                int i2 = 0;
                while (i2 < nCount) {
                    Object obj2;
                    UserConfigMgrItemConfig userConfigMgrItem;
                    Object objItem = list.get(i2);
                    if (objItem != null && objItem instanceof UserConfigMgrItemConfig && StringHelper.Length((String)(userConfigMgrItem = (UserConfigMgrItemConfig)((Object)objItem)).getID()) != 0 && (obj2 = ObjectHelper.Create(userConfigMgrItem.getObject())) != null && obj2 instanceof ConfigMgr) {
                        ConfigMgr configMgr = (ConfigMgr)obj2;
                        configMgr.setFolderSeperator(this.strFolderSeperator);
                        configMgr.setConfigPaths(this.arrConfigPaths);
                        configMgr.setEncrypt(this.bEncrypt);
                        this.filterConfig.getServletContext().setAttribute(userConfigMgrItem.getID(), (Object)configMgr);
                    }
                    ++i2;
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.codeListMgr.StartRefreshTimer();
        String strObjectId = this.webConfig.GetExtValue(TAG_USERMENUCAPTIONMGR, "");
        if (StringHelper.Length((String)strObjectId) > 0 && (obj = ObjectHelper.Create(strObjectId)) != null && obj instanceof ISRFExUserMenuCaptionMgr) {
            this.iUserMenuCaption = (ISRFExUserMenuCaptionMgr)obj;
            this.filterConfig.getServletContext().setAttribute(TAG_USERMENUCAPTIONMGR, (Object)this.iUserMenuCaption);
        }
        this.ResetJSCache();
    }

    protected void OnAfterInit() {
        super.OnAfterInit();
        boolean bAlertOnReadyCatch = this.contextHelper.getWebExConfig().GetValue("SRFEXWEB", "ALERTONREADYCATCH", false);
        if (bAlertOnReadyCatch) {
            SRFExPage.setAlertOnReadyCatch(bAlertOnReadyCatch);
        }
        this.localizationHelper = this.CreateLocalizationHelper();
        if (this.localizationHelper != null) {
            this.filterConfig.getServletContext().setAttribute(TAG_LOCALIZATIONHELPER, (Object)this.localizationHelper);
        }
        this.poLogger = this.CreatePOLogger();
        if (this.poLogger != null) {
            this.filterConfig.getServletContext().setAttribute(TAG_POLOGGER, (Object)this.poLogger);
            this.poLogger.Start();
        }
    }

    protected ISRFExLocalizationHelper CreateLocalizationHelper() {
        return new SRFExLocalizationHelper();
    }

    protected CodeListMgr CreateCodeListMgr() {
        return new CodeListMgr();
    }

    protected void ResetJSCache() {
        try {
            String strJSFolder = String.valueOf(this.strRootPath) + "jscache" + File.separator;
            File folder = new File(strJSFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            String[] files = folder.list();
            int i = 0;
            while (i < files.length) {
                File file = new File(String.valueOf(strJSFolder) + files[i]);
                file.delete();
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void DoWithPage(HttpServletRequest request, HttpServletResponse response) {
        try {
            String strRequestURL = request.getRequestURL().toString();
            int nPos = strRequestURL.lastIndexOf("backend.jsp");
            if (nPos != -1) {
                request.setCharacterEncoding("UTF8");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected WebDBCallerHelperEx CreateBCallerHelperEx() {
        return null;
    }

    protected void SetDBCallerHelperEx(String strMode, WebDBCallerHelperEx dbCallerHelperEx) {
        strMode = strMode.toUpperCase();
        dbCallerHelperEx.setConfigMgr(this.dbCallConfigMgr);
        dbCallerHelperEx.setWebConfig(this.webConfig);
        dbCallerHelperEx.Init();
        this.filterConfig.getServletContext().setAttribute("SRFDBCALLERHELPER" + strMode, (Object)dbCallerHelperEx);
        this.codeListMgr.setDBCallerHelper(strMode, dbCallerHelperEx);
    }

    protected WebDBCallerHelperEx GetDBCallerHelperEx(String strMode) {
        strMode = strMode.toUpperCase();
        Object obj = this.filterConfig.getServletContext().getAttribute("SRFDBCALLERHELPER" + strMode);
        if (obj != null && obj instanceof WebDBCallerHelperEx) {
            return (WebDBCallerHelperEx)((Object)obj);
        }
        return null;
    }

    protected void OutputLibsVersionInfo() {
        super.OutputLibsVersionInfo();
        log.info((Object)String.format("SASRFEX VERSION[%1$s]", Version.toVersionString()));
    }

    protected void OnDestroy() {
        if (this.poLogger != null) {
            this.poLogger.Stop();
            this.poLogger = null;
        }
        if (this.codeListMgr != null) {
            this.codeListMgr.StopRefreshTimer();
            this.codeListMgr = null;
        }
        super.OnDestroy();
    }

    @Override
    public boolean UpdateSession(ISRFExWebContext iWebContext, ServletRequest request, ServletResponse reponse) {
        return true;
    }

    @Override
    public void CreateSession(HttpSession session) {
    }

    @Override
    public void RemoveSession(HttpSession session) {
    }

    private void RegistSM() {
        this.filterConfig.getServletContext().setAttribute(TAG_SM1, (Object)this);
        this.filterConfig.getServletContext().setAttribute(TAG_SM2, (Object)this);
        this.filterConfig.getServletContext().setAttribute(TAG_SM3, (Object)this);
        this.filterConfig.getServletContext().setAttribute(TAG_SM4, (Object)this);
    }

    protected ISRFExPOLogger CreatePOLogger() {
        SRFExPOLogger poLogger = new SRFExPOLogger();
        poLogger.setGlobalHelper(this.contextHelper);
        return poLogger;
    }
}

