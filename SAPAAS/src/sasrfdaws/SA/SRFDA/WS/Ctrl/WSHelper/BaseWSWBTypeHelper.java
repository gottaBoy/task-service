/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.WS.Ctrl.Data.WSWBType;
import SA.SRFDA.WS.Ctrl.IWSWBTypeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class BaseWSWBTypeHelper
implements IWSWBTypeHelper {
    ISRFDAGlobalHelper iDAGlobalHelper = null;
    WSWBType wsWBType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, WSWBType wsWBType) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.wsWBType = wsWBType;
        this.OnInit();
    }

    protected void OnInit() {
    }

    @Override
    public WSWBType getWSWBType() {
        return this.wsWBType;
    }
}

