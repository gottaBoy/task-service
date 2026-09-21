/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.config.demodel.pssfstylever.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSFStyleVerFixStyleVerUIActionModelBase
extends DEUIActionModelBase<PSSFStyleVer> {
    private static final Log log = LogFactory.getLog(PSSFStyleVerFixStyleVerUIActionModelBase.class);

    public PSSFStyleVerFixStyleVerUIActionModelBase() {
        this.setId("C086DA73-49D4-43FC-A0E3-73383F42D1C2");
        this.setName("FixStyleVer");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("FixStyleVer");
        this.setReloadData(true);
        this.setSuccessMsg("\u56fa\u5b9a\u6a21\u677f\u6210\u529f\uff01");
    }
}

