/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DEShortcut
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DEShortcut;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.FormCtrlHelper.BaseFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PickerExWriter
extends BaseFormCtrlWriter {
    private static final Log log = LogFactory.getLog(PickerExWriter.class);
    public static final String TAG_PICKUPPAGEID = "PICKUPPAGEID";
    public static final String TAG_EDITPAGEID = "EDITPAGEID";
    public static final String TAG_SHOWBUTTON = "SHOWBUTTON";
    public static final String TAG_DATALINK = "DATALINK";
    public static final String TAG_ACHIDETRIGGER = "ACHIDETRIGGER";
    public static final String TAG_ACUSERMODE = "ACUSERMODE";
    public static final String TAG_TBDV = "TBDV";
    public static final String TAG_TBDV2 = "TBDV2";
    public static final String TAG_TBDVT = "TBDVT";
    public static final String TAG_TBDVT2 = "TBDVT2";
    public static final String TAG_PICKUPDE = "PICKUPDE";
    public static final String TAG_PICKUPTEXTITEM = "PICKUPTEXTITEM";
    public static final String TAG_APPENDURLPARAMS = "APPENDURLPARAMS";
    public static final String TAG_ACUSERPARAMSEX = "ACUSERPARAMSEX";

    /*
     * Unable to fully structure code
     */
    @Override
    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        iPickupDEFHelper = null;
        pickupTextDEFHelper = null;
        strPickupDEId = "";
        strPickupTextItem = "";
        bPickupDEMode = false;
        iPickupDEHelper = null;
        iTextDEFHelper = null;
        if (iDEFHelper instanceof IPickupDEFHelper) ** GOTO lbl36
        if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) != 0) ** GOTO lbl18
        linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
        if (linkDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper) {
            iPickupDEFHelper = (IPickupDEFHelper)linkDEFHelper.GetRelatedDEFHelper();
            pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
            iPickupDEHelper = iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper();
        } else {
            PickerExWriter.log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPickupDEFHelper]\uff0c\u65e0\u6cd5\u6784\u5efa\u8868\u5355\u5bf9\u8c61", (Object)iDEFHelper.GetFullName()));
            return null;
lbl18:
            // 1 sources

            if (ctrlParams != null) {
                strPickupDEId = ctrlParams.get("PICKUPDE");
                strPickupTextItem = ctrlParams.get("PICKUPTEXTITEM");
                if (StringHelper.IsNullOrEmpty((String)strPickupDEId) || StringHelper.IsNullOrEmpty((String)strPickupTextItem)) {
                    PickerExWriter.log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPickupDEFHelper]\uff0c\u65e0\u6cd5\u6784\u5efa\u8868\u5355\u5bf9\u8c61", (Object)iDEFHelper.GetFullName()));
                    return null;
                }
                iPickupDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(strPickupDEId);
                if (iPickupDEHelper == null) {
                    PickerExWriter.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPickupDEId));
                    return null;
                }
                iTextDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strPickupTextItem);
                if (iTextDEFHelper == null) {
                    PickerExWriter.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s:%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPickupDEId, (Object)strPickupTextItem));
                    return null;
                }
                bPickupDEMode = true;
            } else {
                PickerExWriter.log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPickupDEFHelper]\uff0c\u65e0\u6cd5\u6784\u5efa\u8868\u5355\u5bf9\u8c61", (Object)iDEFHelper.GetFullName()));
                return null;
