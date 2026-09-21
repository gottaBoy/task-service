/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.ORG;

import SA.SRFDA.Ctrl.Data.ORGUnitType;
import SA.SRFDA.Ctrl.ORG.IORGUnitTypeHelper;
import SA.SRFDA.Ctrl.ORG.ORGObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class ORGUnitTypeHelper
extends ORGObjectHelper
implements IORGUnitTypeHelper {
    protected ORGUnitType orgUnitType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, ORGUnitType orgUnitType) throws Exception {
        this.orgUnitType = orgUnitType;
        this.setId(this.orgUnitType.getORGUNITTYPEID());
        this.setName(this.orgUnitType.getORGUNITTYPENAME());
        this.setVersion(this.orgUnitType.getVERSION());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.OnInit();
    }
}

