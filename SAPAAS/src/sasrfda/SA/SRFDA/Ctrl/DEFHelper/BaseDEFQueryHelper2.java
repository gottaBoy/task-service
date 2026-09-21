/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper2;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class BaseDEFQueryHelper2
implements IDEFQueryHelper2 {
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private IDEFHelper iDEFHelper = null;

    @Override
    public void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    @Override
    public void setDEFHelper(IDEFHelper iDEFHelper) {
        this.iDEFHelper = iDEFHelper;
    }

    @Override
    public IDEFHelper getDEFHelper() {
        return this.iDEFHelper;
    }
}

