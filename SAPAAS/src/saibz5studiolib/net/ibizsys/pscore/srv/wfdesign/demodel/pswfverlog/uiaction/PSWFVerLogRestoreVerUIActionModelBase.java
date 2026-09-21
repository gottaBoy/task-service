/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.wfdesign.demodel.pswfverlog.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVerLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSWFVerLogRestoreVerUIActionModelBase
extends DEUIActionModelBase<PSWFVerLog> {
    private static final Log log = LogFactory.getLog(PSWFVerLogRestoreVerUIActionModelBase.class);

    public PSWFVerLogRestoreVerUIActionModelBase() {
        this.setId("81B1651D-72A9-4E61-8C0C-5ADF059FA333");
        this.setName("RestoreVer");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("RestoreVer");
        this.setSuccessMsg("\u6062\u590d\u6210\u529f\uff0c\u8bf7\u5173\u95ed\u7f16\u8f91\u89c6\u56fe\u91cd\u65b0\u6253\u5f00");
    }
}

