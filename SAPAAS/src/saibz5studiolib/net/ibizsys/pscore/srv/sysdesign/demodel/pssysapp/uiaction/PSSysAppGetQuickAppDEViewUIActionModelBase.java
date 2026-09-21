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

public abstract class PSSysAppGetQuickAppDEViewUIActionModelBase
extends DEUIActionModelBase<PSSysApp> {
    private static final Log log = LogFactory.getLog(PSSysAppGetQuickAppDEViewUIActionModelBase.class);

    public PSSysAppGetQuickAppDEViewUIActionModelBase() {
        this.setId("A4E5DE79-C9C6-4AA0-B1B5-737FB300EA02");
        this.setName("GetQuickAppDEView");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("GetQuickAppDEView");
    }
}

