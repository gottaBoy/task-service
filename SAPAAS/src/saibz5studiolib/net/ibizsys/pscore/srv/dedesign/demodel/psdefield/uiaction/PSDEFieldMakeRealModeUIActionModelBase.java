/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefield.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFieldMakeRealModeUIActionModelBase
extends DEUIActionModelBase<PSDEField> {
    private static final Log log = LogFactory.getLog(PSDEFieldMakeRealModeUIActionModelBase.class);

    public PSDEFieldMakeRealModeUIActionModelBase() {
        this.setId("E5E17999-584E-42F7-A169-821E7AEE55C0");
        this.setName("MakeRealMode");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("MAKEREALMODE");
        this.setReloadData(true);
    }
}

