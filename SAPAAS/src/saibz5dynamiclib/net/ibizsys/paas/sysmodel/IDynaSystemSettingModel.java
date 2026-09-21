/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.IDynaSystemSetting
 *  net.ibizsys.paas.sysmodel.ISystemModel
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.sysmodel.IDynaInst;
import net.ibizsys.paas.sysmodel.IDynaSystemSetting;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface IDynaSystemSettingModel
extends IDynaSystemSetting {
    public void init(ISystemModel var1) throws Exception;

    public ISystemModel getSystemModel();

    public void syncAllViews() throws Exception;

    public void syncAllWorkflows() throws Exception;

    public void syncView(String var1) throws Exception;

    public void syncWorkflow(String var1) throws Exception;

    public IDynaInst getDynaInst(String var1, boolean var2) throws Exception;
}

