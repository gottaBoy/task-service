/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefvaluerule.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFValueRulePreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSDEFValueRule> {
    private static final Log log = LogFactory.getLog(PSDEFValueRulePreviewSaveUIActionModelBase.class);

    public PSDEFValueRulePreviewSaveUIActionModelBase() {
        this.setId("D5734BF0-1027-4DBE-90B3-947F8C83D33E");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

