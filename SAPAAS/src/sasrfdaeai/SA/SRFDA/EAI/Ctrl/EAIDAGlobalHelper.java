/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.CodeList.DACodeListMgr
 *  SA.SRFDA.Common.DAConfigMgr
 *  SA.SRFDA.Ctrl.DEDCProcessStorage
 *  SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper
 *  SA.SRFDA.Ctrl.IDAConfigHelper
 *  SA.SRFDA.Ctrl.IDAMBConfigHelper
 *  SA.SRFDA.Ctrl.IDAModelHelper
 *  SA.SRFDA.Ctrl.IDAModelStorage
 *  SA.SRFDA.Ctrl.IDEDataCtrlHelper
 *  SA.SRFDA.Ctrl.RegisterMgr
 *  SA.SRFDA.Ctrl.ServiceMgr
 *  SA.SRFDA.Model.IDAFormItemHelper
 *  SA.SRFDA.Security.IPasswordStorage
 *  SA.SRFDA.Security.PasswordStorageFactory
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFDA.Web.Utility.ISRFDAPOLogger
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.DataEntityMgr
 *  SA.SRFramework.Localization.ISRFExLocalizationHelper
 *  SA.SRFramework.ReportEx.Model.ExcelTemplMgr
 *  SA.SRFramework.ValueRule.ValueRuleMgr
 *  SA.SRFramework.Web.WebConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarMgr
 *  SA.SRFramework.WebEx.UI.AutoCompleteMgr
 *  SA.SRFramework.WebEx.UI.DataGridMgr
 *  SA.SRFramework.WebEx.UI.DynamicPanelMgr
 *  SA.SRFramework.WebEx.UI.ExcelReportMgr
 *  SA.SRFramework.WebEx.UI.FormImageLinkMgr
 *  SA.SRFramework.WebEx.UI.GlobalConfigMgr
 *  SA.SRFramework.WebEx.UI.SearchPanelMgr
 *  SA.SRFramework.WebEx.UI.ShortcutBarMgr
 *  SA.SRFramework.WebEx.UI.TabViewMgr
 *  SA.SRFramework.WebEx.UI.TreeViewMgr
 *  SA.SRFramework.WebEx.UI.ValueTransformMgr
 *  SA.SRFramework.WebEx.UI.WebExConfig
 *  SA.SRFramework.WebEx.Utility.ISRFExPOLogger
 *  SA.SRFramework.Workflow.WFConfigMgr
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.CodeList.DACodeListMgr;
import SA.SRFDA.Common.DAConfigMgr;
import SA.SRFDA.Ctrl.DEDCProcessStorage;
import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDAMBConfigHelper;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.RegisterMgr;
import SA.SRFDA.Ctrl.ServiceMgr;
import SA.SRFDA.Model.IDAFormItemHelper;
import SA.SRFDA.Security.IPasswordStorage;
import SA.SRFDA.Security.PasswordStorageFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.ISRFDAPOLogger;
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

