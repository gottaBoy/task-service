/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Web.Utility;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFDataGridEditPageHelper {
    private static final Log log = LogFactory.getLog(WFDataGridEditPageHelper.class);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Calc(SRFDAPage daPage, SRFExDataGrid dataGrid, JSONObject editPageInfo) {
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
            if (editPageInfo == null) return true;
            editPageInfo.put("uri", (Object)strURL);
            editPageInfo.put("modal", bShowModal);
            editPageInfo.put("width", nWidth);
            editPageInfo.put("height", nHeight);
            return true;
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }
}

