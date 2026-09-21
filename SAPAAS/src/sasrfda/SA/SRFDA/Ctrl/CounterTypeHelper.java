/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.CounterType;
import SA.SRFDA.Ctrl.ICounterTypeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class CounterTypeHelper
extends BaseDAObjectHelper
implements ICounterTypeHelper {
    protected CounterType counterType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, CounterType counterType) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.counterType = counterType;
        this.setId(counterType.getCOUNTERTYPEID());
        this.setName(counterType.getCOUNTERTYPENAME());
        this.setVersion(counterType.getVERSION());
        this.OnInit();
    }

    @Override
    public String getCounterHelperObject() {
        return this.counterType.getTYPEHELPER();
    }
}

