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

public abstract class WFInstanceRestartUIActionModelBase
extends DEUIActionModelBase<WFInstance> {
    private static final Log log = LogFactory.getLog(WFInstanceRestartUIActionModelBase.class);

    public WFInstanceRestartUIActionModelBase() {
        this.setId("4B9CAA8D-5BF7-4B24-8835-B1447EE62477");
        this.setName("Restart");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("Restart");
        this.setReloadData(true);
        this.setSuccessMsg("\u6d41\u7a0b\u91cd\u542f\u5b8c\u6210");
    }
}

