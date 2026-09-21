/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Button;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Button.SRFExButtonAjaxFailedAction;
import SA.SRFramework.WebEx.Button.SRFExButtonClickAction;
import SA.SRFramework.WebEx.Button.SRFExButtonIndicatorAction;
import SA.SRFramework.WebEx.Button.SRFExButtonRequestAction;
import SA.SRFramework.WebEx.SRFExBaseButton;
import SA.SRFramework.WebEx.Script.ButtonJSHelper;
import SA.SRFramework.WebEx.UI.AjaxButtonConfig;
import java.io.Writer;

public class SRFExAjaxButton
extends SRFExBaseButton {
    protected AjaxButtonConfig ajaxButtonConfig = null;
    protected SRFExButtonIndicatorAction indicatorAction = new SRFExButtonIndicatorAction();
    protected SRFExButtonRequestAction requestAction = null;
    protected SRFExButtonAjaxFailedAction ajaxFailedAction = null;
    protected SRFExButtonClickAction clickAction = null;

    public SRFExAjaxButton() {
        this.indicatorAction.setAjaxButton(this);
        this.requestAction = new SRFExButtonRequestAction();
        this.requestAction.setAjaxButton(this);
        this.ajaxFailedAction = new SRFExButtonAjaxFailedAction();
        this.ajaxFailedAction.setAjaxButton(this);
        this.clickAction = new SRFExButtonClickAction();
        this.clickAction.setAjaxButton(this);
    }

    @Override
    protected XMLConfig CreateConfig() {
        return new AjaxButtonConfig();
    }

    public SRFExButtonIndicatorAction getIndicatorAction() {
        return this.indicatorAction;
    }

    public SRFExButtonRequestAction getRequestAction() {
        return this.requestAction;
    }

    public SRFExButtonAjaxFailedAction getAjaxFailedAction() {
        return this.ajaxFailedAction;
    }

    public SRFExButtonClickAction getClickAction() {
        return this.clickAction;
    }

    public AjaxButtonConfig getAjaxButtonConfig() {
        if (this.ajaxButtonConfig == null) {
            this.InitConfig();
        }
        return this.ajaxButtonConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.ajaxButtonConfig = null;
        if (this.config != null && this.config instanceof AjaxButtonConfig) {
            this.ajaxButtonConfig = (AjaxButtonConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            writer.write(StringHelper.Format((String)"<DIV id='%1$s_indicator' class='loading-indicator'  style='background-color:#ffffcc;border:1px solid #aca899;position:absolute;z-index:20000;left:2;top:2;display:none;'>\u5904\u7406\u8fc7\u7a0b\u4e2d...</DIV>", (Object)this.getUniqueID()));
            this.getAjaxButtonConfig().setLoadingIndicator(StringHelper.Format((String)"%1$s_indicator", (Object)this.getUniqueID()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        super.OnRender(writer);
    }

    @Override
    protected void RegisterJSCode() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.getBaseButtonJSCode());
        script.Append("button.ajax = {_BTNID:'%1$s',_BTN:button", this.getUniqueID());
        if (this.indicatorAction != null) {
            script.Append(",");
            this.indicatorAction.Render(script.getWriter());
        }
        if (this.requestAction != null) {
            script.Append(",");
            this.requestAction.Render(script.getWriter());
        }
        if (this.ajaxFailedAction != null) {
            script.Append(",");
            this.ajaxFailedAction.Render(script.getWriter());
        }
        if (this.clickAction != null) {
            script.Append(",");
            this.clickAction.Render(script.getWriter());
        }
        script.Append("};\r\n");
        if (StringHelper.Length((String)this.getAjaxButtonConfig().getConfirm()) > 0) {
            script.Append("button.on('click',function(_1,_2){if(!confirm('%1$s')) return;%2$s});\r\n", this.getAjaxButtonConfig().getConfirm(), ButtonJSHelper.getAjaxButtonClickActionScript(this.getUniqueID()));
        } else {
            script.Append("button.on('click',function(_1,_2){%1$s});\r\n", ButtonJSHelper.getAjaxButtonClickActionScript(this.getUniqueID()));
        }
        this.getPage().RegisterOnReadyScript(2, script.toString());
        script.Reset();
    }

    public String getRemotePath() {
        if (StringHelper.Length((String)this.getAjaxButtonConfig().getRemotePath()) == 0) {
            return this.getPage().getDefaultBackEndUrl();
        }
        return this.getAjaxButtonConfig().getRemotePath();
    }

    public void setRemotePath(String strRemotePath) {
        this.getAjaxButtonConfig().setRemotePath(strRemotePath);
    }
}