lbl36:
                // 1 sources

                iPickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
                pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
                iPickupDEHelper = iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper();
            }
        }
        ctrlNode = new XMLNode();
        ctrlNode.setNodeName("SRFEXPICKEREX");
        strRangeCond = "";
        strResetCond = "";
        der1N = new DER1N();
        callResult = new CallResult();
        if (!bPickupDEMode && (callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(iPickupDEFHelper.GetDERId(), der1N)).getRetCode() == 0) {
            strRangeCond = der1N.getRANGECOND();
        }
        if (this.IsShowButton()) {
            strPickupPageId = this.GetPickupPageId(ctrlParams);
            if (!bPickupDEMode && StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                strPickupPageId = der1N.getPICKUPPAGEID();
            }
            if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                strPickupPageId = iPickupDEHelper.GetPickupPageId();
            }
            strDialogURL = "../srfpage/pickupview.jsp";
            nDialogWidth = 0;
            nDialogHeight = 0;
            strDialogResizable = "yes";
            strDialogScroll = "yes";
            strDialogStatus = "no";
            strAppendFormParams = "";
            if (!StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                pickupPage = new Page();
                callResult = this.globalHelperEx.getDAModelHelper().GetPage(strPickupPageId, pickupPage);
                if (callResult == null || callResult.getRetCode() != 0) {
                    PickerExWriter.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u9875\u9762\u5b9e\u4f53[%1$s]", (Object)strPickupPageId));
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
            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
            strDialogURL = bPickupDEMode != false ? String.valueOf(strDialogURL) + StringHelper.Format((String)"SRFDEFID=%1$s&SRFDEID=%4$s", (Object)iDEFHelper.getId(), (Object)iPickupDEHelper.GetKeyDEFHelper().getName(), (Object)iPickupDEHelper.GetMajorDEFHelper().getName(), (Object)iPickupDEHelper.getId()) : String.valueOf(strDialogURL) + StringHelper.Format((String)"SRFDEFID=%1$s&SRFDEID=%4$s&SRFDER1NID=%5$s", (Object)iDEFHelper.getId(), (Object)iPickupDEFHelper.GetRelatedDEFHelper().getName(), (Object)pickupTextDEFHelper.GetRelatedDEFHelper().getName(), (Object)iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().getId(), (Object)iPickupDEFHelper.GetDERId());
            strAppendURLParams = this.GetAppendURLParams(ctrlParams);
            if (StringHelper.IsNullOrEmpty((String)strAppendURLParams)) {
                strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
                strDialogURL = String.valueOf(strDialogURL) + strAppendURLParams;
            }
            if (!bSearchMode) {
                strURL = "../srfpage/editview.jsp?";
                nWidth = 980;
                nHeight = 680;
                strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
                strEditPageId = this.GetEditPageId(ctrlParams);
                if (StringHelper.IsNullOrEmpty((String)strEditPageId)) {
                    strEditPageId = iPickupDEHelper.GetInfoPageId();
                }
                if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
                    editPage = this.globalHelperEx.getDAModelStorage().FindPage(strEditPageId);
                    if (editPage == null) {
                        PickerExWriter.log.error((Object)"\u83b7\u53d6\u9875\u9762\u4fe1\u606f\u5931\u8d25");
                        return null;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                        strURL = editPage.GetTotalPagePath();
                    }
                    if (editPage.getWIDTH() != 0) {
                        nWidth = editPage.getWIDTH();
                    }
                    if (editPage.getHEIGHT() != 0) {
                        nHeight = editPage.getHEIGHT();
                    }
                    if (!StringHelper.IsNullOrEmpty((String)editPage.getWINDOWSTYLE())) {
                        strWindowStyle = editPage.getWINDOWSTYLE();
                    }
                }
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = String.valueOf(strURL) + StringHelper.Format((String)"SRFDEID=%1$s", (Object)iPickupDEHelper.getId());
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = bPickupDEMode != false ? String.valueOf(strURL) + iPickupDEHelper.GetKeyDEFHelper().getName() : String.valueOf(strURL) + iPickupDEFHelper.GetRealDEFHelper().getName();
                strURL = String.valueOf(strURL) + "=";
                if (this.GetPickupDataLink(ctrlParams)) {
                    if (StringHelper.Compare((String)this.strPageModel, (String)"SL", (boolean)true) == 0) {
                        jo = new JSONObject();
                        jo.put("url", (Object)strURL);
                        jo.put("width", nWidth);
                        jo.put("height", nHeight);
                        ctrlNode.SetValue("DATALINKJSCODE", jo.toString());
                    } else {
                        strDataLinkJSCode = StringHelper.Format((String)"var _URL='%1$s'+_V;", (Object)strURL);
                        strDataLinkJSCode = String.valueOf(strDataLinkJSCode) + StringHelper.Format((String)"window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle);
                        ctrlNode.SetValue("DATALINKJSCODE", strDataLinkJSCode);
                    }
                }
                deShortcuts = new Vector<E>();
                callResult = this.globalHelperEx.getDAModelHelper().GetDEShortcuts(iPickupDEHelper.getId(), 1, deShortcuts);
                if (callResult.IsError()) {
                    PickerExWriter.log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u5feb\u6377\u65b9\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)iPickupDEHelper.getId(), (Object)callResult.getErrorInfo()));
                    return null;
                }
                if (deShortcuts.size() > 0) {
                    dataLinksNode = new XMLNode();
                    dataLinksNode.setNodeName("SRFEXDATALINK");
                    ctrlNode.AddNode(dataLinksNode);
                    for (DEShortcut shortCut : deShortcuts) {
                        dataLinkNode = new XMLNode();
                        dataLinkNode.setNodeName("SRFEXDATALINK");
                        dataLinksNode.AddNode(dataLinkNode);
                        if (!StringHelper.IsNullOrEmpty((String)shortCut.getICONPATH())) {
                            dataLinkNode.SetValue("DATALINKIMAGE", shortCut.getICONPATH());
                        }
                        dataLinkNode.SetValue("DATALINKTIPMESSAGE", shortCut.getDESHORTCUTNAME());
                        dataLinkNode.SetValue("DATALINKJSCODE", shortCut.getJSCODE());
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)strRangeCond)) {
                    try {
                        nIndex = false;
                        properties = PropertiesHelper.Load((String)strRangeCond);
                        en = properties.keys();
                        while (en.hasMoreElements()) {
                            strKey = (String)en.nextElement();
                            strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                            rcDEFHelper = iPickupDEHelper.GetDEFHelper(strKey);
                            if (rcDEFHelper == null) {
                                PickerExWriter.log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8303\u56f4\u6761\u4ef6\u4e2d\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKey));
                                rcDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strValue);
                                if (rcDEFHelper == null) {
                                    PickerExWriter.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5728\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strValue));
                                    break;
                                }
                                if (!StringHelper.IsNullOrEmpty((String)strAppendFormParams)) {
                                    strAppendFormParams = String.valueOf(strAppendFormParams) + ",";
                                }
                                strAppendFormParams = String.valueOf(strAppendFormParams) + strKey + "|" + strValue;
                                strResetCond = formCtrlConfig.GetExtValue("RESETCOND", "");
                                if (!StringHelper.IsNullOrEmpty((String)strResetCond)) {
                                    strResetCond = String.valueOf(strResetCond) + ";";
                                }
                                strResetCond = String.valueOf(strResetCond) + strValue;
                                formCtrlConfig.SetValue("RESETCOND", strResetCond);
                                strLastCode = formCtrlConfig.GetExtValue("ENABLECOND", "");
                                if (StringHelper.IsNullOrEmpty((String)strLastCode)) {
                                    formCtrlConfig.SetValue("ENABLECOND", StringHelper.Format((String)"dp.Val(\"%1$s\")+\"!=''\"", (Object)strValue));
                                    continue;
                                }
                                strNewCode = "'('+" + strLastCode + "+')&&('+" + StringHelper.Format((String)"dp.Val(\"%1$s\")+\"!=''\"", (Object)strValue) + "+')'";
                                formCtrlConfig.SetValue("ENABLECOND", strNewCode);
                                continue;
                            }
                            if (!(rcDEFHelper instanceof ILinkDEFHelper)) {
                                PickerExWriter.log.error((Object)StringHelper.Format((String)"\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u4e0d\u662f\u5173\u7cfb\u5c5e\u6027", (Object)strKey));
                                break;
                            }
                            rcLinkDEFHelper = (ILinkDEFHelper)rcDEFHelper;
                            strDERId = rcLinkDEFHelper.GetDERId();
                            strRelatedName = rcLinkDEFHelper.GetRelatedDEFHelper().getName();
                            if (!StringHelper.IsNullOrEmpty((String)strAppendFormParams)) {
                                strAppendFormParams = String.valueOf(strAppendFormParams) + ",";
                            }
                            strAppendFormParams = String.valueOf(strAppendFormParams) + strRelatedName + "|" + strValue;
                            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
                            strDialogURL = String.valueOf(strDialogURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)"SRFDERID", (Object)strDERId);
                            strResetCond = formCtrlConfig.GetExtValue("RESETCOND", "");
                            if (!StringHelper.IsNullOrEmpty((String)strResetCond)) {
                                strResetCond = String.valueOf(strResetCond) + ";";
                            }
                            strResetCond = String.valueOf(strResetCond) + strValue;
                            formCtrlConfig.SetValue("RESETCOND", strResetCond);
                            strLastCode = formCtrlConfig.GetExtValue("ENABLECOND", "");
                            if (StringHelper.IsNullOrEmpty((String)strLastCode)) {
                                formCtrlConfig.SetValue("ENABLECOND", StringHelper.Format((String)"dp.Val(\"%1$s\")+\"!=''\"", (Object)strValue));
                                continue;
                            }
                            strNewCode = "'('+" + strLastCode + "+')&&('+" + StringHelper.Format((String)"dp.Val(\"%1$s\")+\"!=''\"", (Object)strValue) + "+')'";
                            formCtrlConfig.SetValue("ENABLECOND", strNewCode);
                        }
                    }
                    catch (Exception ex) {
                        PickerExWriter.log.error((Object)ex);
                    }
                }
            }
            ctrlNode.SetValue("DIALOGURL", strDialogURL);
            if (nDialogWidth != 800) {
                ctrlNode.SetValue("DIALOGWIDTH", String.valueOf(nDialogWidth));
            }
            if (nDialogHeight != 600) {
                ctrlNode.SetValue("DIALOGHEIGHT", String.valueOf(nDialogHeight));
            }
            if (StringHelper.Compare((String)strDialogResizable, (String)"no", (boolean)true) != 0) {
                ctrlNode.SetValue("DIALOGRESIZABLE", strDialogResizable);
            }
            if (StringHelper.Compare((String)strDialogScroll, (String)"yes", (boolean)true) != 0) {
                ctrlNode.SetValue("DIALOGSCROLL", strDialogScroll);
            }
            if (StringHelper.Compare((String)strDialogStatus, (String)"no", (boolean)true) != 0) {
                ctrlNode.SetValue("DIALOGSTATUS", strDialogStatus);
            }
            ctrlNode.SetValue("APPENDFORMPARAMS", strAppendFormParams);
        } else {
            ctrlNode.SetValue("SHOWBUTTON", "FALSE");
        }
        strTipsInfo = iPickupDEHelper.getDataEntity().getTIPSINFO();
        strTipsObject = iPickupDEHelper.getDataEntity().getTIPSOBJECT();
        if (!StringHelper.IsNullOrEmpty((String)strTipsInfo) || !StringHelper.IsNullOrEmpty((String)strTipsObject)) {
            strTooltipURL = StringHelper.Format((String)"../srfpage/tooltipsbackend.jsp?SRFDEID=%1$s&%2$s=", (Object)iPickupDEHelper.getId(), (Object)iPickupDEHelper.GetKeyDEFHelper().getName());
            ctrlNode.SetValue("TOOLTIPURL", strTooltipURL);
        }
        childNode = new XMLNode();
        childNode.setNodeName("SRFEXTEXTBOX");
        ctrlNode.AddNode(childNode);
        if (bPickupDEMode) {
            childNode.setID(iTextDEFHelper.GetFormCtrl().GetFormCtrlId());
        } else {
            childNode.setID(pickupTextDEFHelper.GetFormCtrl().GetFormCtrlId());
        }
        if (iDEFHelper.GetFormCtrl() != null) {
            PickerExWriter.CopyCtrlParams(childNode, ctrlParams);
        }
        strAllowEmpty = formCtrlConfig.GetExtValue("ALLOWEMPTY", "");
        itemNode = PickerExWriter.AppendFormItemNode(this.globalHelperEx, (IDEFHelper)(bPickupDEMode != false ? iTextDEFHelper : pickupTextDEFHelper), formCtrlConfig, childNode, this.strLanguage);
        itemNode.SetValue("ALLOWEMPTY", "TRUE");
        itemNode.SetValue("MAXLENGTH", "65535");
        if (ctrlParams != null) {
            strTBDV = ctrlParams.get("TBDV");
            strTBDV2 = ctrlParams.get("TBDV2");
            strTBDVT = ctrlParams.get("TBDVT");
            strTBDVT2 = ctrlParams.get("TBDVT2");
            itemNode.SetValue("DV", strTBDV);
            itemNode.SetValue("DV2", strTBDV2);
            itemNode.SetValue("DVT", strTBDVT);
            itemNode.SetValue("DVT2", strTBDVT2);
            ctrlParams.remove("TBDV");
            ctrlParams.remove("TBDV2");
            ctrlParams.remove("TBDVT");
            ctrlParams.remove("TBDVT2");
        }
        formCtrlConfig.SetValue("ALLOWEMPTY", strAllowEmpty);
        if (this.IsEnableAC()) {
            strACAppendURLParams = "";
            strACAppendFormParams = "";
            if (!StringHelper.IsNullOrEmpty((String)strRangeCond)) {
                try {
                    properties = PropertiesHelper.Load((String)strRangeCond);
                    en = properties.keys();
                    if (en.hasMoreElements()) {
                        strKey = (String)en.nextElement();
                        strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                        rcDEFHelper = iPickupDEHelper.GetDEFHelper(strKey);
                        if (rcDEFHelper == null) {
                            PickerExWriter.log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8303\u56f4\u6761\u4ef6\u4e2d\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKey));
                            rcDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strValue);
                            if (rcDEFHelper == null) {
                                PickerExWriter.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5728\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strValue));
                            } else {
                                strACAppendFormParams = String.valueOf(strKey) + "|" + strValue;
                            }
                        } else if (!(rcDEFHelper instanceof ILinkDEFHelper)) {
                            PickerExWriter.log.error((Object)StringHelper.Format((String)"\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u4e0d\u662f\u5173\u7cfb\u5c5e\u6027", (Object)strKey));
                        } else {
                            rcLinkDEFHelper = (ILinkDEFHelper)rcDEFHelper;
                            strDERId = rcLinkDEFHelper.GetDERId();
                            strACAppendURLParams = StringHelper.Format((String)"SRFDERID=%1$s", (Object)strDERId);
                            strRelatedName = rcLinkDEFHelper.GetRelatedDEFHelper().getName();
                            strACAppendFormParams = String.valueOf(strRelatedName) + "|" + strValue;
                        }
                    }
                }
                catch (Exception ex) {
                    PickerExWriter.log.error((Object)ex);
                }
            }
            strACAppendFormParams = PickerExWriter.GetCtrlParam(ctrlParams, "ACAPPENDFORMPARAMS", strACAppendFormParams);
            if (iPickupDEFHelper != null) {
                if (!StringHelper.IsNullOrEmpty((String)strACAppendURLParams)) {
                    strACAppendURLParams = String.valueOf(strACAppendURLParams) + "&";
                }
                strACAppendURLParams = String.valueOf(strACAppendURLParams) + StringHelper.Format((String)"SRFDER1NID=%1$s", (Object)iPickupDEFHelper.GetDERId());
            }
            if (!StringHelper.IsNullOrEmpty((String)(strUserACAppendURLParams = PickerExWriter.GetCtrlParam(ctrlParams, "ACAPPENDURLPARAMS", "")))) {
                if (!StringHelper.IsNullOrEmpty((String)strACAppendURLParams)) {
                    strACAppendURLParams = String.valueOf(strACAppendURLParams) + "&";
                }
                strACAppendURLParams = String.valueOf(strACAppendURLParams) + strUserACAppendURLParams;
            }
            childNode.SetValue("ACAPPENDURLPARAMS", strACAppendURLParams);
            childNode.SetValue("ACAPPENDFORMPARAMS", strACAppendFormParams);
            childNode.SetValue("ACMODE", "SRFDAAC");
            childNode.SetValue("ACHIDETRIGGER", this.IsHideACTrigger() != false ? "TRUE" : "FALSE");
            if (!this.IsHideACTrigger()) {
                childNode.SetValue("ACWIDTHMODE", "TRUE");
            }
            childNode.SetValue("FORCESELECTION", "TRUE");
            strACUserParams = StringHelper.Format((String)"srfdeid:'%1$s'", (Object)iPickupDEHelper.getId());
            strACUserMode = "";
            if (ctrlParams != null) {
                strACUserMode = ctrlParams.get("ACUSERMODE");
                ctrlParams.remove("ACUSERMODE");
            }
            if (StringHelper.IsNullOrEmpty((String)strACUserMode)) {
                strACUserMode = der1N.getDEACMODENAME();
            }
            if (!StringHelper.IsNullOrEmpty((String)strACUserMode)) {
                strACUserParams = String.valueOf(strACUserParams) + StringHelper.Format((String)",acusermode:'%1$s'", (Object)strACUserMode);
            }
            childNode.SetValue("ACUSERPARAMS", strACUserParams);
            childNode.SetValue("ACLISTWIDTH", this.GetACListWidth(ctrlParams));
            childNode.SetValue("ACCARETFORMPARAMS", this.GetACCaretFormParams(ctrlParams));
            childNode.SetValue("ACMINCHARS", this.GetACMinchars(ctrlParams));
        } else {
            ctrlNode.SetValue("PICKONLY", "TRUE");
        }
        if (iDEFHelper.GetFormCtrl().IsEnableFormCreate() && iDEFHelper.GetFormCtrl().IsEnableFormUpdate()) {
            itemNode.SetValue("ENABLECOND", "ALL");
        } else if (iDEFHelper.GetFormCtrl().IsEnableFormCreate()) {
            itemNode.SetValue("ENABLECOND", "CREATE");
        } else if (iDEFHelper.GetFormCtrl().IsEnableFormUpdate()) {
            itemNode.SetValue("ENABLECOND", "UPDATE");
        } else {
            itemNode.SetValue("ENABLECOND", "NONE");
        }
        itemNode.SetValue("VALIDCOND", itemNode.GetExtValue("ENABLECOND", ""));
        itemNode.RemoveExtValue("ALLOWEMPTYCOND");
        return ctrlNode;
    }

    @Override
    protected XMLNode OnAppendFormItemNode(IDEFHelper helper, XMLNode formCtrlConfig, XMLNode ctrlNode) {
        return super.OnAppendFormItemNode(helper, formCtrlConfig, ctrlNode);
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

    protected boolean GetPickupDataLink(TreeMap<String, String> ctrlParams) {
        String strDataLink;
        if (ctrlParams != null && !StringHelper.IsNullOrEmpty((String)(strDataLink = ctrlParams.get(TAG_DATALINK)))) {
            return StringHelper.Compare((String)strDataLink, (String)"FALSE", (boolean)true) != 0;
        }
        return true;
    }

    protected String GetACMinchars(TreeMap<String, String> ctrlParams) {
        String strACMinchars = this.globalHelperEx.getWebExConfig().GetValue("SRFDA", "ACMINCHARS", "2");
        if (ctrlParams != null) {
            strACMinchars = ctrlParams.get("ACMINCHARS");
            ctrlParams.remove("ACMINCHARS");
        }
        return strACMinchars;
    }

    protected String GetPickupPageId(TreeMap<String, String> ctrlParams) {
        String strPickupPageId;
        if (ctrlParams != null && !StringHelper.IsNullOrEmpty((String)(strPickupPageId = ctrlParams.get(TAG_PICKUPPAGEID)))) {
            return strPickupPageId;
        }
        return this.formCtrlHelperConfig.GetExtValue(TAG_PICKUPPAGEID, "");
    }

    protected String GetEditPageId(TreeMap<String, String> ctrlParams) {
        String strEditPageId;
        if (ctrlParams != null && !StringHelper.IsNullOrEmpty((String)(strEditPageId = ctrlParams.get(TAG_EDITPAGEID)))) {
            return strEditPageId;
        }
        return this.formCtrlHelperConfig.GetExtValue(TAG_EDITPAGEID, "");
    }

    protected String GetAppendURLParams(TreeMap<String, String> ctrlParams) {
        String strAppendUrlParams;
        if (ctrlParams != null && !StringHelper.IsNullOrEmpty((String)(strAppendUrlParams = ctrlParams.get(TAG_APPENDURLPARAMS)))) {
            return strAppendUrlParams;
        }
        return this.formCtrlHelperConfig.GetExtValue(TAG_APPENDURLPARAMS, "");
    }

    protected boolean IsShowButton() {
        return this.formCtrlHelperConfig.GetExtValue(TAG_SHOWBUTTON, true);
    }

    protected boolean IsEnableAC() {
        return this.formCtrlHelperConfig.GetExtValue("AC", true);
    }

    protected boolean IsHideACTrigger() {
        return this.formCtrlHelperConfig.GetExtValue(TAG_ACHIDETRIGGER, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, DGModeDetail dgModeDetail) {
        String strDialogStatus;
        String strDialogScroll;
        String strDialogResizable;
        int nDialogHeight;
        int nDialogWidth;
        String strDialogURL;
        String strAppendFormParams;
        XMLNode ctrlNode;
        TreeMap<String, String> ctrlParams;
        block45: {
            String strACAppendURLParams;
            CallResult callResult;
            DER1N der1N;
            String strRangeCond;
            ILinkDEFHelper pickupTextDEFHelper;
            IPickupDEFHelper iPickupDEFHelper;
            block44: {
                iPickupDEFHelper = null;
                pickupTextDEFHelper = null;
                if (!(iDEFHelper instanceof ILinkDEFHelper)) {
                    if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) != 0) {
                        log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPickupDEFHelper]\uff0c\u65e0\u6cd5\u6784\u5efa\u8868\u683c\u5355\u5143\u7f16\u8f91\u5bf9\u8c61", (Object)iDEFHelper.GetFullName()));
                        return null;
                    }
                    ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                    if (!(linkDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) {
                        log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPickupDEFHelper]\uff0c\u65e0\u6cd5\u6784\u5efa\u8868\u683c\u5355\u5143\u7f16\u8f91\u5bf9\u8c61", (Object)iDEFHelper.GetFullName()));
                        return null;
                    }
                    iPickupDEFHelper = (IPickupDEFHelper)linkDEFHelper.GetRelatedDEFHelper();
                    pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
                } else {
                    iPickupDEFHelper = iDEFHelper.getDEHelper().GetPickupDEFHelper((ILinkDEFHelper)iDEFHelper);
                    pickupTextDEFHelper = iPickupDEFHelper.GetPickupTextDEFHelper();
                }
                ctrlParams = new TreeMap<String, String>();
                if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.getDGItem().GetEditorParam(dgModeDetail))) {
                    try {
                        Properties properties = PropertiesHelper.Load((String)iDEFHelper.getDGItem().GetEditorParam(dgModeDetail));
                        Enumeration<Object> en = properties.keys();
                        while (en.hasMoreElements()) {
                            String strKey = (String)en.nextElement();
                            String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                            ctrlParams.put(strKey.toUpperCase(), strValue);
                        }
                    }
                    catch (Exception ex) {
                        return null;
                    }
                }
                strRangeCond = "";
                der1N = new DER1N();
                callResult = this.globalHelperEx.getDAModelHelper().GetDER1N(iPickupDEFHelper.GetDERId(), der1N);
                if (callResult.getRetCode() == 0) {
                    strRangeCond = der1N.getRANGECOND();
                }
                ctrlNode = new XMLNode();
                ctrlNode.setNodeName("SRFEXDATAGRIDCOLUMNEDITOR");
                ctrlNode.SetValue("OBJECT", "SA.SRFDA.Ctrl.DataGrid.PickupColumnEditor");
                ctrlNode.SetValue("VALUEFIELD", iPickupDEFHelper.getName());
                ctrlNode.SetValue("ACMODE", "SRFDAAC");
                ctrlNode.SetValue("FORCESELECTION", "TRUE");
                String strACUserParams = StringHelper.Format((String)"srfdeid:'%1$s'", (Object)iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().getId());
                String strACUserMode = "";
                if (ctrlParams != null) {
                    strACUserMode = (String)ctrlParams.get(TAG_ACUSERMODE);
                    ctrlParams.remove(TAG_ACUSERMODE);
                }
                if (StringHelper.IsNullOrEmpty((String)strACUserMode)) {
                    strACUserMode = der1N.getDEACMODENAME();
                }
                if (!StringHelper.IsNullOrEmpty((String)strACUserMode)) {
                    strACUserParams = String.valueOf(strACUserParams) + StringHelper.Format((String)",acusermode:'%1$s'", (Object)strACUserMode);
                }
                ctrlNode.SetValue("ACUSERPARAMS", strACUserParams);
                String strACHIDETRIGGER = "";
                if (ctrlParams != null) {
                    strACHIDETRIGGER = (String)ctrlParams.get(TAG_ACHIDETRIGGER);
                    ctrlParams.remove(TAG_ACHIDETRIGGER);
                }
                if (!StringHelper.IsNullOrEmpty((String)strACHIDETRIGGER)) {
                    ctrlNode.SetValue(TAG_ACHIDETRIGGER, strACHIDETRIGGER);
                }
                strAppendFormParams = "";
                strACAppendURLParams = "";
                if (!StringHelper.IsNullOrEmpty((String)strRangeCond)) {
                    try {
                        Properties properties = PropertiesHelper.Load((String)strRangeCond);
                        Enumeration<Object> en = properties.keys();
                        if (!en.hasMoreElements()) break block44;
                        String strKey = (String)en.nextElement();
                        String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                        IDEFHelper rcDEFHelper = iPickupDEFHelper.getDEHelper().GetDEFHelper(strKey);
                        if (rcDEFHelper == null) {
                            log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8303\u56f4\u6761\u4ef6\u4e2d\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKey));
                            rcDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strValue);
                            if (rcDEFHelper == null) {
                                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5728\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strValue));
                                break block44;
                            } else {
                                strAppendFormParams = String.valueOf(strKey) + "|" + strValue;
                            }
                            break block44;
                        }
                        if (!(rcDEFHelper instanceof ILinkDEFHelper)) {
                            log.error((Object)StringHelper.Format((String)"\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u4e0d\u662f\u5173\u7cfb\u5c5e\u6027", (Object)strKey));
                        } else {
                            ILinkDEFHelper rcLinkDEFHelper = (ILinkDEFHelper)rcDEFHelper;
                            String strRelatedName = rcLinkDEFHelper.GetRelatedDEFHelper().getName();
                            String strDERId = rcLinkDEFHelper.GetDERId();
                            strACAppendURLParams = StringHelper.Format((String)"SRFDERID=%1$s", (Object)strDERId);
                            strAppendFormParams = String.valueOf(strRelatedName) + "|" + strValue;
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
            }
            if (iPickupDEFHelper != null) {
                if (!StringHelper.IsNullOrEmpty((String)strACAppendURLParams)) {
                    strACAppendURLParams = String.valueOf(strACAppendURLParams) + "&";
                }
                strACAppendURLParams = String.valueOf(strACAppendURLParams) + StringHelper.Format((String)"SRFDER1NID=%1$s", (Object)iPickupDEFHelper.GetDERId());
            }
            if (ctrlParams != null) {
                String strACAPPENDFORMPARAMS = (String)ctrlParams.get("ACAPPENDFORMPARAMS");
                ctrlParams.remove("ACAPPENDFORMPARAMS");
                if (!StringHelper.IsNullOrEmpty((String)strACAPPENDFORMPARAMS)) {
                    if (!StringHelper.IsNullOrEmpty((String)strAppendFormParams)) {
                        strAppendFormParams = String.valueOf(strAppendFormParams) + ",";
                    }
                    strAppendFormParams = String.valueOf(strAppendFormParams) + strACAPPENDFORMPARAMS;
                }
            }
            if (ctrlParams != null) {
                String strACAPPENDURLPARAMS = (String)ctrlParams.get("ACAPPENDURLPARAMS");
                ctrlParams.remove("ACAPPENDURLPARAMS");
                if (!StringHelper.IsNullOrEmpty((String)strACAPPENDURLPARAMS)) {
                    strACAppendURLParams = String.valueOf(strACAppendURLParams) + "&";
                    strACAppendURLParams = String.valueOf(strACAppendURLParams) + strACAPPENDURLPARAMS;
                }
            }
            ctrlNode.SetValue("ACAPPENDFORMPARAMS", strAppendFormParams);
            ctrlNode.SetValue("ACAPPENDURLPARAMS", strACAppendURLParams);
            String strPickupPageId = this.GetPickupPageId(ctrlParams);
            if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                strPickupPageId = der1N.getPICKUPPAGEID();
            }
            if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
                strPickupPageId = iPickupDEFHelper.GetRealDEFHelper().getDEHelper().GetPickupPageId();
            }
            strDialogURL = "../srfpage/pickupview.jsp";
            nDialogWidth = 800;
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
            }
            strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
            strDialogURL = String.valueOf(strDialogURL) + StringHelper.Format((String)"SRFDEFID=%1$s&SRFDEID=%4$s&SRFDER1NID=%5$S", (Object)iDEFHelper.getId(), (Object)iPickupDEFHelper.GetRelatedDEFHelper().getName(), (Object)pickupTextDEFHelper.GetRelatedDEFHelper().getName(), (Object)iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().getId(), (Object)iPickupDEFHelper.GetDERId());
            String strAppendURLParams = this.GetAppendURLParams(ctrlParams);
            if (StringHelper.IsNullOrEmpty((String)strAppendURLParams)) {
                strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
                strDialogURL = String.valueOf(strDialogURL) + strAppendURLParams;
            }
            if (!StringHelper.IsNullOrEmpty((String)strRangeCond)) {
                try {
                    boolean nIndex = false;
                    Properties properties = PropertiesHelper.Load((String)strRangeCond);
                    Enumeration<Object> en = properties.keys();
                    if (!en.hasMoreElements()) break block45;
                    String strKey = (String)en.nextElement();
                    String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    IDEFHelper rcDEFHelper = iPickupDEFHelper.GetRelatedDEFHelper().getDEHelper().GetDEFHelper(strKey);
                    if (rcDEFHelper == null) {
                        log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8303\u56f4\u6761\u4ef6\u4e2d\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strKey));
                        rcDEFHelper = iDEFHelper.getDEHelper().GetDEFHelper(strValue);
                        if (rcDEFHelper == null) {
                            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5728\u4e3b\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strValue));
                            break block45;
                        } else {
                            strAppendFormParams = String.valueOf(strKey) + "|" + strValue;
                        }
                        break block45;
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
        for (String strKey : ctrlParams.keySet()) {
            ctrlNode.SetValue(strKey, ctrlParams.get(strKey));
        }
        return ctrlNode;
    }
}

