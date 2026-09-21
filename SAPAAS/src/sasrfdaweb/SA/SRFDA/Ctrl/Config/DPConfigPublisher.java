/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.FormPart
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.RawFIStyle
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainActionHelper
 *  SA.SRFDA.Ctrl.IDERGroupDetailHelper
 *  SA.SRFDA.Ctrl.IDERGroupHelper
 *  SA.SRFDA.Web.Form.DefaultFormItemLogicHelper
 *  SA.SRFDA.Web.Form.Model.FormItemLogicConfig
 *  SA.SRFDA.Web.Form.Model.FormItemRuleConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.DAConfigPublisher;
import SA.SRFDA.Ctrl.Config.DPConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IDPConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IDPConfigPublisherContext;
import SA.SRFDA.Ctrl.Config.IDPConfigPublisherPlugin;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.FormPart;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.RawFIStyle;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDERGroupDetailHelper;
import SA.SRFDA.Ctrl.IDERGroupHelper;
import SA.SRFDA.Web.Form.DefaultFormItemLogicHelper;
import SA.SRFDA.Web.Form.Model.FormItemLogicConfig;
import SA.SRFDA.Web.Form.Model.FormItemRuleConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DPConfigPublisher
extends DAConfigPublisher<IDPConfigPublishContext>
implements IDPConfigPublisherContext {
    private static final Log log = LogFactory.getLog(DPConfigPublisher.class);

    @Override
    protected XMLNode OnPublish(IDPConfigPublishContext iPublishContext) throws Exception {
        Form formView = iPublishContext.getForm();
        String strFormModelXML = formView.getFORMMODEL();
        XMLNode rootNode = XMLNode.LoadFromXML((String)strFormModelXML);
        rootNode = this.GetDPConfig(iPublishContext, rootNode);
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMPLUGIN())) {
            rootNode.SetValue("DPPLUGIN", formView.getFORMPLUGIN());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMSCRIPT())) {
            rootNode.SetValue("SCRIPT", formView.getFORMSCRIPT());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFIVCSCRIPT())) {
            rootNode.SetValue("FIVCSCRIPT", formView.getFIVCSCRIPT());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMSCRIPTEX())) {
            rootNode.SetValue("FORMSCRIPTEX", formView.getFORMSCRIPTEX());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMSCRIPTEX2())) {
            rootNode.SetValue("FORMSCRIPTEX2", formView.getFORMSCRIPTEX2());
        }
        if (!StringHelper.IsNullOrEmpty((String)formView.getFORMBSSCRIPT())) {
            rootNode.SetValue("FORMBSSCRIPT", formView.getFORMBSSCRIPT());
        }
        return rootNode;
    }

    protected XMLNode GetDPConfig(IDPConfigPublishContext iPublishContext, XMLNode rootNode) throws Exception {
        Object iDEFHelper;
        CallResult callResult = new CallResult();
        if (rootNode == null) {
            throw new Exception(StringHelper.Format((String)"\u8f7d\u5165\u8868\u5355\u6a21\u578b\u5931\u8d25"));
        }
        IDEHelper iDEHelper = iPublishContext.getDEHelper();
        if (iDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61"));
        }
        IDEMainActionHelper iDEMainActionHelper = iPublishContext.getDEMainAction();
        if (iDEMainActionHelper == null && iPublishContext.getDEMainState() != null) {
            iDEMainActionHelper = iPublishContext.getDEMainState().getEditDEMainAction();
        }
        Hashtable<String, String> pkeys = new Hashtable<String, String>();
        if (iDEHelper.GetKeyDEFHelper() != null) {
            pkeys.put(iDEHelper.GetKeyDEFHelper().getId(), "");
        }
        IDEDataCtrl formPartDataCtrl = this.getDAModelStorage().FindDEDataCtrl2("DE0083", "SYSTEM", null);
        IDEDataCtrl rawFIStyleDataCtrl = null;
        TreeMap<String, RawFIStyle> rawFIStyleMap = new TreeMap<String, RawFIStyle>();
        if (this.getDAGlobalHelper().getDAModelVersion() >= 10120900 && (rawFIStyleDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0069", "SYSTEM", null)) == null) {
            log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0069"));
        }
        ArrayList rawItemNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPRAWITEM", rawItemNodes);
        for (XMLNode rawItemNode : rawItemNodes) {
            boolean bDPModel = rawItemNode.GetExtValue("DPMODEL", false);
            boolean bDPModelFill = rawItemNode.GetExtValue("DPMODELFILL", false);
            if (!bDPModel || !bDPModelFill) continue;
            String strXML = "";
            String strFormPartId = rawItemNode.GetExtValue("FORMPARTID", "");
            if (!StringHelper.IsNullOrEmpty((String)strFormPartId)) {
                FormPart formPart = new FormPart();
                formPart.setFORMPARTID(strFormPartId);
                callResult = formPartDataCtrl.Get((BaseDataEntity)formPart);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9884\u5b9a\u4e49\u8868\u5355\u90e8\u4ef6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFormPartId, (Object)callResult.getErrorInfo()));
                    continue;
                }
                strXML = formPart.getFORMPARTMODEL();
            } else {
                strXML = rawItemNode.GetExtValue("CONTENT", "");
            }
            if (StringHelper.IsNullOrEmpty((String)strXML)) {
                log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u8868\u5355\u9879\u6307\u5b9a\u76f4\u63a5\u8868\u5355\u903b\u8f91\uff0c\u4f46\u6ca1\u6709\u5b9a\u4e49\u903b\u8f91\u5185\u5bb9\u3002"));
                continue;
            }
            strXML = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + strXML;
            rawItemNode.Reset();
            XMLConfig.LoadFromXML((String)strXML, (XMLConfig)rawItemNode);
        }
        rawItemNodes.clear();
        ArrayList tabPageNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", tabPageNodes);
        for (XMLNode tabPageNode : tabPageNodes) {
            String strCapLanResId = tabPageNode.GetExtValue("CAPLANRESID", "");
            if (!StringHelper.IsNullOrEmpty((String)strCapLanResId)) {
                String strCaption = tabPageNode.GetExtValue("CAPTION", "");
                strCaption = this.GetLocalization(iDEHelper, strCapLanResId, strCaption);
                tabPageNode.SetExtValue("CAPTION", strCaption);
            }
            this.FillDPPageGroupNodeDERMode(iDEHelper, tabPageNode, iPublishContext.getForm());
        }
        ArrayList groupNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPGROUP", groupNodes);
        for (XMLNode groupNode : groupNodes) {
            String strCapLanResId = groupNode.GetExtValue("CAPLANRESID", "");
            if (StringHelper.IsNullOrEmpty((String)strCapLanResId)) continue;
            String strCaption = groupNode.GetExtValue("CAPTION", "");
            strCaption = this.GetLocalization(iDEHelper, strCapLanResId, strCaption);
            groupNode.SetExtValue("CAPTION", strCaption);
        }
        ArrayList dpGroupNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPGROUP", dpGroupNodes);
        rootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", dpGroupNodes);
        for (XMLNode dpGroupNode : dpGroupNodes) {
            String strCode;
            String strDPGroupLogic = dpGroupNode.GetExtValue("LOGICXML", "");
            if (StringHelper.IsNullOrEmpty((String)strDPGroupLogic)) continue;
            FormItemLogicConfig formItemLogicConfig = new FormItemLogicConfig();
            XMLConfig.LoadFromXML((String)strDPGroupLogic, (XMLConfig)formItemLogicConfig);
            DefaultFormItemLogicHelper defaultFormItemLogicHelper = new DefaultFormItemLogicHelper(this.getDAGlobalHelper(), iDEHelper);
            FormItemRuleConfig formItemRuleConfig = formItemLogicConfig.FindFormItemRuleConfig("CONTROLENABLE");
            if (formItemRuleConfig == null || !StringHelper.IsNullOrEmpty((String)(strCode = dpGroupNode.GetExtValue("ENABLECOND", ""))) || !(callResult = defaultFormItemLogicHelper.GetEnableCode(formItemRuleConfig)).IsOk() || StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) continue;
            dpGroupNode.SetValue("ENABLECOND", strCode);
        }
        ArrayList dpDataGridNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPDATAGRIDITEM", dpDataGridNodes);
        if (dpDataGridNodes.size() > 0) {
            for (XMLNode dpDataGridNode : dpDataGridNodes) {
                String strDERId = dpDataGridNode.GetExtValue("DER1NID", "");
                Iterator strDGId = dpDataGridNode.GetExtValue("DGID", "");
                String strURLParams = dpDataGridNode.GetExtValue("URLPARAMS", "");
                String strRelatedFields = dpDataGridNode.GetExtValue("RELATEDFIELDS", "");
                String strPageId = dpDataGridNode.GetExtValue("PAGEID", "");
                String strSaveBeforeMajor = dpDataGridNode.GetExtValue("SAVEBEFOREMAJOR", "");
                String strTempData = dpDataGridNode.GetExtValue("TEMPDATA", "");
                String strSaveMajorTip = dpDataGridNode.GetExtValue("SAVEMAJORTIP", "");
                String strRelatedFormState = dpDataGridNode.GetExtValue("RELATEDFORMSTATE", "");
                String strIgnoreParams = dpDataGridNode.GetExtValue("APPENDCTXPARAMS", "");
                if (StringHelper.IsNullOrEmpty((String)strDERId)) {
                    log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5185\u5d4c\u8868\u683cDER1N\u5173\u7cfb\u7f16\u53f7"));
                    return null;
                }
                TreeMap<String, Object> urlParams = new TreeMap<String, Object>();
                urlParams.put("SRFGRIDVIEW", strDGId);
                urlParams.put("SRFDERID", strDERId);
                urlParams.put("SRFSUMMARYKEY", iDEHelper.GetKeyDEFHelper().getName().toUpperCase());
                urlParams.put("SRFDGAL", "FALSE");
                String strGridViewUrl = "";
                if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                    strGridViewUrl = "../srfpage/embedgridview.jsp";
                } else {
                    Page page = this.getDAGlobalHelper().getDAModelStorage().FindPage(strPageId);
                    if (page == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strPageId));
                        return null;
                    }
                    strGridViewUrl = page.GetTotalPagePath();
                }
                strGridViewUrl = URLHelper.AppendURLSeperator((String)strGridViewUrl);
                strGridViewUrl = String.valueOf(strGridViewUrl) + URLHelper.GetQueryString(urlParams);
                if (!StringHelper.IsNullOrEmpty((String)strURLParams)) {
                    strGridViewUrl = URLHelper.AppendURLSeperator((String)strGridViewUrl);
                    strGridViewUrl = String.valueOf(strGridViewUrl) + strURLParams;
                }
                XMLNode dgItem = new XMLNode();
                dgItem.setNodeName("SRFEXDPDATAGRID");
                dgItem.SetValue("URL", strGridViewUrl);
                String strKeys = String.valueOf(iDEHelper.GetKeyDEFHelper().getName()) + ";SRFDATEMPKEYID";
                dgItem.SetValue("RELATEDFIELDS", strRelatedFields);
                dgItem.SetValue("KEYFIELDS", strKeys);
                dgItem.SetValue("HEIGHT", dpDataGridNode.GetExtValue("HEIGHT", "100"));
                if (!StringHelper.IsNullOrEmpty((String)strSaveBeforeMajor)) {
                    dgItem.SetValue("SAVEBEFOREMAJOR", strSaveBeforeMajor);
                }
                if (!StringHelper.IsNullOrEmpty((String)strTempData)) {
                    dgItem.SetValue("TEMPDATA", strTempData);
                }
                if (!StringHelper.IsNullOrEmpty((String)strSaveMajorTip)) {
                    dgItem.SetValue("SAVEMAJORTIP", strSaveMajorTip);
                }
                if (!StringHelper.IsNullOrEmpty((String)strRelatedFormState)) {
                    dgItem.SetValue("RELATEDFORMSTATE", strRelatedFormState);
                }
                dgItem.SetValue("APPENDCTXPARAMS", strIgnoreParams);
                dpDataGridNode.AddNode(dgItem);
            }
        }
        ArrayList formItemNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDPFORMITEM", formItemNodes);
        ArrayList<XMLNode> hiddenNodes = new ArrayList<XMLNode>();
        for (XMLNode formItemNode : formItemNodes) {
            XMLNode formCtrlNode;
            String strFormItemLogic;
            String strRawFIStyleId;
            String strDEField = formItemNode.GetExtValue("DEFIELD", "");
            if (StringHelper.IsNullOrEmpty((String)strDEField)) continue;
            iDEFHelper = iDEHelper.GetDEFHelper(strDEField);
            if (iDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879[%1$s]\u7684\u5b57\u6bb5\u4fe1\u606f", (Object)strDEField));
                continue;
            }
            formItemNode.SetValue("DEFName", iDEFHelper.getName());
            if (this.getDAGlobalHelper().getDAModelVersion() >= 10120900 && !StringHelper.IsNullOrEmpty((String)(strRawFIStyleId = formItemNode.GetExtValue("RAWFISTYLEID", "")))) {
                RawFIStyle rawFIStyle = (RawFIStyle)rawFIStyleMap.get(strRawFIStyleId);
                if (rawFIStyle == null) {
                    rawFIStyle = new RawFIStyle();
                    rawFIStyle.setRAWFISTYLEID(strRawFIStyleId);
                    callResult = rawFIStyleDataCtrl.Get((BaseDataEntity)rawFIStyle);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u5355\u9879\u5bb9\u5668\u6837\u5f0f[%1$s]\u5931\u8d25,%2$s", (Object)strRawFIStyleId, (Object)callResult.getErrorInfo()));
                        continue;
                    }
                    rawFIStyleMap.put(strRawFIStyleId, rawFIStyle);
                }
                formItemNode.SetValue("BEGINHTML", rawFIStyle.getBEGINTAG());
                formItemNode.SetValue("ENDHTML", rawFIStyle.getENDTAG());
            }
            if (!StringHelper.IsNullOrEmpty((String)(strFormItemLogic = formItemNode.GetExtValue("LOGICXML", "")))) {
                String strCode;
                FormItemLogicConfig formItemLogicConfig = new FormItemLogicConfig();
                XMLConfig.LoadFromXML((String)strFormItemLogic, (XMLConfig)formItemLogicConfig);
                DefaultFormItemLogicHelper defaultFormItemLogicHelper = new DefaultFormItemLogicHelper(this.getDAGlobalHelper(), iDEHelper);
                FormItemRuleConfig formItemRuleConfig = formItemLogicConfig.FindFormItemRuleConfig("CONTROLENABLE");
                if (formItemRuleConfig != null) {
                    strCode = formItemNode.GetExtValue("ENABLECOND", "");
                    if (StringHelper.IsNullOrEmpty((String)strCode)) {
                        callResult = defaultFormItemLogicHelper.GetEnableCode(formItemRuleConfig);
                        if (callResult.IsOk() && !StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) {
                            formItemNode.SetValue("ENABLECOND", strCode);
                        }
                    } else {
                        String strCode2;
                        callResult = defaultFormItemLogicHelper.GetEnableCode(formItemRuleConfig);
                        if (callResult.IsOk() && !StringHelper.IsNullOrEmpty((String)(strCode2 = (String)callResult.getUserObject()))) {
                            String strNewCode = "'('+" + strCode + "+')&&('+" + strCode2 + "+')'";
                            formItemNode.SetValue("ENABLECOND", strNewCode);
                        }
                    }
                }
                if ((formItemRuleConfig = formItemLogicConfig.FindFormItemRuleConfig("ALLOWEMPTY")) != null) {
                    strCode = formItemNode.GetExtValue("ALLOWEMPTYCOND", "");
                    if (StringHelper.IsNullOrEmpty((String)strCode) && (callResult = defaultFormItemLogicHelper.GetAllowEmptyCode(formItemRuleConfig)).IsOk() && !StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) {
                        formItemNode.SetValue("ALLOWEMPTYCOND", strCode);
                    }
                    if (StringHelper.IsNullOrEmpty((String)(strCode = formItemNode.GetExtValue("ALLOWEMPTYCOND2", ""))) && (callResult = defaultFormItemLogicHelper.GetBackendAllowEmptyCode(formItemRuleConfig)).IsOk() && !StringHelper.IsNullOrEmpty((String)(strCode = (String)callResult.getUserObject()))) {
                        formItemNode.SetValue("ALLOWEMPTYCOND2", strCode);
                    }
                }
            }
            if (iDEMainActionHelper != null) {
                formItemNode.SetExtValue("FC_DEMAINACTION", iDEMainActionHelper.getId());
            }
            if ((formCtrlNode = this.getDAGlobalHelper().getDAFormItemHelper().GetFormCtrlNode(this.getPageModel(), this.getLanguage(), iDEFHelper.getDEHelper(), (IDEFHelper)iDEFHelper, formItemNode)) != null) {
                boolean bHiddenNode = false;
                String strTag = formCtrlNode.getNodeName();
                if (StringHelper.Compare((String)strTag, (String)"SRFEXHIDDEN", (boolean)true) == 0) {
                    bHiddenNode = true;
                    if (formItemNode.getParentNode() != null) {
                        formItemNode.getParentNode().RemoveNode(formItemNode);
                    }
                    hiddenNodes.add(formCtrlNode);
                }
                if (!bHiddenNode) {
                    formItemNode.AddNode(formCtrlNode);
                }
                if (iDEFHelper.IsKeyDEField()) {
                    pkeys.remove(iDEFHelper.getId());
                }
            }
            if (!iDEFHelper.IsEnableDEFieldPriv()) continue;
            XMLNode hiddenNode = new XMLNode();
            hiddenNode.setNodeName("SRFEXHIDDEN");
            hiddenNode.setID("SRFIP_" + iDEFHelper.getName());
            XMLNode itemNode = new XMLNode();
            itemNode.setNodeName("SRFEXFORMITEM");
            hiddenNode.AddNode(itemNode);
            itemNode.SetValue("KEY", "FALSE");
            itemNode.SetValue("DATATYPE", "INT");
            hiddenNodes.add(hiddenNode);
        }
        rootNode.GetAllNodeByNodeName("SRFEXDPRAWITEM", rawItemNodes);
        for (XMLNode rawItemNode : rawItemNodes) {
            String strRawFIStyleId;
            String strIOSStyle;
            String strContent;
            boolean bDPModel = rawItemNode.GetExtValue("DPMODEL", false);
            if (bDPModel) {
                String strXML = "";
                String strCustom = rawItemNode.GetExtValue("CUSTOM", "");
                if (StringHelper.IsNullOrEmpty((String)strCustom)) {
                    String strFormPartId = rawItemNode.GetExtValue("FORMPARTID", "");
                    if (!StringHelper.IsNullOrEmpty((String)strFormPartId)) {
                        FormPart formPart = new FormPart();
                        formPart.setFORMPARTID(strFormPartId);
                        callResult = formPartDataCtrl.Get((BaseDataEntity)formPart);
                        if (callResult.IsError()) {
                            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9884\u5b9a\u4e49\u8868\u5355\u90e8\u4ef6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFormPartId, (Object)callResult.getErrorInfo()));
                            continue;
                        }
                        strXML = formPart.getFORMPARTMODEL();
                    } else {
                        strXML = rawItemNode.GetExtValue("CONTENT", "");
                    }
                    if (StringHelper.IsNullOrEmpty((String)strXML)) {
                        log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u8868\u5355\u9879\u6307\u5b9a\u76f4\u63a5\u8868\u5355\u903b\u8f91\uff0c\u4f46\u6ca1\u6709\u5b9a\u4e49\u903b\u8f91\u5185\u5bb9\u3002"));
                        continue;
                    }
                    strXML = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" + strXML;
                    rawItemNode.Reset();
                    XMLConfig.LoadFromXML((String)strXML, (XMLConfig)rawItemNode);
                    continue;
                }
                strXML = rawItemNode.GetExtValue("CONTENT", "");
                Object objDAConfigHelperPlugin = ObjectHelper.Create((String)strCustom);
                if (objDAConfigHelperPlugin == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u63d2\u4ef6\u5bf9\u8c61[%1$s]", (Object)strCustom));
                    continue;
                }
                if (!(objDAConfigHelperPlugin instanceof IDPConfigPublisherPlugin)) {
                    log.error((Object)StringHelper.Format((String)"\u63d2\u4ef6\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strCustom));
                    continue;
                }
                IDPConfigPublisherPlugin iDAConfigHelperPlugin = (IDPConfigPublisherPlugin)objDAConfigHelperPlugin;
                rawItemNode.Reset();
                iDAConfigHelperPlugin.Publish(this, iPublishContext, strXML, rootNode, rawItemNode);
                continue;
            }
            String strLanguageResId = rawItemNode.GetExtValue("LANGUAGERESID", "");
            if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0 || StringHelper.Compare((String)this.getPageModel(), (String)"WinRT", (boolean)true) == 0) {
                strContent = rawItemNode.GetExtValue("SLCONTENT", "");
                if (!StringHelper.IsNullOrEmpty((String)strContent)) {
                    rawItemNode.SetValue("CONTENT", strContent);
                    strLanguageResId = "";
                }
                strLanguageResId = rawItemNode.GetExtValue("SLLANGUAGERESID", strLanguageResId);
            }
            if (!StringHelper.IsNullOrEmpty((String)strLanguageResId)) {
                strContent = rawItemNode.GetExtValue("CONTENT", "");
                strContent = this.GetLocalization(iDEHelper, strLanguageResId, strContent);
                rawItemNode.SetValue("CONTENT", strContent);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strIOSStyle = rawItemNode.GetExtValue("IOSSTYLE", "")))) {
                rawItemNode.SetValue("IOSSTYLE", strIOSStyle);
            }
            if (this.getDAGlobalHelper().getDAModelVersion() < 10120900 || StringHelper.IsNullOrEmpty((String)(strRawFIStyleId = rawItemNode.GetExtValue("RAWFISTYLEID", "")))) continue;
            RawFIStyle rawFIStyle = (RawFIStyle)rawFIStyleMap.get(strRawFIStyleId);
            if (rawFIStyle == null) {
                rawFIStyle = new RawFIStyle();
                rawFIStyle.setRAWFISTYLEID(strRawFIStyleId);
                callResult = rawFIStyleDataCtrl.Get((BaseDataEntity)rawFIStyle);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u5355\u9879\u5bb9\u5668\u6837\u5f0f[%1$s]\u5931\u8d25,%2$s", (Object)strRawFIStyleId, (Object)callResult.getErrorInfo()));
                    continue;
                }
                rawFIStyleMap.put(strRawFIStyleId, rawFIStyle);
            }
            rawItemNode.SetValue("BEGINHTML", rawFIStyle.getBEGINTAG());
            rawItemNode.SetValue("ENDHTML", rawFIStyle.getENDTAG());
        }
        groupNodes.clear();
        rootNode.GetAllNodeByNodeName("SRFEXDPGROUP", groupNodes);
        for (XMLNode groupNode : groupNodes) {
            XMLNode newXMLNode;
            String strNewXML;
            String strXML;
            XMLNode pageGroupNode;
            String strChildFormId;
            if (groupNode.GetExtValue("ENABLELOOPMODE", false)) {
                XMLNode pageGroupNode2;
                int nLoopCnt = groupNode.GetExtValue("LOOPCNT", 5);
                String strLoopTag = groupNode.GetExtValue("LOOPTAG", "_X_");
                String strLoopFormId = groupNode.GetExtValue("LOOPFORMID", "");
                if (StringHelper.IsNullOrEmpty((String)strLoopFormId)) continue;
                Form loopForm = new Form();
                callResult = this.getDAGlobalHelper().getDAModelHelper().GetDEForm(strLoopFormId, loopForm);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5faa\u73af\u8868\u5355[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strLoopFormId, (Object)callResult.getErrorInfo()));
                    return null;
                }
                XMLNode loopFormRootNode = XMLNode.LoadFromXML((String)loopForm.getFORMMODEL());
                IDEHelper loopFormDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper(loopForm.getDEID());
                DPConfigPublishContext dpConfigPublishContext = new DPConfigPublishContext();
                dpConfigPublishContext.setConfigMode(iPublishContext.getConfigMode());
                dpConfigPublishContext.setPage(iPublishContext.getPage());
                dpConfigPublishContext.setDEHelper(loopFormDEHelper);
                dpConfigPublishContext.setForm(loopForm);
                loopFormRootNode = this.GetDPConfig(dpConfigPublishContext, loopFormRootNode);
                if (loopFormRootNode == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5faa\u73af\u8868\u5355[%1$s]\u6a21\u578b", (Object)strLoopFormId));
                    return null;
                }
                ArrayList<String> childXMLList = new ArrayList<String>();
                ArrayList<String> childXMLList2 = new ArrayList<String>();
                ArrayList pageGroupNodes = new ArrayList();
                loopFormRootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", pageGroupNodes);
                if (pageGroupNodes.size() > 0 && (pageGroupNode2 = (XMLNode)pageGroupNodes.get(0)).getChildNodes() != null) {
                    for (XMLNode childNode : pageGroupNode2.getChildNodes()) {
                        childXMLList.add(XMLNode.Export((XMLNode)childNode));
                    }
                }
                ArrayList hiddenNodeList = new ArrayList();
                loopFormRootNode.GetAllNodeByNodeName("SRFEXHIDDEN", hiddenNodeList);
                if (hiddenNodeList.size() > 0) {
                    for (XMLNode hiddenXMLNode : hiddenNodeList) {
                        if (StringHelper.Compare((String)hiddenXMLNode.getID(), (String)"SRFDATEMPKEYID", (boolean)false) == 0 || StringHelper.Compare((String)hiddenXMLNode.getID(), (String)"SRFDAUPDATEDATE", (boolean)false) == 0 || StringHelper.Compare((String)hiddenXMLNode.getID(), (String)loopFormDEHelper.GetKeyDEFHelper().getName(), (boolean)false) == 0) continue;
                        childXMLList2.add(XMLNode.Export((XMLNode)hiddenXMLNode));
                    }
                }
                if (groupNode.getChildNodes() != null) {
                    groupNode.getChildNodes().clear();
                }
                int i = 0;
                while (i < nLoopCnt) {
                    XMLNode newXMLNode2;
                    String strNewXML2;
                    String strXML2;
                    Iterator iterator = childXMLList.iterator();
                    while (iterator.hasNext()) {
                        strNewXML2 = strXML2 = (String)iterator.next();
                        strNewXML2 = strNewXML2.replace(strLoopTag, StringHelper.Format((String)"%1$03d", (Object)(i + 1)));
                        newXMLNode2 = XMLNode.LoadFromXML((String)strNewXML2);
                        groupNode.AddNode(newXMLNode2);
                    }
                    iterator = childXMLList2.iterator();
                    while (iterator.hasNext()) {
                        strNewXML2 = strXML2 = (String)iterator.next();
                        strNewXML2 = strNewXML2.replace(strLoopTag, StringHelper.Format((String)"%1$03d", (Object)(i + 1)));
                        newXMLNode2 = XMLNode.LoadFromXML((String)strNewXML2);
                        hiddenNodes.add(newXMLNode2);
                    }
                    ++i;
                }
                continue;
            }
            if (!groupNode.GetExtValue("ENABLECHILDMODE", false) || StringHelper.IsNullOrEmpty((String)(strChildFormId = groupNode.GetExtValue("CHILDFORMID", "")))) continue;
            Form loopForm = new Form();
            callResult = this.getDAGlobalHelper().getDAModelHelper().GetDEForm(strChildFormId, loopForm);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5d4c\u5165\u8868\u5355[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strChildFormId, (Object)callResult.getErrorInfo()));
                return null;
            }
            XMLNode loopFormRootNode = XMLNode.LoadFromXML((String)loopForm.getFORMMODEL());
            IDEHelper loopFormDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper(loopForm.getDEID());
            DPConfigPublishContext dpConfigPublishContext = new DPConfigPublishContext();
            dpConfigPublishContext.setConfigMode(iPublishContext.getConfigMode());
            dpConfigPublishContext.setPage(iPublishContext.getPage());
            dpConfigPublishContext.setDEHelper(loopFormDEHelper);
            dpConfigPublishContext.setForm(loopForm);
            loopFormRootNode = this.GetDPConfig(dpConfigPublishContext, loopFormRootNode);
            if (loopFormRootNode == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5d4c\u5165\u8868\u5355[%1$s]\u6a21\u578b", (Object)strChildFormId));
                return null;
            }
            ArrayList<String> childXMLList = new ArrayList<String>();
            ArrayList<String> childXMLList2 = new ArrayList<String>();
            ArrayList pageGroupNodes = new ArrayList();
            loopFormRootNode.GetAllNodeByNodeName("SRFEXDPPAGEGROUP", pageGroupNodes);
            if (pageGroupNodes.size() > 0 && (pageGroupNode = (XMLNode)pageGroupNodes.get(0)).getChildNodes() != null) {
                for (XMLNode childNode : pageGroupNode.getChildNodes()) {
                    childXMLList.add(XMLNode.Export((XMLNode)childNode));
                }
            }
            ArrayList hiddenNodeList = new ArrayList();
            loopFormRootNode.GetAllNodeByNodeName("SRFEXHIDDEN", hiddenNodeList);
            if (hiddenNodeList.size() > 0) {
                for (XMLNode hiddenXMLNode : hiddenNodeList) {
                    if (StringHelper.Compare((String)hiddenXMLNode.getID(), (String)"SRFDATEMPKEYID", (boolean)false) == 0 || StringHelper.Compare((String)hiddenXMLNode.getID(), (String)"SRFDAUPDATEDATE", (boolean)false) == 0 || StringHelper.Compare((String)hiddenXMLNode.getID(), (String)loopFormDEHelper.GetKeyDEFHelper().getName(), (boolean)false) == 0) continue;
                    childXMLList2.add(XMLNode.Export((XMLNode)hiddenXMLNode));
                }
            }
            if (groupNode.getChildNodes() != null) {
                groupNode.getChildNodes().clear();
            }
            Iterator iterator = childXMLList.iterator();
            while (iterator.hasNext()) {
                strNewXML = strXML = (String)iterator.next();
                newXMLNode = XMLNode.LoadFromXML((String)strNewXML);
                groupNode.AddNode(newXMLNode);
            }
            iterator = childXMLList2.iterator();
            while (iterator.hasNext()) {
                strNewXML = strXML = (String)iterator.next();
                newXMLNode = XMLNode.LoadFromXML((String)strNewXML);
                hiddenNodes.add(newXMLNode);
            }
        }
        XMLNode hiddenGroupNode = new XMLNode();
        hiddenGroupNode.setNodeName("SRFEXDPHIDDENGROUP");
        rootNode.AddNode(0, hiddenGroupNode);
        XMLNode hiddenNode = new XMLNode();
        hiddenNode.setNodeName("SRFEXHIDDEN");
        hiddenGroupNode.AddNode(hiddenNode);
        hiddenNode.setID("SRFDATEMPKEYID");
        XMLNode itemNode = new XMLNode();
        itemNode.setNodeName("SRFEXFORMITEM");
        hiddenNode.AddNode(itemNode);
        itemNode.SetValue("KEY", "FALSE");
        itemNode.SetValue("DATATYPE", "VARCHAR");
        itemNode.SetValue("REALID", "TRUE");
        if (this.OnGetCheckDataUpdateDate(iPublishContext)) {
            hiddenNode = new XMLNode();
            hiddenNode.setNodeName("SRFEXHIDDEN");
            hiddenGroupNode.AddNode(hiddenNode);
            hiddenNode.setID("SRFDAUPDATEDATE");
            itemNode = new XMLNode();
            itemNode.setNodeName("SRFEXFORMITEM");
            hiddenNode.AddNode(itemNode);
            itemNode.SetValue("KEY", "FALSE");
            itemNode.SetValue("DATATYPE", "DATETIME");
            itemNode.SetValue("REALID", "TRUE");
        }
        hiddenNode = new XMLNode();
        hiddenNode.setNodeName("SRFEXHIDDEN");
        hiddenGroupNode.AddNode(hiddenNode);
        hiddenNode.setID("SRFDADEMAINSTATE");
        itemNode = new XMLNode();
        itemNode.setNodeName("SRFEXFORMITEM");
        hiddenNode.AddNode(itemNode);
        itemNode.SetValue("KEY", "FALSE");
        itemNode.SetValue("DATATYPE", "VARCHAR");
        itemNode.SetValue("REALID", "TRUE");
        Enumeration en = pkeys.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            iDEFHelper = iDEHelper.GetDEFHelper(strKey);
            if (iDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879[%1$s]\u7684\u5b57\u6bb5\u4fe1\u606f", (Object)strKey));
                continue;
            }
            XMLNode hiddenNode2 = new XMLNode();
            hiddenNode2.setNodeName("SRFEXHIDDEN");
            hiddenGroupNode.AddNode(hiddenNode2);
            hiddenNode2.setID(iDEFHelper.getName());
            XMLNode itemNode2 = new XMLNode();
            itemNode2.setNodeName("SRFEXFORMITEM");
            hiddenNode2.AddNode(itemNode2);
            itemNode2.SetValue("KEY", "TRUE");
            itemNode2.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
        }
        for (XMLNode xmlNode : hiddenNodes) {
            hiddenGroupNode.AddNode(xmlNode);
        }
        ArrayList defaultItemNodes = new ArrayList();
        rootNode.GetAllNodeByNodeName("SRFEXDEFAULTITEM", defaultItemNodes);
        for (XMLNode formItemNode : defaultItemNodes) {
            String strDEField = formItemNode.GetExtValue("DEFIELD", "");
            IDEFHelper iDEFHelper2 = iDEHelper.GetDEFHelper(strDEField);
            if (iDEFHelper2 == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879[%1$s]\u7684\u5b57\u6bb5\u4fe1\u606f", (Object)strDEField));
                continue;
            }
            formItemNode.SetValue("DEFName", iDEFHelper2.getName());
            formItemNode.setID(iDEFHelper2.getName());
            formItemNode.SetValue("DATATYPE", iDEFHelper2.GetStdDataType());
        }
        DPConfigPublisher.OptimizeDPConfig(rootNode);
        return rootNode;
    }

    public String GetConfigFilePath(String strConfigId) throws Exception {
        return ConfigPathHelper.GetRuntimeDPConfigPath((String)this.getDAGlobalHelper().GetAppRootPath(), (String)strConfigId);
    }

    @Override
    protected String OnGetConfigId(IDPConfigPublishContext iDAConfigPublishContext) throws Exception {
        String strConfigId = "";
        strConfigId = StringHelper.Format((String)"DE%1$s.DPEX_%2$s", (Object)iDAConfigPublishContext.getDEHelper().getId(), (Object)iDAConfigPublishContext.getDEHelper().getVersion());
        if (iDAConfigPublishContext.getForm() != null) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_%1$s_%2$s", (Object)iDAConfigPublishContext.getForm().getFORMID(), (Object)iDAConfigPublishContext.getForm().getFMVERSION());
        }
        return strConfigId;
    }

    protected boolean OnGetCheckDataUpdateDate(IDPConfigPublishContext iDAConfigPublishContext) {
        Form formView = iDAConfigPublishContext.getForm();
        if (formView != null) {
            if (formView.isSAVECHECKNull()) {
                return true;
            }
            return formView.getSAVECHECK();
        }
        return true;
    }

    private static void OptimizeDPConfig(XMLNode xmlNode) {
        ArrayList xmlNodes;
        String strNodeName = xmlNode.getNodeName();
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPPAGEGROUP", (boolean)true) == 0) {
            xmlNode.RemoveExtValue("CAPLANRESID");
            xmlNode.RemoveExtValue("LOGICXML");
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPGROUP", (boolean)true) == 0) {
            if (xmlNode.GetExtValue("COLSPAN", 1) == 1) {
                xmlNode.RemoveExtValue("COLSPAN");
            }
            xmlNode.RemoveExtValue("CAPLANRESID");
            xmlNode.RemoveExtValue("LOGICXML");
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPFORMITEM", (boolean)true) == 0) {
            if (xmlNode.GetExtValue("COLSPAN", 1) == 1) {
                xmlNode.RemoveExtValue("COLSPAN");
            }
            xmlNode.RemoveExtValue("DEFNAME");
            xmlNode.RemoveExtValue("DEFIELD");
            xmlNode.RemoveExtValue("DEFLOGICNAME");
            xmlNode.RemoveExtValue("DEFID");
            xmlNode.RemoveExtValue("FIEXTPARAMS");
            xmlNode.RemoveExtValue("FI_DV");
            xmlNode.RemoveExtValue("ALLOWEMPTYCOND2");
            xmlNode.RemoveExtValue("CAPLANRESID");
            xmlNode.RemoveExtValue("LOGICXML");
            xmlNode.RemoveExtValue("FC_DEMAINACTION");
            if (!xmlNode.GetExtValue("CAPTIONONTOP", false)) {
                xmlNode.RemoveExtValue("CAPTIONONTOP");
            }
            if (xmlNode.GetExtValue("SHOWCAPTION", true)) {
                xmlNode.RemoveExtValue("SHOWCAPTION");
            }
            if (xmlNode.GetExtValue("ALLOWEMPTY", true)) {
                xmlNode.RemoveExtValue("ALLOWEMPTY");
            }
            Vector<String> removeList = new Vector<String>();
            Hashtable extAttrs = xmlNode.getExtAttrs();
            if (extAttrs != null) {
                Enumeration en = extAttrs.keys();
                while (en.hasMoreElements()) {
                    String strKey = (String)en.nextElement();
                    if ((strKey = strKey.toUpperCase()).indexOf("FI_") != 0) continue;
                    removeList.add(strKey);
                }
            }
            for (String strKey : removeList) {
                xmlNode.RemoveExtValue(strKey);
            }
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXFORMITEM", (boolean)true) == 0) {
            String strItemFormat;
            String strDataType;
            if (xmlNode.GetExtValue("ALLOWEMPTY", true)) {
                xmlNode.RemoveExtValue("ALLOWEMPTY");
            }
            if (StringHelper.Compare((String)(strDataType = xmlNode.GetExtValue("DATATYPE", "VARCHAR")), (String)"VARCHAR", (boolean)true) == 0) {
                xmlNode.RemoveExtValue("DATATYPE");
            }
            if (StringHelper.Compare((String)(strItemFormat = xmlNode.GetExtValue("ITEMFORMAT", "%1$s")), (String)"%1$s", (boolean)true) == 0) {
                xmlNode.RemoveExtValue("ITEMFORMAT");
            }
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPDATAGRIDITEM", (boolean)true) == 0) {
            xmlNode.RemoveExtValue("URLPARAMS");
            xmlNode.RemoveExtValue("TBABILITY");
            xmlNode.RemoveExtValue("DER1NID");
            xmlNode.RemoveExtValue("DGID");
            xmlNode.RemoveExtValue("PAGEID");
            xmlNode.RemoveExtValue("PAGENAME");
            xmlNode.RemoveExtValue("RELATEDFIELDS");
            xmlNode.RemoveExtValue("SAVEBEFOREMAJOR");
            xmlNode.RemoveExtValue("TEMPDATA");
            xmlNode.RemoveExtValue("SAVEMAJORTIP");
            xmlNode.RemoveExtValue("RELATEDFORMSTATE");
            xmlNode.RemoveExtValue("APPENDCTXPARAMS");
            xmlNode.RemoveExtValue("HEIGHT");
        }
        if (StringHelper.Compare((String)strNodeName, (String)"SRFEXDPRAWITEM", (boolean)true) == 0) {
            xmlNode.RemoveExtValue("SLCONTENT");
            xmlNode.RemoveExtValue("LANGUAGERESID");
            xmlNode.RemoveExtValue("LANGUAGERESNAME");
            xmlNode.RemoveExtValue("SLLANGUAGERESID");
            xmlNode.RemoveExtValue("SLLANGUAGERESNAME");
        }
        if ((xmlNodes = xmlNode.getChildNodes()) == null) {
            return;
        }
        int i = 0;
        while (i < xmlNodes.size()) {
            DPConfigPublisher.OptimizeDPConfig((XMLNode)xmlNodes.get(i));
            ++i;
        }
    }

    protected void FillDPPageGroupNodeDERMode(IDEHelper iDEHelper, XMLNode tabPageNode, Form formView) throws Exception {
        String strDERMode = tabPageNode.GetExtValue("DERMODE", "");
        if (StringHelper.IsNullOrEmpty((String)strDERMode)) {
            return;
        }
        String strDERGroupId = tabPageNode.GetExtValue("DERGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strDERGroupId)) {
            return;
        }
        int nHeight = tabPageNode.GetExtValue("HEIGHT", 500);
        XMLNode parentNode = tabPageNode.getParentNode();
        int nPos = parentNode.IndexOf(tabPageNode);
        parentNode.RemoveNode(tabPageNode);
        IDERGroupHelper iDERGroupHelper = iDEHelper.FindDERGroup(strDERGroupId);
        for (IDERGroupDetailHelper iDERGroupDetailHelper : iDERGroupHelper.getDetails()) {
            String strDetailType = iDERGroupDetailHelper.getDetailType();
            XMLNode newTabPageNode = new XMLNode();
            newTabPageNode.setNodeName("SRFEXDPPAGEGROUP");
            newTabPageNode.SetExtValue("CAPTION", iDERGroupDetailHelper.getCaption(this.getLanguage()));
            newTabPageNode.SetExtValue("RESOURCEID", iDERGroupDetailHelper.getResourceId());
            XMLNode dpRawItemNode = new XMLNode();
            dpRawItemNode.setNodeName("SRFEXDPRAWITEM");
            dpRawItemNode.SetExtValue("CUSTOM", "SA.SRFDA.Web.SRFDADPIframeItem");
            String strParams = "";
            if (StringHelper.Compare((String)strDetailType, (String)"DER1N", (boolean)true) == 0) {
                strParams = String.valueOf(strParams) + "IFMODE=DER1N\r\n";
                strParams = String.valueOf(strParams) + StringHelper.Format((String)"DERID=%1$s\r\n", (Object)iDERGroupDetailHelper.getDER1NId());
                if (!StringHelper.IsNullOrEmpty((String)iDERGroupDetailHelper.getUrlParam())) {
                    strParams = String.valueOf(strParams) + StringHelper.Format((String)"APPENDPARAMS=%1$s\r\n", (Object)iDERGroupDetailHelper.getUrlParam());
                }
            }
            strParams = String.valueOf(strParams) + StringHelper.Format((String)"HEIGHT=%1$s\r\n", (Object)nHeight);
            dpRawItemNode.SetExtValue("CONTENT", strParams);
            newTabPageNode.AddNode(dpRawItemNode);
            parentNode.AddNode(nPos, newTabPageNode);
            ++nPos;
        }
    }
}

