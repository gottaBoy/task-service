/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeserviceapi.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEServiceAPIRebuildDetailsUIActionModelBase
extends DEUIActionModelBase<PSDEServiceAPI> {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIRebuildDetailsUIActionModelBase.class);

    public PSDEServiceAPIRebuildDetailsUIActionModelBase() {
        this.setId("C8E03E33-08D7-430C-B224-6E98EE4DFD6B");
        this.setName("RebuildDetails");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("RebuildDetails");
        this.setReloadData(true);
        this.setSuccessMsg("\u91cd\u5efa\u63a5\u53e3\u6210\u5458\u5b8c\u6210\uff01");
    }
}

