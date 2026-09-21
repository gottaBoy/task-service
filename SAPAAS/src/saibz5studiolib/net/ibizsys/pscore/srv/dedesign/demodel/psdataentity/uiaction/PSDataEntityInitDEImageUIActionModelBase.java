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

public abstract class PSDataEntityInitDEImageUIActionModelBase
extends DEUIActionModelBase<PSDataEntity> {
    private static final Log log = LogFactory.getLog(PSDataEntityInitDEImageUIActionModelBase.class);

    public PSDataEntityInitDEImageUIActionModelBase() {
        this.setId("A6DB5C8C-6915-4986-AA05-E5404BE1E163");
        this.setName("InitDEImage");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitDEImage");
        this.setReloadData(true);
    }
}

