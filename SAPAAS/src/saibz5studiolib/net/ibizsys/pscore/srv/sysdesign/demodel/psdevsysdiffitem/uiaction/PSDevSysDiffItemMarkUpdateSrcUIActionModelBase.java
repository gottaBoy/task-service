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

public abstract class PSDevSysDiffItemMarkUpdateSrcUIActionModelBase
extends DEUIActionModelBase<PSDevSysDiffItem> {
    private static final Log log = LogFactory.getLog(PSDevSysDiffItemMarkUpdateSrcUIActionModelBase.class);

    public PSDevSysDiffItemMarkUpdateSrcUIActionModelBase() {
        this.setId("95FB74E6-4E1F-4975-87DA-C0C5EAFCFC62");
        this.setName("MarkUpdateSrc");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("MARKUPDATESRC");
        this.setReloadData(true);
    }
}

