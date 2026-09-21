/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DEDataCtrl
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.Data.PageLog
 *  SA.SRFDA.Ctrl.IDAConfigHelper
 *  SA.SRFDA.Ctrl.IDAModelHelper
 *  SA.SRFDA.Ctrl.IDAModelStorage
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngine
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Web.ISRFDAPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.PageLogicEngine
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebConfig
 *  SA.SRFramework.WebEx.DGEx.SRFExDGEx
 *  SA.SRFramework.WebEx.DGEx.SRFExDGExRowCountList
 *  SA.SRFramework.WebEx.DGEx.UI.DGExConfig
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  SA.SRFramework.WebEx.Form.SRFExBaseForm
 *  SA.SRFramework.WebEx.Form.SRFExBaseFormAction
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExFormCustomCallAction
 *  SA.SRFramework.WebEx.Form.SRFExFormIndicatorAction
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SP.UI.SPExConfig
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDataGridRowActionList
 *  SA.SRFramework.WebEx.SRFExDataGridRowCountList
 *  SA.SRFramework.WebEx.SRFExDataGridThemeList
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.SRFExTabViewSideBar
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarConfig
 *  SA.SRFramework.WebEx.UI.DataGridConfig
 *  SA.SRFramework.WebEx.UI.TabViewConfig
 *  SA.SRFramework.WebEx.UI.TreePanelConfig
 *  javax.servlet.jsp.PageContext
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.PageLog;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlEngine;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Web.Form.SRFDAFormIndicatorAction;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.PageLogicEngine;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.WebConfig;
import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.DGEx.SRFExDGExRowCountList;
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormCustomCallAction;
import SA.SRFramework.WebEx.Form.SRFExFormIndicatorAction;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SP.UI.SPExConfig;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridRowActionList;
import SA.SRFramework.WebEx.SRFExDataGridRowCountList;
import SA.SRFramework.WebEx.SRFExDataGridThemeList;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExTabViewSideBar;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TreePanelConfig;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import javax.servlet.jsp.PageContext;
import net.sf.json.JSONObject;

