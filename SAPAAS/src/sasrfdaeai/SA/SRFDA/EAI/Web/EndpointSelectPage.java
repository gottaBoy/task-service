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

import SA.SRFDA.EAI.Ctrl.Data.EAIEndPoint;
import SA.SRFDA.EAI.Ctrl.DataCtrl.IEAIEndPointDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class EndpointSelectPage
extends BaseMainPage {
    protected void OnInitComponents() {
        super.OnInitComponents();
    }

    protected String OnGetPageCaption() {
        String strDirection = this.getWebContext().GetParamValue("DIRECTION");
        if (StringHelper.Compare((String)strDirection, (String)"INBOUND", (boolean)true) == 0) {
            return "\u5165\u7ad9\u7aef\u70b9\u7c7b\u578b";
        }
        return "\u51fa\u7ad9\u7aef\u70b9\u7c7b\u578b";
    }

    public String OutputPageIcon(boolean bSmall) {
        if (bSmall) {
            return "../sasrfex/images/default/icon_gear.png";
        }
        return "../sasrfex/images/default/icon_gear_b.png";
    }

    public String OutputIconView() {
        CallResult callResult;
        IEAIEndPointDataCtrl epDataCtrl;
        Vector<EAIEndPoint> epList = new Vector<EAIEndPoint>();
        String strDirection = this.getWebContext().GetParamValue("DIRECTION");
        if (StringHelper.Compare((String)strDirection, (String)"INBOUND", (boolean)true) == 0) {
            epDataCtrl = (IEAIEndPointDataCtrl)this.getDAModelStorage().FindDEDataCtrl("EAI0011", (ISRFDAWebContext)this.getWebContext());
            callResult = epDataCtrl.GetInboundEndPoints(epList);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 2, StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u5165\u7ad9\u7aef\u70b9\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return "";
            }
        } else {
            epDataCtrl = (IEAIEndPointDataCtrl)this.getDAModelStorage().FindDEDataCtrl("EAI0011", (ISRFDAWebContext)this.getWebContext());
            callResult = epDataCtrl.GetOutboundEndPoints(epList);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 2, StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u5165\u7ad9\u7aef\u70b9\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return "";
            }
        }
        StringBuilderEx strIconView = new StringBuilderEx();
        strIconView.Append("<table align=\"left\" width=\"100%%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >");
        strIconView.Append("<tr><td height=\"20\"></td></tr><tr>");
        String strIconViewTDScheme = "<td width=\"100\"><table align=\"center\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" ><tr><td align=\"center\" ><a href=\"#\"  class='gridlink' onclick=\"editview('%3$s')\" ><img border=\"0\" width=\"50\" src=\"%1$s\" alt=\"%2$s\"/></a></td></tr><tr><td align=\"center\" ><a href=\"#\"  class='gridlink'   onclick=\"editview('%3$s')\" ><span class=\"sx-normaltext-b\">%2$s</span></a></td></tr></table></td>";
        int i = 1;
        for (EAIEndPoint ep : epList) {
            String strIcon = ep.getEPICON();
            if (StringHelper.IsNullOrEmpty((String)strIcon)) {
                strIcon = "../sasrfex/images/default/icon_gear_b.png";
            }
            strIconView.Append(strIconViewTDScheme, (Object)strIcon, (Object)ep.getEAIENDPOINTNAME(), (Object)ep.getEPTYPE());
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

