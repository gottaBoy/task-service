/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.BaseButtonConfig;
import java.io.Writer;

public abstract class SRFExBaseButton
extends SRFExControl {
    protected BaseButtonConfig baseButtonConfig = null;
    protected String strResourceId = null;

    public BaseButtonConfig getBaseButtonConfig() {
        if (this.baseButtonConfig == null) {
            this.InitConfig();
        }
        return this.baseButtonConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.baseButtonConfig = null;
        if (this.config != null && this.config instanceof BaseButtonConfig) {
            this.baseButtonConfig = (BaseButtonConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        if (!this.TestPrivilege()) {
            return;
        }
        try {
            writer.write("<DIV ");
            this.OutputID(writer);
            AttributeBuilder attributesBuilder = new AttributeBuilder();
            attributesBuilder.InitFromHashtable(this.getBaseButtonConfig().getExtAttributes(), true);
            this.FillAttributeBuilder(attributesBuilder);
            StyleBuilder styleBuilder = new StyleBuilder();
            this.FillStyleBuilder(styleBuilder);
            attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getBaseButtonConfig().getExtStyle());
            writer.write(attributesBuilder.ToOutputString());
            writer.write("></DIV>");
            this.RegisterJSCode();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void RegisterJSCode() {
    }

    protected String getBaseButtonJSCode() {
        String strScript = "";
        strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _E=Ext.getDom('%1$s');\r\n", (Object)this.getUniqueID());
        strScript = String.valueOf(strScript) + StringHelper.Format((String)"if(!(_E))return;\r\n");
        String strScriptOp = StringHelper.Format((String)"tooltipType:'title'");
        if (StringHelper.Length((String)this.getBaseButtonConfig().getText()) > 0) {
            strScriptOp = String.valueOf(strScriptOp) + StringHelper.Format((String)",text:'%1$s'", (Object)this.getBaseButtonConfig().getText());
        }
        if (StringHelper.Length((String)this.getBaseButtonConfig().getTips()) > 0) {
            strScriptOp = String.valueOf(strScriptOp) + StringHelper.Format((String)",tooltip:'%1$s'", (Object)this.getBaseButtonConfig().getTips());
        }
        if (this.getBaseButtonConfig().getWidthEx() > 1.0) {
            strScriptOp = String.valueOf(strScriptOp) + StringHelper.Format((String)",minWidth:%1$s", (Object)this.getBaseButtonConfig().getWidth());
        }
        if (!this.getBaseButtonConfig().getVisible()) {
            strScriptOp = String.valueOf(strScriptOp) + StringHelper.Format((String)",hidden:true");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getBaseButtonConfig().getIconCls())) {
            strScriptOp = String.valueOf(strScriptOp) + StringHelper.Format((String)", iconCls:'%1$s'", (Object)this.getBaseButtonConfig().getIconCls());
        }
        if (StringHelper.Length((String)this.getBaseButtonConfig().getRealCssClass()) > 0) {
            strScriptOp = String.valueOf(strScriptOp) + StringHelper.Format((String)",cls:'%1$s'", (Object)this.getBaseButtonConfig().getRealCssClass());
        }
        if (!this.getBaseButtonConfig().getEnabled()) {
            strScriptOp = String.valueOf(strScriptOp) + StringHelper.Format((String)",disabled:true");
        }
        strScriptOp = String.valueOf(strScriptOp) + StringHelper.Format((String)",renderTo:_E");
        strScript = String.valueOf(strScript) + StringHelper.Format((String)"var button=new Ext.Button({%1$s});\r\n", (Object)strScriptOp);
        strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.button['%1$s']=button;\r\n", (Object)this.getUniqueID());
        return strScript;
    }

    public String getResourceId() {
        String strPageResourceId;
        if (StringHelper.Length((String)this.strResourceId) == 0 && this.strResourceId == null && this.getPage() != null && StringHelper.Length((String)(strPageResourceId = this.getPage().getResourceId())) != 0) {
            strPageResourceId = strPageResourceId.replace("PAGE_", "");
            return StringHelper.Format((String)"BUTTON_%1$s.%2$s", (Object)strPageResourceId, (Object)this.getBaseButtonConfig().getID());
        }
        return this.strResourceId;
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }

    public boolean TestPrivilege() {
        String strResourceId = this.getResourceId();
        if (StringHelper.Length((String)strResourceId) != 0) {
            IUserPrivilegeMgr iUserPrivilegeMgr = this.getPage().getWebContext().GetUserPrivilegeMgr();
            iUserPrivilegeMgr.LogTest(this.getPage().getWebContext(), this, strResourceId);
            if (iUserPrivilegeMgr != null && !iUserPrivilegeMgr.Test(this.getPage().getWebContext(), strResourceId)) {
                return false;
            }
        }
        return true;
    }
}

