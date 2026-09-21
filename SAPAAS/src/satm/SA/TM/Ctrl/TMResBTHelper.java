/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMResBT;
import SA.TM.Ctrl.ITMResBTHelper;

public class TMResBTHelper
extends BaseTMObject
implements ITMResBTHelper {
    protected TMResBT tmResBT = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMResBT tmResBT) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmResBT = tmResBT;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public boolean isEnableUserCreate() {
        return this.tmResBT.getENABLEUC();
    }

    public String getId() {
        return this.tmResBT.getTMRESBTID();
    }

    public String getName() {
        return this.tmResBT.getTMRESBTNAME();
    }

    public String getBKTheme() {
        return this.tmResBT.getBKTHEME();
    }
}

