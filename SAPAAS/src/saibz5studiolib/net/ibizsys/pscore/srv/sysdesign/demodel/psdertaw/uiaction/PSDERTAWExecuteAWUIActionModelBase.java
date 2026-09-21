/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdertaw.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERTAW;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDERTAWExecuteAWUIActionModelBase
extends DEUIActionModelBase<PSDERTAW> {
    private static final Log log = LogFactory.getLog(PSDERTAWExecuteAWUIActionModelBase.class);

    public PSDERTAWExecuteAWUIActionModelBase() {
        this.setId("1CCEA03F-5D9C-43FB-B8B6-11C1EF5A8168");
        this.setName("ExecuteAW");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("ExecuteAW");
    }
}

