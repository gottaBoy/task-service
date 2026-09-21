/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel;

import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModelBase;
import net.ibizsys.psrt.srv.wf.demodel.wfreminder.WFReminderDEDataAccMgr;

public class WFReminderDEModel
extends WFReminderDEModelBase {
    private static final long serialVersionUID = -1L;

    @Override
    protected IDEDataAccMgr prepareDEDataAccMgr() throws Exception {
        WFReminderDEDataAccMgr iDEDataAccMgr = new WFReminderDEDataAccMgr();
        iDEDataAccMgr.init(this);
        return iDEDataAccMgr;
    }
}

