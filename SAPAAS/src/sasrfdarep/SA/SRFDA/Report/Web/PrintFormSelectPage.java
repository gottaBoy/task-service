/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PrintForm
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class PrintFormSelectPage
extends BaseMainPage {
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        return this.LoadPageDataEntity();
    }

    public String RenderIconView() {
        Vector<PrintForm> list = new Vector<PrintForm>();
        CallResult callResult = this.getDAModelHelper().GetDEPrintForms(this.strPageDataEntityId, list);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6253\u5370\u8868\u5355\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        StringBuilderEx strIconView = new StringBuilderEx();
        strIconView.Append("<table align=\"left\" width=\"100%%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >");
        strIconView.Append("<tr><td height=\"20\"></td></tr><tr>");
        String strIconViewTDScheme = "<td width=\"100\"><table align=\"center\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" ><tr><td align=\"center\" ><a href=\"#\" class=\"sx-normaltext\" onclick=\"selectprintform('%3$s')\" ><img border=\"0\"  src=\"%1$s\" alt=\"%2$s\" width='32' height='32'/></a></td></tr><tr><td align=\"center\" ><a href=\"#\" class=\"sx-normaltext\"  onclick=\"selectprintform('%3$s')\" ><span class=\"sx-normaltext\">%2$s</span></a></td></tr></table></td>";
        int i = 1;
        for (PrintForm printform : list) {
            String strImage = "";
            if (StringHelper.IsNullOrEmpty((String)strImage)) {
                strImage = "../sasrfex/images/default/icon_printform_b.png";
            }
            strIconView.Append(strIconViewTDScheme, (Object)strImage, (Object)printform.getPRINTFORMNAME(), (Object)printform.getWFFORMNAME());
            if (i % 5 == 0) {
                strIconView.Append("</tr><tr><td height=\"20\"></td></tr><tr>");
            }
            ++i;
        }
        strIconView.Append("</tr>");
        strIconView.Append("</table>");
        return strIconView.toString();
    }
}

