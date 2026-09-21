/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Web.UIGear;

import SA.SRFDA.Ctrl.Data.UIGear;
import SA.SRFDA.Web.UIGear.IUIGear;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class BaseUIGear
implements IUIGear {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected UIGear uiGear = null;

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, UIGear uiGear) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.uiGear = uiGear;
        return this.OnInit();
    }

    protected CallResult OnInit() {
        return new CallResult();
    }

    @Override
    public UIGear getUIGear() {
        return this.uiGear;
    }
}

