/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.demodel.wfinstance.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFInstanceUserCancelUIActionModelBase
extends DEUIActionModelBase<WFInstance> {
    private static final Log log = LogFactory.getLog(WFInstanceUserCancelUIActionModelBase.class);

    public WFInstanceUserCancelUIActionModelBase() {
        this.setId("EBA9085F-461B-4223-BDAF-EEDD62E2E5BE");
        this.setName("UserCancel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("UserCancel");
        this.setReloadData(true);
        this.setSuccessMsg("\u6d41\u7a0b\u53d6\u6d88\u5b8c\u6210");
    }
}

