/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.MSG.Web.JSGear;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MsgDataGridNewEditPageHelper {
    private static final Log log = LogFactory.getLog(MsgDataGridNewEditPageHelper.class);

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, JSONObject newPageInfo, JSONObject editPageInfo) {
        return MsgDataGridNewEditPageHelper.Calc(daPage, dataGrid, newPageInfo, editPageInfo, false);
    }

    public static boolean Calc(SRFDAPage daPage, SRFExDataGrid dataGrid, JSONObject newPageInfo, JSONObject editPageInfo, boolean bInfoMode) {
        try {
            String strDAParams;
            String strURL = "../srfmessage/msgeditview.jsp?";
            int nWidth = 980;
            int nHeight = 680;
            boolean bShowModal = true;
            IDEHelper iDEHelper = daPage.getDEHelper();
            strURL = URLHelper.AppendURLSeperator((String)strURL);
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
            if (newPageInfo != null) {
                newPageInfo.put("uri", (Object)strURL);
                newPageInfo.put("modal", bShowModal);
                newPageInfo.put("width", nWidth);
                newPageInfo.put("height", nHeight);
            }
            if (editPageInfo != null) {
                editPageInfo.put("uri", (Object)strURL);
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

