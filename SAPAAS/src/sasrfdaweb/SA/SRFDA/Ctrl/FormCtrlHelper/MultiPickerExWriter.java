/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MultiPickerExWriter
extends BaseFormCtrlWriter {
    private static final Log log = LogFactory.getLog(MultiPickerExWriter.class);
    public static final String TAG_PICKUPPAGEID = "PICKUPPAGEID";
    public static final String TAG_SHOWBUTTON = "SHOWBUTTON";
    public static final String TAG_ACHIDETRIGGER = "ACHIDETRIGGER";
    public static final String TAG_ACUSERMODE = "ACUSERMODE";
    public static final String TAG_TBDV = "TBDV";
    public static final String TAG_TBDV2 = "TBDV2";
    public static final String TAG_TBDVT = "TBDVT";
    public static final String TAG_TBDVT2 = "TBDVT2";
    public static final String TAG_APPENDURLPARAMS = "APPENDURLPARAMS";
    public static final String TAG_ACUSERPARAMSEX = "ACUSERPARAMSEX";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        ILinkDEFHelper pickupTextDEFHelper;
        IPickupDEFHelper iPickupDEFHelper;
        block25: {
            iPickupDEFHelper = null;
            pickupTextDEFHelper = null;
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) == 0) {
                    ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                    if (!(linkDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) {
                        log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPickupDEFHelper]\uff0c\u65e0\u6cd5\u6784\u5efa\u8868\u5355\u5bf9\u8c61", (Object)iDEFHelper.GetFullName()));
                        return null;
                    }
                    iPickupDEFHelper = (IPickupDEFHelper)linkDEFHelper.GetRelatedDEFHelper();
                    pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
                    break block25;
                } else {
                    if (ctrlParams != null) {
                        return this.OnGetFormCtrlNode2(iDEFHelper, formCtrlConfig, bSearchMode, ctrlParams);
                    }
                    log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPickupDEFHelper]\uff0c\u65e0\u6cd5\u6784\u5efa\u8868\u5355\u5bf9\u8c61", (Object)iDEFHelper.GetFullName()));
                    return null;
                }
            }
            iPickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
        }
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXMULTIPICKER");
        String strRangeCond = "";
        String strResetCond = "";
        DER1N der1N = new DER1N();
        CallResult callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(iPickupDEFHelper.GetDERId(), der1N);
        if (callResult.getRetCode() == 0) {
            strRangeCond = der1N.getRANGECOND();
        }
        if (this.IsShowButton()) {
            String strAppendFormParams;
            String strDialogStatus;
            String strDialogScroll;
            String strDialogResizable;
            int nDialogHeight;
            int nDialogWidth;
            String strDialogURL;
            block26: {
                String strAppendURLParams;
                String strPickupPageId = this.GetPickupPageId();
                if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                    strPickupPageId = der1N.getMPICKUPPAGEID();
                }
                if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                    strPickupPageId = iPickupDEFHelper.GetRealDEFHelper().getDEHelper().GetMPickupPageId();
                }
                if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                    strPickupPageId = "PAGE_00014";
                }
                strDialogURL = "";
                nDialogWidth = 960;
                nDialogHeight = 600;
                strDialogResizable = "yes";
                strDialogScroll = "yes";
                strDialogStatus = "no";
                strAppendFormParams = "";
                if (!StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                    Page pickupPage = new Page();
                    callResult = this.globalHelperEx.getDAModelHelper().GetPage(strPickupPageId, pickupPage);
                    if (callResult == null || callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u9875\u9762\u5b9e\u4f53[%1$s]", (Object)strPickupPageId));
                        return null;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)pickupPage.GetTotalPagePath())) {
                        strDialogURL = pickupPage.GetTotalPagePath();
                    }
                    if (pickupPage.getWIDTH() != 0) {
                        nDialogWidth = pickupPage.getWIDTH();
                    }
                    if (pickupPage.getHEIGHT() != 0) {
                        nDialogHeight = pickupPage.getHEIGHT();
                    }
                }
                if (StringHelper.IsNullOrEmpty((String)(strAppendURLParams = this.GetAppendURLParams()))) {
                    strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
                    strDialogURL = String.valueOf(strDialogURL) + strAppendURLParams;
                }
                strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
                strDialogURL = String.valueOf(strDialogURL) + StringHelper.Format((String)"SRFDEFID=%1$s&SRFDEID=%4$s&ITEMSEPERATOR=%%3B", (Object)iDEFHelper.getId(), (Object)iPickupDEFHelper.GetRelatedDEFHelper().getName(), (Object)pickupTextDEFHelper.GetRelatedDEFHelper().getName(), (Object)iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().getId());
                if (!bSearchMode && !StringHelper.IsNullOrEmpty((String)strRangeCond)) {
                    try {
                        Properties properties = PropertiesHelper.Load((String)strRangeCond);
                        Enumeration<Object> en = properties.keys();
                        if (!en.hasMoreElements()) break block26;
                        String strKey = (String)en.nextElement();
                        String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                        IDEFHelper rcDEFHelper = iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().GetDEFHelper(strKey);
                        if (rcDEFHelper == null) {
                            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8303\u56f4\u6761\u4ef6\u4e2d\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKey));
                            break block26;
                        }
                        if (!(rcDEFHelper instanceof ILinkDEFHelper)) {
                            log.error((Object)StringHelper.Format((String)"\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u4e0d\u662f\u5173\u7cfb\u5c5e\u6027", (Object)strKey));
                        } else {
                            ILinkDEFHelper rcLinkDEFHelper = (ILinkDEFHelper)rcDEFHelper;
                            String strDERId = rcLinkDEFHelper.GetDERId();
                            String strRelatedName = rcLinkDEFHelper.GetRelatedDEFHelper().getName();
                            strAppendFormParams = String.valueOf(strRelatedName) + "|" + strValue;
                            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
                            strDialogURL = String.valueOf(strDialogURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFDERID", (Object)strDERId);
                            strResetCond = strValue;
                            formCtrlConfig.SetValue("RESETCOND", strResetCond);
                            formCtrlConfig.SetValue("ENABLECOND", StringHelper.Format((String)"dp.Val(\"%1$s\")+\"!=''\"", (Object)strValue));
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
            }
            ctrlNode.SetValue("DIALOGURL", strDialogURL);
            ctrlNode.SetValue("DIALOGWIDTH", String.valueOf(nDialogWidth));
            ctrlNode.SetValue("DIALOGHEIGHT", String.valueOf(nDialogHeight));
            ctrlNode.SetValue("DIALOGRESIZABLE", strDialogResizable);
            ctrlNode.SetValue("DIALOGSCROLL", strDialogScroll);
            ctrlNode.SetValue("DIALOGSTATUS", strDialogStatus);
            ctrlNode.SetValue("APPENDFORMPARAMS", strAppendFormParams);
        } else {
            ctrlNode.SetValue(TAG_SHOWBUTTON, "FALSE");
        }
        XMLNode childNode = new XMLNode();
        childNode.setNodeName("TEXT");
        ctrlNode.AddNode(childNode);
        childNode.setID(pickupTextDEFHelper.GetFormCtrl().GetFormCtrlId());
        if (iDEFHelper.GetFormCtrl() != null) {
            MultiPickerExWriter.CopyCtrlParams(childNode, ctrlParams);
        }
        String strAllowEmpty = formCtrlConfig.GetExtValue("ALLOWEMPTY", "");
        XMLNode itemNode = MultiPickerExWriter.AppendFormItemNode(this.globalHelperEx, (IDEFHelper)pickupTextDEFHelper, formCtrlConfig, childNode, this.strLanguage);
        itemNode.SetValue("ALLOWEMPTY", "TRUE");
        itemNode.SetValue("MAXLENGTH", bSearchMode ? "655350" : "65535");
        if (ctrlParams != null) {
            String strTBDV = ctrlParams.get(TAG_TBDV);
            String strTBDV2 = ctrlParams.get(TAG_TBDV2);
            String strTBDVT = ctrlParams.get(TAG_TBDVT);
            String strTBDVT2 = ctrlParams.get(TAG_TBDVT2);
            itemNode.SetValue("DV", strTBDV);
            itemNode.SetValue("DV2", strTBDV2);
            itemNode.SetValue("DVT", strTBDVT);
            itemNode.SetValue("DVT2", strTBDVT2);
            ctrlParams.remove(TAG_TBDV);
            ctrlParams.remove(TAG_TBDV2);
            ctrlParams.remove(TAG_TBDVT);
            ctrlParams.remove(TAG_TBDVT2);
        }
        formCtrlConfig.SetValue("ALLOWEMPTY", strAllowEmpty);
        return ctrlNode;
    }

    protected XMLNode OnGetFormCtrlNode2(IDEFHelper iDEFHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXMULTIPICKER");
        this.AppendPickupConfig(ctrlNode, iDEFHelper, formCtrlConfig, bSearchMode, ctrlParams);
        String strAllowEmpty = formCtrlConfig.GetExtValue("ALLOWEMPTY", "");
        formCtrlConfig.SetValue("ALLOWEMPTY", strAllowEmpty);
        return ctrlNode;
    }

    protected void AppendPickupConfig(XMLNode ctrlNode, IDEFHelper iDEFHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        String strAppendURLParams;
        String strPickupDEId = MultiPickerExWriter.GetCtrlParam(ctrlParams, "PICKUPDE", "");
        String strPickupPageId = MultiPickerExWriter.GetCtrlParam(ctrlParams, TAG_PICKUPPAGEID, "");
        String strDialogURL = MultiPickerExWriter.GetCtrlParam(ctrlParams, "DIALOGURL", "");
        String strPickupTextItem = ctrlParams.get("PICKUPTEXTITEM");
        String strVDEFName = "";
        if (StringHelper.IsNullOrEmpty((String)strPickupDEId) && StringHelper.IsNullOrEmpty((String)strPickupPageId) && StringHelper.IsNullOrEmpty((String)strDialogURL)) {
            log.error((Object)"\u9009\u62e9\u9875\u9762\u914d\u7f6e\u65e0\u6548\uff0c\u5b9e\u4f53\u3001\u9875\u9762\u3001\u9875\u9762\u8def\u5f84\u5fc5\u987b\u81f3\u5c11\u6307\u5b9a\u4e00\u4e2a");
            return;
        }
        int nDialogWidth = 990;
        int nDialogHeight = 600;
        if (StringHelper.IsNullOrEmpty((String)strDialogURL)) {
            IDEHelper iPickupDEHelper;
            if (!StringHelper.IsNullOrEmpty((String)strPickupDEId) && StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                iPickupDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strPickupDEId);
                if (iPickupDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPickupDEId));
                    return;
                }
                strPickupPageId = iPickupDEHelper.GetMPickupPageId();
                if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                    strPickupPageId = "PAGE_00014";
                }
                strVDEFName = iPickupDEHelper.GetKeyDEFHelper().getName();
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
            if (StringHelper.IsNullOrEmpty((String)strPickupTextItem)) {
                strPickupTextItem = "TB_" + iDEFHelper.getDEField().getDEFNAME();
            }
            if (!StringHelper.IsNullOrEmpty((String)strPickupDEId) && StringHelper.IsNullOrEmpty((String)strVDEFName) && (iPickupDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strPickupDEId)) != null) {
                strVDEFName = iPickupDEHelper.GetKeyDEFHelper().getName();
            }
            strDialogURL = String.valueOf(strDialogURL) + StringHelper.Format((String)"SRFDEFID=%1$s&SRFDEID=%4$s&ITEMSEPERATOR=%%3B", (Object)iDEFHelper.getId(), (Object)strVDEFName, (Object)strPickupTextItem, (Object)strPickupDEId);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strAppendURLParams = MultiPickerExWriter.GetCtrlParam(ctrlParams, TAG_APPENDURLPARAMS, this.formCtrlHelperConfig.GetExtValue(TAG_APPENDURLPARAMS, ""))))) {
            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
            strDialogURL = String.valueOf(strDialogURL) + strAppendURLParams;
        }
        String strDialogResizable = MultiPickerExWriter.GetCtrlParam(ctrlParams, "DIALOGRESIZABLE", "yes");
        String strDialogScroll = MultiPickerExWriter.GetCtrlParam(ctrlParams, "DIALOGSCROLL", "yes");
        String strDialogStatus = MultiPickerExWriter.GetCtrlParam(ctrlParams, "DIALOGSTATUS", "no");
        ctrlNode.SetValue("DIALOGURL", strDialogURL);
        ctrlNode.SetValue("DIALOGWIDTH", MultiPickerExWriter.GetCtrlParam(ctrlParams, "DIALOGWIDTH", String.valueOf(nDialogWidth)));
        ctrlNode.SetValue("DIALOGHEIGHT", MultiPickerExWriter.GetCtrlParam(ctrlParams, "DIALOGHEIGHT", String.valueOf(nDialogHeight)));
        ctrlNode.SetValue("DIALOGRESIZABLE", strDialogResizable);
        ctrlNode.SetValue("DIALOGSCROLL", strDialogScroll);
        ctrlNode.SetValue("DIALOGSTATUS", strDialogStatus);
        ctrlNode.SetValue("APPENDFORMPARAMS", MultiPickerExWriter.GetCtrlParam(ctrlParams, "APPENDFORMPARAMS", ""));
    }

    @Override
    protected XMLNode OnAppendFormItemNode(IDEFHelper helper, XMLNode formCtrlConfig, XMLNode ctrlNode) {
        return super.OnAppendFormItemNode(helper, formCtrlConfig, ctrlNode);
    }

    protected String GetPickupPageId() {
        return this.formCtrlHelperConfig.GetExtValue(TAG_PICKUPPAGEID, "");
    }

    protected String GetAppendURLParams() {
        return this.formCtrlHelperConfig.GetExtValue(TAG_APPENDURLPARAMS, "");
    }

    protected boolean IsShowButton() {
        return this.formCtrlHelperConfig.GetExtValue(TAG_SHOWBUTTON, true);
    }

    protected boolean IsReadOnly(boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        return bSearchMode;
    }
}

