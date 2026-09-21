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

public abstract class PSDataEntityInitModelUIActionModelBase
extends DEUIActionModelBase<PSDataEntity> {
    private static final Log log = LogFactory.getLog(PSDataEntityInitModelUIActionModelBase.class);

    public PSDataEntityInitModelUIActionModelBase() {
        this.setId("4DCA00B6-CA29-4534-897F-FECE305E0178");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6a21\u578b\u5b8c\u6210\uff01");
    }
}

