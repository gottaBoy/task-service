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

public abstract class PSSysAppOpenQuickAppUIActionModelBase
extends DEUIActionModelBase<PSSysApp> {
    private static final Log log = LogFactory.getLog(PSSysAppOpenQuickAppUIActionModelBase.class);

    public PSSysAppOpenQuickAppUIActionModelBase() {
        this.setId("37A172F8-60C9-432E-88BE-180F39BD8EC7");
        this.setName("OpenQuickApp");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("OpenQuickApp");
    }
}

