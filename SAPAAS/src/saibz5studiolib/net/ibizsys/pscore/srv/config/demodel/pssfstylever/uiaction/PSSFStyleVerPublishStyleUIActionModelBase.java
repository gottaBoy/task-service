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

public abstract class PSSFStyleVerPublishStyleUIActionModelBase
extends DEUIActionModelBase<PSSFStyleVer> {
    private static final Log log = LogFactory.getLog(PSSFStyleVerPublishStyleUIActionModelBase.class);

    public PSSFStyleVerPublishStyleUIActionModelBase() {
        this.setId("F5DEC16B-FD68-43D5-8BC8-071EAC0CB915");
        this.setName("PublishStyle");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("PUBLISH");
        this.setReloadData(true);
        this.setSuccessMsg("\u53d1\u5e03\u6a21\u677f\u6210\u529f\uff01");
    }
}

