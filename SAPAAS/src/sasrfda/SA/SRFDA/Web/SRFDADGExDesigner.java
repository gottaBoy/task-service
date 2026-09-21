/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExHidden
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web;

import SA.SRFDA.Web.UI.DGExDesignerConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExHidden;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDADGExDesigner
extends SRFExHidden {
    private static final Log log = LogFactory.getLog(SRFDADGExDesigner.class);
    protected DGExDesignerConfig dgExDesignerConfig = null;

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new DGExDesignerConfig();
    }

    public DGExDesignerConfig getDGExDesignerConfig() {
        return this.dgExDesignerConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dgExDesignerConfig = null;
        if (this.config != null && this.config instanceof DGExDesignerConfig) {
            this.dgExDesignerConfig = (DGExDesignerConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            if (this.getForm() == null) {
                writer.write("\u6ca1\u6709\u627e\u5230\u63a7\u4ef6\u7684\u8868\u5355\u5bf9\u8c61");
                log.error((Object)"\u6ca1\u6709\u627e\u5230\u63a7\u4ef6\u7684\u8868\u5355\u5bf9\u8c61");
                return;
            }
            String strDEFormItemId = this.dgExDesignerConfig.getDEFormItem();
            if (StringHelper.IsNullOrEmpty((String)strDEFormItemId)) {
                writer.write("\u6ca1\u6709\u627e\u5230\u5b9e\u4f53\u8868\u5355\u9879\u7f16\u53f7");
                log.error((Object)"\u6ca1\u6709\u627e\u5230\u5b9e\u4f53\u8868\u5355\u9879\u7f16\u53f7");
                return;
            }
            SRFExControl control = this.getForm().FindControl(strDEFormItemId);
            if (control == null) {
                String strError = StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230[%1$s]\u8868\u5355\u5bf9\u8c61", (Object)strDEFormItemId);
                writer.write(strError);
                log.error((Object)strError);
                return;
            }
            writer.write(StringHelper.Format((String)"<IFRAME id='if_%1$s' name='if_%1$s' frameborder='0' style='width:100%%;height:600px'></IFRAME>", (Object)this.getUniqueID()));
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.form['%1$s'].on('valuechanged',function(_1,_I){if(_I == '%2$s'){var _V=%1$s.G(_I);var _IFRAME=Ext.getDom('if_%3$s');_IFRAME.src='../srfds/dgexdesigner.jsp?SRFCTRLID=%3$s&SRFSFMODE=%4$s&SRFDEFGROUPSFMODE=%5$s&SRFDEID='+_V;}});", (Object)this.getForm().getFormId(), (Object)control.getUniqueID(), (Object)this.getUniqueID(), (Object)(this.OnGetSearchFormMode() ? "TRUE" : "FALSE"), (Object)(this.OnGetDEFGroupSFMode() ? "TRUE" : "FALSE"));
            script.Append("Ext.EventManager.on(window,'unload',function(){");
            script.Append("SRFRemoveIframe('if_%1$s');", (Object)this.getUniqueID());
            script.Append("});");
            this.getPage().RegisterOnReadyScript(3, script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected boolean OnGetSearchFormMode() {
        return false;
    }

    protected boolean OnGetDEFGroupSFMode() {
        return false;
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
            return super.getItemValueJSCall(bGetMode);
        }
        return StringHelper.Format((String)"if(_V==$FGV(_ID))break;  $FSV(_ID,_V);var _IFRAME = Ext.getDom('if_%1$s');_IFRAME.src = _IFRAME.src;", (Object)this.getUniqueID());
    }
}

