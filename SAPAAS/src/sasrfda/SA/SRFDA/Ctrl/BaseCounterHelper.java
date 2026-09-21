/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.CounterResult;
import SA.SRFDA.Ctrl.Data.Counter;
import SA.SRFDA.Ctrl.ICounterHelper;
import SA.SRFDA.Ctrl.IDAActionContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class BaseCounterHelper
extends BaseDAObjectHelper
implements ICounterHelper {
    protected Counter counter = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, Counter counter) throws Exception {
        this.counter = counter;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.counter.getCOUNTERID());
        this.setName(this.counter.getCOUNTERNAME());
        this.setVersion(this.counter.getVERSION());
        this.OnInit();
    }

    @Override
    public CounterResult Calc(IDAActionContext iDAActionContext) throws Exception {
        return this.OnCalc(iDAActionContext);
    }

    protected CounterResult OnCalc(IDAActionContext iDAActionContext) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

