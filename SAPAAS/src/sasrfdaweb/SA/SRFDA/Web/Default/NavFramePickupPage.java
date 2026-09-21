/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.NavFramePage;
import SA.SRFDA.Web.Default.ViewModel.NavFramePickupViewModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import net.sf.json.JSONObject;

public class NavFramePickupPage
extends NavFramePage {
    protected NavFramePickupViewModel navFramePickupViewModel = null;

    @Override
    protected boolean PreparePageEnv() {
        if (StringHelper.Length((String)this.getWebContext().getSRFPageId()) == 0) {
            this.getWebContext().SetParamValue("SRFPAGEID", "PAGE_00000");
        }
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
        OkButton.getButtonConfig().setText("\u786e\u5b9a\u9009\u62e9");
        OkButton.getButtonConfig().setTips("\u786e\u5b9a\u9009\u62e9");
        OkButton.getButtonConfig().setIconCls("sx-tb-ok");
        OkButton.setResourceId("");
        this.AddControl((SRFExControl)OkButton);
        if (!this.IsBackEndMode()) {
            script = new StringBuilderEx();
            script.Append("var _1= _SELECTROW;\r\n");
            script.Append("if(_1==null){alert('\u6ca1\u6709\u9009\u62e9\u6570\u636e!');return;}\r\n");
            if (StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFVDEF().toUpperCase())) {
                script.Append("var _v = _1.get('%1$s');\r\n", (Object)this.getDEHelper().GetKeyDEFHelper().getName().toUpperCase());
            } else {
                script.Append("var _v = _1.get('%1$s');\r\n", (Object)this.getWebContext().getSRFVDEF().toLowerCase());
            }
            script.Append("var _t = _1.get('%1$s');\r\n", (Object)"srfmajortext");
            script.Append("if(_t == null){_t = _1.get('%1$s'); }\r\n", (Object)"SRFMAJORTEXT");
            script.Append(BrowserJSHelper.getResetDialogReturnValue());
            script.Append("try{window.returnValue=SRFUtility.rd2obj(_SELECTROW.data);}catch(e){} ");
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"text", (String)"_t"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"value", (String)"_v"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
            script.Append(BrowserJSHelper.getCloseWindowScript());
            OkButton.getButtonConfig().setJSCode(script.toString());
        }
        SRFExButton CancelButton = new SRFExButton();
        CancelButton.InitConfig();
        CancelButton.setID("CancelButton");
        CancelButton.getButtonConfig().setText("\u53d6\u6d88\u64cd\u4f5c");
        CancelButton.getButtonConfig().setTips("\u53d6\u6d88\u64cd\u4f5c");
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

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFVDEF().toUpperCase())) {
            this.navFramePickupViewModel.setPickupValue(this.getDEHelper().GetKeyDEFHelper().getName());
        } else {
            this.navFramePickupViewModel.setPickupValue(this.getWebContext().getSRFVDEF());
        }
        this.navFramePickupViewModel.setPickupText("srfmajortext");
        return true;
    }

    @Override
    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.PICKUPVIEW", "\u9009\u62e9\u89c6\u56fe");
    }
}

