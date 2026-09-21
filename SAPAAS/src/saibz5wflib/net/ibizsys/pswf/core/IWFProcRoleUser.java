/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFUser
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFProcRoleModel;
import net.ibizsys.pswf.core.IWFUser;

public interface IWFProcRoleUser
extends IWFUser {
    public static final String FIELD_IGNORESUBSTITUTE = "IGNORESUBSTITUTE";
    public static final String FIELD_ORIGINALWFUSERID = "ORIGINALWFUSERID";

    public String getId();

    public String getName();

    public IWFProcRoleModel getWFProcRoleModel();

    public String getWFRoleId();

    public boolean isIgnoreSubstitute();

    public String getOriginalWFUserId();
}

