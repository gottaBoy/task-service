/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFRoleUser;

public interface IWFRoleModel {
    public static final String WFROLETYPE_USERGROUP = "USERGROUP";
    public static final String WFROLETYPE_CUSTOM = "CUSTOM";
    public static final String WFROLETYPE_DEDATASET = "DEDATASET";
    public static final String User = "USER";
    public static final String UserGroup = "USERGROUP";
    public static final String SystemUser = "SYSTEMUSER";
    public static final String DynamicUser = "DYNAMICUSER";

    public String getId();

    public String getName();

    public ISystemModel getSystemModel();

    public String getWFRoleType();

    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext var1) throws Exception;

    public Object getRuntimeId();

    public void setRuntimeId(Object var1);
}

