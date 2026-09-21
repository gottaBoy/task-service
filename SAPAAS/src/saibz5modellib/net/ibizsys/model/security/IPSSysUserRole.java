/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ISystemUserRole
 */
package net.ibizsys.model.security;

import java.util.Iterator;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.security.IPSSysUserRoleRes;
import net.ibizsys.paas.core.ISystemUserRole;

public interface IPSSysUserRole
extends IPSSystemObject,
ISystemUserRole,
IPSModelObject {
    public String getRoleType();

    public IPSDataEntity getPSDE();

    public IPSDEDataSet getPSDEDataSet();

    public Iterator<IPSSysUserRoleRes> getPSSysUserRoleReses();
}

