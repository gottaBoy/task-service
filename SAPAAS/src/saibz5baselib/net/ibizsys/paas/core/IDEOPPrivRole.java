/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEOPPrivRole
extends IDataEntityObject {
    public static final String ROLETYPE_SYSROLE = "SYSROLE";
    public static final String ROLETYPE_DEROLE = "DEROLE";
    public static final String ROLETYPE_NONE = "NONE";

    public void init(IDataEntity var1) throws Exception;

    public String getDEOPPrivTag();

    public String getRoleType();

    public String getDEDataQueryId();

    public String getSysUserRoleId();

    public String getDEUserRoleId();
}

