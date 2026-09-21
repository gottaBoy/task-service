/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdataentity.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDataEntityEnableMobUIActionModelBase
extends DEUIActionModelBase<PSDataEntity> {
    private static final Log log = LogFactory.getLog(PSDataEntityEnableMobUIActionModelBase.class);

    public PSDataEntityEnableMobUIActionModelBase() {
        this.setId("686B566B-89BD-4C9C-B5C9-AE4734C7BA05");
        this.setName("EnableMob");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("EnableMob");
        this.setReloadData(true);
    }
}

