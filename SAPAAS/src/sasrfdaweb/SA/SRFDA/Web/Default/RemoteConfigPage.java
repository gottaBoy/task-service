/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Ctrl.Data.DER11
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.List
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Ctrl.Data.WebPart
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  SA.SRFramework.Zip.ZipNullOutputStream
 *  com.jspsmart.upload.SmartUpload
 *  com.jspsmart.upload.SmartUploadException
 *  javax.servlet.ServletException
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.List;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.Data.WebPart;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.UI.DataFilterConfigStorage;
import SA.SRFDA.Web.UI.DataFilterConfigStorageFactory;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import SA.SRFramework.Zip.ZipNullOutputStream;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RemoteConfigPage
extends SRFDAPage {
    public static final String TAG_FOLDER_MENU = "MENU";
    public static final String TAG_FOLDER_MENU2 = "MENU2";
    public static final String TAG_FOLDER_TOOLBAR = "TOOLBAR";
    public static final String TAG_FOLDER_SPEX = "SPEX";
    public static final String TAG_FOLDER_DPEX = "DPEX";
    public static final String TAG_FOLDER_CODELIST = "CODELIST";
    public static final String TAG_FOLDER_DATAGRID = "DATAGRID";
    public static final String TAG_FOLDER_DGEX = "DGEX";
    public static final String TAG_FOLDER_TABVIEW = "TABVIEW";
    public static final String TAG_FOLDER_TREEVIEW = "TREEVIEW";
    public static final String TAG_FOLDER_GRIDVIEWTOOLBAR = "GRIDVIEWTOOLBAR";
    public static final String TAG_FOLDER_GRIDVIEWSPEX = "GRIDVIEWSPEX";
    public static final String TAG_FOLDER_DATAFILTER = "DATAFILTER";
    public static final String TAG_FOLDER_DAMODEL_USERDEDATAGRID = "DAMODEL:USERDEDATAGRID";
    public static final String TAG_FOLDER_DAMODEL_USERDEDATAGRIDS = "DAMODEL:USERDEDATAGRIDS";
    public static final String TAG_FOLDER_DAMODEL_PAGE = "DAMODEL:PAGE";
    public static final String TAG_FOLDER_DAMODEL_DATAGRID = "DAMODEL:DATAGRID";
    public static final String TAG_FOLDER_DAMODEL_DATAENTITY = "DAMODEL:DATAENTITY";
    public static final String TAG_FOLDER_DAMODEL_WEBPART = "DAMODEL:WEBPART";
    public static final String TAG_FOLDER_DAMODEL_CHART = "DAMODEL:CHART";
    public static final String TAG_FOLDER_DAMODEL_LIST = "DAMODEL:LIST";
    public static final String TAG_FOLDER_DAMODEL_DEDATA = "DAMODEL:DEDATA";
    protected boolean bDownloadFile = true;

    public RemoteConfigPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnLoad() {
        String strConfigPath = "";
        String strFolder = this.getWebContext().GetParamValue("FOLDER");
        String strItem = this.getWebContext().GetParamValue("ITEM");
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_MENU, (boolean)true) == 0) {
            String strMenuMode = strItem;
            if (StringHelper.IsNullOrEmpty((String)strMenuMode)) {
                strMenuMode = "DEFAULT";
            }
            if (!StringHelper.IsNullOrEmpty((String)(strConfigPath = this.getDAConfigHelper().GetRIAMainMenuExConfigPath(this.getWebContext(), strMenuMode)))) {
                strConfigPath = this.RebuildMenuConfig(strConfigPath);
                this.SendBackToClient(strConfigPath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u83dc\u5355\u6a21\u5f0f[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strMenuMode));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_MENU2, (boolean)true) == 0) {
            String strMenuConfigId = strItem;
            String strMenuFilePath = ConfigPathHelper.GetRuntimeMainMenuConfigPath((String)this.getWebContext().getGlobalHelper().GetAppRootPath(), (String)strMenuConfigId);
            if (!StringHelper.IsNullOrEmpty((String)strMenuFilePath)) {
                this.SendBackToClient(strMenuFilePath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u83dc\u5355\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strMenuConfigId));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_TOOLBAR, (boolean)true) == 0) {
            String strToolbarConfigId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strToolbarConfigId)) {
                return;
            }
            strConfigPath = this.getWebContext().getToolbarMgr().GetRealConfigFilePath(strToolbarConfigId);
            if (!StringHelper.IsNullOrEmpty((String)(strConfigPath = this.RebuildConfig(TAG_FOLDER_TOOLBAR, strToolbarConfigId, strConfigPath, false)))) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5de5\u5177\u680f\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strToolbarConfigId));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_SPEX, (boolean)true) == 0) {
            String strSPExConfigId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strSPExConfigId)) {
                return;
            }
            strConfigPath = this.getWebContext().getSearchPanelMgr().GetRealConfigFilePath(strSPExConfigId);
            if (!StringHelper.IsNullOrEmpty((String)(strConfigPath = this.RebuildConfig(TAG_FOLDER_SPEX, strSPExConfigId, strConfigPath, false)))) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u641c\u7d22\u9762\u677f\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strSPExConfigId));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DPEX, (boolean)true) == 0) {
            String strDPExConfigId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strDPExConfigId)) {
                return;
            }
            strConfigPath = this.getWebContext().getDynamicPanelMgr().GetRealConfigFilePath(strDPExConfigId);
            if (!StringHelper.IsNullOrEmpty((String)(strConfigPath = this.RebuildConfig(TAG_FOLDER_DPEX, strDPExConfigId, strConfigPath, false)))) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u9762\u677f\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strDPExConfigId));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DATAGRID, (boolean)true) == 0) {
            String strDGConfigId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strDGConfigId)) {
                return;
            }
            strConfigPath = this.getWebContext().getDataGridMgr().GetRealConfigFilePath(strDGConfigId);
            if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u8868\u683c\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strDGConfigId));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DGEX, (boolean)true) == 0) {
            String strDGExConfigId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strDGExConfigId)) {
                return;
            }
            strConfigPath = this.getWebContext().getDataGridMgr().GetRealConfigFilePath(strDGExConfigId);
            if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u590d\u5408\u6570\u636e\u8868\u683c\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strDGExConfigId));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_TABVIEW, (boolean)true) == 0) {
            String strTabViewConfigId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strTabViewConfigId)) {
                return;
            }
            strConfigPath = this.getWebContext().getTabViewMgr().GetRealConfigFilePath(strTabViewConfigId);
            if (!StringHelper.IsNullOrEmpty((String)(strConfigPath = this.RebuildConfig(TAG_FOLDER_TABVIEW, strTabViewConfigId, strConfigPath, true)))) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u9875\u89c6\u56fe\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strTabViewConfigId));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_TREEVIEW, (boolean)true) == 0) {
            String strTreeViewConfigId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strTreeViewConfigId)) {
                return;
            }
            strConfigPath = this.getWebContext().getTreeViewMgr().GetRealConfigFilePath(strTreeViewConfigId);
            if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u89c6\u56fe\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strTreeViewConfigId));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DATAFILTER, (boolean)true) == 0) {
            String strDataFilterConfigId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strDataFilterConfigId)) {
                return;
            }
            try {
                strConfigPath = ((DataFilterConfigStorage)DataFilterConfigStorageFactory.getCurrent().GetConfigStorage((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper())).GetRealConfigFilePath(strDataFilterConfigId);
                if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                    strConfigPath = this.RebuildConfig(TAG_FOLDER_DATAFILTER, strDataFilterConfigId, strConfigPath, true);
                    this.SendBackToClient(strConfigPath);
                    return;
                }
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8fc7\u6ee4\u5668\u89c6\u56fe\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84", (Object)strDataFilterConfigId));
            }
            catch (Exception e) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u8fc7\u6ee4\u5668\u89c6\u56fe\u914d\u7f6e[%1$s]\u7684\u5b9e\u9645\u8def\u5f84\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strDataFilterConfigId, (Object)e.getMessage()), e);
            }
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_CODELIST, (boolean)true) == 0) {
            String strCodeListId = strItem;
            if (StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                return;
            }
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeListId);
            if (codeListConfig == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", (Object)strCodeListId));
                return;
            }
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter simpleXMLWriter = new SimpleXMLWriter(sb);
            simpleXMLWriter.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            codeListConfig.Save(simpleXMLWriter);
            this.bDownloadFile = false;
            this.Output(sb.toString());
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_GRIDVIEWTOOLBAR, (boolean)true) == 0) {
            boolean bInfoMode;
            String strDEId = this.getWebContext().getSRFDEID();
            String strPageId = this.getWebContext().getSRFPageId();
            String strGridViewId = this.getWebContext().getSRFGridView();
            boolean bPickupMode = StringHelper.Compare((String)this.getWebContext().GetParamValue("PICKUPMODE"), (String)"TRUE", (boolean)true) == 0;
            boolean bIFView = StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFIFVIEW"), (String)"TRUE", (boolean)true) == 0;
            boolean bEnableDGEdit = StringHelper.Compare((String)this.getWebContext().GetParamValue("ENABLEDGEDIT"), (String)"TRUE", (boolean)true) == 0;
            boolean bl = bInfoMode = StringHelper.Compare((String)this.getWebContext().GetParamValue("INFOMODE"), (String)"TRUE", (boolean)true) == 0;
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                return;
            }
            Page page = null;
            IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(strDEId);
            if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                page = new Page();
                CallResult callResult = this.getDAModelHelper().GetPage(strPageId, page);
                if (callResult.IsError()) {
                    return;
                }
            }
            DataGrid gridView = null;
            if (!StringHelper.IsNullOrEmpty((String)strGridViewId)) {
                gridView = new DataGrid();
                CallResult callResult = this.getDAModelHelper().GetUserDEDataGrid(strGridViewId, this.getWebContext().getCurUserId(), gridView);
                if (callResult.IsError()) {
                    return;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)(strConfigPath = this.getDAConfigHelper().GetRIAGridViewToolbarConfigPath(iDEHelper, page, gridView, bPickupMode, bIFView, bEnableDGEdit, bInfoMode, null)))) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_GRIDVIEWSPEX, (boolean)true) == 0) {
            String strSPExConfigId;
            String strDEId = this.getWebContext().getSRFDEID();
            String strPageId = this.getWebContext().getSRFPageId();
            String strGridViewId = this.getWebContext().getSRFGridView();
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                return;
            }
            Page page = null;
            IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(strDEId);
            if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
                page = new Page();
                CallResult callResult = this.getDAModelHelper().GetPage(strPageId, page);
                if (callResult.IsError()) {
                    return;
                }
            }
            DataGrid gridView = null;
            if (!StringHelper.IsNullOrEmpty((String)strGridViewId)) {
                gridView = new DataGrid();
                CallResult callResult = this.getDAModelHelper().GetUserDEDataGrid(strGridViewId, this.getWebContext().getCurUserId(), gridView);
                if (callResult.IsError()) {
                    return;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)(strSPExConfigId = this.getPageParam("PAGE.SP", "")))) {
                strConfigPath = this.getWebContext().getSearchPanelMgr().GetRealConfigPath(strSPExConfigId);
                if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                    this.SendBackToClient(strConfigPath);
                }
                return;
            }
            boolean bDefaultSF = false;
            String strSearchformId = this.getPageParam("PAGE.SEARCHFORM", "");
            if (StringHelper.IsNullOrEmpty((String)strSearchformId) && this.getWebContext().getWebExConfig().GetValue("SRFDA", "DEFAULTSEARCHFORM", false)) {
                bDefaultSF = true;
                strSearchformId = StringHelper.Format((String)"%1$s_DEFAULTSF", (Object)iDEHelper.getId());
            }
            if (!StringHelper.IsNullOrEmpty((String)strSearchformId)) {
                SearchForm searchForm = new SearchForm();
                CallResult callResult = this.getDAModelHelper().GetDESearchForm(strSearchformId, searchForm);
                if (callResult.IsError()) {
                    if (callResult.getRetCode() == 3 && bDefaultSF) {
                        strConfigPath = this.getDAConfigHelper().GetRIAGridViewSPExConfigPath(iDEHelper, gridView);
                        if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                            this.SendBackToClient(strConfigPath);
                        }
                        return;
                    }
                    this.PageLog((Object)this, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u641c\u7d22\u8868\u5355[%1$s]", (Object)strSearchformId), callResult);
                    return;
                }
                strConfigPath = this.getDAConfigHelper().GetRIASPExConfigPath(iDEHelper, searchForm);
                if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                    this.SendBackToClient(strConfigPath);
                }
                return;
            }
            strConfigPath = this.getDAConfigHelper().GetRIAGridViewSPExConfigPath(iDEHelper, gridView);
            if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                this.SendBackToClient(strConfigPath);
                return;
            }
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DAMODEL_USERDEDATAGRID, (boolean)true) == 0) {
            String strGridViewId = this.getWebContext().getSRFGridView();
            boolean bPickupMode = StringHelper.Compare((String)this.getWebContext().GetParamValue("PICKUPMODE"), (String)"TRUE", (boolean)true) == 0;
            String strDGMode = this.getWebContext().GetParamValue("DGMODE");
            String strDEId = this.getWebContext().getSRFDEID();
            DataGrid gridView = null;
            if (!StringHelper.IsNullOrEmpty((String)strGridViewId)) {
                gridView = new DataGrid();
                CallResult callResult = this.getDAModelHelper().GetUserDEDataGrid(strGridViewId, this.getWebContext().getCurUserId(), gridView);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u8868\u683c\u89c6\u56fe[%1$s]\u5931\u8d25", (Object)strGridViewId), callResult);
                    return;
                }
            } else if (bPickupMode) {
                CallResult callResult = this.getDAModelHelper().GetDefaultPickupDEDataGrid(strDEId, gridView, "DEFAULT");
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u62fe\u53d6\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                    return;
                }
            } else {
                Vector list = new Vector();
                CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserDEDataGrids(this.getWebContext().getCurUserId(), strDEId, strDGMode, list);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u9ed8\u8ba4\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                    return;
                }
                Iterator iterator = list.iterator();
                if (iterator.hasNext()) {
                    DataGrid dataGrid;
                    gridView = dataGrid = (DataGrid)iterator.next();
                }
                if (gridView == null) {
                    this.PageLog((Object)this, "\u6ca1\u6709\u83b7\u53d6\u5230\u7b26\u5408\u8981\u6c42\u7684\u6570\u636e\u8868\u683c", callResult);
                    return;
                }
            }
            this.SendBackToClient(this.DataEntity2XMLNode((BaseDataEntity)gridView));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DAMODEL_USERDEDATAGRIDS, (boolean)true) == 0) {
            String strDGMode = this.getWebContext().GetParamValue("DGMODE");
            String strDEId = this.getWebContext().getSRFDEID();
            Vector list = new Vector();
            CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserDEDataGrids(this.getWebContext().getCurUserId(), strDEId, strDGMode, list);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u9ed8\u8ba4\u8868\u683c\u89c6\u56fe\u5931\u8d25", callResult);
                return;
            }
            this.SendBackToClient(this.DataEntities2XMLNode(list));
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DAMODEL_DATAENTITY, (boolean)true) == 0) {
            JSONObject jsonObject;
            String strDEId = this.getWebContext().getSRFDEID();
            IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                return;
            }
            JSONObject deJsonObject = new JSONObject();
            iDEHelper.getDataEntity().FillJSONObject(deJsonObject, false);
            Vector<JSONObject> defJsonObjects = new Vector<JSONObject>();
            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                JSONObject defJsonObject = new JSONObject();
                iDEFHelper.getDEField().FillJSONObject(defJsonObject, false);
                defJsonObjects.add(defJsonObject);
            }
            if (defJsonObjects.size() > 0) {
                deJsonObject.put("defields", (Object)JSONArray.fromArray((Object[])defJsonObjects.toArray()));
            }
            Vector<JSONObject> jsonObjects = new Vector<JSONObject>();
            for (DER11 der11 : iDEHelper.GetDER11s(true)) {
                jsonObject = new JSONObject();
                der11.FillJSONObject(jsonObject, false);
                jsonObjects.add(jsonObject);
            }
            if (jsonObjects.size() > 0) {
                deJsonObject.put("der11s", (Object)JSONArray.fromArray((Object[])jsonObjects.toArray()));
            }
            jsonObjects = new Vector();
            for (DER1N der1N : iDEHelper.GetDER1Ns(true)) {
                jsonObject = new JSONObject();
                der1N.FillJSONObject(jsonObject, false);
                jsonObjects.add(jsonObject);
            }
            if (jsonObjects.size() > 0) {
                deJsonObject.put("der1ns", (Object)JSONArray.fromArray((Object[])jsonObjects.toArray()));
            }
            jsonObjects = new Vector();
            for (DER1N der1N : iDEHelper.GetDER1Ns(false)) {
                jsonObject = new JSONObject();
                der1N.FillJSONObject(jsonObject, false);
                jsonObjects.add(jsonObject);
            }
            if (jsonObjects.size() > 0) {
                deJsonObject.put("der1ns2", (Object)JSONArray.fromArray((Object[])jsonObjects.toArray()));
            }
            jsonObjects = new Vector();
            for (DERINDEX derINDEX : iDEHelper.GetDERINDEXs(true)) {
                jsonObject = new JSONObject();
                derINDEX.FillJSONObject(jsonObject, false);
                jsonObjects.add(jsonObject);
            }
            if (jsonObjects.size() > 0) {
                deJsonObject.put("derindexs", (Object)JSONArray.fromArray((Object[])jsonObjects.toArray()));
            }
            jsonObjects = new Vector();
            for (DERINDEX derINDEX : iDEHelper.GetDERINDEXs(false)) {
                jsonObject = new JSONObject();
                derINDEX.FillJSONObject(jsonObject, false);
                jsonObjects.add(jsonObject);
            }
            if (jsonObjects.size() > 0) {
                deJsonObject.put("derindexs2", (Object)JSONArray.fromArray((Object[])jsonObjects.toArray()));
            }
            String strOutput = deJsonObject.toString();
            this.bDownloadFile = false;
            this.Output(strOutput);
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DAMODEL_PAGE, (boolean)true) == 0) {
            Page page = new Page();
            CallResult callResult = this.getDAModelHelper().GetPage(strItem, page);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u9875\u9762[%1$s]\u5931\u8d25", (Object)strItem), callResult);
                return;
            }
            this.bDownloadFile = false;
            JSONObject jsonObject = new JSONObject();
            page.FillJSONObject(jsonObject);
            this.Output(jsonObject.toString());
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DAMODEL_WEBPART, (boolean)true) == 0) {
            WebPart webPart = new WebPart();
            CallResult callResult = this.getDAModelHelper().GetWebPart(strItem, webPart);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7f51\u9875\u90e8\u4ef6[%1$s]\u5931\u8d25", (Object)strItem), callResult);
                return;
            }
            this.bDownloadFile = false;
            JSONObject jsonObject = new JSONObject();
            webPart.FillJSONObject(jsonObject);
            this.Output(jsonObject.toString());
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DAMODEL_CHART, (boolean)true) == 0) {
            Chart chart = new Chart();
            CallResult callResult = this.getDAModelHelper().GetChart(strItem, chart);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u56fe\u5f62\u90e8\u4ef6[%1$s]\u5931\u8d25", (Object)strItem), callResult);
                return;
            }
            this.bDownloadFile = false;
            JSONObject jsonObject = new JSONObject();
            chart.FillJSONObject(jsonObject);
            this.Output(jsonObject.toString());
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_DAMODEL_LIST, (boolean)true) == 0) {
            List list = new List();
            CallResult callResult = this.getDAModelHelper().GetList(strItem, list);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5217\u8868\u90e8\u4ef6[%1$s]\u5931\u8d25", (Object)strItem), callResult);
                return;
            }
            list.RemoveParam("GROUPMODEL");
            this.bDownloadFile = false;
            JSONObject jsonObject = new JSONObject();
            list.FillJSONObject(jsonObject);
            this.Output(jsonObject.toString());
            return;
        }
        if (strFolder.indexOf(TAG_FOLDER_DAMODEL_DEDATA) == 0) {
            String[] parts = strFolder.split("[:]");
            if (parts.length != 3) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53\u6570\u636e\u6307\u4ee4[%1$s]\u65e0\u6548", (Object)strFolder));
                return;
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            IDEDataCtrl iDataCtrl = this.GetDEDataCtrl(parts[2]);
            if (iDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)parts[2]));
                return;
            }
            dataEntity.SetParamValue(iDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), iDataCtrl.GetDEHelper().GetKeyDEFHelper().GetDEFValue(strItem));
            CallResult callResult = iDataCtrl.Get(dataEntity);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u5931\u8d25\uff0c%3$s", (Object)parts[2], (Object)strItem, (Object)callResult.getErrorInfo()));
                return;
            }
            this.bDownloadFile = false;
            JSONObject jsonObject = new JSONObject();
            dataEntity.FillJSONObject(jsonObject);
            this.Output(jsonObject.toString());
            return;
        }
    }

    protected String DataEntity2XMLNode(BaseDataEntity baseDataEntity) {
        String strTempId = Helper.GenGuidEx();
        String strTempFilePath = StringHelper.Format((String)"%1$s%2$s.xml", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId);
        String strValue = BaseDataEntity.ToString((BaseDataEntity)baseDataEntity);
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return null;
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFDAXMLEXPORTS");
        XMLNode xmlNode = new XMLNode();
        xmlNode.setNodeName("SRFDAXMLEXPORT");
        xmlNode.SetValue("SRFVALUE", strValue);
        rootNode.AddNode(xmlNode);
        XMLNode.WriteToFile((XMLNode)rootNode, (String)strTempFilePath);
        return strTempFilePath;
    }

    protected String DataEntities2XMLNode(Vector list) {
        String strTempId = Helper.GenGuidEx();
        String strTempFilePath = StringHelper.Format((String)"%1$s%2$s.xml", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId);
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFDAXMLEXPORTS");
        for (Object objDataEntity : list) {
            BaseDataEntity baseDataEntity = (BaseDataEntity)objDataEntity;
            String strValue = BaseDataEntity.ToString((BaseDataEntity)baseDataEntity);
            XMLNode xmlNode = new XMLNode();
            xmlNode.setNodeName("SRFDAXMLEXPORT");
            xmlNode.SetValue("SRFVALUE", strValue);
            rootNode.AddNode(xmlNode);
        }
        XMLNode.WriteToFile((XMLNode)rootNode, (String)strTempFilePath);
        return strTempFilePath;
    }

    protected void SendBackToClient(String strConfigPath) {
        try {
            String strZipFile = String.valueOf(strConfigPath) + ".zip";
            File file = new File(strZipFile);
            if (!file.exists()) {
                Date date = new Date();
                this.CreateZipFile(strConfigPath, strZipFile);
                Date date2 = new Date();
                this.PageLog((Object)this, 0, StringHelper.Format((String)"\u538b\u7f29\u6587\u4ef6[%1$s]\u8017\u65f6[%2$s]ms", (Object)strConfigPath, (Object)(date2.getTime() - date.getTime())));
            }
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.downloadFile(strZipFile);
        }
        catch (ServletException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (SmartUploadException e) {
            e.printStackTrace();
        }
    }

    protected boolean CreateZipFile(String strInputFile, String strOutputFile) {
        try {
            FileInputStream in = new FileInputStream(strInputFile);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] tmpbuf = new byte[1024];
            int count = 0;
            while ((count = in.read(tmpbuf)) != -1) {
                bout.write(tmpbuf, 0, count);
                tmpbuf = new byte[1024];
            }
            in.close();
            byte[] orgData = bout.toByteArray();
            OutputStream baos = RemoteConfigPage.CreateZipStream(new FileOutputStream(strOutputFile), orgData, "config.xml", true, 9);
            if (baos != null) {
                baos.close();
                return true;
            }
            return false;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static OutputStream CreateZipStream(OutputStream outputStream, byte[] content, String fileName, boolean needCompress, int compressionLevel) throws IOException {
        ZipEntry zipEntry = new ZipEntry(fileName);
        if (needCompress) {
            ZipNullOutputStream baos = new ZipNullOutputStream();
            ZipOutputStream zipOut = new ZipOutputStream((OutputStream)baos);
            zipOut.setMethod(needCompress ? 8 : 0);
            zipOut.setLevel(compressionLevel);
            zipOut.putNextEntry(zipEntry);
            zipOut.write(content);
            zipOut.closeEntry();
            zipOut.finish();
            zipOut.close();
        } else {
            CRC32 crc = new CRC32();
            crc.update(content);
            zipEntry.setCrc(crc.getValue());
            zipEntry.setCompressedSize(content.length);
            zipEntry.setSize(content.length);
        }
        ZipOutputStream zipOut = new ZipOutputStream(outputStream);
        zipOut.setMethod(needCompress ? 8 : 0);
        zipOut.setLevel(compressionLevel);
        zipOut.putNextEntry(zipEntry);
        zipOut.write(content);
        zipOut.closeEntry();
        zipOut.finish();
        zipOut.close();
        return outputStream;
    }

    protected String RebuildConfig(String strConfigType, String strConfigId, String strConfigPath, boolean bRemove) {
        String strTempFilePath;
        File file;
        String strTimeFolder = StringHelper.Format((String)"%1$tY%1$tm%1$td", (Object)new Date(), (Object)Character.valueOf(File.separatorChar));
        String strFolder = StringHelper.Format((String)"%1$sRC%2$s%3$s%4$s%5$s%4$s%6$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)Character.valueOf(File.separatorChar), (Object)strTimeFolder, (Object)Character.valueOf(File.separatorChar), (Object)RemoteConfigPage.GetPersonIdHashString(this.getWebContext().getCurUserId()), (Object)this.getWebContext().getSessionId());
        File file2 = new File(strFolder);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if ((file = new File(strTempFilePath = StringHelper.Format((String)"%1$s%2$s%3$s_%4$s.xml", (Object)strFolder, (Object)Character.valueOf(File.separatorChar), (Object)strConfigType, (Object)strConfigId))).exists()) {
            return strTempFilePath;
        }
        XMLNode xmlNode = XMLNode.Load((String)strConfigPath);
        if (xmlNode == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u8f7d\u5165\u914d\u7f6e\u6587\u4ef6[%1$s]\u5931\u8d25", (Object)strConfigPath));
            return "";
        }
        this.RemoveNoPrivConfigNode(xmlNode, bRemove);
        this.RemoveNoPrivConfigNode2(xmlNode, bRemove);
        XMLNode.WriteToFile((XMLNode)xmlNode, (String)strTempFilePath);
        return strTempFilePath;
    }

    protected String RebuildMenuConfig(String strConfigPath) {
        XMLNode xmlNode = XMLNode.Load((String)strConfigPath);
        if (xmlNode == null) {
            return "";
        }
        this.RemoveNoPrivMenuNode(xmlNode);
        String strTimeFolder = StringHelper.Format((String)"%1$tY%1$tm%1$td", (Object)new Date(), (Object)Character.valueOf(File.separatorChar));
        String strFolder = StringHelper.Format((String)"%1$sRC%2$s%3$s%4$s%5$s%4$s%6$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)Character.valueOf(File.separatorChar), (Object)strTimeFolder, (Object)Character.valueOf(File.separatorChar), (Object)RemoteConfigPage.GetPersonIdHashString(this.getWebContext().getCurUserId()), (Object)this.getWebContext().getSessionId());
        strFolder = String.valueOf(strFolder) + File.separator;
        File file2 = new File(strFolder);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String strTempId = Helper.GenGuidEx();
        String strTempFilePath = StringHelper.Format((String)"%1$sMENU_%2$s.xml", (Object)strFolder, (Object)strTempId);
        XMLNode.WriteToFile((XMLNode)xmlNode, (String)strTempFilePath);
        return strTempFilePath;
    }

    protected void RemoveNoPrivMenuNode(XMLNode xmlNode) {
        ArrayList<XMLNode> childs;
        String strResourceId = xmlNode.GetExtValue("RESOURCEID", "");
        if (!StringHelper.IsNullOrEmpty((String)strResourceId)) {
            if (!this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), strResourceId)) {
                xmlNode.getParentNode().RemoveNode(xmlNode);
                return;
            }
            xmlNode.SetValue("RESOURCEID", "SRFVALID");
        }
        if ((childs = xmlNode.getChildNodes()) == null) {
            return;
        }
        Vector<XMLNode> dupChilds = new Vector<XMLNode>();
        for (XMLNode childNode : childs) {
            dupChilds.add(childNode);
        }
        for (XMLNode childNode : dupChilds) {
            this.RemoveNoPrivMenuNode(childNode);
        }
    }

    protected boolean RemoveNoPrivConfigNode(XMLNode xmlNode, boolean bRemove) {
        ArrayList<XMLNode> childs;
        String strResourceId = xmlNode.GetExtValue("RESOURCEID", "");
        if (!StringHelper.IsNullOrEmpty((String)strResourceId)) {
            if (!this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), strResourceId)) {
                if (bRemove) {
                    xmlNode.getParentNode().RemoveNode(xmlNode);
                    return false;
                }
                xmlNode.SetValue("RESOURCEID", "SRFINVALID");
                return false;
            }
            xmlNode.SetValue("RESOURCEID", "SRFVALID");
        }
        if ((childs = xmlNode.getChildNodes()) == null) {
            return true;
        }
        Vector<XMLNode> dupChilds = new Vector<XMLNode>();
        for (XMLNode childNode : childs) {
            dupChilds.add(childNode);
        }
        int nRemoveCount = 0;
        for (XMLNode childNode : dupChilds) {
            if (this.RemoveNoPrivConfigNode(childNode, bRemove)) continue;
            ++nRemoveCount;
        }
        if (nRemoveCount == dupChilds.size() && StringHelper.IsNullOrEmpty((String)strResourceId)) {
            xmlNode.SetValue("RESOURCEID", "SRFINVALID");
            return false;
        }
        return true;
    }

    protected boolean RemoveNoPrivConfigNode2(XMLNode xmlNode, boolean bRemove) {
        ArrayList<XMLNode> childs;
        String strPrivilegeId = xmlNode.GetExtValue("PRIVILEGEID", "");
        if (!StringHelper.IsNullOrEmpty((String)strPrivilegeId)) {
            if ((this.getWebContext().GetUserPrivilegeMgr().TestColumn((ISRFExWebContext)this.getWebContext(), strPrivilegeId) & 1) == 0) {
                if (bRemove) {
                    xmlNode.getParentNode().RemoveNode(xmlNode);
                    return false;
                }
                xmlNode.SetValue("PRIVILEGEID", "SRFINVALID");
                return false;
            }
            xmlNode.SetValue("PRIVILEGEID", "SRFVALID");
        }
        if ((childs = xmlNode.getChildNodes()) == null) {
            return true;
        }
        Vector<XMLNode> dupChilds = new Vector<XMLNode>();
        for (XMLNode childNode : childs) {
            dupChilds.add(childNode);
        }
        int nRemoveCount = 0;
        for (XMLNode childNode : dupChilds) {
            if (this.RemoveNoPrivConfigNode2(childNode, bRemove)) continue;
            ++nRemoveCount;
        }
        if (nRemoveCount == dupChilds.size() && StringHelper.IsNullOrEmpty((String)strPrivilegeId)) {
            xmlNode.SetValue("PRIVILEGEID", "SRFINVALID");
            return false;
        }
        return true;
    }

    public boolean isDownloadFile() {
        return this.bDownloadFile;
    }

    private static String GetPersonIdHashString(String strPersonId) {
        if (strPersonId == null) {
            return "NULL";
        }
        int nCode = strPersonId.hashCode();
        return StringHelper.Format((String)"%1$s%2$s", (Object)(nCode >= 0 ? "A" : "B"), (Object)Math.abs(nCode));
    }
}
