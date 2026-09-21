/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Data;

import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Web.WebConfig;

public class WebDBCallerHelper
extends BaseDBCallerHelper {
    protected WebConfig curWebConfig = null;

    public void setWebConfig(WebConfig value) {
        this.curWebConfig = value;
    }
}

