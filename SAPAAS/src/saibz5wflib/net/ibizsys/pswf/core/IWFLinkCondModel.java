/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IModelBase
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.IModelBase;

public interface IWFLinkCondModel
extends IModelBase {
    public static final String CONDTYPE_GROUP = "GROUP";
    public static final String CONDTYPE_SINGLE = "SINGLE";
    public static final String CONDTYPE_CUSTOM = "CUSTOM";

    public String getPId();

    public String getCondType();
}

