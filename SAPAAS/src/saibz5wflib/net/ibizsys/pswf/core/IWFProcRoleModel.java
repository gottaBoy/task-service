/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFRoleModel
 *  net.ibizsys.pswf.core.IWFRoleUser
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.IWFRoleUser;

public interface IWFProcRoleModel {
    public static final String ROLETYPE_WFROLE = "WFROLE";
    public static final String ROLETYPE_LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR";
    public static final String ROLETYPE_LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR";
    public static final String ROLETYPE_LASTSTEPACTOR = "LASTSTEPACTOR";
    public static final String ROLETYPE_UDACTOR = "UDACTOR";
    public static final String ROLETYPE_CURACTOR = "CURACTOR";

    public String getId();

    public String getName();

    public void init(IWFInteractiveProcessModel var1) throws Exception;

    public IWFInteractiveProcessModel getWFInteractiveProcessModel();

    public String getWFProcRoleType();

    public String getWFRoleId();

    public IWFRoleModel getWFRoleModel();

    public String[] getUDFields();

    public Iterator<IWFRoleUser> getWFRoleUserModels(IWFActionContext var1) throws Exception;
}

