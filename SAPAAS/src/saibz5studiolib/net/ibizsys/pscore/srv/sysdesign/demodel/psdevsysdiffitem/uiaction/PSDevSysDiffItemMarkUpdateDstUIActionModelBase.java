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

public abstract class PSDevSysDiffItemMarkUpdateDstUIActionModelBase
extends DEUIActionModelBase<PSDevSysDiffItem> {
    private static final Log log = LogFactory.getLog(PSDevSysDiffItemMarkUpdateDstUIActionModelBase.class);

    public PSDevSysDiffItemMarkUpdateDstUIActionModelBase() {
        this.setId("CA654951-0269-4AA5-83A6-E2DAD5C0681A");
        this.setName("MarkUpdateDst");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("MARKUPDATEDST");
        this.setReloadData(true);
    }
}

