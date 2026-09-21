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

public class WFHistoryWorkDGEditPageHelper {
    private static final Log log = LogFactory.getLog(WFHistoryWorkDGEditPageHelper.class);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean Calc(SRFDAPage daPage, SRFExDataGrid dataGrid, String strDEId, JSONObject editPageInfo) {
        try {
            IDEHelper iDEHelper = daPage.getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                return false;
            }
            String strPopupMode = daPage.getWebContext().getWebExConfig().GetValue("SRFDA", "POPUPMODE", "WINDOW");
            boolean bShowModal = StringHelper.Compare((String)strPopupMode, (String)"MODAL", (boolean)true) == 0;
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
            if (daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.POPUP") != null) {
                strPopupMode = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.POPUP", "");
                bShowModal = StringHelper.Compare((String)strPopupMode, (String)"MODAL", (boolean)true) == 0;
            }
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            TreeMap<String, String> daParams = new TreeMap<String, String>();
            daParams.put("SRFDEID", iDEHelper.getId());
            String strDAParams = URLHelper.GetQueryString(daParams);
            if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
                strURL = String.valueOf(strURL) + strDAParams;
                strURL = String.valueOf(strURL) + "&";
            }
            strURL = String.valueOf(strURL) + daPage.getWebContext().GetQueryStringWithoutDAParam();
            strURL = String.valueOf(strURL) + "&";
            strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=", (Object)iDEHelper.GetKeyDEFHelper().getName());
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

