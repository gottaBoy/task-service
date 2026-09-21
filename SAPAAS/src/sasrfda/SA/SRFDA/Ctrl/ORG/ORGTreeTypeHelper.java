/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.ORG;

import SA.SRFDA.Ctrl.Data.ORGTreeType;
import SA.SRFDA.Ctrl.ORG.IORGTreeTypeHelper;
import SA.SRFDA.Ctrl.ORG.ORGObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class ORGTreeTypeHelper
extends ORGObjectHelper
implements IORGTreeTypeHelper {
    protected ORGTreeType orgTreeType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, ORGTreeType orgTreeType) throws Exception {
        this.orgTreeType = orgTreeType;
        this.setId(this.orgTreeType.getORGTREETYPEID());
        this.setName(this.orgTreeType.getORGTREETYPENAME());
        this.setVersion(this.orgTreeType.getVERSION());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.OnInit();
    }
}

