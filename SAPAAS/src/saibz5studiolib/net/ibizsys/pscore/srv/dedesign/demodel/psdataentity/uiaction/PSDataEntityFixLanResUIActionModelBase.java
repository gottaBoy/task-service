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

public abstract class PSDataEntityFixLanResUIActionModelBase
extends DEUIActionModelBase<PSDataEntity> {
    private static final Log log = LogFactory.getLog(PSDataEntityFixLanResUIActionModelBase.class);

    public PSDataEntityFixLanResUIActionModelBase() {
        this.setId("4EA89C84-D525-4D3E-B65D-33EAABA8992E");
        this.setName("FixLanRes");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("FIXLANRES");
        this.setReloadData(true);
    }
}

