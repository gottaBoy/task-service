/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class UploadFilePage
extends BaseMainPage {
    protected boolean PreparePageEnv() {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        return super.PreparePageEnv();
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        jsonObject.put("filetype", (Object)this.OnGetFileType());
        jsonObject.put("filecount", this.OnGetFileCount());
        jsonObject.put("fileuploadurl", (Object)this.OnGetFileUploadUrl());
        return true;
    }

    protected String OnGetFileType() {
        return this.getWebContext().GetParamValue("FILETYPE");
    }

    protected int OnGetFileCount() {
        String strFileCount = this.getWebContext().GetParamValue("FIELCOUNT");
        if (StringHelper.IsNullOrEmpty((String)strFileCount)) {
            return 0;
        }
        return Integer.parseInt(strFileCount);
    }

    protected String OnGetFileUploadUrl() {
        this.getWebContext().SetParamValue("SRFPAGEMODEL", this.getPageModel());
        return "../srfpage/uploadfilemodel.jsp?" + this.getWebContext().GetQueryString();
    }

    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.UPLOADVIEW", "\u4e0a\u4f20\u6587\u4ef6\u89c6\u56fe");
    }
}

