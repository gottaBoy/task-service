/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TextBoxWriter
extends BaseFormCtrlWriter {
    private static final Log log = LogFactory.getLog(TextBoxWriter.class);
    public static final String TAG_ACUSERMODE = "ACUSERMODE";
    public static final String TAG_ACMODE = "ACMODE";

    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXTEXTBOX");
        if (this.formCtrlHelperConfig.GetExtValue("PASSWORD", false)) {
            ctrlNode.SetValue("TEXTBOXMODE", "Password");
        } else {
            String strACMode = this.GetCtrlParams(ctrlParams, TAG_ACMODE, "");
            String strCaretTemplGroupId = iDEFHelper.getCaretTemplGroupId();
            if (!StringHelper.IsNullOrEmpty((String)strCaretTemplGroupId) || !StringHelper.IsNullOrEmpty((String)strACMode)) {
                String strACDataURL;
                String strACAppendFormParams = TextBoxWriter.GetCtrlParam(ctrlParams, "ACAPPENDFORMPARAMS", "");
                ctrlNode.SetValue("ACAPPENDFORMPARAMS", strACAppendFormParams);
                if (StringHelper.Compare((String)strACMode, (String)"TRUE", (boolean)false) == 0) {
                    ctrlNode.SetValue(TAG_ACMODE, "SRFDAAC");
                } else {
                    ctrlNode.SetValue(TAG_ACMODE, strACMode);
                }
                boolean bHideACTrigger = this.IsHideACTrigger(ctrlParams);
                ctrlNode.SetValue("ACHIDETRIGGER", bHideACTrigger ? "TRUE" : "FALSE");
                if (!bHideACTrigger) {
                    ctrlNode.SetValue("ACWIDTHMODE", "TRUE");
                }
                ctrlNode.SetValue("FORCESELECTION", "FALSE");
                String strACUserParams = this.GetACUserParams(ctrlParams);
                if (!StringHelper.IsNullOrEmpty((String)strCaretTemplGroupId)) {
                    if (!StringHelper.IsNullOrEmpty((String)strACUserParams)) {
                        strACUserParams = String.valueOf(strACUserParams) + ",";
                    }
                    strACUserParams = String.valueOf(strACUserParams) + StringHelper.Format((String)"n_carettemplgroupid_eq:'%1$s'", (Object)strCaretTemplGroupId);
                }
                if (!StringHelper.IsNullOrEmpty((String)(strACDataURL = this.GetACDataURL(ctrlParams)))) {
                    ctrlNode.SetValue("ACDATAURL", strACDataURL);
                }
                ctrlNode.SetValue("ACUSERPARAMS", strACUserParams);
                ctrlNode.SetValue("ACLISTWIDTH", this.GetACListWidth(ctrlParams));
                ctrlNode.SetValue("ACCARETFORMPARAMS", this.GetACCaretFormParams(ctrlParams));
                ctrlNode.SetValue("ACMINCHARS", this.GetACMinchars(ctrlParams));
            }
        }
        IDEFFormCtrl iFormCtrl = iDEFHelper.GetFormCtrl();
        if (iFormCtrl.IsReadonly()) {
            ctrlNode.SetValue("READONLY", "TRUE");
        }
        return ctrlNode;
    }

    protected String GetCtrlParams(TreeMap<String, String> ctrlParams, String strAttr, String strDefault) {
        String strCtrlParamsValue = strDefault;
        if (ctrlParams != null) {
            strCtrlParamsValue = ctrlParams.get(strAttr);
            ctrlParams.remove(strAttr);
            if (StringHelper.IsNullOrEmpty((String)strCtrlParamsValue)) {
                return strDefault;
            }
        }
        return strCtrlParamsValue;
    }

    protected String GetACListWidth(TreeMap<String, String> ctrlParams) {
        String strACListWidth = this.GetCtrlParams(ctrlParams, "ACLISTWIDTH", "");
        if (!StringHelper.IsNullOrEmpty((String)strACListWidth)) {
            return strACListWidth;
        }
        return this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "ACLISTWIDTH", "400");
    }

    protected boolean IsEnableAC(TreeMap<String, String> ctrlParams) {
        boolean bDefault = StringHelper.Compare((String)this.GetCtrlParams(ctrlParams, "AC", "FALSE"), (String)"TRUE", (boolean)true) == 0;
        return this.formCtrlHelperConfig.GetExtValue("AC", bDefault);
    }

    protected boolean IsHideACTrigger(TreeMap<String, String> ctrlParams) {
        boolean bDefault = StringHelper.Compare((String)this.GetCtrlParams(ctrlParams, "ACHIDETRIGGER", "TRUE"), (String)"TRUE", (boolean)true) == 0;
        return this.formCtrlHelperConfig.GetExtValue("ACHIDETRIGGER", bDefault);
    }

    protected String GetACMinchars(TreeMap<String, String> ctrlParams) {
        String strACMinchars = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "ACMINCHARS", "2");
        if (ctrlParams != null) {
            strACMinchars = ctrlParams.get("ACMINCHARS");
            ctrlParams.remove("ACMINCHARS");
        }
        return strACMinchars;
    }

    @Override
    protected XMLNode OnGetDGEditor(IDEFHelper helper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModeDetail) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXDATAGRIDTEXTEDITOR");
        return ctrlNode;
    }

    protected String GetCaretTemplateDE(TreeMap<String, String> ctrlParams) {
        String strCaretTemplateDE;
        if (ctrlParams != null && !StringHelper.IsNullOrEmpty((String)(strCaretTemplateDE = ctrlParams.get("SRFDEID")))) {
            return strCaretTemplateDE;
        }
        return this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "CARETTEMPLATEDE", "DE0110");
    }

    protected String GetACCaretFormParams(TreeMap<String, String> ctrlParams) {
        String strACCaretFormParams = "";
        if (ctrlParams != null) {
            strACCaretFormParams = ctrlParams.get("ACCARETFORMPARAMS");
            ctrlParams.remove("ACCARETFORMPARAMS");
            return strACCaretFormParams;
        }
        return "";
    }

    protected String GetACUserParams(TreeMap<String, String> ctrlParams) {
        String strACUserMode = "";
        if (ctrlParams != null) {
            strACUserMode = ctrlParams.get(TAG_ACUSERMODE);
        }
        String strACUserParams = StringHelper.Format((String)"srfdeid:'%1$s'", (Object)this.GetCaretTemplateDE(ctrlParams));
        if (!StringHelper.IsNullOrEmpty((String)strACUserMode)) {
            strACUserParams = String.valueOf(strACUserParams) + StringHelper.Format((String)",acusermode:'%1$s'", (Object)strACUserMode);
        }
        return strACUserParams;
    }

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
}

