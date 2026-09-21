/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.BaseDBCallerHelper;

public class BaseDataMgr {
    protected BaseDBCallerHelper dbCallerHelper = null;
    protected String strLastErrorInfo = "";

    public BaseDataMgr(BaseDBCallerHelper dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
    }

    public String getLastErrorInfo() {
        return this.strLastErrorInfo;
    }
}

