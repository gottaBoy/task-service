/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package SA.SRFDA.MSG.Web.JSGear;

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

public class MsgDataGridNewEditJSGear {
    private static final Log log = LogFactory.getLog(MsgDataGridNewEditJSGear.class);

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid, boolean bNew, boolean bEdit, boolean bDBClickEditMode) {
        try {
            boolean bShowModel = false;
            String strURL = "../srfmessage/msgeditview.jsp?";
            int nWidth = 980;
            int nHeight = 680;
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            TreeMap daParams = new TreeMap();
            String strDAParams = URLHelper.GetQueryString(daParams);
            if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
                strURL = String.valueOf(strURL) + strDAParams;
                strURL = String.valueOf(strURL) + "&";
            }
            strURL = String.valueOf(strURL) + daPage.getWebContext().GetQueryStringWithoutDAParam();
            strURL = String.valueOf(strURL) + "&";
            StringBuilderEx script = new StringBuilderEx();
            if (bNew) {
                script.Append("$P.grid['%1$s']._new = function(){", (Object)dataGrid.getUniqueID());
                script.Append("var _URL = '%1$s';\r\n", (Object)strURL);
                if (bShowModel) {
                    script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
                } else {
                    script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
                }
                script.Append("};\r\n");
            }
            if (bEdit) {
                script.Append("$P.grid['%1$s']._edit = function(_COPYMODE){", (Object)dataGrid.getUniqueID());
                script.Append("var _URL = '%1$s';\r\n", (Object)strURL);
                script.Append("var _1= %1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
                script.Append("if(_COPYMODE){_1.copymode=true;}\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
                script.Append("_URL += Ext.urlEncode(_1);\r\n");
                if (bShowModel) {
                    script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
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
        return MsgDataGridNewEditJSGear.Load(daPage, dataGrid, true, true, true);
    }
}

