/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.PP.PPDataGrid
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.JSGear;

import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.PP.PPDataGrid;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Web.Default.DefaultPageHelper;
import SA.SRFDA.Web.IDEMainStatePage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.PagePathHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataGridNewEditJSGear {
    private static final Log log = LogFactory.getLog(DataGridNewEditJSGear.class);

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode) {
        return DataGridNewEditJSGear.Load(daPage, dataGrid, bNew, bEdit, bDBClickEditMode, false);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode, boolean bInfoMode) {
        try {
            String strDAParams;
            IDEMainStatePage iDEMainStatePage;
            IDEMainStateHelper iDEMainStateHelper = null;
            if (daPage instanceof IDEMainStatePage && (iDEMainStatePage = (IDEMainStatePage)((Object)daPage)).isEnableDEMainState()) {
                iDEMainStateHelper = iDEMainStatePage.getDEMainState();
            }
            PPDataGrid ppDataGrid = null;
            BaseDataEntity pageParam = daPage.getAdvPageParam(dataGrid.getID().toUpperCase(), "PP_DATAGRID");
            if (pageParam != null && pageParam instanceof PPDataGrid) {
                ppDataGrid = (PPDataGrid)pageParam;
            }
            IDEHelper iDEHelper = daPage.getDEHelper();
            String strPopupMode = daPage.getWebContext().getWebExConfig().GetValue("SRFDA", "POPUPMODE", "WINDOW");
            boolean bShowModal = StringHelper.Compare((String)strPopupMode, (String)"MODAL", (boolean)true) == 0;
            String strURL = DefaultPageHelper.GetEditViewPage();
            int nWidth = 0;
            if (ppDataGrid != null && !ppDataGrid.IsParamNull("EDITPAGEWIDTH")) {
                nWidth = ppDataGrid.getEDITPAGEWIDTH();
            }
            nWidth = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.WIDTH", nWidth);
            int nHeight = 0;
            if (ppDataGrid != null && !ppDataGrid.IsParamNull("EDITPAGEHEIGHT")) {
                nHeight = ppDataGrid.getEDITPAGEHEIGHT();
            }
            nHeight = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.HEIGHT", nHeight);
            boolean bBatchOnly = false;
            if (ppDataGrid != null && !ppDataGrid.IsParamNull("NEWBATCHONLY")) {
                bBatchOnly = ppDataGrid.getNEWBATCHONLY();
            }
            bBatchOnly = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.BATCHONLY", bBatchOnly);
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            String strEditPageId = "";
            if (ppDataGrid != null && !ppDataGrid.IsParamNull("EDITPAGEID")) {
                strEditPageId = ppDataGrid.getEDITPAGEID();
            }
            if (StringHelper.IsNullOrEmpty((String)strEditPageId)) {
                strEditPageId = iDEHelper.GetEditPageId();
            }
            if (!StringHelper.IsNullOrEmpty((String)(strEditPageId = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE", strEditPageId)))) {
                Page editPage = daPage.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strEditPageId);
                if (editPage == null) {
                    log.error((Object)"\u83b7\u53d6\u9875\u9762\u4fe1\u606f\u5931\u8d25");
                    return false;
                }
                if (editPage.GetParamValue("ISMODELSTYLE") != null) {
                    bShowModal = editPage.isMODALSTYLE();
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
            if (daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.POPUP") != null) {
                strPopupMode = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.POPUP", "");
                bShowModal = StringHelper.Compare((String)strPopupMode, (String)"MODAL", (boolean)true) == 0;
            }
            String strEditURL = strURL = URLHelper.AppendURLSeperator((String)strURL);
            daPage.getWebContext().RemoveParam("SRFNEWDATA");
            TreeMap<String, String> daParams = new TreeMap<String, String>();
            daParams.put("SRFDEID", iDEHelper.getId());
            daParams.put("SRFPDEID", daPage.getWebContext().getSRFPDEID());
            daParams.put("SRFDERID", daPage.getWebContext().getSRFDERID());
            daParams.put("SRFTEMPDATA", daPage.getWebContext().GetParamValue("SRFTEMPDATA"));
            if (bInfoMode) {
                daParams.put("SRFINFOMODE", "TRUE");
            }
            if (!StringHelper.IsNullOrEmpty((String)(strDAParams = URLHelper.GetQueryString(daParams)))) {
                strURL = String.valueOf(strURL) + strDAParams;
                strURL = String.valueOf(strURL) + "&";
            }
            strURL = String.valueOf(strURL) + daPage.getWebContext().GetQueryStringWithoutDAParam(daParams);
            strURL = String.valueOf(strURL) + "&";
            String strSRFDERId = daPage.getWebContext().getSRFDERID();
            if (!StringHelper.IsNullOrEmpty((String)strSRFDERId)) {
                DER1N der1N = daPage.getDEHelper().FindDER1N(strSRFDERId);
                if (der1N == null) {
                    der1N = new DER1N();
                    CallResult callResult = daPage.getDAModelHelper().GetDER1N(strSRFDERId, der1N);
                    if (callResult.getRetCode() != 0) {
                        daPage.PageLog(null, 1, StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strSRFDERId, (Object)callResult.getErrorInfo()));
                    }
                }
                if (der1N != null && StringHelper.Compare((String)daPage.getDEHelper().getId(), (String)der1N.getMAJORDEID(), (boolean)true) == 0) {
                    daParams.remove("SRFDERID");
                }
            }
            if (iDEMainStateHelper != null) {
                Hashtable<String, String> urlParams = new Hashtable<String, String>();
                urlParams.put("SRFDEMAINSTATE", iDEMainStateHelper.getName());
                strEditURL = PagePathHelper.CalcPath((ISRFDAGlobalHelper)daPage.getWebContext().getGlobalHelper(), iDEMainStateHelper.getSDPageId(), strEditURL, urlParams);
            }
            if (!StringHelper.IsNullOrEmpty((String)(strDAParams = URLHelper.GetQueryString(daParams)))) {
                strEditURL = String.valueOf(strEditURL) + strDAParams;
                strEditURL = String.valueOf(strEditURL) + "&";
            }
            strEditURL = String.valueOf(strEditURL) + daPage.getWebContext().GetQueryStringWithoutDAParam(daParams);
            strEditURL = String.valueOf(strEditURL) + "&";
            StringBuilderEx script = new StringBuilderEx();
            if (bNew) {
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = String.valueOf(strURL) + "&SRFNEWDATA=TRUE&";
                if (!iDEHelper.IsIndexDE()) {
                    script.Append("$P.grid['%1$s']._new = function(){", (Object)dataGrid.getUniqueID());
                    script.Append("if(%1$s){return;}", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
                    script.Append("var _URL = '%1$s';\r\n", (Object)strURL);
                    script.Append("if($P.grid['%1$s']._summarykey){_URL += Ext.urlEncode($P.grid['%1$s']._summarykey);}\r\n", (Object)dataGrid.getUniqueID());
                    DER1N srcDER1N = null;
                    DER1N dstDER1N = null;
                    if (iDEHelper.getDataEntity().getDETYPE() == 3 || iDEHelper.getDataEntity().getDETYPE() == 2) {
                        String strBatchDSTDERID = daPage.getWebContext().GetParamValue("SRFDSTDERID");
                        String strDERId = daPage.getWebContext().getSRFDERID();
                        if (!StringHelper.IsNullOrEmpty((String)strDERId)) {
                            Vector derList = iDEHelper.GetDER1Ns(false);
                            for (DER1N der1n : derList) {
                                if ((der1n.getDERSUBTYPE() & 8) == 0) continue;
                                if (StringHelper.Compare((String)strDERId, (String)der1n.getDERID(), (boolean)true) == 0) {
                                    srcDER1N = der1n;
                                    continue;
                                }
                                if (!StringHelper.IsNullOrEmpty((String)strBatchDSTDERID)) {
                                    if (StringHelper.Compare((String)der1n.getDERID(), (String)strBatchDSTDERID, (boolean)true) != 0) continue;
                                    dstDER1N = der1n;
                                    continue;
                                }
                                dstDER1N = der1n;
                            }
                        }
                    }
                    if (srcDER1N != null && dstDER1N != null) {
                        String strMPickupPageId;
                        if (!bBatchOnly) {
                            script.Append("if(confirm('\u662f\u5426\u8fdb\u884c\u6279\u91cf\u589e\u52a0\uff1f')){");
                        }
                        if (StringHelper.IsNullOrEmpty((String)(strMPickupPageId = daPage.getPageParam("PAGE.DATAGRID.BATCHNEW.MPICKUPPAGE", dstDER1N.getMPICKUPPAGEID())))) {
                            IDEHelper dstDEHelper = daPage.getDAModelStorage().FindDEHelper(dstDER1N.getMAJORDEID());
                            if (dstDEHelper == null) {
                                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)dstDER1N.getMAJORDEID()));
                                return false;
                            }
                            strMPickupPageId = dstDEHelper.GetMPickupPageId();
                        }
                        if (StringHelper.IsNullOrEmpty((String)strMPickupPageId)) {
                            strMPickupPageId = "PAGE_00014";
                        }
                        String strMPickupURL = "../srfpage/pickupview.jsp";
                        int nDialogWidth = nWidth;
                        int nDialogHeight = nHeight;
                        String strDialogResizable = "yes";
                        String strDialogScroll = "yes";
                        String strDialogStatus = "no";
                        if (!StringHelper.IsNullOrEmpty((String)strMPickupPageId)) {
                            Page pickupPage = daPage.getDAModelStorage().FindPage(strMPickupPageId);
                            if (pickupPage == null) {
                                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u9875\u9762\u5b9e\u4f53[%1$s]", (Object)strMPickupPageId));
                                return false;
                            }
                            if (!StringHelper.IsNullOrEmpty((String)pickupPage.GetTotalPagePath())) {
                                strMPickupURL = pickupPage.GetTotalPagePath();
                            }
                            if (pickupPage.getWIDTH() > 0) {
                                nDialogWidth = pickupPage.getWIDTH();
                            }
                            if (pickupPage.getHEIGHT() > 0) {
                                nDialogHeight = pickupPage.getHEIGHT();
                            }
                        }
                        strMPickupURL = URLHelper.AppendURLSeperator((String)strMPickupURL);
                        strMPickupURL = String.valueOf(strMPickupURL) + "SRFDEID=" + dstDER1N.getMAJORDEID();
                        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"_DR", (String)("'" + strMPickupURL + "'"), (String)"", (int)nDialogWidth, (int)nDialogHeight, (String)strDialogResizable, (String)strDialogScroll, (String)strDialogStatus));
                        script.Append("var _ret='cancel';\r\n");
                        script.Append("if(_DR&&_DR.ret&&_DR.items)\r\n ");
                        script.Append("_ret=_DR.ret;\r\n");
                        script.Append("if(_ret=='ok'){\r\n");
                        script.Append("var _P={};if($P.grid['%1$s']._summarykey){_P=Ext.apply($P.grid['%1$s']._summarykey);}\r\n", (Object)dataGrid.getUniqueID());
                        script.Append("_P['%1$s']=_DR.items;\r\n", (Object)dstDER1N.getMAJORKEYDEFNAME().toLowerCase());
                        script.Append("$P.grid['%1$s'].gridmgr.customcall2(_P,'srfdaaddbatch','\u6279\u589e\u52a0\u6570\u636e');\r\n", (Object)dataGrid.getUniqueID());
                        script.Append("}\r\n");
                        if (!bBatchOnly) {
                            script.Append("}else{");
                        }
                    } else {
                        bBatchOnly = false;
                    }
                    if (!bBatchOnly) {
                        if (StringHelper.Compare((String)iDEHelper.GetProperty("MULTIFORM"), (String)"TRUE", (boolean)true) == 0) {
                            String strMultiFormField = iDEHelper.GetProperty("MULTIFORMFIELD");
                            String strType = daPage.getWebContext().GetParamValue(strMultiFormField);
                            if (StringHelper.IsNullOrEmpty((String)strType)) {
                                String strMultiFormFilter = daPage.getPageParam("PAGE.MULTIFORMFILTER", "");
                                if (!StringHelper.IsNullOrEmpty((String)strMultiFormFilter)) {
                                    strMultiFormFilter = URLEncoder.encode(strMultiFormFilter, "UTF-8");
                                }
                                script.Append("var _S='../srfpage/multiformselectview.jsp?SRFDEID=%1$s&SRFMULTIFORMFILTER=%2$s';\r\n", (Object)iDEHelper.getId(), (Object)strMultiFormFilter);
                                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"ret", (String)"_S", (String)"", (int)600, (int)400, (String)"yes", (String)"yes", (String)"no"));
                                script.Append("if(ret==null||ret.ret!='ok')return;");
                                script.Append("_URL+=('&%1$s='+ret.id);", (Object)strMultiFormField);
                            } else {
                                script.Append("_URL+=('&%1$s=%2$s');", (Object)strMultiFormField, (Object)strType);
                            }
                        }
                        if (bShowModal) {
                            script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
                        } else {
                            script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
                        }
                        if (srcDER1N != null && dstDER1N != null) {
                            script.Append("}");
                        }
                    }
                    script.Append(" };\r\n");
                } else {
                    script.Append("$P.grid['%1$s']._new = function(){", (Object)dataGrid.getUniqueID());
                    script.Append("if(%1$s){return;}", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
                    String strIndexFilter = daPage.getPageParam("PAGE.DERINDEXFILTER", "");
                    if (!StringHelper.IsNullOrEmpty((String)strIndexFilter)) {
                        strIndexFilter = URLEncoder.encode(strIndexFilter, "UTF-8");
                    }
                    script.Append("var _S='../srfpage/indexdetypeview.jsp?SRFDEID=%1$s&SRFDERINDEXFILTER=%2$s';\r\n", (Object)iDEHelper.getId(), (Object)strIndexFilter);
                    script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"ret", (String)"_S", (String)"", (int)600, (int)400, (String)"yes", (String)"yes", (String)"no"));
                    script.Append("if(ret==null||ret.ret !='ok')return;");
                    String strParam = "";
                    daParams = new TreeMap();
                    daParams.put("SRFPDEID", daPage.getWebContext().getSRFPDEID());
                    daParams.put("SRFDERID", daPage.getWebContext().getSRFDERID());
                    strDAParams = URLHelper.GetQueryString(daParams);
                    if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
                        strParam = String.valueOf(strParam) + strDAParams;
                        strParam = String.valueOf(strParam) + "&";
                    }
                    strParam = String.valueOf(strParam) + daPage.getWebContext().GetQueryStringWithoutDAParam();
                    script.Append("var _URL = '';\r\n");
                    script.Append("if(ret.url){_URL = ret.url;}else{_URL='%1$s';}\r\n", (Object)"../srfpage/editview.jsp?");
                    script.Append("_URL+='%1$s';\r\n", (Object)strParam);
                    script.Append("_URL+=('&SRFDEID='+ret.deid);\r\n");
                    script.Append("if($P.grid['%1$s']._summarykey){_URL+='&';_URL+=Ext.urlEncode($P.grid['%1$s']._summarykey);}\r\n", (Object)dataGrid.getUniqueID());
                    if (bShowModal) {
                        script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
                    } else {
                        script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
                    }
                    script.Append("};\r\n");
                }
            }
            if (bEdit) {
                script.Append("$P.grid['%1$s']._edit=function(_COPYMODE){", (Object)dataGrid.getUniqueID());
                script.Append("if(%1$s){return;}", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
                script.Append("var _URL='%1$s';\r\n", (Object)strEditURL);
                script.Append("var _1=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
                script.Append("_1.srftempdata=$P.grid['%1$s'].gridmgr.gettempdata();\r\n", (Object)dataGrid.getUniqueID());
                script.Append("if(_COPYMODE){_1.copymode=true;}\r\n");
                script.Append("_URL+=Ext.urlEncode(_1);\r\n");
                if (bShowModal) {
                    script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
                    script.Append("delete _DIALOGRESULT;");
                } else {
                    script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
                }
                script.Append("};\r\n");
            }
            daPage.RegisterUncacheOnReadyScript(3, script.toString());
            if (bDBClickEditMode && bEdit) {
                daPage.RegisterUncacheOnReadyScript(3, DataGridJSHelper.getOnRowDbClickedEventScript((String)dataGrid.getUniqueID(), (String)StringHelper.Format((String)"$P.grid['%1$s']._edit(false);", (Object)dataGrid.getUniqueID())));
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid) {
        return DataGridNewEditJSGear.Load(daPage, dataGrid, true, true, true);
    }
}

