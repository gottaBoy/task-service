/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappstoryboard.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppStoryBoardAddSyncModelTaskUIActionModelBase
extends DEUIActionModelBase<PSAppStoryBoard> {
    private static final Log log = LogFactory.getLog(PSAppStoryBoardAddSyncModelTaskUIActionModelBase.class);

    public PSAppStoryBoardAddSyncModelTaskUIActionModelBase() {
        this.setId("1E442D04-C00A-4279-A5EC-2D348EFBB952");
        this.setName("AddSyncModelTask");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_ADDSYNCMODELTASK");
        this.setSuccessMsg("\u5df2\u6dfb\u52a0\u66f4\u65b0\u6545\u4e8b\u677f\u540e\u53f0\u4efb\u52a1\uff01");
    }
}

