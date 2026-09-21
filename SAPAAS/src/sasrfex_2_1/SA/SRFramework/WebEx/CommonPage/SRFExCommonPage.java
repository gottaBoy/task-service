/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.CommonPage;

import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;

public class SRFExCommonPage
extends SRFExPage {
    protected SRFExButton okButton = null;
    protected SRFExButton cancelButton = null;

    public SRFExCommonPage() {
        this.strResourceId = "";
        this.setMainPage(true);
        this.setDialogPage(true);
    }

    @Override
    protected void OnInitComponents() {
        super.OnInitComponents();
        this.okButton = new SRFExButton();
        this.okButton.InitConfig();
        this.okButton.setID("okButton");
        this.okButton.getButtonConfig().setText("\u786e\u5b9a");
        this.okButton.getButtonConfig().setTips("\u786e\u5b9a");
        this.AddControl(this.okButton);
        this.cancelButton = new SRFExButton();
        this.cancelButton.InitConfig();
        this.cancelButton.setID("cancelButton");
        this.cancelButton.getButtonConfig().setText("\u53d6\u6d88");
        this.cancelButton.getButtonConfig().setTips("\u53d6\u6d88");
        this.AddControl(this.cancelButton);
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue("ret", "'cancel'"));
        this.RegisterOnReadyScript(3, script.toString());
        script.Reset();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue("ret", "'cancel'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        this.cancelButton.getButtonConfig().setJSCode(script.toString());
    }

    @Override
    protected SRFExWebContext CreateWebContext() {
        return SRFExWebContext.Current(this);
    }

    public String RenderCommandBar() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(this.Render("okButton"));
        stringBuilder.Append(this.Render("cancelButton"));
        return stringBuilder.toString();
    }
}

