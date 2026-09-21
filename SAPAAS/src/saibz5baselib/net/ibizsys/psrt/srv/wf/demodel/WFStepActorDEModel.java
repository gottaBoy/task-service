/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel;

import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModelBase;
import net.ibizsys.psrt.srv.wf.demodel.wfstepactor.WFStepActorDEDataAccMgr;

public class WFStepActorDEModel
extends WFStepActorDEModelBase {
    private static final long serialVersionUID = -1L;

    @Override
    protected IDEDataAccMgr prepareDEDataAccMgr() throws Exception {
        WFStepActorDEDataAccMgr iDEDataAccMgr = new WFStepActorDEDataAccMgr();
        iDEDataAccMgr.init(this);
        return iDEDataAccMgr;
    }
}

