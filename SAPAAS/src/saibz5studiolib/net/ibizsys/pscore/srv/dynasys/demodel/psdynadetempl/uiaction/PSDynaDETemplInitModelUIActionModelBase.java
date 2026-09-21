/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynadetempl.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDETempl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaDETemplInitModelUIActionModelBase
extends DEUIActionModelBase<PSDynaDETempl> {
    private static final Log log = LogFactory.getLog(PSDynaDETemplInitModelUIActionModelBase.class);

    public PSDynaDETemplInitModelUIActionModelBase() {
        this.setId("AB67359C-CD69-49FC-8D18-B4015270E3FA");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6a21\u578b\u5b8c\u6210\uff01");
    }
}

