/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepdata.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFStepDataRollbackUIActionModelBase
extends DEUIActionModelBase<WFStepData> {
    private static final Log log = LogFactory.getLog(WFStepDataRollbackUIActionModelBase.class);

    public WFStepDataRollbackUIActionModelBase() {
        this.setId("81FFA1AE-A6F5-49A0-AE3C-995930A6B115");
        this.setName("Rollback");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("Rollback");
        this.setReloadData(true);
        this.setDataAccessAction("NONE");
        this.setSuccessMsg("\u56de\u64a4\u64cd\u4f5c\u6210\u529f\uff01");
    }
}

