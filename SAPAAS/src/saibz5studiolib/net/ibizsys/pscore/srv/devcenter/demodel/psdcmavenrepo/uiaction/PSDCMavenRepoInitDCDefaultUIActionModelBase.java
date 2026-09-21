/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmavenrepo.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMavenRepo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDCMavenRepoInitDCDefaultUIActionModelBase
extends DEUIActionModelBase<PSDCMavenRepo> {
    private static final Log log = LogFactory.getLog(PSDCMavenRepoInitDCDefaultUIActionModelBase.class);

    public PSDCMavenRepoInitDCDefaultUIActionModelBase() {
        this.setId("9C6E19E5-04B7-4A7B-8136-A1BBD0937F90");
        this.setName("InitDCDefault");
        this.setActionTarget("NONE");
        this.setDEActionName("InitDCDefault");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u4e2d\u5fc3\u9ed8\u8ba4\u4ed3\u5e93\u6210\u529f\uff01");
    }
}

