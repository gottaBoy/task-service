/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysucmap.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysUCMapAddUserCasesUIActionModelBase
extends DEUIActionModelBase<PSSysUCMap> {
    private static final Log log = LogFactory.getLog(PSSysUCMapAddUserCasesUIActionModelBase.class);

    public PSSysUCMapAddUserCasesUIActionModelBase() {
        this.setId("EAF5C541-6C44-4FDE-B2F0-16BD762906C6");
        this.setName("AddUserCases");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("ADDUSERCASES");
    }
}

