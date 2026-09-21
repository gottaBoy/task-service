/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdegroup.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGroup;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEGroupInitModelUIActionModelBase
extends DEUIActionModelBase<PSDEGroup> {
    private static final Log log = LogFactory.getLog(PSDEGroupInitModelUIActionModelBase.class);

    public PSDEGroupInitModelUIActionModelBase() {
        this.setId("31718BE4-98C6-4C9D-9BF2-D6EF854FB859");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6a21\u578b\u5b8c\u6210\uff01");
    }
}

