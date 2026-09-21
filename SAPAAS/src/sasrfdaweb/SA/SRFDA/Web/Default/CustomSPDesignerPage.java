/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExTextBox
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;

public class CustomSPDesignerPage
extends SRFDAPage {
    protected String SPCODELIST = "model.spdesinger.customerspdesigner";
    protected SRFExButton btnAddSPItem = null;
    protected SRFExButton btnSaveSPItem = null;
    protected SRFExButton btnResetSPItem = null;
    protected SRFExButton btnSearch = null;
    protected SRFExTextBox tbDataEntity = null;
    protected SRFExDropDownList ddlFormItem = null;
    protected SRFExDropDownList ddlGroupCond = null;
    protected String strDEID = "";
    protected IDEFHelper selectedDEField = null;
    protected String strDEFId = "";
    protected StringBuilderEx script = new StringBuilderEx();

    public void OnInitComponents() {
        super.OnInitComponents();
        this.strDEID = this.getWebContext().getSRFDEID();
        this.InitBtnAddSPItem();
        this.InitBtnSearch();
        this.InitDEText();
        this.InitDEFildDropDownList();
    }

    public void InitBtnAddSPItem() {
        this.btnAddSPItem = new SRFExButton();
        this.btnAddSPItem.InitConfig();
        this.btnAddSPItem.setID("btnAddSPItem");
        this.btnAddSPItem.getButtonConfig().setIconCls("sx-tb-addrow");
        this.btnAddSPItem.getButtonConfig().setText(this.GetLocalization("PAGE.COMMON.CUSTOMSPDESIGNER.ADDBUTTON.TEXT", "\u589e\u52a0"));
        this.btnAddSPItem.getButtonConfig().setTips(this.GetLocalization("PAGE.COMMON.CUSTOMSPDESIGNER.ADDBUTTON.TOOLTIPS", "\u589e\u52a0\u81ea\u5b9a\u4e49\u641c\u7d22\u6761\u4ef6"));
        this.btnAddSPItem.setResourceId("");
        this.script.Reset();
        this.script.Append("customerSPDesinger.newSPItem();");
        this.btnAddSPItem.getButtonConfig().setJSCode(this.script.toString());
        this.AddControl((SRFExControl)this.btnAddSPItem);
    }

    public void InitBtnSaveSPItem() {
        this.btnSaveSPItem = new SRFExButton();
        this.btnSaveSPItem.InitConfig();
        this.btnSaveSPItem.setID("btnSaveSPItem");
        this.btnSaveSPItem.getButtonConfig().setIconCls("sx-tb-save");
        this.btnSaveSPItem.getButtonConfig().setText(this.GetLocalization("PAGE.COMMON.CUSTOMSPDESIGNER.SAVEBUTTON.TEXT", "\u4fdd\u5b58"));
        this.btnSaveSPItem.getButtonConfig().setTips(this.GetLocalization("PAGE.COMMON.CUSTOMSPDESIGNER.SAVEBUTTON.TOOLTIPS", "\u4fdd\u5b58\u81ea\u5b9a\u4e49\u641c\u7d22\u6761\u4ef6"));
        this.btnSaveSPItem.setResourceId("");
        this.script.Reset();
        this.script.Append("customerSPDesinger.saveSPItem();");
        this.btnSaveSPItem.getButtonConfig().setJSCode(this.script.toString());
        this.AddControl((SRFExControl)this.btnSaveSPItem);
    }

    public void InitBtnResetSPItem() {
        this.btnResetSPItem = new SRFExButton();
        this.btnResetSPItem.InitConfig();
        this.btnResetSPItem.setID("btnResetSPItem");
        this.btnResetSPItem.getButtonConfig().setIconCls("sx-tb-other");
        this.btnResetSPItem.getButtonConfig().setText(this.GetLocalization("PAGE.COMMON.CUSTOMSPDESIGNER.RESETBUTTON.TEXT", "\u91cd\u7f6e"));
        this.btnResetSPItem.getButtonConfig().setTips(this.GetLocalization("PAGE.COMMON.CUSTOMSPDESIGNER.RESETBUTTON.TOOLTIPS", "\u91cd\u7f6e\u81ea\u5b9a\u4e49\u641c\u7d22\u6761\u4ef6"));
        this.btnResetSPItem.setResourceId("");
        this.script.Reset();
        this.script.Append("window.location.reload();customerSPDesinger.loadSPItemXML();");
        this.btnResetSPItem.getButtonConfig().setJSCode(this.script.toString());
        this.AddControl((SRFExControl)this.btnResetSPItem);
    }

    public void InitBtnSearch() {
        this.btnSearch = new SRFExButton();
        this.btnSearch.InitConfig();
        this.btnSearch.setID("btnSearch");
        this.btnSearch.getButtonConfig().setIconCls("sx-tb-search");
        this.btnSearch.getButtonConfig().setText(this.GetLocalization("PAGE.COMMON.CUSTOMSPDESIGNER.SEARCHBUTTON.TEXT", "\u641c\u7d22"));
        this.btnSearch.getButtonConfig().setTips(this.GetLocalization("PAGE.COMMON.CUSTOMSPDESIGNER.SEARCHBUTTON.TOOLTIPS", "\u641c\u7d22"));
        this.btnSearch.setResourceId("");
        this.script.Reset();
        this.script.Append("var strXML = customerSPDesinger.saveSPItem();");
        this.script.Append("var strModeDesc = customerSPDesinger.getSPModeDescText();");
        this.script.Append("window.returnValue={};");
        this.script.Append("%1$s", (Object)BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
        this.script.Append("%1$s", (Object)BrowserJSHelper.getSetDialogReturnValue((String)"spItemXML", (String)"strXML"));
        this.script.Append("%1$s", (Object)BrowserJSHelper.getSetDialogReturnValue((String)"spItemModeDesc", (String)"strModeDesc"));
        this.script.Append("%1$s", (Object)BrowserJSHelper.getCloseWindowScript());
        this.btnSearch.getButtonConfig().setJSCode(this.script.toString());
        this.AddControl((SRFExControl)this.btnSearch);
    }

    public void InitDEText() {
        this.tbDataEntity = new SRFExTextBox();
        this.tbDataEntity.InitConfig();
        this.tbDataEntity.setID("tbDataEntity");
        this.tbDataEntity.getTextBoxConfig().setWidthEx(1.0);
        this.tbDataEntity.getTextBoxConfig().setReadOnly(true);
        DataEntity dataEntity = new DataEntity();
        CallResult callResult = this.getDAModelHelper().GetDataEntity(this.strDEID, dataEntity);
        if (callResult == null || callResult.getRetCode() != 0) {
            return;
        }
        this.tbDataEntity.getTextBoxConfig().setText(StringHelper.Format((String)"%1$s[%2$s]", (Object)dataEntity.getDENAME(), (Object)dataEntity.getDELOGICNAME()));
        this.AddControl((SRFExControl)this.tbDataEntity);
    }

    public void InitGroupCondDropDownList() {
        this.ddlGroupCond = new SRFExDropDownList();
        this.ddlGroupCond.InitConfig();
        this.ddlGroupCond.setID("ddlGroupCond");
        this.ddlGroupCond.getDropDownListConfig().setWidthEx(1.0);
        this.ddlGroupCond.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"%1$s [%2$s]", (Object)"\u5e76\u4e14", (Object)"AND"), "AND"));
        this.ddlGroupCond.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"%1$s [%2$s]", (Object)"\u6216\u8005", (Object)"OR"), "OR"));
        this.ddlGroupCond.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"%1$s [%2$s]", (Object)"\u4e0d\u5305\u542b", (Object)"NOT"), "NOT"));
        this.AddControl((SRFExControl)this.ddlGroupCond);
    }

    public void InitDEFildDropDownList() {
        this.ddlFormItem = new SRFExDropDownList();
        this.ddlFormItem.InitConfig();
        this.ddlFormItem.setID("ddlFormItem");
        this.ddlFormItem.getDropDownListConfig().setWidthEx(1.0);
        this.iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(this.strDEID);
        this.ddlFormItem.getDropDownListConfig().getListItems().Add(new ListItem("-", ""));
        for (IDEFHelper iDEFHelper : this.iDEHelper.GetDEFHelpers()) {
            String strTempDEFId = iDEFHelper.getId();
            if (!StringHelper.IsNullOrEmpty((String)this.strDEFId) && StringHelper.Compare((String)strTempDEFId, (String)this.strDEFId, (boolean)true) == 0) {
                this.selectedDEField = iDEFHelper;
            }
            this.ddlFormItem.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"%1$s [%2$s]", (Object)iDEFHelper.getName(), (Object)iDEFHelper.getLogicName(this.getLanguage())), strTempDEFId));
        }
        if (this.selectedDEField != null) {
            this.ddlFormItem.getDropDownListConfig().setSelectedValue(this.selectedDEField.getId());
        }
        this.AddControl((SRFExControl)this.ddlFormItem);
    }

    public String GetDEId() {
        return this.strDEID;
    }

    public String GetItemPrivilege() {
        return StringHelper.Compare((String)this.getWebContext().GetParamValue("ITEMPRIVILEGE"), (String)"TRUE", (boolean)true) == 0 ? "true" : "false";
    }
}

