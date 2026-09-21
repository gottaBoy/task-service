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

public abstract class PSSystemDBCfgOpenJITDBToolUIActionModelBase
extends DEUIActionModelBase<PSSystemDBCfg> {
    private static final Log log = LogFactory.getLog(PSSystemDBCfgOpenJITDBToolUIActionModelBase.class);

    public PSSystemDBCfgOpenJITDBToolUIActionModelBase() {
        this.setId("FB61D3D5-8357-4139-B860-00DB92E55A5C");
        this.setName("OpenJITDBTool");
        this.setActionTarget("NONE");
        this.setDEActionName("OPENJITDBTOOL");
        this.setDataAccessAction("UPDATE");
    }
}

