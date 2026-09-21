/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  javax.servlet.FilterConfig
 *  net.ibizsys.paas.web.WebConfig
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import javax.servlet.FilterConfig;

public class WebConfig
extends net.ibizsys.paas.web.WebConfig {
    private String strFilePath = null;
    private String strTempPath = null;
    private ISRFDAGlobalHelper iSRFDAGlobalHelper = null;

    public WebConfig(ISRFDAGlobalHelper iSRFDAGlobalHelper, FilterConfig config) {
        super(config);
        this.iSRFDAGlobalHelper = iSRFDAGlobalHelper;
        this.strFilePath = this.iSRFDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
        this.strTempPath = this.iSRFDAGlobalHelper.GetTempPath();
    }

    public WebConfig(FilterConfig config) {
        super(config);
    }

    public String getTempPath() {
        return this.strTempPath;
    }

    public String getFilePath() {
        return this.strFilePath;
    }
}

