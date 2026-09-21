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

public abstract class PSDCDBTableGenInsertCodeUIActionModelBase
extends DEUIActionModelBase<PSDCDBTable> {
    private static final Log log = LogFactory.getLog(PSDCDBTableGenInsertCodeUIActionModelBase.class);

    public PSDCDBTableGenInsertCodeUIActionModelBase() {
        this.setId("6CBEDB25-6202-4A99-BFF6-5C2CC99A3087");
        this.setName("GenInsertCode");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("GenInsertCode");
    }
}

