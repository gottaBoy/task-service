/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.DEWizard
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFramework.Base.PropertyConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFramework.Base.PropertyConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEBehaviorWriter
extends BaseToolbarItemWriter {
    private static final Log log = LogFactory.getLog(DEBehaviorWriter.class);

    public CallResult Export(XMLNode tbNode, XMLNode pNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        CallResult callResult = new CallResult();
        if (deBehavior == null) {
            if (tbItemConfig == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a"));
                return callResult;
            }
            if (!StringHelper.IsNullOrEmpty((String)tbItemConfig.getDEBehaviorId()) && (deBehavior = this.globalHelperEx.getDAModelStorage().FindDEBehavior(tbItemConfig.getDEBehaviorId())) == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)tbItemConfig.getDEBehaviorId()));
                return callResult;
            }
        }
        try {
            String strObjectName = context.getDEObjectName();
            XMLNode tbItemNode = new XMLNode();
            if (bMenu) {
                tbItemNode.setNodeName("SRFEXMENUITEMEX");
                if (StringHelper.IsNullOrEmpty((String)context.getPageModel())) {
                    tbItemNode.SetValue("ICONCLS", this.GetItemIconCls(context, deBehavior, tbItemConfig, ""));
                } else if (StringHelper.Compare((String)context.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("IMAGEPATH", this.GetItemImage(context, deBehavior, tbItemConfig, ""));
                }
                if (this.toolbarWriterConfig.getPropertiesConfig() != null) {
                    for (PropertyConfig propertyConfig : this.toolbarWriterConfig.getPropertiesConfig()) {
                        tbItemNode.SetValue(propertyConfig.getID(), propertyConfig.getValue());
                    }
                }
                String strNewFormat = this.GetItemCaption(context, deBehavior, tbItemConfig, "");
                String strNewTipFormat = this.GetItemToolTip(context, deBehavior, tbItemConfig, "");
                tbItemNode.SetValue("CAPTION", StringHelper.Format((String)strNewFormat, (Object)""));
                tbItemNode.SetValue("HANDLER", this.GetItemHandler(context, deBehavior, tbItemConfig));
                tbItemNode.SetValue("RESOURCEID", this.GetItemResourceId(context, deBehavior, tbItemConfig));
                tbItemNode.SetValue("DEBEHAVIORID", deBehavior.getDEBEHAVIORID());
                tbItemNode.SetValue("IMPORTANCE", deBehavior.getIMPORTANCE());
                pNode.AddNode(tbItemNode);
            } else {
                tbItemNode.setNodeName(ToolbarButtonConfig.TAG_TOOLBARBUTTON);
                if (StringHelper.IsNullOrEmpty((String)context.getPageModel())) {
                    tbItemNode.SetValue("ICONCSSCLASS", this.GetItemIconCls(context, deBehavior, tbItemConfig, ""));
                } else if (StringHelper.Compare((String)context.getPageModel(), (String)"SL", (boolean)true) == 0) {
                    tbItemNode.SetValue("IMAGE", this.GetItemImage(context, deBehavior, tbItemConfig, ""));
                }
                if (this.toolbarWriterConfig.getPropertiesConfig() != null) {
                    for (PropertyConfig propertyConfig : this.toolbarWriterConfig.getPropertiesConfig()) {
                        tbItemNode.SetValue(propertyConfig.getID(), propertyConfig.getValue());
                    }
                }
                String strNewFormat = this.GetItemCaption(context, deBehavior, tbItemConfig, "");
                String strNewTipFormat = this.GetItemToolTip(context, deBehavior, tbItemConfig, "");
                tbItemNode.SetValue(ToolbarButtonConfig.TAG_TEXT, StringHelper.Format((String)strNewFormat, (Object)""));
                tbItemNode.SetValue("TIPS", StringHelper.Format((String)strNewTipFormat, (Object)strObjectName));
                tbItemNode.SetValue("HANDLER", this.GetItemHandler(context, deBehavior, tbItemConfig));
                tbItemNode.SetValue("RESOURCEID", this.GetItemResourceId(context, deBehavior, tbItemConfig));
                tbItemNode.SetValue("DEBEHAVIORID", deBehavior.getDEBEHAVIORID());
                tbItemNode.SetValue("IMPORTANCE", deBehavior.getIMPORTANCE());
                pNode.AddNode(tbItemNode);
            }
            this.FillItemUserParams(tbItemNode, tbItemConfig, deBehavior, context, bMenu);
            callResult = this.OnAfterExport(tbNode, pNode, tbItemNode, tbItemConfig, deBehavior, context, bMenu);
        }
        catch (Exception e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    protected CallResult FillItemUserParams(XMLNode tbItemNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        Properties properties;
        CallResult callResult = new CallResult();
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getDEBEHAVIORID())) {
            tbItemNode.SetValue("UP_DEBEHAVIORID", deBehavior.getDEBEHAVIORID());
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getDEBEHAVIORNAME())) {
            tbItemNode.SetValue("UP_DEBEHAVIORNAME", deBehavior.getDEBEHAVIORNAME());
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getDATAACTION())) {
            tbItemNode.SetValue("UP_DATAACTION", deBehavior.getDATAACTION());
        }
        if (deBehavior.getUSERCONFIRM()) {
            tbItemNode.SetValue("UP_USERCONFIRM", deBehavior.getUSERCONFIRM() ? "TRUE" : "FALSE");
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getCONFIRMINFO())) {
            tbItemNode.SetValue("UP_CONFIRMINFO", deBehavior.getCONFIRMINFO());
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getPROCESSTYPE())) {
            tbItemNode.SetValue("UP_PROCESSTYPE", deBehavior.getPROCESSTYPE());
        }
        if (deBehavior.getTIMEOUT() > 0) {
            tbItemNode.SetValue("UP_TIMEOUT", StringHelper.Format((String)"%1$s", (Object)deBehavior.getTIMEOUT()));
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getACTIONTARGET())) {
            tbItemNode.SetValue("UP_ACTIONTARGET", deBehavior.getACTIONTARGET());
        }
        tbItemNode.SetValue("UP_CLOSEEDITVIEW", deBehavior.getCLOSEEDITVIEW() ? "TRUE" : "FALSE");
        if (StringHelper.Compare((String)deBehavior.getPROCESSTYPE(), (String)"FRONT", (boolean)true) == 0 && (StringHelper.Compare((String)deBehavior.getFRONTPROTYPE(), (String)"WIZARD", (boolean)true) == 0 || StringHelper.Compare((String)deBehavior.getFRONTPROTYPE(), (String)"SHOWPAGE", (boolean)true) == 0)) {
            String strURL = "";
            int nWidth = 0;
            int nHeight = 0;
            boolean bShowModal = false;
            if (StringHelper.Compare((String)deBehavior.getFRONTPROTYPE(), (String)"WIZARD", (boolean)true) == 0) {
                String strDEWizardId = deBehavior.getDEWIZARDID();
                if (StringHelper.IsNullOrEmpty((String)strDEWizardId)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc");
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                DEWizard deWizard = new DEWizard();
                callResult = this.globalHelperEx.getDAModelHelper().GetDEWizard(strDEWizardId, deWizard);
                if (callResult.IsError()) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDEWizardId, (Object)callResult.getErrorInfo()));
                    log.error((Object)callResult.getErrorInfo());
                    return callResult;
                }
                strURL = "../srfpage/wizardinitview.jsp?SRFDEWIZARDID=" + strDEWizardId;
                bShowModal = true;
                nWidth = deWizard.getWZWIDTH();
                nHeight = deWizard.getWZHEIGHT();
            } else if (StringHelper.Compare((String)deBehavior.getFRONTPROTYPE(), (String)"SHOWPAGE", (boolean)true) == 0) {
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
            }
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
            tbItemNode.SetValue("UP_RELOADDATA", deBehavior.getRELOADDATA() ? "TRUE" : "FALSE");
            tbItemNode.SetValue("UP_HTMLMODE", bHtmlMode ? "TRUE" : "FALSE");
        }
        if ((properties = deBehavior.getExtParams()) != null) {
            for (Object objKey : properties.keySet()) {
                String strValue;
                String strKey = objKey.toString();
                if (strKey.indexOf("HANDLERPARAM.") != 0 || StringHelper.IsNullOrEmpty((String)(strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey)))) continue;
                String strNewKey = strKey.substring(StringHelper.Length((String)"HANDLERPARAM."));
                tbItemNode.SetValue(strNewKey, strValue);
            }
        }
        return callResult;
    }

    @Override
    protected String GetItemHandler(IToolbarItemWriterContext context, DEBehavior deBehavior, TBItemConfig tbItemConfig) {
        String strExtParam = StringHelper.Format((String)"%1$s.%2$s", (Object)"HANDLER", (Object)context.getViewStyle());
        String strHandler = deBehavior.GetExtParam(strExtParam, "");
        if (!StringHelper.IsNullOrEmpty((String)strHandler)) {
            return strHandler;
        }
        if (StringHelper.Compare((String)context.getViewStyle(), (String)"EDITVIEW", (boolean)true) == 0) {
            return "SA.SRFDA.Ctrl.Toolbar.FormDEBehaviorHandler";
        }
        if (StringHelper.Compare((String)context.getViewStyle(), (String)"GRIDVIEW", (boolean)true) == 0) {
            return "SA.SRFDA.Ctrl.Toolbar.GridDEBehaviorHandler";
        }
        if (StringHelper.Compare((String)context.getViewStyle(), (String)"TREEVIEW", (boolean)true) == 0) {
            return "SA.SRFDA.Ctrl.Toolbar.TreeDEBehaviorHandler";
        }
        return this.toolbarWriterConfig.GetExtValue("HANDLER", "");
    }

    protected String GetDEWizardItemHandler(IToolbarItemWriterContext context, DEWizard deWizard, TBItemConfig tbItemConfig) {
        if (StringHelper.Compare((String)context.getViewStyle(), (String)"EDITVIEW", (boolean)true) == 0) {
            return "SA.SRFDA.Ctrl.Toolbar.FormWizardHandler";
        }
        if (StringHelper.Compare((String)context.getViewStyle(), (String)"GRIDVIEW", (boolean)true) == 0) {
            return "SA.SRFDA.Ctrl.Toolbar.GridDEBehaviorHandler";
        }
        return this.toolbarWriterConfig.GetExtValue("HANDLER", "");
    }

    protected CallResult OnAfterExport(XMLNode tbNode, XMLNode pNode, XMLNode tbItemNode, TBItemConfig tbItemConfig, DEBehavior deBehavior, IToolbarItemWriterContext context, boolean bMenu) {
        return new CallResult();
    }
}

