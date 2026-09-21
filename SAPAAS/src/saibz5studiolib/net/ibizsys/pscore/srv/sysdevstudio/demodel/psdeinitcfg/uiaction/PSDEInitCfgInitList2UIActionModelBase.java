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

public abstract class PSDEInitCfgInitList2UIActionModelBase
extends DEUIActionModelBase<PSDEInitCfg> {
    private static final Log log = LogFactory.getLog(PSDEInitCfgInitList2UIActionModelBase.class);

    public PSDEInitCfgInitList2UIActionModelBase() {
        this.setId("494011B3-C2EB-43FF-A5AF-7FF4FDAE8EEB");
        this.setName("InitList2");
        this.setActionTarget("NONE");
        this.setDEActionName("InitList2");
        this.setReloadData(true);
    }
}

