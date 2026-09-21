/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.FormCtrlHelper.TextBoxWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;

public class TextAreaCaretWriter
extends TextBoxWriter {
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        IDEFFormCtrl iFormCtrl;
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXTEXTBOX");
        ctrlNode.SetValue("TEXTBOXMODE", "Caret");
        int nRowCount = 5;
        if (this.formCtrlHelperConfig.IsContainsKey("ROWS") && (nRowCount = this.formCtrlHelperConfig.GetExtValue("ROWS", nRowCount)) <= 0) {
            nRowCount = 5;
        }
        ctrlNode.SetValue("HEIGHT", StringHelper.Format((String)"%1$s", (Object)(nRowCount * 20)));
        ctrlNode.SetValue("ACLISTWIDTH", this.GetACListWidth(ctrlParams));
        ctrlNode.SetValue("ACUSERPARAMS", this.GetACUserParams(ctrlParams));
        ctrlNode.SetValue("ACCARETFORMPARAMS", this.GetACCaretFormParams(ctrlParams, iDEFHelper.getDEField().getDEFNAME()));
        String strACDataURL = this.GetACDataURL(ctrlParams);
        if (!StringHelper.IsNullOrEmpty((String)strACDataURL)) {
            ctrlNode.SetValue("ACDATAURL", strACDataURL);
        }
        if ((iFormCtrl = iDEFHelper.GetFormCtrl()).IsReadonly()) {
            ctrlNode.SetValue("READONLY", "TRUE");
        }
        return ctrlNode;
    }

    @Override
    protected String GetACDataURL(TreeMap<String, String> ctrlParams) {
        String strACDataURL = "";
        String strACAppendStaticParams = "";
        if (ctrlParams != null) {
            strACAppendStaticParams = ctrlParams.get("ACAPPENDSTATICPARAMS");
        }
        if (StringHelper.IsNullOrEmpty((String)strACAppendStaticParams)) {
            return "";
        }
        strACDataURL = this.globalHelperEx.getWebConfig().GetExtValue("AUTOCOMPLETE", "");
        if (strACDataURL.lastIndexOf("?") <= 0) {
            strACDataURL = String.valueOf(strACDataURL) + "?";
        }
        String[] arrACAppendStaticParams = strACAppendStaticParams.split("[,]");
        int i = 0;
        while (i < arrACAppendStaticParams.length) {
            String strACAppendParam = arrACAppendStaticParams[i];
            String[] arrACAppendParam = strACAppendParam.split("[|]");
            if (arrACAppendParam.length == 2) {
                if (i > 0) {
                    strACDataURL = String.valueOf(strACDataURL) + "&amp;";
                }
                strACDataURL = String.valueOf(strACDataURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)arrACAppendParam[0], (Object)arrACAppendParam[1]);
            }
            ++i;
        }
        return strACDataURL;
    }

    protected String GetACCaretFormParams(TreeMap<String, String> ctrlParams, String strDefault) {
        String strACCaretFormParams = "";
        if (ctrlParams != null) {
            strACCaretFormParams = ctrlParams.get("ACCARETFORMPARAMS");
        }
        if (StringHelper.IsNullOrEmpty((String)strACCaretFormParams)) {
            String strCaretTemplateDE = this.GetCaretTemplateDE(ctrlParams);
            strACCaretFormParams = StringHelper.Compare((String)strCaretTemplateDE, (String)"DE0110", (boolean)true) == 0 ? String.valueOf(strDefault) + "|CARETWORD" : strDefault;
        }
        return strACCaretFormParams;
    }

    @Override
    protected String GetACUserParams(TreeMap<String, String> ctrlParams) {
        String strACUserMode = "";
        if (ctrlParams != null) {
            strACUserMode = ctrlParams.get("ACUSERMODE");
        }
        String strACUserParams = StringHelper.Format((String)"srfdeid:'%1$s'", (Object)this.GetCaretTemplateDE(ctrlParams));
        if (!StringHelper.IsNullOrEmpty((String)strACUserMode)) {
            strACUserParams = String.valueOf(strACUserParams) + StringHelper.Format((String)",acusermode:'%1$s'", (Object)strACUserMode);
        }
        return strACUserParams;
    }

    @Override
    protected String GetCaretTemplateDE(TreeMap<String, String> ctrlParams) {
        String strCaretTemplateDE;
        if (ctrlParams != null && !StringHelper.IsNullOrEmpty((String)(strCaretTemplateDE = ctrlParams.get("SRFDEID")))) {
            return strCaretTemplateDE;
        }
        return this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "CARETTEMPLATEDE", "DE0110");
    }

    @Override
    protected String GetACListWidth(TreeMap<String, String> ctrlParams) {
        String strACListWidth = "";
        if (ctrlParams != null) {
            strACListWidth = ctrlParams.get("ACLISTWIDTH");
            ctrlParams.remove("ACLISTWIDTH");
            if (!StringHelper.IsNullOrEmpty((String)strACListWidth)) {
                return strACListWidth;
            }
        }
        return this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "ACLISTWIDTH", "400");
    }
}

