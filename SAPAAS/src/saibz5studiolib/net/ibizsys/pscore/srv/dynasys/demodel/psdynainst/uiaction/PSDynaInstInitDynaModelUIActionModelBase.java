/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dynasys.demodel.psdynainst.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaInstInitDynaModelUIActionModelBase
extends DEUIActionModelBase<PSDynaInst> {
    private static final Log log = LogFactory.getLog(PSDynaInstInitDynaModelUIActionModelBase.class);

    public PSDynaInstInitDynaModelUIActionModelBase() {
        this.setId("B9EB4F72-BEC5-450C-BFD4-779B7CC61E80");
        this.setName("InitDynaModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitDynaModel");
        this.setSuccessMsg("\u521d\u59cb\u5316\u52a8\u6001\u6a21\u578b\u5b8c\u6210\uff01");
    }
}

