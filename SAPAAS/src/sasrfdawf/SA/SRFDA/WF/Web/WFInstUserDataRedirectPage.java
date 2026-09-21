/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.IOException;
import java.util.TreeMap;

public class WFInstUserDataRedirectPage
extends SRFDAPageEx {
    public WFInstUserDataRedirectPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strUserDatas = this.getWebContext().GetParamValue("USERDATAS");
        if (StringHelper.IsNullOrEmpty((String)strUserDatas)) {
            this.OutputAlertMsg("\u4f20\u5165\u53c2\u6570\u65e0\u6548\uff0c\u6ca1\u6709\u4f20\u5165\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u76f8\u5173\u7528\u6237\u6570\u636e", true);
            return false;
        }
        String[] userdatas = strUserDatas.split("[;]");
        if (userdatas.length != 5) {
            this.OutputAlertMsg("\u4f20\u5165\u53c2\u6570\u65e0\u6548\uff0c\u6ca1\u6709\u4f20\u5165\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u76f8\u5173\u7528\u6237\u6570\u636e", true);
            return false;
        }
        IDEHelper iUserDEHelper = this.getDAModelStorage().FindDEHelper(userdatas[3]);
        if (iUserDEHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61", (Object)userdatas[4]));
            return false;
        }
        String strURL = "../srfpage/editview.jsp?";
        String strEditPageId = iUserDEHelper.GetEditPageId();
        if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
            Page editPage = this.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strEditPageId);
            if (editPage == null) {
                this.PageLog((Object)this, 1, "\u83b7\u53d6\u9875\u9762\u4fe1\u606f\u5931\u8d25");
                return false;
            }
            if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                strURL = editPage.GetTotalPagePath();
            }
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", iUserDEHelper.getId());
        daParams.put(iUserDEHelper.GetKeyDEFHelper().getName(), userdatas[0]);
        String strDAParams = URLHelper.GetQueryString(daParams);
        if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
            strURL = String.valueOf(strURL) + strDAParams;
            strURL = String.valueOf(strURL) + "&";
        }
        strURL = String.valueOf(strURL) + this.getWebContext().GetQueryStringWithoutDAParam(daParams);
        strURL = String.valueOf(strURL) + "&";
        try {
            this.getResponse().sendRedirect(strURL);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

