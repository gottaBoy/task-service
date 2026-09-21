/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdevuser.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevUserInitAliasUserUIActionModelBase
extends DEUIActionModelBase<PSDevUser> {
    private static final Log log = LogFactory.getLog(PSDevUserInitAliasUserUIActionModelBase.class);

    public PSDevUserInitAliasUserUIActionModelBase() {
        this.setId("070FA244-7D78-4E78-A1FC-528072990C5D");
        this.setName("InitAliasUser");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitAliasUser");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u522b\u540d\u7528\u6237\u6210\u529f\uff01");
    }
}

