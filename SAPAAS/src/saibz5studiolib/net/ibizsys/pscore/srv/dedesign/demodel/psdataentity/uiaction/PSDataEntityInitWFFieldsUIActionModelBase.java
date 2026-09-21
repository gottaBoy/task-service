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

public abstract class PSDataEntityInitWFFieldsUIActionModelBase
extends DEUIActionModelBase<PSDataEntity> {
    private static final Log log = LogFactory.getLog(PSDataEntityInitWFFieldsUIActionModelBase.class);

    public PSDataEntityInitWFFieldsUIActionModelBase() {
        this.setId("91463E78-DB5A-4D27-87CC-5A460AAF00FD");
        this.setName("InitWFFields");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitWFFields");
        this.setSuccessMsg("\u521d\u59cb\u5316\u5de5\u4f5c\u6d41\u5c5e\u6027\u5b8c\u6210\uff01");
    }
}

