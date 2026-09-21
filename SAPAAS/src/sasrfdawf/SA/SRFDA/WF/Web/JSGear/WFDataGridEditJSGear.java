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
package SA.SRFDA.WF.Web.JSGear;

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

public class WFDataGridEditJSGear {
    private static final Log log = LogFactory.getLog(WFDataGridEditJSGear.class);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bDBClickEditMode) {
        try {
            String strSectorPageId;
            IDEHelper iDEHelper = daPage.getDEHelper();
            String strPopupMode = daPage.getWebContext().getWebExConfig().GetValue("SRFDA", "POPUPMODE", "WINDOW");
            boolean bShowModal = StringHelper.Compare((String)strPopupMode, (String)"MODAL", (boolean)true) == 0;
            String strURL = "../srfwf/wfinfoview.jsp?";
            int nWidth = 0;
            int nHeight = 0;
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            String strInfoPageId = iDEHelper.GetDEWF().getWFINFOPAGEID();
            String strSectorPageName = StringHelper.Format((String)"%1$s.%2$s:%3$s:%4$s", (Object)"WFINFOPAGE", (Object)daPage.getWebContext().GetParamValue("SRFWFDATAGROUP"), (Object)daPage.getWebContext().GetParamValue("SRFWFSTATEVALUE"), (Object)daPage.getWebContext().GetParamValue("SRFWFSTEP"));
            String strDESubWFId = daPage.getWebContext().GetParamValue("SRFDESUBWFID");
            if (!StringHelper.IsNullOrEmpty((String)strDESubWFId)) {
                strSectorPageName = StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strSectorPageName, (Object)strDESubWFId, (Object)daPage.getWebContext().GetParamValue("SRFWFSUBSTEP"));
            }
            if (!StringHelper.IsNullOrEmpty((String)(strSectorPageId = iDEHelper.GetDEWF().GetWFParam(strSectorPageName)))) {
                strInfoPageId = strSectorPageId;
            }
            if (!StringHelper.IsNullOrEmpty((String)strInfoPageId)) {
                Page editPage = daPage.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strInfoPageId);
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
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            TreeMap<String, String> daParams = new TreeMap<String, String>();
            daParams.put("SRFDEID", iDEHelper.getId());
            daParams.put("SRFWFSTATE", daPage.getWebContext().getSRFWFSTATE());
            daParams.put("SRFWFSTEP", daPage.getWebContext().getSRFWFSTEP());
            daParams.put("SRFTEMPDATA", daPage.getWebContext().GetParamValue("SRFTEMPDATA"));
            String strDAParams = URLHelper.GetQueryString(daParams);
            if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
                strURL = String.valueOf(strURL) + strDAParams;
                strURL = String.valueOf(strURL) + "&";
            }
            strURL = String.valueOf(strURL) + daPage.getWebContext().GetQueryStringWithoutDAParam();
            strURL = String.valueOf(strURL) + "&";
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.grid['%1$s']._edit = function(_COPYMODE){", (Object)dataGrid.getUniqueID());
            script.Append("var _URL='%1$s';\r\n", (Object)strURL);
            script.Append("var _1=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
            script.Append("if(_COPYMODE){_1.copymode=true;}\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
            script.Append("_URL += Ext.urlEncode(_1);\r\n");
            if (bShowModal) {
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"", (String)"_URL", (String)"window", (int)nWidth, (int)nHeight, (String)strWindowStyle));
            } else {
                script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
            }
            script.Append("};\r\n");
            daPage.RegisterUncacheOnReadyScript(3, script.toString());
            if (!bDBClickEditMode) return true;
            daPage.RegisterUncacheOnReadyScript(3, DataGridJSHelper.getOnRowDbClickedEventScript((String)dataGrid.getUniqueID(), (String)StringHelper.Format((String)"$P.grid['%1$s']._edit(false);", (Object)dataGrid.getUniqueID())));
            return true;
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid) {
        return WFDataGridEditJSGear.Load(daPage, dataGrid, true);
    }
}

