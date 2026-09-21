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

public abstract class PSDCDBTableGenInsertCode2UIActionModelBase
extends DEUIActionModelBase<PSDCDBTable> {
    private static final Log log = LogFactory.getLog(PSDCDBTableGenInsertCode2UIActionModelBase.class);

    public PSDCDBTableGenInsertCode2UIActionModelBase() {
        this.setId("BD06FB82-9887-497E-B3A4-255C0364AA02");
        this.setName("GenInsertCode2");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("GenInsertCode");
    }
}

