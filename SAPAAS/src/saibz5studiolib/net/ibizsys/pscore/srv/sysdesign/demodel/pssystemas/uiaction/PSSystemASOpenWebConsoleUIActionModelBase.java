/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemas.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSystemASOpenWebConsoleUIActionModelBase
extends DEUIActionModelBase<PSSystemAS> {
    private static final Log log = LogFactory.getLog(PSSystemASOpenWebConsoleUIActionModelBase.class);

    public PSSystemASOpenWebConsoleUIActionModelBase() {
        this.setId("ADFF2D6B-B2F1-4877-8055-3DD68FF6807B");
        this.setName("OpenWebConsole");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("OPENWEBCONSOLE");
    }
}

