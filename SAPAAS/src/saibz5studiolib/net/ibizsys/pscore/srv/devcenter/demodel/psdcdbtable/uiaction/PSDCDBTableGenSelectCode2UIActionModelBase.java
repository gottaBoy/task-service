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

public abstract class PSDCDBTableGenSelectCode2UIActionModelBase
extends DEUIActionModelBase<PSDCDBTable> {
    private static final Log log = LogFactory.getLog(PSDCDBTableGenSelectCode2UIActionModelBase.class);

    public PSDCDBTableGenSelectCode2UIActionModelBase() {
        this.setId("90C42CBB-2300-4585-85A4-55E8D43C72D8");
        this.setName("GenSelectCode2");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("GenSelectCode");
    }
}

