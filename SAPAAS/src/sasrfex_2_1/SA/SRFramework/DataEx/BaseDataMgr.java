/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;
import SA.SRFramework.WebEx.SRFExWebContext;

public class BaseDataMgr {
    protected BaseDBCallerHelper dbCallerHelper = null;
    protected String strLastErrorInfo = "";

    public BaseDataMgr(BaseDBCallerHelper dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
    }

    public BaseDBCallerHelper getDBCaller() {
        return this.dbCallerHelper;
    }

    public BaseDBCallerHelperEx getDBCallerEx() {
        if (this.dbCallerHelper != null && this.dbCallerHelper instanceof BaseDBCallerHelperEx) {
            return (BaseDBCallerHelperEx)this.dbCallerHelper;
        }
        return null;
    }

    public WebDBCallerHelperEx getWebDBCallerHelperEx() {
        if (this.dbCallerHelper != null && this.dbCallerHelper instanceof WebDBCallerHelperEx) {
            return (WebDBCallerHelperEx)this.dbCallerHelper;
        }
        return null;
    }

    public SRFExWebContext getWebContext() {
        WebDBCallerHelperEx webDBCallerHelperEx = this.getWebDBCallerHelperEx();
        if (webDBCallerHelperEx != null) {
            return webDBCallerHelperEx.getWebContext();
        }
        return null;
    }

    public String getLastErrorInfo() {
        return this.strLastErrorInfo;
    }
}

