/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PP.PPTreePickupView
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.PP.PPTreePickupView;
import SA.SRFDA.Web.Default.TreePage;
import SA.SRFDA.Web.Default.ViewModel.TreePickupViewModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import net.sf.json.JSONObject;

public class TreePickupPage
extends TreePage {
    protected PPTreePickupView ppTreePickupView = null;
    protected TreePickupViewModel treePickupViewModel = null;

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam("PAGE", "PPTREEPICKUPVIEW")) != null && pageParam instanceof PPTreePickupView) {
            this.ppTreePickupView = (PPTreePickupView)pageParam;
        }
    }

    @Override
    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadButton();
    }

    protected void LoadButton() {
        StringBuilderEx script;
        SRFExButton OkButton = new SRFExButton();
        OkButton.InitConfig();
        OkButton.setID("OkButton");
        OkButton.getButtonConfig().setWidth(70);
        String strOKText = this.GetLocalization("PAGE.COMMON.PICKUPVIEW.OKBTN.TEXT", "\u786e\u5b9a\u9009\u62e9");
        OkButton.getButtonConfig().setText(strOKText);
        OkButton.getButtonConfig().setTips(strOKText);
        OkButton.getButtonConfig().setIconCls("sx-tb-ok");
        OkButton.setResourceId("");
        this.AddControl((SRFExControl)OkButton);
        if (!this.IsBackEndMode()) {
            script = new StringBuilderEx();
            script.Append(BrowserJSHelper.getResetDialogReturnValue());
            if (this.bMultiSelect) {
                String strItemSeperator = this.GetItemSeperator();
                script.Append("var items=$P.tree['%1$s'].getChecked();", (Object)this.treePanel.getUniqueID());
                script.Append("var _Texts ='';var _Values='';if(items&&items.length>0){for(var i = 0;i<items.length;i++){var node=items[i];_Texts+=node.attributes['selecttext']+'%1$s';_Values+= node.attributes['value']+'%1$s';}}else{alert('\u6240\u9009\u6570\u636e\u4e0d\u80fd\u4e3a\u7a7a');return false;}", (Object)strItemSeperator);
                script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"text", (String)"_Texts"));
                script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"value", (String)"_Values"));
            } else {
                script.Append("var node=$P.tree['%1$s'].getSelectionModel().getSelectedNode();", (Object)this.treePanel.getUniqueID());
                script.Append("if(node==null){alert('\u6240\u9009\u6570\u636e\u4e0d\u80fd\u4e3a\u7a7a');return false;}");
                script.Append("if(!node.attributes['value']){alert('\u6240\u9009\u6570\u636e\u4e0d\u80fd\u4e3a\u7a7a');return false;}");
                script.Append("window.returnValue=node.attributes;");
                script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"text", (String)"node.attributes['selecttext']"));
                script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"value", (String)"node.attributes['value']"));
            }
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
            script.Append(BrowserJSHelper.getCloseWindowScript());
            OkButton.getButtonConfig().setJSCode(script.toString());
        }
        SRFExButton CancelButton = new SRFExButton();
        CancelButton.InitConfig();
        CancelButton.setID("CancelButton");
        CancelButton.getButtonConfig().setWidth(70);
        String strCancelText = this.GetLocalization("PAGE.COMMON.PICKUPVIEW.CANCELBTN.TEXT", "\u53d6\u6d88\u64cd\u4f5c");
        CancelButton.getButtonConfig().setText(strCancelText);
        CancelButton.getButtonConfig().setTips(strCancelText);
        CancelButton.getButtonConfig().setIconCls("sx-tb-cancel");
        CancelButton.setResourceId("");
        this.AddControl((SRFExControl)CancelButton);
        script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'cancel'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        CancelButton.getButtonConfig().setJSCode(script.toString());
        SRFExButton ResetButton = new SRFExButton();
        ResetButton.InitConfig();
        ResetButton.setID("ResetButton");
        ResetButton.getButtonConfig().setWidth(70);
        String strResetText = this.GetLocalization("PAGE.COMMON.PICKUPVIEW.RESETBTN.TEXT", "\u6e05\u7a7a\u9009\u62e9");
        ResetButton.getButtonConfig().setText(strResetText);
        ResetButton.getButtonConfig().setTips(strResetText);
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

    public String GetItemSeperator() {
        String strSeperator = this.getWebContext().GetParamValue("ITEMSEPERATOR");
        if (!StringHelper.IsNullOrEmpty((String)strSeperator)) {
            return strSeperator;
        }
        if (this.ppTreePickupView != null) {
            strSeperator = this.ppTreePickupView.getITEMSEPERATOR();
        }
        if (StringHelper.IsNullOrEmpty((String)strSeperator)) {
            strSeperator = "|";
        }
        return this.getPageParam("PAGE.ITEMSEPERATOR", strSeperator);
    }

    @Override
    protected PageModel CreatePageModel() {
        return new TreePickupViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.treePickupViewModel = (TreePickupViewModel)this.pageModel;
    }

    public String GetKeyName() {
        return this.getDEHelper().GetKeyDEFHelper().getName().toLowerCase();
    }

    public String GetTextName() {
        return this.getPageParam("PAGE.SELECTCAPTION", this.getDEHelper().GetMajorDEFHelper().getDEField().getDEFNAME()).toLowerCase();
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.treePickupViewModel.setPickupValue(this.GetKeyName());
        this.treePickupViewModel.setPickupText(this.GetTextName());
        return true;
    }
}

