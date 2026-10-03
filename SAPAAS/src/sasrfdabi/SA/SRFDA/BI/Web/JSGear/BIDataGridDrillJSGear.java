/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
package SA.SRFDA.BI.Web.JSGear;

import SA.SRFDA.BI.Ctrl.Data.BICubeSrc;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.DataGridJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BIDataGridDrillJSGear {
    private static final Log log = LogFactory.getLog(BIDataGridDrillJSGear.class);

    public static boolean Load(SRFDAPage daPage, SRFExDataGrid dataGrid) {
        try {
            IDEHelper iDEHelper = daPage.getDEHelper();
            String strURL = "../srfbi/bicubesrcredirectview.jsp?";
            int nWidth = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.WIDTH", 0);
            int nHeight = daPage.getPageParam("PAGE.DATAGRID.EDITPAGE.HEIGHT", 0);
            String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            daPage.getWebContext().RemoveParam("SRFNEWDATA");
            TreeMap<String, String> daParams = new TreeMap<String, String>();
            daParams.put("SRFDEID", iDEHelper.getId());
            daParams.put("SRFBIMEASURE", daPage.getWebContext().GetParamValue("SRFBIMEASURE"));
            String strDAParams = URLHelper.GetQueryString(daParams);
            if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
                strURL = String.valueOf(strURL) + strDAParams;
                strURL = String.valueOf(strURL) + "&";
            }
            int nCnt = daPage.getPageParam("BICUBESRCCNT", 0);
            String strBICUBESRCID = daPage.getPageParam("BICUBESRCID", "");
            StringBuilderEx script = new StringBuilderEx();
            script.Append("$P.grid['%1$s']._edit=function(){", (Object)dataGrid.getUniqueID());
            if (nCnt == 0) {
                script.Append("alert('\u6ca1\u6709\u4e3a\u5f53\u524d\u5206\u6790\u6570\u636e\u5b9a\u4e49\u91c7\u96c6\u6e90\u6570\u636e!');return;");
            } else if (nCnt == 1) {
                script.Append("var _URL='%1$s';", (Object)strURL);
                script.Append("_URL+=('&BICUBESRCID=%1$s');", (Object)strBICUBESRCID);
                script.Append("var _1=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
                script.Append("_URL+='&';\r\n");
                script.Append("_URL+=Ext.urlEncode(_1);\r\n");
                script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
            } else {
                Vector<BICubeSrc> cubeSrcList = (Vector<BICubeSrc>)daPage.getPageParam("BICUBESRCLIST");
                script.Append("var _R=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecord((String)dataGrid.getUniqueID()));
                script.Append("var _srcid='';\r\n");
                for (BICubeSrc cubeSrc : cubeSrcList) {
                    String strFields = cubeSrc.getSRCSELFIELDS();
                    if (StringHelper.IsNullOrEmpty((String)strFields)) continue;
                    script.Append("if((");
                    String[] Fields = strFields.split("[;]");
                    int i = 0;
                    while (i < Fields.length) {
                        if (i != 0) {
                            script.Append("+'_'");
                        }
                        script.Append("_R.get('%1$s')", (Object)Fields[i]);
                        ++i;
                    }
                    script.Append(")=='%1$s'){_srcid='%2$s';}", (Object)cubeSrc.getSRCSELVALUE(), (Object)cubeSrc.getBICUBESRCID());
                }
                script.Append("if(_srcid==''){");
                script.Append("var _S='../srfbi/bicubesrcselectview.jsp?SRFDEID=%1$s';\r\n", (Object)iDEHelper.getId());
                script.Append(BrowserJSHelper.getShowDialogScriptEx((String)"ret", (String)"_S", (String)"", (int)600, (int)400, (String)"yes", (String)"yes", (String)"no"));
                script.Append("if(ret==null||ret.ret!='ok')return;");
                script.Append("_srcid=ret.id;\r\n");
                script.Append("}\r\n");
                script.Append("var _URL='%1$s';", (Object)strURL);
                script.Append("_URL+=('&BICUBESRCID='+_srcid);");
                script.Append("var _1=%1$s;\r\n", (Object)DataGridJSHelper.getSelectedRecordKeys((String)dataGrid.getUniqueID()));
                script.Append("_URL+='&';\r\n");
                script.Append("_URL+=Ext.urlEncode(_1);\r\n");
                script.Append(BrowserJSHelper.getShowWindowScriptEx((String)"_URL", (String)"''", (String)("'" + strWindowStyle + "'"), (boolean)false, (int)nWidth, (int)nHeight));
            }
            script.Append("}\r\n");
            daPage.RegisterUncacheOnReadyScript(3, script.toString());
            script.Reset();
            daPage.RegisterUncacheOnReadyScript(3, DataGridJSHelper.getOnRowDbClickedEventScript((String)dataGrid.getUniqueID(), (String)StringHelper.Format((String)"$P.grid['%1$s']._edit();", (Object)dataGrid.getUniqueID())));
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }
}

