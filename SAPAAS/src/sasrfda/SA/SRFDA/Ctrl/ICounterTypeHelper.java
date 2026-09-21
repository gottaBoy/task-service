/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.CounterType;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface ICounterTypeHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, CounterType var2) throws Exception;

    public String getCounterHelperObject();
}

