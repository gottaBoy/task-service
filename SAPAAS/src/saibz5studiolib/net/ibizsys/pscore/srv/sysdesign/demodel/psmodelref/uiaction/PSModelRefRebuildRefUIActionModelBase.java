/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psmodelref.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModelRef;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSModelRefRebuildRefUIActionModelBase
extends DEUIActionModelBase<PSModelRef> {
    private static final Log log = LogFactory.getLog(PSModelRefRebuildRefUIActionModelBase.class);

    public PSModelRefRebuildRefUIActionModelBase() {
        this.setId("8CAF9B1C-BADA-4CB0-B132-1004638FA46D");
        this.setName("RebuildRef");
        this.setActionTarget("NONE");
        this.setDEActionName("RebuildRef");
        this.setReloadData(true);
    }
}

