/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.CounterResult;
import SA.SRFDA.Ctrl.Data.Counter;
import SA.SRFDA.Ctrl.IDAActionContext;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface ICounterHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, Counter var2) throws Exception;

    public CounterResult Calc(IDAActionContext var1) throws Exception;
}

