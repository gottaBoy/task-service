/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.EAI.Web;

import SA.SRFDA.EAI.Ctrl.Data.EAIAppIntType;
import SA.SRFDA.EAI.Ctrl.DataCtrl.IEAIAppIntTypeDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class AppIntTypeSelectPage
extends BaseMainPage {
    protected void OnInitComponents() {
        super.OnInitComponents();
    }

    protected String OnGetPageCaption() {
        return "\u5e94\u7528\u63a5\u53e3\u7c7b\u578b";
    }

    public String OutputPageIcon(boolean bSmall) {
        if (bSmall) {
            return "../sasrfex/images/default/icon_gear.png";
        }
        return "../sasrfex/images/default/icon_gear_b.png";
    }

    public String OutputIconView() {
        boolean bMain;
        Vector<EAIAppIntType> appIntTypeList = new Vector<EAIAppIntType>();
        IEAIAppIntTypeDataCtrl appIntTypeDataCtrl = (IEAIAppIntTypeDataCtrl)this.getDAModelStorage().FindDEDataCtrl("EAI0017", (ISRFDAWebContext)this.getWebContext());
        CallResult callResult = appIntTypeDataCtrl.GetAppIntTypes(bMain = StringHelper.Compare((String)this.getWebContext().GetParamValue("APPTYPE"), (String)"MAIN", (boolean)true) == 0, appIntTypeList);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 2, StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u63a5\u53e3\u7c7b\u578b\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        StringBuilderEx strIconView = new StringBuilderEx();
        strIconView.Append("<table align=\"left\" width=\"100%%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >");
        strIconView.Append("<tr><td height=\"20\"></td></tr><tr>");
        String strIconViewTDScheme = "<td width=\"100\"><table align=\"center\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" ><tr><td align=\"center\" ><a href=\"#\"  class='gridlink' onclick=\"editview('%3$s')\" ><img border=\"0\" width=\"50\" src=\"%1$s\" alt=\"%2$s\"/></a></td></tr><tr><td align=\"center\" ><a href=\"#\"  class='gridlink'   onclick=\"editview('%3$s')\" ><span class=\"sx-normaltext-b\">%2$s</span></a></td></tr></table></td>";
        int i = 1;
        for (EAIAppIntType appIntType : appIntTypeList) {
            String strIcon = appIntType.getICONPATH();
            if (StringHelper.IsNullOrEmpty((String)strIcon)) {
                strIcon = "../sasrfex/images/default/icon_gear_b.png";
            }
            strIconView.Append(strIconViewTDScheme, (Object)strIcon, (Object)appIntType.getEAIAPPINTTYPENAME(), (Object)appIntType.getEAIAPPINTTYPEID());
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

