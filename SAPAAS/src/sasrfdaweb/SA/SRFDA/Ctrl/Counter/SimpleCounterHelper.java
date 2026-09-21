/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseCounterHelper
 *  SA.SRFDA.Ctrl.CounterResult
 *  SA.SRFDA.Ctrl.IDAActionContext
 */
package SA.SRFDA.Ctrl.Counter;

import SA.SRFDA.Ctrl.BaseCounterHelper;
import SA.SRFDA.Ctrl.CounterResult;
import SA.SRFDA.Ctrl.IDAActionContext;
import java.util.Random;

public class SimpleCounterHelper
extends BaseCounterHelper {
    protected CounterResult OnCalc(IDAActionContext iDAActionContext) throws Exception {
        CounterResult counterResult = new CounterResult();
        counterResult.setCount(new Random().nextInt(100));
        return counterResult;
    }
}

