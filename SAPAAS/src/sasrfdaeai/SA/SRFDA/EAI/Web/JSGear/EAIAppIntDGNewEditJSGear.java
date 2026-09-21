/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.DataGridJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Web.JSGear;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EAIAppIntDGNewEditJSGear {
    private static final Log log = LogFactory.getLog(EAIAppIntDGNewEditJSGear.class);

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode) {
        return EAIAppIntDGNewEditJSGear.Load(daPage, dataGrid, bNew, bEdit, bDBClickEditMode, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode, boolean bInfoMode) {
        try {
            String strDAParams;
            IDEHelper iDEHelper = daPage.getDEHelper();
            boolean bShowModal = true;
            String strURL = "../srfpage/editview.jsp?";
            int nWidth = 0;
            int nHeight = 0;
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
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
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            TreeMap<String, String> daParams = new TreeMap<String, String>();
            daParams.put("SRFDEID", iDEHelper.getId());
            daParams.put("SRFPDEID", daPage.getWebContext().getSRFPDEID());
            daParams.put("SRFDERID", daPage.getWebContext().getSRFDERID());
            if (bInfoMode) {
                daParams.put("SRFINFOMODE", "TRUE");
            }
            if (!StringHelper.IsNullOrEmpty((String)(strDAParams = URLHelper.GetQueryString(daParams)))) {
                strURL = String.valueOf(strURL) + strDAParams;
                strURL = String.valueOf(strURL) + "&";
            }
            strURL = String.valueOf(strURL) + daPage.getWebContext().GetQueryStringWithoutDAParam();
            strURL = String.valueOf(strURL) + "&";
            StringBuilderEx script = new StringBuilderEx();
            if (bNew) {
                script.Append("$P.grid['%1$s']._new = function(){", (Object)dataGrid.getUniqueID());
                script.Append("if(%1$s){return;}", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
                script.Append("var _SELECTURL = '../srfeai/appinttypeselectview.jsp?SRFDEID=%1$s&APPTYPE=%2$s';\r\n", (Object)iDEHelper.getId(), (Object)daPage.getWebContext().GetParamValue("APPTYPE"));
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"ret", (String)"_SELECTURL", (String)"", (int)600, (int)400, (String)"yes", (String)"yes", (String)"no"));
                script.Append("if (ret==null || ret.ret !='ok')return;");
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
                script.Append("var _URL = '%1$s';\r\n", (Object)strURL);
                script.Append("_URL+='%1$s';\r\n", (Object)strParam);
                script.Append("_URL+=('&appinttype='+ret.type);\r\n");
                script.Append("if($P.grid['%1$s']._summarykey){_URL += Ext.urlEncode($P.grid['%1$s']._summarykey);}\r\n", (Object)dataGrid.getUniqueID());
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
                script.Append("};\r\n");
            }
            if (bEdit) {
                script.Append("$P.grid['%1$s']._edit = function(_COPYMODE){", (Object)dataGrid.getUniqueID());
                script.Append("if(%1$s){return;}", (Object)DataGridJSHelper.getGetDataGridEditable((String)dataGrid.getUniqueID()));
                script.Append("var _URL = '%1$s';\r\n", (Object)strURL);
                script.Append("var _1= %1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
                script.Append("var _2= %1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecord((String)dataGrid.getUniqueID()));
                script.Append("if(_COPYMODE){_1.copymode=true;}\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
                script.Append("_URL += Ext.urlEncode(_1);\r\n");
                script.Append("_URL+=('&appinttype='+_2.get('appinttype'));\r\n");
                if (bShowModal) {
                    script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
                    script.Append("delete _DIALOGRESULT;");
                } else {
                    script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
                }
                script.Append("};\r\n");
            }
            daPage.RegisterUncacheOnReadyScript(3, script.toString());
            if (!bDBClickEditMode) return true;
            if (!bEdit) return true;
            daPage.RegisterUncacheOnReadyScript(3, DataGridJSHelper.getOnRowDbClickedEventScript((String)dataGrid.getUniqueID(), (String)StringHelper.Format((String)"$P.grid['%1$s']._edit(false);", (Object)dataGrid.getUniqueID())));
            return true;
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid) {
        return EAIAppIntDGNewEditJSGear.Load(daPage, dataGrid, true, true, true);
    }
}

