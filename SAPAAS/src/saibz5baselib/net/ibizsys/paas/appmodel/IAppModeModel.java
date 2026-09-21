/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.appmodel;

import net.ibizsys.paas.appmodel.IApplicationModel;

public interface IAppModeModel
extends IApplicationModel {
    public void init(IApplicationModel var1) throws Exception;

    public IApplicationModel getAppModel();

    public String getMode();
}

