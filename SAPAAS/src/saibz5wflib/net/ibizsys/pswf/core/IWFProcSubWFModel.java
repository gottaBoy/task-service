/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IWFProcSubWFModel {
    public void init(IWFEmbedWFProcessModelBase var1) throws Exception;

    public IWFEmbedWFProcessModelBase getWFEmbedWFProcessModelBase();

    public String getId();

    public String getName();

    public IWFModel getWFModel();

    public String getWFId();

    public String getDEName();

    public String getDEDSName();

    public boolean isSuspendDefault();

    public IWFVersionModel getWFVersionModel();

    public String getWFVerId();
}