public class EAIDAGlobalHelper
implements ISRFDAGlobalHelper {
    private BaseDBCallerHelperEx baseDBCallerHelperEx = null;
    private IDAModelHelper daModelHelper = null;
    private IDAModelStorage daModelStorage = null;
    private IDEDataCtrlHelper iDEDataCtrlHelper = null;
    protected RegisterMgr registerMgr = new RegisterMgr((ISRFDAGlobalHelper)this);
    private DAConfigMgr daConfigMgr = null;
    private GlobalConfigMgr globalConfigMgr = null;

    public DACodeListMgr getCodeListMgr() {
        return null;
    }

    public void setDAConfigMgr(DAConfigMgr daConfigMgr) {
        this.daConfigMgr = daConfigMgr;
    }

    public DAConfigMgr getDAConfigMgr() {
        return this.daConfigMgr;
    }

    public IDAFormItemHelper getDAFormItemHelper() {
        return null;
    }

    public void setDAModelHelper(IDAModelHelper daModelHelper) {
        this.daModelHelper = daModelHelper;
    }

    public IDAModelHelper getDAModelHelper() {
        return this.daModelHelper;
    }

    public void setDAModelStorage(IDAModelStorage daModelStorage) {
        this.daModelStorage = daModelStorage;
    }

    public IDAModelStorage getDAModelStorage() {
        return this.daModelStorage;
    }

    public IDEDataCtrlHelper getDEDataCtrlHelper() {
        return this.iDEDataCtrlHelper;
    }

    public void setDEDataCtrlHelper(IDEDataCtrlHelper iDEDataCtrlHelper) {
        this.iDEDataCtrlHelper = iDEDataCtrlHelper;
    }

    public String GetAppRootPath() {
        return null;
    }

    public Object GetGlobalValue(String strKey) {
        return null;
    }

    public void SetGlobalValue(String strKey, Object objValue) {
    }

    public String GetTempPath() {
        return null;
    }

    public AutoCompleteMgr getAutoCompleteMgr() {
        return null;
    }

    public void setDBCallerEx(BaseDBCallerHelperEx baseDBCallerHelperEx) {
        this.baseDBCallerHelperEx = baseDBCallerHelperEx;
    }

    public BaseDBCallerHelper getDBCaller() {
        return this.baseDBCallerHelperEx;
    }

    public BaseDBCallerHelper getDBCaller(String strMode) {
        return this.baseDBCallerHelperEx;
    }

    public BaseDBCallerHelperEx getDBCallerEx() {
        return this.baseDBCallerHelperEx;
    }

    public BaseDBCallerHelperEx getDBCallerEx(String strMode) {
        return this.baseDBCallerHelperEx;
    }

    public DataEntityMgr getDataEntityMgr() {
        return null;
    }

    public DataGridMgr getDataGridMgr() {
        return null;
    }

    public DynamicPanelMgr getDynamicPanelMgr() {
        return null;
    }

    public ExcelReportMgr getExcelReportMgr() {
        return null;
    }

    public ExcelTemplMgr getExcelTemplMgr() {
        return null;
    }

    public FormImageLinkMgr getFormImageLinkMgr() {
        return null;
    }

    public void setGlobalConfigMgr(GlobalConfigMgr globalConfigMgr) {
        this.globalConfigMgr = globalConfigMgr;
    }

    public GlobalConfigMgr getGlobalConfigMgr() {
        return this.globalConfigMgr;
    }

    public SearchPanelMgr getSearchPanelMgr() {
        return null;
    }

    public ShortcutBarMgr getShortcutBarMgr() {
        return null;
    }

    public TabViewMgr getTabViewMgr() {
        return null;
    }

    public ToolbarMgr getToolbarMgr() {
        return null;
    }

    public TreeViewMgr getTreeViewMgr() {
        return null;
    }

    public ValueRuleMgr getValueRuleMgr() {
        return null;
    }

    public ValueTransformMgr getValueTransformMgr() {
        return null;
    }

    public WebConfig getWebConfig() {
        return null;
    }

    public WebExConfig getWebExConfig() {
        return this.globalConfigMgr.GetWebExConfig();
    }

    public WFConfigMgr getWorkflowMgr() {
        return null;
    }

    public IDEDataCtrlHelper getDEDataCtrlHelper(String strDBStorage) {
        return this.iDEDataCtrlHelper;
    }

    public IDAConfigHelper getDAConfigHelper(String strLanguage, String strPageModel) {
        return null;
    }

    public int getDAModelVersion() {
        return this.getWebExConfig().GetValue("SRFDA", "DAMODEL", 99999999);
    }

    public DEDCProcessStorage getDEDCProcessStorage() {
        return null;
    }

    public String getDAModelDB() {
        return this.getWebExConfig().GetValue("SRFDA", "DAMODELDB", "DB2");
    }

    public RegisterMgr getRegisterMgr() {
        return this.registerMgr;
    }

    public ServiceMgr getServiceMgr() {
        return null;
    }

    public ISRFExPOLogger getPOLogger() {
        return null;
    }

    public ISRFDAPOLogger getPOLoggerEx() {
        return null;
    }

    public ISRFExLocalizationHelper getLocalizationHelper() {
        return null;
    }

    public IDataNotifyHelper getDataNotifyHelper() {
        return null;
    }

    public IDAMBConfigHelper getDAMBConfigHelper(String strLanguage, String strPageModel) throws Exception {
        return null;
    }

    public IPasswordStorage getPasswordStorage() throws Exception {
        return PasswordStorageFactory.Create((ISRFDAGlobalHelper)this);
    }

    public /* synthetic */ String getAppMode() {
        throw new Error("Unresolved compilation problem: \n\tThe type EAIDAGlobalHelper must implement the inherited abstract method ISRFDAGlobalHelper.getAppMode()\n");
    }
}

