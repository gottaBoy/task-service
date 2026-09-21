/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IModelBase3
 *  net.ibizsys.paas.sysmodel.IDynaSystemSetting
 *  net.ibizsys.paas.sysmodel.ISystemModel
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.sysmodel.IDynaSystemSetting;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface IDynaInst
extends IModelBase3 {
    public void init(ISystemModel var1, String var2) throws Exception;

    public ISystemModel getSystemModel();

    public IDynaSystemSetting getDynaSystemSetting();

    public IDynaInst getParentDynaInst();
}

