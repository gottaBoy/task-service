/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEDataImport
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler
 *  SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler
 *  SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Ctrl.Toolbar;

import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarButtonHandler;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class ImportExcelHandler
implements ISRFExToolbarButtonHandler,
ISRFExToolbarMenuHandler {
    public String getJSCode(ToolbarButtonConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        String strImportUrl = "../srfpage/uploaddedataexcelview.jsp";
        SRFDAPage page = (SRFDAPage)webContext.getPage();
        String strDEId = page.getPageDataEntityId();
        boolean bDefault = true;
        String strDataImport = page.getPageParam("PAGE.DATAIMPORT", "");
        if (StringHelper.IsNullOrEmpty((String)strDataImport)) {
            strDataImport = "DEFAULT";
            bDefault = true;
        }
        if (!StringHelper.IsNullOrEmpty((String)strDataImport)) {
            if (page.getDEHelper() == null) {
                if (!bDefault) {
                    page.PageLog(this, 1, StringHelper.Format((String)"\u9875\u9762\u6307\u5b9a\u4e86\u6570\u636e\u5bfc\u5165\u6a21\u5f0f\uff0c\u4f46\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548"));
                }
            } else {
                DEDataImport dataImport = page.getDEHelper().GetDataImport(strDataImport);
                if (dataImport == null) {
                    if (!bDefault) {
                        page.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5bfc\u5165\u6a21\u5f0f[%2$s]", (Object)strDEId, (Object)strDataImport));
                    }
                } else {
                    if (!StringHelper.IsNullOrEmpty((String)dataImport.getIMPORTVIEW())) {
                        strImportUrl = dataImport.getIMPORTVIEW();
                    }
                    strImportUrl = URLHelper.AppendURLSeperator((String)strImportUrl);
                    strImportUrl = String.valueOf(strImportUrl) + StringHelper.Format((String)"SRFDEDATAIMPORT=%1$s", (Object)strDataImport);
                }
            }
        }
        strImportUrl = URLHelper.AppendURLSeperator((String)strImportUrl);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFPDEID", page.getWebContext().getSRFPDEID());
        daParams.put("SRFDERID", page.getWebContext().getSRFDERID());
        daParams.put("SRFDEID", strDEId);
        strImportUrl = String.valueOf(strImportUrl) + URLHelper.GetQueryString(daParams);
        strImportUrl = URLHelper.AppendURLSeperator((String)strImportUrl);
        strImportUrl = String.valueOf(strImportUrl) + page.getWebContext().GetQueryStringWithoutDAParam();
        int nWidth = 980;
        int nHeight = 680;
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        script.Append("var _URL='%1$s';\r\n", (Object)strImportUrl);
        script.Append("if($P.maingrid && $P.maingrid._summarykey){_URL+=('&'+ Ext.urlEncode($P.maingrid._summarykey));}\r\n");
        script.Append("window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle);
        script.Append("}");
        return script.toString();
    }

    public String getToolbarMenuJSCode(MenuItemExConfig config, SRFExWebContext webContext, Object obj) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function(_1){");
        String strImportUrl = "../srfpage/uploaddedataexcelview.jsp";
        SRFDAPage page = (SRFDAPage)webContext.getPage();
        String strDEId = page.getPageDataEntityId();
        boolean bDefault = true;
        String strDataImport = page.getPageParam("PAGE.DATAIMPORT", "");
        if (StringHelper.IsNullOrEmpty((String)strDataImport)) {
            strDataImport = "DEFAULT";
            bDefault = true;
        }
        if (!StringHelper.IsNullOrEmpty((String)strDataImport)) {
            if (page.getDEHelper() == null) {
                if (!bDefault) {
                    page.PageLog(this, 1, StringHelper.Format((String)"\u9875\u9762\u6307\u5b9a\u4e86\u6570\u636e\u5bfc\u5165\u6a21\u5f0f\uff0c\u4f46\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548"));
                }
            } else {
                DEDataImport dataImport = page.getDEHelper().GetDataImport(strDataImport);
                if (dataImport == null) {
                    if (!bDefault) {
                        page.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5bfc\u5165\u6a21\u5f0f[%2$s]", (Object)strDEId, (Object)strDataImport));
                    }
                } else {
                    if (!StringHelper.IsNullOrEmpty((String)dataImport.getIMPORTVIEW())) {
                        strImportUrl = dataImport.getIMPORTVIEW();
                    }
                    strImportUrl = URLHelper.AppendURLSeperator((String)strImportUrl);
                    strImportUrl = String.valueOf(strImportUrl) + StringHelper.Format((String)"SRFDEDATAIMPORT=%1$s", (Object)strDataImport);
                }
            }
        }
        strImportUrl = URLHelper.AppendURLSeperator((String)strImportUrl);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFPDEID", page.getWebContext().getSRFPDEID());
        daParams.put("SRFDERID", page.getWebContext().getSRFDERID());
        daParams.put("SRFDEID", strDEId);
        strImportUrl = String.valueOf(strImportUrl) + URLHelper.GetQueryString(daParams);
        strImportUrl = URLHelper.AppendURLSeperator((String)strImportUrl);
        strImportUrl = String.valueOf(strImportUrl) + page.getWebContext().GetQueryStringWithoutDAParam();
        int nWidth = 980;
        int nHeight = 680;
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        script.Append("var _URL='%1$s';\r\n", (Object)strImportUrl);
        script.Append("if($P.maingrid && $P.maingrid._summarykey){_URL+=('&'+ Ext.urlEncode($P.maingrid._summarykey));}\r\n");
        script.Append("window.open(_URL,'','width=%1$s,height=%2$s,%3$s',false);\r\n", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle);
        script.Append("}");
        return script.toString();
    }
}

