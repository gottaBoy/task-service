/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.sysmodel.SystemUserRoleModelBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

public class CustomSystemUserRoleModel
extends SystemUserRoleModelBase {
    @Override
    public String getRoleType() {
        return "CUSTOM";
    }

    @Override
    public boolean testCurUser(IWebContext iWebContext) throws Exception {
        return WebContext.getUserRoleMgr2().testSysUserRole(this.getRoleTag());
    }
}

