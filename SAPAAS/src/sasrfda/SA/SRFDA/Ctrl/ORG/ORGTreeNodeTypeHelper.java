/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.ORG;

import SA.SRFDA.Ctrl.Data.ORGTreeNodeType;
import SA.SRFDA.Ctrl.ORG.IORGTreeNodeTypeHelper;
import SA.SRFDA.Ctrl.ORG.ORGObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class ORGTreeNodeTypeHelper
extends ORGObjectHelper
implements IORGTreeNodeTypeHelper {
    protected ORGTreeNodeType orgTreeNodeType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, ORGTreeNodeType orgTreeNodeType) throws Exception {
        this.orgTreeNodeType = orgTreeNodeType;
        this.setId(this.orgTreeNodeType.getORGTREENODETYPEID());
        this.setName(this.orgTreeNodeType.getORGTREENODETYPENAME());
        this.setVersion(this.orgTreeNodeType.getVERSION());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.OnInit();
    }
}

