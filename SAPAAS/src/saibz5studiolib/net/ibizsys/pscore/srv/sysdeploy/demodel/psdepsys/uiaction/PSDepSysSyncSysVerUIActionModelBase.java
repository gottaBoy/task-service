/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsys.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSys;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDepSysSyncSysVerUIActionModelBase
extends DEUIActionModelBase<PSDepSys> {
    private static final Log log = LogFactory.getLog(PSDepSysSyncSysVerUIActionModelBase.class);

    public PSDepSysSyncSysVerUIActionModelBase() {
        this.setId("3D8C2C41-8CC2-4A78-8D43-471D6D0361E1");
        this.setName("SyncSysVer");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("SyncSysVer");
        this.setReloadData(true);
        this.setSuccessMsg("\u540c\u6b65\u7cfb\u7edf\u7248\u672c\u6210\u529f\uff01");
    }
}

