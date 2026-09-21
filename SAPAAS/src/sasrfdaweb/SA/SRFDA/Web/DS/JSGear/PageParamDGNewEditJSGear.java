/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.IDEHelper
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
package SA.SRFDA.Web.DS.JSGear;

import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PageParamDGNewEditJSGear {
    private static final Log log = LogFactory.getLog(PageParamDGNewEditJSGear.class);

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode) {
        return PageParamDGNewEditJSGear.Load(daPage, dataGrid, bNew, bEdit, bDBClickEditMode, false);
    }

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode, boolean bInfoMode) {
        try {
            String strDAParams;
            IDEHelper iDEHelper = daPage.getDEHelper();
            String strPopupMode = daPage.getWebContext().getWebExConfig().GetValue("SRFDA", "POPUPMODE", "WINDOW");
            boolean bShowModal = StringHelper.Compare((String)strPopupMode, (String)"MODAL", (boolean)true) == 0;
            String strURL = "../srfds/pageparamredirectview.jsp?";
            int nWidth = 960;
            int nHeight = 800;
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
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
            StringBuilderEx script = new StringBuilderEx();
            if (bNew) {
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = String.valueOf(strURL) + "&SRFNEWDATA=TRUE&";
                script.Append("$P.grid['%1$s']._new = function(_1){", (Object)dataGrid.getUniqueID());
                script.Append("if(%1$s){return;}", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
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
                script.Append("var _URL='%1$s';\r\n", (Object)strEditURL);
                script.Append("_URL+='%1$s';\r\n", (Object)strParam);
                script.Append("if(_1!=null){_URL+=('&PAGEPARAMTYPEID='+_1.get('pageparamtypeid'));}\r\n");
                script.Append("if($P.grid['%1$s']._summarykey){_URL+='&';_URL+=Ext.urlEncode($P.grid['%1$s']._summarykey);}\r\n", (Object)dataGrid.getUniqueID());
                if (bShowModal) {
                    script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
                } else {
                    script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
                }
                script.Append("};\r\n");
            }
            if (bEdit) {
                script.Append("$P.grid['%1$s']._edit=function(_COPYMODE){", (Object)dataGrid.getUniqueID());
                script.Append("if(%1$s){return;}", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
                script.Append("var _URL='%1$s';\r\n", (Object)strEditURL);
                script.Append("var _1=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
                script.Append("if(_1.PAGEPARAMID==''){$P.grid['%1$s']._new(%2$s);return;}\r\n", (Object)dataGrid.getUniqueID(), (Object)DataGridJSHelper.getSelectedRecord((String)dataGrid.getUniqueID()));
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
        return PageParamDGNewEditJSGear.Load(daPage, dataGrid, true, true, true);
    }
}

