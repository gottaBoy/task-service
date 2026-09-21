/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.PP.PPDataGrid
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
package SA.SRFDA.Web.DS.Utility;

import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.PP.PPDataGrid;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PageParamDGNewEditPageHelper {
    private static final Log log = LogFactory.getLog(PageParamDGNewEditPageHelper.class);

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, JSONObject newPageInfo, JSONObject editPageInfo) {
        return PageParamDGNewEditPageHelper.Calc(daPage, dataGrid, newPageInfo, editPageInfo, false);
    }

    public static boolean Calc(SRFDAPage daPage, SRFExDataGrid dataGrid, JSONObject newPageInfo, JSONObject editPageInfo, boolean bInfoMode) {
        try {
            String strDAParams;
            PPDataGrid ppDataGrid = null;
            BaseDataEntity pageParam = daPage.getAdvPageParam(dataGrid.getID().toUpperCase(), "PP_DATAGRID");
            if (pageParam != null && pageParam instanceof PPDataGrid) {
                ppDataGrid = (PPDataGrid)pageParam;
            }
            IDEHelper iDEHelper = daPage.getDEHelper();
            boolean bShowModal = true;
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
            if (newPageInfo != null) {
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = String.valueOf(strURL) + "&SRFNEWDATA=TRUE&";
                newPageInfo.put("uri", (Object)strURL);
                newPageInfo.put("modal", bShowModal);
                newPageInfo.put("width", nWidth);
                newPageInfo.put("height", nHeight);
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

