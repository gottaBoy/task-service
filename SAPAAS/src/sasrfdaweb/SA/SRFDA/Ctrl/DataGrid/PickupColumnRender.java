/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.DataGrid.SRFDADataGridColumnRender;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PickupColumnRender
extends SRFDADataGridColumnRender {
    private static final Log log = LogFactory.getLog(PickupColumnRender.class);

    @Override
    protected String OnGetJSCode(SRFDAWebContext webContext, SRFExDataGrid dataGrid, DataGridColumnRenderConfig baseConfig) {
        String strDEId = baseConfig.GetExtValue("DEID", "");
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u7f16\u53f7");
            return "return value;";
        }
        IDEHelper iDEHelper = webContext.getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
            return "return value;";
        }
        String strURL = "../srfpage/editview.jsp?";
        int nWidth = 980;
        int nHeight = 680;
        String strWindowStyle = "resizable=1,menubar=0,status=0,titlebar=0,toolbar=0,scrollbars=0";
        String strEditPageId = iDEHelper.GetEditPageId();
        if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
            Page editPage = webContext.getGlobalHelper().getDAModelStorage().FindPage(strEditPageId);
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
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + StringHelper.Format((String)"SRFDEID=%1$s", (Object)iDEHelper.getId());
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + iDEHelper.GetKeyDEFHelper().getName();
        strURL = String.valueOf(strURL) + "=";
        StringBuilderEx script = new StringBuilderEx();
        script.Append("if(value==null || value ==undefined)return '';\r\n");
        script.Append("var li=value.split(\"||SRF||\");\r\n");
        script.Append("if(li.length!=2)return '';\r\n");
        script.Append("if(li[0].length==0 ||li[1].length==0)return '';\r\n");
        script.Append("var _3='SRFUtility.openwin(\"%4$s\"+\"'+li[1]+'\",\"\",\"width=%1$s,height=%2$s,%3$s\",false,%1$s,%2$s)';", (Object)nWidth, (Object)nHeight, (Object)strWindowStyle, (Object)strURL);
        if (StringHelper.Compare((String)baseConfig.GetExtValue("DATALINK", "TRUE"), (String)"TRUE", (boolean)true) == 0) {
            script.Append("var _2='<A onclick=\\''+_3+'\\' href=\"#\"><IMG align=\"absmiddle\" src=\"../sasrfex/images/default/icon_properties.png\" alt=\"\u70b9\u51fb\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f\"></A>&nbsp;'+li[0];\r\n");
        } else {
            script.Append("var _2=li[0];");
        }
        script.Append("return _2;");
        return script.toString();
    }

    protected void AppendCodeItemConfigCode(StringBuilderEx script, CodeItemConfig codeItemConfig) {
        if (codeItemConfig.getCodeItems() == null) {
            return;
        }
        int i = 0;
        while (i < codeItemConfig.getCodeItems().size()) {
            CodeItemConfig childItemConfig = (CodeItemConfig)codeItemConfig.getCodeItems().get(i);
            script.Append("if(value=='%1$s')return '%2$s';\r\n", (Object)childItemConfig.getValue(), (Object)childItemConfig.getText());
            this.AppendCodeItemConfigCode(script, childItemConfig);
            ++i;
        }
    }
}

