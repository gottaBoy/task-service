/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.CommonPage;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.CommonPage.SRFExCommonPage;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;

public class SRFExTextAreaPage
extends SRFExCommonPage {
    protected SRFExTextBox textBox = null;

    @Override
    protected void OnInitComponents() {
        super.OnInitComponents();
        this.textBox = new SRFExTextBox();
        this.textBox.InitConfig();
        this.textBox.setID("textBox");
        this.textBox.getTextBoxConfig().setWidth(680);
        this.textBox.getTextBoxConfig().setHeight(430);
        this.textBox.getTextBoxConfig().setTextMode(1);
        this.textBox.getTextBoxConfig().setCssClass("textarea.x-form-field");
        this.AddControl(this.textBox);
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _V=window.dialogArguments;\r\n");
        script.Append("Ext.getDom('%1$s').value=SRFUtility.parsestring(_V);\r\n", this.textBox.getUniqueID());
        this.RegisterOnReadyScript(3, script.toString());
        script.Reset();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue("ret", "'ok'"));
        script.Append(BrowserJSHelper.getSetDialogReturnValue("value", StringHelper.Format((String)"Ext.getDom('%1$s').value", (Object)this.textBox.getUniqueID())));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        this.okButton.getButtonConfig().setJSCode(script.toString());
    }
}

