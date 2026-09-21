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

public abstract class PSDevSysDiffItemMarkUpdateNoneUIActionModelBase
extends DEUIActionModelBase<PSDevSysDiffItem> {
    private static final Log log = LogFactory.getLog(PSDevSysDiffItemMarkUpdateNoneUIActionModelBase.class);

    public PSDevSysDiffItemMarkUpdateNoneUIActionModelBase() {
        this.setId("386B49CD-4514-4024-8D30-C58963C14FAC");
        this.setName("MarkUpdateNone");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("MARKUPDATENONE");
        this.setReloadData(true);
    }
}

