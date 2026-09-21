/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemdbcfg.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSystemDBCfgOpenDBToolUIActionModelBase
extends DEUIActionModelBase<PSSystemDBCfg> {
    private static final Log log = LogFactory.getLog(PSSystemDBCfgOpenDBToolUIActionModelBase.class);

    public PSSystemDBCfgOpenDBToolUIActionModelBase() {
        this.setId("001D7B4F-DD64-4FD1-8EB0-02A132B990D8");
        this.setName("OpenDBTool");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("OPENDBTOOL");
    }
}

