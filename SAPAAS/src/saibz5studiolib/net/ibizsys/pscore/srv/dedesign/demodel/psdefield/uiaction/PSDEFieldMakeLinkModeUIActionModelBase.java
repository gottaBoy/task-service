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

public abstract class PSDEFieldMakeLinkModeUIActionModelBase
extends DEUIActionModelBase<PSDEField> {
    private static final Log log = LogFactory.getLog(PSDEFieldMakeLinkModeUIActionModelBase.class);

    public PSDEFieldMakeLinkModeUIActionModelBase() {
        this.setId("A53D040E-F0C5-4EA6-9EDC-78254BB074C9");
        this.setName("MakeLinkMode");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("MAKELINKMODE");
        this.setReloadData(true);
    }
}

