/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListBoxPickupWriter
extends BaseFormCtrlWriter {
    private static final Log log = LogFactory.getLog(ListBoxPickupWriter.class);
    public static final String DEFAULT_MSPICKUPPAGEID = "PAGE_00014";
    public static final String TAG_LISTBOXPICKUPVALUEASXML = "LISTBOXPICKUPVALUEASXML";

    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXLISTBOXPICKUP");
        ctrlNode.SetValue("VALUEASXML", this.GetValueAsXML(bSearchMode, ctrlParams));
        ctrlNode.SetValue("SEPARATOR", bSearchMode ? ";" : ListBoxPickupWriter.GetCtrlParam(ctrlParams, "SEPARATOR", "|"));
        this.AppendPickupConfig(ctrlNode, iDEFHelper, formCtrlConfig, bSearchMode, ctrlParams);
        return ctrlNode;
    }

    protected void AppendPickupConfig(XMLNode ctrlNode, IDEFHelper iDEFHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        String strAppendURLParams;
        String strPickupDEId = ListBoxPickupWriter.GetCtrlParam(ctrlParams, "PICKUPDE", "");
        String strPickupPageId = ListBoxPickupWriter.GetCtrlParam(ctrlParams, "PICKUPPAGEID", "");
        String strDialogURL = ListBoxPickupWriter.GetCtrlParam(ctrlParams, "DIALOGURL", "");
        if (StringHelper.IsNullOrEmpty((String)strPickupDEId) && StringHelper.IsNullOrEmpty((String)strPickupPageId) && StringHelper.IsNullOrEmpty((String)strDialogURL)) {
            log.error((Object)"\u9009\u62e9\u9875\u9762\u914d\u7f6e\u65e0\u6548\uff0c\u5b9e\u4f53\u3001\u9875\u9762\u3001\u9875\u9762\u8def\u5f84\u5fc5\u987b\u81f3\u5c11\u6307\u5b9a\u4e00\u4e2a");
            return;
        }
        int nDialogWidth = 990;
        int nDialogHeight = 600;
        if (StringHelper.IsNullOrEmpty((String)strDialogURL)) {
            if (!StringHelper.IsNullOrEmpty((String)strPickupDEId) && StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                IDEHelper iPickupDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strPickupDEId);
                if (iPickupDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPickupDEId));
                    return;
                }
                strPickupPageId = iPickupDEHelper.GetMPickupPageId();
                if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                    strPickupPageId = DEFAULT_MSPICKUPPAGEID;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                Page pickupPage = this.globalHelperEx.getDAModelStorage().FindPage(strPickupPageId);
                if (pickupPage == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u9009\u62e9\u9875\u9762[%1$s]", (Object)strPickupPageId));
                    return;
                }
                strDialogURL = URLHelper.AppendURLSeperator((String)pickupPage.GetTotalPagePath());
                if (StringHelper.IsNullOrEmpty((String)strPickupDEId)) {
                    strPickupDEId = pickupPage.getDEID();
                }
                if (pickupPage.getWIDTH() != 0) {
                    nDialogWidth = pickupPage.getWIDTH();
                }
                if (pickupPage.getHEIGHT() != 0) {
                    nDialogHeight = pickupPage.getHEIGHT();
                }
            }
            strDialogURL = String.valueOf(strDialogURL) + StringHelper.Format((String)"SRFDEID=%1$s", (Object)strPickupDEId);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strAppendURLParams = this.GetAppendURLParams(ctrlParams)))) {
            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
            strDialogURL = String.valueOf(strDialogURL) + strAppendURLParams;
        }
        String strDialogResizable = ListBoxPickupWriter.GetCtrlParam(ctrlParams, "DIALOGRESIZABLE", "yes");
        String strDialogScroll = ListBoxPickupWriter.GetCtrlParam(ctrlParams, "DIALOGSCROLL", "yes");
        String strDialogStatus = ListBoxPickupWriter.GetCtrlParam(ctrlParams, "DIALOGSTATUS", "no");
        ctrlNode.SetValue("DIALOGURL", strDialogURL);
        ctrlNode.SetValue("DIALOGWIDTH", ListBoxPickupWriter.GetCtrlParam(ctrlParams, "DIALOGWIDTH", String.valueOf(nDialogWidth)));
        ctrlNode.SetValue("DIALOGHEIGHT", ListBoxPickupWriter.GetCtrlParam(ctrlParams, "DIALOGHEIGHT", String.valueOf(nDialogHeight)));
        ctrlNode.SetValue("DIALOGRESIZABLE", strDialogResizable);
        ctrlNode.SetValue("DIALOGSCROLL", strDialogScroll);
        ctrlNode.SetValue("DIALOGSTATUS", strDialogStatus);
        ctrlNode.SetValue("APPENDFORMPARAMS", ListBoxPickupWriter.GetCtrlParam(ctrlParams, "APPENDFORMPARAMS", ""));
    }

    protected String GetValueAsXML(boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        if (bSearchMode) {
            return "FALSE";
        }
        if (ctrlParams == null) {
            return "TRUE";
        }
        String strValueAsXML = ctrlParams.get("VALUEASXML");
        if (StringHelper.IsNullOrEmpty((String)strValueAsXML)) {
            return this.globalHelperEx.getWebExConfig().GetValue("SRFDA", TAG_LISTBOXPICKUPVALUEASXML, "TRUE");
        }
        return strValueAsXML;
    }

    protected String GetAppendURLParams(TreeMap<String, String> ctrlParams) {
        return ListBoxPickupWriter.GetCtrlParam(ctrlParams, "APPENDURLPARAMS", this.formCtrlHelperConfig.GetExtValue("APPENDURLPARAMS", ""));
    }
}

