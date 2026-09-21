/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DAConfigHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.DataGrid.SimpleDADataGridActionHelper;
import SA.SRFDA.Ctrl.Toolbar.DialogCancelHandler;
import SA.SRFDA.Ctrl.Toolbar.DialogOkHandler;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarItemsConfig;
import SA.SRFramework.XML.XMLNode;
import java.io.File;

public class CommonSelectPage
extends SRFDAPageEx {
    protected SRFExToolbar toolbar = null;
    protected SRFExDataGrid selectDataGrid = null;
    protected SRFExDataGrid totalDataGrid = null;
    protected SRFExButton selectButton = null;
    protected SRFExButton selectAllButton = null;
    protected SRFExButton cancelButton = null;
    protected SRFExButton cancelAllButton = null;
    public static final String TAG_TOTALDGTITLE = "PAGE.TOTALDGTITLE";
    public static final String TAG_SELECTDGTITLE = "PAGE.SELECTDGTITLE";
    public static final String TAG_DGCOLUMNNAME = "PAGE.DATAGRID.COLUMNNAME";
    public static final String TAG_DGPAGINGBAR = "PAGE.DATAGRID.PAGINGBAR";
    public static final String TAG_DGPAGINGSIZE = "PAGE.DATAGRID.PAGINGSIZE";
    public static final String TAG_DGCOLUMNFORMAT = "PAGE.DATAGRID.COLUMNFORMAT";
    public static final String TAG_DGCOLUMNFIELD = "PAGE.DATAGRID.COLUMNFIELD";
    public static final String TAG_DGKEYCOLUMN = "PAGE.DATAGRID.KEYCOLUMN";

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        return this.LoadPageDataEntity();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
        this.LoadButtons();
        this.LoadSelectDataGrid();
        this.LoadTotalDataGrid();
    }

    protected void LoadToolbar() {
        String strToolbarConfigId = CommonSelectPage.GetToolbarConfigId(this.getWebContext(), this.page);
        if (StringHelper.IsNullOrEmpty((String)strToolbarConfigId)) {
            return;
        }
        this.toolbar = CommonSelectPage.CreateToolbar(this, "toolBar", 0.0, 0.0, strToolbarConfigId);
    }

    public String GetTotalDGTitle() {
        return this.getPageParam(TAG_TOTALDGTITLE, "\u5168\u90e8\u6570\u636e");
    }

    public String GetSelectDGTitle() {
        return this.getPageParam(TAG_SELECTDGTITLE, "\u9009\u62e9\u6570\u636e");
    }

    private static String GetToolbarConfigId(SRFDAWebContext webContext, Page page) {
        XMLNode tbItemNode;
        String strToolbarConfigId = StringHelper.Format((String)"PAGE_%1$s.TB_%2$s", (Object)page.getPAGEID(), (Object)page.getVERSION());
        strToolbarConfigId = strToolbarConfigId.toUpperCase();
        String strTBFilePath = ConfigPathHelper.GetRuntimeToolbarConfigPath((String)webContext.GetAppRootPath(), (String)strToolbarConfigId);
        File file = new File(strTBFilePath);
        if (file.exists()) {
            return strToolbarConfigId;
        }
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXTOOLBAR");
        XMLNode tbItemsNode = new XMLNode();
        tbItemsNode.setNodeName(ToolbarItemsConfig.TAG_TOOLBARITEMS);
        rootNode.AddNode(tbItemsNode);
        XMLNode userToolbar = null;
        String strToolbarXML = page.getTOOLBAR();
        if (!StringHelper.IsNullOrEmpty((String)strToolbarXML)) {
            userToolbar = XMLNode.LoadFromXML((String)strToolbarXML);
        }
        boolean bOkButton = true;
        boolean bCancelButton = true;
        boolean bOtherAction = false;
        if (userToolbar != null) {
            bOkButton = userToolbar.GetExtValue("OKACTION", bOkButton);
            bCancelButton = userToolbar.GetExtValue("CANCELACTION", bCancelButton);
            bOtherAction = userToolbar.GetExtValue("OTHERACTION", bOtherAction);
        }
        if (bOkButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-ok");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u786e\u5b9a");
            tbItemNode.SetValue("TIPS", "\u786e\u5b9a\u5f53\u524d\u64cd\u4f5c\u5e76\u5173\u95ed\u7a97\u53e3");
            tbItemNode.SetValue("HANDLER", DialogOkHandler.class.getName());
        }
        if (bCancelButton) {
            tbItemNode = new XMLNode();
            tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
            tbItemsNode.AddNode(tbItemNode);
            tbItemNode.SetValue("ICONCSSCLASS", "sx-tb-cancel");
            tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, "\u53d6\u6d88");
            tbItemNode.SetValue("TIPS", "\u5173\u95ed\u7a97\u53e3");
            tbItemNode.SetValue("HANDLER", DialogCancelHandler.class.getName());
        }
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strTBFilePath)) {
            return "";
        }
        return strToolbarConfigId;
    }

    public String GetKeyName() {
        String strKeyColumn = this.getPageParam(TAG_DGKEYCOLUMN, "");
        if (StringHelper.IsNullOrEmpty((String)strKeyColumn)) {
            return this.getDEHelper().GetKeyDEFHelper().getName();
        }
        IDEFHelper iDEFHelper = this.iDEHelper.GetDEFHelper(strKeyColumn);
        if (iDEFHelper != null) {
            return iDEFHelper.getName();
        }
        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKeyColumn));
        return "";
    }

    public String GetDGConfigId() {
        String strDataGridConfigId = StringHelper.Format((String)"PAGE_%1$s.DG_%2$s", (Object)this.page.getPAGEID(), (Object)this.page.getVERSION());
        strDataGridConfigId = strDataGridConfigId.toUpperCase();
        String strDGFilePath = ConfigPathHelper.GetRuntimeDGConfigPath((String)this.webContext.GetAppRootPath(), (String)strDataGridConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strDataGridConfigId;
        }
        String strDGPagingBar = this.getPageParam(TAG_DGPAGINGBAR, "FALSE");
        String strDGColumnName = this.getPageParam(TAG_DGCOLUMNNAME, "\u6570\u636e");
        String strDGPagingSize = this.getPageParam(TAG_DGPAGINGSIZE, "20");
        String strInfoFields = this.getPageParam(TAG_DGCOLUMNFIELD, "");
        String strInfoFormat = this.getPageParam(TAG_DGCOLUMNFORMAT, "");
        String strKeyColumn = this.getPageParam(TAG_DGKEYCOLUMN, "");
        XMLNode rootNode = new XMLNode();
        rootNode.setNodeName("SRFEXDATAGRID");
        rootNode.SetValue("PAGING", strDGPagingBar);
        rootNode.SetValue("SELECTCOLUMN", "FALSE");
        rootNode.SetValue("MULTISELECT", "TRUE");
        XMLNode pagingNode = new XMLNode();
        pagingNode.setNodeName("SRFEXDATAGRIDPAGING");
        rootNode.AddNode(pagingNode);
        pagingNode.SetValue("PAGESIZE", strDGPagingSize);
        XMLNode dsItemsNode = new XMLNode();
        dsItemsNode.setNodeName("SRFEXDATAGRIDDS");
        rootNode.AddNode(dsItemsNode);
        XMLNode dsItemNode = new XMLNode();
        dsItemNode.setNodeName("SRFEXDATAGRIDDSITEM");
        dsItemsNode.AddNode(dsItemNode);
        if (StringHelper.IsNullOrEmpty((String)strKeyColumn)) {
            dsItemNode.setID(this.getDEHelper().GetKeyDEFHelper().getName());
        } else {
            IDEFHelper iDEFHelper = this.iDEHelper.GetDEFHelper(strKeyColumn);
            if (iDEFHelper != null) {
                dsItemNode.setID(iDEFHelper.getName());
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKeyColumn));
                return "";
            }
        }
        dsItemNode.SetValue("KEY", "TRUE");
        String strTextColumnName = "";
        XMLNode dsItemNode2 = new XMLNode();
        dsItemNode2.setNodeName("SRFEXDATAGRIDDSITEM");
        dsItemsNode.AddNode(dsItemNode2);
        if (StringHelper.IsNullOrEmpty((String)strInfoFormat)) {
            strInfoFormat = "%1$s";
        }
        dsItemNode2.SetValue("ITEMFORMAT", strInfoFormat);
        XMLNode dsItemParamsNode = new XMLNode();
        dsItemParamsNode.setNodeName("SRFEXITEMPARAMS");
        dsItemNode2.AddNode(dsItemParamsNode);
        if (StringHelper.IsNullOrEmpty((String)strInfoFields)) {
            IDEFHelper majorDEFHelper = this.iDEHelper.GetMajorDEFHelper();
            if (majorDEFHelper != null) {
                dsItemNode2.setID(majorDEFHelper.getName());
                XMLNode dsItemParamNode = new XMLNode();
                dsItemParamNode.setNodeName("SRFEXITEMPARAM");
                dsItemParamsNode.AddNode(dsItemParamNode);
                dsItemParamNode.setID(majorDEFHelper.getName());
                dsItemParamNode.SetValue("ITEMFORMAT", majorDEFHelper.getDGItem().GetItemFormat(null));
                String strCodeList = majorDEFHelper.GetCodeList();
                if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
                    dsItemParamNode.SetValue("CODELIST", strCodeList);
                }
                strTextColumnName = majorDEFHelper.getName();
            }
        } else {
            boolean bFirst = true;
            String[] parts = strInfoFields.split("[|]");
            int i = 0;
            while (i < parts.length) {
                String strParam = parts[i];
                IDEFHelper iDEFHelper = this.iDEHelper.GetDEFHelper(strParam = strParam.trim());
                if (iDEFHelper != null) {
                    if (bFirst) {
                        bFirst = false;
                        dsItemNode2.setID(iDEFHelper.getName());
                        strTextColumnName = iDEFHelper.getName();
                    }
                    XMLNode dsItemParamNode = new XMLNode();
                    dsItemParamNode.setNodeName("SRFEXITEMPARAM");
                    dsItemParamsNode.AddNode(dsItemParamNode);
                    dsItemParamNode.setID(iDEFHelper.getName());
                    dsItemParamNode.SetValue("ITEMFORMAT", iDEFHelper.getDGItem().GetItemFormat(null));
                    String strCodeList = iDEFHelper.GetCodeList();
                    if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
                        dsItemParamNode.SetValue("CODELIST", strCodeList);
                    }
                }
                ++i;
            }
        }
        XMLNode dgColumnsNode = new XMLNode();
        dgColumnsNode.setNodeName("SRFEXDATAGRIDCOLUMNS");
        rootNode.AddNode(dgColumnsNode);
        XMLNode dgColumnNode = new XMLNode();
        dgColumnNode.setNodeName("SRFEXDATAGRIDCOLUMN");
        dgColumnsNode.AddNode(dgColumnNode);
        dgColumnNode.setID(this.getDEHelper().GetMajorDEFHelper().getName());
        dgColumnNode.SetValue("CAPTION", strDGColumnName);
        dgColumnNode.SetValue("WIDTH", "200");
        dgColumnNode.SetValue("SORTABLE", "FALSE");
        dgColumnNode.SetValue("DSITEM", strTextColumnName);
        if (!DAConfigHelper.ExportConfigFile((XMLNode)rootNode, (String)strDGFilePath)) {
            return "";
        }
        return strDataGridConfigId;
    }

    protected void LoadButtons() {
        this.selectAllButton = new SRFExButton();
        this.selectAllButton.InitConfig();
        this.selectAllButton.setID("selectAllButton");
        this.selectAllButton.getButtonConfig().setText("\u5168\u90e8\u9009\u62e9");
        this.selectAllButton.getButtonConfig().setTips("\u5168\u90e8\u9009\u62e9");
        this.selectAllButton.getButtonConfig().setWidth(120);
        this.selectAllButton.getButtonConfig().setIconCls("sx-tb-moverightall");
        this.selectAllButton.setResourceId("");
        this.InitCtrlConfigFromPageParam("BUTTON.SELECTALL", (XMLConfig)this.selectAllButton.getButtonConfig());
        this.selectAllButton.getButtonConfig().setJSCode("addall();");
        this.AddControl((SRFExControl)this.selectAllButton);
        this.selectButton = new SRFExButton();
        this.selectButton.InitConfig();
        this.selectButton.setID("selectButton");
        this.selectButton.getButtonConfig().setText("\u9009\u62e9");
        this.selectButton.getButtonConfig().setTips("\u9009\u62e9\u9009\u4e2d\u7684\u6570\u636e");
        this.selectButton.getButtonConfig().setWidth(120);
        this.selectButton.getButtonConfig().setIconCls("sx-tb-moveright");
        this.InitCtrlConfigFromPageParam("BUTTON.SELECT", (XMLConfig)this.selectButton.getButtonConfig());
        this.selectButton.getButtonConfig().setJSCode("addselect();");
        this.selectButton.setResourceId("");
        this.AddControl((SRFExControl)this.selectButton);
        this.cancelButton = new SRFExButton();
        this.cancelButton.InitConfig();
        this.cancelButton.setID("cancelButton");
        this.cancelButton.getButtonConfig().setText("\u53d6\u6d88");
        this.cancelButton.getButtonConfig().setTips("\u53d6\u6d88\u9009\u4e2d\u7684\u6570\u636e");
        this.cancelButton.getButtonConfig().setWidth(120);
        this.cancelButton.getButtonConfig().setIconCls("sx-tb-moveleft");
        this.cancelButton.setResourceId("");
        this.InitCtrlConfigFromPageParam("BUTTON.UNSELECT", (XMLConfig)this.cancelButton.getButtonConfig());
        this.cancelButton.getButtonConfig().setJSCode("removeselect();");
        this.AddControl((SRFExControl)this.cancelButton);
        this.cancelAllButton = new SRFExButton();
        this.cancelAllButton.InitConfig();
        this.cancelAllButton.setID("cancelAllButton");
        this.cancelAllButton.getButtonConfig().setText("\u5168\u90e8\u53d6\u6d88");
        this.cancelAllButton.getButtonConfig().setTips("\u5168\u90e8\u53d6\u6d88");
        this.cancelAllButton.getButtonConfig().setWidth(120);
        this.cancelAllButton.getButtonConfig().setIconCls("sx-tb-moveleftall");
        this.cancelAllButton.setResourceId("");
        this.InitCtrlConfigFromPageParam("BUTTON.UNSELECTALL", (XMLConfig)this.cancelAllButton.getButtonConfig());
        this.cancelAllButton.getButtonConfig().setJSCode("removeall();");
        this.AddControl((SRFExControl)this.cancelAllButton);
    }

    protected void LoadSelectDataGrid() {
        String strDataGridConfigId = this.GetDGConfigId();
        if (StringHelper.IsNullOrEmpty((String)strDataGridConfigId)) {
            return;
        }
        this.selectDataGrid = CommonSelectPage.CreateDataGrid(this, "selectDataGrid", 200.0, 300.0, strDataGridConfigId);
        if (this.selectDataGrid != null) {
            this.selectDataGrid.getDataGridConfig().setLoadDefault(false);
        }
    }

    protected void LoadTotalDataGrid() {
        String strDataGridConfigId = this.GetDGConfigId();
        if (StringHelper.IsNullOrEmpty((String)strDataGridConfigId)) {
            return;
        }
        this.totalDataGrid = CommonSelectPage.CreateDataGrid(this, "totalDataGrid", 200.0, 300.0, strDataGridConfigId);
        if (this.totalDataGrid != null) {
            this.totalDataGrid.getDataGridConfig().setLoadDefault(true);
        }
    }

    @Override
    protected String OnGetPageHeader() {
        return "\u6570\u636e\u9009\u62e9\u754c\u9762";
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterDataGridActionHelper(this.totalDataGrid.getUniqueID(), this.GetDataGridActionHelper());
    }

    protected String GetDataGridActionHelper() {
        String strDGActionHelper = this.getPageParam("PAGE.DGACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGActionHelper)) {
            return strDGActionHelper;
        }
        return SimpleDADataGridActionHelper.class.getName();
    }
}

