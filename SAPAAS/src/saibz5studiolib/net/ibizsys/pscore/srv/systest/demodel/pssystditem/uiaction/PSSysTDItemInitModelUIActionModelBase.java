/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.systest.demodel.pssystditem.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.systest.entity.PSSysTDItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysTDItemInitModelUIActionModelBase
extends DEUIActionModelBase<PSSysTDItem> {
    private static final Log log = LogFactory.getLog(PSSysTDItemInitModelUIActionModelBase.class);

    public PSSysTDItemInitModelUIActionModelBase() {
        this.setId("05AB28C4-AF34-42A3-868A-3D52BF5B13F9");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6570\u636e\u5b8c\u6210\uff01");
    }
}

