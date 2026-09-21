/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysServiceAPIGenUniqueTagUIActionModelBase
extends DEUIActionModelBase<PSSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIGenUniqueTagUIActionModelBase.class);

    public PSSysServiceAPIGenUniqueTagUIActionModelBase() {
        this.setId("5DD96D5F-43A2-4AA4-831C-C1FE5D3A0B6E");
        this.setName("GenUniqueTag");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("GenUniqueTag");
        this.setReloadData(true);
        this.setSuccessMsg("\u5efa\u7acb\u552f\u4e00\u6807\u8bb0\u6210\u529f\uff01");
    }
}

