/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 */
package SA.SRFDA.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import java.io.Writer;

public class SRFDADPIFrame
extends SRFExIFrame {
    protected void OnRender(Writer writer) {
        super.OnRender(writer);
        String strIFMode = this.getIFrameConfig().GetExtValue("IFMODE", "NORMAL");
        String strFormItem = this.getIFrameConfig().GetExtValue("FORMITEM", "");
        if (StringHelper.Compare((String)strIFMode, (String)"DER1N", (boolean)true) == 0) {
            SRFExControl keyControl = this.getPage().getDefaultForm().FindControl(strFormItem);
            SRFExControl tempKeyControl = this.getPage().getDefaultForm().FindControl("SRFDATEMPKEYID");
            if (keyControl == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879[%1$s]", (Object)strFormItem));
                return;
            }
            if (tempKeyControl == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879[%1$s]", (Object)"SRFDATEMPKEYID"));
                return;
            }
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var _1=%1$s.G('%2$s');\r\n", (Object)this.getPage().getDefaultFormId(), (Object)keyControl.getUniqueID());
            script.Append("if(_1!=''){Ext.getDom('%1$s').src='%2$s'+'SRFEMBEDMODE=TRUE&%3$s='+_1;}\r\n", (Object)this.getUniqueID(), (Object)this.getIFrameConfig().getURL(), (Object)strFormItem);
            script.Append("else{if(_1==''){_1=%1$s.G('%2$s');}\r\n", (Object)this.getPage().getDefaultFormId(), (Object)tempKeyControl.getUniqueID());
            script.Append("if(_1==''){Ext.getDom('%1$s').src='about:blank';}\r\n", (Object)this.getUniqueID());
            script.Append("else{Ext.getDom('%1$s').src='%2$s'+'SRFEMBEDMODE=TRUE&SRFTEMPDATA=TRUE&%3$s='+_1;}}\r\n", (Object)this.getUniqueID(), (Object)this.getIFrameConfig().getURL(), (Object)strFormItem);
            this.getPage().RegisterOnReadyScript(5, script.toString());
            this.getPage().RegisterOnReadyScript(5, FormJSHelper.getOnFormFillEventScript((SRFExForm)((SRFExForm)this.getPage().getDefaultForm()), (String)script.toString()));
            return;
        }
        if (StringHelper.Compare((String)strIFMode, (String)"NORMAL", (boolean)true) == 0) {
            SRFExControl keyControl = this.getPage().getDefaultForm().FindControl(strFormItem);
            if (keyControl == null) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8868\u5355\u9879[%1$s]", (Object)strFormItem));
                return;
            }
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var _1=%1$s.G('%2$s');", (Object)this.getPage().getDefaultFormId(), (Object)keyControl.getUniqueID());
            script.Append("if(_1!=''){Ext.getDom('%1$s').src='%2$s'+'%3$s='+_1;}", (Object)this.getUniqueID(), (Object)this.getIFrameConfig().getURL(), (Object)strFormItem);
            script.Append("else{Ext.getDom('%1$s').src='about:blank';}", (Object)this.getUniqueID());
            this.getPage().RegisterOnReadyScript(5, script.toString());
            this.getPage().RegisterOnReadyScript(5, FormJSHelper.getOnFormFillEventScript((SRFExForm)((SRFExForm)this.getPage().getDefaultForm()), (String)script.toString()));
            return;
        }
    }
}

