/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.pswf.core.IWFProcRoleModel;

public interface IPSWFProcessRole
extends IPSModelObject,
IWFProcRoleModel {
    public static final String ROLETYPE_WFROLE = "WFROLE";
    public static final String ROLETYPE_LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR";
    public static final String ROLETYPE_LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR";
    public static final String ROLETYPE_LASTSTEPACTOR = "LASTSTEPACTOR";
    public static final String ROLETYPE_UDACTOR = "UDACTOR";
    public static final String ROLETYPE_CURACTOR = "CURACTOR";

    public String getWFProcessRoleType();

    public String getUDField();
}

