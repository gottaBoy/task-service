/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.pstscmd.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTSCmd;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSTSCmdEndTaskUIActionModelBase
extends DEUIActionModelBase<PSTSCmd> {
    private static final Log log = LogFactory.getLog(PSTSCmdEndTaskUIActionModelBase.class);

    public PSTSCmdEndTaskUIActionModelBase() {
        this.setId("276F3E4F-18DE-42BF-9900-D1B89F326124");
        this.setName("EndTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("ENDTASK");
        this.setReloadData(true);
        this.setSuccessMsg("\u7ed3\u675f\u4efb\u52a1\u6210\u529f\uff01");
    }
}

