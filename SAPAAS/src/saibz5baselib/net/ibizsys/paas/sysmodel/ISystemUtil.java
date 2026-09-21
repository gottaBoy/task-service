/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.sysmodel.ISystemModel;

public interface ISystemUtil {
    public void init(ISystemModel var1) throws Exception;

    public String getUtilType();

    public void setUtilParam(String var1, Object var2);

    public ISystemModel getSystemModel();
}

