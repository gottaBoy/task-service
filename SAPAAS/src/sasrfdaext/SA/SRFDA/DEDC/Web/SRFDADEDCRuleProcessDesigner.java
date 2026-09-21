/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExHidden
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.DEDC.Web;

import SA.SRFDA.DEDC.Web.UI.DEDCRuleProcessDesignerConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExHidden;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDADEDCRuleProcessDesigner
extends SRFExHidden {
    private static final Log log = LogFactory.getLog(SRFDADEDCRuleProcessDesigner.class);
    protected DEDCRuleProcessDesignerConfig ruleProcessDesignerConfig = null;

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new DEDCRuleProcessDesignerConfig();
    }

    public DEDCRuleProcessDesignerConfig getDEDCRuleProcessDesignerConfig() {
        return this.ruleProcessDesignerConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.ruleProcessDesignerConfig = null;
        if (this.config != null && this.config instanceof DEDCRuleProcessDesignerConfig) {
            this.ruleProcessDesignerConfig = (DEDCRuleProcessDesignerConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            writer.write(StringHelper.Format((String)"<IFRAME id='if_%1$s' name='if_%1$s' frameborder='0' style='width:100%%;height:500px'  ></IFRAME>", (Object)this.getUniqueID()));
            StringBuilderEx script = new StringBuilderEx();
            script.Append("if(true){var _IFRAME = Ext.getDom('if_%1$s');_IFRAME.src='../srfdedc/ruleprocessdesigner.jsp?SRFCTRLID=%1$s';}", (Object)this.getUniqueID());
            script.Append("Ext.EventManager.on(window, 'unload', function() {");
            script.Append("SRFRemoveIframe('if_%1$s');", (Object)this.getUniqueID());
            script.Append("});");
            this.getPage().RegisterOnReadyScript(3, script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getItemEnableStateJSCall() {
        StringBuilderEx script = new StringBuilderEx();
        return script.toString();
    }

    public void setEnabled(boolean bEnabled) {
        super.setEnabled(bEnabled);
    }

    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var _1 = Ext.getDom('if_%1$s');", (Object)this.getUniqueID());
            script.Append("if(_1 && _1.contentWindow && _1.contentWindow.exportxml){_1.contentWindow.exportxml();}");
            script.Append(super.getItemValueJSCall(bGetMode));
            return script.toString();
        }
        return StringHelper.Format((String)"if(_V==$FGV(_ID))break;$FSV(_ID,_V);var _IFRAME = Ext.getDom('if_%1$s');_IFRAME.src = _IFRAME.src;", (Object)this.getUniqueID());
    }
}

