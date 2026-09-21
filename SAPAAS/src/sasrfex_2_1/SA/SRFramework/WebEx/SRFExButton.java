/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExBaseButton;
import SA.SRFramework.WebEx.UI.ButtonConfig;

public class SRFExButton
extends SRFExBaseButton {
    protected ButtonConfig buttonConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new ButtonConfig();
    }

    public ButtonConfig getButtonConfig() {
        if (this.buttonConfig == null) {
            this.InitConfig();
        }
        return this.buttonConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.buttonConfig = null;
        if (this.config != null && this.config instanceof ButtonConfig) {
            this.buttonConfig = (ButtonConfig)this.config;
        }
    }

    @Override
    protected void RegisterJSCode() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.getBaseButtonJSCode());
        if (StringHelper.Length((String)this.getButtonConfig().getJSCode()) > 0) {
            if (StringHelper.Length((String)this.getButtonConfig().getConfirm()) > 0) {
                script.Append("button.on('click',function(_1,_2){if(!confirm('%1$s')) return; %2$s});\r\n", this.getButtonConfig().getConfirm(), this.getButtonConfig().getJSCode());
            } else {
                script.Append("button.on('click',function(_1,_2){%1$s});\r\n", this.getButtonConfig().getJSCode());
            }
        }
        this.getPage().RegisterOnReadyScript(2, script.toString());
    }
}

