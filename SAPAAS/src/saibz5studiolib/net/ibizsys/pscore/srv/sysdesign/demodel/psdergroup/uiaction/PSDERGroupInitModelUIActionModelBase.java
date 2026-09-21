/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdergroup.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDERGroup;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDERGroupInitModelUIActionModelBase
extends DEUIActionModelBase<PSDERGroup> {
    private static final Log log = LogFactory.getLog(PSDERGroupInitModelUIActionModelBase.class);

    public PSDERGroupInitModelUIActionModelBase() {
        this.setId("BBD4B5F1-424E-47AC-A8EB-497DDDF786F3");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6a21\u578b\u5b8c\u6210\uff01");
    }
}

