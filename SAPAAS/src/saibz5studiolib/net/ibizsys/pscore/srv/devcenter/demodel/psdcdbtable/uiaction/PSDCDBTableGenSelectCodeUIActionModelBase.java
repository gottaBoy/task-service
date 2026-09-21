/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcdbtable.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBTable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDCDBTableGenSelectCodeUIActionModelBase
extends DEUIActionModelBase<PSDCDBTable> {
    private static final Log log = LogFactory.getLog(PSDCDBTableGenSelectCodeUIActionModelBase.class);

    public PSDCDBTableGenSelectCodeUIActionModelBase() {
        this.setId("1F6B4C30-73B5-4EEF-AC4E-0E22A42D536C");
        this.setName("GenSelectCode");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("GenSelectCode");
    }
}

