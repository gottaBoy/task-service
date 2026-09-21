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

public abstract class PSSysUCMapAddActorsUIActionModelBase
extends DEUIActionModelBase<PSSysUCMap> {
    private static final Log log = LogFactory.getLog(PSSysUCMapAddActorsUIActionModelBase.class);

    public PSSysUCMapAddActorsUIActionModelBase() {
        this.setId("47A91E46-E63D-4A40-9CA4-3E8061A4C408");
        this.setName("AddActors");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("ADDACTORS");
    }
}

