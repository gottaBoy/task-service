/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Web.WebConfig
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
import SA.SRFramework.WebEx.Utility.ISRFExPOLogger;
import SA.SRFramework.Workflow.WFConfigMgr;

public interface ISRFExGlobalHelper {
    public WebConfig getWebConfig();

    public GlobalConfigMgr getGlobalConfigMgr();

    public CodeListMgr getCodeListMgr();

    public AutoCompleteMgr getAutoCompleteMgr();

    public BaseDBCallerHelper getDBCaller();

    public BaseDBCallerHelper getDBCaller(String var1);

    public BaseDBCallerHelperEx getDBCallerEx();

    public BaseDBCallerHelperEx getDBCallerEx(String var1);

    public WebExConfig getWebExConfig();

    public String GetTempPath();

    public String GetAppRootPath();

    public FormImageLinkMgr getFormImageLinkMgr();

    public WFConfigMgr getWorkflowMgr();

    public ExcelTemplMgr getExcelTemplMgr();

    public ValueTransformMgr getValueTransformMgr();

    public ExcelReportMgr getExcelReportMgr();

    public DataEntityMgr getDataEntityMgr();

    public ToolbarMgr getToolbarMgr();

    public DynamicPanelMgr getDynamicPanelMgr();

    public DataGridMgr getDataGridMgr();

    public ShortcutBarMgr getShortcutBarMgr();

    public ValueRuleMgr getValueRuleMgr();

    public SearchPanelMgr getSearchPanelMgr();

    public TreeViewMgr getTreeViewMgr();

    public TabViewMgr getTabViewMgr();

    public Object GetGlobalValue(String var1);

    public void SetGlobalValue(String var1, Object var2);

    public ISRFExPOLogger getPOLogger();

    public ISRFExLocalizationHelper getLocalizationHelper();
}

