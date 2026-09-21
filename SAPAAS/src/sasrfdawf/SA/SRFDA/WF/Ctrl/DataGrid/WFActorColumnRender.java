/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.DataGrid.SRFDADataGridColumnRender
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.DataGrid.SRFDADataGridColumnRender;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFActorColumnRender
extends SRFDADataGridColumnRender {
    private static final Log log = LogFactory.getLog(WFActorColumnRender.class);

    protected String OnGetJSCode(SRFDAWebContext webContext, SRFExDataGrid dataGrid, DataGridColumnRenderConfig baseConfig) {
        StringBuilderEx script;
        boolean bNameOnly = false;
        String strURL = "";
        int nWidth = 980;
        int nHeight = 680;
        String strWindowStyle = "";
        String strWFActorInfoPageId = webContext.getWebExConfig().GetValue("SRFDA.WF", "WFACTORINFOPAGE", "");
        if (StringHelper.IsNullOrEmpty((String)strWFActorInfoPageId)) {
            bNameOnly = true;
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u64cd\u4f5c\u8005\u4fe1\u606f\u5c55\u793a\u9875\u9762\uff0c\u6309\u7167\u540d\u79f0\u8fdb\u884c\u8f93\u51fa");
        } else {
            Page editPage = webContext.getGlobalHelper().getDAModelStorage().FindPage(strWFActorInfoPageId);
            if (editPage == null) {
                log.error((Object)"\u83b7\u53d6\u9875\u9762\u4fe1\u606f\u5931\u8d25");
                return "return value;";
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
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            strURL = String.valueOf(strURL) + "WFACTORID=";
        }
        if (bNameOnly) {
            script = new StringBuilderEx();
            script.Append("if(value==null || value ==undefined)return '';\r\n");
            script.Append("var li=value.split(\"||SRF||\");\r\n");
            script.Append("if(li.length!=2)return value;\r\n");
            script.Append("if(li[0].length==0 ||li[1].length==0)return li[0];\r\n");
            script.Append("return li[0];");
            return script.toString();
        }
        script = new StringBuilderEx();
        script.Append("if(value==null || value ==undefined)return '';\r\n");
        script.Append("var li=value.split(\"||SRF||\");\r\n");
        script.Append("if(li.length!=2)return value;\r\n");
        script.Append("if(li[0].length==0 ||li[1].length==0)return li[0];\r\n");
        script.Append("var _3='SRFUtility.openwin(\"%4$s\"+\"'+li[1]+'\",\"\",\"width=%1$s,height=%2$s,%3$s\",false,%1$s,%2$s)';", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle, (Object)strURL);
        if (StringHelper.Compare((String)baseConfig.GetExtValue("DATALINK", "TRUE"), (String)"TRUE", (boolean)true) == 0) {
            script.Append("var _2='<A onclick=\\''+_3+'\\' href=\"#\"><IMG align=\"absmiddle\" src=\"../sasrfex/images/default/icon_properties.png\" alt=\"\u70b9\u51fb\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f\"></A>&nbsp;'+li[0];\r\n");
        } else {
            script.Append("var _2=li[0];");
        }
        script.Append("return _2;");
        return script.toString();
    }
}

