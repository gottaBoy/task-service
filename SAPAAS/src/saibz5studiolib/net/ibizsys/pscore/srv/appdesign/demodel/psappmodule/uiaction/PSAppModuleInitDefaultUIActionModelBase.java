/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappmodule.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppModuleInitDefaultUIActionModelBase
extends DEUIActionModelBase<PSAppModule> {
    private static final Log log = LogFactory.getLog(PSAppModuleInitDefaultUIActionModelBase.class);

    public PSAppModuleInitDefaultUIActionModelBase() {
        this.setId("DEC2B114-1232-4182-BC7B-CA46AC476593");
        this.setName("InitDefault");
        this.setActionTarget("NONE");
        this.setDEActionName("InitDefault");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u5e94\u7528\u6a21\u5757\u6210\u529f\uff01");
    }
}

