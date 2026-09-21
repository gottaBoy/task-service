/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.HiddenConfig;

public class FileDownloaderConfig
extends HiddenConfig {
    public static final String TAG_FILEDOWNLOADER = "SRFEXFILEDOWNLOADER";
    public static final String TAG_DOWNLOADPAGEPATH = "DOWNLOADPAGEPATH";
    protected String strDownloadPagePath = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DOWNLOADPAGEPATH, (boolean)true) == 0) {
            this.strDownloadPagePath = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDownloadPagePath() {
        return this.strDownloadPagePath;
    }

    public void setDownloadPagePath(String strDownloadPagePath) {
        this.strDownloadPagePath = strDownloadPagePath;
    }
}

