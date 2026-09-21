/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Web.WebConfig
 *  javax.servlet.ServletContext
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.DataEntityMgr;
import SA.SRFramework.Localization.ISRFExLocalizationHelper;
import SA.SRFramework.ReportEx.Model.ExcelTemplMgr;
import SA.SRFramework.ValueRule.ValueRuleMgr;
import SA.SRFramework.Web.WebConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarMgr;
import SA.SRFramework.WebEx.UI.AutoCompleteMgr;
import SA.SRFramework.WebEx.UI.DataGridMgr;
import SA.SRFramework.WebEx.UI.DynamicPanelMgr;
import SA.SRFramework.WebEx.UI.ExcelReportMgr;
import SA.SRFramework.WebEx.UI.FormImageLinkMgr;
import SA.SRFramework.WebEx.UI.GlobalConfigMgr;
import SA.SRFramework.WebEx.UI.SearchPanelMgr;
import SA.SRFramework.WebEx.UI.ShortcutBarMgr;
import SA.SRFramework.WebEx.UI.TabViewMgr;
import SA.SRFramework.WebEx.UI.TreeViewMgr;
import SA.SRFramework.WebEx.UI.ValueTransformMgr;
import SA.SRFramework.WebEx.UI.WebExConfig;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SA.SRFramework.WebEx.Utility.ISRFExPOLogger;
import SA.SRFramework.Workflow.WFConfigMgr;
import javax.servlet.ServletContext;

