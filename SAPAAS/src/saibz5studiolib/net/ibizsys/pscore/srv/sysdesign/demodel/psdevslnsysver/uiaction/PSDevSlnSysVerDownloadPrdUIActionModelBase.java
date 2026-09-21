/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnsysver.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevSlnSysVerDownloadPrdUIActionModelBase
extends DEUIActionModelBase<PSDevSlnSysVer> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysVerDownloadPrdUIActionModelBase.class);

    public PSDevSlnSysVerDownloadPrdUIActionModelBase() {
        this.setId("D873F74C-FB9B-4A7D-9B7B-374F62E14243");
        this.setName("DownloadPrd");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("DownloadPrd");
    }
}

