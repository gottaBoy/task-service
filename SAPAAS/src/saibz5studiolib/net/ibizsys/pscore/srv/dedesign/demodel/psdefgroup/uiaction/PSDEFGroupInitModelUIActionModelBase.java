/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefgroup.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFGroupInitModelUIActionModelBase
extends DEUIActionModelBase<PSDEFGroup> {
    private static final Log log = LogFactory.getLog(PSDEFGroupInitModelUIActionModelBase.class);

    public PSDEFGroupInitModelUIActionModelBase() {
        this.setId("F583F602-FFD4-4BA0-99AA-1B2C7250190D");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6a21\u578b\u5b8c\u6210\uff01");
    }
}

