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

public abstract class PSDCDBViewGenSelectCode2UIActionModelBase
extends DEUIActionModelBase<PSDCDBView> {
    private static final Log log = LogFactory.getLog(PSDCDBViewGenSelectCode2UIActionModelBase.class);

    public PSDCDBViewGenSelectCode2UIActionModelBase() {
        this.setId("9EEA3829-F042-4DC5-BCDF-F612A87FD164");
        this.setName("GenSelectCode2");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("GenSelectCode");
    }
}

