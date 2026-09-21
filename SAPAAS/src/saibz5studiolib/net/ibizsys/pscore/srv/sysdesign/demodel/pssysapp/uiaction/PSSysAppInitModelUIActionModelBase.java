/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysapp.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysAppInitModelUIActionModelBase
extends DEUIActionModelBase<PSSysApp> {
    private static final Log log = LogFactory.getLog(PSSysAppInitModelUIActionModelBase.class);

    public PSSysAppInitModelUIActionModelBase() {
        this.setId("014BAA23-E04B-4319-B5AA-8AB7AF36FAE3");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u5e94\u7528\u5b8c\u6210\uff01");
    }
}