public abstract class SRFDAPage
extends SRFExPage
implements ISRFDAPage {
    protected String strPageDataEntityId = "";
    protected DataEntity pageDataEntity = null;
    protected IDEHelper iDEHelper = null;
    private Hashtable<String, IDEDataCtrl> deDataCtrlMap = new Hashtable();
    public static final String TAG_WEBCONTEXT = "WEBCONTEXT";
    protected String strPageModel = "";
    protected IDEDataCtrlEngine iDEDataCtrlEngine = null;
    protected static IDEDataCtrl pageLogDataCtrl = null;
    protected PageModel pageModel = null;
    protected String strLastPageLogId = "";

    public static void setPageLogDataCtrl(IDEDataCtrl dataCtrl) {
        pageLogDataCtrl = dataCtrl;
    }

    public SRFDAPage() {
        this.setOutputDebug(false);
    }

    protected void setPageDataEntityId(String strPageDataEntityId) {
        this.strPageDataEntityId = strPageDataEntityId;
    }

    public String getPageDataEntityId() {
        return this.strPageDataEntityId;
    }

    public DataEntity getPageDataEntity() {
        return this.pageDataEntity;
    }

    protected String OnGetPageModel() {
        return this.getWebContext().getSRFPageModel();
    }

    public IDAConfigHelper getDAConfigHelper() {
        IDAConfigHelper iDAConfigHelper = this.OnGetDAConfigHelper();
        if (iDAConfigHelper != null) {
            iDAConfigHelper.setCurPage((ISRFDAPage)this);
        }
        return iDAConfigHelper;
    }

    protected IDAConfigHelper OnGetDAConfigHelper() {
        if (this.getDEHelper() != null) {
            return this.getDEHelper().GetDAConfigHelper(this.getLanguage(), this.strPageModel);
        }
        return this.getWebContext().getGlobalHelper().getDAConfigHelper(this.getLanguage(), this.strPageModel);
    }

    public IDEHelper getDEHelper() {
        if (this.iDEHelper != null && StringHelper.Compare((String)this.iDEHelper.getId(), (String)this.strPageDataEntityId, (boolean)true) == 0) {
            return this.iDEHelper;
        }
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            this.iDEHelper = null;
            return null;
        }
        this.iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(this.strPageDataEntityId);
        if (this.iDEHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.strPageDataEntityId));
        }
        return this.iDEHelper;
    }

    public final IDAModelHelper getDAModelHelper() {
        return this.getWebContext().getGlobalHelper().getDAModelHelper();
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.PreparePageParam();
        this.strPageModel = this.OnGetPageModel();
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            this.setControlValueFromUniqueId(false);
            if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                this.setFrontUIStyle(11);
            } else if (StringHelper.Compare((String)this.strPageModel, (String)"WinRT", (boolean)true) == 0) {
                this.setFrontUIStyle(12);
            }
            try {
                this.getRequest().setCharacterEncoding("UTF-8");
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (this.IsOutputPageModel()) {
            this.pageModel = this.CreatePageModel();
            this.PreparePageModel();
        }
        return true;
    }

    protected void PreparePageParam() {
    }

    protected void PreparePageModel() {
    }

    protected PageModel CreatePageModel() {
        return new PageModel();
    }

    protected static boolean ExecPageLogic(SRFDAPage daPage, DEDataCtrl deDataCtrl) {
        if (deDataCtrl == null) {
            return true;
        }
        IDEDataCtrlEngine pageLogicEngine = daPage.GetPageLogicEngine();
        if (pageLogicEngine == null) {
            daPage.PageLog((Object)daPage, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762\u903b\u8f91\u5904\u7406\u5f15\u64ce"));
            return false;
        }
        BaseDataEntity arg = new BaseDataEntity();
        CallResult callResult = pageLogicEngine.CustomCall(deDataCtrl, arg, deDataCtrl.getDEDATACTRLNAME());
        if (callResult.IsError()) {
            daPage.PageLog((Object)daPage, 1, StringHelper.Format((String)"\u6267\u884c\u9875\u9762\u5904\u7406\u903b\u8f91[%1$s]\u5931\u8d25\uff0c%2$s", (Object)deDataCtrl.getDEDATACTRLNAME(), (Object)callResult.getErrorInfo()));
            return false;
        }
        return true;
    }

    protected IDEDataCtrlEngine GetPageLogicEngine() {
        if (this.iDEDataCtrlEngine != null) {
            return this.iDEDataCtrlEngine;
        }
        IDEDataCtrl iDataCtrl = this.GetDEDataCtrl();
        if (iDataCtrl == null) {
            return null;
        }
        this.iDEDataCtrlEngine = new PageLogicEngine();
        this.iDEDataCtrlEngine.Init(iDataCtrl, (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        return this.iDEDataCtrlEngine;
    }

    public final IDAModelStorage getDAModelStorage() {
        return this.getWebContext().getGlobalHelper().getDAModelStorage();
    }

    public final ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.getWebContext().getGlobalHelper();
    }

    public void PageLog(Object obj, int nLevel, String strInfo, Throwable throwable) {
        super.PageLog(obj, nLevel, strInfo, throwable);
        if ((nLevel == 1 || nLevel == 2) && pageLogDataCtrl != null) {
            this.strLastPageLogId = Helper.GenGuidEx();
            SRFDAPage.PageLog(this, this.strLastPageLogId, obj, nLevel, strInfo, throwable);
        }
    }

    private static void PageLog(SRFDAPage page, String strLastPageLogId, Object obj, int nLevel, String strInfo, Throwable throwable) {
        PageLog pageLog = new PageLog();
        BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)pageLog, (boolean)false);
        BaseDEDataCtrl.SetCallParamRetData((BaseDataEntity)pageLog, (boolean)false);
        pageLog.setPAGELOGID(strLastPageLogId);
        if (StringHelper.Length((String)strInfo) > 100) {
            strInfo = String.valueOf(strInfo.substring(0, 90)) + "...";
        }
        pageLog.setPAGELOGNAME(strInfo);
        pageLog.setPAGEPATH(page.getCurPagePath());
        pageLog.setFRONTCALL(!page.IsBackEndMode());
        pageLog.setDEID(page.getPageControlID());
        if (nLevel == 1) {
            pageLog.setLOGLEVEL(40000);
        } else if (nLevel == 2) {
            pageLog.setLOGLEVEL(50000);
        }
        if (page.getWebContext() != null) {
            pageLog.setQUERYSTRING(page.getWebContext().GetQueryString());
            pageLog.setLOGINNAME(page.getWebContext().getCurUserId());
            pageLog.setIPADDR(page.getWebContext().getRemoteAddr());
        }
        String strTraceInfo = strInfo;
        if (throwable == null) {
            throwable = new Throwable();
        } else {
            strTraceInfo = String.valueOf(strTraceInfo) + "\r\n\r\n" + throwable.toString();
        }
        int i = 0;
        while (i < throwable.getStackTrace().length) {
            StackTraceElement frame = throwable.getStackTrace()[i];
            String strInfo2 = frame.toString();
            if (strInfo2.indexOf("SA.SRFDA.Web.SRFDAPage.PageLog") == -1 && strInfo2.indexOf("SA.SRFramework.WebEx.SRFExPage.PageLog") == -1) {
                strTraceInfo = String.valueOf(strTraceInfo) + "\r\n\t" + strInfo2;
            }
            ++i;
        }
        pageLog.setCALLSTACKINFO(strTraceInfo);
        pageLogDataCtrl.Save(true, (BaseDataEntity)pageLog);
    }

    protected SRFExWebContext CreateWebContext() {
        String strWebContextObject = SRFDAPage.getWebConfig(this.getPageContext()).GetExtValue(TAG_WEBCONTEXT, "");
        if (StringHelper.Length((String)strWebContextObject) == 0) {
            this.PageLog((Object)this, 2, StringHelper.Format((String)"!!\u65e0\u6548\u7684\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61[%1$s]\r\n", (Object)strWebContextObject));
            return null;
        }
        SRFExWebContext webContext = SRFDAPage.GetWebContext(strWebContextObject, this);
        if (webContext == null) {
            this.PageLog((Object)this, 2, StringHelper.Format((String)"!!\u65e0\u6548\u7684\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61[%1$s]\r\n", (Object)strWebContextObject));
            return null;
        }
        if (!this.IsBackEndMode()) {
            webContext.SetParamValue("SRFACCSEQ", Helper.GenGuidEx());
        }
        return webContext;
    }

    public String OutputPageModel() {
        JSONObject jsonObject = new JSONObject();
        this.OnFillPageModel(jsonObject);
        if (this.pageModel != null) {
            this.pageModel.FillJSONObject(jsonObject);
        }
        this.LogPagePerformance();
        return jsonObject.toString();
    }

    public PageModel GetOfflinePageModel(JSONObject jsonObject) {
        this.OnFillPageModel(jsonObject);
        if (this.pageModel != null) {
            this.pageModel.FillJSONObject(jsonObject);
        }
        return this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (this.pageModel != null) {
            this.pageModel.setBackendUrl(this.getDefaultBackEndUrl());
            this.pageModel.setPageDataEntityId(this.strPageDataEntityId);
            this.pageModel.setHelpItem(this.OnGetPageHelpItem());
            this.pageModel.setImportMode(this.OnGetPageDataImportMode());
        }
        return true;
    }

    public static String OutputRedirectModel(String strUrl) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("redirecturl", (Object)strUrl);
        return jsonObject.toString();
    }

    protected static SRFExWebContext GetWebContext(String strWebContextObject, SRFExPage page) {
        Object obj;
        block8: {
            Method method;
            block7: {
                Class<?> cl;
                block6: {
                    try {
                        cl = Class.forName(strWebContextObject);
                        if (cl != null) break block6;
                        return null;
                    }
                    catch (Exception ex) {
                        page.PageLog((Object)page, 1, "\u65e0\u6cd5\u5efa\u7acb\u7f51\u9875\u4e0a\u4e0b\u6587\u5bf9\u8c61", (Throwable)ex);
                        return null;
                    }
                }
                Class[] paramTypes = new Class[]{SRFExPage.class};
                method = cl.getMethod("Current", paramTypes);
                if (method != null) break block7;
                return null;
            }
            obj = method.invoke(null, page);
            if (obj != null) break block8;
            return null;
        }
        if (obj instanceof SRFExWebContext) {
            return (SRFExWebContext)obj;
        }
        return null;
    }

    private static WebConfig getWebConfig(PageContext pageContext) {
        return (WebConfig)pageContext.getServletContext().getAttribute("SRFWEBCONFIG");
    }

    public SRFDAWebContext getWebContext() {
        SRFExWebContext webContext = super.getWebContext();
        if (webContext != null && webContext instanceof SRFDAWebContext) {
            return (SRFDAWebContext)webContext;
        }
        return null;
    }

    protected boolean LoadPageDataEntity() {
        return this.OnLoadPageDataEntity();
    }

    protected boolean OnLoadPageDataEntity() {
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u9875\u9762\u5b9e\u4f53\u5bf9\u8c61");
            return false;
        }
        IDEHelper iDEHelper = this.getDEHelper();
        if (iDEHelper != null) {
            this.pageDataEntity = iDEHelper.getDataEntity();
        }
        return this.pageDataEntity != null;
    }

    protected static SRFExDataGridThemeList CreateDataGridThemeList(SRFExPage page, String strDataGridThemeId, int nWidth) {
        SRFExDataGridThemeList dataGridThemeList = new SRFExDataGridThemeList();
        dataGridThemeList.InitConfig();
        dataGridThemeList.setID(strDataGridThemeId);
        if (dataGridThemeList.getDataGridThemeListConfig().getWidthEx() == 0.0) {
            dataGridThemeList.getDataGridThemeListConfig().setWidthEx((double)nWidth);
        }
        page.AddControl((SRFExControl)dataGridThemeList);
        return dataGridThemeList;
    }

    protected static SRFExDataGrid CreateDataGrid(SRFDAPage page, String strDataGridId, double nWidth, double nHeight, String strConfig) {
        return SRFDAPage.CreateDataGrid(page, strDataGridId, nWidth, nHeight, strConfig, true);
    }

    protected static SRFExDataGrid CreateDataGrid(SRFDAPage page, String strDataGridId, double nWidth, double nHeight, String strConfig, boolean bCache) {
        DataGridConfig dataGridConfig = null;
        dataGridConfig = bCache ? page.getWebContext().GetConfigCache().GetDataGridConfig(page.getWebContext(), strDataGridId, strConfig) : page.getWebContext().getDataGridMgr().GetDataGridConfig(strConfig);
        if (dataGridConfig != null) {
            SRFExDataGrid dataGrid = new SRFExDataGrid();
            if (!StringHelper.IsNullOrEmpty((String)page.getPageModel())) {
                dataGrid.setEnableUserDGTheme(false);
            }
            dataGrid.setConfig((XMLConfig)dataGridConfig);
            dataGrid.setID(strDataGridId);
            if (!page.IsBackEndMode()) {
                if (dataGrid.getDataGridConfig().getWidth() == 0 && nWidth != 0.0) {
                    dataGrid.getDataGridConfig().setWidthEx(nWidth);
                }
                if (dataGrid.getDataGridConfig().getHeight() == 0 && nHeight != 0.0) {
                    dataGrid.getDataGridConfig().setHeightEx(nHeight);
                }
            }
            page.AddControl((SRFExControl)dataGrid);
            return dataGrid;
        }
        page.PageLog((Object)page, 1, StringHelper.Format((String)"\u8868\u683c\u89c6\u56fe\u914d\u7f6e[%1$s]\u65e0\u6548", (Object)strConfig));
        return null;
    }

    protected static SRFExDGEx CreateDGEx(SRFDAPage page, String strDGExId, double nWidth, double nHeight, String strConfig) {
        return SRFDAPage.CreateDGEx(page, strDGExId, nWidth, nHeight, strConfig, true);
    }

    protected static SRFExDGEx CreateDGEx(SRFDAPage page, String strDGExId, double nWidth, double nHeight, String strConfig, boolean bCache) {
        DGExConfig dgExConfig = null;
        dgExConfig = bCache ? page.getWebContext().GetConfigCache().GetDGExConfig(page.getWebContext(), strDGExId, strConfig) : page.getWebContext().getDataGridMgr().GetDGExConfig(strConfig);
        if (dgExConfig != null) {
            SRFExDGEx dgEx = new SRFExDGEx();
            dgEx.setConfig((XMLConfig)dgExConfig);
            dgEx.setID(strDGExId);
            if (!page.IsBackEndMode()) {
                if (dgEx.getDGExConfig().getWidth() == 0 && nWidth != 0.0) {
                    dgEx.getDGExConfig().setWidthEx(nWidth);
                }
                if (dgEx.getDGExConfig().getHeight() == 0 && nHeight != 0.0) {
                    dgEx.getDGExConfig().setHeightEx(nHeight);
                }
            }
            page.AddControl((SRFExControl)dgEx);
            return dgEx;
        }
        page.PageLog((Object)page, 1, StringHelper.Format((String)"\u8868\u683c\u89c6\u6269\u5c55\u56fe\u914d\u7f6e[%1$s]\u65e0\u6548", (Object)strConfig));
        return null;
    }

    protected static SRFExToolbar CreateToolbar(SRFDAPage page, String strToolbarId, double nWidth, double nHeight) {
        return SRFDAPage.CreateToolbar(page, strToolbarId, nWidth, nHeight, "");
    }

    protected static SRFExToolbar CreateToolbar(SRFDAPage page, String strToolbarId, double nWidth, double nHeight, String strConfig) {
        ToolbarConfig toolBarConfig = null;
        toolBarConfig = !page.IsBackEndMode() ? page.getWebContext().getToolbarMgr().GetToolbarConfig(strConfig) : new ToolbarConfig();
        if (toolBarConfig != null) {
            SRFExToolbar toolBar = new SRFExToolbar();
            toolBar.setConfig((XMLConfig)toolBarConfig);
            toolBar.setID(strToolbarId);
            if (!page.IsBackEndMode()) {
                if (toolBar.getToolbarConfig().getWidth() == 0 && nWidth != 0.0) {
                    toolBar.getToolbarConfig().setWidthEx(nWidth);
                }
                if (toolBar.getToolbarConfig().getHeight() == 0 && nHeight != 0.0) {
                    toolBar.getToolbarConfig().setHeightEx(nHeight);
                }
            }
            page.AddControl((SRFExControl)toolBar);
            return toolBar;
        }
        page.PageLog((Object)page, 1, StringHelper.Format((String)"\u5de5\u5177\u680f\u89c6\u56fe\u914d\u7f6e[%1$s]\u65e0\u6548", (Object)strConfig));
        return null;
    }

    protected static SRFExSPEx CreateSPEx(SRFDAPage page, String strSearchPanelId, String strConfig) {
        return SRFDAPage.CreateSPEx(page, strSearchPanelId, strConfig, false);
    }

    protected static SRFExSPEx CreateSPEx(SRFDAPage page, String strSearchPanelId, String strConfig, boolean bCache) {
        SPExConfig searchPanelExConfig = null;
        searchPanelExConfig = bCache ? page.getWebContext().GetConfigCache().GetSPExConfig(page.getWebContext(), strSearchPanelId, strConfig) : page.getWebContext().getSearchPanelMgr().GetSPExConfig(strConfig);
        if (searchPanelExConfig != null) {
            SRFExSearchForm searchForm;
            SRFExSPEx searchPanel = new SRFExSPEx();
            searchPanel.setConfig((XMLConfig)searchPanelExConfig);
            searchPanel.setID(strSearchPanelId);
            page.AddControl((SRFExControl)searchPanel);
            if (!page.IsBackEndMode() && (searchForm = searchPanel.getSearchForm()) != null) {
                searchForm.setOptimizeErrorParam(true);
                searchForm.getLoadAction().setEnabled(true);
                searchForm.getLoadAction().setLoadDefault(true);
                searchForm.getLoadConditionAction().setEnabled(false);
                searchForm.getSaveConditionAction().setEnabled(false);
                searchForm.setErrorIndicator(StringHelper.Format((String)"%1$s_errorindicator", (Object)searchForm.getFormId()));
                searchForm.setLoadingIndicator(StringHelper.Format((String)"%1$s_indicator", (Object)searchForm.getFormId()));
                searchForm.getShowErrorAction().setShowFormItemErrorFunc("SRFForm.showFormItemErrorEx");
                searchForm.getResetErrorAction().setShowFormItemErrorFunc("SRFForm.showFormItemErrorEx");
            }
            if (page.IsBackEndMode()) {
                SRFExSearchForm sRFExSearchForm = searchPanel.getSearchForm();
            }
            return searchPanel;
        }
        page.PageLog((Object)page, 1, StringHelper.Format((String)"\u641c\u7d22\u89c6\u56fe\u914d\u7f6e[%1$s]\u65e0\u6548", (Object)strConfig));
        return null;
    }

    protected static SRFExDataGridRowActionList CreateDataGridRowActionList(SRFDAPage page, String strDataGridRowActionId, int nWidth) {
        SRFExDataGridRowActionList dataGridRowActionList = new SRFExDataGridRowActionList();
        dataGridRowActionList.InitConfig();
        dataGridRowActionList.setID(strDataGridRowActionId);
        if (dataGridRowActionList.getDataGridRowActionListConfig().getWidth() == 0) {
            dataGridRowActionList.getDataGridRowActionListConfig().setWidthEx((double)nWidth);
        }
        page.AddControl((SRFExControl)dataGridRowActionList);
        return dataGridRowActionList;
    }

    protected static SRFExDataGridRowCountList CreateDataGridRowCountList(SRFDAPage page, String strDataGridRowCountId, int nWidth) {
        SRFExDataGridRowCountList dataGridRowCountList = new SRFExDataGridRowCountList();
        dataGridRowCountList.InitConfig();
        dataGridRowCountList.setID(strDataGridRowCountId);
        if (dataGridRowCountList.getDataGridRowCountListConfig().getWidth() == 0) {
            dataGridRowCountList.getDataGridRowCountListConfig().setWidthEx((double)nWidth);
        }
        page.AddControl((SRFExControl)dataGridRowCountList);
        return dataGridRowCountList;
    }

    protected static SRFExDGExRowCountList CreateDGExRowCountList(SRFDAPage page, String strDGExRowCountId, int nWidth) {
        SRFExDGExRowCountList dgExRowCountList = new SRFExDGExRowCountList();
        dgExRowCountList.InitConfig();
        dgExRowCountList.setID(strDGExRowCountId);
        if (dgExRowCountList.getDGExRowCountListConfig().getWidth() == 0) {
            dgExRowCountList.getDGExRowCountListConfig().setWidthEx((double)nWidth);
        }
        page.AddControl((SRFExControl)dgExRowCountList);
        return dgExRowCountList;
    }

    protected static SRFExTabView CreateTabView(SRFDAPage page, String strTabViewId, double nWidth, double nHeight, String strConfig) {
        TabViewConfig tabViewConfig = page.getWebContext().getTabViewMgr().GetTabViewConfig(strConfig);
        if (tabViewConfig != null) {
            return SRFDAPage.CreateTabView(page, strTabViewId, nWidth, nHeight, tabViewConfig);
        }
        page.PageLog((Object)page, 1, StringHelper.Format((String)"\u5206\u9875\u89c6\u56fe\u914d\u7f6e[%1$s]\u65e0\u6548", (Object)strConfig));
        return null;
    }

    protected static SRFExTabView CreateTabView(SRFDAPage page, String strTabViewId, double nWidth, double nHeight, TabViewConfig tabViewConfig) {
        SRFExTabView tabView = new SRFExTabView();
        tabView.setConfig((XMLConfig)tabViewConfig);
        tabView.setID(strTabViewId);
        if (!page.IsBackEndMode()) {
            if (tabView.getTabViewConfig().getWidthEx() == 0.0 && nWidth != 0.0) {
                tabView.getTabViewConfig().setWidthEx(nWidth);
            }
            if (tabView.getTabViewConfig().getHeightEx() == 0.0 && nHeight != 0.0) {
                tabView.getTabViewConfig().setHeightEx(nHeight);
            }
        }
        page.AddControl((SRFExControl)tabView);
        return tabView;
    }

    protected static SRFExTabViewSideBar CreateTabViewSideBar(SRFDAPage page, String strTabViewSideId, double nWidth, double nHeight) {
        SRFExTabViewSideBar tabViewSideBar = new SRFExTabViewSideBar();
        tabViewSideBar.InitConfig();
        tabViewSideBar.setID(strTabViewSideId);
        if (tabViewSideBar.getTabViewSideBarConfig().getWidthEx() == 0.0) {
            tabViewSideBar.getTabViewSideBarConfig().setWidthEx(nWidth);
        }
        if (tabViewSideBar.getTabViewSideBarConfig().getHeightEx() == 0.0) {
            tabViewSideBar.getTabViewSideBarConfig().setHeightEx(nHeight);
        }
        page.AddControl((SRFExControl)tabViewSideBar);
        return tabViewSideBar;
    }

    protected static SRFExDPEx CreateDPEx(SRFDAPage page, String strDPExId, boolean bCreateForm, String strConfig) {
        DPConfig panelConfig = page.getWebContext().GetConfigCache().GetDPConfig(page.getWebContext(), strDPExId, strConfig);
        if (panelConfig == null) {
            page.PageLog((Object)page, 1, StringHelper.Format((String)"\u52a8\u6001\u9762\u677f[%1$s]\u65e0\u6548", (Object)strConfig));
            return null;
        }
        return SRFDAPage.CreateDPEx(page, strDPExId, bCreateForm, panelConfig);
    }

    protected static SRFExDPEx CreateDPEx(SRFDAPage page, String strDPExId, boolean bCreateForm, DPConfig panelConfig) {
        SRFExForm form = null;
        if (bCreateForm) {
            form = new SRFExForm();
            form.setFormId(page.getDefaultFormId());
            page.getForms().AddForm((SRFExBaseForm)form);
        }
        if (panelConfig != null) {
            SRFExDPEx panel = new SRFExDPEx();
            panel.setConfig((XMLConfig)panelConfig);
            panel.setID(strDPExId);
            page.AddControl((SRFExControl)panel);
            if (form != null) {
                form.setMainPanel((SRFExControl)panel);
            }
            if (!page.IsBackEndMode() && form != null) {
                form.setOptimizeErrorParam(true);
                form.setLoadingIndicator(StringHelper.Format((String)"%1$s_indicator", (Object)form.getFormId()));
                form.setErrorIndicator(StringHelper.Format((String)"%1$s_errorindicator", (Object)form.getFormId()));
                form.getShowErrorAction().setShowFormItemErrorFunc(StringHelper.Format((String)"SRFForm.showFormItemErrorEx"));
                form.getResetErrorAction().setShowFormItemErrorFunc(StringHelper.Format((String)"SRFForm.showFormItemErrorEx"));
                form.getShowErrorAction().setAddErrorFunc(StringHelper.Format((String)"$P.object['%1$s'].addFormError", (Object)panel.getUniqueID()));
                form.setIndicatorAction((SRFExFormIndicatorAction)new SRFDAFormIndicatorAction());
                form.getButtonStateAction().setEnabled(false);
                form.getRemoveAction().setEnabled(true);
                form.getRemoveAction().getSuccessAction().RegisterProcessCode(0, "SRFUtility.refreshpdg();window.close();");
                if (page.IsContainPageParam("PAGE.FORM.SAVETIMEOUT")) {
                    int nSaveTimeout = page.getPageParam("PAGE.FORM.SAVETIMEOUT", 30);
                    form.getSaveAction().setTimeout(nSaveTimeout * 1000);
                }
                form.AddFormAction((SRFExBaseFormAction)new SRFExFormCustomCallAction());
            }
            return panel;
        }
        page.PageLog((Object)page, 1, StringHelper.Format((String)"\u52a8\u6001\u9762\u677f\u914d\u7f6e\u65e0\u6548"));
        return null;
    }

    protected static SRFExTreePanel CreateTreePanel(SRFDAPage page, String strTreePanelId, double nWidth, double nHeight, String strConfig) {
        TreePanelConfig treePanelConfig = page.getWebContext().getTreeViewMgr().GetTreePanelConfig(strConfig);
        if (treePanelConfig != null) {
            SRFExTreePanel treePanel = new SRFExTreePanel();
            treePanel.setConfig((XMLConfig)treePanelConfig);
            treePanel.setID(strTreePanelId);
            if (!page.IsBackEndMode()) {
                if (treePanel.getTreePanelConfig().getWidth() == 0 && nWidth != 0.0) {
                    treePanel.getTreePanelConfig().setWidthEx(nWidth);
                }
                if (treePanel.getTreePanelConfig().getHeight() == 0 && nHeight != 0.0) {
                    treePanel.getTreePanelConfig().setHeightEx(nHeight);
                }
            }
            page.AddControl((SRFExControl)treePanel);
            return treePanel;
        }
        page.PageLog((Object)page, 1, StringHelper.Format((String)"\u6811\u89c6\u56fe\u914d\u7f6e[%1$s]\u65e0\u6548", (Object)strConfig));
        return null;
    }

    public String getResourceId() {
        return "";
    }

    protected String GetDefaultPageDataEntityId() {
        return this.getWebContext().getSRFDEID();
    }

    public IDEDataCtrl GetDEDataCtrl() {
        return this.GetDEDataCtrl(this.strPageDataEntityId, false);
    }

    public IDEDataCtrl GetDEDataCtrl(String strDEId) {
        return this.GetDEDataCtrl(strDEId, false);
    }

    public IDEDataCtrl GetDEDataCtrl(String strDEId, boolean bReload) {
        if (this.deDataCtrlMap.containsKey(strDEId) && !bReload) {
            return this.deDataCtrlMap.get(strDEId);
        }
        IDEHelper iDEHelper = this.getDEHelper();
        IDEDataCtrl iDEDataCtrl = null;
        iDEDataCtrl = iDEHelper != null && StringHelper.Compare((String)strDEId, (String)iDEHelper.getId(), (boolean)true) == 0 ? iDEHelper.GetDEDataCtrl(null, (ISRFDAWebContext)this.getWebContext()) : this.getDAModelStorage().FindDEDataCtrl(strDEId, (ISRFDAWebContext)this.getWebContext());
        if (iDEDataCtrl == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
            return null;
        }
        this.deDataCtrlMap.put(strDEId, iDEDataCtrl);
        return iDEDataCtrl;
    }

    public IDEDataCtrl getDEDataCtrl2(String strDEId) throws Exception {
        IDEDataCtrl iDEDataCtrl = this.GetDEDataCtrl(strDEId);
        if (iDEDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
        }
        return iDEDataCtrl;
    }

    public String getPageModel() {
        return this.strPageModel;
    }

    public BaseDataEntity getAdvPageParam(String strCtrlId, String strParamType) {
        return null;
    }

    protected boolean IsOutputPageModel() {
        if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            return false;
        }
        return !this.IsBackEndMode();
    }

    protected String OnGetPageHelpItem() {
        return this.getPageParam("PAGE.HELPITEM", "");
    }

    protected String OnGetPageDataImportMode() {
        return this.getPageParam("PAGE.DATAIMPORT", "");
    }

    public IPageHelper getPageData() {
        return this.OnGetPageData();
    }

    protected IPageHelper OnGetPageData() {
        return null;
    }

    public String getPageType() {
        return this.OnGetPageType();
    }

    protected String OnGetPageType() {
        return "UNKNOWN";
    }

    public final boolean isEnableDAConfigV2(String strConfigType) {
        return this.OnGetEnableDAConfigV2(strConfigType);
    }

    protected boolean OnGetEnableDAConfigV2(String strConfigType) {
        return this.getDEHelper() != null && this.getDEHelper().GetProperty("DACONFIGVER", 1) == 2;
    }

    protected void OutputPreparePageEnvError(String strErrorInfo) {
        this.PageLog((Object)this, 1, strErrorInfo);
        if (this.pageModel != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.pageModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript(this.getPageModel(), strErrorInfo));
                this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
            }
            this.OutputDirect(this.pageModel.toString());
        }
    }
}

