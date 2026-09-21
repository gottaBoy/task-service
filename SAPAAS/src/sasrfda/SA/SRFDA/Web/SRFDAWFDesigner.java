/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExHidden
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 */
package SA.SRFDA.Web;

import SA.SRFDA.Web.UI.WFDesignerConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import java.io.Writer;

public class SRFDAWFDesigner
extends SRFExHidden {
    protected WFDesignerConfig pickupExConfig = null;
    private static String strImage = "../sasrfex/images/default/icon_gear.png";
    private static String strDisableImage = "../sasrfex/images/default/icon_gear2.png";

    protected void OnInit() {
        super.OnInit();
    }

    protected XMLConfig CreateConfig() {
        return new WFDesignerConfig();
    }

    public WFDesignerConfig getWFDesignerConfig() {
        return this.pickupExConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.pickupExConfig = null;
        if (this.config != null && this.config instanceof WFDesignerConfig) {
            this.pickupExConfig = (WFDesignerConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            String strScript = "";
            strScript = StringHelper.Format((String)"$P.picker['%1$s'].pickup();", (Object)this.getUniqueID());
            writer.write(String.format("<span style='padding:6px;'><A onclick=\"javascript:%1$s\" href='#'><span class='sx-normaltext'>\u70b9\u51fb\u914d\u7f6e</span><IMG id='IMG_%4$s' src=\"%2$s\"  border=\"0\" alt=\"%3$s\" align='absmiddle'></A><span>", strScript, strImage, "\u70b9\u51fb\u914d\u7f6e\u5de5\u4f5c\u6d41", this.getUniqueID()));
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.picker['%1$s']={};$P.picker['%1$s'].enable=true;", (Object)this.getUniqueID());
            script.Append("$P.picker['%1$s'].pickup = function(){", (Object)this.getUniqueID());
            script.Append("if(!$P.picker['%1$s'].enable)return;", (Object)this.getUniqueID());
            String strAppendParams = "";
            String strDialogURL = "../srfwf/wfdesigner.jsp";
            int nDialogWidth = 1000;
            int nDialogHeight = 700;
            String strDialogResizable = "no";
            String strDialogScroll = "no";
            String strDialogStatus = "no";
            strAppendParams = this.getPage().getWebContext().GetParamsString(strAppendParams);
            if (StringHelper.Length((String)strAppendParams) > 0) {
                strDialogURL = strDialogURL.indexOf("?") == -1 ? String.valueOf(strDialogURL) + "?" : String.valueOf(strDialogURL) + "&";
                strDialogURL = String.valueOf(strDialogURL) + strAppendParams;
            }
            strDialogURL = strDialogURL.indexOf("?") == -1 ? String.valueOf(strDialogURL) + "?" : String.valueOf(strDialogURL) + "&";
            script.Append("if(Ext.getDom('IMG_%1$s').style.visibility == 'hidden') return;", (Object)this.getUniqueID());
            script.Append("var _URL = '%1$s';", (Object)strDialogURL);
            script.Append("var _PARAMS = {};");
            script.Append("_PARAMS['%1$s']=%2$s.G('%3$s');", (Object)"xmlcontent", (Object)this.getForm().getFormId(), (Object)this.getUniqueID());
            script.Append(BrowserJSHelper.getShowDialogScript(null, (String)"_URL", (String)"_PARAMS", (int)nDialogWidth, (int)nDialogHeight, (String)strDialogResizable, (String)strDialogScroll, (String)strDialogStatus));
            script.Append("var _ret = 'cancel';\r\n");
            script.Append("if(_DIALOGRESULT!=null && _DIALOGRESULT!= undefined && _DIALOGRESULT.ret != undefined)\r\n ");
            script.Append("_ret =_DIALOGRESULT.ret; \r\n");
            script.Append("if(_ret=='ok'){");
            script.Append("var _value = $V(_DIALOGRESULT.value,'');");
            script.Append("Ext.getDom('%1$s').value= _value;", (Object)this.getUniqueID());
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

    public String getItemEnableStateJSCall() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$P.picker['%1$s'].enable = _V;", (Object)this.getUniqueID());
        script.Append("Ext.getDom('IMG_%1$s').src = _V?'%2$s':'%3$s';", (Object)this.getUniqueID(), (Object)strImage, (Object)strDisableImage);
        return script.toString();
    }

    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return "_V=$FGV(_ID);";
        }
        return StringHelper.Format((String)"$FSV(_ID,_V);");
    }
}

