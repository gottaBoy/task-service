/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTTaskRes;
import SA.TM.Ctrl.ITMBTTaskResHelper;

public class TMBTTaskResHelper
extends BaseTMObject
implements ITMBTTaskResHelper {
    protected TMBTTaskRes tmBTTaskRes = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTTaskRes tmBTTaskRes) throws Exception {
        this.tmBTTaskRes = tmBTTaskRes;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(tmBTTaskRes.getTMBTTASKRESID());
        this.setName(tmBTTaskRes.getTMBTTASKRESNAME());
        this.OnInit();
    }

    public TMBTTaskRes getData() {
        return this.tmBTTaskRes;
    }

    public boolean isCustomDuration() {
        return !this.tmBTTaskRes.isDURATIONNull();
    }

    public int getDuration() {
        return this.tmBTTaskRes.getDURATION();
    }

    public String getResCatalogId() {
        return this.tmBTTaskRes.getTMRESCATALOGID();
    }
}

