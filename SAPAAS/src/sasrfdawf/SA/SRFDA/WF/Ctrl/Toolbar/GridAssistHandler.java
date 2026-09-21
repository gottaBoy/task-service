/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SRFWF.Ctrl.Data.WFInstance
 */
package SA.SRFDA.WF.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExBaseDataGridTBBHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Ctrl.Data.WFInstance;
import java.util.TreeMap;

public class GridAssistHandler
extends SRFExBaseDataGridTBBHandler {
    protected String OnGetJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, SRFExDataGrid dataGrid) {
        String strDAParams;
        String strWFStepColumnName;
        GridAssistHandler.RegisterDataGridSelecteEvent((ToolbarButtonConfig)config, (SRFExWebContext)webContext, (SRFExDataGrid)dataGrid);
        SRFDAPage daPage = (SRFDAPage)webContext.getPage();
        if (!daPage.IsContainPageParam("WFINSTANCE")) {
            daPage.OutputAlertMsg("\u5bbf\u4e3b\u9875\u9762\u7f3a\u4e4f\u53c2\u6570[WFINSTANCE]", false);
            return "";
        }
        if (!daPage.IsContainPageParam("ACTIVEDATAENTITY")) {
            daPage.OutputAlertMsg("\u5bbf\u4e3b\u9875\u9762\u7f3a\u4e4f\u53c2\u6570[ACTIVEDATAENTITY]", false);
            return "";
        }
        if (!daPage.IsContainPageParam("REALDEHELPER")) {
            daPage.OutputAlertMsg("\u5bbf\u4e3b\u9875\u9762\u7f3a\u4e4f\u53c2\u6570[REALDEHELPER]", false);
            return "";
        }
        WFInstance wfInt = (WFInstance)daPage.getPageParam("WFINSTANCE");
        BaseDataEntity activeDataEntity = (BaseDataEntity)daPage.getPageParam("ACTIVEDATAENTITY");
        IDEHelper iRealDEHelper = (IDEHelper)daPage.getPageParam("REALDEHELPER");
        DEWF dewf = iRealDEHelper.GetDEWF();
        if (dewf == null) {
            daPage.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u5b9e\u4f53\u5bf9\u8c61\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41"));
            return "";
        }
        boolean bShowModal = true;
        int nWidth = 0;
        int nHeight = 0;
        String strURL = "../srfwf/wfinfoview.jsp";
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        String strInfoPageId = iRealDEHelper.GetDEWF().getWFINFOPAGEID();
        if (!StringHelper.IsNullOrEmpty((String)strInfoPageId)) {
            Page editPage = daPage.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strInfoPageId);
            if (editPage == null) {
                daPage.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]", (Object)strInfoPageId));
                return "";
            }
            if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                strURL = editPage.GetTotalPagePath();
            }
            if (editPage.getWIDTH() != 0) {
                nWidth = editPage.getWIDTH();
            }
            if (editPage.getHEIGHT() != 0) {
                nHeight = editPage.getHEIGHT();
            }
            if (!StringHelper.IsNullOrEmpty((String)editPage.getWINDOWSTYLE())) {
                strWindowStyle = editPage.getWINDOWSTYLE();
            }
        }
        if (daPage.getWebContext().getGlobalHelper().getDAModelVersion() >= 11071100) {
            strURL = "../srfwf/wfassistredirectview.jsp";
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", iRealDEHelper.getId());
        daParams.put(iRealDEHelper.GetKeyDEFHelper().getName(), activeDataEntity.GetParamStringValue(iRealDEHelper.GetKeyDEFHelper().getName(), ""));
        String strWFStateColumnName = dewf.getWFSTATEDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
            IDEFHelper iDEFHelper = iRealDEHelper.GetDEFHelper(strWFStateColumnName);
            strWFStateColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStepColumnName = dewf.getWFSTEPDEFID()))) {
            IDEFHelper iDEFHelper = iRealDEHelper.GetDEFHelper(strWFStepColumnName);
            strWFStepColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
        }
        if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
            daParams.put("SRFWFSTATE", activeDataEntity.GetParamStringValue(strWFStateColumnName, ""));
        }
        if (!StringHelper.IsNullOrEmpty((String)strWFStepColumnName)) {
            daParams.put("SRFWFSTEP", activeDataEntity.GetParamStringValue(strWFStepColumnName, ""));
        }
        if (!StringHelper.IsNullOrEmpty((String)(strDAParams = URLHelper.GetQueryString(daParams)))) {
            strURL = String.valueOf(strURL) + strDAParams;
            strURL = String.valueOf(strURL) + "&";
        }
        strURL = String.valueOf(strURL) + daPage.getWebContext().GetQueryStringWithoutDAParam();
        strURL = String.valueOf(strURL) + "&";
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        script.Append("var _URL='%1$s';\r\n", (Object)strURL);
        script.Append("var _1=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
        script.Append("_URL += Ext.urlEncode(_1);\r\n");
        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
        script.Append("}");
        return script.toString();
    }
}

