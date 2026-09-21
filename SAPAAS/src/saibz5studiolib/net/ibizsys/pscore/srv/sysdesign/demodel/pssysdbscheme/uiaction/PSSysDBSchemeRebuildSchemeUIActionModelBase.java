/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdbscheme.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysDBSchemeRebuildSchemeUIActionModelBase
extends DEUIActionModelBase<PSSysDBScheme> {
    private static final Log log = LogFactory.getLog(PSSysDBSchemeRebuildSchemeUIActionModelBase.class);

    public PSSysDBSchemeRebuildSchemeUIActionModelBase() {
        this.setId("5D9EB758-2012-4701-8710-3AB89FAF0DFF");
        this.setName("RebuildScheme");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("RebuildScheme");
        this.setReloadData(true);
    }
}

