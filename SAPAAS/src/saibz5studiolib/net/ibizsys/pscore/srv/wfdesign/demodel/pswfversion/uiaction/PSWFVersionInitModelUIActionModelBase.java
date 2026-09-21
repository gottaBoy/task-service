/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfversion.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSWFVersionInitModelUIActionModelBase
extends DEUIActionModelBase<PSWFVersion> {
    private static final Log log = LogFactory.getLog(PSWFVersionInitModelUIActionModelBase.class);

    public PSWFVersionInitModelUIActionModelBase() {
        this.setId("D64B0127-6675-4F9B-8EEF-29DA37046552");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6d41\u7a0b\u7248\u672c\u5b8c\u6210\uff01");
    }
}

