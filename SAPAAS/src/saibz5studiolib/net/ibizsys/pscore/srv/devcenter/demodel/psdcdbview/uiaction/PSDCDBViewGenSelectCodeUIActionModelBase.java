/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbview.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDCDBViewGenSelectCodeUIActionModelBase
extends DEUIActionModelBase<PSDCDBView> {
    private static final Log log = LogFactory.getLog(PSDCDBViewGenSelectCodeUIActionModelBase.class);

    public PSDCDBViewGenSelectCodeUIActionModelBase() {
        this.setId("AADFCFFD-DBCB-4DD9-9E7F-3B1976A73EAA");
        this.setName("GenSelectCode");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("GenSelectCode");
    }
}

