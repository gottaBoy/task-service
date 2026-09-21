/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTPlanTask;
import SA.TM.Ctrl.ITMBTTaskInstPlanHelper;
import java.sql.Timestamp;

public class TMBTTaskInstPlanHelper
extends BaseTMObject
implements ITMBTTaskInstPlanHelper {
    protected TMBTPlanTask tmBTPlanTask = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTPlanTask tmBTPlanTask) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.tmBTPlanTask = tmBTPlanTask;
        this.setId(tmBTPlanTask.getTMBTPLANTASKID());
        this.setName(tmBTPlanTask.getTMBTPLANTASKNAME());
        this.OnInit();
    }

    public Timestamp getBeginTime() {
        return this.tmBTPlanTask.getBEGINTIME();
    }

    public Timestamp getEndTime() {
        return this.tmBTPlanTask.getENDTIME();
    }

    public boolean isIgnoreArrange() {
        if (this.tmBTPlanTask.isIGNOREARRANGENull()) {
            return false;
        }
        return this.tmBTPlanTask.getIGNOREARRANGE();
    }
}

