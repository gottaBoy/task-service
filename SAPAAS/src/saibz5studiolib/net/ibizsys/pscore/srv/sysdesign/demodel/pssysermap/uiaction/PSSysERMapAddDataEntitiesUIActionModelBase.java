/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysermap.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysERMapAddDataEntitiesUIActionModelBase
extends DEUIActionModelBase<PSSysERMap> {
    private static final Log log = LogFactory.getLog(PSSysERMapAddDataEntitiesUIActionModelBase.class);

    public PSSysERMapAddDataEntitiesUIActionModelBase() {
        this.setId("4BFE8C0F-50A6-4816-968F-A18FD2EA95D9");
        this.setName("AddDataEntities");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("ADDDATAENTITIES");
        this.setSuccessMsg("\u52a0\u5165\u5b9e\u4f53\u5b8c\u6210\uff01");
    }
}

