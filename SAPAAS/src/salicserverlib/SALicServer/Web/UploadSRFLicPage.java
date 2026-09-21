/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.SRFPage
 *  com.jspsmart.upload.SmartFile
 *  com.jspsmart.upload.SmartUpload
 */
package SALicServer.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.SRFPage;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;

public class UploadSRFLicPage
extends SRFPage {
    protected StringBuilderEx processInfo = new StringBuilderEx();
    private static String LICFILE = "/WEB-INF/srflic/srf.lic";

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.upload();
            int nCount = su.getFiles().getCount();
            if (nCount == 0) {
                return;
            }
            String strTempFilePath = StringHelper.Format((String)"%1$s", (Object)this.pageContext.getServletContext().getRealPath(LICFILE));
            SmartFile file = su.getFiles().getFile(0);
            file.saveAs(strTempFilePath);
            this.ValidSRFLicense(strTempFilePath);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean ValidSRFLicense(String strLic) {
        this.processInfo.Append("Checking this license's validitation..");
        return true;
    }

    public String getProcessInfo() {
        return this.processInfo.toString();
    }
}

