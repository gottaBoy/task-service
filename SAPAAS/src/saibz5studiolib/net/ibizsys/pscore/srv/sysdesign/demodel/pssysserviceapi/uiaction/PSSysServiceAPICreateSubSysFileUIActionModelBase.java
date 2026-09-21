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

public abstract class PSSysServiceAPICreateSubSysFileUIActionModelBase
extends DEUIActionModelBase<PSSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSysServiceAPICreateSubSysFileUIActionModelBase.class);

    public PSSysServiceAPICreateSubSysFileUIActionModelBase() {
        this.setId("3AA04821-D232-4F5B-BE3E-5082017E4DCD");
        this.setName("CreateSubSysFile");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("CreateSubSysFile");
    }
}

