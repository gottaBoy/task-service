/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.DataGrid.SRFDADataGridColumnRender;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImageColumnRender
extends SRFDADataGridColumnRender {
    private static final Log log = LogFactory.getLog(ImageColumnRender.class);

    @Override
    protected String OnGetJSCode(SRFDAWebContext webContext, SRFExDataGrid dataGrid, DataGridColumnRenderConfig baseConfig) {
        String strDownloadFilePath = webContext.getWebExConfig().GetValue("SRFEXWEB", "DOWNLOADPAGEPATH", "");
        strDownloadFilePath = URLHelper.AppendURLSeperator((String)strDownloadFilePath);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("if(value==null || value ==undefined)return '';\r\n");
        script.Append("var li=value.split(\"||SRF||\");\r\n");
        script.Append("if(li.length!=2)return value;\r\n");
        script.Append("if(li[0].length==0 ||li[1].length==0)return li[0];\r\n");
        script.Append("var _3='SRFUtility.download(\"%1$sFILEID=\"+\"'+li[1]+'\")';", (Object)strDownloadFilePath);
        script.Append("var _2='<A onclick=\\''+_3+'\\' href=\"#\"><IMG align=\"absmiddle\" src=\"../sasrfex/images/default/icon_download.png\" alt=\"\u70b9\u51fb\u4e0b\u8f7d\u6587\u4ef6\"></A>&nbsp;'+li[0];\r\n");
        script.Append("return _2;");
        return script.toString();
    }
}

