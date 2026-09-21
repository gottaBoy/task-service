/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysServiceAPIRebuildDESARSUIActionModelBase
extends DEUIActionModelBase<PSSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIRebuildDESARSUIActionModelBase.class);

    public PSSysServiceAPIRebuildDESARSUIActionModelBase() {
        this.setId("8D54E671-8960-4F35-A52B-AB45756DA0C1");
        this.setName("RebuildDESARS");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("RebuildDESARS");
        this.setReloadData(true);
    }
}

