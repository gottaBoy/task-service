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

public abstract class PSSysDBSchemeAddSyncDBSchemaModelTaskUIActionModelBase
extends DEUIActionModelBase<PSSysDBScheme> {
    private static final Log log = LogFactory.getLog(PSSysDBSchemeAddSyncDBSchemaModelTaskUIActionModelBase.class);

    public PSSysDBSchemeAddSyncDBSchemaModelTaskUIActionModelBase() {
        this.setId("C47D113F-F9AC-4DE5-B4EF-D45B2712996A");
        this.setName("AddSyncDBSchemaModelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_ADDSYNCDBSCHEMAMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540e\u53f0\u540c\u6b65\u6570\u636e\u5e93\u6a21\u578b\u4efb\u52a1");
    }
}

