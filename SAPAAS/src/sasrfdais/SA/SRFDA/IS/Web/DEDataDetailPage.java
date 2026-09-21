/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.IS.Web;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class DEDataDetailPage
extends SRFDAPage {
    protected String strDocPath = "";
    protected String strDocPath2 = "";
    protected String strDocName = "";

    public DEDataDetailPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
    }

    protected String GetSearchFormActionHelper() {
        return BaseDASearchFormActionHelper.class.getName();
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strKey = this.getWebContext().GetParamValue("KEY");
        if (StringHelper.IsNullOrEmpty((String)strKey)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u4f20\u5165\u6709\u6548\u9875\u9762\u53c2\u6570"));
            return false;
        }
        String[] keys = strKey.split("[|]");
        if (keys.length < 3) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u53c2\u6570\u6709\u8bef"));
            return false;
        }
        IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(keys[1]);
        if (iDEHelper == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)keys[1]));
            return false;
        }
        String strURL = "../srfpage/editview.jsp?";
        String strEditPageId = iDEHelper.GetEditPageId();
        if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
            Page editPage = this.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strEditPageId);
            if (editPage == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u4fe1\u606f[%1$s]\u5931\u8d25", (Object)strEditPageId));
                return false;
            }
            strURL = editPage.GetTotalPagePath();
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", iDEHelper.getId());
        daParams.put(iDEHelper.GetKeyDEFHelper().getName(), keys[2]);
        String strDAParams = URLHelper.GetQueryString(daParams);
        if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
            strURL = String.valueOf(strURL) + strDAParams;
            strURL = String.valueOf(strURL) + "&";
        }
        try {
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            strURL = String.valueOf(strURL) + this.getWebContext().GetQueryStringWithout("SRFPAGEID");
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.getResponse().sendRedirect(strURL);
            } else {
                this.getResponse().getWriter().write(DEDataDetailPage.OutputRedirectModel((String)strURL));
            }
            return false;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
    }
}