public class ContextHelper
implements ISRFExGlobalHelper {
    protected ServletContext servletContext = null;
    protected ISRFExLocalizationHelper localizationHelper = null;

    public ContextHelper(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return this.servletContext;
    }

    @Override
    public WebConfig getWebConfig() {
        return (WebConfig)this.servletContext.getAttribute("SRFWEBCONFIG");
    }

    @Override
    public GlobalConfigMgr getGlobalConfigMgr() {
        return (GlobalConfigMgr)((Object)this.servletContext.getAttribute("GLOBALCONFIG"));
    }

    @Override
    public CodeListMgr getCodeListMgr() {
        return (CodeListMgr)((Object)this.servletContext.getAttribute("CODELIST"));
    }

    @Override
    public AutoCompleteMgr getAutoCompleteMgr() {
        return (AutoCompleteMgr)((Object)this.servletContext.getAttribute("AUTOCOMLETE"));
    }

    @Override
    public BaseDBCallerHelper getDBCaller() {
        return this.OnGetDBCaller("");
    }

    @Override
    public BaseDBCallerHelper getDBCaller(String strMode) {
        return this.OnGetDBCaller(strMode);
    }

    protected BaseDBCallerHelper OnGetDBCaller(String strMode) {
        BaseDBCallerHelper dbCaller = (BaseDBCallerHelper)this.servletContext.getAttribute("SRFDBCALLERHELPER" + strMode);
        return dbCaller;
    }

    @Override
    public BaseDBCallerHelperEx getDBCallerEx() {
        return this.OnGetDBCallerEx("");
    }

    @Override
    public BaseDBCallerHelperEx getDBCallerEx(String strMode) {
        return this.OnGetDBCallerEx(strMode);
    }

    protected BaseDBCallerHelperEx OnGetDBCallerEx(String strMode) {
        BaseDBCallerHelperEx dbCaller = (BaseDBCallerHelperEx)((Object)this.servletContext.getAttribute("SRFDBCALLERHELPER" + strMode));
        return dbCaller;
    }

    @Override
    public WebExConfig getWebExConfig() {
        return this.getGlobalConfigMgr().GetWebExConfig();
    }

    @Override
    public String GetTempPath() {
        return this.getWebExConfig().GetValue("SRFEXWEB", "TEMPFOLDER", "");
    }

    @Override
    public String GetAppRootPath() {
        return (String)this.servletContext.getAttribute("APPROOTPATH");
    }

    @Override
    public FormImageLinkMgr getFormImageLinkMgr() {
        return (FormImageLinkMgr)((Object)this.servletContext.getAttribute("FORMIMAGELINK"));
    }

    @Override
    public WFConfigMgr getWorkflowMgr() {
        return (WFConfigMgr)((Object)this.servletContext.getAttribute("WORKFLOW"));
    }

    @Override
    public ExcelTemplMgr getExcelTemplMgr() {
        return (ExcelTemplMgr)((Object)this.servletContext.getAttribute("EXCELTEMPLATE"));
    }

    @Override
    public ValueTransformMgr getValueTransformMgr() {
        return (ValueTransformMgr)((Object)this.servletContext.getAttribute("VALUETRANSFORM"));
    }

    @Override
    public ExcelReportMgr getExcelReportMgr() {
        return (ExcelReportMgr)((Object)this.servletContext.getAttribute("EXCELREPORT"));
    }

    @Override
    public DataEntityMgr getDataEntityMgr() {
        return (DataEntityMgr)((Object)this.servletContext.getAttribute("DATAENTITY"));
    }

    @Override
    public ToolbarMgr getToolbarMgr() {
        return (ToolbarMgr)((Object)this.servletContext.getAttribute("TOOLBAR"));
    }

    @Override
    public DynamicPanelMgr getDynamicPanelMgr() {
        return (DynamicPanelMgr)((Object)this.servletContext.getAttribute("DYNAMICPANEL"));
    }

    @Override
    public DataGridMgr getDataGridMgr() {
        return (DataGridMgr)((Object)this.servletContext.getAttribute("DATAGRID"));
    }

    @Override
    public ShortcutBarMgr getShortcutBarMgr() {
        return (ShortcutBarMgr)((Object)this.servletContext.getAttribute("SHORTCUTBAR"));
    }

    @Override
    public ValueRuleMgr getValueRuleMgr() {
        return (ValueRuleMgr)((Object)this.servletContext.getAttribute("VALUERULE"));
    }

    @Override
    public SearchPanelMgr getSearchPanelMgr() {
        return (SearchPanelMgr)((Object)this.servletContext.getAttribute("SEARCHPANEL"));
    }

    @Override
    public TreeViewMgr getTreeViewMgr() {
        return (TreeViewMgr)((Object)this.servletContext.getAttribute("TREEVIEW"));
    }

    @Override
    public TabViewMgr getTabViewMgr() {
        return (TabViewMgr)((Object)this.servletContext.getAttribute("TABVIEW"));
    }

    @Override
    public ISRFExPOLogger getPOLogger() {
        Object objLogger = this.GetGlobalValue("POLOGGER");
        if (objLogger == null) {
            return null;
        }
        if (objLogger instanceof ISRFExPOLogger) {
            return (ISRFExPOLogger)objLogger;
        }
        return null;
    }

    @Override
    public Object GetGlobalValue(String strKey) {
        return this.servletContext.getAttribute(strKey);
    }

    @Override
    public void SetGlobalValue(String strKey, Object objValue) {
        if (objValue == null) {
            this.servletContext.removeAttribute(strKey);
        } else {
            this.servletContext.setAttribute(strKey, objValue);
        }
    }

    public int GetExtJSVersion() {
        return this.getWebExConfig().GetValue("SRFEXWEB", "EXTJSVERSION", 220);
    }

    @Override
    public ISRFExLocalizationHelper getLocalizationHelper() {
        if (this.localizationHelper != null) {
            return this.localizationHelper;
        }
        Object objLocalizationHelper = this.GetGlobalValue("LOCALIZATIONHELPER");
        if (objLocalizationHelper == null) {
            return null;
        }
        if (objLocalizationHelper instanceof ISRFExLocalizationHelper) {
            this.localizationHelper = (ISRFExLocalizationHelper)objLocalizationHelper;
            return this.localizationHelper;
        }
        return null;
    }
}

