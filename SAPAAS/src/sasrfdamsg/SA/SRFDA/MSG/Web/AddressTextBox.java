/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExTextBox
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.MSG.Web;

import SA.SRFDA.MSG.Web.UI.AddressTextBoxConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.Writer;

public class AddressTextBox
extends SRFExTextBox {
    protected AddressTextBoxConfig addressTextBoxConfig = null;

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new AddressTextBoxConfig();
    }

    public AddressTextBoxConfig getAddressTextBoxConfig() {
        return this.addressTextBoxConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.addressTextBoxConfig = null;
        if (this.config != null && this.config instanceof AddressTextBoxConfig) {
            this.addressTextBoxConfig = (AddressTextBoxConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    protected void OnRender(Writer writer) {
        try {
            String strScript = "";
            strScript = StringHelper.Format((String)"$P.picker['%1$s'].pickup();", (Object)this.getUniqueID());
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.picker['%1$s']={};$P.picker['%1$s'].enable=true;", (Object)this.getUniqueID());
            this.getAddressTextBoxConfig().setTextMode(3);
            if (this.getBaseControlConfig().getWidthEx() == 0.0) {
                writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            } else {
                writer.write(StringHelper.Format((String)"<table  border='0' cellspacing='0' cellpadding='0' style='width:%1$s'>", (Object)this.getBaseControlConfig().getWidthString()));
            }
            writer.write("<tr><td>");
            double nLastWidth = this.getBaseControlConfig().getWidthEx();
            if (this.getBaseControlConfig().getWidthEx() >= 1.0) {
                this.getAddressTextBoxConfig().setWidthEx(1.0);
                super.OnRender(writer);
                this.getAddressTextBoxConfig().setWidthEx(nLastWidth);
            } else {
                super.OnRender(writer);
            }
            writer.write("</td><td width='20' >");
            writer.write(String.format("<A onclick=\"javascript:%1$s\" href='#'><IMG id='IMG_%4$s' src=\"%2$s\"  border=\"0\" alt=\"%3$s\"></A>", strScript, this.getAddressTextBoxConfig().getImage(), this.getAddressTextBoxConfig().getTipMessage(), this.getUniqueID()));
            writer.write("</td><td width='8'>&nbsp;");
            writer.write("</td></tr></table>");
            script.Append("$P.picker['%1$s'].pickup = function(){", (Object)this.getUniqueID());
            script.Append("if(!$P.picker['%1$s'].enable)return;", (Object)this.getUniqueID());
            String strDialogURL = "";
            int nDialogWidth = 800;
            int nDialogHeight = 600;
            String strDialogResizable = "no";
            String strDialogScroll = "no";
            String strDialogStatus = "no";
            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
            script.Append("if(Ext.getDom('IMG_%1$s').style.visibility == 'hidden') return;", (Object)this.getUniqueID());
            script.Append("var _URL = '%1$s';", (Object)strDialogURL);
            script.Append("var _PARAMS = {};");
            script.Append("_URL+=Ext.urlEncode(_PARAMS);");
            script.Append(BrowserJSHelper.getShowDialogScript(null, (String)"_URL", (String)"", (int)nDialogWidth, (int)nDialogHeight, (String)strDialogResizable, (String)strDialogScroll, (String)strDialogStatus));
            script.Append("var _ret = 'cancel';\r\n");
            script.Append("if(_DIALOGRESULT &&_DIALOGRESULT.ret!=undefined)\r\n ");
            script.Append("_ret =_DIALOGRESULT.ret; \r\n");
            script.Append("if(_ret=='ok'){");
            script.Append("var _text = $V(_DIALOGRESULT.text,'');");
            script.Append("var _value = $V(_DIALOGRESULT.value,'');");
            if (this.getForm() != null) {
                script.Append("$P.form['%1$s']._FORM.S('%2$s',_value);", (Object)this.getForm().getFormId(), (Object)this.getUniqueID());
            } else {
                script.Append("Ext.getDom('%1$s').value +=_value;", (Object)this.getUniqueID());
            }
            script.Append("}else{");
            script.Append("}");
            script.Append("};");
            this.getPage().RegisterOnReadyScript(3, script.toString());
            script.Reset();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

