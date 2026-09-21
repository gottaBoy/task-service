/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.ISystemUserRole;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.web.IWebContext;

public interface ISystemUserRoleModel
extends ISystemUserRole {
    public void init(ISystemModel var1) throws Exception;

    public ISystemModel getSystemModel();

    public void registerUniResTag(String var1);

    public boolean testUniResTag(String var1) throws Exception;

    public boolean testCurUser(IWebContext var1) throws Exception;
}

