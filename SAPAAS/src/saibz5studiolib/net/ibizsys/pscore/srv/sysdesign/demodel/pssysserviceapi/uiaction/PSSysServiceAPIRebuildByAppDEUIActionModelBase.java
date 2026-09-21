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

public abstract class PSSysServiceAPIRebuildByAppDEUIActionModelBase
extends DEUIActionModelBase<PSSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIRebuildByAppDEUIActionModelBase.class);

    public PSSysServiceAPIRebuildByAppDEUIActionModelBase() {
        this.setId("1912E8A5-71FB-4253-9172-C8449A26A05F");
        this.setName("RebuildByAppDE");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("RebuildByAppDE");
        this.setReloadData(true);
    }
}

