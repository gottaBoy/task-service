/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartUpload
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartUpload;

public class ExportPage
extends SRFDAPage {
    public ExportPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setNoCache(false);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        String strFileName = this.webContext.GetParamValue("FILEID");
        if (StringHelper.IsNullOrEmpty((String)strFileName)) {
            return;
        }
        String strTempFilePath = StringHelper.Format((String)"%1$s%2$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strFileName);
        try {
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.downloadFile(strTempFilePath);
            this.pageContext.getOut().clear();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

