/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevsysdiffitem.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevSysDiffItemExecuteSyncActionUIActionModelBase
extends DEUIActionModelBase<PSDevSysDiffItem> {
    private static final Log log = LogFactory.getLog(PSDevSysDiffItemExecuteSyncActionUIActionModelBase.class);

    public PSDevSysDiffItemExecuteSyncActionUIActionModelBase() {
        this.setId("3A8D39EA-7DD9-4E39-A6BB-32A662DC8F21");
        this.setName("ExecuteSyncAction");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_EXECUTESYNCACTION");
        this.setReloadData(true);
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540e\u53f0\u540c\u6b65\u4efb\u52a1");
    }
}

