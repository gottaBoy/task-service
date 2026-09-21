/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psder.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDERCreateDEOPPrivUIActionModelBase
extends DEUIActionModelBase<PSDER> {
    private static final Log log = LogFactory.getLog(PSDERCreateDEOPPrivUIActionModelBase.class);

    public PSDERCreateDEOPPrivUIActionModelBase() {
        this.setId("7E02FD1A-11AE-42D5-955E-7557F61BC2C6");
        this.setName("CreateDEOPPriv");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CreateDEOPPriv");
        this.setSuccessMsg("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u6620\u5c04\u6210\u529f\uff01");
    }
}

