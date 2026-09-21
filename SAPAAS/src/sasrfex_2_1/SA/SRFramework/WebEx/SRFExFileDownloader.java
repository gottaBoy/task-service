/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.UI.FileDownloaderConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.Writer;

public class SRFExFileDownloader
extends SRFExHidden {
    protected FileDownloaderConfig fileDownloaderConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new FileDownloaderConfig();
    }

    public FileDownloaderConfig getFileDownloaderConfig() {
        return this.fileDownloaderConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.fileDownloaderConfig = null;
        if (this.config != null && this.config instanceof FileDownloaderConfig) {
            this.fileDownloaderConfig = (FileDownloaderConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            super.OnRender(writer);
            String strDownloadFilePath = this.GetDownloadPagePath();
            strDownloadFilePath = URLHelper.AppendURLSeperator(strDownloadFilePath);
            writer.write(StringHelper.Format((String)"<a href='#' onclick=\"javascript:if(Ext.getDom('%2$s').value!=''){SRFUtility.download('%1$sFILEID='+Ext.getDom('%2$s').value);}\"><span class='sx-normaltext'>\u4e0b\u8f7d\u6587\u4ef6</span></a>", (Object)strDownloadFilePath, (Object)this.getUniqueID()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected String GetDownloadPagePath() {
        String strDownloadFilePath = this.fileDownloaderConfig.getDownloadPagePath();
        if (StringHelper.IsNullOrEmpty((String)strDownloadFilePath)) {
            strDownloadFilePath = this.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "DOWNLOADPAGEPATH", "");
        }
        return strDownloadFilePath;
    }
}

