/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.Data.BICubeSrc;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class BICubeSrcSelectViewPage
extends BaseMainPage {
    Vector<BICubeSrc> cubeSrcList = new Vector();

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + " select t1.* from t_SRFBICUBESRC t1 ";
        strSQL = String.valueOf(strSQL) + " LEFT JOIN T_SRFBICUBE t2 ON t1.BICUBEID = t2.BICUBEID ";
        strSQL = String.valueOf(strSQL) + " LEFT JOIN T_SRFDATAENTITY t3 ON t2.DEID = t3.DEID where t2.DEID='%1$s' ";
        strSQL = StringHelper.Format((String)strSQL, (Object)this.strPageDataEntityId);
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, this.cubeSrcList, (String)BICubeSrc.class.getName());
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u76f8\u5173\u5206\u6790\u6e90\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)this.getDEHelper().getId(), (Object)callResult.getErrorInfo()));
            this.OutputAlertMsg("\u67e5\u8be2\u5b9e\u4f53\u76f8\u5173\u5206\u6790\u6e90\u6570\u636e\u5931\u8d25\uff01", true);
            return false;
        }
        return true;
    }

    public String RenderIconView() {
        StringBuilderEx strIconView = new StringBuilderEx();
        strIconView.Append("<table align=\"left\" width=\"100%%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >");
        strIconView.Append("<tr><td height=\"20\" colspan='5'></td></tr><tr>");
        String strIconViewTDScheme = "<td width=\"100\"><table align=\"center\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" ><tr><td align=\"center\" ><a href=\"#\"  class='gridlink' onclick=\"endview({ret:'ok',id:'%3$s'})\" ><img border=\"0\" width=\"50\" src=\"%1$s\" alt=\"%2$s\"/></a></td></tr><tr><td align=\"center\" ><a href=\"#\"  class='gridlink'  onclick=\"endview({ret:'ok',id:'%3$s'})\" ><span class=\"sx-normaltext\">%2$s</span></a></td></tr></table></td>";
        int i = 0;
        for (BICubeSrc biCubeSrc : this.cubeSrcList) {
            String img = "../sasrfex/images/default/icon_bisrc32.png";
            String strLogicName = biCubeSrc.getBICUBESRCNAME();
            String strId = biCubeSrc.getBICUBESRCID();
            strIconView.Append(strIconViewTDScheme, (Object)img, (Object)strLogicName, (Object)strId);
            if (i % 5 == 0) {
                strIconView.Append("</tr><tr><td height=\"20\" colspan='5'></td></tr><tr>");
            }
            ++i;
        }
        while (i % 5 != 0) {
            strIconView.Append("<td width=\"100\" >&nbsp;</td>");
            ++i;
        }
        strIconView.Append("</tr>");
        strIconView.Append("</table>");
        return strIconView.toString();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
    }

    protected void OnInit() {
        super.OnInit();
    }
}

