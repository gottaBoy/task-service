/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdeinitcfg.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEInitCfgInitListUIActionModelBase
extends DEUIActionModelBase<PSDEInitCfg> {
    private static final Log log = LogFactory.getLog(PSDEInitCfgInitListUIActionModelBase.class);

    public PSDEInitCfgInitListUIActionModelBase() {
        this.setId("0749DEF2-856F-44CE-8F0C-DC590F0585A1");
        this.setName("InitList");
        this.setActionTarget("NONE");
        this.setDEActionName("InitList");
        this.setReloadData(true);
    }
}

