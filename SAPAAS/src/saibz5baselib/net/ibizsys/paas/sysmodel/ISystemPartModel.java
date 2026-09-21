/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface ISystemPartModel
extends IModelBase3 {
    public ISystemModel getSystemModel();

    public void installRTDatas() throws Exception;
}

