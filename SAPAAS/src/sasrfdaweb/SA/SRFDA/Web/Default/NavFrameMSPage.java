/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Button.SRFExAjaxButton
 *  SA.SRFramework.WebEx.SRFExBaseButton
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DAConfigHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Web.Default.NavFramePage;
import SA.SRFDA.Web.Default.ViewModel.NavFramePickupViewModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Button.SRFExAjaxButton;
import SA.SRFramework.WebEx.SRFExBaseButton;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import net.sf.json.JSONObject;

public class NavFrameMSPage
extends NavFramePage {
    protected SRFExDataGrid selectDataGrid = null;
    protected SRFExButton selectButton = null;
    protected SRFExButton selectAllButton = null;
    protected SRFExButton unselectButton = null;
    protected SRFExButton unselectAllButton = null;
    protected SRFExBaseButton OkButton = null;
    public static final String TAG_SELECTDGTITLE = "PAGE.SELECTDGTITLE";
    public static final String TAG_DGCOLUMNNAME = "PAGE.DATAGRID.COLUMNNAME";
    public static final String TAG_DGPAGINGBAR = "PAGE.DATAGRID.PAGINGBAR";
    public static final String TAG_DGPAGINGSIZE = "PAGE.DATAGRID.PAGINGSIZE";
    public static final String TAG_DGCOLUMNFORMAT = "PAGE.DATAGRID.COLUMNFORMAT";
    public static final String TAG_DGCOLUMNFIELD = "PAGE.DATAGRID.COLUMNFIELD";
    public static final String TAG_DGKEYCOLUMN = "PAGE.DATAGRID.KEYCOLUMN";
    protected NavFramePickupViewModel navFramePickupViewModel = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.setPageParam("PICKUPMODE", true);
        return true;
    }

    @Override
    protected PageModel CreatePageModel() {
        return new NavFramePickupViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.navFramePickupViewModel = (NavFramePickupViewModel)this.pageModel;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        String bAHelper = this.OnGetOKButtonActionHelper();
        if (StringHelper.Length((String)bAHelper) > 0) {
            this.RegisterButtonActionHelper(this.OkButton.getUniqueID(), bAHelper);
        }
    }

    protected String OnGetOKButtonActionHelper() {
        return this.getPageParam("PAGE.MSAHELPER", "");
    }

    @Override
    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadButton();
        this.LoadButtons();
        this.LoadSelectDataGrid();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        String strItemSeperator = this.GetItemSeperator();
        script.Append("if(onBeforeLoad) onBeforeLoad();var _SELECTEDROWS ='';for(var i = 0;i<items.getCount();i++) _SELECTEDROWS+= items.get(i)+',';\n");
        script.Append("var _Texts ='';if(texts){for(var i = 0;i<texts.getCount();i++) _Texts+= texts.get(i)+'%1$s';}\n", (Object)strItemSeperator);
        script.Append("var _Values ='';for(var i = 0;i<items.getCount();i++) _Values+= items.get(i)+'%1$s';\n", (Object)strItemSeperator);
        script.Append("if( _SELECTEDROWS == '' ) { alert('\u6ca1\u6709\u9009\u4e2d\u4efb\u4f55\u6570\u636e\uff0c\u8bf7\u786e\u8ba4\uff01');return;}\n");
        if (this.OkButton instanceof SRFExAjaxButton) {
            script.Append("_PARAMS['ajaxparam1'] = _SELECTEDROWS;");
            script.Append(" _POSTDATA =  Ext.urlEncode(_PARAMS); ");
            ((SRFExAjaxButton)this.OkButton).getClickAction().setBeforeCode(script.toString());
            script.Reset();
            script.Append(BrowserJSHelper.getResetDialogReturnValue());
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
            script.Append(BrowserJSHelper.getCloseWindowScript());
            ((SRFExAjaxButton)this.OkButton).getClickAction().getSuccessAction().RegisterProcessCode(0, script.toString());
        } else {
            script.Append(BrowserJSHelper.getResetDialogReturnValue());
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"items", (String)"_SELECTEDROWS"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"text", (String)"_Texts"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"value", (String)"_Values"));
            script.Append(BrowserJSHelper.getCloseWindowScript());
            ((SRFExButton)this.OkButton).getButtonConfig().setJSCode(script.toString());
        }
    }

    protected void LoadButton() {
        String bAHelper = this.OnGetOKButtonActionHelper();
        if (!StringHelper.IsNullOrEmpty((String)bAHelper)) {
            SRFExAjaxButton ajaxOKButton = new SRFExAjaxButton();
            ajaxOKButton.InitConfig();
            ajaxOKButton.setID("OkButton");
            ajaxOKButton.getAjaxButtonConfig().setConfirm("\u786e\u5b9e\u8981\u64cd\u4f5c\u9009\u4e2d\u7684\u6570\u636e\u4e48\uff1f");
            ajaxOKButton.getAjaxButtonConfig().setText("\u786e\u5b9a\u64cd\u4f5c");
            ajaxOKButton.getAjaxButtonConfig().setTips("\u786e\u5b9a\u64cd\u4f5c\u4e2d\u9009\u4e2d\u7684\u6570\u636e");
            ajaxOKButton.getAjaxButtonConfig().setIconCls("sx-tb-ok");
            ajaxOKButton.setResourceId("");
            this.AddControl((SRFExControl)ajaxOKButton);
            this.OkButton = ajaxOKButton;
        } else {
            SRFExButton normalOKButton = new SRFExButton();
            normalOKButton.InitConfig();
            normalOKButton.setID("OkButton");
            normalOKButton.getButtonConfig().setText("\u786e\u5b9a\u64cd\u4f5c");
            normalOKButton.getButtonConfig().setTips("\u786e\u5b9a\u64cd\u4f5c\u4e2d\u9009\u4e2d\u7684\u6570\u636e");
            normalOKButton.getButtonConfig().setIconCls("sx-tb-ok");
            normalOKButton.setResourceId("");
            this.AddControl((SRFExControl)normalOKButton);
            this.OkButton = normalOKButton;
        }
        SRFExButton CancelButton = new SRFExButton();
        CancelButton.InitConfig();
        CancelButton.setID("CancelButton");
        CancelButton.getButtonConfig().setText("\u53d6\u6d88\u64cd\u4f5c");
        CancelButton.getButtonConfig().setTips("\u53d6\u6d88\u64cd\u4f5c");
        CancelButton.getButtonConfig().setIconCls("sx-tb-cancel");
        CancelButton.setResourceId("");
        this.AddControl((SRFExControl)CancelButton);
        StringBuilderEx script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'cancel'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        CancelButton.getButtonConfig().setJSCode(script.toString());
        SRFExButton ResetButton = new SRFExButton();
        ResetButton.InitConfig();
        ResetButton.setID("ResetButton");
        ResetButton.getButtonConfig().setText("\u6e05\u7a7a\u9009\u62e9");
        ResetButton.getButtonConfig().setTips("\u6e05\u7a7a\u9009\u62e9");
        ResetButton.getButtonConfig().setIconCls("sx-tb-restart");
        ResetButton.setResourceId("");
        this.AddControl((SRFExControl)ResetButton);
        script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"text", (String)"''"));
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"value", (String)"''"));
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        ResetButton.getButtonConfig().setJSCode(script.toString());
    }

    public String GetKeyName() {
        String strKeyColumn = this.getPageParam(TAG_DGKEYCOLUMN, "");
        if (StringHelper.IsNullOrEmpty((String)strKeyColumn)) {
            return this.getDEHelper().GetKeyDEFHelper().getName().toLowerCase();
        }
        IDEFHelper iDEFHelper = this.iDEHelper.GetDEFHelper(strKeyColumn);
        if (iDEFHelper != null) {
            return iDEFHelper.getName();
        }
        this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKeyColumn));
        return "";
    }

    public String GetTextName() {
        return this.getPageParam("PAGE.SELECTCAPTION", this.getDEHelper().GetMajorDEFHelper().getDEField().getDEFNAME()).toLowerCase();
    }

    public boolean GetExFlag() {
        return this.getPage().getPageParam("PAGE.EXFLAG") == null || StringHelper.Compare((String)this.getPage().getPageParam("PAGE.EXFLAG").toString(), (String)"false", (boolean)true) != 0;
    }

    public String GetSelectDGTitle() {
        return this.getPageParam(TAG_SELECTDGTITLE, "\u9009\u62e9\u6570\u636e");
    }

    public String GetItemSeperator() {
        String strSeperator = this.getWebContext().GetParamValue("ITEMSEPERATOR");
        if (!StringHelper.IsNullOrEmpty((String)strSeperator)) {
            return strSeperator;
        }
        return this.getPageParam("PAGE.ITEMSEPERATOR", "|");
    }

    protected void LoadSelectDataGrid() {
        String strDataGridConfigId = this.GetDGConfigId();
        if (StringHelper.IsNullOrEmpty((String)strDataGridConfigId)) {
            return;
        }
        this.selectDataGrid = NavFrameMSPage.CreateDataGrid(this, "selectDataGrid", 100.0, 100.0, strDataGridConfigId);
        if (this.selectDataGrid != null) {
            this.selectDataGrid.getDataGridConfig().setLoadDefault(false);
            this.selectDataGrid.getDataGridConfig().setDeferEmptyText(true);
        }
    }

    public String GetDGConfigId() {
        String strDataGridConfigId = StringHelper.Format((String)"PAGE_%1$s.DG_%2$s", (Object)(String.valueOf(this.page.getPAGEID()) + this.getWebContext().getSRFDEID()), (Object)this.page.getVERSION());
        strDataGridConfigId = strDataGridConfigId.toUpperCase();
        String strDGFilePath = ConfigPathHelper.GetRuntimeDGConfigPath((String)this.webContext.GetAppRootPath(), (String)strDataGridConfigId);
        File file = new File(strDGFilePath);
        if (file.exists()) {
            return strDataGridConfigId;
        }
        String strDGPagingBar = this.getPageParam(TAG_DGPAGINGBAR, "FALSE");
        String strDGColumnName = this.getPageParam(TAG_DGCOLUMNNAME, "\u9009\u4e2d\u7684\u6570\u636e");
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
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKeyColumn));
                return "";
            }
        }
        dsItemNode.SetValue("KEY", "TRUE");
        String strTextColumnName = "";
        IDEFHelper majorDEFHelper = this.iDEHelper.GetMajorDEFHelper();
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
            String strMajorFieldName = this.getPageParam("PAGE.SELECTCAPTION", "");
            if (!StringHelper.IsNullOrEmpty((String)strMajorFieldName)) {
                majorDEFHelper = this.iDEHelper.GetDEFHelper(strMajorFieldName);
            }
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
        dgColumnNode.setID(majorDEFHelper.getDEField().getDEFNAME());
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
        this.selectAllButton.getButtonConfig().setText("");
        this.selectAllButton.getButtonConfig().setTips("\u5168\u90e8\u9009\u62e9");
        this.selectAllButton.getButtonConfig().setIconCls("sx-tb-moverightall");
        this.InitCtrlConfigFromPageParam("BUTTON.SELECTALL", (XMLConfig)this.selectAllButton.getButtonConfig());
        this.selectAllButton.getButtonConfig().setJSCode("addall();");
        this.selectAllButton.setResourceId("");
        this.AddControl((SRFExControl)this.selectAllButton);
        this.selectButton = new SRFExButton();
        this.selectButton.InitConfig();
        this.selectButton.setID("selectButton");
        this.selectButton.getButtonConfig().setText("");
        this.selectButton.getButtonConfig().setTips("\u9009\u62e9\u9009\u4e2d\u7684\u6570\u636e");
        this.selectButton.getButtonConfig().setIconCls("sx-tb-moveright");
        this.InitCtrlConfigFromPageParam("BUTTON.SELECT", (XMLConfig)this.selectButton.getButtonConfig());
        this.selectButton.getButtonConfig().setJSCode("addselect();");
        this.selectButton.setResourceId("");
        this.AddControl((SRFExControl)this.selectButton);
        this.unselectButton = new SRFExButton();
        this.unselectButton.InitConfig();
        this.unselectButton.setID("unselectButton");
        this.unselectButton.getButtonConfig().setText("");
        this.unselectButton.getButtonConfig().setTips("\u53d6\u6d88\u9009\u4e2d\u7684\u6570\u636e");
        this.unselectButton.getButtonConfig().setIconCls("sx-tb-moveleft");
        this.unselectButton.setResourceId("");
        this.InitCtrlConfigFromPageParam("BUTTON.UNSELECT", (XMLConfig)this.unselectButton.getButtonConfig());
        this.unselectButton.getButtonConfig().setJSCode("removeselect();");
        this.AddControl((SRFExControl)this.unselectButton);
        this.unselectAllButton = new SRFExButton();
        this.unselectAllButton.InitConfig();
        this.unselectAllButton.setID("unselectAllButton");
        this.unselectAllButton.getButtonConfig().setText("");
        this.unselectAllButton.getButtonConfig().setTips("\u5168\u90e8\u53d6\u6d88");
        this.unselectAllButton.getButtonConfig().setIconCls("sx-tb-moveleftall");
        this.unselectAllButton.setResourceId("");
        this.InitCtrlConfigFromPageParam("BUTTON.UNSELECTALL", (XMLConfig)this.unselectAllButton.getButtonConfig());
        this.unselectAllButton.getButtonConfig().setJSCode("removeall();");
        this.AddControl((SRFExControl)this.unselectAllButton);
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.navFramePickupViewModel.setPickupValue(this.GetKeyName());
        this.navFramePickupViewModel.setPickupText(this.GetTextName());
        this.navFramePickupViewModel.setSelectedDataTitle(this.GetSelectDGTitle());
        return true;
    }

    @Override
    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.PICKUPVIEW", "\u9009\u62e9\u89c6\u56fe");
    }
}

