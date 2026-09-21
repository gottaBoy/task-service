/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 */
package SA.SRFramework.WebEx.Data;

import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.DataEx.BaseDataMgr;
import SA.SRFramework.WebEx.SRFExWebContext;

public class WebBaseDataMgr
extends BaseDataMgr {
    protected SRFExWebContext webContext = null;

    public WebBaseDataMgr(BaseDBCallerHelper dbCallerHelper) {
        super(dbCallerHelper);
    }

    public void setWebContext(SRFExWebContext webContext) {
        this.webContext = webContext;
    }

    @Override
    public SRFExWebContext getWebContext() {
        return this.webContext;
    }
}

