/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEFQueryHelper2
extends IDEFQueryHelper {
    public void setDAGlobalHelper(ISRFDAGlobalHelper var1);

    public void setDEFHelper(IDEFHelper var1);

    public IDEFHelper getDEFHelper();
}

