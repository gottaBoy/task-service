/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Web.WebConfig
 */
package SA.SRFramework.WebEx.Data;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.Web.WebConfig;
import SA.SRFramework.WebEx.SRFExWebContext;

public class WebDBCallerHelperEx
extends BaseDBCallerHelperEx {
    protected WebConfig curWebConfig = null;
    protected static ThreadLocal<SRFExWebContext> webContext = new ThreadLocal();

    public void setWebConfig(WebConfig value) {
        this.curWebConfig = value;
    }

    public SRFExWebContext getWebContext() {
        return webContext.get();
    }

    public void setWebContext(SRFExWebContext value) {
        webContext.set(value);
    }
}

