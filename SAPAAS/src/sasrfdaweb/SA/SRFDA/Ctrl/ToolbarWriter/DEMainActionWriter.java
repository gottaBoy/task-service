/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEMainActionHelper
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.DEBehaviorWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEMainActionWriter
extends DEBehaviorWriter {
    private static final Log log = LogFactory.getLog(DEMainActionWriter.class);

    @Override
    protected CallResult FillItemUserParams(XMLNode tbItemNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = super.FillItemUserParams(tbItemNode, tbItemConfig, deBehavior, context, bMenu);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEMainActionHelper iDEMainActionHelper = (IDEMainActionHelper)context.getAttribute("DEMAINACTION");
        tbItemNode.SetValue("UP_DEMAINACTION", iDEMainActionHelper.getName());
        if (StringHelper.Compare((String)deBehavior.getPROCESSTYPE(), (String)"FRONT", (boolean)true) == 0 && StringHelper.Compare((String)deBehavior.getFRONTPROTYPE(), (String)"SHOWPAGE", (boolean)true) == 0) {
            String strURL = "";
            int nWidth = 0;
            int nHeight = 0;
            boolean bShowModal = false;
            String strPageId = deBehavior.getPAGEID();
            if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u663e\u793a\u9875\u9762\u5bf9\u8c61");
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            Page showPage = this.globalHelperEx.getDAModelStorage().FindPage(strPageId);
            if (showPage == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strPageId, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (showPage.GetParamValue("ISMODELSTYLE") != null) {
                bShowModal = showPage.isMODALSTYLE();
            }
            if (!StringHelper.IsNullOrEmpty((String)showPage.GetTotalPagePath())) {
                strURL = showPage.GetTotalPagePath();
            }
            if (showPage.getWIDTH() != 0) {
                nWidth = showPage.getWIDTH();
            }
            if (showPage.getHEIGHT() != 0) {
                nHeight = showPage.getHEIGHT();
            }
            if (StringHelper.IsNullOrEmpty((String)showPage.getDEID())) {
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFDEID", (Object)context.getDEHelper().getId());
            }
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFDEMAINACTION", (Object)iDEMainActionHelper.getName());
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            if (StringHelper.IsNullOrEmpty((String)deBehavior.getURLAPPENDPARAM())) {
                if (StringHelper.Compare((String)deBehavior.getACTIONTARGET(), (String)"NONE", (boolean)true) != 0) {
                    strURL = String.valueOf(strURL) + "SRFDAKEYS=";
                }
            } else {
                strURL = String.valueOf(strURL) + deBehavior.getURLAPPENDPARAM();
            }
            boolean bHtmlMode = deBehavior.getHTMLMODE();
            tbItemNode.SetValue("UP_PAGEURL", strURL);
            tbItemNode.SetValue("UP_PAGEWIDTH", StringHelper.Format((String)"%1$s", (Object)nWidth));
            tbItemNode.SetValue("UP_PAGEHEIGHT", StringHelper.Format((String)"%1$s", (Object)nHeight));
            tbItemNode.SetValue("UP_PAGESHOWMODAL", bShowModal ? "TRUE" : "FALSE");
            tbItemNode.SetValue("UP_HTMLMODE", bHtmlMode ? "TRUE" : "FALSE");
        }
        return callResult;
    }

    @Override
    protected String GetItemHandler(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig) {
        return super.GetItemHandler(context, deBehavior, tbItemConfig);
    }

    @Override
    protected CallResult OnAfterExport(XMLNode tbNode, XMLNode pNode, XMLNode tbItemNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        return super.OnAfterExport(tbNode, pNode, tbItemNode, tbItemConfig, deBehavior, context, bMenu);
    }

    @Override
    protected String GetItemResourceId(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig) {
        String strResourceId = super.GetItemResourceId(context, deBehavior, tbItemConfig);
        if (!StringHelper.IsNullOrEmpty((String)strResourceId)) {
            return strResourceId;
        }
        IDEMainActionHelper iDEMainActionHelper = (IDEMainActionHelper)context.getAttribute("DEMAINACTION");
        return StringHelper.Format((String)"DEDATARESID:%1$s:%2$s", (Object)context.getDEHelper().getId(), (Object)iDEMainActionHelper.getName());
    }
}

