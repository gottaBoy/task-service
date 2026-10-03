/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.PP.PPDataGrid
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.Utility;

import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.PP.PPDataGrid;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.net.URLEncoder;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataGridNewEditPageHelper {
    private static final Log log = LogFactory.getLog(DataGridNewEditPageHelper.class);

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, JSONObject newPageInfo, JSONObject editPageInfo) {
        return DataGridNewEditPageHelper.Calc(daPage, dataGrid, newPageInfo, editPageInfo, false);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static boolean Calc(SRFDAPage daPage, SRFExDataGrid dataGrid, JSONObject newPageInfo, JSONObject editPageInfo, boolean bInfoMode) {
        try {
            String strDAParams;
            PPDataGrid ppDataGrid = null;
            BaseDataEntity pageParam = daPage.getAdvPageParam(dataGrid.getID().toUpperCase(), "PP_DATAGRID");
            if (pageParam != null && pageParam instanceof PPDataGrid) {
                ppDataGrid = (PPDataGrid)pageParam;
            }
            IDEHelper iDEHelper = daPage.getDEHelper();
            String strPopupMode = daPage.getWebContext().getWebExConfig().GetValue("SRFDA", "POPUPMODE", "WINDOW");
            boolean bShowModal = StringHelper.Compare((String)strPopupMode, (String)"MODAL", (boolean)true) == 0;
            String strURL = "../srfpage/editview.jsp?";
            int nWidth = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.WIDTH", 0);
            int nHeight = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.HEIGHT", 0);
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            boolean bBatchOnly = false;
            if (ppDataGrid != null && !ppDataGrid.IsParamNull("NEWBATCHONLY")) {
                bBatchOnly = ppDataGrid.getNEWBATCHONLY();
            }
            bBatchOnly = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.BATCHONLY", bBatchOnly);
            String strEditPageId = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE", iDEHelper.GetEditPageId());
            if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
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
            if (!StringHelper.IsNullOrEmpty((String)(strDAParams = URLHelper.GetQueryString(daParams)))) {
                strEditURL = String.valueOf(strEditURL) + strDAParams;
                strEditURL = String.valueOf(strEditURL) + "&";
            }
            strEditURL = String.valueOf(strEditURL) + daPage.getWebContext().GetQueryStringWithoutDAParam(daParams);
            strEditURL = String.valueOf(strEditURL) + "&";
            if (newPageInfo != null) {
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = String.valueOf(strURL) + "&SRFNEWDATA=TRUE&";
                if (!iDEHelper.IsIndexDE()) {
                    DER1N srcDER1N = null;
                    DER1N dstDER1N = null;
                    if (iDEHelper.getDataEntity().getDETYPE() == 3 || iDEHelper.getDataEntity().getDETYPE() == 2) {
                        String strBatchDSTDERID = daPage.getWebContext().GetParamValue("SRFDSTDERID");
                        String strDERId = daPage.getWebContext().getSRFDERID();
                        if (!StringHelper.IsNullOrEmpty((String)strDERId)) {
                            Vector<DER1N> derList = iDEHelper.GetDER1Ns(false);
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
                        newPageInfo.put("batch", true);
                        newPageInfo.put("batchonly", bBatchOnly);
                        String strMPickupPageId = daPage.getPageParam("PAGE.DATAGRID.BATCHNEW.MPICKUPPAGE", dstDER1N.getMPICKUPPAGEID());
                        if (StringHelper.IsNullOrEmpty((String)strMPickupPageId)) {
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
                        int nDialogWidth = 0;
                        int nDialogHeight = 0;
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
                        newPageInfo.put("batchuri", (Object)strMPickupURL);
                        newPageInfo.put("batchwidth", nDialogWidth);
                        newPageInfo.put("batchheight", nDialogHeight);
                        newPageInfo.put("batchkey", (Object)dstDER1N.getMAJORKEYDEFNAME());
                    } else {
                        bBatchOnly = false;
                    }
                    if (!bBatchOnly && StringHelper.Compare((String)iDEHelper.GetProperty("MULTIFORM"), (String)"TRUE", (boolean)true) == 0) {
                        String strMultiFormField = iDEHelper.GetProperty("MULTIFORMFIELD");
                        String strType = daPage.getWebContext().GetParamValue(strMultiFormField);
                        if (StringHelper.IsNullOrEmpty((String)strType)) {
                            String strMultiFormFilter = daPage.getPageParam("PAGE.MULTIFORMFILTER", "");
                            if (!StringHelper.IsNullOrEmpty((String)strMultiFormFilter)) {
                                strMultiFormFilter = URLEncoder.encode(strMultiFormFilter, "UTF-8");
                            }
                            String strSelectUrl = StringHelper.Format((String)"../srfpage/multiformselectview.jsp?SRFDEID=%1$s&SRFMULTIFORMFILTER=%2$s", (Object)iDEHelper.getId(), (Object)strMultiFormFilter);
                            newPageInfo.put("mfselect", true);
                            newPageInfo.put("selecturi", (Object)strSelectUrl);
                            strURL = URLHelper.AppendURLSeperator((String)strURL);
                            strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=", (Object)strMultiFormField);
                        } else {
                            strURL = URLHelper.AppendURLSeperator((String)strURL);
                            strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)strMultiFormField, (Object)strType);
                        }
                    }
                    newPageInfo.put("uri", (Object)strURL);
                    newPageInfo.put("modal", bShowModal);
                    newPageInfo.put("width", nWidth);
                    newPageInfo.put("height", nHeight);
                } else {
                    String strIndexFilter = daPage.getPageParam("PAGE.DERINDEXFILTER", "");
                    if (!StringHelper.IsNullOrEmpty((String)strIndexFilter)) {
                        strIndexFilter = URLEncoder.encode(strIndexFilter, "UTF-8");
                    }
                    strURL = StringHelper.Format((String)"../srfpage/indexdetypeview.jsp?SRFDEID=%1$s&SRFDERINDEXFILTER=%2$s", (Object)iDEHelper.getId(), (Object)strIndexFilter);
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
                    newPageInfo.put("uriparam", (Object)strParam);
                    newPageInfo.put("selecturi", (Object)strURL);
                    newPageInfo.put("modal", true);
                    newPageInfo.put("width", 700);
                    newPageInfo.put("height", 500);
                    newPageInfo.put("indexdeselect", true);
                }
            }
            if (editPageInfo != null) {
                editPageInfo.put("uri", (Object)strEditURL);
                editPageInfo.put("modal", bShowModal);
                editPageInfo.put("width", nWidth);
                editPageInfo.put("height", nHeight);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }
}
