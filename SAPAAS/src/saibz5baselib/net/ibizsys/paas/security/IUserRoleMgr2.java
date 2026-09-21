/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.security;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemUserRoleModel;
import net.ibizsys.paas.web.IWebContext;

public interface IUserRoleMgr2 {
    public void setEnableSysUserRole(boolean var1);

    public boolean isEnableSysUserRole();

    public String getDEOPPrivRoleCond(IService var1, String var2, IDEDataSetFetchContext var3) throws Exception;

    public boolean testDEOPPrivRoleAction(IWebContext var1, IDataEntityModel var2, IEntity var3, String var4) throws Exception;

    public boolean testSysUserRole(String var1) throws Exception;

    public void registerSysUserRole(ISystemUserRoleModel var1);

    public Iterator<ISystemUserRoleModel> getSysUserRoles();
}

