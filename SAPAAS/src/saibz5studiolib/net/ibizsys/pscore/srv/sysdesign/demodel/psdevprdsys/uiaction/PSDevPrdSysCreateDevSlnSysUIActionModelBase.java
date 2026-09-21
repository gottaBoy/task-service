/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevprdsys.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevPrdSys;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevPrdSysCreateDevSlnSysUIActionModelBase
extends DEUIActionModelBase<PSDevPrdSys> {
    private static final Log log = LogFactory.getLog(PSDevPrdSysCreateDevSlnSysUIActionModelBase.class);

    public PSDevPrdSysCreateDevSlnSysUIActionModelBase() {
        this.setId("F1537EFF-6123-4CB7-8A17-2AABB90A2888");
        this.setName("CreateDevSlnSys");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CreateDevSlnSys");
        this.setSuccessMsg("\u6b63\u5728\u540e\u53f0\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf");
    }
}

