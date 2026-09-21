/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.SubSystem;
import SA.SRFDA.Ctrl.IDASubSystemHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class DASubSystemHelper
extends BaseDAObjectHelper
implements IDASubSystemHelper {
    private SubSystem subSystem = null;
    private ISRFDAGlobalHelper iDAGlobalHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, SubSystem subSystem) throws Exception {
        this.subSystem = subSystem;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.subSystem.getSUBSYSTEMID());
        this.setName(this.subSystem.getSUBSYSTEMNAME());
        this.OnInit();
    }

    @Override
    public void InitGlobalSession() throws Exception {
    }

    @Override
    public void InitUserSession(ISRFDAWebContext iSRFDAWebContext) throws Exception {
    }
}

