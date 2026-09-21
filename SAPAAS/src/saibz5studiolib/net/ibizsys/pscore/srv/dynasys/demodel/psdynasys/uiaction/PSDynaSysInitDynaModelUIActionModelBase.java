/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynasys.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaSysInitDynaModelUIActionModelBase
extends DEUIActionModelBase<PSDynaSys> {
    private static final Log log = LogFactory.getLog(PSDynaSysInitDynaModelUIActionModelBase.class);

    public PSDynaSysInitDynaModelUIActionModelBase() {
        this.setId("F2D6EE54-15AD-412D-A5E0-13CC191F5C41");
        this.setName("InitDynaModel");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("InitDynaModel");
    }
}

