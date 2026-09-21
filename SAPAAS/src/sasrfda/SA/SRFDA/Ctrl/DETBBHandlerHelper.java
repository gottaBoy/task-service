/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DETBBHandler;
import SA.SRFDA.Ctrl.IDETBBHandlerHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class DETBBHandlerHelper
extends BaseDAObjectHelper
implements IDETBBHandlerHelper {
    protected DETBBHandler deTBBHandler = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DETBBHandler deTBBHandler) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.deTBBHandler = deTBBHandler;
        this.OnInit();
    }

    @Override
    public String getDEId() {
        return this.deTBBHandler.getDEID();
    }

    @Override
    public String getOldHandler() {
        return this.deTBBHandler.getDETBBHANDLERNAME();
    }

    @Override
    public String getNewHandler() {
        return this.deTBBHandler.getNEWHANDLER();
    }

    @Override
    public String getMemo() {
        return this.deTBBHandler.getMEMO();
    }
}

